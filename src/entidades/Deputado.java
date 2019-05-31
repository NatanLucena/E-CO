package entidades;

public class Deputado implements Funcao {

	private String dataDeInicio;
	private int leisAprovadas;

	public Deputado(String data) {
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
		return "POL: ";
	}
}
