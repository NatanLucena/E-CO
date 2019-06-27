package testesDeUnidade;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entidades.PL;

class PLTest {
	PL pl;
	
	@BeforeEach
	void iniciaPL() {
		pl = new PL("123456789-9", 2018, "rerorero", "1234", "educacao", "url", false);
	}
	
	@Test
	void construtorTest() {
		assertThrows(IllegalArgumentException.class, () -> new PL(null,  2018, "rerorero", "1234", "educacao", "url", false));
		assertThrows(IllegalArgumentException.class, () -> new PL("",  2018, "rerorero", "1234", "educacao", "url", false));
		
		assertThrows(IllegalArgumentException.class, () -> new PL("Lucas",  2018, null, "1234", "educacao", "url", false));
		assertThrows(IllegalArgumentException.class, () -> new PL("Lucas",  2018, "", "1234", "educacao", "url", false));
		
		assertThrows(IllegalArgumentException.class, () -> new PL("Lucas",  2018, "rerorero", null, "educacao", "url", false));
		assertThrows(IllegalArgumentException.class, () -> new PL("Lucas",  2018, "rerorero", "", "educacao", "url", false));
		
		assertThrows(IllegalArgumentException.class, () -> new PL("Lucas",  2018, "rerorero", "1234", null, "url", false));
		assertThrows(IllegalArgumentException.class, () -> new PL("Lucas",  2018, "rerorero", "1234", "", "url", false));
		
		assertThrows(IllegalArgumentException.class, () -> new PL("Lucas",  2018, "rerorero", "1234", "educacao", null, false));
		assertThrows(IllegalArgumentException.class, () -> new PL("Lucas",  2018, "rerorero", "1234", "educacao", "", false));
	}
	
	@Test
	void getConclusivaEIsConclusivaTest() {
		 assertEquals(pl.getConclusiva(), "");
		 PL pl2 = new PL("123456788-9", 2018, "rerorero", "1234", "educacao", "url", true);
		 assertEquals(pl2.getConclusiva(), " - Conclusiva");
		 assertFalse(pl.isConclusivo());
		 assertTrue(pl2.isConclusivo());
	}

	@Test
	void toStringTest() {
		assertEquals(pl.toString(), "Projeto de Lei - rerorero - 123456789-9 - 1234 - EM VOTACAO (CCJC)");
	}	

}