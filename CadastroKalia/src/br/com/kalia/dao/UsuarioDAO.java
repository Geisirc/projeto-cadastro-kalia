package br.com.kalia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import br.com.kalia.jdbc.ConnectionFactory;
import br.com.kalia.model.Usuario;

public class UsuarioDAO {
	
	public boolean inserir(Usuario us) throws ClassNotFoundException{
			Connection conexao = ConnectionFactory.abrirConexao();
			boolean result = false;
			try {
				PreparedStatement stmt = conexao.prepareStatement("INSERT INTO usuario "  +
				" (login) " + 
				" Values (?)") ;
				stmt.setString(1, us.getLogin());
				
				if(stmt.executeUpdate() > 0){
					result = true;
				}

				stmt.close();	
			} catch (SQLException e) {
				System.out.println(e);
				result = false;
			}			
			ConnectionFactory.fecharConexao();
			
			return result;
	}
}
