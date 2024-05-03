package br.com.fatec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fatec.factory.ConnectionFactory;
import br.com.fatec.model.Usuario;

public class UsuarioDAO {
	public static void insere(Usuario user) throws SQLException{
        String sql= "INSERT INTO usuarios(nome,login,senha) VALUES (?,?,?)";
        Connection conn=null;
        PreparedStatement pstm=null;
        try{
            //criar uma conexão com o BD
            conn= ConnectionFactory.createConnection();
            
            //Preparando a query
            pstm= (PreparedStatement) conn.prepareStatement(sql);
            
           // indicar as substituições na query- nome, login e senha do usuário
            pstm.setString(1,user.getNome());
            pstm.setString(2, user.getLogin());
            pstm.setString(3,user.getSenha());
            
            //Executando a query
             pstm.execute();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(pstm!= null) pstm.close();
            if(conn!=null) conn.close();
        }
	}
	
	public static void removeById(int id) throws SQLException {
		String sql = "DELETE FROM usuarios WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnection();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setInt(1,id);
			pstm.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
            if(pstm!= null) pstm.close();
            if(conn!=null) conn.close();
		}
	}
	
	public static void update(Usuario usuario) throws SQLException {
		String sql = "UPDATE usuarios SET nome = ?, login = ?, senha = ?" + "WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnection();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, usuario.getNome());
			pstm.setString(2, usuario.getLogin());
			pstm.setString(3, usuario.getSenha());
			
			pstm.setLong(4, usuario.getId());
			
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
            if(pstm!= null) pstm.close();
            if(conn!=null) conn.close();
		}
	}
	
	public static ArrayList<Usuario> listarBD() throws SQLException{
		String sql = "SELECT * FROM usuarios";
		
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnection();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				Usuario usuario = new Usuario();
				
				usuario.setId(rset.getLong("id"));
				usuario.setNome(rset.getString("nome"));
				usuario.setLogin(rset.getString("login"));
				usuario.setSenha(rset.getString("senha"));
				
				usuarios.add(usuario);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try{
				if(rset != null){
					rset.close();
				}
				if(pstm != null){
					pstm.close();
				}
				if(conn != null){
					conn.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}		 
			return usuarios;
		}
	
   
}