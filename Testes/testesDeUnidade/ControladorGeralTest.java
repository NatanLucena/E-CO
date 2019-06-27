package testesDeUnidade;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controladores.ControladorGeral;

public class ControladorGeralTest {
	private ControladorGeral controlador;

	@BeforeEach
	public void iniciaControladorGeral() {
		this.controlador = new ControladorGeral();
	}

	@Test
	public void testCadastrarPessoa() {
		this.controlador.cadastrarPessoa("Jackson", "011111111-0", "PB", "saude, educacao");
		assertEquals("Jackson - 011111111-0 (PB) - Interesses: saude, educacao",
				controlador.exibirPessoa("011111111-0"));
	}

	@Test
	public void testCadastrarPessoaComPartido() {
		this.controlador.cadastrarPessoaComPartido("Jackson", "011111111-0", "PB", "saude, educacao", "DEM");
		assertEquals("Jackson - 011111111-0 (PB) - DEM - Interesses: saude, educacao",
				controlador.exibirPessoa("011111111-0"));
	}

	@Test
	public void testCadastrarDeputado() {
		this.controlador.cadastrarPessoaComPartido("Jose", "011111112-0", "PB", "esporte, educacao", "DEM");
		this.controlador.cadastrarDeputado("011111112-0", "29022016");
		assertEquals("POL: Jose - 011111112-0 (PB) - DEM - Interesses: esporte, educacao - 29/02/2016 - 0 Leis",
				controlador.exibirPessoa("011111112-0"));
	}

	@Test
	public void testExibirPessoa() {
		this.controlador.cadastrarPessoa("Jackson", "011111111-0", "PB", "saude, educacao");
		assertEquals("Jackson - 011111111-0 (PB) - Interesses: saude, educacao",
				controlador.exibirPessoa("011111111-0"));
		this.controlador.cadastrarPessoaComPartido("Jose", "011111112-0", "PB", "esporte, educacao", "DEM");
		assertEquals("Jose - 011111112-0 (PB) - DEM - Interesses: esporte, educacao",
				controlador.exibirPessoa("011111112-0"));
		this.controlador.cadastrarDeputado("011111112-0", "29022016");
		assertEquals("POL: Jose - 011111112-0 (PB) - DEM - Interesses: esporte, educacao - 29/02/2016 - 0 Leis",
				controlador.exibirPessoa("011111112-0"));
	}

	@Test
	void testCadastrarPartido() {
		assertThrows(IllegalArgumentException.class, () -> controlador.cadastrarPartido(""));
		assertThrows(IllegalArgumentException.class, () -> controlador.cadastrarPartido(null));
		this.controlador.cadastrarPartido("DEM");
		assertThrows(IllegalArgumentException.class, () -> controlador.cadastrarPartido("DEM"));
	}

	@Test
	void testExibirBase() {
		this.controlador.cadastrarPartido("Partido1");
		this.controlador.cadastrarPartido("Partido2");
		assertEquals("Partido1,Partido2", this.controlador.exibirBase());

	}

	@Test
	void testCadastraComissao() {
		this.controlador.cadastrarPessoaComPartido("Jose", "051444444-0", "PB", "esporte, educacao", "DEM");
		this.controlador.cadastrarDeputado("051444444-0", "30112000");
		assertThrows(IllegalArgumentException.class, () -> controlador.cadastraComissao("", "051444444-0"));
		assertThrows(IllegalArgumentException.class, () -> controlador.cadastraComissao(null, "051444444-0"));
		assertThrows(IllegalArgumentException.class, () -> controlador.cadastraComissao("Tema1", ""));
		assertThrows(IllegalArgumentException.class, () -> controlador.cadastraComissao("Tema2", null));
		this.controlador.cadastraComissao("Tema", "051444444-0");
		assertThrows(IllegalArgumentException.class, () -> controlador.cadastraComissao("Tema", "051444445-0"));
	}

