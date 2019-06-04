package metodosAuxiliares;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ValidaDataDeInicio {
	
	public static boolean validaDataDeInicio(String dataDeInicio) {
		if(dataDeInicio.trim().length() != 8) {
			return false;
		}

		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/mm/yyyy");
			LocalDate formatedData = LocalDate.parse(dataDeInicio, formatter);
			dataDeInicio = formatter.format(formatedData);
		}
		catch(Exception e) {
			return false;
		}

		return true;
	}
}