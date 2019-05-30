package entidades;

import java.time.LocalDate;

public class Deputado extends Pessoa {

	private LocalDate dataDeInicio;
	private int leisAprovadas;

	public Deputado(String nome, String dni, String estado, String interesses, String partido, LocalDate data) {
		super(nome, dni, estado, interesses, partido);
		this.dataDeInicio = data;
		this.leisAprovadas = 0;
	}

	public int getLeisAprovadas() {
		return leisAprovadas;
	}

	public void setLeisAprovadas(int leisAprovadas) {
		this.leisAprovadas = leisAprovadas;
	}

	public LocalDate getDataDeInicio() {
		return dataDeInicio;
	}

	@Override
	public String toString() {
		if (super.getInteresses().equals("")) {
			return "POL: " + super.getNome() + " - " + super.getDni() + " (" + super.getEstado() + ")" + " - "
					+ this.dataDeInicio + " - " + this.leisAprovadas + " Leis";
		} else
			return "POL: " + super.getNome() + " - " + super.getDni() + " (" + super.getEstado() + ") - Interesses: "
					+ super.getInteresses() + " - " + this.dataDeInicio + " - " + this.leisAprovadas + " Leis";
	}
}
