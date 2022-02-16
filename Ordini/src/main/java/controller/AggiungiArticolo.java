package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businesscomponent.AdminFacade;
import businesscomponent.model.Articolo;

@WebServlet("/inserisciArticolo")
public class AggiungiArticolo extends HttpServlet {
	
	private static final long serialVersionUID = 5443161436822550933L;
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Articolo articolo = this.getArticolo(request);
		
		if(articolo != null) {
			try {
				AdminFacade.getInstance().createOrUpdateArticolo(articolo);
			} catch (ClassNotFoundException | SQLException | IOException e) {
				e.printStackTrace();
				throw new ServletException(e.getMessage());
			}
		}
		response.sendRedirect("admin/gestisciArticoli.jsp");
	}
	
	public Articolo getArticolo(HttpServletRequest request) {
		Articolo articolo = null;
		
		try {
			articolo = new Articolo();
			
			articolo.setId_articolo(Long.parseLong(request.getParameter("id")));
			articolo.setMarca(request.getParameter("marca"));
			articolo.setModello(request.getParameter("modello"));
			articolo.setPrezzo(Double.parseDouble(request.getParameter("prezzo")));
			
		} catch (NumberFormatException exc) {
			exc.printStackTrace();
		}
		return articolo;
	}


}
