package controladores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import entidades.PropostaLegislativa;
import entidades.Votacao;
import metodosAuxiliares.ValidadorGeral;

/**
 * Responsavel por ser o controlador geral do sistema.
 * 
 * @author JacksonMateus
 *
 */
public class ControladorGeral implements Serializable {
	/**
	 * Armazena indentificador de versao de serializacao da classe ControladorGeral.
	 */
	private static final long serialVersionUID = -3617749414434865217L;
	/**
	 * Armazena um controlador de comissoes.
	 */
	private ControladorDeComissoes controladorDeComissoes;
	/**
	 * Armazena um controlador de pessoas e deputados.
	 */
	private ControladorDePessoasEDeputados controladorDePessoasEDeputados;
	/**
	 * Armazena um controlador de propostas legislativas.
	 */
	private ControladorDePropostasLegislativas controladorDePropostasLegislativas;
	/**
	 * Armazena uma votacao.
	 */
	private Votacao votacao;
	/**
	 * Armazena uma lista dos partidos da base do governo.
	 */
	private List<String> baseGovernista;
	/**
	 * Armazena um validador que verifica e lanca excecoes comuns.
	 */
	private ValidadorGeral validador;

	/**
	 * Constroi um controlador geral no sistema.
	 */
	public ControladorGeral() {
		this.controladorDeComissoes = new ControladorDeComissoes();
		this.controladorDePessoasEDeputados = new ControladorDePessoasEDeputados();
		this.controladorDePropostasLegislativas = new ControladorDePropostasLegislativas();
		this.votacao = new Votacao();
		this.validador = new ValidadorGeral();
		this.baseGovernista = new ArrayList<>();
	}

	/**
	 * Cadastra uma pessoa no sistema com base em seu nome, dni, estado e
	 * interesses.
	 * 
	 * @param nome       nome da pessoa que sera cadastrada
	 * @param dni        dni da pessoa que sera cadastrada
	 * @param estado     estado da pessoa que sera cadastrada
	 * @param interesses interesses da pessoa que sera cadastrada
	 */
	public void cadastrarPessoa(String nome, String dni, String estado, String interesses) {
		this.controladorDePessoasEDeputados.cadastrarPessoa(nome, dni, estado, interesses);
	}

	/**
	 * Cadastra uma pessoa com partido no sistema com base em seu nome, dni, estado,
	 * interesses e partido.
	 * 
	 * @param nome       nome da pessoa que sera cadastrada
	 * @param dni        dni da pessoa que sera cadastrada
	 * @param estado     estado da pessoa que sera cadastrada
	 * @param interesses interesses da pessoa que sera cadastrada
	 * @param partido    partido da pessoa que sera cadastrada
	 */
	public void cadastrarPessoaComPartido(String nome, String dni, String estado, String interesses, String partido) {
		this.controladorDePessoasEDeputados.cadastrarPessoaComPartido(nome, dni, estado, interesses, partido);
	}

	/**
	 * Retorna uma representacao em string de uma pessoa atraves de seu dni.
	 * 
	 * @param dni dni da pessoa que sera exibida
	 * 
	 * @return uma representacao em string de uma pessoa
	 */
	public String exibirPessoa(String dni) {
		return this.controladorDePessoasEDeputados.exibirPessoa(dni);
	}

	/**
	 * Cadastra um deputado no sistema atraves do seu dni e da data do inicio de se
	 * mandato.
	 * 
	 * @param dni          dni do deputado
	 * @param dataDeInicio data de inicio do mandato
	 */
	public void cadastrarDeputado(String dni, String dataDeInicio) {
		this.controladorDePessoasEDeputados.cadastrarDeputado(dni, dataDeInicio);
	}

