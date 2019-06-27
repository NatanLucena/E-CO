package estrategias;

import java.util.List;

import entidades.PropostaLegislativa;

public interface Estrategia {
	public String desempate(List<PropostaLegislativa> propostas);
}
