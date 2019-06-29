package controladores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entidades.Deputado;
import entidades.Pessoa;
import entidades.PropostaLegislativa;
import estrategias.Estrategia;
import estrategias.EstrategiaAprovacao;
import estrategias.EstrategiaConclusao;
import estrategias.EstrategiaConstitucional;
import metodosAuxiliares.ValidadorGeral;

/**
 * Responsavel por todos os metodos envolvendo pessoa normal e deputado
 * @author JacksonMateus
 *
 */
public class ControladorDePessoasEDeputados implements Serializable {

	/**
	 * Armazena indentificador de versao de serializacao da classe
	 * ControladorDePessoaEDeputado.
	 */
	private static final long serialVersionUID = 2273665890759352701L;
	
	/**
	 * Armazena um mapa de pessoas cadastradas no sistema que possuem o seu dni como
	 * identificador.
	 */
	private Map<String, Pessoa> pessoas;
	
	/**
	 * Armazena um mapa de deputados cadastrados no sistema que possuem o seus dni
	 * como identificador.
	 */
	private Map<String, Deputado> deputados;
	
	/**
	 * Armazena um validador que verifica e lanca excecoes comuns.
	 */
	private ValidadorGeral validadorGeral;

	/**
	 * Constroi um controlador de pessoas e deputados.
	 */
	public ControladorDePessoasEDeputados() {
		this.pessoas = new HashMap<>();
		this.deputados = new HashMap<>();
		this.validadorGeral = new ValidadorGeral();
	}

	/**
	 * Cadastra uma pessoa no sistema.
	 * 
	 * @param nome       nome da pessoa que sera cadastrada
	 * @param dni        dni da pessoa que sera cadastrada
	 * @param estado     estado da pessoa que sera cadastrada
	 * @param interesses interesses da pessoa que sera cadastrada
	 * 
	 * @throws IllegalArgumentException caso algum parametro passado seja invalido
	 */
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

	/**
	 * Cadastra uma pessoa com partido no sistema.
	 * 
	 * @param nome       nome da pessoa que sera cadastrada
	 * @param dni        dni da pessoa que sera cadastrada
	 * @param estado     estado da pessoa que sera cadastrada
	 * @param interesses interesses da pessoa que sera cadastrada
	 * @param partido    partido politico da pessoa que sera cadastrada
	 * 
	 * @throws IllegalArgumentException caso algum parametro passado seja invalido
	 */
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

	/**
	 * Retorna uma representacao em string de uma pessoa do sistema.
	 * 
	 * @param dni dni da pessoa que sera exibida
	 * 
	 * @throws IllegalArgumentException caso o dni passado seja invalido
	 * 
	 * @return uma representacao em string de uma pessoa do sistema
	 */
	public String exibirPessoa(String dni) {
		validadorGeral.validaNullOuVazio(dni, "Erro ao exibir pessoa: dni nao pode ser vazio ou nulo");
		validadorGeral.validaDni(dni, "Erro ao exibir pessoa: dni invalido");

		if (this.deputados.containsKey(dni)) {
			return this.deputados.get(dni).exibir();
		} 
		else if (this.pessoas.containsKey(dni)) {
			return this.pessoas.get(dni).exibir();
		} 
		else {
			throw new IllegalArgumentException("Erro ao exibir pessoa: pessoa nao encontrada");
		}
	}

	/**
	 * Retorna um deputado do sistema atraves do seu dni
	 * 
	 * @param dni dni do deputado que sera retornado
	 * 
	 * @return um deputado do sistema
	 */
	public Deputado getDeputado(String dni) {
		return this.deputados.get(dni);
	}

