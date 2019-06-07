package testesDeUnidade;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controladores.ControladorDePartidos;

class ControladorDePartidosTest {
	private ControladorDePartidos controlador;

	@BeforeEach
	public void preparaControle() {
		this.controlador = new ControladorDePartidos();
	}
	
	@Test
	void testCadastraPartido() {
		//cadastrando partido valido
		controlador.cadastraPartido("AAAAA");
		assertTrue(controlador.containsPartido("AAAAA"));
		//cadastrando partido nulo
		assertThrows(IllegalArgumentException.class, () -> controlador.cadastraPartido(null));
		//cadastrando partido vazio
		assertThrows(IllegalArgumentException.class, () -> controlador.cadastraPartido(""));
	}
	
	@Test
	void testExibirBase() {
		
	}
}