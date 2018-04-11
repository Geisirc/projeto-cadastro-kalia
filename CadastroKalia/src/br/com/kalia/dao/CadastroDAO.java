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
			" (objeto, tipo, requisitante, data_devolucao, contato) " + 
			" Values (?, ?, ?, ?, ?)") ;
			stmt.setString(1, cad.getObjeto());
			stmt.setString(6, cad.getTipo());
			stmt.setString(7, cad.getRequisitante());
			stmt.setString(8, cad.getContato());
			stmt.setDate(2, new java.sql.Date(cad.getDataDevolucao().getTime()));
		
			if(stmt.executeUpdate() > 0){
				result = true;
			}

			stmt.close();	
		} catch (SQLException e) {
			System.out.println(e);
			result = false;
		}			
		ConnectionFactory.FecharConexao();
		
		return result;
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
                Date dataDevolucao = (Date) formato.parse(res.getString("data_devolucao")); 
                
                System.out.println(dataDevolucao);
               
                Cadastro pp1 = new Cadastro();
                pp1.setIdCadastro(Integer.parseInt(res.getString("idCadastro")));
                pp1.setObjeto(res.getString("objeto"));
                pp1.setTipo(res.getString("tipo"));
                pp1.setRequisitante(res.getString("requisitante"));               
                //pp1.setDataDevolucao(res.getDate(dataDevolucao));
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
			ConnectionFactory.FecharConexao();
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
        		Date dataDevolucao = (Date) formato.parse(res.getString("data_devolucao")); 
        		
                pp1.setIdCadastro(Integer.parseInt(res.getString("idCadastro")));
                pp1.setObjeto(res.getString("objeto"));                
                pp1.setTipo(res.getString("tipo"));
                pp1.setRequisitante(res.getString("requisitante"));
                pp1.setDataDevolucao(dataDevolucao);
                pp1.setContato(res.getString("contato"));
                
            }
			
			if(count > 0){
				return pp1;
			}

			st.close();	
		} catch (SQLException e) {
			System.out.println(e);
		}finally{
			ConnectionFactory.FecharConexao();
		}
		
		return null;
	}
}
