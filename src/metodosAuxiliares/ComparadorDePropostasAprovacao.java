package metodosAuxiliares;

import java.util.Comparator;

import entidades.PropostaLegislativa;

public class ComparadorDePropostasAprovacao implements Comparator<PropostaLegislativa> {

	@Override
	public int compare(PropostaLegislativa p1, PropostaLegislativa p2) {
		int aprovacoesP1 = (int) p1.getListaTramitacao().stream().filter(p -> p.contains("APROVADO")).count();
		int aprovacoesP2 = (int) p1.getListaTramitacao().stream().filter(p -> p.contains("APROVADO")).count();
	}

}
