package entidades;

import java.util.ArrayList;
import java.util.List;

public class Comissao {
	private String tema;
	private List<String> integrantes;
	
	public Comissao(String tema, ArrayList<String> integrantes) {
		this.tema = tema;
		this.integrantes = new ArrayList<>();
		this.integrantes.addAll(integrantes);
	}

	public String getTema() {
		return tema;
	}

	public List<String> getIntegrantes() {
		return integrantes;
	}
	

}
