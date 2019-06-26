package entidades;

public class PLP extends PropostaLegislativa {
	/**
	 * Armazena indentificador de versao de serializacao da classe PLP.
	 */
	private static final long serialVersionUID = -7128292217539824288L;
	private String artigosAlterados;
	
	public PLP(String autor, int ano, String codigo, String ementa, String interesses, String URL, String artigos) {
		super(autor, ano, codigo, ementa, interesses, URL);
		this.artigosAlterados = artigos;
	}
	
	public String getArtigos() {
		return this.artigosAlterados;
	}
	
	public String toString() {
		return "Projeto de Lei Complementar - " + super.codigo +  " - " + super.autor + " - " + super.ementa + " - " + this.artigosAlterados + " - " + super.situacao;
	}

}
