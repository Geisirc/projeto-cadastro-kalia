package br.com.kalia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.mysql.jdbc.Statement;

import br.com.kalia.jdbc.ConnectionFactory;
import br.com.kalia.model.Cadastro;

public class CadastroDAO {
	public boolean inserir(Cadastro cad) throws ClassNotFoundException {
		Connection conexao = ConnectionFactory.abrirConexao();
		boolean result = false;
		try {
			PreparedStatement stmt = conexao.prepareStatement("INSERT INTO cadastro "  +

			" (objeto, tipo, requisitante, data_emprestimo, data_devolucao, email) " + 
			" Values (?, ?, ?, ?, ?, ?)") ;
			

			" (objeto, tipo, requisitante, data_emprestimo, data_devolucao, contato) " + 
			" Values (?, ?, ?, ?, ?, ?)") ;

			int count = 1;
			stmt.setString(count++, cad.getObjeto());
			stmt.setString(count++, cad.getTipo());
			stmt.setString(count++, cad.getRequisitante());

			stmt.setString(count++, cad.getDataEmprestimo());
			stmt.setString(count++, cad.getDataDevolucao());
			stmt.setString(count++, cad.getRequisitante());
			stmt.setString(count++, cad.getEmail());
			
			//stmt.setDate(count++, converteData(cad.getDataEmprestimo()));
			//stmt.setDate(count++, converteData(cad.getDataDevolucao()));
			
			

			stmt.setDate(count++, converteData(cad.getDataEmprestimo()));
			stmt.setDate(count++, converteData(cad.getDataDevolucao()));
			stmt.setString(count++, cad.getContato());

		
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
	
	private java.sql.Date converteData(Date dataUtil) {
		return new java.sql.Date(dataUtil.getTime());
	}

	
	public static String dataForSQL(String Data){
    	return Data.substring(8, 10) + "-" + Data.substring(5, 7) + "-" + Data.substring(0, 4);
    }

	
	public List<Cadastro> buscar(String pesquisa) throws ClassNotFoundException, ParseException{
		
		Connection conexao = ConnectionFactory.abrirConexao();
		int count = 0;
		try {
			Statement st = (Statement) conexao.createStatement();
			
			List ll = new LinkedList();
			ResultSet res = st.executeQuery("SELECT * FROM cadastro WHERE objeto LIKE '%" + pesquisa + "%' OR "
					+ "tipo LIKE '%" + pesquisa + "%'");
			while (res.next()){
                count = res.getInt(1);
                
                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); 
                //Date dataEmprestimo = (Date) formato.parse(res.getString("data_emprestimo"));
                //Date dataDevolucao = (Date) formato.parse(res.getString("data_devolucao")); 
                
                               
                Cadastro pp1 = new Cadastro();
                //pp1.getIdRequisitante(Integer.parseInt(res.getString("idRequisitante"));
                pp1.setObjeto(res.getString("objeto"));
                pp1.setTipo(res.getString("tipo"));

                pp1.setRequisitante(res.getString("requisitante"));
                pp1.setDataEmprestimo(res.getString("data_emprestimo"));
                pp1.setDataDevolucao(res.getString("dataDevolucao"));
                pp1.setEmail(res.getString("email"));

                pp1.setRequisitante(res.getString("requisitante"));               
                pp1.setDataDevolucao(dataDevolucao);
                pp1.setContato(res.getString("contato"));

                
                ll.add(pp1);                
            }
			
			if(count > 0){
				return ll;
			}

			st.close();	
		} catch (SQLException e) {
			System.out.println(e);
		}finally{
			ConnectionFactory.fecharConexao();
		}
		
		return null;
	}
	

	//Método utilizado para modificar dados dos usuário. Esse método
	//recebe os dados já alterados e envia pro banco.
	public static Cadastro editaUsuario(Cadastro usuario) throws ClassNotFoundException{
		Connection conexao = ConnectionFactory.abrirConexao();
		PreparedStatement ps=null;
		try {
			//os dados contidos na query devem estar escritos igual como
			//os dados do banco
			String query="UPDATE cadastro SET objeto=?,tipo=?,requisitante=?,data_emprestimo=?,data_devolucao=?,email=? WHERE idRequisitante=?";
			ps=conexao.prepareStatement(query);	
			
			int count = 1;
			ps.setString(count++, usuario.getObjeto());;
			ps.setString(count++, usuario.getTipo());;
			ps.setString(count++, usuario.getRequisitante());;
			ps.setString(count++, usuario.getDataEmprestimo());;
			ps.setString(count++, usuario.getDataDevolucao());;
			ps.setString(count++, usuario.getEmail());;
			ps.executeUpdate();
			
		} catch (Exception e) {
				System.out.println(e);
		}
		return usuario;		
	}

	

	//Método utilizado para excluir usuarios
	public static Cadastro excluirUsuario(String id) throws ClassNotFoundException {
		
		int cod_usuario = Integer.parseInt(id);
		Connection conexao = ConnectionFactory.abrirConexao();
		String query = "delete from usuario where id_usuario=?";
		try {
			PreparedStatement ps = conexao.prepareStatement(query);
			ps.setInt(1, cod_usuario);
			ps.executeUpdate();
						
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectionFactory.fecharConexao();
		}
		return null;
		
	}
	
	
	public static Cadastro buscarPorId(int id) throws ClassNotFoundException, ParseException{
		Connection conexao = ConnectionFactory.abrirConexao();
		int count = 0;
		try {
			Statement st = (Statement) conexao.createStatement();
			Cadastro pp1 = new Cadastro();
			
			ResultSet res = st.executeQuery("SELECT * FROM cadastro WHERE idCadastro = '" + id + "'");
			while (res.next()){
                count = res.getInt(1);  
                
                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); 
        		//Date dataEmprestimo = (Date) formato.parse(res.getString("data_emprestimo"));
        		//Date dataDevolucao = (Date) formato.parse(res.getString("data_devolucao")); 
        		
                //pp1.setIdCadastro(Integer.parseInt(res.getString("idCadastro")));
                pp1.setObjeto(res.getString("objeto"));                
                pp1.setTipo(res.getString("tipo"));
                pp1.setRequisitante(res.getString("requisitante"));
                pp1.setDataEmprestimo(res.getString("data_emprestimo"));
                pp1.setDataDevolucao(res.getString("data_devolucao"));
                pp1.setEmail(res.getString("email"));
                
            }
			
			if(count > 0){
				return pp1;
			}

			st.close();	
		} catch (SQLException e) {
			System.out.println(e);
		}finally{
			ConnectionFactory.fecharConexao();
		}
		
		return null;
	}
}
