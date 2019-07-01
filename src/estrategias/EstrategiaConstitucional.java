package estrategias;

import java.util.Collections;
import java.util.List;

import entidades.PropostaLegislativa;
import metodosAuxiliares.ComparadorDePropostasConstitucionais;

public class EstrategiaConstitucional implements Estrategia {

	@Override
	public String desempate(List<PropostaLegislativa> propostas) {
		ComparadorDePropostasConstitucionais comparadorConstitucional = new ComparadorDePropostasConstitucionais();
		Collections.sort(propostas, comparadorConstitucional);
		return propostas.get(0).getCodigo();
	}
	
}
