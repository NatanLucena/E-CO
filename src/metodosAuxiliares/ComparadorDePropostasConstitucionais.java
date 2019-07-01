package metodosAuxiliares;

import java.util.Comparator;

import entidades.PropostaLegislativa;

public class ComparadorDePropostasConstitucionais implements Comparator<PropostaLegislativa> {

	@Override
	public int compare(PropostaLegislativa p1, PropostaLegislativa p2) {
		if(p1.getCodigo().contains("PEC ") && (!p2.getCodigo().contains("PEC "))) {
			return -1;
		}else if(!p1.getCodigo().contains("PEC ") && (p2.getCodigo().contains("PEC "))) {
			return 1;
		}else if (p1.getCodigo().contains("PLP ") && (!p2.getCodigo().contains("PLP "))) {
			return -1;
		}else if (!p1.getCodigo().contains("PLP ") && (p2.getCodigo().contains("PLP "))) {
			return 1;
		}else {
			ComparadorDePropostasPorData comp = new ComparadorDePropostasPorData();
			return comp.compare(p1, p2);
		}
	}

}
