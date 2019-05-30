package controladores;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import entidades.Partido;

public class ControladorDePartidos {
	private Map<String, Partido> partidos;
	
	public ControladorDePartidos() {
		this.partidos = new HashMap<>();
	}
	
	public void cadastraPartido(String partido) {
		partidos.put(partido, new Partido(partido));
	}
	
	public String exibirBase() {
		return this.partidos.values().stream()
			.sorted((i,j)->i.getPartido().compareTo(j.getPartido()))
			.map(Partido::getPartido)
			.collect(Collectors.joining(","));
	}

}
