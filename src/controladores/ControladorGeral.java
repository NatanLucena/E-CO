package controladores;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

import metodosAuxiliares.ValidadorGeral;

public class ControladorGeral {
	ControladorDeComissoes controladorDeComissoes;
	ControladorDePessoasEDeputados controladorDePessoasEDeputados;
	ControladorDePropostasLegislativas controladorDePropostasLegislativas;
	List<String> baseGovernista;
	ValidadorGeral validador;
	
	public ControladorGeral() {
		this.controladorDeComissoes = new ControladorDeComissoes();
		this.controladorDePessoasEDeputados = new ControladorDePessoasEDeputados();
		this.controladorDePropostasLegislativas = new ControladorDePropostasLegislativas();
		this.baseGovernista = new ArrayList<>();
		this.validador = new ValidadorGeral();
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
	}
	
	public String exibirBase() {
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
		dnis.stream().forEach( dni-> this.validaDniPessoa(dni));
		dnis.stream().forEach( dni-> this.validaDniDeputado(dni));
		
		this.controladorDeComissoes.cadastraComissao(tema, dnis);	
	}
	
	public void cadastrarPL(String autor, int ano, String ementa, String interesses, String url, boolean conclusivo) {
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
		this.controladorDePropostasLegislativas.cadastrarPL(autor, ano, ementa, interesses, url, conclusivo);
	}
	
	public void cadastrarPLP(String autor, int ano, String ementa, String interesses, String url, String artigos) {
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
		this.controladorDePropostasLegislativas.cadastrarPLP(autor, ano, ementa, interesses, url, artigos);
	}
	
	public void cadastrarPEC(String autor, int ano, String ementa, String interesses, String url, String artigos) {
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
		this.controladorDePropostasLegislativas.cadastrarPEC(autor, ano, ementa, interesses, url, artigos);
	}
	
	public String exibirProjeto(String codigo) {
		return this.controladorDePropostasLegislativas.exibirProjeto(codigo);
	}
	
	
	
	private void validaDniPessoa(String dni) {
		if(!controladorDePessoasEDeputados.containsPessoa(dni)) {
			throw new IllegalArgumentException("Erro ao cadastrar comissao: pessoa inexistente");
		}
	}
	
	private void validaDniDeputado(String dni) {
		if(!controladorDePessoasEDeputados.containsDeputado(dni)) {
			throw new IllegalArgumentException("Erro ao cadastrar comissao: pessoa nao eh deputado");
		}
	}

}
