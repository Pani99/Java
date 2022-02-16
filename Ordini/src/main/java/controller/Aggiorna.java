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

@WebServlet("/aggiorna")
public class Aggiorna extends HttpServlet {
	private static final long serialVersionUID = 653309683633585690L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String user = (String)session.getAttribute("username");
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			ClientFacade cF = ClientFacade.getInstance();
			
			Utente utente = new Utente();
			utente.setNome(request.getParameter("nome"));
			utente.setCognome(request.getParameter("cognome"));
			utente.setIndirizzo(request.getParameter("indirizzo"));
			utente.setCap(request.getParameter("cap"));
			utente.setNascita(formato.parse(request.getParameter("nascita")));
			utente.setUsername(user);
			utente.setPassword(request.getParameter("password"));
			utente.setEmail(request.getParameter("email"));
			cF.getUserById(utente);
			boolean modify=true;
			
			session.setAttribute("mod", modify);
			session.setAttribute("username", utente.getUsername());
			response.sendRedirect("user.jsp");
		
		} catch(ClassNotFoundException | DAOException | ParseException exc) {
			exc.printStackTrace();
			throw new ServletException(exc.getMessage());	
		}
	}
}
