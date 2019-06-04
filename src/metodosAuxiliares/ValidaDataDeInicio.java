package metodosAuxiliares;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ValidaDataDeInicio {
	
	//Não ta funcionando.
	public boolean validaDataDeInicio(String dataDeInicio) {
		if(dataDeInicio.trim().length() != 8) {
			return false;
		}
		
		String dia = dataDeInicio.substring(0, 2);
		String mes = dataDeInicio.substring(2, 4);
		String ano = dataDeInicio.substring(4, 8);
		
		String data = dia + "/" + mes + "/" + ano;
		System.out.println("flag " +data);
		try {
			
			LocalDate localDate = LocalDate.now();
			
			int resultDia = Integer.parseInt(dia);
			System.out.println("flag 1");
			int resultMes = Integer.parseInt(mes);
			System.out.println("flag 2");
			int resultAno = Integer.parseInt(ano);
			System.out.println("flag 3");
			String resultData = resultDia + "/" + resultMes + "/" + resultAno;
			
			
			
			return true;
		}
		catch(Exception e) {
			return false;
		}

	}
}