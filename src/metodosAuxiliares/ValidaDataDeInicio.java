package metodosAuxiliares;

public class ValidaDataDeInicio {
	
	public static boolean validaDataDeInicio(String dataDeInicio) {
		if(dataDeInicio.trim().length() != 8) {
			return false;
		}

		String dia = dataDeInicio.substring(0, 2);
		String mes = dataDeInicio.substring(2, 4);
		String ano = dataDeInicio.substring(4, 8);
		
		try {
			int inteiroDia = Integer.parseInt(dia);
			int inteiroMes = Integer.parseInt(mes);
			int inteiroAno = Integer.parseInt(ano);
			
			if (inteiroDia < 1 || inteiroDia > 31) {
				return false;
			}
			else if(inteiroMes < 1 || inteiroMes > 12) {
				return false;
			}
			
			else if (inteiroAno < 1 ||inteiroAno > 9999) {
				return false;
			}
			
		} catch(NumberFormatException e) {
			return false;
		}
		return true;
	}
}