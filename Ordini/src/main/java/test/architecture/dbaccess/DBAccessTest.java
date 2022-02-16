package test.architecture.dbaccess;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import architecture.dao.DAOException;
import architecture.dbaccess.DBAccess;

class DBAccessTest {

	@Test
	void testConnection() {
		try {
			DBAccess.getConnection();
		} catch(DAOException | ClassNotFoundException | IOException exc) {
			exc.printStackTrace();
			fail("Connessione non funzionante");
		}finally {
			try {
				DBAccess.closeConnection();
			} catch(DAOException exc) {
				exc.printStackTrace();
				fail("Impossibile chiudere la connessione");
			}
		}
	}

}
