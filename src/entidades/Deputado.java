package entidades;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Deputado implements Funcao {

	private LocalDate data;
	private String dataDeInicio;
	private int leisAprovadas;
	DateTimeFormatter formatter;

	public Deputado(String data) {
		System.out.println(data);
		try {
			this.formatter = DateTimeFormatter.ofPattern("DD/MM/YYYY");
			LocalDate formatedData = LocalDate.parse(data, formatter);
			this.data = formatedData;
			this.leisAprovadas = 0;
		}
		catch (Exception e) {
			throw new IllegalArgumentException("Erro ao cadastrar deputado: data invalida");
		}
	}

	public int getLeisAprovadas() {
		return leisAprovadas;
	}

	public void setLeisAprovadas(int leisAprovadas) {
		this.leisAprovadas = leisAprovadas;
	}

	public String getDataDeInicio() {
		return formatter.format(this.data);
	}

	@Override
	public String toString() {
		return "POL: ";
	}
}
