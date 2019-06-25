package testesDeUnidade;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;


import controladores.ControladorDeComissoes;

public class ControladorComissaoTest {
	private ControladorDeComissoes controladorComissao;
	private List<String> politicos;


	@BeforeEach
	void iniciaControladorComissao() {
		controladorComissao = new ControladorDeComissoes();
		politicos=new ArrayList<>();
	}

	@Test
	void testCadastraComissao() {
		politicos.add("Deputado1");
		politicos.add("Deputado2");		
		assertThrows(IllegalArgumentException.class, () -> controladorComissao.cadastraComissao("", politicos));
		
	}

	@Test
	void testContainsComissao() {
		politicos.add("Deputado1");
		politicos.add("Deputado2");	
		controladorComissao.cadastraComissao("Tema", politicos);
		assertTrue(controladorComissao.containsComissao("Tema"));
		assertFalse(controladorComissao.containsComissao("NaoTema")); }

	@Test
	void testGetIntegrantes() {
		politicos.add("Deputado1");
		politicos.add("Deputado2");
		controladorComissao.cadastraComissao("Tema", politicos);
		assertEquals(controladorComissao.getIntegrantes("Tema"),politicos); }
	

}
