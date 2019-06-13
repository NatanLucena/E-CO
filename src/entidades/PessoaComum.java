package entidades;

public class PessoaComum implements Exibir {

	/**
	 * Este metodo retorna a representacao textual da pessoa
	 * 
	 * @return uma String contendo todas as informacoes disponiveis da pessoa
	 */
	@Override
	public String exibir(String nome, String dni, String estado, String partido, String interesses) {
		return nome + " - " + dni + " (" + estado + ")" + partido + interesses;
	}
}