package entidades;

public class PL extends PropostaLegislativa {
	/**
	 * Armazena indentificador de versao de serializacao da classe PL.
	 */
	private static final long serialVersionUID = -8713565553635256164L;
	private boolean conclusiva;
	
	public PL(String autor, int ano, String codigo, String ementa, String interesses, String URL, boolean conclusiva) {
		super(autor, ano, codigo, ementa, interesses, URL);
		this.conclusiva = conclusiva;
	}
	
	public String getConclusiva() {
		if(this.conclusiva) {
			return " - Conclusiva";
		}
		return "";
	}
	
	public boolean isConclusivo() {
		return this.conclusiva;
	}
	
	public String toString() {
		return "Projeto de Lei - " + super.codigo + " - " + super.autor + " - " + super.ementa + this.getConclusiva() + " - " + super.situacao;
	}

}
