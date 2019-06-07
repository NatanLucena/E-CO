package entidades;

public class PessoaComum implements Exibir {

	@Override
	public String exibir(String nome, String dni, String estado, String partido, String interesses) {
		return nome + " - " + dni + " (" + estado + ")" + partido + interesses;
	}
}