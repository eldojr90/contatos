package controller.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.SessionUtils;
import model.Contato;
import model.dao.ContatoDAO;


@WebServlet("/home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		SessionUtils.verifySession(request, response,true);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		SessionUtils.verifySession(request, response, false);
		
		List<Contato> contatos = new ContatoDAO().todosContatos();
		
		String name = SessionUtils.getUser(request).getNome();
		String dataContacts = "";
		
		for(Contato contato:contatos) {
			
			
			dataContacts += "<tr>" + 
									"<td>"+contato.getNome()+"</td>" + 
									"<td>"+contato.getSobrenome()+"</td>" + 
									"<td>"+contato.getTelefone()+"</td>" + 
									"<td>"+contato.getIdade()+"</td>" +  
									"<td>"+contato.getEndereco()+"</td>" + 
									"<td>"+contato.getEmail()+"</td>" + 
									"<td>" + 
										"<button id='"+contato.getId()+":"+contato.getNome()+"' class='excluir-contato'>Excluir</button>" + 
									"</td>" + 
								"</tr>";
		}
		
		String responseBodyStr = "{\"nome\":\""+name+"\",\"contatos\":\""+dataContacts+"\"}";
		
		response.getWriter().write(responseBodyStr);
		
	}

}
