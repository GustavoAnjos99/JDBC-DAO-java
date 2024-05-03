package br.com.fatec.testes;

import java.sql.SQLException;

import br.com.fatec.dao.UsuarioDAO;
import br.com.fatec.model.Usuario;

public class TestaInsertBD {

	public static void main(String[] args) throws SQLException {
		UsuarioDAO.insere(new Usuario("Gustavo dos anjos", "gustavo@email.com", "321"));
		UsuarioDAO.insere(new Usuario("Ronaldo Fenomeno", "r9@email.com", "Senha"));
		UsuarioDAO.insere(new Usuario("Aubameyang", "auba@email.com", "1234"));
		UsuarioDAO.insere(new Usuario("Renato augusto", "ra9@email.com", "0099"));
		UsuarioDAO.insere(new Usuario("Cassio Ramos", "cassio@email.com", "abcdefg1"));
	}

}
