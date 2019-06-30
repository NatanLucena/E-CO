package testesDeUnidade;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entidades.Deputado;

class DeputadoTest {
	Deputado deputado;
 
	@BeforeEach
	void iniciaDeputado() {
		deputado = new Deputado("Lucas", "123456789-9", "PB", "saneamento", "PPP", "30112010");

	}

	@Test
	void construtorTest() {
		assertThrows(IllegalArgumentException.class, () -> new Deputado(null, "123456789-0", "PE", "seguranca", "PPP", "30112010"));
		assertThrows(IllegalArgumentException.class, () -> new Deputado("", "123456789-0", "PE", "seguranca", "PPP", "30112010"));
		
		assertThrows(IllegalArgumentException.class, () -> new Deputado("Cayo", null, "PE", "seguranca", "PPP", "30112010"));
		assertThrows(IllegalArgumentException.class, () -> new Deputado("Cayo", "", "PE", "seguranca", "PPP", "30112010"));
		
		assertThrows(IllegalArgumentException.class, () -> new Deputado("Cayo", "0123456789-0", "PE", "seguranca", "PPP", "30112010"));
		assertThrows(IllegalArgumentException.class, () -> new Deputado("Cayo", "A23456789-0", "PE", "seguranca", "PPP", "30112010"));
		
		assertThrows(IllegalArgumentException.class, () -> new Deputado("Cayo", "123456789-0", null, "seguranca", "PPP", "30112010"));
		assertThrows(IllegalArgumentException.class, () -> new Deputado("Cayo", "123456789-0", "", "seguranca", "PPP", "30112010"));
		
		assertThrows(IllegalArgumentException.class, () -> new Deputado("Cayo", "123456789-0", "PE", "seguranca", null, "30112010"));
		assertThrows(IllegalArgumentException.class, () -> new Deputado("Cayo", "123456789-0", "PE", "seguranca", "", "30112010"));
		
		assertThrows(IllegalArgumentException.class, () -> new Deputado("Cayo", "123456789-0", "PE", "seguranca", "PPP", null));
		assertThrows(IllegalArgumentException.class, () -> new Deputado("Cayo", "123456789-0", "PE", "seguranca", "PPP", ""));
		
		assertThrows(IllegalArgumentException.class, () -> new Deputado("Cayo", "123456789-0", "PE", "seguranca", "PPP", "40112010"));
		assertThrows(IllegalArgumentException.class, () -> new Deputado("Cayo", "123456789-0", "PE", "seguranca", "PPP", "30132010"));
		
	}

	@Test
	void getESetLeisAprovadasTest() {
		assertEquals(0, deputado.getLeisAprovadas());
		deputado.setLeisAprovadas();
		assertEquals(1, deputado.getLeisAprovadas());
		
		assertEquals("30/11/2010", deputado.getDataDeInicio());
	}

	@Test
	void exibirTest() {
		assertEquals("POL: Lucas - 123456789-9 (PB) - PPP - Interesses: saneamento - 30/11/2010 - 0 Leis", deputado.exibir());
	}
	

}