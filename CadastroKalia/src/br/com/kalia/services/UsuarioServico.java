package br.com.kalia.services;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import br.com.kalia.dao.UsuarioDAO;
import br.com.kalia.model.Usuario;

public class UsuarioServico {

	public static boolean inserirUsuario(String login) throws InvalidKeyException, ClassNotFoundException, NoSuchAlgorithmException{
		Usuario us = new Usuario();
		UsuarioDAO usDao = new UsuarioDAO();
		us.setLogin(login);
		
		return usDao.inserir(us);
		
	}
}
