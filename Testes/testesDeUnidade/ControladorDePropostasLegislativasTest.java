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
		assertEquals(this.controlador.cadastrarPLP("Aaaaa", 2019, "Bbbbb", "Ccccc", "Ddddd", "Eeeee"), "PLP 1/2019");
		assertEquals(this.controlador.cadastrarPLP("Fffff", 2019, "Ggggg", "Hhhhh", "Iiiii", "Jjjjj"), "PLP 2/2019");
		assertEquals(this.controlador.cadastrarPLP("Aaaaa", 2017, "Bbbbb", "Ccccc", "Ddddd", "Eeeee"), "PLP 1/2017");
		assertEquals(this.controlador.cadastrarPLP("Fffff", 2017, "Ggggg", "Hhhhh", "Iiiii", "Jjjjj"), "PLP 2/2017");
		assertEquals(this.controlador.cadastrarPLP("Kkkkk", 2017, "Lllll", "Mmmmm", "Nnnnn", "Ooooo"), "PLP 3/2017");
		assertEquals(this.controlador.cadastrarPLP("Ppppp", 2017, "Qqqqq", "Rrrrr", "Sssss", "Ttttt"), "PLP 4/2017");
	}

	@Test
	void testCadastrarPEC() {
		assertEquals(this.controlador.cadastrarPEC("Aaaaa", 2019, "Bbbbb", "Ccccc", "Ddddd", "Eeeee"), "PEC 1/2019");
		assertEquals(this.controlador.cadastrarPEC("Fffff", 2019, "Ggggg", "Hhhhh", "Iiiii", "Jjjjj"), "PEC 2/2019");
		assertEquals(this.controlador.cadastrarPEC("Aaaaa", 2017, "Bbbbb", "Ccccc", "Ddddd", "Eeeee"), "PEC 1/2017");
		assertEquals(this.controlador.cadastrarPEC("Fffff", 2017, "Ggggg", "Hhhhh", "Iiiii", "Jjjjj"), "PEC 2/2017");
		assertEquals(this.controlador.cadastrarPEC("Kkkkk", 2017, "Lllll", "Mmmmm", "Nnnnn", "Ooooo"), "PEC 3/2017");
		assertEquals(this.controlador.cadastrarPEC("Ppppp", 2017, "Qqqqq", "Rrrrr", "Sssss", "Ttttt"), "PEC 4/2017");
	}

	@Test
	void testExibirProjeto() {
		this.controlador.cadastrarPL("Aaaaa", 2019, "Bbbbb", "Ccccc", "Ddddd", true);
		this.controlador.cadastrarPL("Eeeee", 2019, "Fffff", "Ggggg", "Hhhhh", false);
		this.controlador.cadastrarPLP("Aaaaa", 2017, "Bbbbb", "Ccccc", "Ddddd", "Eeeee");
		this.controlador.cadastrarPLP("Fffff", 2017, "Ggggg", "Hhhhh", "Iiiii", "Jjjjj");
		this.controlador.cadastrarPEC("Kkkkk", 2017, "Lllll", "Mmmmm", "Nnnnn", "Ooooo");
		this.controlador.cadastrarPEC("Ppppp", 2017, "Qqqqq", "Rrrrr", "Sssss", "Ttttt");

		assertEquals(this.controlador.exibirProjeto("PL 1/2019"),
				"Projeto de Lei - PL 1/2019 - Aaaaa - Bbbbb - Conclusiva - EM VOTACAO (CCJC)");
		assertEquals(this.controlador.exibirProjeto("PL 2/2019"),
				"Projeto de Lei - PL 2/2019 - Eeeee - Fffff - EM VOTACAO (CCJC)");
		assertEquals(this.controlador.exibirProjeto("PLP 1/2017"),
				"Projeto de Lei Complementar - PLP 1/2017 - Aaaaa - Bbbbb - Eeeee - EM VOTACAO (CCJC)");
		assertEquals(this.controlador.exibirProjeto("PLP 2/2017"),
				"Projeto de Lei Complementar - PLP 2/2017 - Fffff - Ggggg - Jjjjj - EM VOTACAO (CCJC)");
		assertEquals(this.controlador.exibirProjeto("PEC 1/2017"),
				"Projeto de Emenda Constitucional - PEC 1/2017 - Kkkkk - Lllll - Ooooo - EM VOTACAO (CCJC)");
		assertEquals(this.controlador.exibirProjeto("PEC 2/2017"),
				"Projeto de Emenda Constitucional - PEC 2/2017 - Ppppp - Qqqqq - Ttttt - EM VOTACAO (CCJC)");
	}

	@Test
	void testContainsProposta() {
		this.controlador.cadastrarPL("Aaaaa", 2019, "Bbbbb", "Ccccc", "Ddddd", true);
		this.controlador.cadastrarPLP("Aaaaa", 2017, "Bbbbb", "Ccccc", "Ddddd", "Eeeee");
		this.controlador.cadastrarPEC("Kkkkk", 2017, "Lllll", "Mmmmm", "Nnnnn", "Ooooo");

		assertTrue(this.controlador.containsProposta("PL 1/2019"));
		assertFalse(this.controlador.containsProposta("PL 2/2019"));
		assertTrue(this.controlador.containsProposta("PLP 1/2017"));
		assertFalse(this.controlador.containsProposta("PLP 2/2017"));
		assertTrue(this.controlador.containsProposta("PEC 1/2017"));
		assertFalse(this.controlador.containsProposta("PEC 2/2017"));
	}

	@Test
	void testGetLocal() {
		this.controlador.cadastrarPL("Aaaaa", 2019, "Bbbbb", "Ccccc", "Ddddd", true);
		this.controlador.cadastrarPLP("Aaaaa", 2017, "Bbbbb", "Ccccc", "Ddddd", "Eeeee");
		this.controlador.cadastrarPEC("Kkkkk", 2017, "Lllll", "Mmmmm", "Nnnnn", "Ooooo");

		assertEquals(this.controlador.getLocal("PL 1/2019"), "CCJC");
		assertEquals(this.controlador.getLocal("PLP 1/2017"), "CCJC");
		assertEquals(this.controlador.getLocal("PEC 1/2017"), "CCJC");
	}

	@Test
	void testGetListaDeInteresses() {
		this.controlador.cadastrarPL("Aaaaa", 2019, "Bbbbb", "Ccccc", "Ddddd", true);
		this.controlador.cadastrarPLP("Aaaaa", 2017, "Bbbbb", "Ccccc", "Ddddd", "Eeeee");
		this.controlador.cadastrarPEC("Kkkkk", 2017, "Lllll", "Mmmmm", "Nnnnn", "Ooooo");

		assertEquals(this.controlador.getListaDeInteresses("PL 1/2019").toString(), "[Ccccc]");
		assertEquals(this.controlador.getListaDeInteresses("PLP 1/2017").toString(), "[Ccccc]");
		assertEquals(this.controlador.getListaDeInteresses("PEC 1/2017").toString(), "[Mmmmm]");
	}

	@Test
	void testGetAutor() {
		this.controlador.cadastrarPL("Aaaaa", 2019, "Bbbbb", "Ccccc", "Ddddd", true);
		this.controlador.cadastrarPLP("Aaaaa", 2017, "Bbbbb", "Ccccc", "Ddddd", "Eeeee");
		this.controlador.cadastrarPEC("Kkkkk", 2017, "Lllll", "Mmmmm", "Nnnnn", "Ooooo");

		assertEquals(this.controlador.getAutor("PL 1/2019"), "Aaaaa");
		assertEquals(this.controlador.getAutor("PLP 1/2017"), "Aaaaa");
		assertEquals(this.controlador.getAutor("PEC 1/2017"), "Kkkkk");
	}

	@Test
	void testExibeTramitacao() {
		this.controlador.cadastrarPL("Aaaaa", 2019, "Bbbbb", "Ccccc", "Ddddd", true);
		this.controlador.cadastrarPLP("Aaaaa", 2017, "Bbbbb", "Ccccc", "Ddddd", "Eeeee");
		this.controlador.cadastrarPEC("Kkkkk", 2017, "Lllll", "Mmmmm", "Nnnnn", "Ooooo");

		assertEquals(this.controlador.exibeTramitacao("PL 1/2019"), "EM VOTACAO (CCJC)");
		assertEquals(this.controlador.exibeTramitacao("PLP 1/2017"), "EM VOTACAO (CCJC)");
		assertEquals(this.controlador.exibeTramitacao("PEC 1/2017"), "EM VOTACAO (CCJC)");
		assertThrows(IllegalArgumentException.class, () -> this.controlador.exibeTramitacao("PL 2/2019"));
	}
}
