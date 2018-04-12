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
//import br.com.kalia.model.Cadastro;

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
			System.out.println(e + "Erro ao inserir registros na pesquisa");	
			result = false;
		}finally{
			ConnectionFactory.fecharConexao();
			System.out.println("Fechando conexão de inserção de dados");	
		}
		
		return result;
	}
	
	private java.sql.Date converteData(Date dataUtil) {
		return new java.sql.Date(dataUtil.getTime());
	}

	
}
