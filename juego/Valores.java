package juego;

public enum Valores {
	
	AS("A", 1),
	DOS("2", 2), 
	TRES("3", 3), 
	CUATRO("4", 4), 
	CINCO("5", 5), 
	SEIS("6", 6), 
	SIETE("7", 7), 
	OCHO("8", 8), 
	NUEVE("9", 9), 
	DIEZ("10", 10), 
	J("J", 10), 
	Q("Q", 10), 
	K("K", 10);
	
	private int numero;
	private String simbolo;
	
	Valores(String simbolo, int numero) {
		this.simbolo = simbolo;
		this.numero = numero;
	}

	public int getNumero() {
		return numero;
	}

	public String getSimbolo() {
		return simbolo;
	}

}
