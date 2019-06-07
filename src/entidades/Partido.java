package entidades;
/**
 * É responsavel por representar um partido
 * @author NatanLucena, CayoViegas, lucas-lucena, JacksonMateus
 *
 */
public class Partido {
	/**
	 * Armazena o nome do Partido 
	 */
	private String partido;
	
	/**
	 * Inicia um partido a partir do nome do partido.
	 * @param partido nome do partido a ser inicializado
	 */
	public Partido(String partido) {
		this.partido = partido;
	}
	
	/**
	 * Retorna o nome do partido
	 * @return Uma String que representa o nome do partido
	 */
	public String getPartido() {
		return this.partido;
	}
	
	/**
	 * Retorna a representacao textual do partido
	 */
	public String toString() {
		return "Partido: " + this.partido;
	}

}