	/**
	 * Cadastra um partido da base do governo no sistema.
	 * 
	 * @param partido no do partido que sera cadastrado
	 * 
	 * @throws IllegalArgumentException caso o nome do partido passado seja invalido
	 */
	public void cadastrarPartido(String partido) {
		validador.validaNullOuVazio(partido, "Erro ao cadastrar partido: partido nao pode ser vazio ou nulo");
		if (this.baseGovernista.contains(partido)) {
			throw new IllegalArgumentException("Erro ao cadastrar partido: partido ja cadastrado");
		}
		baseGovernista.add(partido);
		this.votacao.cadastraPartido(partido);

	}

	/**
	 * Retorna uma representacao em string de todos os partidos da base do governo
	 * em ordem alfabetica.
	 * 
	 * @return uma representacao em string de todos os partidos da base do governo
	 *         em ordem alfabetica
	 */
	public String exibirBase() {
		Collections.sort(this.baseGovernista);
		return String.join(",", this.baseGovernista);
	}

	/**
	 * Cadastra uma comissao no sistema atraves do seu nome e do dni de seus
	 * integrantes.
	 * 
	 * @param tema      nome da comissao
	 * @param politicos integrantes da comissao
	 * 
	 * @throws IllegalArgumentExcetpion caso algum parametro passado seja invalido
	 */
	public void cadastraComissao(String tema, String politicos) {
		validador.validaNullOuVazio(tema, "Erro ao cadastrar comissao: tema nao pode ser vazio ou nulo");
		validador.validaNullOuVazio(politicos,
				"Erro ao cadastrar comissao: lista de politicos nao pode ser vazio ou nulo");
		if (controladorDeComissoes.containsComissao(tema)) {
			throw new IllegalArgumentException("Erro ao cadastrar comissao: tema existente");
		}

		List<String> dnis = Arrays.asList(politicos.split(","));
		dnis.stream().forEach(dni -> validador.validaDni(dni, "Erro ao cadastrar comissao: dni invalido"));
		dnis.stream().forEach(dni -> this.validaDniPessoa(dni, "Erro ao cadastrar comissao: pessoa inexistente"));
		dnis.stream().forEach(dni -> this.validaDniDeputado(dni, "Erro ao cadastrar comissao: pessoa nao eh deputado"));

		this.controladorDeComissoes.cadastraComissao(tema);

		dnis.stream().forEach(
				p -> controladorDeComissoes.cadastraIntegrante(tema, controladorDePessoasEDeputados.getDeputado(p)));
	}

	/**
	 * Cadastra uma proposta legislativa do tipo PL no sistema.
	 * 
	 * @param autor      autor da proposta
	 * @param ano        ano da proposta
	 * @param ementa     ementa da proposta
	 * @param interesses interesses da proposta
	 * @param url        link URL da proposta
	 * @param conclusivo um boolean que demonstra se a proposta e conclusiva ou nao
	 * 
	 * @throws IllegalArgumentException caso algum parametro passado seja invalido
	 * 
	 * @return o codigo da proposta apos cadastrado
	 */
	public String cadastrarPL(String autor, int ano, String ementa, String interesses, String url, boolean conclusivo) {
		validador.validaNullOuVazio(autor, "Erro ao cadastrar projeto: autor nao pode ser vazio ou nulo");
		validador.validaDni(autor, "Erro ao cadastrar projeto: dni invalido");
		validador.validaNullOuVazio(ementa, "Erro ao cadastrar projeto: ementa nao pode ser vazia ou nula");
		validador.validaNullOuVazio(interesses, "Erro ao cadastrar projeto: interesse nao pode ser vazio ou nulo");
		validador.validaNullOuVazio(url, "Erro ao cadastrar projeto: url nao pode ser vazio ou nulo");

		if (!controladorDePessoasEDeputados.containsPessoa(autor)) {
			throw new IllegalArgumentException("Erro ao cadastrar projeto: pessoa inexistente");
		} else if (!controladorDePessoasEDeputados.containsDeputado(autor)) {
			throw new IllegalArgumentException("Erro ao cadastrar projeto: pessoa nao eh deputado");
		}

		
		if (ano < 1988) {
			throw new IllegalArgumentException("Erro ao cadastrar projeto: ano anterior a 1988");
		} else if (ano > 2019) {
			throw new IllegalArgumentException("Erro ao cadastrar projeto: ano posterior ao ano atual");
		}
		return this.controladorDePropostasLegislativas.cadastrarPL(autor, ano, ementa, interesses, url, conclusivo);
	}

