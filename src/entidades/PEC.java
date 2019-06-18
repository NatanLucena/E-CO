package entidades;

public class PEC extends PropostaLegislativa {
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
