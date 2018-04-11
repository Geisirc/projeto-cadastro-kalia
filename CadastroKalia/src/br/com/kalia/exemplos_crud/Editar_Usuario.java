package CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.ResultSet;

import util.DB_Connection;
import util.Usuario;

public class Editar_Usuario {

	
	//Método utilizado para modificar dados dos usuário. Esse método
	//recebe os dados já alterados e envia pro banco.
	public void edita_usuario(Usuario usuario){
		DB_Connection db_conection = new DB_Connection();
		Connection connection = db_conection.get_connection();
		PreparedStatement ps=null;
		try {
			//os dados contidos na query devem estar escritos igual como
			//os dados do banco
			String query="update usuario set nome=?,email=?,telefone=? where id_usuario=?";
			ps=connection.prepareStatement(query);		
			ps.setString(1, usuario.getNome());;
			ps.setString(2, usuario.getEmail());;
			ps.setString(3, usuario.getTelefone());;
			ps.setInt(4, usuario.getId_usuario());;
			ps.executeUpdate();
			
		} catch (Exception e) {
				System.out.println(e);
		}
	 
		
		
	}
}