	@Test
	void testCadastrarPL() {
		this.controlador.cadastrarPessoaComPartido("Jackson", "011111111-0", "PB", "saude, educacao", "DEM");
		this.controlador.cadastrarDeputado("011111111-0", "29022016");

		assertThrows(IllegalArgumentException.class,
				() -> controlador.cadastrarPL("", 2018, "Ementa1", "Interesses1, Interesses2", "Url", false));
		assertThrows(IllegalArgumentException.class,
				() -> controlador.cadastrarPL(null, 2018, "Ementa1", "Interesses1, Interesses2", "Url", false));
		assertThrows(IllegalArgumentException.class, () -> controlador.cadastrarPL(".111111111-0", 2018, "Ementa1",
				"Interesses1, Interesses2", "Url", false));

		assertThrows(IllegalArgumentException.class, () -> controlador.cadastrarPL("011111112-0", 2018, "Ementa1",
				"Interesses1, Interesses2", "Url", false));
		assertThrows(IllegalArgumentException.class,
				() -> controlador.cadastrarPL("011111111-0", 2018, "", "Interesses1, Interesses2", "Url", false));

		assertThrows(IllegalArgumentException.class,
				() -> controlador.cadastrarPL("011111111-0", 2018, null, "Interesses1, Interesses2", "Url", false));
		assertThrows(IllegalArgumentException.class,
				() -> controlador.cadastrarPL("011111111-0", 2018, "Ementa1", "", "Url", false));

		assertThrows(IllegalArgumentException.class,
				() -> controlador.cadastrarPL("011111111-0", 2018, "Ementa1", null, "Url", false));
		assertThrows(IllegalArgumentException.class,
				() -> controlador.cadastrarPL("011111111-0", 2018, "Ementa1", "Interesses1, Interesses2", "", false));

		assertThrows(IllegalArgumentException.class,
				() -> controlador.cadastrarPL("011111111-0", 2018, "Ementa1", "Interesses1, Interesses2", null, false));
		assertThrows(IllegalArgumentException.class, () -> controlador.cadastrarPL("011111111-0", 2020, "Ementa1",
				"Interesses1, Interesses2", "Url", false));
		assertThrows(IllegalArgumentException.class, () -> controlador.cadastrarPL("011111111-0", 1987, "Ementa1",
				"Interesses1, Interesses2", "Url", false));

		this.controlador.cadastrarPL("011111111-0", 2017, "Ementa", "Interesses1,Interesses2", "URL", false);

	}

	@Test
	void testCadastrarPLP() {
		this.controlador.cadastrarPessoaComPartido("Jackson", "011111111-0", "PB", "saude, educacao", "DEM");
		this.controlador.cadastrarDeputado("011111111-0", "29022016");
		assertThrows(IllegalArgumentException.class,
				() -> controlador.cadastrarPLP("", 2017, "Ementa1", "Interesses1,Interesses2", "URL", "Artigos"));
		assertThrows(IllegalArgumentException.class,
				() -> controlador.cadastrarPLP(null, 2017, "Ementa1", "Interesses1,Interesses2", "URL", "Artigos"));
		assertThrows(IllegalArgumentException.class, () -> controlador.cadastrarPLP(".111111111-0", 2017, "Ementa1",
				"Interesses1,Interesses2", "URL", "Artigos"));

		this.controlador.cadastrarPessoaComPartido("Jose", "011111112-0", "PB", "saude, educacao", "DEM");

		assertThrows(IllegalArgumentException.class, () -> controlador.cadastrarPLP("111111113-0", 2017, "Ementa1",
				"Interesses1,Interesses2", "URL", "Artigos"));
		assertThrows(IllegalArgumentException.class, () -> controlador.cadastrarPLP("111111112-0", 2017, "Ementa1",
				"Interesses1,Interesses2", "URL", "Artigos"));

		assertThrows(IllegalArgumentException.class,
				() -> controlador.cadastrarPLP("011111111-0", 2017, "", "Interesses1,Interesses2", "URL", "Artigos"));
		assertThrows(IllegalArgumentException.class,
				() -> controlador.cadastrarPLP("011111111-0", 2017, null, "Interesses1,Interesses2", "URL", "Artigos"));

		assertThrows(IllegalArgumentException.class,
				() -> controlador.cadastrarPLP("111111111-0", 2017, "Ementa1", "", "URL", "Artigos"));
		assertThrows(IllegalArgumentException.class,
				() -> controlador.cadastrarPLP("111111111-0", 2017, "Ementa1", null, "URL", "Artigos"));

		assertThrows(IllegalArgumentException.class, () -> controlador.cadastrarPLP("011111111-0", 2017, "Ementa1",
				"Interesses1,Interesses2", "", "Artigos"));
		assertThrows(IllegalArgumentException.class, () -> controlador.cadastrarPLP("011111111-0", 2017, "Ementa1",
				"Interesses1,Interesses2", null, "Artigos"));

		assertThrows(IllegalArgumentException.class, () -> controlador.cadastrarPLP("011111111-0", 2020, "Ementa1",
				"Interesses1,Interesses2", "URL", "Artigos"));
		assertThrows(IllegalArgumentException.class, () -> controlador.cadastrarPLP("011111111-0", 1987, "Ementa1",
				"Interesses1,Interesses2", "URL", "Artigos"));

		this.controlador.cadastrarPLP("011111111-0", 2017, "Ementa", "Interesses1,Interesses2", "URL", "Artigos");

	}

