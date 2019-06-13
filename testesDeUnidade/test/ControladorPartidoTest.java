package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controladores.ControladorDePartidos;

class ControladorPartidoTest {
	private ControladorDePartidos controladorPartido;
	
	@BeforeEach
	void iniciaControladorPartido(){
		controladorPartido = new ControladorDePartidos();
		
	}
		

	@Test
	void testCadastraPartido() {
		assertThrows(IllegalArgumentException.class, () -> controladorPartido.cadastraPartido(""));
		assertThrows(IllegalArgumentException.class, () -> controladorPartido.cadastraPartido(null));
		controladorPartido.cadastraPartido("ABC");
		assertThrows(IllegalArgumentException.class, () -> controladorPartido.cadastraPartido("ABC"));
		
		
}

	@Test
	void testExibirBase() {
		controladorPartido.cadastraPartido("ABC");
		controladorPartido.cadastraPartido("DEF");
		assertEquals("ABC,DEF",controladorPartido.exibirBase());

		
	}

	@Test
	void testVerificaPartido() {
		controladorPartido.cadastraPartido("ABC");
		assertTrue(controladorPartido.verificaPartido("ABC"));
		assertFalse(controladorPartido.verificaPartido("DEF"));


	}

}