	/**
	 * Cadastra uma proposta legislativa do tipo PLP no sistema.
	 * 
	 * @param autor      autor da proposta
	 * @param ano        ano da proposta
	 * @param ementa     ementa da proposta
	 * @param interesses interesses da proposta
	 * @param url        link URL da proposta
	 * @param artigos    artigos da constituicao que serao afetados
	 * 
	 * @throws IllegalArgumentException caso algum parametro passado seja invalido
	 * 
	 * @return o codigo da proposta apos cadastrado
	 */
	public String cadastrarPLP(String autor, int ano, String ementa, String interesses, String url, String artigos) {
		validador.validaNullOuVazio(autor, "Erro ao cadastrar projeto: autor nao pode ser vazio ou nulo");
		validador.validaDni(autor, "Erro ao cadastrar projeto: dni invalido");

		if (!controladorDePessoasEDeputados.containsPessoa(autor)) {
			throw new IllegalArgumentException("Erro ao cadastrar projeto: pessoa inexistente");
		} else if (!controladorDePessoasEDeputados.containsDeputado(autor)) {
			throw new IllegalArgumentException("Erro ao cadastrar projeto: pessoa nao eh deputado");
		}

		validador.validaNullOuVazio(ementa, "Erro ao cadastrar projeto: ementa nao pode ser vazia ou nula");
		validador.validaNullOuVazio(interesses, "Erro ao cadastrar projeto: interesse nao pode ser vazio ou nulo");
		validador.validaNullOuVazio(url, "Erro ao cadastrar projeto: url nao pode ser vazio ou nulo");
		validador.validaNullOuVazio(artigos, "Erro ao cadastrar projeto: artigo nao pode ser vazio ou nulo");

		if (ano < 1988) {
			throw new IllegalArgumentException("Erro ao cadastrar projeto: ano anterior a 1988");
		} else if (ano > 2019) {
			throw new IllegalArgumentException("Erro ao cadastrar projeto: ano posterior ao ano atual");
		}
		return this.controladorDePropostasLegislativas.cadastrarPLP(autor, ano, ementa, interesses, url, artigos);
	}

	/**
	 * Cadastra uma proposta legislativa do tipo PEC no sistema.
	 * 
	 * @param autor      autor da proposta
	 * @param ano        ano da proposta
	 * @param ementa     ementa da proposta
	 * @param interesses interesses da proposta
	 * @param url        link URL da proposta
	 * @param artigos    artigos da constituicao que serao afetados
	 * 
	 * @throws IllegalArgumentException caso algum parametro passado seja invalido
	 * 
	 * @return o codigo da proposta apos cadastrado
	 */
	public String cadastrarPEC(String autor, int ano, String ementa, String interesses, String url, String artigos) {
		validador.validaNullOuVazio(autor, "Erro ao cadastrar projeto: autor nao pode ser vazio ou nulo");
		validador.validaDni(autor, "Erro ao cadastrar projeto: dni invalido");

		if (!controladorDePessoasEDeputados.containsPessoa(autor)) {
			throw new IllegalArgumentException("Erro ao cadastrar projeto: pessoa inexistente");
		} else if (!controladorDePessoasEDeputados.containsDeputado(autor)) {
			throw new IllegalArgumentException("Erro ao cadastrar projeto: pessoa nao eh deputado");
		}

		validador.validaNullOuVazio(ementa, "Erro ao cadastrar projeto: ementa nao pode ser vazia ou nula");
		validador.validaNullOuVazio(interesses, "Erro ao cadastrar projeto: interesse nao pode ser vazio ou nulo");
		validador.validaNullOuVazio(url, "Erro ao cadastrar projeto: url nao pode ser vazio ou nulo");
		validador.validaNullOuVazio(artigos, "Erro ao cadastrar projeto: artigo nao pode ser vazio ou nulo");
		if (ano < 1988) {
			throw new IllegalArgumentException("Erro ao cadastrar projeto: ano anterior a 1988");
		} else if (ano > 2019) {
			throw new IllegalArgumentException("Erro ao cadastrar projeto: ano posterior ao ano atual");
		}
		return this.controladorDePropostasLegislativas.cadastrarPEC(autor, ano, ementa, interesses, url, artigos);
	}

