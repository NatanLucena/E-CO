package controladores;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entidades.PEC;
import entidades.PL;
import entidades.PLP;
import entidades.PropostaLegislativa;

/**
 * Responsavel por todos os metodos envolvendo a proposta legislativa
 * @author jacksonmca
 *
 */
public class ControladorDePropostasLegislativas implements Serializable {
	/**
	 * Armazena indentificador de versao de serializacao da classe
	 * ControladorDePropostasLegislativas.
	 */
	private static final long serialVersionUID = -2942187304776944035L;
	/**
	 * Armazena um mapa de propostas legislativas com o seu codigo como
	 * identificador.
	 */
	private Map<String, PropostaLegislativa> propostas;

	/**
	 * Constroi um controlador de propostas legislativas.
	 */
	public ControladorDePropostasLegislativas() {
		this.propostas = new HashMap<>();

	}

	/**
	 * Cadastra uma proposta legislativa do tipo PL no sistema.
	 * 
	 * @param autor      autor da proposta
	 * @param ano        ano da proposta
	 * @param ementa     ementa da proposta
	 * @param interesses interesses da proposta
	 * @param url        link URL da proposta
	 * @param conclusivo um boolean que demonstra se a proposta e conclusiva ou nao
	 * 
	 * @return o codigo da proposta apos cadastrado
	 */
	public String cadastrarPL(String autor, int ano, String ementa, String interesses, String url, boolean conclusivo) {
		int posicaoPL = (int) propostas.values().stream().filter(p -> p.getCodigo().contains("PL "))
				.filter(p -> p.getAno() == ano).count() + 1;
		String codigo = "PL " + posicaoPL + "/" + ano;
		this.propostas.put(codigo, new PL(autor, ano, codigo, ementa, interesses, url, conclusivo));
		return codigo;
	}

	/**
	 * Cadastra uma proposta legislativa do tipo PLP no sistema.
	 * 
	 * @param autor      autor da proposta
	 * @param ano        ano da proposta
	 * @param ementa     ementa da proposta
	 * @param interesses interesses da proposta
	 * @param url        link URL da proposta
	 * @param artigos    artigos da constituicao que serao afetados
	 * 
	 * @return o codigo da proposta apos cadastrado
	 */
	public String cadastrarPLP(String autor, int ano, String ementa, String interesses, String url, String artigos) {
		int posicaoPLP = (int) propostas.values().stream().filter(p -> p.getCodigo().contains("PLP "))
				.filter(p -> p.getAno() == ano).count() + 1;
		String codigo = "PLP " + posicaoPLP + "/" + ano;
		this.propostas.put(codigo, new PLP(autor, ano, codigo, ementa, interesses, url, artigos));
		return codigo;
	}

	/**
	 * Cadastra uma proposta legislativa do tipo PEC no sistema.
	 * 
	 * @param autor      autor da proposta
	 * @param ano        ano da proposta
	 * @param ementa     ementa da proposta
	 * @param interesses interesses da proposta
	 * @param url        link URL da proposta
	 * @param artigos    artigos da constituicao que serao afetados
	 * 
	 * @return o codigo da proposta apos cadastrado
	 */
	public String cadastrarPEC(String autor, int ano, String ementa, String interesses, String url, String artigos) {
		int posicaoPEC = (int) propostas.values().stream().filter(p -> p.getCodigo().contains("PEC "))
				.filter(p -> p.getAno() == ano).count() + 1;
		String codigo = "PEC " + posicaoPEC + "/" + ano;
		this.propostas.put(codigo, new PEC(autor, ano, codigo, ementa, interesses, url, artigos));
		return codigo;
	}

	/**
	 * Retorna uma representacao em string de uma proposta legislativa atraves de
	 * seu codigo.
	 * 
	 * @param codigo codigo da proposta
	 * 
	 * @return uma representacao em string de uma proposta legislativa atraves de
	 *         seu codigo
	 */
	public String exibirProjeto(String codigo) {
		return propostas.get(codigo).toString();
	}

	/**
	 * Retorna um boolean referente a existencia de uma proposta no sistema.
	 * 
	 * @param codigo codigo que sera verificado
	 * 
	 * @return um boolean referente a existencia de uma proposta no sistema
	 */
	public boolean containsProposta(String codigo) {
		return propostas.containsKey(codigo);
	}

	/**
	 * Retorna uma proposta atraves de seu codigo.
	 * 
	 * @param codigo codigo da proposta
	 * 
	 * @return uma proposta legislativa
	 */
	public PropostaLegislativa getProposta(String codigo) {
		return this.propostas.get(codigo);
	}

	/**
	 * Retorna o local em que uma proposta esta tramitando.
	 * 
	 * @param codigo codigo da proposta
	 * 
	 * @return o local em que a proposta esta tramitando
	 */
	public String getLocal(String codigo) {
		return propostas.get(codigo).getLocal();
	}

	/**
	 * Retorna o dni do autor da proposta.
	 * 
	 * @param codigo codigo da proposta
	 * 
	 * @return o dni do autor da proposta
	 */
	public String getAutor(String codigo) {
		return this.propostas.get(codigo).getAutor();
	}

	/**
	 * Retorna a lista de interesses de uma proposta atraves de seu codigo.
	 * 
	 * @param codigo codigo da proposta
	 * 
	 * @return a lista de interesses de uma proposta atraves de seu codigo
	 */
	public List<String> getListaDeInteresses(String codigo) {
		return propostas.get(codigo).getListaDeInteresses();
	}

	/**
	 * Retorna uma string que exibe toda a tramitacao de uma proposta no sistema
	 * 
	 * @param codigo codigo da proposta
	 * 
	 * @throws IllegalArgumentException caso o codigo passado seja invalido
	 * 
	 * @return uma string que exibe toda a tramitacao da proposta no sistema
	 */
	public String exibeTramitacao(String codigo) {
		if (!this.propostas.containsKey(codigo)) {
			throw new IllegalArgumentException("Erro ao exibir tramitacao: projeto inexistente");
		}
		return this.propostas.get(codigo).getTramitacao();
	}

}
