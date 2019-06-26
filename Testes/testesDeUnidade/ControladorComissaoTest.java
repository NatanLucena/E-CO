package testesDeUnidade;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controladores.ControladorDeComissoes;
import entidades.Comissao;
import entidades.Deputado;

public class ControladorComissaoTest {
	private ControladorDeComissoes controladorComissao;

	@BeforeEach
	public void iniciaControladorComissao() {
		controladorComissao = new ControladorDeComissoes();
	}

	@Test
	public void testCadastraComissao() {
		assertThrows(IllegalArgumentException.class, () -> this.controladorComissao.cadastraComissao(""));
		this.controladorComissao.cadastraComissao("Tema");
		assertThrows(IllegalArgumentException.class, () -> this.controladorComissao.cadastraComissao("Tema"));
		
		this.controladorComissao.cadastraComissao("Tema2");
		assertTrue(this.controladorComissao.containsComissao("Tema2"));
		assertFalse(this.controladorComissao.containsComissao("Tema3")); }

	@Test
	public void testContainsComissao() {
		controladorComissao.cadastraComissao("Tema");
		assertTrue(controladorComissao.containsComissao("Tema"));
		assertFalse(controladorComissao.containsComissao("NaoTema"));
	}
	@Test
	public void getComissao() {
		controladorComissao.cadastraComissao("Tema");
		ControladorDeComissoes controladorComissao2 = new ControladorDeComissoes();
		controladorComissao2.cadastraComissao("Tema");
		assertEquals(controladorComissao.getComissao("Tema"), controladorComissao.getComissao("Tema")); 
		}

	@Test
	public void testCadastraIntegrante() {
		controladorComissao.cadastraComissao("Tema");
		Deputado deputado = new Deputado("Jackson", "011111111-0", "PB", "saude, educacao", "DEM", "29022016");
		controladorComissao.cadastraIntegrante("Tema", deputado);
		List<Deputado> deputados = new ArrayList<>();
		deputados.add(deputado);
		
		assertEquals(deputados,this.controladorComissao.getComissao("Tema").getIntegrantes());
		
	}
}
