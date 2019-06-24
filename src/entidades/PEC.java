package entidades;

public class PEC extends PropostaLegislativa {
	/**
	 * Armazena indentificador de versao de serializacao da classe PEC.
	 */
	private static final long serialVersionUID = 5247444466850372223L;

	private String artigosAlterados;
	
	public PEC(String autor, int ano, String codigo, String ementa, String interesses, String URL, String artigos) {
		super(autor, ano, codigo, ementa, interesses, URL);
		this.artigosAlterados = artigos;
	}
	
	public String getArtigos() {
		String[] artigos = this.artigosAlterados.split(",");
		return String.join(", ", artigos);
	}
	
	public String toString() {
		return "Projeto de Emenda Constitucional - " + super.codigo + " - " + super.autor + " - " + super.ementa + " - " + this.getArtigos() + " - " + super.situacao;
	}

}
