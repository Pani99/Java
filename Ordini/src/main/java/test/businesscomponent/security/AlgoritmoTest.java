package test.businesscomponent.security;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import businesscomponent.security.Algoritmo;

class AlgoritmoTest {

	@Test
	void testAlgoritmo() {
		String password = Algoritmo.converti("pass");
		assertNotNull(password);
		System.out.println(password);
	}

}
