package testesDeUnidade;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entidades.PropostaLegislativa;

class PropostaLegislativaTest {
	PropostaLegislativa proposta;
	
	@BeforeEach
	void iniciaPropostaLegislativa() {
		proposta = new PropostaLegislativa("123456789-0", 2010, "codigo", "ementa", "educacao", "url");
	}
	
	@Test
	void construtorTest() {
//		assertThrows(IllegalArgumentException.class, () -> new PropostaLegislativa("123456789-0", 2010, "codigo", "ementa", "educacao", "url"));
		
		assertThrows(IllegalArgumentException.class, () -> new PropostaLegislativa("A23456789-0", 2010, "codigo", "ementa", "educacao", "url"));
		assertThrows(IllegalArgumentException.class, () -> new PropostaLegislativa("123456789-A", 2010, "codigo", "ementa", "educacao", "url"));
		assertThrows(IllegalArgumentException.class, () -> new PropostaLegislativa("12345678-0", 2010, "codigo", "ementa", "educacao", "url"));
		assertThrows(IllegalArgumentException.class, () -> new PropostaLegislativa("123456789-", 2010, "codigo", "ementa", "educacao", "url"));
		assertThrows(IllegalArgumentException.class, () -> new PropostaLegislativa("1234567890", 2010, "codigo", "ementa", "educacao", "url"));
		assertThrows(IllegalArgumentException.class, () -> new PropostaLegislativa(null, 2010, "codigo", "ementa", "educacao", "url"));
		assertThrows(IllegalArgumentException.class, () -> new PropostaLegislativa("", 2010, "codigo", "ementa", "educacao", "url"));
		
		assertThrows(IllegalArgumentException.class, () -> new PropostaLegislativa("123456789-0", 2010, null, "ementa", "educacao", "url"));
		assertThrows(IllegalArgumentException.class, () -> new PropostaLegislativa("123456789-0", 2010, "", "ementa", "educacao", "url"));
		
		assertThrows(IllegalArgumentException.class, () -> new PropostaLegislativa("123456789-0", 2010, "codigo", null, "educacao", "url"));
		assertThrows(IllegalArgumentException.class, () -> new PropostaLegislativa("123456789-0", 2010, "codigo", "", "educacao", "url"));
		
		assertThrows(IllegalArgumentException.class, () -> new PropostaLegislativa("123456789-0", 2010, "codigo", "ementa", null, "url"));
		assertThrows(IllegalArgumentException.class, () -> new PropostaLegislativa("123456789-0", 2010, "codigo", "ementa", "", "url"));
		
		assertThrows(IllegalArgumentException.class, () -> new PropostaLegislativa("123456789-0", 2010, "codigo", "ementa", "educacao", null));
		assertThrows(IllegalArgumentException.class, () -> new PropostaLegislativa("123456789-0", 2010, "codigo", "ementa", "educacao", ""));
	}
	
