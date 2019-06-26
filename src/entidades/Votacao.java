package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que realiza uma votacao, seja ela em comissao ou em plenario.
 * 
 * @author Natan Vinicius
 *
 */
public class Votacao implements Serializable{
	/**
	 * Armazena indentificador de versao de serializacao da classe Votacao.
	 */
	private static final long serialVersionUID = -7668656112804140239L;
	/**
	 * Armazena os partidos da base do governo.
	 */
	private List<String> baseGovernista;

	/**
	 * Constroi uma votacao no sistema.
	 */
	public Votacao() {
		this.baseGovernista = new ArrayList<>();
	}

	/**
	 * Cadastra um partido que faz parte da base do governo.
	 * 
	 * @param partido partido da base do governo
	 */
	public void cadastraPartido(String partido) {
		this.baseGovernista.add(partido);
	}

	/**
	 * Metodo que realiza uma votacao em comissao e retorna um boolean referente a
	 * aprovacao ou rejeicao da proposta.
	 * 
	 * @param proposta         proposta que sera votada em comissao
	 * @param comissao         comissao que ira votar a proposta
	 * @param statusGovernista posicao politica da proposta
	 * @param proximoLocal     local em que a proposta sera votada apos essa votacao
	 * @param autor            autor da proposta
	 * 
	 * @return um boolean referente a aprovacao ou rejeicao do projeto
	 */
	public boolean votaComissao(PropostaLegislativa proposta, Comissao comissao, String statusGovernista,
			String proximoLocal, Deputado autor) {
		int votos = 0;

		for (int i = 0; i < comissao.getIntegrantes().size(); i++) {
			if (statusGovernista.equals("GOVERNISTA")) {
				if (this.baseGovernista.contains(comissao.getIntegrantes().get(i).getPartido2())) {
					votos += 1;
				}
			} else if (statusGovernista.equals("OPOSICAO")) {
				if (!this.baseGovernista.contains(comissao.getIntegrantes().get(i).getPartido2())) {
					votos += 1;
				}
			} else {
				List<String> interessesDoDeputado = comissao.getIntegrantes().get(i).getListaDeInteresses();
				for (int j = 0; j < interessesDoDeputado.size(); j++) {
					if (proposta.getListaDeInteresses().contains(interessesDoDeputado.get(j))) {
						votos += 1;
						break;
					}
				}
			}
		}

		if (votos >= ((comissao.getIntegrantes().size() / 2) + 1)) {
			if (proposta.getCodigo().contains("PL ") 
					&& proposta.toString().contains("Conclusiva")
					&& !proposta.getLocal().equals("CCJC")) {
				
				autor.setLeisAprovadas();
				proposta.setTramitacao("APROVADO (" + proposta.getLocal() + ")");
				proposta.setLocal("-");
				proposta.setSituacao("APROVADO");
			} else {
				
				proposta.setTramitacao("APROVADO (" + proposta.getLocal() + ")");
				if (proximoLocal.equals("plenario")) {
					if (proposta.getCodigo().contains("PL ")) {
						proposta.setLocal(proximoLocal);
						proposta.adicionaTramitacao("EM VOTACAO (Plenario)");
						proposta.setSituacao("EM VOTACAO (Plenario)");
					} else {
						proposta.setLocal(proximoLocal);
						proposta.adicionaTramitacao("EM VOTACAO (Plenario - 1o turno)");
						proposta.setSituacao("EM VOTACAO (Plenario - 1o turno)");
					}
				} else {
					proposta.adicionaTramitacao("EM VOTACAO (" + proximoLocal + ")");
					proposta.setLocal(proximoLocal);
					proposta.setSituacao("EM VOTACAO (" + proximoLocal + ")");
				}
			}
			return true;
		} else {
			if (proposta.getLocal().equals("CCJC")) {
				proposta.setTramitacao("REJEITADO (CCJC)");
				proposta.setLocal("-");
				proposta.setSituacao("ARQUIVADO");
			} else if (proposta.getCodigo().contains("PL ") && proposta.toString().contains("Conclusiva")) {
				proposta.setTramitacao("REJEITADO (" + proposta.getLocal() + ")");
				proposta.setLocal("-");
				proposta.setSituacao("ARQUIVADO");
			} else {
				proposta.setTramitacao("REJEITADO (" + proposta.getLocal() + ")");
				if (proximoLocal.equals("plenario")) {
					if (proposta.getCodigo().contains("PL ")) {
						proposta.setLocal("Plenario");
						proposta.adicionaTramitacao("EM VOTACAO (Plenario)");
						proposta.setSituacao("EM VOTACAO (Plenario)");
					} else {
						proposta.setLocal("Plenario - 1o turno");
						proposta.adicionaTramitacao("EM VOTACAO (Plenario - 1o turno)");
						proposta.setSituacao("EM VOTACAO (Plenario - 1o turno)");
					}
				} else {
					proposta.adicionaTramitacao("EM VOTACAO (" + proximoLocal + ")");
					proposta.setLocal(proximoLocal);
					proposta.setSituacao("EM VOTACAO (" + proximoLocal + ")");
				}
			}
			return false;
		}
		
	}

