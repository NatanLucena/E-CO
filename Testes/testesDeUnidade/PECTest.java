package testesDeUnidade;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entidades.PEC;

class PECTest {
	PEC pec;
	
	@BeforeEach
	void iniciandoPEC() {
		pec = new PEC("123456789-9", 2018, "codigo", "1234", "educacao", "url", "artigos");
	}
	

	@Test
	void construtorTest() {
		assertThrows(IllegalArgumentException.class, () -> new PEC(null, 2018, "codigo", "1234", "educacao", "url", "artigos"));
		assertThrows(IllegalArgumentException.class, () -> new PEC("", 2018, "codigo", "1234", "educacao", "url", "artigos"));
		
		assertThrows(IllegalArgumentException.class, () -> new PEC("123456789-9", 2018, null, "1234", "educacao", "url", "artigos"));
		assertThrows(IllegalArgumentException.class, () -> new PEC("123456789-9", 2018, "", "1234", "educacao", "url", "artigos"));
		
		assertThrows(IllegalArgumentException.class, () -> new PEC("123456789-9", 2018, "codigo", null, "educacao", "url", "artigos"));
		assertThrows(IllegalArgumentException.class, () -> new PEC("123456789-9", 2018, "codigo", "", "educacao", "url", "artigos"));
		
		assertThrows(IllegalArgumentException.class, () -> new PEC("123456789-9", 2018, "codigo", "1234", null, "url", "artigos"));
		assertThrows(IllegalArgumentException.class, () -> new PEC("123456789-9", 2018, "codigo", "1234", "", "url", "artigos"));
		
		assertThrows(IllegalArgumentException.class, () -> new PEC("123456789-9", 2018, "codigo", "1234", "educacao", null, "artigos"));
		assertThrows(IllegalArgumentException.class, () -> new PEC("123456789-9", 2018, "codigo", "1234", "educacao", "", "artigos"));
		
		assertThrows(IllegalArgumentException.class, () -> new PEC("123456789-9", 2018, "codigo", "1234", "educacao", "url", null));
		assertThrows(IllegalArgumentException.class, () -> new PEC("123456789-9", 2018, "codigo", "1234", "educacao", "url", ""));
	}
	
	@Test
	void getArtigosTest() {
		assertNotEquals(pec.getArtigos(), null);
		assertNotEquals(pec.getArtigos(), "");
		assertEquals(pec.getArtigos(), "artigos");
		
		PEC pec2 = new PEC("123456789-9", 2018, "codigo", "1234", "educacao", "url", "sogitra");
		assertNotEquals(pec.getArtigos(), pec2.getArtigos());
		assertEquals(pec2.getArtigos(), "sogitra");
	}
	
	@Test
	void toStringTest() {
		assertEquals(pec.toString(), "Projeto de Emenda Constitucional - codigo - 123456789-9 - 1234 - artigos - EM VOTACAO (CCJC)");
	}
	
	
}
