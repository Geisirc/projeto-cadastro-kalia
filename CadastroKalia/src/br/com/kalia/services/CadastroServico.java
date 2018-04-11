package br.com.kalia.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import br.com.kalia.dao.CadastroDAO;
import br.com.kalia.model.Cadastro;

public class CadastroServico {

	public static boolean inserirCadastro(HashMap<String, String> mapper) throws ClassNotFoundException, ParseException{
		CadastroDAO caDao = new CadastroDAO();
		Cadastro ca = new Cadastro();
		
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); 
		Date dataDevolucao = (Date) formato.parse(mapper.get("data_devolucao")); 
		
		ca.setObjeto(mapper.get("objeto"));
		ca.setTipo(mapper.get("tipo"));
		ca.setRequisitante(mapper.get("requisitante"));
		ca.setContato(mapper.get("contato"));
		ca.setDataDevolucao(dataDevolucao);
		
		
				
		return caDao.inserir(ca);
	}
	
	public static List<Cadastro> buscarCadastro(String pesquisa) throws ClassNotFoundException, ParseException{
		CadastroDAO caDAO = new CadastroDAO();
		List caRes = caDAO.buscar(pesquisa);
		
		if(caRes != null){
			return caRes;
		}
		
		return null;
	}
}
