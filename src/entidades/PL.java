package entidades;

public class PL extends PropostaLegislativa {
	private boolean conclusiva;
	
	public PL(String autor, int ano, String codigo, String ementa, String interesses, String URL, boolean conclusiva) {
		super(autor, ano, codigo, ementa, interesses, URL);
		this.conclusiva = conclusiva;
	}
	
	public String getConclusiva() {
		if(this.conclusiva) {
			return "Conclusiva";
		}
		return "Inconclusiva";
	}
	
	public String toString() {
		return "Projeto de Lei -" + super.codigo + " - " + super.autor + " - " + super.ementa + " - " + this.getConclusiva() + " - " + super.situacao;
	}

}
