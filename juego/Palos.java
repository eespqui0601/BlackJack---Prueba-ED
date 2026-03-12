package juego;

public enum Palos {
	
	CORAZONES("♥"),
	DIAMANTES("♦"),
	PICAS("♣"),
	TREBOLES("♠");

	private String simbolo;
	
	Palos(String simbolo) {
		this.simbolo = simbolo;
	}

	public String getSimbolo() {
		return simbolo;
	}

}
