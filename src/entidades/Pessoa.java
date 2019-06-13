package entidades;

import metodosAuxiliares.ValidadorGeral;

/**
 * É responsavel por representar uma pessoa
 * 
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
	 * Muda a forma de exibicao entre Pessoa ou Deputado
	 */
	private Exibir exibir;

	/**
	 * Validador de parametros, que lanca excecoes, caso necessario
	 */
	private ValidadorGeral validadorGeral;

	/**
	 * Inicia uma pessoa a partir do nome, dni, estado e interesses, alem de
	 * inicializar o Validador
	 * 
	 * @param nome       uma String que representa o nome da pessoa
	 * @param dni        uma String que representa o Documento Nacional de
	 *                   Identificacao da pessoa
	 * @param estado     uma String que representa o estado de origem da pessoa
	 * @param interesses uma String que representa os interesses da pessoa
	 */
	public Pessoa(String nome, String dni, String estado, String interesses) {
		this.validadorGeral = new ValidadorGeral();

		validadorGeral.validaNullOuVazio(nome, "Erro ao cadastrar pessoa: nome nao pode ser vazio ou nulo");
		validadorGeral.validaNullOuVazio(estado, "Erro ao cadastrar pessoa: estado nao pode ser vazio ou nulo");
		validadorGeral.validaDni(dni, "Erro ao cadastrar pessoa: dni nao pode ser vazio ou nulo");

		this.nome = nome;
		this.dni = dni;
		this.estado = estado;
		this.interesses = interesses;
		this.partido = "";
		this.exibir = new PessoaComum();
	}

	/**
	 * Inicia uma pessoa a partir do nome, dni, estado e interesses, alem de
	 * inicializar o Validador
	 * 
	 * @param nome       uma String que representa o nome da pessoa
	 * @param dni        uma String que representa o Documento Nacional de
	 *                   Identificacao da pessoa
	 * @param estado     uma String que representa o estado de origem da pessoa
	 * @param interesses uma String que representa os interesses da pessoa
	 * @param partido    uma String que representa o partido ao qual a pessoa é
	 *                   filiada
	 */
	public Pessoa(String nome, String dni, String estado, String interesses, String partido) {
		this(nome, dni, estado, interesses);

		this.partido = partido;
	}

	/**
	 * Retorna o nome da pessoa
	 * 
	 * @return uma String que representa o nome da pessoa
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Retorna o dni da pessoa
	 * 
	 * @return uma String que representa o Documento Nacional de Identificacao da
	 *         pessoa
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * Retorna o estado da pessoa
	 * 
	 * @return uma String que representa o estado da pessoa
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * Retorna os interesses da pessoa;
	 * 
	 * @return uma String que representa os interesses da pessoa
	 */
	public String getInteresses() {
		if (this.interesses == null || this.interesses.equals("")) {
			return "";
		} else {
			return " - Interesses: " + this.interesses;
		}
	}

	/**
	 * Retorna o partido da pessoa;
	 * 
	 * @return uma String que representa o estado da pessoa
	 */
	public String getPartido() {
		if (partido == null || partido.equals("")) {
			return "";
		} else {
			return " - " + this.partido;
		}
	}

	/**
	 * Altera a funcao de uma pessoa
	 * 
	 * @param dataDeInicio uma String que representa a data de inicio da pessoa na
	 *                     nova funcao
	 */
	public void assumeFuncao(String dataDeInicio) {
		this.exibir = new Deputado(dataDeInicio);
	}

	/**
	 * Verifica se a pessoa exerce a funcao de deputado
	 * 
	 * @return Um booleano,se a pessoa exerce a funcao de deputado retorna true,
	 *         caso contrario retorna falso
	 */
	public boolean isDeputado() {
		return exibir.getClass().equals(Deputado.class);
	}

	/**
	 * Este metodo retorna a representacao textual da pessoa
	 * 
	 * @return uma String contendo todas as informacoes disponiveis da pessoa
	 */
	public String exibir() {
		return exibir.exibir(nome, dni, estado, this.getPartido(), this.getInteresses());
	}
}
