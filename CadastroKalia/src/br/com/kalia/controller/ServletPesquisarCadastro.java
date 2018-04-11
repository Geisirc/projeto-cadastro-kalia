package br.com.kalia.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import br.com.kalia.model.Cadastro;
import br.com.kalia.services.CadastroServico;


@WebServlet("/PesquisarCadastro")
public class ServletPesquisarCadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ServletPesquisarCadastro() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pesquisa = request.getParameter("inputPesquisa");
		
		try {
			List cadastros = CadastroServico.buscarCadastro(pesquisa);
			if(cadastros != null){		
				request.setAttribute("listaPesquisa", cadastros);
			}else{
				request.setAttribute("mensagem", "undefined");
			}
		} catch (ClassNotFoundException | ParseException e) {
			e.printStackTrace();
		}
		
		
		request.getRequestDispatcher("pesquisa.jsp").forward(request, response);
	}

}
