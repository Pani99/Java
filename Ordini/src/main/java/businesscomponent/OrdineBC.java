package businesscomponent;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import architecture.dao.DAOException;
import architecture.dao.OrdineDAO;
import architecture.dbaccess.DBAccess;
import businesscomponent.idgenerator.OrdineIdGenerator;
import businesscomponent.model.Ordine;

public class OrdineBC {
	private Connection conn;
	private OrdineIdGenerator idGen;

	public OrdineBC() throws ClassNotFoundException, DAOException, FileNotFoundException, IOException {
		conn = DBAccess.getConnection();
		idGen = OrdineIdGenerator.getInstance();
	}

	public void create(Ordine ordine) throws ClassNotFoundException, IOException, DAOException {
		try {
			ordine.setId_ordine(idGen.getNextId());
			ordine.setData(new Date());
			OrdineDAO.getFactory().create(conn, ordine);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	public Ordine[] getOrdini() throws DAOException {
		Ordine[] ordini = null;
		try {
			ordini = OrdineDAO.getFactory().getAll(conn);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return ordini;
	}

	public void delete(Ordine ordine) throws DAOException {
		try {
			OrdineDAO.getFactory().delete(conn, ordine);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	public Ordine getById(long id) throws DAOException {

		Ordine nuovo = null;

		try {
			nuovo = OrdineDAO.getFactory().getById(conn, id);
		} catch (DAOException sql) {
			throw new DAOException(sql);
		}
		return nuovo;
	}

}
