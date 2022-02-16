package architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import businesscomponent.model.Articolo;

public class ArticoloDAO implements GenericDAO<Articolo>, DAOConstants{
	private CachedRowSet rowSet;

	
	private ArticoloDAO() throws DAOException {
		try {
			rowSet = RowSetProvider.newFactory().createCachedRowSet();
		}catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public static ArticoloDAO getFactory() throws DAOException {
		return new ArticoloDAO();
	}
	

	@Override
	public void create(Connection conn, Articolo model) throws DAOException {
		try {
			rowSet.setCommand(SELECT_ARTICOLO);
			rowSet.execute(conn);
			rowSet.moveToInsertRow();
			rowSet.updateLong(1, model.getId_articolo());
			rowSet.updateString(2, model.getMarca());
			rowSet.updateString(3, model.getModello());
			rowSet.updateDouble(4, model.getPrezzo());
			
			rowSet.insertRow();
			rowSet.moveToCurrentRow();
			rowSet.acceptChanges();	
		}catch (SQLException sql) {
			throw new DAOException(sql);
		}	
	}

	@Override
	public void update(Connection conn, Articolo model) throws DAOException {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(UPDATE_ARTICOLO);
			ps.setString(1, model.getMarca());
			ps.setString(2, model.getModello());
			ps.setDouble(3, model.getPrezzo());
			ps.setLong(4, model.getId_articolo());
			ps.execute();
			conn.commit();
		}catch (SQLException sql) {
			throw new DAOException(sql);
		}	
	}

	@Override
	public void delete(Connection conn, Articolo model) throws DAOException {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(DELETE_ARTICOLO);
			ps.setLong(1, model.getId_articolo());
			ps.execute();
			conn.commit();
		}catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	@Override
	public Articolo[] getAll(Connection conn) throws DAOException {
		Articolo[] articoli = null;
		try {
			Statement stmt = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(SELECT_ARTICOLO);
			rs.last();
			articoli = new Articolo[rs.getRow()];
			rs.beforeFirst();
			
			for(int i = 0; rs.next(); i++) {
				Articolo a = new Articolo();
				a.setId_articolo(rs.getLong(1));
				a.setMarca(rs.getString(2));
				a.setModello(rs.getString(3));
				a.setPrezzo(rs.getDouble(4));
				articoli[i] = a;	
			}
			rs.close();
		}catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return articoli;
	}

	@Override
	public Articolo getById(Connection conn, Articolo model) throws DAOException {
		Articolo articolo = null;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SELECT_ARTICOLO_BYID);
			ps.setLong(1, model.getId_articolo());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				articolo = new Articolo();
				articolo.setId_articolo(rs.getLong(1));
				articolo.setMarca(rs.getString(2));
				articolo.setModello(rs.getString(3));
				articolo.setPrezzo(rs.getDouble(4));
			}
		}catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return articolo;
	}
	
	public Articolo getById(Connection conn, long id) throws DAOException {
		Articolo articolo = null;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SELECT_ARTICOLO_BYID);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				articolo = new Articolo();
				articolo.setId_articolo(rs.getLong(1));
				articolo.setMarca(rs.getString(2));
				articolo.setModello(rs.getString(3));
				articolo.setPrezzo(rs.getDouble(4));
			}
		}catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return articolo;
	}
	
	public ArrayList<Articolo> getArticoliSearch(String ricerca, Connection conn) throws DAOException{

		ArrayList<Articolo> lista = new ArrayList<Articolo>();
		Articolo[] articoli = this.getAll(conn);
		
		for(Articolo articolo : articoli) {
			if(articolo.getMarca().contains(ricerca) || articolo.getModello().contains(ricerca)) {
				lista.add(articolo);
			}
		}
		
		return lista;
	}
	
	public long totaleVendite(Connection conn) throws DAOException {
		long totale = 0;
		
		try {
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(SELECT_TOTAL_EARNINGS);
			if(rs.next())
				totale = rs.getLong(1);
			
			rs.close();

		} catch (SQLException sql) {
			throw new DAOException(sql);
		}

		return totale;
	}
	
	public String bestSeller(Connection conn) throws DAOException {
		String best = null;
		
		try {
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(SELECT_BEST_SELLER);
			if(rs.next())
				best = rs.getString(1);
			
			rs.close();

		} catch (SQLException sql) {
			throw new DAOException(sql);
		}

		return best;
	}
	
	public String mostOrders(Connection conn) throws DAOException {
		String most = null;
		
		try {
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(SELECT_MOST_ORDERS);
			if(rs.next())
				most = rs.getString(1);
			
			rs.close();

		} catch (SQLException sql) {
			throw new DAOException(sql);
		}

		return most;
	}
	
	public String mostSpentByUser(Connection conn) throws DAOException {
		String most = null;
		
		try {
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(SELECT_MOST_SPENT_USER);
			if(rs.next())
				most = rs.getString(1);
			
			rs.close();

		} catch (SQLException sql) {
			throw new DAOException(sql);
		}

		return most;
	}
	
}
