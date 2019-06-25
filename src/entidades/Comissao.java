package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Responsavel por representar uma comissao no sistema
 * @author NatanLucena, CayoViegas, lucas-lucena, JacksonMateus
 *
 */
public class Comissao implements Serializable {
	/**
	 * Armazena indentificador de versao de serializacao da classe Comissao.
	 */
	private static final long serialVersionUID = -1190752484642864132L;
	
	/**
	 * Armazena o tema da comissao
	 */
	private String tema;
	/**
	 * Armazena todos os integrantes que fazem parte da comissao
	 */
	private List<String> integrantes;
	/**
	 * Inicia a comissao a partir do tema, e com uma lista com os integrantes da comissao
	 * @param tema da comissao
	 * @param integrantes da comissao
	 */
	public Comissao(String tema, List<String> integrantes) {
		this.tema = tema;
		this.integrantes = new ArrayList<>();
		this.integrantes.addAll(integrantes);
	}
	
	/**
	 * Retorna o tema da comissao
	 * @return uma String que representa o tema da comissao
	 */
	public String getTema() {
		return tema;
	}
	/**
	 * Retorna os integrantes da comissao
	 * @return uma lista, com todos os integrantes da comissao
	 */
	public List<String> getIntegrantes() {
		return integrantes;
	}
	

}
