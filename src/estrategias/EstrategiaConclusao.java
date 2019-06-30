package estrategias;

import java.util.Collections;
import java.util.List;

import entidades.PropostaLegislativa;
import metodosAuxiliares.ComparadorDePropostasConclusao;

public class EstrategiaConclusao implements Estrategia {

	@Override
	public String desempate(List<PropostaLegislativa> propostas) {
		ComparadorDePropostasConclusao comparaConclusao = new ComparadorDePropostasConclusao();
		Collections.sort(propostas, comparaConclusao);
		return propostas.get(0).getCodigo();
	}

}
