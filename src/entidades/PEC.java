package entidades;

/**
 * Representa um projeto de lei complementar no sistema
 * @author JacksonMateus
 *
 */
public class PEC extends PropostaLegislativa {
	/**
	 * Armazena indentificador de versao de serializacao da classe PEC.
	 */
	private static final long serialVersionUID = 5247444466850372223L;

	/**
	 * Armazena os artigos da constituição sendo complementados ou emendados;
	 */
	private String artigosAlterados;
	
	/**
	 * Inicia a PEC a partir do autor do projeto de lei, ano de inicio do projeto, codigo, ementa, interesses, URL e artigos desse 
	 * projeto de lei
	 * @param autor da PEC
	 * @param ano de inicio da PEC
	 * @param codigo da PEC
	 * @param ementa da PEC
	 * @param interesses da PEC 
	 * @param URL da PEC
	 * @param artigos da PEC
	 */
	public PEC(String autor, int ano, String codigo, String ementa, String interesses, String URL, String artigos) {
		super(autor, ano, codigo, ementa, interesses, URL);
		this.artigosAlterados = artigos;
	}
	
	/**
	 * Retorna os artigos da PEC
	 * @return uma String que representa todos os artigos da PEC
	 */
	public String getArtigos() {
		String[] artigos = this.artigosAlterados.split(",");
		return String.join(", ", artigos);
	}
	
	/**
	 * Representacao textual da PEC
	 */
	public String toString() {
		return "Projeto de Emenda Constitucional - " + super.codigo + " - " + super.autor + " - " + super.ementa + " - " + this.getArtigos() + " - " + super.situacao;
	}

}
