package CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.ResultSet;
import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import util.DB_Connection;
import util.Usuario;
/*
 * Essa classe possui 2 métodos de listar usuarios
 * O primeiro restorna uma lista com todos os usuários cadastrados
 * O segundo retorna apenas o usuario selecionado de acordo com o Id dele 
 */
public class Lista_Usuario {
	public List<Usuario> lista_usuarios(){
		DB_Connection db_conection = new DB_Connection();
		Connection connection = db_conection.get_connection();
		
		List<Usuario> lista = new ArrayList<>();
		String query ="select*from usuario";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs =(ResultSet) ps.executeQuery();
			while(rs.next()) {
					Usuario usuario = new Usuario();
					usuario.setId_usuario(rs.getInt("id_usuario"));
					usuario.setNome(rs.getString("nome"));
					usuario.setEmail(rs.getString("email"));
					usuario.setTelefone(rs.getString("telefone"));
					
					lista.add(usuario);	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	
	public Usuario lista_usuarios_ID(int id){
		DB_Connection db_conection = new DB_Connection();
		Connection connection = db_conection.get_connection();
		Usuario usuario = new Usuario();
		String query = "select * from usuario where id_usuario=?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = (ResultSet) ps.executeQuery();
			
			while(rs.next()) {
			
				usuario.setId_usuario(rs.getInt("id_usuario"));
				usuario.setNome(rs.getString("nome"));
				usuario.setTelefone(rs.getString("telefone"));
				usuario.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return usuario;
		
	}
	
}
