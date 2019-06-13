package entidades;

/**
 * Responsavel por representar um Deputado
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
	 * @param leisAprovadas nova quantidade de leis aprovadas pelo deputado
	 */

	public void setLeisAprovadas(int leisAprovadas) {
		this.leisAprovadas = leisAprovadas;
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
	 * 
	 * @param
	 * @param
	 * @param
	 * @param
	 * @param
	 * 
	 */
	@Override
	public String exibir(String nome, String dni, String estado, String partido, String interesses) {
		return "POL: " + nome + " - " + dni + " (" + estado + ")" + partido + interesses + " - "
				+ this.getDataDeInicio() + " - " + this.getLeisAprovadas() + " Leis";
	}
}
