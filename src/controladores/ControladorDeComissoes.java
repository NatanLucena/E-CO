package controladores;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entidades.Comissao;
import metodosAuxiliares.ValidadorGeral;
/**
 * Responsavel por representar todos os metodos envolvendo comissao
 * @author NatanLucena, CayoViegas, lucas-lucena, JacksonMateus
 *
 */
public class ControladorDeComissoes {
	
	/**
	 * Mapa usado para representar as comissoes cadastrados no sistema,onde
	 * acontece o mapeamento do identificador da comissao que é o nome da
	 * comissao,com os dados da comissao
	 */
	private Map<String, Comissao> comissoes;
	
	private ValidadorGeral validador;
	
	/**
	 * Constroi o controlador de comissao,inicializando o mapa de comissoes
	 * cadastradas
	 */
	public ControladorDeComissoes() {
		this.comissoes = new HashMap<>();
		this.validador = new ValidadorGeral();
	}
	
	/** 
	 * Cadastra comissoes no sistema,a partir do tema da comissao e da lista de politicos da comissao
	 * @param tema da comissao
	 * @param politicos que sao integrantes da comissao
	 */
	public void cadastraComissao(String tema, List<String> politicos) {
		validador.validaNullOuVazio(tema, "");
		if(this.comissoes.containsKey(tema)) {
			throw new IllegalArgumentException("");
		}else {
			this.comissoes.put(tema, new Comissao(tema, politicos));
		}
	}
	/**
	 * Verifica se a comissao esta cadastrada no sistema
	 * @param comissao que sera verificada se esta presente no sistema
	 * @return um boolean, se a comissao esta contida no sistema retorna true, 
	 * caso contrario retorna false
	 */
	public boolean containsComissao(String comissao) {
		return comissoes.containsKey(comissao);
	}
	
	/**
	 * Retorna os politicos que fazem parte da comissao, a partir do nome da comissao, 
	 * passada como parametro
	 * @param comissao sera retornado os politicos dessa comissao
	 * @return uma lista, com os politicos dessa comissao
	 */
	public List<String> getIntegrantes(String comissao) {
		return comissoes.get(comissao).getIntegrantes();
	}
}
