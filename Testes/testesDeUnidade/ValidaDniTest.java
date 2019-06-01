package testesDeUnidade;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import metodosAuxiliares.ValidaDni;

class ValidaDniTest {

	@Test
	void validaDni() {
		assertFalse(ValidaDni.validaDni("1111111111-A"));		
		assertFalse(ValidaDni.validaDni("A111111111-0"));
		assertTrue(ValidaDni.validaDni("111111111-0"));
		
	}

}
