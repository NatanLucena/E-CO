package controladores;

import java.util.HashMap;
import java.util.Map;

import entidades.Pessoa;
import metodosAuxiliares.ValidadorGeral;

public class ControladorDePessoasEDeputados {

	private Map<String, Pessoa> pessoas;
	private Map<String, Pessoa> deputados;
	private ValidadorGeral validadorGeral;

	public ControladorDePessoasEDeputados() {
		this.pessoas = new HashMap<>();
		this.deputados = new HashMap<>();
		this.validadorGeral = new ValidadorGeral();
	}

	public void cadastrarPessoa(String nome, String dni, String estado, String interesses) {
		validadorGeral.validaNullOuVazio(nome, "Erro ao cadastrar pessoa: nome nao pode ser vazio ou nulo");
		validadorGeral.validaNullOuVazio(dni, "Erro ao cadastrar pessoa: dni nao pode ser vazio ou nulo");
		validadorGeral.validaNullOuVazio(estado, "Erro ao cadastrar pessoa: estado nao pode ser vazio ou nulo");
		validadorGeral.validaDni(dni, "Erro ao cadastrar pessoa: dni invalido");

		if (pessoas.containsKey(dni)) {
			throw new IllegalArgumentException("Erro ao cadastrar pessoa: dni ja cadastrado");
		} else {
			this.pessoas.put(dni, new Pessoa(nome, dni, estado, interesses));
		}
	}

	public void cadastrarPessoaComPartido(String nome, String dni, String estado, String interesses, String partido) {
		validadorGeral.validaNullOuVazio(nome, "Erro ao cadastrar pessoa: nome nao pode ser vazio ou nulo");
		validadorGeral.validaNullOuVazio(dni, "Erro ao cadastrar pessoa: dni nao pode ser vazio ou nulo");
		validadorGeral.validaNullOuVazio(estado, "Erro ao cadastrar pessoa: estado nao pode ser vazio ou nulo");
		validadorGeral.validaDni(dni, "Erro ao cadastrar pessoa: dni invalido");

		if (pessoas.containsKey(dni)) {
			throw new IllegalArgumentException("Erro ao cadastrar pessoa: dni ja cadastrado");
		} else {
			this.pessoas.put(dni, new Pessoa(nome, dni, estado, interesses, partido));
		}
	}

	public String exibirPessoa(String dni) {
		validadorGeral.validaNullOuVazio(dni, "Erro ao exibir pessoa: dni nao pode ser vazio ou nulo");
		validadorGeral.validaDni(dni, "Erro ao exibir pessoa: dni invalido");

		if (!this.pessoas.containsKey(dni)) {
			throw new IllegalArgumentException("Erro ao exibir pessoa: pessoa nao encontrada");
		} else {
			return this.pessoas.get(dni).exibir();
		}
	}

	public void cadastrarDeputado(String dni, String dataDeInicio) {
		validadorGeral.validaNullOuVazio(dni, "Erro ao cadastrar deputado: dni nao pode ser vazio ou nulo");
		validadorGeral.validaDni(dni, "Erro ao cadastrar deputado: dni invalido");

		if (!pessoas.containsKey(dni)) {
			throw new IllegalArgumentException("Erro ao cadastrar deputado: pessoa nao encontrada");
		}

		validadorGeral.validaNullOuVazio(dataDeInicio, "Erro ao cadastrar deputado: data nao pode ser vazio ou nulo");

		Pessoa pessoa = pessoas.get(dni);

		validadorGeral.verificaExistenciaDeLetras(dataDeInicio);
		validadorGeral.validaDataDeInicio(dataDeInicio);
		validadorGeral.verificaDataFutura(dataDeInicio);

		if (pessoa.getPartido().equals("")) {
			throw new IllegalArgumentException("Erro ao cadastrar deputado: pessoa sem partido");
		}
		if (pessoa.isDeputado()) {
			throw new IllegalArgumentException("Erro ao cadastrar deputado: deputado ja cadastrado");
		}

		pessoa.assumeFuncao(dataDeInicio);
	}

	public boolean containsDeputado(String dni) {
		return this.deputados.containsKey(dni);
	}

	public boolean containsPessoa(String dni) {
		return this.pessoas.containsKey(dni);
	}
}