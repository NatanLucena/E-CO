package testesDeUnidade;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entidades.Deputado;
import entidades.Pessoa;

class PessoaTest {
	Pessoa pessoa, pessoa1, pessoa2;

	@BeforeEach
	void iniciaPessoa() {
		
		pessoa = new Pessoa("Lucas", "123456789-9", "PB", "saneamento");
		pessoa1= new Pessoa("Lucas", "123456789-9", "PB", "saneamento", "PPP");
		
	}

	@Test
	void construtirTest() {
		assertThrows(IllegalArgumentException.class, () -> new Pessoa(null, "123456789-0", "PE", "seguranca"));
		assertThrows(IllegalArgumentException.class, () -> new Pessoa("", "123456789-0", "PE", "seguranca"));
		
		assertThrows(IllegalArgumentException.class, () -> new Pessoa("Cayo", null, "PE", "seguranca"));
		assertThrows(IllegalArgumentException.class, () -> new Pessoa("Cayo", "", "PE", "seguranca"));
		
		assertThrows(IllegalArgumentException.class, () -> new Pessoa("Cayo", "123456789-0", null, "seguranca"));
		assertThrows(IllegalArgumentException.class, () -> new Pessoa("Cayo", "123456789-0", "", "seguranca"));
		
		assertThrows(IllegalArgumentException.class, () -> new Pessoa("Cayo", "123456789-0", "PE", null));
		assertThrows(IllegalArgumentException.class, () -> new Pessoa("Cayo", "123456789-0", "PE", ""));
		
		
		
		assertThrows(IllegalArgumentException.class, () -> new Pessoa(null, "123456789-0", "PE", "seguranca", "PPP"));
		assertThrows(IllegalArgumentException.class, () -> new Pessoa("", "123456789-0", "PE", "seguranca", "PPP"));
		
		assertThrows(IllegalArgumentException.class, () -> new Pessoa("Cayo", null, "PE", "seguranca", "PPP"));
		assertThrows(IllegalArgumentException.class, () -> new Pessoa("Cayo", "", "PE", "seguranca", "PPP"));
		
		assertThrows(IllegalArgumentException.class, () -> new Pessoa("Cayo", "123456789-0", null, "seguranca", "PPP"));
		assertThrows(IllegalArgumentException.class, () -> new Pessoa("Cayo", "123456789-0", "", "seguranca", "PPP"));
		
		assertThrows(IllegalArgumentException.class, () -> new Pessoa("Cayo", "123456789-0", "PE", null, "PPP"));
		assertThrows(IllegalArgumentException.class, () -> new Pessoa("Cayo", "123456789-0", "PE", "", "PPP"));
		
		assertThrows(IllegalArgumentException.class, () -> new Pessoa("Cayo", "123456789-0", "PE", "seguranca", null));
		assertThrows(IllegalArgumentException.class, () -> new Pessoa("Cayo", "123456789-0", "PE", "seguranca", ""));		

	}

	@Test
	void exibirTest() {
		assertEquals("Lucas - 123456789-9 (PB) - Interesses: saneamento", pessoa.exibir());

	}
	
	@Test
	void getTest() {
		assertEquals(pessoa.getDni(), "123456789-9");
		assertEquals(pessoa.getEstado(), "PB");
		assertEquals(pessoa.getInteresses(), " - Interesses: saneamento");
		assertEquals(pessoa.getInteresses2(), "saneamento");
		assertEquals(pessoa.getNome(), "Lucas");
		assertEquals(pessoa.getPartido(), "");

		assertEquals(pessoa1.getPartido(), " - PPP");
		assertEquals(pessoa1.getPartido2(), "PPP");
		
		List<String> interesses = new ArrayList<>();
		interesses.add("saneamento");
		assertEquals(pessoa.getListaDeInteresses(), interesses);
	}

}