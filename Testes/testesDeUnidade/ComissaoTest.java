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
		List<String> integrantes2 = new ArrayList<>();
		integrantes2.add("Aaaaa");
		integrantes2.add("Bbbbb");
		integrantes2.add("Ccccc");
		integrantes2.add("Ddddd");
		Comissao comissao2 = new Comissao("Tema", integrantes2);
		assertEquals(comissao2.getTema(), "Tema");
		assertEquals(comissao.getIntegrantes(), comissao2.getIntegrantes());
	}

	@Test
	void testGetTema() {
		assertEquals(comissao.getTema(), "Tema");
	
	}

	@Test
	void testGetIntegrantes() {
		List<String> integrantes2 = new ArrayList<>();
		integrantes2.add("Aaaaa");
		integrantes2.add("Bbbbb");
		integrantes2.add("Ccccc");
		integrantes2.add("Ddddd");
		Comissao comissao2 = new Comissao("Tema", integrantes2);
		assertEquals(comissao.getIntegrantes(), comissao2.getIntegrantes());
	}

}
