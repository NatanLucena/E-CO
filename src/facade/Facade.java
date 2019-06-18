package facade;

import controladores.ControladorGeral;
import easyaccept.EasyAccept;

public class Facade {
	ControladorGeral controlador;

	public static void main(String[] args) {
//		args = new String[] { "facade.Facade", "acceptance_tests/use_case_1.txt", "acceptance_tests/use_case_2.txt",
//				"acceptance_tests/use_case_3.txt", "acceptance_tests/use_case_4.txt", "acceptance_tests/use_case_5.txt",
//				"acceptance_tests/use_case_6.txt", "acceptance_tests/use_case_7.txt"};

		args = new String[] { "facade.Facade","acceptance_tests/use_case_7.txt"};
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
	
	public void cadastrarComissao(String tema, String politicos) {
		this.controlador.cadastraComissao(tema, politicos);
	}
	
	public String cadastrarPL (String autor, int ano, String ementa, String interesses, String url, boolean conclusivo) {
		return this.controlador.cadastrarPL(autor, ano, ementa, interesses, url, conclusivo);
	}
	
	public String cadastrarPLP (String autor, int ano, String ementa, String interesses, String url,  String artigos) {
		return this.controlador.cadastrarPLP(autor, ano, ementa, interesses, url, artigos);
	}
	
	public String cadastrarPEC (String autor, int ano, String ementa, String interesses, String url,  String artigos) {
		return this.controlador.cadastrarPEC(autor, ano, ementa, interesses, url, artigos);
	}
	
	public String exibirProjeto (String codigo) {
		return this.controlador.exibirProjeto(codigo);
	}
	
	public boolean votarComissao(String codigo, String statusGovernista, String proximoLocal) {
		return this.controlador.votarComissao(codigo, statusGovernista, proximoLocal);
	}
	
	public boolean votarPlenario(String codigo, String statusGovernista, String presentes) {
		return this.controlador.votarPlenario(codigo, statusGovernista, presentes);
	}

}
