package architecture.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import businesscomponent.model.OrdineArticolo;

public class OrdineArticoloDAO extends OrdineArticoloAdapter implements DAOConstants {

	private CachedRowSet rowSet;

	private OrdineArticoloDAO() throws DAOException {
		try {
			rowSet = RowSetProvider.newFactory().createCachedRowSet();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	public static OrdineArticoloDAO getFactory() throws DAOException {
		return new OrdineArticoloDAO();
	}

	@Override
	public void create(Connection conn, OrdineArticolo model) throws DAOException {

		try {
			rowSet.setCommand(SELECT_ORDINE_ARTICOLO);
			rowSet.execute(conn);
			rowSet.moveToInsertRow();

			rowSet.updateLong(1, model.getIdOrdine());
			rowSet.updateLong(2, model.getIdArticolo());
			rowSet.updateInt(3, model.getQuantita());

			rowSet.insertRow();
			rowSet.moveToCurrentRow();
			rowSet.acceptChanges();

		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		
	}
	
	public OrdineArticolo[] getOrdineArticolo(Connection conn) throws DAOException {
		
		OrdineArticolo[] oa = null;
		try {
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			ResultSet rs = stmt.executeQuery(SELECT_ORDINE_ARTICOLO);
			rs.last();

			oa = new OrdineArticolo[rs.getRow()];

			rs.beforeFirst();
			
			for (int i = 0; rs.next(); i++) {
				OrdineArticolo prov = new OrdineArticolo();
				
				prov.setIdOrdine(rs.getLong(1));
				prov.setIdArticolo(rs.getLong(2));
				prov.setQuantita(rs.getInt(3));
				
				oa[i] = prov;
			}
			rs.close();


		} catch (SQLException sql) {
			throw new DAOException(sql);
		}

		return oa;
	}
}
