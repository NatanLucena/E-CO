package testesDeUnidade;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controladores.ControladorGeral;

public class ControladorGeralTest {
	private ControladorGeral controlador;

	@BeforeEach
	public void iniciaControladorGeral() {
		controlador = new ControladorGeral();
	}
	
	@Test
	public void testCadastrarPessoa() {
		controlador.cadastrarPessoa("Jackson", "011111111-0", "PB", "saude, educacao");
		assertEquals("Jackson - 011111111-0 (PB) - Interesses: saude, educacao", controlador.exibirPessoa("011111111-0")); 
		}

	@Test
	public void testCadastrarPessoaComPartido() {
		controlador.cadastrarPessoaComPartido("Jackson", "011111111-0", "PB", "saude, educacao", "DEM");
		assertEquals("Jackson - 011111111-0 (PB) - DEM - Interesses: saude, educacao", controlador.exibirPessoa("011111111-0")); }

	
	@Test
	public void testCadastrarDeputado() {
		controlador.cadastrarPessoaComPartido("Jose", "011111112-0", "PB", "esporte, educacao", "DEM");
		controlador.cadastrarDeputado("011111112-0", "29022016");
		assertEquals("POL: Jose - 011111112-0 (PB) - DEM - Interesses: esporte, educacao - 29/02/2016 - 0 Leis", controlador.exibirPessoa("011111112-0"));  }
	
	@Test
	public void testExibirPessoa() {
		controlador.cadastrarPessoa("Jackson", "011111111-0", "PB", "saude, educacao");
		assertEquals("Jackson - 011111111-0 (PB) - Interesses: saude, educacao", controlador.exibirPessoa("011111111-0")); 
		controlador.cadastrarPessoaComPartido("Jose", "011111112-0", "PB", "esporte, educacao", "DEM");
		assertEquals("Jose - 011111112-0 (PB) - DEM - Interesses: esporte, educacao", controlador.exibirPessoa("011111112-0"));
		controlador.cadastrarDeputado("011111112-0", "29022016");
		assertEquals("POL: Jose - 011111112-0 (PB) - DEM - Interesses: esporte, educacao - 29/02/2016 - 0 Leis", controlador.exibirPessoa("011111112-0"));  }

		
	
	@Test
	void testCadastrarPartido() {
		assertThrows(IllegalArgumentException.class, () -> controlador.cadastrarPartido(""));
		assertThrows(IllegalArgumentException.class, () -> controlador.cadastrarPartido(null));
		this.controlador.cadastrarPartido("DEM");
		assertThrows(IllegalArgumentException.class, () -> controlador.cadastrarPartido("DEM")); }
	@Test
	void testExibirBase() {
		this.controlador.cadastrarPartido("Partido1");
		this.controlador.cadastrarPartido("Partido2");
		assertEquals("Partido1,Partido2", this.controlador.exibirBase());
		
	}

	@Test
	void testCadastraComissao() {
		assertThrows(IllegalArgumentException.class, () -> controlador.cadastraComissao("", "Politico1,Politico2"));
		assertThrows(IllegalArgumentException.class, () -> controlador.cadastraComissao(null, "Politico1,Politico2"));
		assertThrows(IllegalArgumentException.class, () -> controlador.cadastraComissao("Tema1", ""));
		assertThrows(IllegalArgumentException.class, () -> controlador.cadastraComissao("Tema2", null));	
		this.controlador.cadastraComissao("Tema1", "Politico1,Politico2");
		assertThrows(IllegalArgumentException.class, () -> controlador.cadastraComissao("Tema1", "Politico1,Politico2")); }
	

