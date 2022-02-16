package businesscomponent;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import architecture.dao.ArticoloDAO;
import architecture.dao.DAOException;
import architecture.dbaccess.DBAccess;
import businesscomponent.idgenerator.ArticoloIdGenerator;
import businesscomponent.model.Articolo;

public class ArticoloBC {
	private Connection conn;
	private ArticoloIdGenerator idGen;
	
	public ArticoloBC() 
			throws ClassNotFoundException, DAOException, FileNotFoundException, IOException {
		conn = DBAccess.getConnection();
		idGen = ArticoloIdGenerator.getInstance();
	}
	
	public void CreateOrUpdate(Articolo articolo) 
			throws DAOException, ClassNotFoundException, IOException {
		try {
			if(articolo.getId_articolo() > 0 )
				ArticoloDAO.getFactory().update(conn, articolo);
			else {
				articolo.setId_articolo(idGen.getNextId());
				ArticoloDAO.getFactory().create(conn, articolo);
			}
				
		}catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public long creaModifica(Articolo articolo) throws DAOException, ClassNotFoundException, IOException {
		long id = articolo.getId_articolo();
		try {
			if (articolo.getId_articolo() > 0)
				ArticoloDAO.getFactory().update(conn, articolo);
			else {
				id = idGen.getNextId();
				articolo.setId_articolo(id);
				ArticoloDAO.getFactory().create(conn, articolo);
			}
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return id;
	}
	
	public Articolo[] getArticoli() throws DAOException {
		Articolo[] articoli = null;
		try {
			articoli = ArticoloDAO.getFactory().getAll(conn);
		}catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return articoli;
	}
	
	public ArrayList<Articolo> getArrayArticoli() throws DAOException {
		ArrayList<Articolo> articoli = new ArrayList<Articolo>();
		Articolo[] articoliArr = null;

		try {
			articoliArr = ArticoloDAO.getFactory().getAll(conn);
			
			for(int i = 0; i < articoliArr.length; i++) {
				articoli.add(articoliArr[i]);
			}
			
		} catch (DAOException sql) {
			throw new DAOException(sql);
		}

		return articoli;
	}
	
	
	public Articolo[] searchArticolo(String query) throws DAOException {
		ArrayList<Articolo> listaArticoli = new ArrayList<Articolo>();
		String[] criterioDiRicerca = query.toLowerCase().split(" ");
		
		
		for(Articolo a : getArticoli())
			for(String s : criterioDiRicerca)
				if(a.getMarca().toLowerCase().contains(s) ||
						a.getModello().toLowerCase().contains(s))
					listaArticoli.add(a);
		
		Articolo[] articoli = new Articolo[listaArticoli.size()];
		for(int i = 0; i < listaArticoli.size(); i++) {
			articoli[i] = listaArticoli.get(i);
		}
		return articoli;	
	}
	
	public Articolo getById(Articolo articolo) throws DAOException {
		try {
			return ArticoloDAO.getFactory().getById(conn, articolo);
		}catch (SQLException sql) {
			throw new DAOException(sql);
		}
		
		
		
	}
	
	public Articolo getById(long id) throws DAOException {
		try {
			return ArticoloDAO.getFactory().getById(conn, id);
		}catch (SQLException sql) {
			throw new DAOException(sql);
		}
		
		
		
	}
	
	public void delete(Articolo articolo) throws DAOException {
		try {
			ArticoloDAO.getFactory().delete(conn, articolo);
		}catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public ArrayList<Articolo> getArticoliSearch(String ricerca) throws DAOException{
		ArrayList<Articolo> lista = null;
		
		try {
			lista = ArticoloDAO.getFactory().getArticoliSearch(ricerca, conn);
		}  catch (DAOException sql) {
			throw new DAOException(sql);
		}
		
		return lista;
	}
	
	public long totaleVendite() throws DAOException {
		long totale = 0;
		
		try {
			totale = ArticoloDAO.getFactory().totaleVendite(conn);
		} catch (DAOException sql) {
			throw new DAOException(sql);
		}
		
		return totale;
	}
	
	public String bestSeller() throws DAOException {
		String best = null;
		
		try {
			best = ArticoloDAO.getFactory().bestSeller(conn);
		} catch (DAOException sql) {
			throw new DAOException(sql);
		}
		return best;
	}
	
	public String mostOrders() throws DAOException {
		String most = null;
		
		try {
			most = ArticoloDAO.getFactory().mostOrders(conn);
		} catch (DAOException sql) {
			throw new DAOException(sql);
		}
		return most;
	}
	
	public String mostSpentByUser()throws DAOException {
		String most = null;
		
		try {
			most = ArticoloDAO.getFactory().mostSpentByUser(conn);
		} catch (DAOException sql) {
			throw new DAOException(sql);
		}
		return most;
	}
	

}
