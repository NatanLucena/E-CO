package controladores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import entidades.Comissao;
import metodosAuxiliares.ValidadorGeral;

public class ControladorDeComissoes {
	private Map<String, Comissao> comissoes;
	private ValidadorGeral validador;
	
	public ControladorDeComissoes() {
		this.comissoes = new HashMap<>();
		this.validador = new ValidadorGeral();
	}
	
	public void cadastraComissao(String tema, ArrayList<String> politicos) {
		validador.validaNullOuVazio(tema, "");
		if(this.comissoes.containsKey(tema)) {
			throw new IllegalArgumentException("");
		}else {
			this.comissoes.put(tema, new Comissao(tema, politicos));
		}
	}
}
