package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PropostaLegislativa implements Serializable {
	/**
	 * Armazena indentificador de versao de serializacao da classe PropostaLegislativa.
	 */
	private static final long serialVersionUID = 237001536563632409L;
	protected String autor;
	protected int ano;
	protected String codigo;
	protected String ementa;
	protected String interesses;
	protected String situacao;
	private String URL;
	private String local;
	private List<String> tramitacao;
	
	public PropostaLegislativa(String autor,int ano, String codigo, String ementa, String interesses, String URL) {
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

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
	public void setTramitacao(String tramitacao) {
		this.tramitacao.remove(-1);
		this.tramitacao.add(tramitacao);
	}
	
	public void adicionaTramitacao(String tramitacao) {
		this.tramitacao.add(tramitacao);
	}
	
	public String getTramitacao() {
		return String.join(",", this.tramitacao);
	}
	
	public List<String> getListaTramitacao() {
		return this.tramitacao;
	}

	public String getAutor() {
		return autor;
	}

	public int getAno() {
		return ano;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getEmenta() {
		return ementa;
	}

	public String getInteresses() {
		return interesses;
	}
	
	public List<String> getListaDeInteresses() {
		List<String> interesses = Arrays.asList(this.interesses.split(","));
		return interesses;
	}

	public String getURL() {
		return URL;
	}
	
	public String getLocal() {
		return this.local;
	}
	
	public void setLocal(String local) {
		this.local = local;
	}
	

}
