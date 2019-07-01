package controladores;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entidades.Comissao;
import entidades.Deputado;
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
	/**
	 * Armazena um validador que verifica e lanca excecoes comuns.
	 */
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
	public void cadastraComissao(String tema) {
		validador.validaNullOuVazio(tema, "");
		if(this.comissoes.containsKey(tema)) {
			throw new IllegalArgumentException("");
		}else {
			this.comissoes.put(tema, new Comissao(tema));
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
	 * Retorna uma comissao atraves do seu nome.
	 * 
	 * @param comissao nome da comissao que sera retornada
	 * 
	 * @return uma comissao
	 */
	public Comissao getComissao(String comissao) {
		return this.comissoes.get(comissao);
	}
	/**
	 * Cadastra um deputado e uma comissao.
	 * 
	 * @param tema nome da comissao
	 * @param deputado deputado que sera cadastrado na comissao
	 */
	public void cadastraIntegrante(String tema, Deputado deputado) {
		this.comissoes.get(tema).cadastraIntegrante(deputado);
	}
	
}
