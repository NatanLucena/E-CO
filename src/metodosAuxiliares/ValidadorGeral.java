package metodosAuxiliares;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

public class ValidadorGeral {

	public void validaNullOuVazio(String entrada, String mensagem) {
		if (entrada == null || entrada.trim().equals("")) {
			throw new IllegalArgumentException(mensagem);
		}
	}

	public void validaDni(String dni, String mensagem) {

		dni = dni.trim();
		if (dni.length() != 11) {
			throw new IllegalArgumentException(mensagem);
		}

		String[] dniFormatado = dni.split("-");

		if (dniFormatado.length != 2) {
			throw new IllegalArgumentException(mensagem);
		}
		if (dniFormatado[0].length() != 9 || dniFormatado[1].length() != 1) {
			throw new IllegalArgumentException(mensagem);
		}

		try {
			Integer.parseInt(dniFormatado[0]);
			Integer.parseInt(dniFormatado[1]);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(mensagem);
		}
	}

	public static void validaData(String data, String mensagem) {
		if (data.trim().length() != 8) {
			throw new IllegalArgumentException(mensagem);
		}

		String dateFormat = "dd/MM/uuuu";

		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(dateFormat)
				.withResolverStyle(ResolverStyle.STRICT);
		try {
			LocalDate date = LocalDate.parse(data, dateTimeFormatter);
		} catch (DateTimeParseException e) {
			throw new IllegalArgumentException(mensagem);
		}
	}
}