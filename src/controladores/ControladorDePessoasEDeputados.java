package controladores;

import java.util.HashMap;
import java.util.Map;

import entidades.Pessoa;
import metodosAuxiliares.ValidaDataDeInicio;
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
		} else if (estado == null || estado.equals("")) {
			throw new IllegalArgumentException("Erro ao cadastrar pessoa: estado nao pode ser vazio ou nulo");
		} else if (!ValidaDni.validaDni(dni)) {
			throw new IllegalArgumentException("Erro ao cadastrar pessoa: dni invalido");
		} else if (pessoas.containsKey(dni)) {
			throw new IllegalArgumentException("Erro ao cadastrar pessoa: dni ja cadastrado");
		} else {
			this.pessoas.put(dni, new Pessoa(nome, dni, estado, interesses));
		}
	}

	public void cadastrarPessoaComPartido(String nome, String dni, String estado, String interesses, String partido) {
		if (nome == null || nome.equals("")) {
			throw new IllegalArgumentException("Erro ao cadastrar pessoa: nome nao pode ser vazio ou nulo");
		} else if (dni == null || dni.equals("")) {
			throw new IllegalArgumentException("Erro ao cadastrar pessoa: dni nao pode ser vazio ou nulo");
		} else if (estado == null || estado.equals("")) {
			throw new IllegalArgumentException("Erro ao cadastrar pessoa: estado nao pode ser vazio ou nulo");
		} else if (!ValidaDni.validaDni(dni)) {
			throw new IllegalArgumentException("Erro ao cadastrar pessoa: dni invalido");
		} else if (pessoas.containsKey(dni)) {
			throw new IllegalArgumentException("Erro ao cadastrar pessoa: dni ja cadastrado");
		} else {
			this.pessoas.put(dni, new Pessoa(nome, dni, estado, interesses, partido));
		}
	}

	public String exibirPessoa(String dni) {
		if (dni == null || dni.equals(""))
			throw new IllegalArgumentException("Erro ao exibir pessoa: dni nao pode ser vazio ou nulo");
		else if (!ValidaDni.validaDni(dni))
			throw new IllegalArgumentException("Erro ao exibir pessoa: dni invalido");
		else {
			if (this.pessoas.containsKey(dni))
				return this.pessoas.get(dni).toString();
			else
				throw new IllegalArgumentException("Erro ao exibir pessoa: pessoa nao encontrada");
		}
	}

	public void cadastrarDeputado(String DNI, String dataDeInicio) {
		if (DNI == null || DNI.equals("")) {
			throw new IllegalArgumentException("Erro ao cadastrar deputado: dni nao pode ser vazio ou nulo");
		}
		if (!ValidaDni.validaDni(DNI)) {
			throw new IllegalArgumentException("Erro ao cadastrar deputado: dni invalido");
		}
		if (dataDeInicio == null || dataDeInicio.equals("")) {
			throw new IllegalArgumentException("Erro ao cadastrar deputado: data nao pode ser vazio ou nulo");
		}
		if (!ValidaDataDeInicio.validaDataDeInicio(dataDeInicio)) {
			throw new IllegalArgumentException("Erro ao cadastrar deputado: data invalida");
		}
		if (!pessoas.containsKey(DNI)) {
			throw new IllegalArgumentException("Erro ao cadastrar deputado: pessoa nao encontrada");
		}

		else {
			Pessoa pessoa = pessoas.get(DNI);

			if (pessoa.getPartido().equals("")) {
				throw new IllegalArgumentException("Erro ao cadastrar deputado: pessoa sem partido");
			}

			else if (pessoa.isDeputado()) {
				throw new IllegalArgumentException("Erro ao cadastrar deputado: deputado ja cadastrado");
			} else {
				pessoa.setFuncao(dataDeInicio);
			}
		}
	}
}