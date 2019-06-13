package testesDeUnidade;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controladores.ControladorDePartidos;

class ControladorDePartidosTest {
	ControladorDePartidos controlador;
	
	@BeforeEach
	void setUp() {
		controlador = new ControladorDePartidos();
	}

	@Test
	void testCadastraPartidoVazio() {
		assertThrows(IllegalArgumentException.class, () -> controlador.cadastraPartido(""));
	}
	
	@Test
	void testCadastraPartidoNulo() {
		assertThrows(IllegalArgumentException.class, () -> controlador.cadastraPartido(null));
	}
	
	@Test
	void testCadastraPartido() {
		controlador.cadastraPartido("ABC");
		assertTrue(controlador.verificaPartido("ABC"));
	}

	@Test
	void testExibirBaseVazio() {
		assertEquals(controlador.exibirBase(), "");
	}
	
	@Test
	void testExibirBaseUmPartido() {
		controlador.cadastraPartido("ABC");
		assertEquals(controlador.exibirBase(), "ABC");
	}
	
	@Test
	void testExibirBaseMultiplosPartidos() {
		controlador.cadastraPartido("XYZ");
		controlador.cadastraPartido("ABC");
		assertEquals(controlador.exibirBase(), "ABC,XYZ");
	}
	
}