package controladores;

import java.util.HashMap;
import java.util.Map;

import entidades.PEC;
import entidades.PL;
import entidades.PLP;
import entidades.PropostaLegislativa;
import metodosAuxiliares.ValidadorGeral;

public class ControladorDePropostasLegislativas {
	private Map<String, PropostaLegislativa> propostas;
	private int PLsCadastradas;
	private int PLPsCadastradas;
	private int PECsCadastradas;
	private ValidadorGeral validador;
	
	public ControladorDePropostasLegislativas() {
		this.propostas = new HashMap<>();
		this.validador = new ValidadorGeral();
	}
	
	public void cadastrarPL(String autor, int ano, String ementa, String interesses, String url, boolean conclusivo) {
		this.PLsCadastradas += 1;
		String codigo = "PL " + this.PLsCadastradas + "/" + ano;
		this.propostas.put(codigo, new PL(autor, ano, codigo, ementa, interesses, url, conclusivo));
	}
	
	public void cadastrarPLP(String autor, int ano, String ementa, String interesses, String url, String artigos) {
		this.PLPsCadastradas += 1;
		String codigo = "PLP " + this.PLPsCadastradas + "/" + ano;
		this.propostas.put(codigo, new PLP(autor, ano, codigo, ementa, interesses, url, artigos));
	}
	
	public void cadastrarPEC(String autor, int ano, String ementa, String interesses, String url, String artigos) {
		this.PECsCadastradas += 1;
		String codigo = "PEC " + this.PECsCadastradas + "/" + ano;
		this.propostas.put(codigo, new PEC(autor, ano, codigo, ementa, interesses, url, artigos));
	}
	
	public String exibirProjeto(String codigo) {
		return propostas.get(codigo).toString();
	}
	
}
