package testesDeUnidade;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entidades.Pessoa;

class PessoaTest {
	Pessoa pessoa, pessoa2;

	@BeforeEach
	void IniciaPessoa() {
		pessoa = new Pessoa("Nome", "011111111-0", "PB", "educacao,seguranca publica,saude");
		pessoa2 = new Pessoa("Jay", "011111111-0", "MG", "interesses", "ABC");
	}

	@Test
	void testPessoaStringStringStringString() {
		Pessoa pessoa2 = new Pessoa("Nome", "011111111-0", "PB", "educacao,seguranca publica,saude");
		assertEquals(this.pessoa.getNome(), pessoa2.getNome());
		assertEquals(this.pessoa.getDni(), pessoa2.getDni());
		assertEquals(this.pessoa.getEstado(), pessoa2.getEstado());
		assertEquals(this.pessoa.getInteresses(), pessoa2.getInteresses());
	}

	@Test
	void testPessoaStringStringStringStringString() {
		Pessoa pessoa3 = new Pessoa("Jay", "011111111-0", "MG", "interesses", "ABC");
		assertEquals(this.pessoa2.getNome(), pessoa3.getNome());
		assertEquals(this.pessoa2.getDni(), pessoa3.getDni());
		assertEquals(this.pessoa2.getEstado(), pessoa3.getEstado());
		assertEquals(this.pessoa2.getInteresses(), pessoa3.getInteresses());
		assertEquals(this.pessoa2.getPartido(), pessoa3.getPartido());
	}

	@Test
	void testToString() {
		assertEquals("Jay - 011111111-0 (MG) - ABC - Interesses: interesses", pessoa2.exibir());

	}

}
