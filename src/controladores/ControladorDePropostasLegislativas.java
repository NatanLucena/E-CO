package controladores;

import java.util.HashMap;
import java.util.List;
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
	
	public String cadastrarPL(String autor, int ano, String ementa, String interesses, String url, boolean conclusivo) {
		this.PLsCadastradas += 1;
		String codigo = "PL " + this.PLsCadastradas + "/" + ano;
		this.propostas.put(codigo, new PL(autor, ano, codigo, ementa, interesses, url, conclusivo));
		return codigo;
	}
	
	public String cadastrarPLP(String autor, int ano, String ementa, String interesses, String url, String artigos) {
		this.PLPsCadastradas += 1;
		String codigo = "PLP " + this.PLPsCadastradas + "/" + ano;
		this.propostas.put(codigo, new PLP(autor, ano, codigo, ementa, interesses, url, artigos));
		return codigo;
	}
	
	public String cadastrarPEC(String autor, int ano, String ementa, String interesses, String url, String artigos) {
		this.PECsCadastradas += 1;
		String codigo = "PEC " + this.PECsCadastradas + "/" + ano;
		this.propostas.put(codigo, new PEC(autor, ano, codigo, ementa, interesses, url, artigos));
		return codigo;
	}
	
	public String exibirProjeto(String codigo) {
		return propostas.get(codigo).toString();
	}
	
	public boolean containsProposta(String codigo) {
		return propostas.containsKey(codigo);
	}
	
	public String getLocal(String codigo) {
		return propostas.get(codigo).getLocal();
	}
	
	public void setLocal(String codigo, String local) {
		this.propostas.get(codigo).setLocal(local);
		this.propostas.get(codigo).setSituacao();
	}
	
	public List<String> getListaDeInteresses(String codigo) {
		return propostas.get(codigo).getListaDeInteresses();
	}
	
	public boolean isPL(String codigo) {
		return propostas.get(codigo).getClass().equals(PL.class);
	}
	
	public boolean isPLP(String codigo) {
		return propostas.get(codigo).getClass().equals(PLP.class);
	}
	
	public boolean isPEC(String codigo) {
		return propostas.get(codigo).getClass().equals(PEC.class);
	}
	
}
