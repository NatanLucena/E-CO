package controladores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import entidades.Votacao;
import metodosAuxiliares.ValidadorGeral;

public class ControladorGeral implements Serializable {
	/**
	 * Armazena indentificador de versao de serializacao da classe ControladorGeral.
	 */
	private static final long serialVersionUID = -3617749414434865217L;
	private ControladorDeComissoes controladorDeComissoes;
	private ControladorDePessoasEDeputados controladorDePessoasEDeputados;
	private ControladorDePropostasLegislativas controladorDePropostasLegislativas;
	private Votacao votacao;
	private List<String> baseGovernista;
	private ValidadorGeral validador;
	
	public ControladorGeral() {
		this.controladorDeComissoes = new ControladorDeComissoes();
		this.controladorDePessoasEDeputados = new ControladorDePessoasEDeputados();
		this.controladorDePropostasLegislativas = new ControladorDePropostasLegislativas();
		this.votacao = new Votacao();
		this.validador = new ValidadorGeral();
		this.baseGovernista = new ArrayList<>();
	}
	
	public void cadastrarPessoa(String nome, String dni, String estado, String interesses) {
		this.controladorDePessoasEDeputados.cadastrarPessoa(nome, dni, estado, interesses);
	}
	
	public void cadastrarPessoaComPartido(String nome, String dni, String estado, String interesses, String partido) {
		this.controladorDePessoasEDeputados.cadastrarPessoaComPartido(nome, dni, estado, interesses, partido);
	}
	
	public String exibirPessoa(String dni) {
		return this.controladorDePessoasEDeputados.exibirPessoa(dni);
	}
	
	public void cadastrarDeputado(String dni, String dataDeInicio) {
		this.controladorDePessoasEDeputados.cadastrarDeputado(dni, dataDeInicio);
	}
	
	public void cadastrarPartido(String partido) {
		validador.validaNullOuVazio(partido, "Erro ao cadastrar partido: partido nao pode ser vazio ou nulo");
		if(this.baseGovernista.contains(partido)) {
			throw new IllegalArgumentException("Erro ao cadastrar partido: partido ja cadastrado");
		}
		baseGovernista.add(partido);
		this.votacao.cadastraPartido(partido);
		
	}
	
	public String exibirBase() {
		Collections.sort(this.baseGovernista);
		return String.join(",", this.baseGovernista);
	}
	
	public void cadastraComissao(String tema, String politicos) {
		validador.validaNullOuVazio(tema, "Erro ao cadastrar comissao: tema nao pode ser vazio ou nulo");
		validador.validaNullOuVazio(politicos, "Erro ao cadastrar comissao: lista de politicos nao pode ser vazio ou nulo");
		if(controladorDeComissoes.containsComissao(tema)) {
			throw new IllegalArgumentException("Erro ao cadastrar comissao: tema existente");
		}
	
		List<String> dnis = Arrays.asList(politicos.split(","));
		dnis.stream().forEach( dni-> validador.validaDni(dni, "Erro ao cadastrar comissao: dni invalido"));
		dnis.stream().forEach( dni-> this.validaDniPessoa(dni, "Erro ao cadastrar comissao: pessoa inexistente"));
		dnis.stream().forEach( dni-> this.validaDniDeputado(dni, "Erro ao cadastrar comissao: pessoa nao eh deputado"));
		
		this.controladorDeComissoes.cadastraComissao(tema, dnis);	
		
		dnis.stream().forEach(p -> controladorDeComissoes.cadastraIntegrante(tema, controladorDePessoasEDeputados.getDeputado(p)));
	}
	
	public String cadastrarPL(String autor, int ano, String ementa, String interesses, String url, boolean conclusivo) {
		validador.validaNullOuVazio(autor, "Erro ao cadastrar projeto: autor nao pode ser vazio ou nulo");
		validador.validaDni(autor, "Erro ao cadastrar projeto: dni invalido");
		
		if(!controladorDePessoasEDeputados.containsPessoa(autor)) {
			throw new IllegalArgumentException("Erro ao cadastrar projeto: pessoa inexistente");
		}else if(!controladorDePessoasEDeputados.containsDeputado(autor)) {
			throw new IllegalArgumentException("Erro ao cadastrar projeto: pessoa nao eh deputado");
		}
		
		validador.validaNullOuVazio(ementa, "Erro ao cadastrar projeto: ementa nao pode ser vazia ou nula");
		validador.validaNullOuVazio(interesses, "Erro ao cadastrar projeto: interesse nao pode ser vazio ou nulo");
		validador.validaNullOuVazio(url, "Erro ao cadastrar projeto: url nao pode ser vazio ou nulo");
		
		if (ano < 1988) {
			throw new IllegalArgumentException("Erro ao cadastrar projeto: ano anterior a 1988");
		}else if (ano > 2019) {
			throw new IllegalArgumentException("Erro ao cadastrar projeto: ano posterior ao ano atual");
		}
		return this.controladorDePropostasLegislativas.cadastrarPL(autor, ano, ementa, interesses, url, conclusivo);
	}
	
