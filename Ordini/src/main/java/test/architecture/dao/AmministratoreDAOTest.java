package test.architecture.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import architecture.dao.AmministratoreDAO;
import architecture.dao.DAOException;
import architecture.dbaccess.DBAccess;
import businesscomponent.model.Amministratore;

@TestMethodOrder(OrderAnnotation.class)

class AmministratoreDAOTest {

	private static Amministratore admin;
	private static Connection conn;

	@BeforeAll
	static void setUp() throws Exception {
		conn = DBAccess.getConnection();
		admin = new Amministratore();
		admin.setUsername("piantuz");
		admin.setPassword("ciao02");
		admin.setEmail("l@mal.it");
	}

	@Test
	@Order(1)
	void testCreate() {
		try {
			AmministratoreDAO.getFactory().create(conn, admin);
			System.out.println("Creato amministratore");
			System.out.println(admin.toString());
		} catch(DAOException exc) {
			exc.printStackTrace();
			fail(exc.getMessage());
		}
	}
	
	@Test
	@Order(2)
	void testUpdateGetByID() {
		try {
			admin = new Amministratore();
			admin.setPassword("ciao02");
			admin.setEmail("io@mail.it");
			admin.setUsername("piantuz");
			
		AmministratoreDAO.getFactory().update(conn, admin);
		System.out.println("Aggiornato admin");
		System.out.println(admin.toString());
		Amministratore a = AmministratoreDAO.getFactory().getById(conn, admin);
		System.out.println("username aggiornato: "+a.getUsername());
		System.out.println("mail aggiornata: "+a.getEmail());
	} catch(NullPointerException | DAOException exc) {
		exc.printStackTrace();
		fail(exc.getMessage());
	}
}
	
	@Test
	@Order(3)
	void testGetAll() {
		try {	
		Amministratore[] amministratori = AmministratoreDAO.getFactory().getAll(conn);
		assertNotNull(amministratori);
	} catch(NullPointerException | DAOException exc) {
		exc.printStackTrace();
		fail(exc.getMessage());
	}
}
	
	@AfterAll
	 static void tearDownAfterClass() throws Exception {
		try {
			AmministratoreDAO.getFactory().delete(conn, admin);
			admin = null;
			System.out.println("Cancellato amministratore");
		} catch(NullPointerException | DAOException exc) {
			exc.printStackTrace();
			fail(exc.getMessage());
		}
	}

}
