package entidades;



public class Deputado extends Pessoa {

	private String dataDeInicio;
	private int leisAprovadas;

	public Deputado(String nome, String dni, String estado, String interesses, String partido, String data) {
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

	public String getDataDeInicio() {
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
