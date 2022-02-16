package architecture.dao;

import java.sql.Connection;

import businesscomponent.model.OrdineArticolo;

public abstract class OrdineArticoloAdapter implements GenericDAO<OrdineArticolo> {

	@Override
	public void create(Connection conn, OrdineArticolo model) throws DAOException {
	
	}

	@Override
	public void update(Connection conn, OrdineArticolo model) throws DAOException {
	
	}

	@Override
	public void delete(Connection conn, OrdineArticolo model) throws DAOException {
		
	}

	@Override
	public OrdineArticolo[] getAll(Connection conn) throws DAOException {
		
		return null;
	}

	@Override
	public OrdineArticolo getById(Connection conn, OrdineArticolo model) throws DAOException {
		
		return null;
	}

}