	public String cadastrarPLP(String autor, int ano, String ementa, String interesses, String url, String artigos) {
		validador.validaNullOuVazio(autor, "Erro ao cadastrar projeto: autor nao pode ser vazio ou nulo");
		validador.validaDni(autor, "Erro ao cadastrar projeto: dni invalido");

		if(!controladorDePessoasEDeputados.containsPessoa(autor)) {
			throw new IllegalArgumentException("Erro ao cadastrar projeto: pessoa inexistente");
		}else if(!controladorDePessoasEDeputados.containsDeputado(autor)) {
			throw new IllegalArgumentException("Erro ao cadastrar projeto: pessoa nao eh deputado");
		}
		
		validador.validaNullOuVazio(ementa, "Erro ao cadastrar projeto: ementa nao pode ser vazia ou nula");
		validador.validaNullOuVazio(interesses, "Erro ao cadastrar projeto: interesse nao pode ser vazio ou nulo");
		validador.validaNullOuVazio(url, "Erro ao cadastrar projeto: url nao pode ser vazio ou nulo");
		validador.validaNullOuVazio(artigos, "Erro ao cadastrar projeto: artigo nao pode ser vazio ou nulo");
		
		if (ano < 1988) {
			throw new IllegalArgumentException("Erro ao cadastrar projeto: ano anterior a 1988");
		}else if (ano > 2019) {
			throw new IllegalArgumentException("Erro ao cadastrar projeto: ano posterior ao ano atual");
		}
		return this.controladorDePropostasLegislativas.cadastrarPLP(autor, ano, ementa, interesses, url, artigos);
	}
	
	public String cadastrarPEC(String autor, int ano, String ementa, String interesses, String url, String artigos) {
		validador.validaNullOuVazio(autor, "Erro ao cadastrar projeto: autor nao pode ser vazio ou nulo");
		validador.validaDni(autor, "Erro ao cadastrar projeto: dni invalido");
		
		if(!controladorDePessoasEDeputados.containsPessoa(autor)) {
			throw new IllegalArgumentException("Erro ao cadastrar projeto: pessoa inexistente");
		}else if(!controladorDePessoasEDeputados.containsDeputado(autor)) {
			throw new IllegalArgumentException("Erro ao cadastrar projeto: pessoa nao eh deputado");
		}
		
		validador.validaNullOuVazio(ementa, "Erro ao cadastrar projeto: ementa nao pode ser vazia ou nula");
		validador.validaNullOuVazio(interesses, "Erro ao cadastrar projeto: interesse nao pode ser vazio ou nulo");
		validador.validaNullOuVazio(url, "Erro ao cadastrar projeto: url nao pode ser vazio ou nulo");
		validador.validaNullOuVazio(artigos, "Erro ao cadastrar projeto: artigo nao pode ser vazio ou nulo");
		if (ano < 1988) {
			throw new IllegalArgumentException("Erro ao cadastrar projeto: ano anterior a 1988");
		}else if (ano > 2019) {
			throw new IllegalArgumentException("Erro ao cadastrar projeto: ano posterior ao ano atual");
		}
		return this.controladorDePropostasLegislativas.cadastrarPEC(autor, ano, ementa, interesses, url, artigos);
	}
	
	public String exibirProjeto(String codigo) {
		return this.controladorDePropostasLegislativas.exibirProjeto(codigo);
	}
	
