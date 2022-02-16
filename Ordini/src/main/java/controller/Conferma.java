package controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import architecture.dao.DAOException;
import businesscomponent.Carrello;
import businesscomponent.ClientFacade;
import businesscomponent.model.Ordine;
import businesscomponent.model.OrdineArticolo;

@WebServlet("/conferma")
public class Conferma extends HttpServlet {
	private static final long serialVersionUID = 8639538868273910537L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Carrello carrello = (Carrello)session.getAttribute("carrello");
		Ordine ordine = new Ordine();
		ordine.setTotale(carrello.totaleComplessivo());
		ordine.setUsername((String)session.getAttribute("username"));
		
		try {
			ClientFacade cF = ClientFacade.getInstance();
			cF.createOrdine(ordine);
			
			OrdineArticolo oa;
			Enumeration<String[]> prodotti = carrello.getElementi();
			while(prodotti.hasMoreElements()) {
				oa = new OrdineArticolo();
				String[] prodotto = prodotti.nextElement();
				oa.setIdOrdine(ordine.getId_ordine());
				oa.setIdArticolo(Long.parseLong(prodotto[4].trim()));
				oa.setQuantita(Integer.parseInt(prodotto[3]));
				System.out.println(oa.toString());
				cF.createOrdineArticolo(oa);
				
			}
			
			session.setAttribute("idOrdine", ordine.getId_ordine());
			response.sendRedirect("ordine.jsp");
		
		} catch(DAOException | ClassNotFoundException exc) {
			exc.printStackTrace();
			throw new ServletException(exc.getMessage());	
		}
	}
}
