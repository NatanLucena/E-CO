package facade;

import controladores.ControladorDePartidos;
import controladores.ControladorDePessoasEDeputados;

public class Facade {
	ControladorDePartidos controladorDePartidos;
	ControladorDePessoasEDeputados controladorDePessoasEDeputados;
	
	public Facade() {
		this.controladorDePartidos = new ControladorDePartidos();
		this.controladorDePessoasEDeputados = new ControladorDePessoasEDeputados();
	}
	
	public void cadastrarPessoa(String nome, String dni, String estado, String interesses) {
		this.controladorDePessoasEDeputados.cadastrarPessoa(nome, dni, estado, interesses);
	}
	
	public void cadastrarPessoa(String nome, String dni, String estado, String interesses, String partido) {
		if(this.controladorDePartidos.verificaPartido(partido)) {
			this.controladorDePessoasEDeputados.cadastrarPessoaComPartido(nome, dni, estado, interesses, partido);
		}
	}
	
	public void cadastrarPartido(String partido) {
		this.controladorDePartidos.cadastraPartido(partido);
	}
	
	public String exibirBase() {
		return this.controladorDePartidos.exibirBase();
	}
}
