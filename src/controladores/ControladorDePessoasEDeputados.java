package controladores;

import java.util.HashMap;
import java.util.Map;

import entidades.Pessoa;
import metodosAuxiliares.ValidaDni;

public class ControladorDePessoasEDeputados {

	private Map<String, Pessoa> pessoas;

	public ControladorDePessoasEDeputados() {
		this.pessoas = new HashMap<>();
	}

	public void cadastrarPessoa(String nome, String dni, String estado, String interesses) {
		if (nome == null || nome.equals("")) {
			throw new IllegalArgumentException("Erro ao cadastrar pessoa: nome nao pode ser vazio ou nulo");
		} else if (dni == null || dni.equals("")) {
			throw new IllegalArgumentException("Erro ao cadastrar pessoa: dni nao pode ser vazio ou nulo");
		} else if (!ValidaDni.validaDni(dni)) {
			throw new IllegalArgumentException("Erro ao cadastrar pessoa: dni invalido");
		} else if (estado == null || estado.equals("")) {
			throw new IllegalArgumentException("Erro ao cadastrar pessoa: estado nao pode ser vazio ou nulo");
		}
	}
}
