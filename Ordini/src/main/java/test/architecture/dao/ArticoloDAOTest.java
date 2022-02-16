package test.architecture.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import architecture.dao.ArticoloDAO;
import architecture.dao.DAOException;
import architecture.dbaccess.DBAccess;
import businesscomponent.model.Articolo;

@TestMethodOrder(OrderAnnotation.class)

class ArticoloDAOTest {
	private static Articolo articolo;
	private static Connection conn;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		conn = DBAccess.getConnection();
		articolo = new Articolo();
		articolo.setId_articolo(31);
		articolo.setMarca("HP");
		articolo.setModello("Deskjet F8200");
		articolo.setPrezzo(350.00);
	}

	
	@Test
	@Order(1)
	void testCreate() {
		try {	
		ArticoloDAO.getFactory().create(conn, articolo);
		System.out.println("Creato articolo");
	} catch(DAOException exc) {
		exc.printStackTrace();
		fail(exc.getMessage());
	}
}
	
	@Test
	@Order(2)
	void testUpdateGetByID() {
		try {
			articolo = new Articolo();
			articolo.setId_articolo(31);
			articolo.setMarca("HP");
			articolo.setModello("Deskjet F5200");
			articolo.setPrezzo(250.00);
		ArticoloDAO.getFactory().update(conn, articolo);
		System.out.println("Aggiornato articolo");
		Articolo art = ArticoloDAO.getFactory().getById(conn, articolo);
		System.out.println(art.getModello());
		System.out.println(art.getPrezzo());
	} catch(DAOException exc) {
		exc.printStackTrace();
		fail(exc.getMessage());
	}
}
	
	@Test
	@Order(3)
	void testGetAll() {
		try {	
		Articolo[] articoli = ArticoloDAO.getFactory().getAll(conn);
		assertNotNull(articoli);
	} catch(DAOException exc) {
		exc.printStackTrace();
		fail(exc.getMessage());
	}
}
	
	@AfterAll
	@Order(value = 4)
	static void tearDownAfterClass() throws Exception {
		
		try {
			ArticoloDAO.getFactory().delete(conn, articolo);
			articolo = null;
			System.out.println("Cancellato articolo");
		} catch(DAOException exc) {
			exc.printStackTrace();
			fail(exc.getMessage());
		}
	}
}




