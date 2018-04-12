package br.com.kalia.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import br.com.kalia.services.CadastroServico;

@WebServlet("/NovoCadastro")
public class ServletCadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletCadastro() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HashMap<String, String> mapper = new HashMap<String, String>();
		
		
		mapper.put("objeto", request.getParameter("inputCadObjeto"));
		mapper.put("tipo", request.getParameter("inputCadTipo"));
		mapper.put("requisitante", request.getParameter("inputCadRequisitante"));
		mapper.put("dataEmpretimo", request.getParameter("inputCadEmprestimo"));
		mapper.put("dataDevolucao", request.getParameter("inputCadDevolucao"));
		mapper.put("email", request.getParameter("inputCadEmail"));
						
		try {
			boolean resultado = CadastroServico.inserirCadastro(mapper);
			if(resultado){
				request.setAttribute("mensagem", "Cadastro inserido com sucesso!");
				request.getRequestDispatcher("listaresultado.jsp").forward(request, response);
				System.out.println("cadastro inserido com sucesso!");
			}else{
				request.setAttribute("mensagem", "Erro ao inserir cadastro!");
				request.getRequestDispatcher("cadastro.jsp").forward(request, response);
				System.out.println("erro ao inserir cadastro!");
			}	
		} catch (ClassNotFoundException | ParseException e) {
			
			e.printStackTrace();
			request.setAttribute("mensagem", "Erro ao inserir cadastro!");
			request.getRequestDispatcher("cadastro.jsp").forward(request, response);
			System.out.println("erro ao inserir cadastro!");
		}	
	}

}
