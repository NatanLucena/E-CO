package entidades;

/**
 * Representa um projeto de lei complementar no sistema.
 * 
 * @author JacksonMateus
 *
 */
public class PLP extends PropostaLegislativa {
	/**
	 * Armazena indentificador de versao de serializacao da classe PLP.
	 */
	private static final long serialVersionUID = -7128292217539824288L;
	
	/**
	 * Armazena os artigos da constituição sendo complementados ou emendados;
	 */
	private String artigosAlterados;

	/**
	 * Inicia a PLP a partir do autor do projeto de lei, ano de inicio do projeto, codigo, ementa, interesses, URL e artigos desse projeto de lei.
	 * 
	 * @param autor da PLP
	 * @param ano de inicio da PLP
	 * @param codigo da PLP
	 * @param ementa da PLP
	 * @param interesses da PLP
	 * @param URL da PLP
	 * @param artigos da PLP
	 */
	public PLP(String autor, int ano, String codigo, String ementa, String interesses, String URL, String artigos) {
		super(autor, ano, codigo, ementa, interesses, URL);
		this.artigosAlterados = artigos;
	}
	
	/**
	 * Retorna os artigos da PLP.
	 * 
	 * @return uma String que representa todos os artigos da PLP
	 */
	public String getArtigos() {
		return this.artigosAlterados;
	}
	

	/**
	 * Retorna uma representacao textual da PLP.
	 */
	public String toString() {
		return "Projeto de Lei Complementar - " + super.codigo +  " - " + super.autor + " - " + super.ementa + " - " + this.artigosAlterados + " - " + super.situacao;
	}

}
