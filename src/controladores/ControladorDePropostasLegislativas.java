package controladores;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entidades.PEC;
import entidades.PL;
import entidades.PLP;
import entidades.PropostaLegislativa;

public class ControladorDePropostasLegislativas {
	private Map<String, PropostaLegislativa> propostas;
	
	public ControladorDePropostasLegislativas() {
		this.propostas = new HashMap<>();
		
	}
	
	public String cadastrarPL(String autor, int ano, String ementa, String interesses, String url, boolean conclusivo) {
		int posicaoPL = (int)propostas.values().stream().
				filter(p -> p.getCodigo().contains("PL ")).
				filter(p -> p.getAno() == ano).
				count() + 1;
    	String codigo = "PL " + posicaoPL  + "/" + ano;
		this.propostas.put(codigo, new PL(autor, ano, codigo, ementa, interesses, url, conclusivo));
		return codigo;
	}
	
	public String cadastrarPLP(String autor, int ano, String ementa, String interesses, String url, String artigos) {
		int posicaoPLP = (int)propostas.values().stream().
				filter(p->p.getCodigo().contains("PLP ")).
				filter(p -> p.getAno() == ano).
				count() + 1;
		String codigo = "PLP " + posicaoPLP + "/" + ano;
		this.propostas.put(codigo, new PLP(autor, ano, codigo, ementa, interesses, url, artigos));
		return codigo;
	}
	
	public String cadastrarPEC(String autor, int ano, String ementa, String interesses, String url, String artigos) {
		int posicaoPEC = (int)propostas.values().stream().
				filter(p->p.getCodigo().contains("PEC ")).
				filter(p -> p.getAno() == ano).
				count() + 1;
		String codigo = "PEC " + posicaoPEC + "/" + ano;
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
	
	public void setLocal(String codigo, String local, String situacao) {
		if(local.equals("plenario")) {
			if(this.propostas.get(codigo).getCodigo().contains("PL ")) {
				this.propostas.get(codigo).setLocal(situacao + ": " + local);
			}else {
				this.propostas.get(codigo).setLocal(situacao + ": " + local + " - 2o turno");
			}
		}
		this.propostas.get(codigo).setLocal(situacao + ": " + local);
	}
	
	public String getAutor(String codigo) {
		return this.propostas.get(codigo).getAutor();
	}
	
	public List<String> getListaDeInteresses(String codigo) {
		return propostas.get(codigo).getListaDeInteresses();
	}
	
	public boolean isPL(String codigo) {
		return propostas.get(codigo).getCodigo().contains("PL ");
	}
	
	public boolean isPLP(String codigo) {
		return propostas.get(codigo).getCodigo().contains("PLP ");
	}
	
	public boolean isPEC(String codigo) {
		return propostas.get(codigo).getCodigo().contains("PEC ");
	}
	
	public void adicionaTramitacao(String codigo,String local, String situacao) {
		List<String> tramitacao = this.propostas.get(codigo).getListaTramitacao();
		if(!situacao.equals("EM VOTACAO")) {
			tramitacao.remove(-1);
			if(tramitacao.size() != 0) {
				tramitacao.add(", " + situacao + " " + local);
			}else {
				tramitacao.add(situacao + " " + local);
			}
			this.propostas.get(codigo).setTramitacao(tramitacao);
		}else {
			tramitacao.add(situacao + " " + local);
		}
	}
	
	public boolean isConclusivo(String codigo) {
		return ((PL)this.propostas.get(codigo)).isConclusivo();
	}
	
}
