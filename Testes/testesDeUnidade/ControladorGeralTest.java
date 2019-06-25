package testesDeUnidade;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import controladores.ControladorGeral;

public class ControladorGeralTest {
	private ControladorGeral controlador;

	@BeforeEach
	void iniciaControladorGeral() {
		controlador = new ControladorGeral();
	}
	
	@Test
	void testCadastrarPessoa() {
		controlador.cadastrarPessoa("Jackson", "011111111-0", "PB", "saude, educacao");
		assertEquals("", controlador.exibirPessoa("011111111-0")); 
		}

	@Test
	void testCadastrarPessoaComPartido() {
		controlador.cadastrarPessoaComPartido("Jackson", "011111111-0", "PB", "saude, educacao", "DEM");
		assertEquals("", controlador.exibirPessoa("011111111-0")); }

	
	@Test
	void testCadastrarDeputado() {
		controlador.cadastrarPessoaComPartido("Jose", "011111112-0", "PB", "esporte, educacao", "DEM");
		controlador.cadastrarDeputado("011111112-0", "29022016");
		assertEquals("", controlador.exibirPessoa("011111111-0"));  }
	
	@Test
	void testExibirPessoa() {
		controlador.cadastrarPessoa("Jackson", "011111111-0", "PB", "saude, educacao");
		assertEquals("", controlador.exibirPessoa("011111111-0")); 
		controlador.cadastrarPessoaComPartido("Jose", "011111112-0", "PB", "esporte, educacao", "DEM");
		assertEquals("", controlador.exibirPessoa("011111112-0"));
		controlador.cadastrarDeputado("011111112-0", "29022016");
		assertEquals("", controlador.exibirPessoa("011111112-0"));  }

		

	/**
	@Test
	void testCadastrarPartido() {
		fail("Not yet implemented");
	}

	@Test
	void testExibirBase() {
		fail("Not yet implemented");
	}

	@Test
	void testCadastraComissao() {
		fail("Not yet implemented");
	}

	@Test
	void testCadastrarPL() {
		fail("Not yet implemented");
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
	void testVotarComissao() {
		fail("Not yet implemented");
	}

	@Test
	void testVotarPlenario() {
		fail("Not yet implemented");
	}

	@Test
	void testExibirTramitacao() {
		fail("Not yet implemented");
	}*/

}
