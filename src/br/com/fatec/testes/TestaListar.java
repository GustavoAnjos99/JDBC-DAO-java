package br.com.fatec.testes;

import java.sql.SQLException;

import br.com.fatec.dao.UsuarioDAO;

public class TestaListar {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println(UsuarioDAO.listarBD());
	}

}
