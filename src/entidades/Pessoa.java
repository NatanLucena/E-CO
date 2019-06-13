package entidades;

import metodosAuxiliares.ValidadorGeral;

public class Pessoa {

	private String nome;
	private String dni;
	private String estado;
	private String interesses;
	private String partido;
	private Exibir exibir;
	private ValidadorGeral validadorGeral;

	public Pessoa(String nome, String dni, String estado, String interesses) {
		this.validadorGeral = new ValidadorGeral();
		
		validadorGeral.validaNullOuVazio(nome, "Erro ao cadastrar pessoa: nome nao pode ser vazio ou nulo");
		validadorGeral.validaNullOuVazio(estado, "Erro ao cadastrar pessoa: estado nao pode ser vazio ou nulo");
		validadorGeral.validaDni(dni, "Erro ao cadastrar pessoa: dni nao pode ser vazio ou nulo");

		this.nome = nome;
		this.dni = dni;
		this.estado = estado;
		this.interesses = interesses;
		this.partido = "";
		this.exibir = new PessoaComum();
	}

	public Pessoa(String nome, String dni, String estado, String interesses, String partido) {
		this(nome, dni, estado, interesses);

		this.partido = partido;
	}

	public String getNome() {
		return nome;
	}

	public String getDni() {
		return dni;
	}

	public String getEstado() {
		return estado;
	}

	public String getInteresses() {
		if (this.interesses == null || this.interesses.equals("")) {
			return "";
		} else {
			return " - Interesses: " + this.interesses;
		}
	}

	public String getPartido() {
		if (partido == null || partido.equals("")) {
			return "";
		} else {
			return " - " + this.partido;
		}
	}

	public void assumeFuncao(String dataDeInicio) {
		this.exibir = new Deputado(dataDeInicio);
	}

	public boolean isDeputado() {
		return exibir.getClass().equals(Deputado.class);
	}

	public String exibir() {
		return exibir.exibir(nome, dni, estado, this.getPartido(), this.getInteresses());
	}
}
