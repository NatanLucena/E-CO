package metodosAuxiliares;

import java.time.LocalDate;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ValidaDataDeInicio {
	
	public void verificaExistenciaDeLetras (String dataDeInicio) {
		try {
			int valida = Integer.parseInt(dataDeInicio);
		}
		catch (Exception e){
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
		}
		catch(Exception e) {
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