	/**
	 * Retorna uma representacao em string de uma proposta legislativa atraves de
	 * seu codigo.
	 * 
	 * @param codigo codigo da proposta
	 * 
	 * @return uma representacao em string de uma proposta legislativa atraves de
	 *         seu codigo
	 */
	public String exibirProjeto(String codigo) {
		return this.controladorDePropostasLegislativas.exibirProjeto(codigo);
	}

	/**
	 * Metodo que realiza uma votacao em comissao no sistema e retorna um boolean
	 * indicando a aprovacao ou rejeicao da proposta nessa comissao.
	 * 
	 * @param codigo           codigo da proposta que sera votada
	 * @param statusGovernista posicao politica da proposta
	 * @param proximoLocal     proximo local de votacao
	 * 
	 * @throws IllegalArgumentException caso algum parametro passado seja invalido
	 * 
	 * @return um boolean referente a aprovacao ou rejeicao da proposta nessa
	 *         comissao
	 */
	public boolean votarComissao(String codigo, String statusGovernista, String proximoLocal) {
		validador.validaNullOuVazio(codigo, "Erro ao votar proposta: codigo vazio");
		validador.validaNullOuVazio(statusGovernista, "Erro ao votar proposta: presentes vazio");
		validador.validaNullOuVazio(proximoLocal, "Erro ao votar proposta: proximo local vazio");
		if ((!statusGovernista.equals("GOVERNISTA")
				&& (!statusGovernista.equals("LIVRE") && (!statusGovernista.equals("OPOSICAO"))))) {
			throw new IllegalArgumentException("Erro ao votar proposta: status invalido");
		}
		if (!this.controladorDePropostasLegislativas.containsProposta(codigo)) {
			throw new IllegalArgumentException("Erro ao votar proposta: projeto inexistente");
		}
		if(this.controladorDePropostasLegislativas.getLocal(codigo).equalsIgnoreCase("plenario")) {
			throw new IllegalArgumentException("Erro ao votar proposta: proposta encaminhada ao plenario");
		}
		if (this.controladorDePropostasLegislativas.getLocal(codigo).equals("-")) {
			throw new IllegalArgumentException("Erro ao votar proposta: tramitacao encerrada");
		}
		if (!this.controladorDeComissoes.containsComissao(this.controladorDePropostasLegislativas.getLocal(codigo))) {
			throw new IllegalArgumentException("Erro ao votar proposta: "
					+ this.controladorDePropostasLegislativas.getLocal(codigo) + " nao cadastrada");
		};
		boolean resultado = this.votacao.votaComissao(this.controladorDePropostasLegislativas.getProposta(codigo), this.controladorDeComissoes.getComissao(this.controladorDePropostasLegislativas.getLocal(codigo)), statusGovernista, proximoLocal);
		if(this.controladorDePropostasLegislativas.propostaEmComissao(codigo, resultado, proximoLocal)) {
			this.controladorDePessoasEDeputados.getDeputado(this.controladorDePropostasLegislativas.getAutor(codigo)).setLeisAprovadas();
		}
		return resultado;

	}

