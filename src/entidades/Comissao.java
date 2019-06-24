package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Comissao implements Serializable {
	/**
	 * Armazena indentificador de versao de serializacao da classe Comissao.
	 */
	private static final long serialVersionUID = -1190752484642864132L;
	private String tema;
	private List<String> integrantes;
	
	public Comissao(String tema, List<String> integrantes) {
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
