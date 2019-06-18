package testesDeUnidade;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controladores.ControladorDePropostasLegislativas;

class ControladorDePropostasLegislativasTest {
	private ControladorDePropostasLegislativas controlador;

	@BeforeEach
	void iniciaControlador() {
		this.controlador = new ControladorDePropostasLegislativas();
	}
	
	@Test
	void testCadastrarPL() {
		assertEquals(this.controlador.cadastrarPL("Aaaaa", 2019, "Bbbbb", "Ccccc", "Ddddd", true), "PL 1/2019");
		assertEquals(this.controlador.cadastrarPL("Eeeee", 2019, "Fffff", "Ggggg", "Hhhhh", false), "PL 2/2019");
		assertEquals(this.controlador.cadastrarPL("Iiiii", 2017, "Jjjjj", "Kkkkk", "Lllll", true), "PL 1/2017");
		assertEquals(this.controlador.cadastrarPL("Aaaaa", 2017, "Bbbbb", "Ccccc", "Ddddd", true), "PL 2/2017");
		assertEquals(this.controlador.cadastrarPL("Eeeee", 2017, "Fffff", "Ggggg", "Hhhhh", false), "PL 3/2017");
		assertEquals(this.controlador.cadastrarPL("Mmmmm", 2017, "Nnnnn", "Ooooo", "Ppppp", true), "PL 4/2017");
	}

	@Test
	void testCadastrarPLP() {
		fail("Not yet implemented");
	}

	@Test
	void testCadastrarPEC() {
		fail("Not yet implemented");
	}

	@Test
	void testExibirProjeto() {
		fail("Not yet implemented");
	}

	@Test
	void testContainsProposta() {
		fail("Not yet implemented");
	}

	@Test
	void testGetLocal() {
		fail("Not yet implemented");
	}

	@Test
	void testGetListaDeInteresses() {
		fail("Not yet implemented");
	}

}
