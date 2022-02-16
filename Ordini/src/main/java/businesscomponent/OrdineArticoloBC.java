package businesscomponent;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import architecture.dao.DAOException;
import architecture.dao.OrdineArticoloDAO;
import architecture.dbaccess.DBAccess;
import businesscomponent.model.OrdineArticolo;

public class OrdineArticoloBC {
	private Connection conn;
	
	public OrdineArticoloBC() 
			throws ClassNotFoundException, DAOException, FileNotFoundException, IOException {
		conn = DBAccess.getConnection();
	}
	
	public void create(OrdineArticolo oa) throws DAOException {
		try {
			OrdineArticoloDAO.getFactory().create(conn, oa);
		}catch (SQLException sql) {
			throw new DAOException(sql);
		}	
	}
	
	public OrdineArticolo[] getOrdineArticolo() throws DAOException {

		OrdineArticolo[] nuovo = null;

		try {
			nuovo = OrdineArticoloDAO.getFactory().getOrdineArticolo(conn);
		} catch (DAOException sql) {
			throw new DAOException(sql);
		}
		return nuovo;
	}
}
