package entidades;

public class Partido {
	private String partido;
	
	public Partido(String partido) {
		this.partido = partido;
	}
	
	public String getPartido() {
		return this.partido;
	}
	
	public String toString() {
		return "Partido: " + this.partido;
	}

}
