package entidades;

import metodosAuxiliares.ValidaDni;

public class Pessoa {

	private String nome;
	private String dni;
	private String estado;
	private String interesses;
	private String partido;
	private Funcao funcao;

	public Pessoa(String nome, String dni, String estado, String interesses) {
		if (nome == null || nome.equals("")) {
			throw new IllegalArgumentException();
		}
		if (dni == null || !ValidaDni.validaDni(dni)) {
			throw new IllegalArgumentException();
		}
		if (estado == null || estado.equals("")) {
			throw new IllegalArgumentException();
		}
		if (interesses == null) {
			throw new IllegalArgumentException();
		}

		this.nome = nome;
		this.dni = dni;
		this.estado = estado;
		this.interesses = interesses;
		this.partido = "";
		this.funcao = null;
	}

	public Pessoa(String nome, String dni, String estado, String interesses, String partido) {
		this(nome, dni, estado, interesses);

		if (partido == null || partido.equals("")) {
			throw new IllegalArgumentException();
		}

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
		return interesses;
	}

	public String getPartido() {
		return partido;
	}

	public void setFuncao(String dataDeInicio) {
		this.funcao = new Deputado(dataDeInicio);
	}

	public boolean isDeputado() {
		return funcao != null;
	}

	@Override
	public String toString() {
		if (funcao == null) {
			return this.nome + " - " + this.dni + " (" + this.estado + ") - " + this.partido + " - Interesses: "
					+ this.interesses;
		} else {
			return "POL: " + this.nome + " - " + this.dni + " (" + this.estado + ") - " + this.partido
					+ " - Interesses: " + this.interesses + " - " + funcao.getDataDeInicio() + " - "
					+ funcao.getLeisAprovadas() + " leis";
		}
	}
}