	/**
	 * Metodo que realiza uma votacao em plenario no sistema e retorna um boolean
	 * indicando a aprovacao ou rejeicao da proposta no plenario.
	 * 
	 * @param codigo           codigo da proposta que sera votada
	 * @param statusGovernista posicao politica da proposta
	 * @param presentes        deputados presentes durante a votacao
	 * 
	 * @return um boolean referente a aprovacao ou rejeicao da proposta no plenario
	 */
	public boolean votarPlenario(String codigo, String statusGovernista, String presentes) {
		validador.validaNullOuVazio(codigo, "Erro ao votar proposta: codigo vazio");
		validador.validaNullOuVazio(statusGovernista, "Erro ao votar proposta: presentes vazio");
		List<String> deputados = Arrays.asList(presentes.split(","));
		deputados.stream().forEach(dni -> validador.validaDni(dni, "Erro ao votar proposta: dni invalido"));
		if ((!statusGovernista.equals("GOVERNISTA")
				&& (!statusGovernista.equals("LIVRE") && (!statusGovernista.equals("OPOSICAO"))))) {
			throw new IllegalArgumentException("Erro ao votar proposta: status invalido");
		}
		if (!this.controladorDePropostasLegislativas.containsProposta(codigo)) {
			throw new IllegalArgumentException("Erro ao votar proposta: projeto inexistente");
		}
		if (this.controladorDePropostasLegislativas.getLocal(codigo).equals("-")) {
			throw new IllegalArgumentException("Erro ao votar proposta: tramitacao encerrada");
		}
		if (!this.controladorDePropostasLegislativas.getProposta(codigo).getSituacao().contains("EM VOTACAO (Plenario")){
			throw new IllegalArgumentException("Erro ao votar proposta: tramitacao em comissao");
		}
		if (deputados.size() <= 1) {
			throw new IllegalArgumentException("Erro ao votar proposta: quorum invalido");
		}
		if ((codigo.contains("PLP")
				&& deputados.size() < ((this.controladorDePessoasEDeputados.totalDeDeputados() / 2) + 1))) {
			throw new IllegalArgumentException("Erro ao votar proposta: quorum invalido");
		}
		if (codigo.contains("PEC")
				&& deputados.size() < ((this.controladorDePessoasEDeputados.totalDeDeputados() * 3) / 5) + 1) {
			throw new IllegalArgumentException("Erro ao votar proposta: quorum invalido");
		}
		deputados.stream()
				.forEach(dni -> this.validaDniDeputado(dni, "Erro ao votar proposta: pessoa nao eh deputado"));

		int votacao = this.votacao.votaPlenario(this.controladorDePropostasLegislativas.getListaDeInteresses(codigo),
				this.controladorDePessoasEDeputados.getPresentes(deputados), statusGovernista);
		boolean aprovado = false;
		if(codigo.contains("PL ")) {
			if(votacao >= ((deputados.size() / 2) + 1)) {
				aprovado = true;
			}
			if(this.controladorDePropostasLegislativas.propostaEmPlenario(codigo, aprovado)) {
				this.controladorDePessoasEDeputados.getDeputado(this.controladorDePropostasLegislativas.getAutor(codigo)).setLeisAprovadas();
			}
		}else if(codigo.contains("PLP ")) {
			if(votacao >= ((deputados.size() / 2) + 1)) {
				aprovado = true;
			}
			if(this.controladorDePropostasLegislativas.propostaEmPlenario(codigo, aprovado)) {
				this.controladorDePessoasEDeputados.getDeputado(this.controladorDePropostasLegislativas.getAutor(codigo)).setLeisAprovadas();
			}
		}else {
			if(votacao >= (((deputados.size() * 3) / 5) + 1)) {
				aprovado = true;
			}
			if(this.controladorDePropostasLegislativas.propostaEmPlenario(codigo, aprovado)) {
				this.controladorDePessoasEDeputados.getDeputado(this.controladorDePropostasLegislativas.getAutor(codigo)).setLeisAprovadas();
			}
		}
		return aprovado;
	}

