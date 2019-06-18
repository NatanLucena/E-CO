package entidades;

import java.util.Arrays;
import java.util.List;

public class PropostaLegislativa {
	protected String autor;
	protected int ano;
	protected String codigo;
	protected String ementa;
	protected String interesses;
	protected String situacao;
	private String URL;
	private String local;
	
	public PropostaLegislativa(String autor,int ano, String codigo, String ementa, String interesses, String URL) {
		this.autor = autor;
		this.ano = ano;
		this.codigo = codigo;
		this.ementa = ementa;
		this.interesses = interesses;
		this.situacao = "EM VOTACAO (CCJC)";
		this.URL = URL;
		this.local = "CCJC";
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao() {
		this.situacao = "EM VOTACAO (" + this.local + ")";
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
