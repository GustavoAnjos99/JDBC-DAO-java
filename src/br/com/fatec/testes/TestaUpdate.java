package br.com.fatec.testes;

import java.sql.SQLException;

import br.com.fatec.dao.UsuarioDAO;
import br.com.fatec.model.Usuario;

public class TestaUpdate {

	public static void main(String[] args) throws SQLException {
		UsuarioDAO.update(new Usuario(2, "GustavoANJOS", "gustavo160@email.com", "2805"));
	}

}
