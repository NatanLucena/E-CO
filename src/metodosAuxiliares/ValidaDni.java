package metodosAuxiliares;

public class ValidaDni {

	public static boolean validaDni(String dni) {
		if (dni.trim().length() != 11) {
			return false;
		}

		String[] dniFormatado = dni.split("-");

		if (dniFormatado.length != 2) {
			return false;
		} else if (dniFormatado[0].length() != 9 || dniFormatado[1].length() != 1) {
			return false;
		}

		try {
			Integer.parseInt(dniFormatado[0]);
			Integer.parseInt(dniFormatado[1]);
		} catch (NumberFormatException e) {
			return false;
		}

		return true;
	}
}
