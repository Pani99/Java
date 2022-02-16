package architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import businesscomponent.model.Utente;
import businesscomponent.security.Algoritmo;

public class UtenteDAO implements GenericDAO<Utente>, DAOConstants{
	private CachedRowSet rowSet;
	
	private UtenteDAO() throws DAOException {
		try {
			rowSet = RowSetProvider.newFactory().createCachedRowSet();
		}catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public static UtenteDAO getFactory() throws DAOException {
		return new UtenteDAO();
	}
	

	@Override
	public void create(Connection conn, Utente model) throws DAOException {
		try {
			rowSet.setCommand(SELECT_UTENTE);
			rowSet.execute(conn);
			rowSet.moveToInsertRow();
			rowSet.updateString(1, model.getNome());
			rowSet.updateString(2, model.getCognome());
			rowSet.updateString(3, model.getIndirizzo());
			rowSet.updateString(4, model.getCap());
			rowSet.updateDate(5, new java.sql.Date(model.getNascita().getTime()));
			rowSet.updateString(6, model.getUsername());
			rowSet.updateString(7, Algoritmo.converti(model.getPassword()));
			rowSet.updateString(8, model.getEmail());
			rowSet.insertRow();
			rowSet.moveToCurrentRow();
			rowSet.acceptChanges();	
		}catch (SQLException sql) {
			throw new DAOException(sql);
		}	
	}

	@Override
	public void update(Connection conn, Utente model) throws DAOException {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(UPDATE_UTENTE);
			ps.setString(1, model.getNome());
			ps.setString(2, model.getCognome());
			ps.setString(3, model.getIndirizzo());
			ps.setString(4, model.getCap());
			ps.setDate(5, new java.sql.Date(model.getNascita().getTime()));
			ps.setString(6, Algoritmo.converti(model.getPassword()));
			ps.setString(7, model.getEmail());
			ps.setString(8, model.getUsername());
			ps.execute();
			conn.commit();
		}catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	@Override
	public void delete(Connection conn, Utente model) throws DAOException {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(DELETE_UTENTE);
			ps.setString(1, model.getUsername());
			ps.execute();
			conn.commit();
		}catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	@Override
	public Utente[] getAll(Connection conn) throws DAOException {
		Utente[] utenti = null;
		try {
			Statement stmt = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(SELECT_UTENTE);
			rs.last();
			utenti = new Utente[rs.getRow()];
			rs.beforeFirst();
			
			for(int i = 0; rs.next(); i++) {
				Utente u = new Utente();
				u.setNome(rs.getString(1));
				u.setCognome(rs.getString(2));
				u.setIndirizzo(rs.getString(3));
				u.setCap(rs.getString(4));
				u.setNascita(new java.util.Date(rs.getDate(5).getTime()));
				u.setUsername(rs.getString(6));
				u.setPassword(Algoritmo.converti(rs.getString(7)));
				u.setEmail(rs.getString(8));
				utenti[i] = u;	
			}
			rs.close();
		}catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return utenti;
	}

	@Override
	public Utente getById(Connection conn, Utente model) throws DAOException {
		Utente utente = null;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SELECT_UTENTE_BYID);
			ps.setString(1, model.getUsername());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				utente = new Utente();
				utente.setNome(rs.getString(1));
				utente.setCognome(rs.getString(2));
				utente.setIndirizzo(rs.getString(3));
				utente.setCap(rs.getString(4));
				utente.setNascita(new java.util.Date(rs.getDate(5).getTime()));
				utente.setUsername(rs.getString(6));
				utente.setPassword(Algoritmo.converti(rs.getString(7)));
				utente.setEmail(rs.getString(8));
			}
		}catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return utente;
	}
	
	public Utente getById(Connection conn, String username) throws DAOException {

		Utente utente = null;
		PreparedStatement ps;

		try {
			ps = conn.prepareStatement(SELECT_UTENTE_BYID);
			ps.setString(1, username);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				utente = new Utente();

				utente.setNome(rs.getString(1));
				utente.setCognome(rs.getString(2));
				utente.setIndirizzo(rs.getString(3));
				utente.setCap(rs.getString(4));
				utente.setNascita(rs.getDate(5));
				utente.setUsername(rs.getString(6));
				utente.setPassword(rs.getString(7));
				utente.setEmail(rs.getString(8));

			}

		} catch (SQLException sql) {
			throw new DAOException(sql);
		}

		return utente;
	}
	
	public String mostOrdersByUser(Connection conn) throws DAOException {
		String most = null;
		
		try {
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(SELECT_MOST_ORDERS_NUMBER);
			if(rs.next())
				most = rs.getString(1);
			
			rs.close();

		} catch (SQLException sql) {
			throw new DAOException(sql);
		}

		return most;
	}

	
	
}
