package controller.servlets;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.SessionUtils;
import model.Contato;
import model.dao.ContatoDAO;


@WebServlet("/novo-contato")
public class NovoContato extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		SessionUtils.verifySession(request, response,true);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		SessionUtils.verifySession(request, response, false);
	
		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		String telefone = request.getParameter("tel");
		String nascimento_str = request.getParameter("nascimento");
		String endereco = request.getParameter("endereco");
		String email = request.getParameter("email");
		
		String[] params = new String[] {nome,sobrenome,telefone,nascimento_str,endereco,email};
		
		String responseBodyStr = "";
		Date nascimento = SessionUtils.parseDate(nascimento_str);
		
		if(SessionUtils.verifyParams(params)) {
			
			responseBodyStr = new ContatoDAO().inserirContato(new Contato(-1, nome, sobrenome, telefone, 
														nascimento, endereco, email))?
				"1"
			:
				"Erro na inserção... consulte admin!";
			;
			
			
		}else {
			responseBodyStr = "Informe todos os campos!";
		}
		
		response.getWriter().write(responseBodyStr);
				
	}

}
