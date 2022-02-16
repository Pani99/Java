package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import architecture.dao.DAOException;
import businesscomponent.ClientFacade;
import businesscomponent.model.Utente;

@WebServlet("/registra")
public class Registra extends HttpServlet {
	private static final long serialVersionUID = 653309683633585690L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Utente utente= new Utente();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			utente.setNome(request.getParameter("nome"));
			utente.setCognome(request.getParameter("cognome"));
			utente.setIndirizzo(request.getParameter("indirizzo"));
			utente.setCap(request.getParameter("cap"));
			utente.setNascita(formato.parse(request.getParameter("nascita")));
			String user = request.getParameter("username");
			utente.setUsername(user);
			utente.setPassword(request.getParameter("password"));
			utente.setEmail(request.getParameter("email"));
			ClientFacade.getInstance().createUtente(utente);
			
			session.setAttribute("mod", false);
			session.setAttribute("username", user);
			response.sendRedirect("acquisti.jsp");
		
		} catch(ParseException | DAOException | ClassNotFoundException exc) {
			exc.printStackTrace();
			throw new ServletException(exc.getMessage());	
		}
	}
}
