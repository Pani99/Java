package test.businesscomponent.idgenerator;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import architecture.dao.DAOException;
import businesscomponent.idgenerator.OrdineIdGenerator;

class OrdineIdGeneratorTest {

	@Test
	void testGeneratoreId() {
	try {
		OrdineIdGenerator idGen = OrdineIdGenerator.getInstance();
		assertNotNull(idGen, "istanza non generata correttamente");
		long valore = idGen.getNextId();
		assertEquals(valore, idGen.getNextId() - 1);
		}catch (ClassNotFoundException | DAOException | IOException exc) {
			fail(exc.getMessage());
		}
	}

}
