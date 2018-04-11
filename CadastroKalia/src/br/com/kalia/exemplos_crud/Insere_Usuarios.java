package CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.DB_Connection;
import util.Usuario;

public class Insere_Usuarios {
	//m�todo utilizado para inserir usuarios
	public void insere_usuarios(String nome, String telefone, String email) {
		DB_Connection db_conection = new DB_Connection();
		Connection connection = db_conection.get_connection();
		//Como essa query � de inser��o e o id do usuario � auto_increment
		//n�o � preciso enviar o id, somente os outros campos
		String query="insert into usuario(nome,email,telefone) values(?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1,nome);
			ps.setString(2,email);
			ps.setString(3,telefone);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e);
		}
		
	}
}
