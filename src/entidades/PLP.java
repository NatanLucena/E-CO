package entidades;

public class PLP extends PropostaLegislativa {
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
