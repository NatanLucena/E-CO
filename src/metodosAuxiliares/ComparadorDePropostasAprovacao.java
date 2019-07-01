package metodosAuxiliares;

import java.util.Comparator;

import entidades.PropostaLegislativa;

public class ComparadorDePropostasAprovacao implements Comparator<PropostaLegislativa> {

	@Override
	public int compare(PropostaLegislativa p1, PropostaLegislativa p2) {
		int aprovacoesP1 = (int) p1.getListaTramitacao().stream().filter(p -> p.contains("APROVADO")).count();
		int aprovacoesP2 = (int) p1.getListaTramitacao().stream().filter(p -> p.contains("APROVADO")).count();
		if(aprovacoesP1 > aprovacoesP2) {
			return -1;
		}else if (aprovacoesP1 < aprovacoesP2){
			return 1;
		}else {
			ComparadorDePropostasPorData comp = new ComparadorDePropostasPorData();
			return comp.compare(p1, p2);
		}
	}

}
