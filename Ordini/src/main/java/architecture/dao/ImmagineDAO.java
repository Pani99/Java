package architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import businesscomponent.model.Immagine;

public class ImmagineDAO implements GenericDAO<Immagine>, DAOConstants{
	private CachedRowSet rowSet;
	
	private ImmagineDAO() throws DAOException {
		try {
			rowSet = RowSetProvider.newFactory().createCachedRowSet();
		}catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public static ImmagineDAO getFactory() throws DAOException {
		return new ImmagineDAO();
	}
	

	@Override
	public void create(Connection conn, Immagine model) throws DAOException {
		try {
			rowSet.setCommand(SELECT_IMMAGINE);
			rowSet.execute(conn);
			rowSet.moveToInsertRow();
			rowSet.updateLong(1, model.getIdImg());
			rowSet.updateString(2, model.getUrl());
			rowSet.updateString(3, model.getDescrizione());
			
			rowSet.insertRow();
			rowSet.moveToCurrentRow();
			rowSet.acceptChanges();	
		}catch (SQLException sql) {
			throw new DAOException(sql);
		}	
	}

	@Override
	public void update(Connection conn, Immagine model) throws DAOException {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(UPDATE_IMMAGINE);
			ps.setString(1, model.getUrl());
			ps.setString(2, model.getDescrizione());
			ps.setLong(3, model.getIdImg());
			ps.execute();
			conn.commit();
		}catch (SQLException sql) {
			throw new DAOException(sql);
		}	
	}

	@Override
	public void delete(Connection conn, Immagine model) throws DAOException {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(DELETE_IMMAGINE);
			ps.setLong(1, model.getIdImg());
			ps.execute();
			conn.commit();
		}catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	@Override
	public Immagine[] getAll(Connection conn) throws DAOException {
		Immagine[] img = null;
		try {
			Statement stmt = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(SELECT_IMMAGINE);
			rs.last();
			img = new Immagine[rs.getRow()];
			rs.beforeFirst();
			
			for(int i = 0; rs.next(); i++) {
				Immagine imm = new Immagine();
				imm.setIdImg(rs.getLong(1));
				imm.setUrl(rs.getString(2));
				imm.setDescrizione(rs.getString(3));
				img[i] = imm;	
			}
			rs.close();
		}catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return img;
	}

	@Override
	public Immagine getById(Connection conn, Immagine model) throws DAOException {
		Immagine imm = null;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SELECT_IMMAGINE_BYID);
			ps.setLong(1, model.getIdImg());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				imm = new Immagine();
				imm.setIdImg(rs.getLong(1));
				imm.setUrl(rs.getString(2));
				imm.setDescrizione(rs.getString(3));
				}
		}catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return imm;
	}
}
