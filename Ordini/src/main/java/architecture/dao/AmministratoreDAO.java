package architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import businesscomponent.model.Amministratore;
import businesscomponent.security.Algoritmo;

public class AmministratoreDAO implements GenericDAO<Amministratore>, DAOConstants{
	private CachedRowSet rowSet;
	
	private AmministratoreDAO() throws DAOException {
		try {
			rowSet = RowSetProvider.newFactory().createCachedRowSet();
		}catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public static AmministratoreDAO getFactory() throws DAOException {
		return new AmministratoreDAO();
	}
	

	@Override
	public void create(Connection conn, Amministratore model) throws DAOException {
		try {
			rowSet.setCommand(SELECT_AMMINISTRATORE);
			rowSet.execute(conn);
			rowSet.moveToInsertRow();
			rowSet.updateString(1, model.getUsername());
			rowSet.updateString(2, Algoritmo.converti(model.getPassword()));
			rowSet.updateString(3, model.getEmail());
			rowSet.insertRow();
			rowSet.moveToCurrentRow();
			rowSet.acceptChanges();	
		}catch (SQLException sql) {
			throw new DAOException(sql);
		}	
	}

	@Override
	public void update(Connection conn, Amministratore model) throws DAOException {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(UPDATE_AMMINISTRATORE);
			ps.setString(1, Algoritmo.converti(model.getPassword()));
			ps.setString(2, model.getEmail());
			ps.setString(3, model.getUsername());
			ps.execute();
			conn.commit();
		}catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	@Override
	public void delete(Connection conn, Amministratore model) throws DAOException {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(DELETE_AMMINISTRATORE);
			ps.setString(1, model.getUsername());
			ps.execute();
			conn.commit();
		}catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	@Override
	public Amministratore[] getAll(Connection conn) throws DAOException {
		Amministratore[] admin = null;
		try {
			Statement stmt = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(SELECT_AMMINISTRATORE);
			rs.last();
			admin = new Amministratore[rs.getRow()];
			rs.beforeFirst();
			
			for(int i = 0; rs.next(); i++) {
				Amministratore a = new Amministratore();
				a.setUsername(rs.getString(1));
				a.setPassword(Algoritmo.converti(rs.getString(2)));
				a.setEmail(rs.getString(3));
				admin[i] = a;	
			}
			rs.close();
		}catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return admin;
	}

	@Override
	public Amministratore getById(Connection conn, Amministratore model) throws DAOException {
		Amministratore admin = null;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SELECT_AMMINISTRATORE_BYID);
			ps.setString(1, model.getUsername());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				admin = new Amministratore();
				admin.setUsername(rs.getString(1));
				admin.setPassword(Algoritmo.converti(rs.getString(2)));
				admin.setEmail(rs.getString(3));
			}
		}catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return admin;
	}
}
