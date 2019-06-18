package testesDeUnidade;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entidades.Comissao;

class ComissaoTest {
	private Comissao comissao;
	private List<String> integrantes;
	
	@BeforeEach
	void iniciaComissao() {
		this.integrantes = new ArrayList<>();
		this.integrantes.add("Aaaaa");
		this.integrantes.add("Bbbbb");
		this.integrantes.add("Ccccc");
		this.integrantes.add("Ddddd");
		this.comissao = new Comissao("Tema", this.integrantes);
	}

	@Test
	void testComissao() {
		List<String> integrantes1 = new ArrayList<>();
		integrantes1.add("Aaaaa");
		integrantes1.add("Bbbbb");
		integrantes1.add("Ccccc");
		integrantes1.add("Ddddd");
		Comissao comissao1 = new Comissao("Tema", integrantes1);
		
		assertEquals(comissao1.getTema(), "Tema");
		assertEquals(comissao1.getIntegrantes());
	}

	@Test
	void testGetTema() {
		fail("Not yet implemented");
	}

	@Test
	void testGetIntegrantes() {
		fail("Not yet implemented");
	}

}
