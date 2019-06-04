package metodosAuxiliares;

import java.time.LocalDate;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ValidaDataDeInicio {
	
	//Não ta funcionando.
	public void validaDataDeInicio(String dataDeInicio) {


		SimpleDateFormat k = new SimpleDateFormat("ddmmyyyy");
		Date d;
		
		try {
			d = k.parse(dataDeInicio);
		} catch (ParseException e) {
			
		}

	}
}