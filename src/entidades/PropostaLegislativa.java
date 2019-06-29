package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import metodosAuxiliares.ValidadorGeral;
/**
 * Responsavel por representar uma proposta legislativa.
 *  
 * @author JacksonMateus
 *
 */
public class PropostaLegislativa implements Serializable {
	
	/**
	 * Armazena indentificador de versao de serializacao da classe PropostaLegislativa.
	 */
	private static final long serialVersionUID = 237001536563632409L;
	
	/**
	 * Armazena o autor da proposta legislativa
	 */
	protected String autor;
	
	/**
	 * Armazena o ano de inicio da proposta legislativa
	 */
	protected int ano;
	
	/**
	 * Armazena o codigo da proposta legislativa
	 */
	protected String codigo;

	/**
	 * Armazena a ementa da proposta legislativa
	 */
	protected String ementa;
	
	/**
	 * Armazena os interesses da proposta legislativa
	 */
	protected String interesses;
	
	/**
	 * Armazena a situacao da proposta legislativa
	 */
	protected String situacao;
	
	/**
	 * Armazena a URL da proposta legislativa
	 */
	private String URL;
	
	/**
	 * Armazena o local da proposta legislativa
	 */
	private String local;
	
	/**
	 * Armazena em uma lista todas as tramitacoes da proposta legislativa
	 */
	private List<String> tramitacao;
	
	private ValidadorGeral validador;
	
	
	/**
	 * Inicia a proposta legislativa a partir do autor do projeto de lei, ano, codigo, ementa, interesses e URL da proposta conclusiva.
	 * 
	 * @param autor da proposta legislativa
	 * @param ano de inicio da proposta legislativa
	 * @param codigo da proposta legislativa
	 * @param ementa da proposta legislativa
	 * @param interesses da proposta legislativa
	 * @param URL da proposta legislativa
	 */
	public PropostaLegislativa(String autor,int ano, String codigo, String ementa, String interesses, String URL) {
		validador = new ValidadorGeral();
		
		validador.validaNullOuVazio(autor, "Erro ao cadastrar projeto: autor nao pode ser vazio ou nulo");
		validador.validaDni(autor, "Erro ao cadastrar projeto: dni invalido");
		validador.validaNullOuVazio(codigo, "Erro ao cadastrar projeto: codigo nao pode ser vazio ou nulo");
		validador.validaNullOuVazio(ementa, "Erro ao cadastrar projeto: ementa nao pode ser vazia ou nula");
		validador.validaNullOuVazio(interesses, "Erro ao cadastrar projeto: interesse nao pode ser vazio ou nulo");
		validador.validaNullOuVazio(URL, "Erro ao cadastrar projeto: url nao pode ser vazio ou nulo");

		this.autor = autor;
		this.ano = ano;
		this.codigo = codigo;
		this.ementa = ementa;
		this.interesses = interesses;
		this.situacao = "EM VOTACAO (CCJC)";
		this.URL = URL;
		this.local = "CCJC";
		this.tramitacao = new ArrayList<>();
		this.tramitacao.add("EM VOTACAO (CCJC)");
	}
	
	/**
	 * Retorna a situacao da proposta legislativa.
	 * 
	 * @return uma String que representa a situacao da proposta legislativa
	 */
	public String getSituacao() {
		return situacao;
	}
	
	/**
	 * Altera a situacao da proposta legislativa.
	 * 
	 * @param situacao que sera atualizado como situacao da proposta legislativa
	 */
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	

	/**
	 * Adiciona uma tramitacao na lista de tramitacoes da proposta legislativa 
	 * tambem removendo a tramitacao que esta na ultima posicao da lista.
	 * 
	 * @param tramitacao que sera adicionada na lista de tramitacoes da proposta legislativa
	 */
	public void setTramitacao(String tramitacao) {
		this.tramitacao.remove(this.tramitacao.size() -1);
		this.tramitacao.add(tramitacao);
	}
	
	/**
	 * Adiciona uma tramitacao na lista de tramitacoes da proposta legislativa.
	 *  
	 * @param tramitacao que sera adicionada na lista de tramitacoes da proposta legislativa
	 */
	public void adicionaTramitacao(String tramitacao) {
		this.tramitacao.add(tramitacao);
	}

	/**
	 * Retorna as tramitacoes da proposta legislativa.
	 * 
	 * @return uma String que representa as tramitacoes da proposta legislativa
	 */
	public String getTramitacao() {
		return String.join(", ", this.tramitacao);
	}
	
	/**
	 * Retorna as tramitacoes da proposta legislativa.
	 * 
	 * @return uma Lista com todas as tramitacoes da proposta legislativa 
	 */
	public List<String> getListaTramitacao() {
		return this.tramitacao;
	}

