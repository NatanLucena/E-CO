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
	void getTest() {
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
	
	@Test
	void setTest() {
		assertThrows(IllegalArgumentException.class, () -> proposta.setLocal(null));
		assertThrows(IllegalArgumentException.class, () -> proposta.setLocal(""));
		
		assertThrows(IllegalArgumentException.class, () -> proposta.setSituacao(null));
		assertThrows(IllegalArgumentException.class, () -> proposta.setSituacao(""));
		
		assertThrows(IllegalArgumentException.class, () -> proposta.setTramitacao(null));
		assertThrows(IllegalArgumentException.class, () -> proposta.setTramitacao(""));
		
		proposta.setLocal("LCC");
		proposta.setSituacao("EM VOTACAO (LCC)");
		proposta.setTramitacao("EM VOTACAO (LCC)");
		
		assertEquals(proposta.getLocal(), "LCC");
		assertEquals(proposta.getSituacao(), "EM VOTACAO (LCC)");
		assertEquals(proposta.getTramitacao(), "EM VOTACAO (LCC)");
	}
	
	@Test
	void adicionaTramitacaoTest() {
		assertThrows(IllegalArgumentException.class, () -> proposta.adicionaTramitacao(null));
		assertThrows(IllegalArgumentException.class, () -> proposta.adicionaTramitacao(""));
		
		assertEquals(proposta.getTramitacao(), "EM VOTACAO (CCJC)");
		proposta.adicionaTramitacao("EM VOTACAO (LCC)");
		assertEquals(proposta.getTramitacao(), "EM VOTACAO (CCJC), EM VOTACAO (LCC)");
	}

}
