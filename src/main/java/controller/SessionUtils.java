package controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;
import model.dao.UsuarioDAO;

public class SessionUtils {
	
	public static void verifySession(HttpServletRequest request, HttpServletResponse response, boolean redirect) 
			throws ServletException, IOException{
		if(redirect) {
			redirectBySession(request, response);
		}else {
			redirectBySessionToLogin(request, response);
		}
	}
	
	public static void redirectBySession(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		String page = "login.jsp";
		
		if(SessionUtils.verifyUserOnSession(request)) {
			page = "home.jsp";
		}
		
		request.getRequestDispatcher(page).forward(request, response);
	}
	
	public static void redirectBySessionToLogin(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		if(!SessionUtils.verifyUserOnSession(request)) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
	
	public static boolean verifyUserOnSession(HttpServletRequest request) 
			throws ServletException, IOException{
		return (request.getSession().getAttribute("idUsuario") != null);
	}
	
	public static void logout(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{ 
		
		String responseBodyStr = "0";
		
		if(SessionUtils.verifyUserOnSession(request)) {
			
			HttpSession session = request.getSession(); 
			session.invalidate();
			
			responseBodyStr = "1";
			
		}
		
		response.getWriter().write(responseBodyStr);
		
	}
	
	public static boolean verifyParams(String[] params) {
		
		for(String param: params) {
			if(param == "") {
				return false;
			}
		}
		
		return true;
		
	}
	
	public static Date parseDate(String date_str){
		try {
			return new Date(new SimpleDateFormat("yyyy-MM-dd")
							.parse(date_str)
							.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}

	}
	
	public static Usuario getUser(HttpServletRequest request) 
			throws ServletException, IOException{
		
		if(SessionUtils.verifyUserOnSession(request)) {
			
			Object ob = request.getSession().getAttribute("idUsuario");
			
			if(ob != null) {
				return new UsuarioDAO().findById(Integer.parseInt(ob.toString()));
			}
			
		}
		
		
		return null;
		
	}
	
}
