package facade;

import controladores.ControladorDePartidos;
import controladores.ControladorDePessoasEDeputados;
import easyaccept.EasyAccept;

public class Facade {
	ControladorDePartidos controladorDePartidos;
	ControladorDePessoasEDeputados controladorDePessoasEDeputados;

	public static void main(String[] args) {
		args = new String[] { "facade.Facade", "acceptance_tests/use_case_1.txt", "acceptance_tests/use_case_2.txt",
				"acceptance_tests/use_case_3.txt", "acceptance_tests/use_case_4.txt" };
		EasyAccept.main(args);
	}

	public Facade() {
		this.controladorDePartidos = new ControladorDePartidos();
		this.controladorDePessoasEDeputados = new ControladorDePessoasEDeputados();
	}
	
	public void cadastrarPessoa(String nome, String dni, String estado, String interesses) {
		this.controladorDePessoasEDeputados.cadastrarPessoa(nome, dni, estado, interesses);
	}

	public void cadastrarPessoa(String nome, String dni, String estado, String interesses, String partido) {
		this.controladorDePessoasEDeputados.cadastrarPessoaComPartido(nome, dni, estado, interesses, partido);
	}

	public void cadastrarPartido(String partido) {
		this.controladorDePartidos.cadastraPartido(partido);
	}

	public String exibirBase() {
		return this.controladorDePartidos.exibirBase();
	}

}
