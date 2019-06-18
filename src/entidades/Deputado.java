package entidades;

/**
 * Responsavel por representar um Deputado
 * 
 * @author NatanLucena, CayoViegas, lucas-lucena, JacksonMateus
 *
 */
public class Deputado implements Exibir {

	/**
	 * Data de inicio que a pessoa exerceu a funcao de deputado
	 */
	private String dataDeInicio;

	/**
	 * Quantidade de leis que o deputado aprovou
	 */
	private int leisAprovadas;

	/**
	 * Inicia o deputado a partir da data de inicio da pessoa na funcao de deputado
	 * 
	 * @param dataDeInicio que a pessoa exerceu a funcao de deputado
	 */
	public Deputado(String dataDeInicio) {
		this.dataDeInicio = dataDeInicio;
		this.leisAprovadas = 0;
	}

	/**
	 * Retorna as quantidade de leis aprovadas pelo deputado
	 */
	public int getLeisAprovadas() {
		return leisAprovadas;
	}

	/**
	 * Altera a quantidade de leis aprovadas pelo deputado
	 * 
	 * @param leisAprovadas nova quantidade de leis aprovadas pelo deputado
	 */

	public void setLeisAprovadas() {
		this.leisAprovadas += 1;
	}

	/**
	 * @return Retorna a data de inicio da pessoa como Deputado
	 */
	public String getDataDeInicio() {
		String dia = dataDeInicio.substring(0, 2);
		String mes = dataDeInicio.substring(2, 4);
		String ano = dataDeInicio.substring(4, 8);

		return dia + "/" + mes + "/" + ano;
	}

	/**
	 * Este metodo retorna a representacao textual de um deputado
	 * 
	 * @param nome       uma String que representa o nome do deputado
	 * @param dni        uma String que representa o Documento Nacional de
	 *                   Identificacao do deputado
	 * @param estado     uma String que representa o estado de origem do deputado
	 * @param partido    uma String que representa o partido ao qual o deputado é
	 *                   filiado
	 * @param interesses uma String que representa os interesses do deputado
	 * @return Uma String contendo todas as informacoes disponiveis do deputado
	 */
	@Override
	public String exibir(String nome, String dni, String estado, String partido, String interesses) {
		return "POL: " + nome + " - " + dni + " (" + estado + ")" + partido + interesses + " - "
				+ this.getDataDeInicio() + " - " + this.getLeisAprovadas() + " Leis";
	}
}