	/**
	 * Metodo que cadastra um deputado no sistema.
	 * 
	 * @param dni          dni da pessoa que se tornou um deputado
	 * @param dataDeInicio a data em que o deputado iniciou seu mandato
	 * 
	 * @throws IllegalArgumentException caso algum parametro passado seja invalido
	 */
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
				pessoa.getInteresses(), pessoa.getPartido(), dataDeInicio);
		this.deputados.put(dni, novoDeputado);
	}

	/**
	 * Verifica se um deputado existe no sistema atraves de seu dni.
	 * 
	 * @param dni dni do deputado que sera verificado
	 * 
	 * @return um boolean referente a existencia ou nao do deputado no sistema
	 */
	public boolean containsDeputado(String dni) {
		return this.deputados.containsKey(dni);
	}

	/**
	 * Verifica se uma pessoa existe no sistema atraves de seu dni.
	 * 
	 * @param dni dni da pessoa que sera verificada
	 * 
	 * @return um boolean referente a existencia ou nao da pessoa no sistema
	 */
	public boolean containsPessoa(String dni) {
		return this.pessoas.containsKey(dni);
	}

	/**
	 * Retorna um partido de um deputado atraves de seu dni.
	 * 
	 * @param dni dni do deputado
	 * 
	 * @return o partido do deputado
	 */
	public String getPartido(String dni) {
		validadorGeral.validaNullOuVazio(dni, "Erro ao recuperar partido: dni nao pode ser vazia ou nula");
		validadorGeral.validaDni(dni, "Erro ao recuperar partido: dni invalida");
		return this.deputados.get(dni).getPartido();
	}

	/**
	 * Retorna uma lista de deputados atraves de uma lista de dni
	 * 
	 * @param deputados lista de dni
	 * 
	 * @return uma lista de deputados
	 */
	public List<Deputado> getPresentes(List<String> deputados) {
		List<Deputado> presentes = new ArrayList<>();
		for (int i = 0; i < deputados.size(); i++) {
			presentes.add(this.deputados.get(deputados.get(i)));
		}
		return presentes;
	}

	/**
	 * Retorna a lista de interesses de um deputado atraves de seu dni.
	 * 
	 * @param dni dni do deputado
	 * 
	 * @return uma lista de interesses de um deputado
	 */
	public List<String> getListaDeInteresses(String dni) {
		validadorGeral.validaNullOuVazio(dni, "Erro ao recuperar lista de interesses de um deputado: dni nao pode ser vazio ou nulo.");
		validadorGeral.validaDni(dni, "Erro ao recuperar lista de interesses de um deputado: dni inavlido.");
		return pessoas.get(dni).getListaDeInteresses();
	}

	/**
	 * Retorna o numero total de deputados cadastrados no sistema.
	 * 
	 * @return o numero total de deuputados cadastrados no sistema
	 */
	public int totalDeDeputados() {
		return deputados.size();
	}

	/**
	 * Metodo que altera o tipo de estrategia de desempate para a pessoa passada como parametro.
	 * 
	 * @param dni dni da pessoa que tera sua estategia alterada
	 * 
	 * @param estrategia o novo tipo de estrategia que sera implementado
	 * 
	 */
	public void setEstrategia(String dni, String estrategia) {
		Estrategia novaEstrategia;
		if(estrategia.equalsIgnoreCase("CONCLUSAO")) {
			novaEstrategia = new EstrategiaConclusao();
		}else if(estrategia.equalsIgnoreCase("APROVACAO")) {
			novaEstrategia = new EstrategiaAprovacao();
		}else {
			novaEstrategia = new EstrategiaConstitucional();
		}
		pessoas.get(dni).setEstrategia(novaEstrategia);
	}
	
	/**
	 * Retorna a proposta mais adequada, para a pessoa passada, dentre as propostas da lista.
	 * 
	 * @param dni dni da pessoa que ira executar o desempate
	 * 
	 * @return a proposta mais adequada a pessoa que foi passada como parametro
	 * 
	 */
	public String desempate(String dni, List<PropostaLegislativa> propostas) {
		return pessoas.get(dni).desempate(propostas);
	}
}