package testesDeUnidade;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import entidades.PropostaLegislativa;

class PropostaLegislativaTest {

	@Test
	void testPropostaLegislativa() {
		PropostaLegislativa proposta1 = new PropostaLegislativa("Aaaaa", 2019, "Bbbbb", "Ccccc", "Ddddd", "Eeeee");
		PropostaLegislativa proposta2 = new PropostaLegislativa("Fffff", 2018, "Ggggg", "Hhhhh", "Iiiii", "Jjjjj");
		PropostaLegislativa proposta3 = new PropostaLegislativa("Kkkkk", 2017, "Lllll", "Mmmmm", "Nnnnn", "Ooooo");

		assertEquals(proposta1.getAutor(), "Aaaaa");
		assertEquals(proposta1.getAno(), 2019);
		assertEquals(proposta1.getCodigo(), "Bbbbb");
		assertEquals(proposta1.getEmenta(), "Ccccc");
		assertEquals(proposta1.getInteresses(), "Ddddd");
		assertEquals(proposta1.getURL(), "Eeeee");
		assertEquals(proposta2.getAutor(), "Fffff");
		assertEquals(proposta2.getAno(), 2018);
		assertEquals(proposta2.getCodigo(), "Ggggg");
		assertEquals(proposta2.getEmenta(), "Hhhhh");
		assertEquals(proposta2.getInteresses(), "Iiiii");
		assertEquals(proposta2.getURL(), "Jjjjj");
		assertEquals(proposta3.getAutor(), "Kkkkk");
		assertEquals(proposta3.getAno(), 2017);
		assertEquals(proposta3.getCodigo(), "Lllll");
		assertEquals(proposta3.getEmenta(), "Mmmmm");
		assertEquals(proposta3.getInteresses(), "Nnnnn");
		assertEquals(proposta3.getURL(), "Ooooo");
	}

	@Test
	void testGetSituacao() {
		PropostaLegislativa proposta1 = new PropostaLegislativa("Aaaaa", 2019, "Bbbbb", "Ccccc", "Ddddd", "Eeeee");
		PropostaLegislativa proposta2 = new PropostaLegislativa("Fffff", 2018, "Ggggg", "Hhhhh", "Iiiii", "Jjjjj");
		PropostaLegislativa proposta3 = new PropostaLegislativa("Kkkkk", 2017, "Lllll", "Mmmmm", "Nnnnn", "Ooooo");

		assertEquals(proposta1.getSituacao(), "EM VOTACAO (CCJC)");
		assertEquals(proposta2.getSituacao(), "EM VOTACAO (CCJC)");
		assertEquals(proposta3.getSituacao(), "EM VOTACAO (CCJC)");
	}

	@Test
	void testSetSituacao() {
		PropostaLegislativa proposta1 = new PropostaLegislativa("Aaaaa", 2019, "Bbbbb", "Ccccc", "Ddddd", "Eeeee");
		PropostaLegislativa proposta2 = new PropostaLegislativa("Fffff", 2018, "Ggggg", "Hhhhh", "Iiiii", "Jjjjj");
		PropostaLegislativa proposta3 = new PropostaLegislativa("Kkkkk", 2017, "Lllll", "Mmmmm", "Nnnnn", "Ooooo");
		proposta1.setSituacao("ARQUIVADO");
		proposta2.setSituacao("ARQUIVADO");
		proposta3.setSituacao("ARQUIVADO");

		assertEquals(proposta1.getSituacao(), "ARQUIVADO");
		assertEquals(proposta2.getSituacao(), "ARQUIVADO");
		assertEquals(proposta3.getSituacao(), "ARQUIVADO");
	}

	@Test
	void testGetLocal() {
		PropostaLegislativa proposta1 = new PropostaLegislativa("Aaaaa", 2019, "Bbbbb", "Ccccc", "Ddddd", "Eeeee");
		PropostaLegislativa proposta2 = new PropostaLegislativa("Fffff", 2018, "Ggggg", "Hhhhh", "Iiiii", "Jjjjj");
		PropostaLegislativa proposta3 = new PropostaLegislativa("Kkkkk", 2017, "Lllll", "Mmmmm", "Nnnnn", "Ooooo");

		assertEquals(proposta1.getLocal(), "CCJC");
		assertEquals(proposta2.getLocal(), "CCJC");
		assertEquals(proposta3.getLocal(), "CCJC");
	}

	@Test
	void testSetLocal() {
		PropostaLegislativa proposta1 = new PropostaLegislativa("Aaaaa", 2019, "Bbbbb", "Ccccc", "Ddddd", "Eeeee");
		PropostaLegislativa proposta2 = new PropostaLegislativa("Fffff", 2018, "Ggggg", "Hhhhh", "Iiiii", "Jjjjj");
		PropostaLegislativa proposta3 = new PropostaLegislativa("Kkkkk", 2017, "Lllll", "Mmmmm", "Nnnnn", "Ooooo");
		proposta1.setLocal("Aaaaa");
		proposta2.setLocal("Aaaaa");
		proposta3.setLocal("Aaaaa");

		assertEquals(proposta1.getLocal(), "Aaaaa");
		assertEquals(proposta2.getLocal(), "Aaaaa");
		assertEquals(proposta3.getLocal(), "Aaaaa");
	}

}
