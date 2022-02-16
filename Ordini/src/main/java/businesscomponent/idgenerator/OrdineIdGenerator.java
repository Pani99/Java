package businesscomponent.idgenerator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import architecture.dao.DAOConstants;
import architecture.dao.DAOException;
import architecture.dbaccess.DBAccess;

public class OrdineIdGenerator implements IdGeneratorInterface, DAOConstants {
	private static OrdineIdGenerator istanza;
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;

	private OrdineIdGenerator() throws ClassNotFoundException, DAOException, FileNotFoundException, IOException {
		conn = DBAccess.getConnection();
	}

	public static OrdineIdGenerator getInstance()
			throws ClassNotFoundException, DAOException, FileNotFoundException, IOException {
		if (istanza == null)
			istanza = new OrdineIdGenerator();
		return istanza;
	}

	@Override
	public long getNextId() throws DAOException, ClassNotFoundException, IOException {
		long id = 0;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SELECT_ORDINE_SEQ);
			rs.next();
			id = rs.getLong(1);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return id;

	}

}
