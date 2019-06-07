package entidades;

import metodosAuxiliares.ValidaDni;
/**
 * É responsavél por representar um cliente
 * @author NatanLucena, CayoViegas, lucas-lucena, JacksonMateus
 *
 */
public class Pessoa {
	/**
	 * Armazena nome da pessoa 
	 */
	private String nome;
	/**
	 * Armazena dni da pessoa
	 */
	private String dni;
	/**
	 * Armazena estado da pessoa
	 */
	private String estado;
	/**
	 * Armazena interesses da pessoa
	 */
	private String interesses;
	/**
	 * Armazena partido da pessoa
	 */
	private String partido;
	/**
	 * Armazena as funçoes que a pessoa exerce,podendo ser pessoa uma pessoa simples ou deputado
	 */
	private Funcao funcao;
	/**
	 * Inicia uma pessoa a partir do nome, dni, estado e interesses.
	 * @param nome da pessoa
	 * @param dni da pessoa
	 * @param estado da pessoa 
	 * @param interesses da pessoa
	 */
	public Pessoa(String nome, String dni, String estado, String interesses) {
		if (nome == null || nome.equals("")) {
			throw new IllegalArgumentException();
		}
		if (dni == null || !ValidaDni.validaDni(dni)) {
			throw new IllegalArgumentException();
		}
		if (estado == null || estado.equals("")) {
			throw new IllegalArgumentException();
		}
		if (interesses == null) {
			throw new IllegalArgumentException();
		}

		this.nome = nome;
		this.dni = dni;
		this.estado = estado;
		this.interesses = interesses;
		this.partido = "";
		this.funcao = null;
	}
	/**
	 * Inicia uma pessoa a partir do nome, dni, estado, interesses e partido.
	 * @param nome
	 * @param dni
	 * @param estado
	 * @param interesses
	 * @param partido
	 */
	public Pessoa(String nome, String dni, String estado, String interesses, String partido) {
		this(nome, dni, estado, interesses);

		if (partido == null || partido.equals("")) {
			throw new IllegalArgumentException();
		}

		this.partido = partido;
	}
	/**
	 * Retorna o nome da pessoa
	 * @return Uma String que representa o nome da pessoa
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * Retorna o dni da pessoa
	 * @return Uma String que representa o dni da pessoa
	 */
	public String getDni() {
		return dni;
	}
	/**
	 * Retorna o estado da pessoa
	 * @return Uma String que representa o estado da pessoa
	 */
	public String getEstado() {
		return estado;
	}
	/**
	 * Retorna os interesses da pessoa;
	 * @return Uma String que representa os interesses da pessoa
	 */
	public String getInteresses() {
		if (this.interesses == null|| this.interesses.equals("")) {
			return "";
		}
		else {
			return " - Interesses: " + this.interesses;
		}
	}
	/**
	 * Retorna o partido da pessoa;
	 * @return Uma String que representa o estado da pessoa
	 */
	public String getPartido() {
		if (partido == null || partido.equals("")) {
			return "";
		}
		else {
			return " - " + this.partido;
		}
	}
	/**
	 * Altera a funcao da pessoa;
	 * @param dataDeInicio da pessoa na nova funcao
	 */
	public void setFuncao(String dataDeInicio) {
		this.funcao = new Deputado(dataDeInicio);
	}                 
	/**
	 * Verifica se a pessoa exerce a funcao de deputado
	 * @return Um booleano,se a pessoa exerce a funcao de deputado retorna true,
	 * caso contrario retorna falso 
	 */
	public boolean isDeputado() {
		return funcao != null;
	}
	/**
	 * Retorna a representação textual da pessoa 
	 */
	@Override
	public String toString() {
		if (funcao == null) {
			return this.nome + " - " + this.dni + " (" + this.estado + ")" + this.getPartido() + this.getInteresses();
		}
		else {
			return "POL: " + this.nome + " - " + this.dni + " (" + this.estado + ")" + this.getPartido()
					+ this.getInteresses() + " - " + funcao.getDataDeInicio() + " - "
					+ funcao.getLeisAprovadas() + " Leis";
		}
	}
}
