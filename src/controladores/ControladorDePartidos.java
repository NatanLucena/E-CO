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
		if (partido == null) {
			throw new NullPointerException("Erro ao cadastrar partido: partido nao pode ser vazio ou nulo");
		} else if (partido.equals("")) {
			throw new IllegalArgumentException("Erro ao cadastrar partido: partido nao pode ser vazio ou nulo");
		} else if (partidos.containsKey(partido)) {
			throw new IllegalArgumentException("Erro ao cadastrar partido: partido ja cadastrado");
		} else {
			partidos.put(partido, new Partido(partido));
		}
	}

	public String exibirBase() {
		return this.partidos.values().stream().sorted((i, j) -> i.getPartido().compareTo(j.getPartido()))
				.map(Partido::getPartido).collect(Collectors.joining(","));
	}

	public boolean verificaPartido(String partido) {
		return partidos.containsKey(partido);
	}

}
