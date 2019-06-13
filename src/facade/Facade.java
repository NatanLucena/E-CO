package facade;

import controladores.ControladorDePartidos;
import controladores.ControladorDePessoasEDeputados;
import controladores.ControladorGeral;
import easyaccept.EasyAccept;

public class Facade {
	ControladorGeral controlador;

	public static void main(String[] args) {
		args = new String[] { "facade.Facade", "acceptance_tests/use_case_1.txt", "acceptance_tests/use_case_2.txt",
				"acceptance_tests/use_case_3.txt", "acceptance_tests/use_case_4.txt" };
		EasyAccept.main(args);
	}

	public Facade() {
		this.controlador = new ControladorGeral();
	}

	public void cadastrarPessoa(String nome, String dni, String estado, String interesses) {
		this.controlador.cadastrarPessoa(nome, dni, estado, interesses);
	}

	public void cadastrarPessoa(String nome, String dni, String estado, String interesses, String partido) {
		this.controlador.cadastrarPessoaComPartido(nome, dni, estado, interesses, partido);
	}

	public void cadastrarDeputado(String DNI, String dataDeInicio) {
		this.controlador.cadastrarDeputado(DNI, dataDeInicio);
	}

	public void cadastrarPartido(String partido) {
		this.controlador.cadastrarPartido(partido);
	}

	public String exibirBase() {
		return this.controlador.exibirBase();
	}

	public void limparSistema() {

	}

	public String exibirPessoa(String dni) {
		return this.controlador.exibirPessoa(dni);
	}

	public void carregarSistema() {

	}

	public void salvarSistema() {

	}

}
