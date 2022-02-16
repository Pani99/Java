package businesscomponent;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import architecture.dao.DAOException;
import architecture.dao.UtenteDAO;
import architecture.dbaccess.DBAccess;
import businesscomponent.model.Utente;

public class UtenteBC {
	private Connection conn;
	
	public UtenteBC() 
			throws ClassNotFoundException, DAOException, FileNotFoundException, IOException {
		conn = DBAccess.getConnection();
	}
	
	public void create(Utente utente) throws DAOException {
		try {
			UtenteDAO.getFactory().create(conn, utente);
		}catch (SQLException sql) {
			throw new DAOException(sql);
		}	
	}
	
	public void update(Utente utente) throws DAOException {
		try {
			UtenteDAO.getFactory().update(conn, utente);
			
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}	
	}
	
	public Utente getUserById(Utente utente) throws DAOException {
		try {
			return UtenteDAO.getFactory().getById(conn, utente);
		}catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	
	public Utente getById(String username) throws DAOException {
		
		Utente utente = null;

		try {
			utente = UtenteDAO.getFactory().getById(conn, username);
		} catch (DAOException sql) {
			throw new DAOException(sql);
		}
		return utente;
	}
		
	
	public void delete(Utente utente) throws DAOException {
		try {
			UtenteDAO.getFactory().delete(conn, utente);
		}catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public String mostOrdersByUser() throws DAOException {
		String most = null;
		
		try {
			most = UtenteDAO.getFactory().mostOrdersByUser(conn);
		} catch (DAOException sql) {
			throw new DAOException(sql);
		}
		return most;
	}
		
}
