package architecture.dao;

import java.sql.Connection;

public interface GenericDAO<T> {
	void create(Connection conn, T model) throws DAOException;
	void update(Connection conn, T model) throws DAOException;
	void delete(Connection conn, T model) throws DAOException;
	T[] getAll(Connection conn) throws DAOException;
	T getById(Connection conn, T model) throws DAOException;
}
