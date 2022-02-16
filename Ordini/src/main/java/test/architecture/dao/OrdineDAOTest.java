package test.architecture.dao;

import static org.junit.jupiter.api.Assertions.*;


import java.sql.Connection;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

import architecture.dao.DAOException;
import architecture.dao.OrdineDAO;
import architecture.dao.UtenteDAO;
import architecture.dbaccess.DBAccess;
import businesscomponent.model.Ordine;
import businesscomponent.model.Utente;

@TestMethodOrder(OrderAnnotation.class)

class OrdineDAOTest {
	private static Ordine ordine;
	private static Utente utente;
	private static Connection conn;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		conn = DBAccess.getConnection();
		utente = new Utente();
		utente.setNome("Luca");
		utente.setCognome("Pianta");
		utente.setIndirizzo("Via Torino, 10");
		utente.setCap("10147");
		utente.setNascita(new GregorianCalendar(1999,04,07).getTime());
		utente.setUsername("piantuz");
		utente.setPassword("ciao02");
		utente.setEmail("l@mail.it");
		
		ordine = new Ordine();
		ordine.setId_ordine(1);
		ordine.setTotale(2000);
		ordine.setData(new Date());
		ordine.setUsername(utente.getUsername());
	}

	@Test
	@Order(1)
	void testCreate() {
		try {	
		UtenteDAO.getFactory().create(conn, utente);
		OrdineDAO.getFactory().create(conn, ordine);
		System.out.println("Creato utente e ordine");
	} catch(DAOException exc) {
		exc.printStackTrace();
		fail(exc.getMessage());
	}
}

	@Test
	@Order(2)
	void testGetAll() {
		try {	
		Ordine[] ordini = OrdineDAO.getFactory().getAll(conn);
		assertNotNull(ordini);
	} catch(DAOException exc) {
		exc.printStackTrace();
		fail(exc.getMessage());
	}
}
	
	@Test
	@Order(3)
	void testUpdateGetByID() {
		try {
			ordine = new Ordine();
			ordine.setId_ordine(1);
			ordine.setTotale(1800);
			ordine.setData(new Date());
			ordine.setUsername("piantuz");
		OrdineDAO.getFactory().update(conn, ordine);
		System.out.println("Aggiornato ordine");
		Ordine or = OrdineDAO.getFactory().getById(conn, ordine);
		System.out.println(or.getTotale());
		System.out.println(or.getUsername());
	} catch(DAOException exc) {
		exc.printStackTrace();
		fail(exc.getMessage());
	}
}
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		try {
			OrdineDAO.getFactory().delete(conn, ordine);
			UtenteDAO.getFactory().delete(conn, utente);
			ordine = null;
			utente = null;
			System.out.println("Cancellato utente e ordine");
		} catch(DAOException exc) {
			exc.printStackTrace();
			fail(exc.getMessage());
		}
	}
	
}