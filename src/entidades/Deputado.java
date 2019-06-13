package entidades;

public class Deputado implements Exibir {

	private String dataDeInicio;
	private int leisAprovadas;

	public Deputado(String dataDeInicio) {
		this.dataDeInicio = dataDeInicio;
		this.leisAprovadas = 0;
	}

	public int getLeisAprovadas() {
		return leisAprovadas;
	}

	public void setLeisAprovadas(int leisAprovadas) {
		this.leisAprovadas = leisAprovadas;
	}

	public String getDataDeInicio() {
		String dia = dataDeInicio.substring(0, 2);
		String mes = dataDeInicio.substring(2, 4);
		String ano = dataDeInicio.substring(4, 8);

		return dia + "/" + mes + "/" + ano;
	}

	@Override
	public String exibir(String nome, String dni, String estado, String partido, String interesses) {
		return "POL: " + nome + " - " + dni + " (" + estado + ")" + partido + interesses + " - "
				+ this.getDataDeInicio() + " - " + this.getLeisAprovadas() + " Leis";
	}
}
