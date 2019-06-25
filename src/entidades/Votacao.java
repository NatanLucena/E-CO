package entidades;

import java.util.ArrayList;
import java.util.List;

public class Votacao {
	private List<String> baseGovernista; 
	
	public Votacao() {
		this.baseGovernista = new ArrayList<>();
	}
	
	public void cadastraPartido(String partido) {
		this.baseGovernista.add(partido);
	}
	
	public boolean votaComissao(PropostaLegislativa proposta, Comissao comissao, String statusGovernista, String proximoLocal) {
		int votos = 0;
		
		for(int i = 0; i < comissao.getIntegrantes().size(); i++) {
			if(statusGovernista.equals("GOVERNISTA")) {
				if(this.baseGovernista.contains(comissao.getIntegrantes().get(i).getPartido2())) {
					votos += 1;
				}
		   }else if(statusGovernista.equals("OPOSICAO")) {
			   if(!this.baseGovernista.contains(comissao.getIntegrantes().get(i).getPartido2())) {
				   votos += 1;
			   }
		   }else {
			   List<String> interessesDoDeputado = comissao.getIntegrantes().get(i).getListaDeInteresses();
			   for(int j = 0; j < interessesDoDeputado.size(); j++) {
					if(proposta.getListaDeInteresses().contains(interessesDoDeputado.get(j))) {
						votos += 1;
						break;
					}
				}
		   }
	}

}
	
}
