package businesscomponent;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import architecture.dao.DAOException;
import businesscomponent.model.Articolo;
import businesscomponent.model.Immagine;
import businesscomponent.model.Ordine;
import businesscomponent.model.OrdineArticolo;
import businesscomponent.model.Utente;

public class ClientFacade {
	private static ClientFacade istanza;
	
	private ClientFacade() {
		
	}
	
	public static ClientFacade getInstance() {
		if(istanza == null)
			istanza = new ClientFacade();
		return istanza;
	}
	
	public void createUtente(Utente utente ) 
			throws DAOException, ClassNotFoundException, FileNotFoundException, IOException {
		UtenteBC uBC = new UtenteBC();
		uBC.create(utente);
	}
	
	public void createOrdine(Ordine ordine) 
			throws ClassNotFoundException, DAOException, FileNotFoundException, IOException {
		OrdineBC oBC = new OrdineBC();
		oBC.create(ordine);
	}
	
	public void createOrdineArticolo(OrdineArticolo oa) 
			throws ClassNotFoundException, DAOException, FileNotFoundException, IOException {
		OrdineArticoloBC oBC = new OrdineArticoloBC();
		oBC.create(oa);
	}
	
	public Articolo[] getArticoli() 
			throws ClassNotFoundException, DAOException, FileNotFoundException, IOException {
		ArticoloBC aBC = new ArticoloBC();
		return aBC.getArticoli();
	}
	
	public Articolo[] searchArticolo(String query) 
			throws ClassNotFoundException, DAOException, FileNotFoundException, IOException {
		ArticoloBC aBC = new ArticoloBC();
		return aBC.searchArticolo(query);
	}
	
	public Articolo getArticoloById(Articolo articolo) 
			throws ClassNotFoundException, DAOException, FileNotFoundException, IOException {
		ArticoloBC aBC = new ArticoloBC();
		return aBC.getById(articolo);
	}
	
	public Utente getUserById(Utente utente) 
			throws ClassNotFoundException, DAOException, FileNotFoundException, IOException {
		UtenteBC uBC = new UtenteBC();
		uBC.update(utente);
		return utente;
	}
	
	public Utente getUser(Utente utente) 
			throws ClassNotFoundException, DAOException, FileNotFoundException, IOException {
		UtenteBC uBC = new UtenteBC();
		uBC.getUserById(utente);
		return utente;
	}
	
	public Immagine getImgById(Immagine immagine)
			throws ClassNotFoundException, DAOException, FileNotFoundException, IOException {
		ImmagineBC iBC = new ImmagineBC();
		return iBC.getImgById(immagine);
	}
	
	public ArrayList<Articolo> getArrayArticoli() throws ClassNotFoundException, SQLException, IOException {
		ArticoloBC aBC = new ArticoloBC();
		return aBC.getArrayArticoli();
	}
	
	public ArrayList<Articolo> getArticoliSearch(String ricerca) throws ClassNotFoundException, SQLException, IOException {
		ArticoloBC aBC = new ArticoloBC();
		return aBC.getArticoliSearch(ricerca);
	}

}
