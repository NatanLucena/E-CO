package estrategias;

import java.util.Collections;
import java.util.List;

import entidades.PropostaLegislativa;
import metodosAuxiliares.ComparadorDePropostasAprovacao;

public class EstrategiaAprovacao implements Estrategia {

	@Override
	public String desempate(List<PropostaLegislativa> propostas) {
		ComparadorDePropostasAprovacao comparaAprovacao = new ComparadorDePropostasAprovacao();
		Collections.sort(propostas, comparaAprovacao);
		return propostas.get(0).getCodigo();
	}

}
