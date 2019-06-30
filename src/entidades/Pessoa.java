package entidades;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import estrategias.Estrategia;
import estrategias.EstrategiaConstitucional;
import estrategias.EstrategiaAprovacao;
import estrategias.EstrategiaConclusao;
import metodosAuxiliares.ValidadorGeral;

/**
 * Responsavel por representar uma pessoa
 * 
 * @author NatanLucena, CayoViegas, lucas-lucena, JacksonMateus
 *
 */
public class Pessoa implements Serializable {

	/**
	 * Armazena indentificador de versao de serializacao da classe Pessoa.
	 */
	private static final long serialVersionUID = 4930726363577103229L;

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
	 * Validador de parametros, que lanca excecoes, caso necessario
	 */
	private ValidadorGeral validadorGeral;
	
	/**
	 * Armazena o tipo de estrategia de desempate para propostas os quais a pessoa possui interesses em comun.
	 */
	private Estrategia estrategia;

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
		validadorGeral.validaNullOuVazio(dni, "Erro ao cadastrar pessoa: dni nao pode ser vazio ou nulo");
		validadorGeral.validaDni(dni, "Erro ao cadastrar pessoa: dni invalido");
		validadorGeral.validaNullOuVazio(estado, "Erro ao cadastrar pessoa: estado nao pode ser vazio ou nulo");		

		this.nome = nome;
		this.dni = dni;
		this.estado = estado;
		this.interesses = interesses;
		this.partido = "";
		this.estrategia = new EstrategiaConstitucional();
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

		validadorGeral.validaNullOuVazio(partido, "Erro ao cadastrar pessoa: partido nao pode ser vazio");
		
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
	 * Retorna os interesses da pessoa para o metodo exibir();
	 * 
	 * @return uma String que representa os interesses da pessoa
	 */
	public String getInteressesToString() {
		if (this.interesses == null || this.interesses.equals("")) {
			return "";
		} else {
			return " - Interesses: " + this.interesses;
		}
	}
	
	/**
	 * Retorna os interesses da pessoa;
	 * 
	 * @return uma String que representa os interesses da pessoa
	 */
	public String getInteresses() {
		return this.interesses;
	}
	
	/**
	 * Retorna uma lista com os interesses de uma pessoa;
	 * 
	 * @return uma lista contendo interesses
	 */
	public List<String> getListaDeInteresses() {
		List<String> interesses = Arrays.asList(this.interesses.split(","));
		return interesses;
	}

	/**
	 * Retorna o partido da pessoa para o metodo exibir();
	 * 
	 * @return uma String que representa o estado da pessoa
	 */
	public String getPartidoToString() {
		if (partido == null || partido.equals("")) {
			return "";
		} else {
			return " - " + this.partido;
		}
	}
	
	/**
	 * Retorna somente o partido da pessoa;
	 * 
	 * @return uma String que representa o estado da pessoa
	 */
	public String getPartido() {
		return this.partido;
	}
	
	/**
	 * Altera o tipo de estrategia de desempate.
	 * 
	 * @param novaEstrategia nova estrategia que sera implementada por essa pessoa
	 */
	public void setEstrategia(Estrategia novaEstrategia) {
		this.estrategia = novaEstrategia;
	}
	
	/**
	 * Retorna o codigo da proposta mais adequada de acordo com o tipo da estrategia.
	 * 
	 * @param propostas propostas que serao verificadas
	 * 
	 * @return o codigo da proposta mais adequada de acordo com o tipo da estrategia
	 */
	public String desempate(List<PropostaLegislativa> propostas) {
		return this.estrategia.desempate(propostas);
	}


	/**
	 * Este metodo retorna a representacao textual da pessoa
	 * 
	 * @return uma String contendo todas as informacoes disponiveis da pessoa
	 */
	public String exibir() {
		return this.getNome() + " - " + this.getDni() + " (" + this.getEstado() + ")" + this.getPartidoToString() + this.getInteressesToString();
	}
	
}
