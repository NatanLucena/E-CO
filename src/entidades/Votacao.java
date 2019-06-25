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
	
	public boolean votaComissao(PropostaLegislativa proposta, Comissao comissao, String statusGovernista, String proximoLocal, Deputado autor) {
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
		
		if(votos >= ((comissao.getIntegrantes().size()/2) + 1)) {
			if(proposta.getCodigo().contains("PL ") && proposta.toString().contains("Conclusiva") && !proposta.getLocal().equals("CCJC")) {
				autor.setLeisAprovadas();
				proposta.setTramitacao("APROVADO (" + proposta.getLocal() + ")");
				proposta.setLocal("-");
				proposta.setSituacao("ARQUIVADO");
			}else {
				proposta.setTramitacao("APROVADO (" + proposta.getLocal() + ")");
				if(proximoLocal.equals("plenario")) {
					if(proposta.getCodigo().contains("PL ")) {
						proposta.setLocal(proximoLocal);
						proposta.adicionaTramitacao("EM VOTACAO (" + proximoLocal + ")");
						proposta.setSituacao("EM VOTACAO (" + proximoLocal + ")");
					}else {
						proposta.setLocal(proximoLocal);
						proposta.adicionaTramitacao("EM VOTACAO (" + proximoLocal + " - 1o turno)");
						proposta.setSituacao("EM VOTACAO (" + proximoLocal + " - 1o turno)");
					}
				}else {
					proposta.adicionaTramitacao("EM VOTACAO (" + proximoLocal + ")");
					proposta.setLocal(proximoLocal);
					proposta.setSituacao("EM VOTACAO (" + proximoLocal + ")");
				}	
			}
			return true;
		}else {
			if(proposta.getLocal().equals("CCJC")) {
				proposta.setTramitacao("REJEITADO (CCJC)");
				proposta.setLocal("-");
				proposta.setSituacao("ARQUIVADO");
			}else if(proposta.getCodigo().contains("PL ") && proposta.toString().contains("Conclusiva")) {
				proposta.setTramitacao("REJEITADO (" + proposta.getLocal() + ")");
				proposta.setLocal("-");
				proposta.setSituacao("ARQUIVADO");
			}else {
				proposta.setTramitacao("REJEITADO (" + proposta.getLocal() + ")");
				if(proximoLocal.equals("plenario")) {
					if(proposta.getCodigo().contains("PL ")) {
						proposta.setLocal("Plenario");
						proposta.adicionaTramitacao("EM VOTACAO (Plenario)");
						proposta.setSituacao("EM VOTACAO (Plenario)");
					}else {
						proposta.setLocal("Plenario - 1o turno");
						proposta.adicionaTramitacao("EM VOTACAO (Plenario - 1o turno)");
						proposta.setSituacao("EM VOTACAO (Plenario - 1o turno)");
					}
				}else {
					proposta.adicionaTramitacao("EM VOTACAO (" + proximoLocal + ")");
					proposta.setLocal(proximoLocal);
					proposta.setSituacao("EM VOTACAO (" + proximoLocal + ")");
				}
			}
			return false;
		}

	}
	
	public boolean votaPlenario(PropostaLegislativa proposta, List<Deputado> presentes, int totalDeputados, String statusGovernista, Deputado autor) {
		int votos = 0;
		
		List<String> interessesDaProposta = proposta.getListaDeInteresses();
		for(int i = 0; i < presentes.size(); i++) {
			if(statusGovernista.equals("GOVERNISTA")) {
				if(this.baseGovernista.contains(presentes.get(i).getPartido2())) {
					votos += 1;
				}
			}else if(statusGovernista.equals("OPOSICAO")) {
				if(!this.baseGovernista.contains(presentes.get(i).getPartido2())) {
					votos += 1;
				}
			}else {
				List<String> interessesDoDeputado = presentes.get(i).getListaDeInteresses();
				for(int j = 0; j < interessesDoDeputado.size(); j++) {
					if(interessesDaProposta.contains(interessesDoDeputado.get(j))) {
						votos += 1;
						break;
					}
				}
			}
		}
		
		if(proposta.getCodigo().contains("PL ")) {
			if(votos >= ((presentes.size()/2) + 1)) {
				autor.setLeisAprovadas();
				proposta.setTramitacao("APROVADO (Plenario)");
				proposta.setLocal("-");
				proposta.setSituacao("ARQUIVADO");
				return true;
			}else {
				proposta.setTramitacao("Rejeitado (Plenario)");
				proposta.setLocal("-");
				proposta.setSituacao("ARQUIVADO");
				return false;
			}
		}else if(proposta.getCodigo().contains("PLP ")) {
			if(votos >= ((totalDeputados/2) + 1)) {
				if(proposta.getLocal().equals("Plenario - 1o turno")) {
					proposta.setTramitacao("APROVADO (Plenario - 1o turno)");
					proposta.setLocal("Plenario - 2o turno");
					proposta.adicionaTramitacao("EM VOTACAO (Plenario - 1o turno)");
					proposta.setSituacao("EM VOTACAO (Plenario - 1o turno)");
					return true;
				}else {
					autor.setLeisAprovadas();
					proposta.setTramitacao("APROVADO (Plenario - 2o turno)");
					proposta.setLocal("-");
					proposta.setSituacao("ARQUIVADO");
					return true;
				}
			}else {
				proposta.setTramitacao("REJEITADO (" + proposta.getLocal() + ")");
				proposta.setLocal("-");
				proposta.setSituacao("ARQUIVADO");
				return false;
			}
		}else {
			if(votos >= (((totalDeputados*3)/5) + 1)) {
				if(proposta.getLocal().equals("Plenario - 1o turno")) {
					proposta.setTramitacao("APROVADO (Plenario - 1o turno)");
					proposta.setLocal("Plenario - 2o turno");
					proposta.adicionaTramitacao("EM VOTACAO (Plenario - 1o turno)");
					proposta.setSituacao("EM VOTACAO (Plenario - 1o turno)");
					return true;
				}else {
					autor.setLeisAprovadas();
					proposta.setTramitacao("APROVADO (Plenario - 2o turno)");
					proposta.setLocal("-");
					proposta.setSituacao("ARQUIVADO");
					return true;
				}
			}else {
				proposta.setTramitacao("REJEITADO (" + proposta.getLocal() + ")");
				proposta.setLocal("-");
				proposta.setSituacao("ARQUIVADO");
				return false;
			}
		}
	}
	
}
