package controladores;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import entidades.Partido;
import metodosAuxiliares.ValidadorGeral;

/**
 * Responsavel por representar todos os metodos envolvendo Partidos
 * @author NatanLucena, CayoViegas, lucas-lucena, JacksonMateus
 *
 */
public class ControladorDePartidos {
	
	/**
	 * Armazena todos os partidos cadastrados no sistema, onde acontece o 
	 * mapeameto do identificador do partido que é o nome do partido, com os dados que um partido tem
	 */
	private Map<String, Partido> partidos;
	
	/**
	 * Validador de parametros, que lanca excecoes, caso necessario
	 */
	private ValidadorGeral validadorGeral;

	/**
	 * Constroi o controlador de partidos, inicializando o mapa de partidos. Tambem inicializa o Validador
	 */
	public ControladorDePartidos() {
		this.partidos = new HashMap<>();
		this.validadorGeral = new ValidadorGeral();
	}

	/**
	 * Cadastra partidos no sistema, a partir do nome do partido
	 * @param partido String que representa o nome do partido
	 */

	public void cadastraPartido(String partido) {
		validadorGeral.validaNullOuVazio(partido, "Erro ao cadastrar partido: partido nao pode ser vazio ou nulo");

		if (partidos.containsKey(partido)) {
			throw new IllegalArgumentException("Erro ao cadastrar partido: partido ja cadastrado");
		} else {
			partidos.put(partido, new Partido(partido));
		}
	}

	/**
	 * Representacao textual com os nomes de todos os partidos da base politica
	 * @return uma String com os nomes de todos os partidos da base politica
	 */
	public String exibirBase() {
		return this.partidos.values().stream().sorted((i, j) -> i.getPartido().compareTo(j.getPartido()))
				.map(Partido::getPartido).collect(Collectors.joining(","));
	}

	/**
	 * Verifica se o partido esta cadastrado no sistema
	 * @param partido que sera verificado 
	 * @return um booleano,se o partido passado com parametro esta cadastrado no sistema retorna true, 
	 * caso contrario retorna false
	 *  
	 */
	public boolean verificaPartido(String partido) {
		return partidos.containsKey(partido);
	}
}
