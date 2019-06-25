package controladores;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entidades.Deputado;
import entidades.Pessoa;
import metodosAuxiliares.ValidadorGeral;

public class ControladorDePessoasEDeputados implements Serializable {

	/**
	 * Armazena indentificador de versao de serializacao da classe ControladorDePessoaEDeputado.
	 */
	private static final long serialVersionUID = 2273665890759352701L;
	private Map<String, Pessoa> pessoas;
	private Map<String, Deputado> deputados;
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

		if (this.deputados.containsKey(dni)) {
			return this.deputados.get(dni).exibir();
		} else if (this.pessoas.containsKey(dni)) {
			return this.pessoas.get(dni).exibir();
		} else {
			throw new IllegalArgumentException("Erro ao exibir pessoa: pessoa nao encontrada");
		}
	}
	
	public Deputado getDeputado(String dni) {
		return this.deputados.get(dni);
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
		if (this.deputados.containsKey(dni)) {
			throw new IllegalArgumentException("Erro ao cadastrar deputado: deputado ja cadastrado");
		}

		Deputado novoDeputado = new Deputado(pessoa.getNome(), pessoa.getDni(), pessoa.getEstado(),
				pessoa.getInteresses2(), pessoa.getPartido2(), dataDeInicio);
		this.deputados.put(dni, novoDeputado);
	}

	public void propostaAprovada(String dni) {
		this.deputados.get(dni).setLeisAprovadas();
	}

	public boolean containsDeputado(String dni) {
		return this.deputados.containsKey(dni);
	}

	public boolean containsPessoa(String dni) {
		return this.pessoas.containsKey(dni);
	}

	public String getPartido(String dni) {
		return this.deputados.get(dni).getPartido2();
	}

	public List<String> getListaDeInteresses(String dni) {
		return deputados.get(dni).getListaDeInteresses();
	}

	public int totalDeDeputados() {
		return deputados.size();
	}
}