	public boolean votarComissao(String codigo, String statusGovernista, String proximoLocal) {
		validador.validaNullOuVazio(codigo, "Erro ao votar proposta: codigo vazio");
		validador.validaNullOuVazio(statusGovernista, "Erro ao votar proposta: presentes vazio");
		validador.validaNullOuVazio(proximoLocal, "Erro ao votar proposta: proximo local vazio");
		if((!statusGovernista.equals("GOVERNISTA") && (!statusGovernista.equals("LIVRE") && (!statusGovernista.equals("OPOSICAO"))))) {
			throw new IllegalArgumentException("Erro ao votar proposta: status invalido");
		}
		if(!this.controladorDePropostasLegislativas.containsProposta(codigo)) {
			throw new IllegalArgumentException("Erro ao votar proposta: projeto inexistente");
		}
		if(this.controladorDePropostasLegislativas.getLocal(codigo).equals("-")) {
			throw new IllegalArgumentException("Erro ao votar proposta: tramitacao encerrada");
		}
		if(!this.controladorDeComissoes.containsComissao(this.controladorDePropostasLegislativas.getLocal(codigo))) {
			throw new IllegalArgumentException("Erro ao votar proposta: " + this.controladorDePropostasLegislativas.getLocal(codigo) + " nao cadastrada");
		}
		
		return this.votacao.votaComissao(this.controladorDePropostasLegislativas.getProposta(codigo), this.controladorDeComissoes.getComissao(this.controladorDePropostasLegislativas.getLocal(codigo)), statusGovernista, proximoLocal, this.controladorDePessoasEDeputados.getDeputado(this.controladorDePropostasLegislativas.getAutor(codigo)));
		
		
	}
	
	public boolean votarPlenario(String codigo, String statusGovernista, String presentes) {
		validador.validaNullOuVazio(codigo, "Erro ao votar proposta: codigo vazio");
		validador.validaNullOuVazio(statusGovernista, "Erro ao votar proposta: presentes vazio");
		List<String> deputados = Arrays.asList(presentes.split(","));
		deputados.stream().forEach( dni-> validador.validaDni(dni, "Erro ao votar proposta: dni invalido"));
		if((!statusGovernista.equals("GOVERNISTA") && (!statusGovernista.equals("LIVRE") && (!statusGovernista.equals("OPOSICAO"))))) {
			throw new IllegalArgumentException("Erro ao votar proposta: status invalido");
		}
		if(!this.controladorDePropostasLegislativas.containsProposta(codigo)) {
			throw new IllegalArgumentException("Erro ao votar proposta: projeto inexistente");
		}
		if(this.controladorDePropostasLegislativas.getLocal(codigo).equals("-")) {
			throw new IllegalArgumentException("Erro ao votar proposta: tramitacao encerrada");
		}
		if(!this.controladorDePropostasLegislativas.getLocal(codigo).contains("Plenario")) {
			throw new IllegalArgumentException("Erro ao votar proposta: tramitacao em comissao");
		}
		if(deputados.size() <= 1) {
			throw new IllegalArgumentException("Erro ao votar proposta: quorum invalido");
		}
		if((codigo.contains("PLP") && deputados.size() < ((this.controladorDePessoasEDeputados.totalDeDeputados()/2) + 1))) {
			throw new IllegalArgumentException("Erro ao votar proposta: quorum invalido");
		}
		if(codigo.contains("PEC") && deputados.size() < ((this.controladorDePessoasEDeputados.totalDeDeputados()*3)/5) + 1) {
			throw new IllegalArgumentException("Erro ao votar proposta: quorum invalido");
		}
		deputados.stream().forEach( dni-> this.validaDniDeputado(dni, "Erro ao votar proposta: pessoa nao eh deputado"));
		
		return this.votacao.votaPlenario(this.controladorDePropostasLegislativas.getProposta(codigo), this.controladorDePessoasEDeputados.getPresentes(deputados), this.controladorDePessoasEDeputados.totalDeDeputados(), statusGovernista, this.controladorDePessoasEDeputados.getDeputado(this.controladorDePropostasLegislativas.getAutor(codigo)));
	}
	
	public String exibirTramitacao(String codigo) {
		validador.validaNullOuVazio(codigo, "Erro ao exibir tramitacao: projeto nao pode ser vazio ou nulo");
		return this.controladorDePropostasLegislativas.exibeTramitacao(codigo);
	}
	
	private void validaDniPessoa(String dni, String mensagem) {
		if(!controladorDePessoasEDeputados.containsPessoa(dni)) {
			throw new IllegalArgumentException(mensagem);
		}
	}
	
	private void validaDniDeputado(String dni, String mensagem) {
		if(!controladorDePessoasEDeputados.containsDeputado(dni)) {
			throw new IllegalArgumentException(mensagem);
		}
	}

}
