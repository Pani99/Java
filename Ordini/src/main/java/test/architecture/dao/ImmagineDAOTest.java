package test.architecture.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import architecture.dao.DAOException;
import architecture.dao.ImmagineDAO;
import architecture.dbaccess.DBAccess;
import businesscomponent.model.Immagine;

@TestMethodOrder(OrderAnnotation.class)

class ImmagineDAOTest {
		private static Immagine immagine;
		private static Connection conn;
		
		@BeforeAll
		static void setUpBeforeClass() throws Exception {
			conn = DBAccess.getConnection();
			immagine = new Immagine();
			immagine.setIdImg(1);
			immagine.setUrl("img1");
			immagine.setDescrizione("Tramonto");
		}

		
		@Test
		@Order(1)
		void testCreate() {
			try {	
			ImmagineDAO.getFactory().create(conn, immagine);
			System.out.println("Creata immagine");
		} catch(DAOException exc) {
			exc.printStackTrace();
			fail(exc.getMessage());
		}
	}
		
		@Test
		@Order(2)
		void testUpdateGetByID() {
			try {
				immagine = new Immagine();
				immagine.setIdImg(1);
				immagine.setUrl("localeimg1");
				immagine.setDescrizione("Alba");
			ImmagineDAO.getFactory().update(conn, immagine);
			System.out.println("Aggiornata immagine");
			Immagine imm = ImmagineDAO.getFactory().getById(conn, immagine);
			System.out.println(imm.getUrl());
			System.out.println(imm.getDescrizione());
		} catch(DAOException exc) {
			exc.printStackTrace();
			fail(exc.getMessage());
		}
	}
		
		@Test
		@Order(3)
		void testGetAll() {
			try {	
			Immagine[] imm = ImmagineDAO.getFactory().getAll(conn);
			assertNotNull(imm);
		} catch(DAOException exc) {
			exc.printStackTrace();
			fail(exc.getMessage());
		}
	}
		
		@AfterAll
		static void tearDownAfterClass() throws Exception {
			
			try {
				ImmagineDAO.getFactory().delete(conn, immagine);
				immagine = null;
				System.out.println("Cancellata immagine");
			} catch(DAOException exc) {
				exc.printStackTrace();
				fail(exc.getMessage());
			}
		}
	}