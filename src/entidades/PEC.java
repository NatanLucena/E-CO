package entidades;

import metodosAuxiliares.ValidadorGeral;

/**
 * Representa um projeto de lei complementar no sistema
 * 
 * @author JacksonMateus
 *
 */
public class PEC extends PropostaLegislativa {
	/**
	 * Armazena indentificador de versao de serializacao da classe PEC.
	 */
	private static final long serialVersionUID = 5247444466850372223L;

	/**
	 * Armazena os artigos da constituicao sendo complementados ou emendados;
	 */
	private String artigosAlterados;
	
	/**
	 * Armazena um validador para verificacao de error comuns
	 */
	private ValidadorGeral validador;
	
	/**
	 * Inicia a PEC a partir do autor do projeto de lei, ano de inicio do projeto, codigo, ementa, interesses, URL e artigos desse 
	 * projeto de lei
	 * 
	 * @param autor da PEC
	 * @param ano de inicio da PEC
	 * @param codigo da PEC
	 * @param ementa da PEC
	 * @param interesses da PEC 
	 * @param URL da PEC
	 * @param artigos da PEC
	 */
	public PEC(String autor, int ano, String codigo, String ementa, String interesses, String URL, String artigos) {
		super(autor, ano, codigo, ementa, interesses, URL);
		
		this.validador = new ValidadorGeral();
		validador.validaNullOuVazio(artigos, "Erro ao cadastrar Projeto: artigos nao podem ser vazios ou nulos");
		
		this.artigosAlterados = artigos;
	}
	
	/**
	 * Retorna os artigos da PEC
	 * @return uma String que representa todos os artigos da PEC
	 */
	public String getArtigos() {
		String[] artigos = this.artigosAlterados.split(",");
		return String.join(", ", artigos);
	}
	
	/**
	 * Representacao textual da PEC
	 */
	public String toString() {
		return "Projeto de Emenda Constitucional - " + super.codigo + " - " + super.autor + " - " + super.ementa + " - " + this.getArtigos() + " - " + super.situacao;
	}
	
	@Override
	public boolean propostaEmPlenario(boolean aprovado) {
		boolean leiAprovada = false;
		if (aprovado) {
			if (this.getSituacao().equals("EM VOTACAO (Plenario - 1o turno)")) {
				this.setTramitacao("APROVADO (Plenario - 1o turno)");
				this.setLocal("Plenario - 2o turno");
				this.adicionaTramitacao("EM VOTACAO (Plenario - 2o turno)");
				this.setSituacao("EM VOTACAO (Plenario - 2o turno)");
			} else {
				leiAprovada = true;
				this.setTramitacao("APROVADO (Plenario - 2o turno)");
				this.setLocal("-");
				this.setSituacao("APROVADO");
			}
		} else {
			if(this.getSituacao().equals("EM VOTACAO (Plenario - 1o turno)")) {
				this.setTramitacao("REJEITADO (Plenario - 1o turno)");
			}else {
				this.setTramitacao("REJEITADO (Plenario - 2o turno)");
			}
			this.setLocal("-");
			this.setSituacao("ARQUIVADO");
		}
		return leiAprovada;
	}

}
