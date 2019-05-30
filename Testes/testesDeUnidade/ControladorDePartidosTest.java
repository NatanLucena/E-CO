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
		try {
			controlador.cadastraPartido("");
		}catch (IllegalArgumentException i) {
			
		}
	}
	
	@Test
	void testCadastraPartidoNulo() {
		try {
			controlador.cadastraPartido(null);
		}catch (NullPointerException n) {
			
		}
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
