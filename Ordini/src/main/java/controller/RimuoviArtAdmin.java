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
import businesscomponent.model.Ordine;
import businesscomponent.model.OrdineArticolo;

@WebServlet("/rimuoviArticolo")
public class RimuoviArtAdmin extends HttpServlet {

	private static final long serialVersionUID = 8801581003372160691L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Ordine ordine = new Ordine();
		Articolo toBeDeleted = null;
		OrdineArticolo[] oa = null;
		long idArticolo = Long.parseLong( request.getParameter("id"));
		
		try {
			oa = AdminFacade.getInstance().getOrdineArticolo();
			
			for(int i = 0; i < oa.length; i++) {
				
				if(oa[i].getIdArticolo() == idArticolo) {
					ordine.setId_ordine(oa[i].getIdOrdine());
					AdminFacade.getInstance().deleteOrdine(ordine);
				}
			}
			
			toBeDeleted = AdminFacade.getInstance().getArticoloById(idArticolo);
			
			AdminFacade.getInstance().deleteArticolo(toBeDeleted);
			
		} catch (NumberFormatException | ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
			throw new ServletException(e.getMessage());
		}
		
		response.sendRedirect("admin/gestisciArticoli.jsp");
	}

}
