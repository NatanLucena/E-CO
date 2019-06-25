package testesDeUnidade;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entidades.Comissao;
import entidades.Deputado;

class ComissaoTest {
	private Comissao comissao;
	
	@BeforeEach
	void iniciaComissao() {
		this.comissao = new Comissao("Tema");
	}

	@Test
	void testComissao() {
		Comissao comissao2 = new Comissao("Tema");
		assertEquals(comissao2.getTema(), "Tema");
	}

	@Test
	void testGetTema() {
		assertEquals(comissao.getTema(), "Tema");
	
	}
	
	@Test 
	void testCadastraIntegrante() {
		List<Deputado> integrantes = new ArrayList<>();
		Deputado deputado = new Deputado("Jackson", "011111111-0", "PB", "saude, educacao", "DEM", "29022016");
		integrantes.add(deputado);
		this.comissao.cadastraIntegrante(deputado);
		
		assertEquals(integrantes, this.comissao.getIntegrantes());
		
	}

	@Test
	void testGetIntegrantes() {
		List<Deputado> integrantes = new ArrayList<>();
		Deputado deputado = new Deputado("Jackson", "011111111-0", "PB", "saude, educacao", "DEM", "29022016");
		integrantes.add(deputado);
		this.comissao.cadastraIntegrante(deputado);
		
		assertEquals(integrantes, this.comissao.getIntegrantes());
		

	}

}
