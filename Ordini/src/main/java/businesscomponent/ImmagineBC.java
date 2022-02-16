package businesscomponent;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import architecture.dao.DAOException;
import architecture.dao.ImmagineDAO;
import architecture.dbaccess.DBAccess;
import businesscomponent.model.Immagine;

public class ImmagineBC {
	private Connection conn;
	
	public ImmagineBC() 
			throws ClassNotFoundException, DAOException, FileNotFoundException, IOException {
		conn = DBAccess.getConnection();
	}
	
	
	public Immagine[] getImmagini() throws DAOException {
		Immagine[] immagini = null;
		try {
			immagini = ImmagineDAO.getFactory().getAll(conn);
		}catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return immagini;
	}
	
	
	
	public Immagine getImgById(Immagine immagine) throws DAOException {
		try {
			return ImmagineDAO.getFactory().getById(conn, immagine);
		}catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public void delete(Immagine immagine) throws DAOException {
		try {
			ImmagineDAO.getFactory().delete(conn, immagine);
		}catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	

}
