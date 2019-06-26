package testesDeUnidade;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controladores.ControladorDePessoasEDeputados;
import entidades.Deputado;

class ControladorDePessoasEDeputadosTest {
	private ControladorDePessoasEDeputados controladorPessoaDeputado;

	@BeforeEach
	void iniciaControladorPessoaDeputado() {
		this.controladorPessoaDeputado = new ControladorDePessoasEDeputados();
	}

	@Test
	void testCadastrarPessoa() { 
		assertThrows(IllegalArgumentException.class, () -> controladorPessoaDeputado.cadastrarPessoa("", "011111111-0",
				"PB", "educacao,seguranca publica,saude"));
		assertThrows(IllegalArgumentException.class, () -> controladorPessoaDeputado.cadastrarPessoa(null,
				"011111111-0", "PB", "educacao,seguranca publica,saude"));
		assertThrows(IllegalArgumentException.class, () -> controladorPessoaDeputado.cadastrarPessoa("Marina", "", "PB",
				"educacao,seguranca publica,saude"));
		assertThrows(IllegalArgumentException.class, () -> controladorPessoaDeputado.cadastrarPessoa("Marina", null,
				"PB", "educacao,seguranca publica,saude"));
		assertThrows(IllegalArgumentException.class, () -> controladorPessoaDeputado.cadastrarPessoa("Marina",
				"011111111-0", "", "educacao,seguranca publica,saude"));
		assertThrows(IllegalArgumentException.class, () -> controladorPessoaDeputado.cadastrarPessoa("Marina",
				"011111111-0", null, "educacao,seguranca publica,saude"));
		assertThrows(IllegalArgumentException.class, () -> controladorPessoaDeputado.cadastrarPessoa("", "1111111111-A",
				"PB", "educacao,seguranca publica,saude"));
		assertThrows(IllegalArgumentException.class, () -> controladorPessoaDeputado.cadastrarPessoa("Marina",
				".111111111-0", "PB", "educacao,seguranca publica,saude"));
		controladorPessoaDeputado.cadastrarPessoa("Marina", "011111111-0", "PB", "educacao,seguranca publica,saude");
		assertThrows(IllegalArgumentException.class, () -> controladorPessoaDeputado.cadastrarPessoa("Jose",
				"011111111-0", "PB", "educacao,seguranca publica,saude"));
	}

	@Test
	void testCadastrarPessoaComPartido() {
		assertThrows(IllegalArgumentException.class, () -> controladorPessoaDeputado.cadastrarPessoaComPartido("",
				"011111111-0", "PB", "educacao,seguranca publica,saude", "PMD"));
		assertThrows(IllegalArgumentException.class, () -> controladorPessoaDeputado.cadastrarPessoaComPartido(null,
				"011111111-0", "PB", "educacao,seguranca publica,saude", "PMD"));
		assertThrows(IllegalArgumentException.class, () -> controladorPessoaDeputado.cadastrarPessoaComPartido("Marina",
				"", "PB", "educacao,seguranca publica,saude", "PMD"));
		assertThrows(IllegalArgumentException.class, () -> controladorPessoaDeputado.cadastrarPessoaComPartido("Marina",
				null, "PB", "educacao,seguranca publica,saude", "PMD"));
		assertThrows(IllegalArgumentException.class, () -> controladorPessoaDeputado.cadastrarPessoaComPartido("Marina",
				"011111111-0", "", "educacao,seguranca publica,saude", "PMD"));
		assertThrows(IllegalArgumentException.class, () -> controladorPessoaDeputado.cadastrarPessoaComPartido("Marina",
				"011111111-0", null, "educacao,seguranca publica,saude", "PMD"));
		assertThrows(IllegalArgumentException.class, () -> controladorPessoaDeputado.cadastrarPessoaComPartido("",
				"1111111111-A", "PB", "educacao,seguranca publica,saude", "PMD"));
		assertThrows(IllegalArgumentException.class, () -> controladorPessoaDeputado.cadastrarPessoaComPartido("Marina",
				".111111111-0", "PB", "educacao,seguranca publica,saude", "PMD"));
		controladorPessoaDeputado.cadastrarPessoaComPartido("Marina", "011111111-0", "PB",
				"educacao,seguranca publica,saude", "PMD");
		assertThrows(IllegalArgumentException.class, () -> controladorPessoaDeputado.cadastrarPessoaComPartido("Jose",
				"011111111-0", "PB", "educacao,seguranca publica,saude", "PMD"));
	}

