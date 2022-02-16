package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import businesscomponent.Carrello;

@WebServlet("/rimuovi")
public class Rimuovi extends HttpServlet {
	private static final long serialVersionUID = 1418913962208488399L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Carrello carrello = (Carrello)session.getAttribute("carrello");
		
		String id = request.getParameter("id");
		System.out.println(id);
		
		if(id != null) {
			carrello.rimuoviArticolo(id);
		}
		response.sendRedirect("carrello.jsp");
	}

}
