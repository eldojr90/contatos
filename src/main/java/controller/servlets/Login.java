package controller.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.SessionUtils;
import model.Usuario;
import model.dao.UsuarioDAO;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		SessionUtils.verifySession(request, response,true);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
		String name = request.getParameter("nome");
		String password = request.getParameter("senha");
		
		if(SessionUtils.verifyParams(new String[] {
												name,
												password})) {
			
			Usuario usuarioValidado = new UsuarioDAO().findByNameAndPassword(name, password);
			int retorno = 0;
			
			
			if(usuarioValidado != null) {
				request.getSession().setAttribute("idUsuario", usuarioValidado.getId());
				retorno = 1;
			}
			
			response.getWriter().write(retorno+"");
			
			
		}else {
			SessionUtils.verifySession(request, response,true);
		}
		
		
	}

}