	@Test
	void testCadastrarPEC() {
		this.controlador.cadastrarPessoaComPartido("Jackson", "011111111-0", "PB", "saude, educacao", "DEM");
		this.controlador.cadastrarDeputado("011111111-0", "29022016");
		assertThrows(IllegalArgumentException.class,
				() -> controlador.cadastrarPEC("", 2017, "Ementa1", "Interesses1,Interesses2", "URL", "Artigos"));
		assertThrows(IllegalArgumentException.class,
				() -> controlador.cadastrarPEC(null, 2017, "Ementa1", "Interesses1,Interesses2", "URL", "Artigos"));
		assertThrows(IllegalArgumentException.class, () -> controlador.cadastrarPEC(".111111111-0", 2017, "Ementa1",
				"Interesses1,Interesses2", "URL", "Artigos"));

		this.controlador.cadastrarPessoaComPartido("Jose", "011111112-0", "PB", "saude, educacao", "DEM");

		assertThrows(IllegalArgumentException.class, () -> controlador.cadastrarPEC("111111113-0", 2017, "Ementa1",
				"Interesses1,Interesses2", "URL", "Artigos"));
		assertThrows(IllegalArgumentException.class, () -> controlador.cadastrarPEC("111111112-0", 2017, "Ementa1",
				"Interesses1,Interesses2", "URL", "Artigos"));

		assertThrows(IllegalArgumentException.class,
				() -> controlador.cadastrarPEC("011111111-0", 2017, "", "Interesses1,Interesses2", "URL", "Artigos"));
		assertThrows(IllegalArgumentException.class,
				() -> controlador.cadastrarPEC("011111111-0", 2017, null, "Interesses1,Interesses2", "URL", "Artigos"));

		assertThrows(IllegalArgumentException.class,
				() -> controlador.cadastrarPEC("111111111-0", 2017, "Ementa1", "", "URL", "Artigos"));
		assertThrows(IllegalArgumentException.class,
				() -> controlador.cadastrarPEC("111111111-0", 2017, "Ementa1", null, "URL", "Artigos"));

		assertThrows(IllegalArgumentException.class, () -> controlador.cadastrarPEC("011111111-0", 2017, "Ementa1",
				"Interesses1,Interesses2", "", "Artigos"));
		assertThrows(IllegalArgumentException.class, () -> controlador.cadastrarPEC("011111111-0", 2017, "Ementa1",
				"Interesses1,Interesses2", null, "Artigos"));

		assertThrows(IllegalArgumentException.class, () -> controlador.cadastrarPEC("011111111-0", 2020, "Ementa1",
				"Interesses1,Interesses2", "URL", "Artigos"));
		assertThrows(IllegalArgumentException.class, () -> controlador.cadastrarPEC("011111111-0", 1987, "Ementa1",
				"Interesses1,Interesses2", "URL", "Artigos"));

		this.controlador.cadastrarPEC("011111111-0", 2017, "Ementa", "Interesses1,Interesses2", "URL", "Artigos");
	}

