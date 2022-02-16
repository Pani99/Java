package test.architecture.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import architecture.dao.DAOException;
import architecture.dao.UtenteDAO;
import architecture.dbaccess.DBAccess;
import businesscomponent.model.Utente;

@TestMethodOrder(OrderAnnotation.class)

class UtenteDAOTest {
	private static Utente utente;
	private static Connection conn;

	@BeforeEach
	void setUp() throws Exception {
		conn = DBAccess.getConnection();
		utente = new Utente();
		utente.setNome("Luca");
		utente.setCognome("Pianta");
		utente.setIndirizzo("Via Torino, 10");
		utente.setCap("10147");
		utente.setNascita(new GregorianCalendar(1999,04,07).getTime());
		utente.setUsername("piantuz");
		utente.setPassword("ciao02");
		utente.setEmail("l@mal.it");
	}

	@Test
	@Order(1)
	void testCreate() {
		try {
			UtenteDAO.getFactory().create(conn, utente);
			System.out.println("Creato utente");
			System.out.println(utente.toString());
		} catch(DAOException exc) {
			exc.printStackTrace();
			fail(exc.getMessage());
		}
	}
	
	@Test
	@Order(3)
	void testUpdateGetByID() {
		try {
			utente = new Utente();
			utente.setNome("Mario");
			utente.setCognome("Rossi");
			utente.setIndirizzo("Via Torino, 10");
			utente.setCap("10100");
			utente.setNascita(new GregorianCalendar(1999,04,07).getTime());
			utente.setPassword("ciao02");
			utente.setEmail("io@mail.it");
			utente.setUsername("piantuz");
			
		UtenteDAO.getFactory().update(conn, utente);
		System.out.println("Aggiornato utente");
		System.out.println(utente.toString());
		Utente u = UtenteDAO.getFactory().getById(conn, utente);
		System.out.println(u.toString());
		System.out.println("nome aggiornato: "+u.getNome());
		System.out.println("cognome aggiornato: "+u.getCognome());
	} catch(NullPointerException | DAOException exc) {
		exc.printStackTrace();
		fail(exc.getMessage());
	}
}
	
	@Test
	@Order(2)
	void testGetAll() {
		try {	
		Utente[] utenti = UtenteDAO.getFactory().getAll(conn);
		assertNotNull(utenti);
	} catch(NullPointerException | DAOException exc) {
		exc.printStackTrace();
		fail(exc.getMessage());
	}
}
	
	@AfterAll
	 static void tearDownAfterClass() throws Exception {
		try {
			UtenteDAO.getFactory().delete(conn, utente);
			utente = null;
			System.out.println("Cancellato utente");
		} catch(NullPointerException | DAOException exc) {
			exc.printStackTrace();
			fail(exc.getMessage());
		}
	}
}
