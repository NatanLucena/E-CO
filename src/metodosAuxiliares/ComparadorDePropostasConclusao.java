package metodosAuxiliares;

import java.util.Comparator;

import entidades.PropostaLegislativa;

public class ComparadorDePropostasConclusao implements Comparator<PropostaLegislativa> {

	@Override
	public int compare(PropostaLegislativa p1, PropostaLegislativa p2) {
		if(p1.getListaTramitacao().size() > p2.getListaTramitacao().size()){
			return -1;
		}else if(p1.getListaTramitacao().size() < p2.getListaTramitacao().size()) {
			return 1;
		}else {
			ComparadorDePropostasPorData comp = new ComparadorDePropostasPorData();
			return comp.compare(p1, p2);
		}
	}

}