	@Test
	void testExibirPessoa() {
		assertThrows(IllegalArgumentException.class, () -> controladorPessoaDeputado.exibirPessoa(""));
		assertThrows(IllegalArgumentException.class, () -> controladorPessoaDeputado.exibirPessoa(null));
		assertThrows(IllegalArgumentException.class, () -> controladorPessoaDeputado.exibirPessoa("1111111111-A"));
		assertThrows(IllegalArgumentException.class, () -> controladorPessoaDeputado.exibirPessoa("011111122-0"));
		
		controladorPessoaDeputado.cadastrarPessoa("Maria", "011111111-0", "PB", "saude, educacao");
		assertEquals("Maria - 011111111-0 (PB) - Interesses: saude, educacao",
				controladorPessoaDeputado.exibirPessoa("011111111-0"));
		
		controladorPessoaDeputado.cadastrarPessoaComPartido("Maria", "011111113-0", "PB", "saude, educacao", "PPP");
		assertEquals("Maria - 011111113-0 (PB) - PPP - Interesses: saude, educacao", controladorPessoaDeputado.exibirPessoa("011111113-0"));

		controladorPessoaDeputado.cadastrarDeputado("011111113-0", "30012012");
		assertEquals("POL: Maria - 011111113-0 (PB) - PPP - Interesses: saude, educacao - 30/01/2012 - 0 Leis", controladorPessoaDeputado.exibirPessoa("011111113-0"));
		
	}
	
	@Test
	void getDeputadpTest() {
		controladorPessoaDeputado.cadastrarPessoaComPartido("Maria", "011111111-0", "PB", "saude, educacao", "PPP");
		controladorPessoaDeputado.cadastrarDeputado("011111111-0", "30012012");
		assertEquals(controladorPessoaDeputado.getDeputado("011111111-0").getClass(), Deputado.class);
	}

	@Test
	void testCadastrarDeputado() {
		assertThrows(IllegalArgumentException.class,
				() -> controladorPessoaDeputado.cadastrarDeputado(null, "29022016"));
		assertThrows(IllegalArgumentException.class,
				() -> controladorPessoaDeputado.cadastrarDeputado("", "329022016"));
		assertThrows(IllegalArgumentException.class,
				() -> controladorPessoaDeputado.cadastrarDeputado("011111123-0", ""));
		assertThrows(IllegalArgumentException.class,
				() -> controladorPessoaDeputado.cadastrarDeputado("011111124-0", null));
		assertThrows(IllegalArgumentException.class,
				() -> controladorPessoaDeputado.cadastrarDeputado("1111111111-A", "29022016"));
		controladorPessoaDeputado.cadastrarPessoaComPartido("Maria", "011111112-0", "PB", "saude, educacao", "");
		assertThrows(IllegalArgumentException.class,  () -> controladorPessoaDeputado.cadastrarDeputado("011111112-0", "01012001"));
		
		controladorPessoaDeputado.cadastrarPessoaComPartido("Marina", "011111111-0", "PB",
				"educacao,seguranca publica,saude", "PMD");
		controladorPessoaDeputado.cadastrarDeputado("011111111-0", "29022016");
		// pessoa ja é deputado
		assertThrows(IllegalArgumentException.class,
				() -> controladorPessoaDeputado.cadastrarDeputado("011111111-0", "29022016"));
		controladorPessoaDeputado.cadastrarPessoa("Jorge", "011111151-0", "PB", "saude");
		assertThrows(IllegalArgumentException.class,
				() -> controladorPessoaDeputado.cadastrarDeputado("011111122-0", "29022016"));
		assertThrows(IllegalArgumentException.class,
				() -> controladorPessoaDeputado.cadastrarDeputado("011111151-0", "29022017"));
	}

	@Test
	void testContainsDeputado() {
		controladorPessoaDeputado.cadastrarPessoaComPartido("Marina", "011111111-0", "PB",
				"educacao,seguranca publica,saude", "PMD");
		controladorPessoaDeputado.cadastrarDeputado("011111111-0", "20042016");

		assertTrue(controladorPessoaDeputado.containsDeputado("011111111-0"));
		assertFalse(controladorPessoaDeputado.containsDeputado("011111112-0"));

	}

