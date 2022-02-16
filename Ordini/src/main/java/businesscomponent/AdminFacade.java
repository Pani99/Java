package businesscomponent;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import architecture.dao.DAOException;
import businesscomponent.model.Articolo;
import businesscomponent.model.Ordine;
import businesscomponent.model.OrdineArticolo;
import businesscomponent.model.Utente;

public class AdminFacade {
	private static AdminFacade istanza;
	
	private AdminFacade() {
		
	}
	
	public static AdminFacade getInstance() {
		if(istanza == null)
			istanza = new AdminFacade();
		return istanza;
	}
	
	public Ordine[] getOrdini() 
			throws ClassNotFoundException, DAOException, FileNotFoundException, IOException {
		OrdineBC oBC = new OrdineBC();
		return oBC.getOrdini();
		
		
	}
	
	public void deleteOrdine(Ordine ordine ) 
			throws DAOException, ClassNotFoundException, FileNotFoundException, IOException {
		OrdineBC oBC = new OrdineBC();
		oBC.delete(ordine);
	}
	
	public void createOrUpdateArticolo(Articolo articolo) 
			throws ClassNotFoundException, DAOException, FileNotFoundException, IOException {
		ArticoloBC aBC = new ArticoloBC();
		aBC.CreateOrUpdate(articolo);
	}
	
	public void deleteArticolo(Articolo articolo) 
			throws ClassNotFoundException, DAOException, FileNotFoundException, IOException {
		ArticoloBC aBC = new ArticoloBC();
		aBC.delete(articolo);
	}
	
	public Articolo[] getArticoli() 
			throws ClassNotFoundException, DAOException, FileNotFoundException, IOException {
		ArticoloBC aBC = new ArticoloBC();
		return aBC.getArticoli();
	}
	
	public ArrayList<Articolo> getArrayArticoli() throws ClassNotFoundException, SQLException, IOException {
		ArticoloBC aBC = new ArticoloBC();
		return aBC.getArrayArticoli();
	}
	
	public Articolo[] searchArticolo(String query) 
			throws ClassNotFoundException, DAOException, FileNotFoundException, IOException {
		ArticoloBC aBC = new ArticoloBC();
		return aBC.searchArticolo(query);
	}
	
	public Articolo getArticoloById(Articolo articolo) throws ClassNotFoundException, SQLException, IOException {
		ArticoloBC aBC = new ArticoloBC();
		return aBC.getById(articolo);
	}
	
	public Articolo getArticoloById(long id) 
			throws ClassNotFoundException, DAOException, FileNotFoundException, IOException {
		ArticoloBC aBC = new ArticoloBC();
		return aBC.getById(id);
	}
	
	public long creaModifica(Articolo articolo)
			throws ClassNotFoundException, DAOException, FileNotFoundException, IOException {
		ArticoloBC aBC = new ArticoloBC();
		return aBC.creaModifica(articolo);
	}
	
	
	public Utente getUtenteById(String username) throws ClassNotFoundException, SQLException, IOException {
		UtenteBC uBC = new UtenteBC();
		return uBC.getById(username);
	}
	
	public long totaleVendite() throws ClassNotFoundException, SQLException, IOException {
		ArticoloBC aBC = new ArticoloBC();
		return aBC.totaleVendite();
	}
	
	public String bestSeller() throws ClassNotFoundException, SQLException, IOException {
		ArticoloBC aBC = new ArticoloBC();
		long id = Long.parseLong(aBC.bestSeller());
		return this.getArticoloById(id).getMarca() + " " + this.getArticoloById(id).getModello();
	}
	
	public String mostOrders() throws ClassNotFoundException, SQLException, IOException {
		ArticoloBC aBC = new ArticoloBC();
		return aBC.mostOrders();
	}
	
	
	public String mostSpentByUser() throws ClassNotFoundException, SQLException, IOException {
		ArticoloBC aBC = new ArticoloBC();
		return aBC.mostSpentByUser();
	}
	
	public Ordine getOrdineById(long id) throws ClassNotFoundException, SQLException, IOException {
		OrdineBC ordineBC = new OrdineBC();
		return ordineBC.getById(id);
	}
	
	public OrdineArticolo[] getOrdineArticolo() throws ClassNotFoundException, SQLException, IOException {
		OrdineArticoloBC oaBC = new OrdineArticoloBC();
		return oaBC.getOrdineArticolo();
	}
	
	
	public String mostOrdersByUser() throws ClassNotFoundException, SQLException, IOException {
		UtenteBC uBC = new UtenteBC();
		return uBC.mostOrdersByUser();
	}
	
	
	
	
}
