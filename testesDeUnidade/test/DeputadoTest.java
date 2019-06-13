package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entidades.Deputado;

class DeputadoTest {
	Deputado deputado;
	
	@BeforeEach
	void iniciaDeputado() {
		deputado = new Deputado("30/11/2010");
		
	}
	@Test
	void testDeputado() {
		Deputado deputado2 = new Deputado("30/11/2010");
		assertEquals(deputado.getDataDeInicio(), deputado2.getDataDeInicio());
	}

	@Test
	void testSetLeisAprovadas() {
		deputado.setLeisAprovadas(2);
		assertEquals(2, deputado.getLeisAprovadas());
	}

	@Test
	void testToString() {
		assertEquals("POL:", deputado.toString());

	}

}