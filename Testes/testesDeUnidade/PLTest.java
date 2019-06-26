package testesDeUnidade;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import entidades.PL;

class PLTest {

	@Test
	void testGetConclusiva() {
		PL pl1 = new PL("Aaaaa", 2019, "Bbbbb", "Ccccc", "Ddddd", "Eeeee", true);
		PL pl2 = new PL("Fffff", 2019, "Ggggg", "Hhhhh", "Iiiii", "Jjjjj", false);

		assertTrue(pl1.isConclusivo());
		assertFalse(pl2.isConclusivo());
	}

}