package juego;

public class Carta {
	
	private String numero;
	private String simbolo;
	
	public Carta(String numero, String simbolo) { //Constructor de carta.
		this.numero = numero;
		this.simbolo = simbolo;
	}

	@Override
	public String toString() {
		return numero + simbolo;
	}

}
