package entidades;
/**
 * Representa um projeto de lei no sistema
 * @author JacksonMateus
 *
 */
public class PL extends PropostaLegislativa {
	/**
	 * Armazena indentificador de versao de serializacao da classe PL.
	 */
	private static final long serialVersionUID = -8713565553635256164L;
	
	/**
	 * Armazena se a proposta precisa ser apreciada nas comissões, e não precisa ir ao plenário.
	 */
	private boolean conclusiva;
	
	/**
	 * Inicia a PL a partir do autor do projeto de lei, ano, codigo, ementa, interesses, url, e se a proposta é 
	 * conclusiva ou nao;
	 * @param autor da PL
	 * @param ano de inicio da PL foi iniciada
	 * @param codigo da PL
	 * @param ementa da PL
	 * @param interesses da PL
	 * @param URL da PL
	 * @param conclusiva booleano que diz se o projeto é conclusiva ou nao
	 */
	public PL(String autor, int ano, String codigo, String ementa, String interesses, String URL, boolean conclusiva) {
		super(autor, ano, codigo, ementa, interesses, URL);
		this.conclusiva = conclusiva;
	}
	
	/**
	 * Retorna se o projeto de lei é conclusivo ou nao
	 * @return uma String, que mostra se o projeto de lei é conclusivo ou nao
	 */
	public String getConclusiva() {
		if(this.conclusiva) {
			return " - Conclusiva";
		}
		return "";
	}
	
	/**
	 * Retorna se o projeto de lei é conclusivo ou nao
	 * @return uma booleano, que mostra se o projeto de lei é conclusivo ou nao
	 */
	public boolean isConclusivo() {
		return this.conclusiva;
	}
	
	/**
	 * Representacao textual da PL
	 */
	public String toString() {
		return "Projeto de Lei - " + super.codigo + " - " + super.autor + " - " + super.ementa + this.getConclusiva() + " - " + super.situacao;
	}

}
