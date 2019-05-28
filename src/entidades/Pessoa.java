package entidades;

public class Pessoa {

	private String nome;
	private String dni;
	private String estado;
	private String interesses;
	private String partido;

	public Pessoa(String nome, String dni, String estado, String interesses) {
		this.nome = nome;
		this.dni = dni;
		this.estado = estado;
		this.interesses = interesses;
		this.partido = "";
	}

	public Pessoa(String nome, String dni, String estado, String interesses, String partido) {
		this.nome = nome;
		this.dni = dni;
		this.estado = estado;
		this.interesses = interesses;
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

	@Override
	public String toString() {
		if (this.partido.equals("")) {
			return this.nome + " - " + this.dni + " (" + this.estado + ") - Interesses: " + this.interesses;
		} else {
			return this.nome + " - " + this.dni + " (" + this.estado + ") - " + this.partido + " - Interesses: "
					+ this.interesses;
		}
	}
}
