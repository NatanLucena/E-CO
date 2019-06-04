package entidades;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Deputado implements Funcao {


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
	public String toString() {
		return "POL: ";
	}
}
