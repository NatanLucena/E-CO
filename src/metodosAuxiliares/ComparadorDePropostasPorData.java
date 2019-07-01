package metodosAuxiliares;

import java.util.Comparator;

import entidades.PropostaLegislativa;

public class ComparadorDePropostasPorData implements Comparator<PropostaLegislativa> {

	@Override
	public int compare(PropostaLegislativa p1, PropostaLegislativa p2) {
		String[] proposta1 = p1.getCodigo().split(" ");
		String[] proposta1Info = proposta1[1].split("/");
		String[] proposta2 = p2.getCodigo().split(" ");
		String[] proposta2Info = proposta2[1].split("/");
		if(Integer.parseInt(proposta1Info[1]) < Integer.parseInt(proposta2Info[1])) {
			return -1;
		}else if(Integer.parseInt(proposta1Info[1]) > Integer.parseInt(proposta2Info[1])) {
			return 1;
		}else {
			if(Integer.parseInt(proposta1Info[0]) < Integer.parseInt(proposta2Info[0])) {
				return -1;
			}else {
				return 1;
			}
		}
	}

}