	/**
	 * Retorna toda a tramitacao de uma proposta no sistema atraves do seu codigo.
	 * 
	 * @param codigo codigo da proposta
	 * 
	 * @throws IllegalArgumentException caso o codigo passado seja invalido
	 * 
	 * @return toda a tramitacao de uma proposta
	 */
	public String exibirTramitacao(String codigo) {
		validador.validaNullOuVazio(codigo, "Erro ao exibir tramitacao: projeto nao pode ser vazio ou nulo");
		return this.controladorDePropostasLegislativas.exibeTramitacao(codigo);
	}

	/**
	 * Verifica se o dni passado e de uma pessoa no sistema.
	 * 
	 * @param dni      dni da pessoa
	 * 
	 * @param mensagem mensagem de erro que sera lancada caso a pessoa nao exista
	 * 
	 * @throws IllegalArgumentException caso a pessoa nao exista no sistema
	 */
	private void validaDniPessoa(String dni, String mensagem) {
		if (!controladorDePessoasEDeputados.containsPessoa(dni)) {
			throw new IllegalArgumentException(mensagem);
		}
	}

	/**
	 * Verifica se o dni passado e de um deputado no sistema.
	 * 
	 * @param dni      dni do deputado
	 * 
	 * @param mensagem mensagem de erro que sera lancada caso o deputado nao exista
	 * 
	 * @throws IllegalArgumentException caso o deputado nao exista no sistema
	 */
	private void validaDniDeputado(String dni, String mensagem) {
		if (!controladorDePessoasEDeputados.containsDeputado(dni)) {
			throw new IllegalArgumentException(mensagem);
		}
	}
	
	/**
	 * Metodo que altera o tipo de estrategia de desempate que uma pessoa possui.
	 * 
	 * @param dni dni da pessoa que tera sua estrategia modificada
	 * 
	 * @param estrategia novo tipo de estrategia de desempate de propostas relacionadas
	 * 
	 * @throws IllegalArgumentException caso algum parametro passado seja invalido
	 */
	public void configurarEstrategiaPropostaRelacionada(String dni, String estrategia) {
		validador.validaNullOuVazio(dni, "Erro ao configurar estrategia: pessoa nao pode ser vazia ou nula");
		validador.validaDni(dni, "Erro ao configurar estrategia: dni invalido");
		validador.validaNullOuVazio(estrategia, "Erro ao configurar estrategia: estrategia vazia");
		this.validaDniPessoa(dni, "Erro ao configurar estrategia: dni nao cadastrado");
		if(estrategia.equals("CONSTITUCIONAL") || (estrategia.equals("CONCLUSAO")) || (estrategia.equals("APROVACAO"))) {
			this.controladorDePessoasEDeputados.setEstrategia(dni, estrategia);
		}else {
			throw new IllegalArgumentException("Erro ao configurar estrategia: estrategia invalida");
		}	
		
	}

	
	/**
	 * Retorna a proposta que possui mais interesses em comum com a pessoa ou a que mais atendeu aos parametros desempate.
	 * 
	 * @param dni dni da pessoa
	 * 
	 * @throws IllegalArgumentException caso o dni passado seja invalido
	 * 
	 * @return a prposta mais relacionada a pessoa passada como parametro
	 * 
	 */
	public String pegarPropostaRelacionada(String dni) {
		validador.validaNullOuVazio(dni, "Erro ao pegar proposta relacionada: pessoa nao pode ser vazia ou nula");
		validador.validaDni(dni, "Erro ao pegar proposta relacionada: dni invalido");
		List<PropostaLegislativa> relacionados = this.controladorDePropostasLegislativas.getPropostasRelacionadas(this.controladorDePessoasEDeputados.getListaDeInteresses(dni));
		if(relacionados.size() == 0) {
			return "";
		}else if(relacionados.size() == 1) {
			return relacionados.get(0).getCodigo();
		}else {
			return this.controladorDePessoasEDeputados.desempate(dni, relacionados);
		}
		
	}

	

}
