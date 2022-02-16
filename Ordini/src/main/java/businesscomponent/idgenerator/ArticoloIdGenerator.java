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

public class ArticoloIdGenerator implements IdGeneratorInterface, DAOConstants {
	private static ArticoloIdGenerator istanza;
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;

	private ArticoloIdGenerator() throws ClassNotFoundException, DAOException, FileNotFoundException, IOException {
		conn = DBAccess.getConnection();
	}

	public static ArticoloIdGenerator getInstance()
			throws ClassNotFoundException, DAOException, FileNotFoundException, IOException {
		if (istanza == null)
			istanza = new ArticoloIdGenerator();
		return istanza;
	}

	@Override
	public long getNextId() throws DAOException, ClassNotFoundException, IOException {
		long id = 0;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SELECT_ARTICOLO_SEQ);
			rs.next();
			id = rs.getLong(1);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return id;

	}

}
