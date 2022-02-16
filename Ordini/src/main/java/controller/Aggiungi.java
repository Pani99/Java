package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import businesscomponent.Carrello;

@WebServlet("/aggiungi")
public class Aggiungi extends HttpServlet {
	private static final long serialVersionUID = -3961377836263286663L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Carrello carrello = (Carrello)session.getAttribute("carrello");
		
		String id = request.getParameter("id");
		
		if(id != null) {
			String marca = request.getParameter("marca");
			String modello = request.getParameter("modello");
			double prezzo = Double.parseDouble(request.getParameter("prezzo"));
			carrello.aggiungiArticolo(id, marca, modello, prezzo);
		}
		response.sendRedirect("acquisti.jsp");
	}

}
