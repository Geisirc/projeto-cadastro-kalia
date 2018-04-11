package CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.ResultSet;

import util.DB_Connection;
import util.Usuario;

public class Excluir_Usuario {
	//Método utilizado para excluir usuarios
	public void excluir_usuario(String id) {
		int cod_usuario = Integer.parseInt(id);
		DB_Connection db_conection = new DB_Connection();
		Connection connection = db_conection.get_connection();
		String query = "delete from usuario where id_usuario=?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, cod_usuario);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