	@Test
	void getESetTest() {
		assertEquals(proposta.getAutor(), "123456789-0");
		assertEquals(proposta.getAno(), 2010);
		assertEquals(proposta.getCodigo(), "codigo");
		assertEquals(proposta.getEmenta(), "ementa");
		assertEquals(proposta.getInteresses(),"educacao");
		assertEquals(proposta.getURL(), "url");
		
		List<String> interesses = new ArrayList<>();
		interesses.add("educacao");

		List<String> tramitacao = new ArrayList<>();
		tramitacao.add("EM VOTACAO (CCJC)");
		
		assertEquals(proposta.getListaDeInteresses(), interesses);
		assertEquals(proposta.getListaTramitacao(), tramitacao);
		assertEquals(proposta.getLocal(), "CCJC");
		assertEquals(proposta.getSituacao(), "EM VOTACAO (CCJC)");
		assertEquals(proposta.getTramitacao(), "EM VOTACAO (CCJC)");
		
		
		
	}
	
	
	
	
	
	
	
	
	

//	@Test
//	void testPropostaLegislativa() {
//		PropostaLegislativa proposta1 = new PropostaLegislativa("Aaaaa", 2019, "Bbbbb", "Ccccc", "Ddddd", "Eeeee");
//		PropostaLegislativa proposta2 = new PropostaLegislativa("Fffff", 2018, "Ggggg", "Hhhhh", "Iiiii", "Jjjjj");
//		PropostaLegislativa proposta3 = new PropostaLegislativa("Kkkkk", 2017, "Lllll", "Mmmmm", "Nnnnn", "Ooooo");
//
//		assertEquals(proposta1.getAutor(), "Aaaaa");
//		assertEquals(proposta1.getAno(), 2019);
//		assertEquals(proposta1.getCodigo(), "Bbbbb");
//		assertEquals(proposta1.getEmenta(), "Ccccc");
//		assertEquals(proposta1.getInteresses(), "Ddddd");
//		assertEquals(proposta1.getURL(), "Eeeee");
//		assertEquals(proposta2.getAutor(), "Fffff");
//		assertEquals(proposta2.getAno(), 2018);
//		assertEquals(proposta2.getCodigo(), "Ggggg");
//		assertEquals(proposta2.getEmenta(), "Hhhhh");
//		assertEquals(proposta2.getInteresses(), "Iiiii");
//		assertEquals(proposta2.getURL(), "Jjjjj");
//		assertEquals(proposta3.getAutor(), "Kkkkk");
//		assertEquals(proposta3.getAno(), 2017);
//		assertEquals(proposta3.getCodigo(), "Lllll");
//		assertEquals(proposta3.getEmenta(), "Mmmmm");
//		assertEquals(proposta3.getInteresses(), "Nnnnn");
//		assertEquals(proposta3.getURL(), "Ooooo");
//	}
//
//	@Test
//	void testGetSituacao() {
//		PropostaLegislativa proposta1 = new PropostaLegislativa("Aaaaa", 2019, "Bbbbb", "Ccccc", "Ddddd", "Eeeee");
//		PropostaLegislativa proposta2 = new PropostaLegislativa("Fffff", 2018, "Ggggg", "Hhhhh", "Iiiii", "Jjjjj");
//		PropostaLegislativa proposta3 = new PropostaLegislativa("Kkkkk", 2017, "Lllll", "Mmmmm", "Nnnnn", "Ooooo");
//
//		assertEquals(proposta1.getSituacao(), "EM VOTACAO (CCJC)");
//		assertEquals(proposta2.getSituacao(), "EM VOTACAO (CCJC)");
//		assertEquals(proposta3.getSituacao(), "EM VOTACAO (CCJC)");
//	}
//
//	@Test
//	void testSetSituacao() {
//		PropostaLegislativa proposta1 = new PropostaLegislativa("Aaaaa", 2019, "Bbbbb", "Ccccc", "Ddddd", "Eeeee");
//		PropostaLegislativa proposta2 = new PropostaLegislativa("Fffff", 2018, "Ggggg", "Hhhhh", "Iiiii", "Jjjjj");
//		PropostaLegislativa proposta3 = new PropostaLegislativa("Kkkkk", 2017, "Lllll", "Mmmmm", "Nnnnn", "Ooooo");
//		proposta1.setSituacao("ARQUIVADO");
//		proposta2.setSituacao("ARQUIVADO");
//		proposta3.setSituacao("ARQUIVADO");
//
//		assertEquals(proposta1.getSituacao(), "ARQUIVADO");
//		assertEquals(proposta2.getSituacao(), "ARQUIVADO");
//		assertEquals(proposta3.getSituacao(), "ARQUIVADO");
//	}
//
//	@Test
//	void testGetLocal() {
//		PropostaLegislativa proposta1 = new PropostaLegislativa("Aaaaa", 2019, "Bbbbb", "Ccccc", "Ddddd", "Eeeee");
//		PropostaLegislativa proposta2 = new PropostaLegislativa("Fffff", 2018, "Ggggg", "Hhhhh", "Iiiii", "Jjjjj");
//		PropostaLegislativa proposta3 = new PropostaLegislativa("Kkkkk", 2017, "Lllll", "Mmmmm", "Nnnnn", "Ooooo");
//
//		assertEquals(proposta1.getLocal(), "CCJC");
//		assertEquals(proposta2.getLocal(), "CCJC");
//		assertEquals(proposta3.getLocal(), "CCJC");
//	}
//
//	@Test
//	void testSetLocal() {
//		PropostaLegislativa proposta1 = new PropostaLegislativa("Aaaaa", 2019, "Bbbbb", "Ccccc", "Ddddd", "Eeeee");
//		PropostaLegislativa proposta2 = new PropostaLegislativa("Fffff", 2018, "Ggggg", "Hhhhh", "Iiiii", "Jjjjj");
//		PropostaLegislativa proposta3 = new PropostaLegislativa("Kkkkk", 2017, "Lllll", "Mmmmm", "Nnnnn", "Ooooo");
//		proposta1.setLocal("Aaaaa");
//		proposta2.setLocal("Aaaaa");
//		proposta3.setLocal("Aaaaa");
//
//		assertEquals(proposta1.getLocal(), "Aaaaa");
//		assertEquals(proposta2.getLocal(), "Aaaaa");
//		assertEquals(proposta3.getLocal(), "Aaaaa");
//	}

}
