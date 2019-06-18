package testesDeUnidade;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controladores.ControladorDePessoasEDeputados;

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
		controladorPessoaDeputado.cadastrarPessoa("Maria", "011111111-0", "PB", "saude, educacao");
		assertThrows(IllegalArgumentException.class, () -> controladorPessoaDeputado.exibirPessoa("011111122-0"));
		assertEquals("Maria - 011111111-0 (PB) - Interesses: saude, educacao",
				controladorPessoaDeputado.exibirPessoa("011111111-0"));
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
}