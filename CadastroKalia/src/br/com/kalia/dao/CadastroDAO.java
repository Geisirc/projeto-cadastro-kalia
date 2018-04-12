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
			

			" (objeto, tipo, requisitante, data_emprestimo, data_devolucao, email) " + 
			" Values (?, ?, ?, ?, ?, ?)") ;

			int count = 1;
			stmt.setString(count++, cad.getObjeto());
			stmt.setString(count++, cad.getTipo());
			stmt.setString(count++, cad.getRequisitante());
			stmt.setDate(count++, converteData(cad.getDataEmprestimo()));
			stmt.setDate(count++, converteData(cad.getDataDevolucao()));
			stmt.setString(count++, cad.getEmail());
					
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
                Date dataEmprestimo = (Date) formato.parse(res.getString("data_emprestimo"));
                Date dataDevolucao = (Date) formato.parse(res.getString("data_devolucao")); 
                
                               
                Cadastro pp1 = new Cadastro();
                pp1.getIdRequisitante(Integer.parseInt(res.getString("idRequisitante"));
                pp1.setObjeto(res.getString("objeto"));
                pp1.setTipo(res.getString("tipo"));

                pp1.setRequisitante(res.getString("requisitante"));
                pp1.setDate(dataEmprestimo);
		pp1.setDate(dataDevolucao);
                pp1.setEmail(res.getString("email"));                       
                               
                ll.add(pp1);
		return pp1;
            }
			
		if(count > 0){
			return ll;
		}

			st.close();	
		} catch (SQLException e) {
			System.out.println(e + "Erro ao buscar registros na pesquisa");			
		}finally{
			ConnectionFactory.fecharConexao();
			System.out.println("Fechando conexão da busca");	
		}
		
		return pp1;
	}
	

	/*
	Método utilizado para modificar dados dos usuário. Esse método
	recebe os dados já alterados e envia pro banco.
	*/
	public static Cadastro editaUsuario(Cadastro usuario) throws ClassNotFoundException{
		Connection conexao = ConnectionFactory.abrirConexao();
		PreparedStatement ps=null;
		try {
			//os dados contidos na query devem estar escritos igual como os dados do banco
			String query="UPDATE cadastro SET objeto=?,tipo=?,requisitante=?,data_emprestimo=?,data_devolucao=?,email=? WHERE idRequisitante=?";
			ps=conexao.prepareStatement(query);	
			
			int count = 1;
			ps.setString(count++, usuario.getObjeto());;
			ps.setString(count++, usuario.getTipo());;
			ps.setString(count++, usuario.getRequisitante());;
			
			ps.setDate(count++, converteData(cad.getDataEmprestimo()));
			ps.setDate(count++, converteData(cad.getDataDevolucao()));
			
			ps.setString(count++, usuario.getEmail());;
			ps.executeUpdate();
			
			System.out.println("Editado cadastro do usuário");
			
		} catch (Exception e) {
			System.out.println(e + "Erro ao editar cadastro do usuário");
		}
		return null;		
	}

	

	//Método utilizado para excluir usuarios
	public static Cadastro excluirUsuario(String id) throws ClassNotFoundException {
		
		int codUsuario = Integer.parseInt(id);
		Connection conexao = ConnectionFactory.abrirConexao();
		String query = "delete from usuario where id_usuario=?";
		try {
			PreparedStatement ps = conexao.prepareStatement(query);
			ps.setInt(1, cod_usuario);
			ps.executeUpdate();
			System.out.println("Excluindo cadastro do usuário" + codUsuario);			
		} catch (SQLException e) {
			System.out.println("Erro ao excluir cadastro do usuário" + e.printStackTrace();
		}finally{
			ConnectionFactory.fecharConexao();
			System.out.println("Fechando conexão de exclusão");
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
        	Date dataEmprestimo = (Date) formato.parse(res.getString("data_emprestimo"));
        	Date dataDevolucao = (Date) formato.parse(res.getString("data_devolucao")); 
        		
                pp1.setIdCadastro(Integer.parseInt(res.getString("idCadastro")));
                pp1.setObjeto(res.getString("objeto"));                
                pp1.setTipo(res.getString("tipo"));
                pp1.setRequisitante(res.getString("requisitante"));
                pp1.setDataEmprestimo(dataEmprestimo);
                pp1.setDataDevolucao(dataDevolucao);
                pp1.setEmail(res.getString("email"));
                
               }
			
		f(count > 0){
			return pp1;
		}

			st.close();	
		} catch (SQLException e) {
			System.out.println(e + "Erro na busca por id");
			
		}finally{
			ConnectionFactory.fecharConexao();
			System.out.println("Fechando conexão da busca por id");
		}
		
		return null;
	}
}
