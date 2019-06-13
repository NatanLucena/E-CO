package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entidades.Partido;

class PartidoTest {
	Partido partido;

	@BeforeEach
	void IniciaPartido() {
		partido = new Partido("ABC");
	}

	@Test
	void testPartido() {
		Partido partido2 = new Partido("ABC");
		assertEquals(partido2.getPartido(), partido.getPartido());
	}

	@Test
	void testToString() {
		assertEquals("Partido: ABC", partido.toString());
	}

}