	@Test
	void testCadastrarPL() {
		controlador.cadastrarPessoaComPartido("Jackson", "011111111-0", "PB", "saude, educacao", "DEM");
		controlador.cadastrarDeputado("011111111-0", "29022016");
		assertThrows(IllegalArgumentException.class, () -> controlador.cadastrarPL("", 2018, "Ementa1", "Interesses1, Interesses2", "Url", false));
		assertThrows(IllegalArgumentException.class, () -> controlador.cadastrarPL(null, 2018, "Ementa1", "Interesses1, Interesses2", "Url", false));
		assertThrows(IllegalArgumentException.class, () -> controlador.cadastrarPL("Jose", 2018, "Ementa1", "Interesses1, Interesses2", "Url", false));
		assertThrows(IllegalArgumentException.class, () -> controlador.cadastrarPL("Jackson", 2018, "", "Interesses1, Interesses2", "Url", false));
		assertThrows(IllegalArgumentException.class, () -> controlador.cadastrarPL("Jackson", 2018, null, "Interesses1, Interesses2", "Url", false));
		assertThrows(IllegalArgumentException.class, () -> controlador.cadastrarPL("Jackson", 2018, "Ementa1", "", "Url", false));
		assertThrows(IllegalArgumentException.class, () -> controlador.cadastrarPL("Jackson", 2018, "Ementa1", null, "Url", false));
		assertThrows(IllegalArgumentException.class, () -> controlador.cadastrarPL("Jackson", 2018, "Ementa1", "Interesses1, Interesses2", "", false));
		assertThrows(IllegalArgumentException.class, () -> controlador.cadastrarPL("Jackson", 2018, "Ementa1", "Interesses1, Interesses2", null, false));
		assertThrows(IllegalArgumentException.class, () -> controlador.cadastrarPL("Jackson", 2020, "Ementa1", "Interesses1, Interesses2", "Url", false));
		assertThrows(IllegalArgumentException.class, () -> controlador.cadastrarPL("Jackson", 1987, "Ementa1", "Interesses1, Interesses2", "Url", false));
		controlador.cadastrarPessoaComPartido("Jackson", "011111111-0", "PB", "saude, educacao", "DEM");
		controlador.cadastrarDeputado("011111111-0", "29022016");
		assertThrows(IllegalArgumentException.class, () -> controlador.cadastrarPL("Jackson", 2018, "Ementa1", "Interesses1, Interesses2", "Url", false));
	
	}
	/**
	@Test
	void testCadastrarPLP() {
		controlador.cadastrarPessoaComPartido("Jackson", "011111111-0", "PB", "saude, educacao", "DEM");
		controlador.cadastrarDeputado("011111111-0", "29022016");
		assertThrows(IllegalArgumentException.class, () -> controlador.cadastrarPLP("", 2017, "Ementa1", "Interesses1,Interesses2", "URL", "Artigos"));
		assertThrows(IllegalArgumentException.class, () -> controlador.cadastrarPLP(null, 2017, "Ementa1", "Interesses1,Interesses2", "URL", "Artigos"));
		
		assertThrows(IllegalArgumentException.class, () -> controlador.cadastrarPLP("Jose", 2018, "Ementa1", "Interesses1, Interesses2", "Url", "Artigos"));
		assertThrows(IllegalArgumentException.class, () -> controlador.cadastrarPL("Jackson", 2018, "", "Interesses1, Interesses2", "Url", "Artigos"));
		assertThrows(IllegalArgumentException.class, () -> controlador.cadastrarPL("Jackson", 2018, null, "Interesses1, Interesses2", "Url", "Artigos"));
		assertThrows(IllegalArgumentException.class, () -> controlador.cadastrarPL("Jackson", 2018, "Ementa1", "", "Url", false));
		assertThrows(IllegalArgumentException.class, () -> controlador.cadastrarPL("Jackson", 2018, "Ementa1", null, "Url", false));
		assertThrows(IllegalArgumentException.class, () -> controlador.cadastrarPL("Jackson", 2018, "Ementa1", "Interesses1, Interesses2", "", "Artigos"));
		assertThrows(IllegalArgumentException.class, () -> controlador.cadastrarPL("Jackson", 2018, "Ementa1", "Interesses1, Interesses2", null, "Artigos"));
		assertThrows(IllegalArgumentException.class, () -> controlador.cadastrarPL("Jackson", 2020, "Ementa1", "Interesses1, Interesses2", "Url", "Artigos"));
		assertThrows(IllegalArgumentException.class, () -> controlador.cadastrarPL("Jackson", 1987, "Ementa1", "Interesses1, Interesses2", "Url", "Artigos"));		
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
