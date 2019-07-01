package testesDeUnidade;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entidades.PLP;

class PLPTest {

	PLP PLP;
	
	@BeforeEach
	void iniciandoPLP() {
		PLP = new PLP("123456789-9", 2018, "codigo", "1234", "educacao", "url", "artigos");
	}	
	

	@Test
	void construtorTest() {
		assertThrows(IllegalArgumentException.class, () -> new PLP(null, 2018, "codigo", "1234", "educacao", "url", "artigos"));
		assertThrows(IllegalArgumentException.class, () -> new PLP("", 2018, "codigo", "1234", "educacao", "url", "artigos"));
		
		assertThrows(IllegalArgumentException.class, () -> new PLP("123456789-9", 2018, null, "1234", "educacao", "url", "artigos"));
		assertThrows(IllegalArgumentException.class, () -> new PLP("123456789-9", 2018, "", "1234", "educacao", "url", "artigos"));
		
		assertThrows(IllegalArgumentException.class, () -> new PLP("123456789-9", 2018, "codigo", null, "educacao", "url", "artigos"));
		assertThrows(IllegalArgumentException.class, () -> new PLP("123456789-9", 2018, "codigo", "", "educacao", "url", "artigos"));
		
		assertThrows(IllegalArgumentException.class, () -> new PLP("123456789-9", 2018, "codigo", "1234", null, "url", "artigos"));
		assertThrows(IllegalArgumentException.class, () -> new PLP("123456789-9", 2018, "codigo", "1234", "", "url", "artigos"));
		
		assertThrows(IllegalArgumentException.class, () -> new PLP("123456789-9", 2018, "codigo", "1234", "educacao", null, "artigos"));
		assertThrows(IllegalArgumentException.class, () -> new PLP("123456789-9", 2018, "codigo", "1234", "educacao", "", "artigos"));
		
		assertThrows(IllegalArgumentException.class, () -> new PLP("123456789-9", 2018, "codigo", "1234", "educacao", "url", null));
		assertThrows(IllegalArgumentException.class, () -> new PLP("123456789-9", 2018, "codigo", "1234", "educacao", "url", ""));
	}
	
	@Test
	void getArtigosTest() {
		assertNotEquals(PLP.getArtigos(), null);
		assertNotEquals(PLP.getArtigos(), "");
		assertEquals(PLP.getArtigos(), "artigos");
		
		PLP PLP2 = new PLP("123456789-9", 2018, "codigo", "1234", "educacao", "url", "sogitra");
		assertNotEquals(PLP.getArtigos(), PLP2.getArtigos());
		assertEquals(PLP2.getArtigos(), "sogitra");
	}
	
	@Test
	void toStringTest() {
		assertEquals(PLP.toString(), "Projeto de Lei Complementar - codigo - 123456789-9 - 1234 - artigos - EM VOTACAO (CCJC)");
	}
	
	
}
