package businesscomponent.utilities;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import architecture.dao.DAOConstants;
import architecture.dao.DAOException;
import architecture.dbaccess.DBAccess;

public class LoginControl implements DAOConstants {
	private Connection conn;

	public LoginControl() 
			throws ClassNotFoundException, DAOException, FileNotFoundException, IOException {
		conn = DBAccess.getConnection();
	}

	public String getUserPass(String username) throws DAOException {
		try {
			PreparedStatement ps = conn.prepareStatement(SELECT_USERPASS);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				return rs.getString(1);
			return null;
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public String getAdminPass(String username) throws DAOException {
		try {
			PreparedStatement ps = conn.prepareStatement(SELECT_ADMINPASS);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				return rs.getString(1);
			return null;
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
}