	@Test
	void testContainsPessoa() {
		controladorPessoaDeputado.cadastrarPessoa("Marina", "011111111-0", "PB", "educacao,seguranca publica,saude");
		assertTrue(controladorPessoaDeputado.containsPessoa("011111111-0"));
		assertFalse(controladorPessoaDeputado.containsPessoa("011111118-0"));
	}
	
	@Test
	void getPartidoTest() {
		controladorPessoaDeputado.cadastrarPessoaComPartido("Maria", "011111111-0", "PB", "saude, educacao", "PPP");
		controladorPessoaDeputado.cadastrarDeputado("011111111-0", "30012012");
		assertEquals(controladorPessoaDeputado.getPartido("011111111-0"), "PPP");
	
		assertThrows(IllegalArgumentException.class, () -> controladorPessoaDeputado.getPartido(""));
		assertThrows(IllegalArgumentException.class, () -> controladorPessoaDeputado.getPartido("01111111A-0"));
		assertThrows(IllegalArgumentException.class, () -> controladorPessoaDeputado.getPartido("011111111-A"));
		assertThrows(IllegalArgumentException.class, () -> controladorPessoaDeputado.getPartido("01111111-0"));
		assertThrows(IllegalArgumentException.class, () -> controladorPessoaDeputado.getPartido("011111111-"));
		assertThrows(IllegalArgumentException.class, () -> controladorPessoaDeputado.getPartido("-0"));
		assertThrows(IllegalArgumentException.class, () -> controladorPessoaDeputado.getPartido("0111111110"));		
	}
	
	@Test
	void getPresentesTest() {
		controladorPessoaDeputado.cadastrarPessoaComPartido("Maria", "011111111-0", "PB", "saude, educacao", "PPP");
		controladorPessoaDeputado.cadastrarDeputado("011111111-0", "30012012");
		
		List<String> deputados = new ArrayList<>();
		deputados.add("011111111-0");

		List<Deputado> objetosDeputado = new ArrayList<>();
		objetosDeputado.add(controladorPessoaDeputado.getDeputado("011111111-0"));
		
		assertEquals(controladorPessoaDeputado.getPresentes(deputados), objetosDeputado);
	}
	
	@Test
	void getListaDeInteressesTest() {
		assertThrows(IllegalArgumentException.class, () -> controladorPessoaDeputado.getListaDeInteresses(""));
		assertThrows(IllegalArgumentException.class, () -> controladorPessoaDeputado.getListaDeInteresses("01111111A-0"));
		assertThrows(IllegalArgumentException.class, () -> controladorPessoaDeputado.getListaDeInteresses("011111111-A"));
		assertThrows(IllegalArgumentException.class, () -> controladorPessoaDeputado.getListaDeInteresses("01111111-0"));
		assertThrows(IllegalArgumentException.class, () -> controladorPessoaDeputado.getListaDeInteresses("011111111-"));
		assertThrows(IllegalArgumentException.class, () -> controladorPessoaDeputado.getListaDeInteresses("-0"));
		assertThrows(IllegalArgumentException.class, () -> controladorPessoaDeputado.getListaDeInteresses("0111111110"));
		
		controladorPessoaDeputado.cadastrarPessoaComPartido("Maria", "011111111-0", "PB", "saude,educacao", "PPP");
		controladorPessoaDeputado.cadastrarDeputado("011111111-0", "30012012");
		
		List<String> interesses = new ArrayList<>();
		interesses.add("saude");
		interesses.add("educacao");
		
		assertEquals(interesses, controladorPessoaDeputado.getListaDeInteresses("011111111-0"));
	}
	
	@Test
	void totalDeDeputadosTest() {
		assertEquals(0, controladorPessoaDeputado.totalDeDeputados());
		
		controladorPessoaDeputado.cadastrarPessoaComPartido("Maria", "011111111-0", "PB", "saude, educacao", "PPP");
		controladorPessoaDeputado.cadastrarDeputado("011111111-0", "30012012");
		
		assertEquals(1, controladorPessoaDeputado.totalDeDeputados());
	}
}