	/**
	 * Metodo que realiza uma votacao em plenario e retorna um boolean referente a
	 * aprovacao ou rejeicao da proposta.
	 * 
	 * @param proposta         proposta que sera votada em plenario
	 * @param presentes        deputados presentes na votacao
	 * @param totalDeputados   numero total de cadeiras no plenario
	 * @param statusGovernista posicao politica da proposta
	 * @param autor            autor da proposta
	 * 
	 * @return um boolean referente a aprovacao ou rejeicao da proposta
	 */
	public boolean votaPlenario(PropostaLegislativa proposta, List<Deputado> presentes, int totalDeputados,
			String statusGovernista, Deputado autor) {
		int votos = 0;

		List<String> interessesDaProposta = proposta.getListaDeInteresses();
		for (int i = 0; i < presentes.size(); i++) {
			if (statusGovernista.equals("GOVERNISTA")) {
				if (this.baseGovernista.contains(presentes.get(i).getPartido2())) {
					votos += 1;
				}
			} else if (statusGovernista.equals("OPOSICAO")) {
				if (!this.baseGovernista.contains(presentes.get(i).getPartido2())) {
					votos += 1;
				}
			} else {
				List<String> interessesDoDeputado = presentes.get(i).getListaDeInteresses();
				for (int j = 0; j < interessesDoDeputado.size(); j++) {
					if (interessesDaProposta.contains(interessesDoDeputado.get(j))) {
						votos += 1;
						break;
					}
				}
			}
		}
		System.out.println(proposta);
		System.out.println(totalDeputados);
		System.out.println(votos);

		if (proposta.getCodigo().contains("PL ")) {
			if (votos >= ((presentes.size() / 2) + 1)) {
				autor.setLeisAprovadas();
				proposta.setTramitacao("APROVADO (Plenario)");
				proposta.setLocal("-");
				proposta.setSituacao("APROVADO");
				return true;
			} else {
				proposta.setTramitacao("Rejeitado (Plenario)");
				proposta.setLocal("-");
				proposta.setSituacao("ARQUIVADO");
				return false;
			}
		} else if (proposta.getCodigo().contains("PLP ")) {
			if (votos >= ((totalDeputados / 2) + 1)) {
				if (proposta.getSituacao().equals("EM VOTACAO (Plenario - 1o turno)")) {
					proposta.setTramitacao("APROVADO (Plenario - 1o turno)");
					proposta.setLocal("Plenario - 2o turno");
					proposta.adicionaTramitacao("EM VOTACAO (Plenario - 2o turno)");
					proposta.setSituacao("EM VOTACAO (Plenario - 2o turno)");
				} else {
					autor.setLeisAprovadas();
					proposta.setTramitacao("APROVADO (Plenario - 2o turno)");
					proposta.setLocal("-");
					proposta.setSituacao("APROVADO");
				}
				return true;
			} else {
				proposta.setTramitacao("REJEITADO (" + proposta.getLocal() + ")");
				proposta.setLocal("-");
				proposta.setSituacao("ARQUIVADO");
				return false;
			}
		} else {
			if (votos >= (((totalDeputados * 3) / 5) + 1)) {
				if (proposta.getLocal().equals("Plenario - 1o turno")) {
					proposta.setTramitacao("APROVADO (Plenario - 1o turno)");
					proposta.setLocal("Plenario - 2o turno");
					proposta.adicionaTramitacao("EM VOTACAO (Plenario - 1o turno)");
					proposta.setSituacao("EM VOTACAO (Plenario - 1o turno)");
				} else {
					autor.setLeisAprovadas();
					proposta.setTramitacao("APROVADO (Plenario - 2o turno)");
					proposta.setLocal("-");
					proposta.setSituacao("APROVADO");
				}
				return true;
			} else {
				proposta.setTramitacao("REJEITADO (" + proposta.getLocal() + ")");
				proposta.setLocal("-");
				proposta.setSituacao("ARQUIVADO");
				return false;
			}
		}
	}

}