	@Test
	void testExibirProjeto() {
		this.controlador.cadastrarPessoaComPartido("Jackson", "011111111-0", "PB", "saude, educacao", "DEM");
		this.controlador.cadastrarDeputado("011111111-0", "29022016");
		this.controlador.cadastrarPLP("011111111-0", 2017, "Ementa", "Interesses1,Interesses2", "URL", "Artigos");
		String codigo = this.controlador.cadastrarPLP("011111111-0", 2017, "Ementa", "Interesses1,Interesses2", "URL",
				"Artigos");
		assertEquals("Projeto de Lei Complementar - PLP 2/2017 - 011111111-0 - Ementa - Artigos - EM VOTACAO (CCJC)",
				this.controlador.exibirProjeto(codigo));

		this.controlador.cadastrarPessoaComPartido("Jose", "011111112-0", "PB", "saude, educacao", "PMDB");
		this.controlador.cadastrarDeputado("011111112-0", "30112013");

		this.controlador.cadastrarPEC("011111112-0", 2015, "Ementa", "futebol, saude", "URL", "Artigos");
		this.controlador.cadastrarPL("011111112-0", 2016, "Ementa", "futebol, saude", "URL", false);

		String codigo2 = this.controlador.cadastrarPEC("011111112-0", 2015, "Ementa", "futebol, saude", "URL",
				"Artigos");
		String codigo3 = this.controlador.cadastrarPL("011111112-0", 2016, "Ementa", "futebol, saude", "URL", true);

		assertEquals(
				"Projeto de Emenda Constitucional - PEC 2/2015 - 011111112-0 - Ementa - Artigos - EM VOTACAO (CCJC)",
				this.controlador.exibirProjeto(codigo2));
		assertEquals("Projeto de Lei - PL 2/2016 - 011111112-0 - Ementa - Conclusiva - EM VOTACAO (CCJC)",
				this.controlador.exibirProjeto(codigo3));
	}

	@Test
	void testExibirTramitacao() {
		this.controlador.cadastrarPessoaComPartido("Jackson", "011111111-0", "PB", "saude, educacao", "DEM");
		this.controlador.cadastrarDeputado("011111111-0", "29022016");
		this.controlador.cadastrarPLP("011111111-0", 2017, "Ementa", "Interesses1,Interesses2", "URL", "Artigos");
		String codigo = this.controlador.cadastrarPLP("011111111-0", 2017, "Ementa", "Interesses1,Interesses2", "URL",
				"Artigos");
		assertEquals("EM VOTACAO (CCJC)", this.controlador.exibirTramitacao(codigo));

		assertThrows(IllegalArgumentException.class, () -> controlador.exibirTramitacao(""));
		assertThrows(IllegalArgumentException.class, () -> controlador.exibirTramitacao(null));

	}
	
	@Test
	void testVotarComissao() {
		this.controlador.cadastrarPessoaComPartido("Cayo", "111111111-1", "PE", "saude", "PPP");
		this.controlador.cadastrarPessoaComPartido("Jackson", "222222222-2", "PB", "saude", "PJ");
		this.controlador.cadastrarPessoaComPartido("Leal", "333333333-3", "PB", "saude", "PO");
		this.controlador.cadastrarDeputado("111111111-1", "01012018");
		this.controlador.cadastrarDeputado("222222222-2", "01012018");
		this.controlador.cadastrarDeputado("333333333-3", "01012018");
		this.controlador.cadastraComissao("CCJC", "111111111-1,222222222-2,333333333-3");
		this.controlador.cadastrarPL("333333333-3", 2019, "Ementa", "saude", "aaa.com", true);
		
		assertTrue(this.controlador.votarComissao("PL 1/2019", "GOVERNISTA", "CCJC"));
		
		
		
	}

}