	/**
	 * Retorna o autor da proposta legislativa.
	 * 
	 * @return Uma String que representa o autor da proposta legislativa 
	 */
	public String getAutor() {
		return autor;
	}
	/**
	 * Retorna o ano de inicio da proposta legislativa.
	 * 
	 * @return um inteiro que representa o ano de inicio da proposta legislativa 
	 */
	public int getAno() {
		return ano;
	}
	
	/**
	 * Retorna o codigo da proposta legislativa.
	 * 
	 * @return uma String que representa o codigo da proposta legislativa 
	 */
	public String getCodigo() {
		return codigo;
	}
	
	/**
	 * Retorna a ementa da proposta legislativa.
	 *  
	 * @return uma String que representa a ementa da proposta legislativa 
	 */
	public String getEmenta() {
		return ementa;
	}
	/**
	 * Retorna os intereses da proposta legislativa.
	 * 
	 * @return uma String que representa os interesses da proposta legislativa 
	 */
	public String getInteresses() {
		return interesses;
	}
	
	/**
	 * Retorna os interesses da proposta legislativa.
	 * 
	 * @return uma Lista com todos os interesses da proposta legislativa 
	 */
	public List<String> getListaDeInteresses() {
		List<String> interesses = Arrays.asList(this.interesses.split(","));
		return interesses;
	}

	/**
	 * Retorna a URL da proposta legislativa.
	 *  
	 * @return uma String que representa a URL da proposta legislativa 
	 */
	public String getURL() {
		return URL;
	}
	
	/**
	 * Retorna o local da proposta legislativa.
	 * 
	 * @return uma String que representa o local da proposta legislativa 
	 */
	public String getLocal() {
		return this.local;
	}
	
	/**
	 * Altera o local da proposta legislativa.
	 * 
	 * @param local novo local da proposta legislativa 
	 */
	public void setLocal(String local) {
		this.local = local;
	}
	
	public boolean propostaEmComissao(boolean aprovado, String proximoLocal) {
		boolean leiAprovada = false;
		if(aprovado) {
			if (this.getCodigo().contains("PL ") 
				&& this.toString().contains("Conclusiva")
				&& !this.getLocal().equals("CCJC")) {
				leiAprovada = true;
				this.setTramitacao("APROVADO (" + this.getLocal() + ")");
				this.setLocal("-");
				this.setSituacao("APROVADO");
			} else {
				this.setTramitacao("APROVADO (" + this.getLocal() + ")");
				if (proximoLocal.equals("plenario")) {
					if (this.getCodigo().contains("PL ")) {
						this.setLocal(proximoLocal);
						this.adicionaTramitacao("EM VOTACAO (Plenario)");
						this.setSituacao("EM VOTACAO (Plenario)");
					} else {
						this.setLocal(proximoLocal);
						this.adicionaTramitacao("EM VOTACAO (Plenario - 1o turno)");
						this.setSituacao("EM VOTACAO (Plenario - 1o turno)");
					}
				} else {
					this.adicionaTramitacao("EM VOTACAO (" + proximoLocal + ")");
					this.setLocal(proximoLocal);
					this.setSituacao("EM VOTACAO (" + proximoLocal + ")");
				}
			}
		}else {
			if (this.getLocal().equals("CCJC")) {
				this.setTramitacao("REJEITADO (CCJC)");
				this.setLocal("-");
				this.setSituacao("ARQUIVADO");
			} else if (this.getCodigo().contains("PL ") && this.toString().contains("Conclusiva")) {
				this.setTramitacao("REJEITADO (" + this.getLocal() + ")");
				this.setLocal("-");
				this.setSituacao("ARQUIVADO");
			} else {
				this.setTramitacao("REJEITADO (" + this.getLocal() + ")");
				if (proximoLocal.equals("plenario")) {
					if (this.getCodigo().contains("PL ")) {
						this.setLocal("Plenario");
						this.adicionaTramitacao("EM VOTACAO (Plenario)");
						this.setSituacao("EM VOTACAO (Plenario)");
					} else {
						this.setLocal("Plenario - 1o turno");
						this.adicionaTramitacao("EM VOTACAO (Plenario - 1o turno)");
						this.setSituacao("EM VOTACAO (Plenario - 1o turno)");
					}
				} else {
					this.adicionaTramitacao("EM VOTACAO (" + proximoLocal + ")");
					this.setLocal(proximoLocal);
					this.setSituacao("EM VOTACAO (" + proximoLocal + ")");
				}
			}
		}
		return leiAprovada;
	}
	

}
