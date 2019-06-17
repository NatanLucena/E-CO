package metodosAuxiliares;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ValidadorGeral {

	public void validaNullOuVazio(String entrada, String mensagem) {
		if (entrada == null || entrada.trim().equals("")) {
			throw new IllegalArgumentException(mensagem);
		}
	}

	public void validaDni(String dni, String mensagem) {
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

	public void verificaExistenciaDeLetras(String dataDeInicio) {
		try {
			int valida = Integer.parseInt(dataDeInicio);
		} catch (Exception e) {
			throw new IllegalArgumentException("Erro ao cadastrar deputado: data invalida");
		}

	}

	public void verificaDataFutura(String dataDeInicio) {
		try {
			SimpleDateFormat k = new SimpleDateFormat("ddMMyyyy");
			Date date = k.parse(dataDeInicio);
			Date nowDate = new Date();

			if (date.after(nowDate)) {
				throw new IllegalArgumentException("Erro ao cadastrar deputado: data futura");
			}
		} catch (Exception e) {
			throw new IllegalArgumentException("Erro ao cadastrar deputado: data futura");
		}
	}

	public void validaDataDeInicio(String dataDeInicio) {
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy");
		formatter.setLenient(false);
		Date formatedDate;

		try {
			formatedDate = formatter.parse(dataDeInicio);
		}

		catch (ParseException e) {
			throw new IllegalArgumentException("Erro ao cadastrar deputado: data invalida");
		}
	}
}