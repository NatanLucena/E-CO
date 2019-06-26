package testesDeUnidade;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entidades.Deputado;

class DeputadoTest {
	Deputado deputado;

	@BeforeEach
	void iniciaDeputado() {
		this.deputado = new Deputado("Jackson", "011111111-0", "PB", "saude, educacao", "DEM", "29022016");

	}

	@Test
	void testDeputado() {
		Deputado deputado2 = new Deputado("Jackson", "011111111-0", "PB", "saude, educacao", "DEM", "29022016");
		assertEquals(deputado.getDataDeInicio(), deputado2.getDataDeInicio());
		assertEquals(deputado.getDni(), deputado2.getDni());
		assertEquals(deputado.getEstado(), deputado2.getEstado());
		assertEquals(deputado.getInteresses(), deputado2.getInteresses());
		assertEquals(deputado.getNome(), deputado2.getNome());
		assertEquals(deputado.getPartido2(), deputado2.getPartido2());
		assertEquals(deputado.getLeisAprovadas(), deputado2.getLeisAprovadas());
	}

	@Test
	void testSetLeisAprovadas() {
		deputado.setLeisAprovadas();
		deputado.setLeisAprovadas();
		assertEquals(2, deputado.getLeisAprovadas());
	}

	@Test
	void testGetDataInicio() {
		Deputado deputado2 = new Deputado("Jackson", "011111111-0", "PB", "saude, educacao", "DEM", "29022016");
		assertEquals(deputado2.getDataDeInicio(), this.deputado.getDataDeInicio());
	}

	@Test
	void testExibir() {
		assertEquals("POL: Jackson - 011111111-0 (PB) - DEM - Interesses: saude, educacao - 29/02/2016 - 0 Leis",
				this.deputado.exibir());

	}

}
