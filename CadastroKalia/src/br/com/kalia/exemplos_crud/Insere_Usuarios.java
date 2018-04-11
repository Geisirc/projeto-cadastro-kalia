package CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.DB_Connection;
import util.Usuario;

public class Insere_Usuarios {
	//método utilizado para inserir usuarios
	public void insere_usuarios(String nome, String telefone, String email) {
		DB_Connection db_conection = new DB_Connection();
		Connection connection = db_conection.get_connection();
		//Como essa query é de inserção e o id do usuario é auto_increment
		//não é preciso enviar o id, somente os outros campos
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
