package test.businesscomponent;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import architecture.dao.DAOException;
import businesscomponent.UtenteBC;
import businesscomponent.model.Utente;

@TestMethodOrder(OrderAnnotation.class)

class UtenteBCTest {
	private static Utente utente;
	private static UtenteBC user;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		utente = new Utente();
		user = new UtenteBC();
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
	void testCreateUtente() throws ClassNotFoundException, FileNotFoundException, IOException {
		try {
			user.create(utente);
			System.out.println("Creato utente: "+utente.getUsername());
		} catch(DAOException exc) {
			exc.printStackTrace();
			fail(exc.getMessage());
		}
	}
	
	@Test
	@Order(2)
	void testUpdateUtente() {
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
			
		user.update(utente);
		System.out.println("Aggiornato utente");
		System.out.println(utente.toString());
	} catch(NullPointerException | DAOException exc) {
		exc.printStackTrace();
		fail(exc.getMessage());
	}
}
	
	@Test
	@Order(3)
	void testGetUtente() {
		try {
			/*utente = new Utente();
			utente.setNome("Mario");
			utente.setCognome("Rossi");
			utente.setIndirizzo("Via Torino, 10");
			utente.setCap("10100");
			utente.setNascita(new GregorianCalendar(1999,04,07).getTime());
			utente.setPassword("ciao02");
			utente.setEmail("io@mail.it");*/
			utente.setUsername("piantuz");
			
		user.getUserById(utente);
		System.out.println("Utente Get");
		System.out.println(utente.toString());
	} catch(NullPointerException | DAOException exc) {
		exc.printStackTrace();
		fail(exc.getMessage());
	}
}
	
	
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		try {
			user.delete(utente);
			utente = null;
			user = null;
			System.out.println("Cancellato utente");
		} catch(NullPointerException | DAOException exc) {
			exc.printStackTrace();
			fail(exc.getMessage());
		}
	}
}
