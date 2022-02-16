package businesscomponent.utilities;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import architecture.dao.DAOConstants;
import architecture.dao.DAOException;
import architecture.dbaccess.DBAccess;

public class ReportOrdini implements DAOConstants{
	private Connection conn;
	
	public ReportOrdini() 
			throws ClassNotFoundException, DAOException, FileNotFoundException, IOException {
		conn = DBAccess.getConnection();
	}
	
	public Vector<String[]> getReport() throws DAOException {
		try {
			Statement stmt = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery(SELECT_REPORT);
			ResultSetMetaData meta = rs.getMetaData();
			int colonne = meta.getColumnCount();
			Vector<String[]> dati = new Vector<String[]>();
			rs.beforeFirst();
			while(rs.next()) {
				String[] riga = new String[colonne];
				for(int i = 0; i < colonne; i++) 
					riga[i] = rs.getString(i+1);
				dati.add(riga);
			}
			return dati;	
		}catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
}
