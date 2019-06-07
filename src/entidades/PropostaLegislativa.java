package entidades;

public class PropostaLegislativa {
	protected String autor;
	protected int ano;
	protected String codigo;
	protected String ementa;
	protected String interesses;
	protected String situacao;
	private String URL;
	
	public PropostaLegislativa(String autor,int ano, String codigo, String ementa, String interesses, String URL) {
		this.autor = autor;
		this.ano = ano;
		this.codigo = codigo;
		this.ementa = ementa;
		this.interesses = interesses;
		this.situacao = "EM VOTACAO (CCJC)";
		this.URL = URL;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
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

	public String getURL() {
		return URL;
	}
	

}
