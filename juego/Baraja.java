package juego;

import java.util.Random;

public class Baraja {
	
	private int numero;
	private String ultimoPalo = "";
	private String ultimoNumber = "";
	Random random = new Random();
	
	public String getPalo() {
		numero = random.nextInt(4) + 1;
		if (numero == 1) {
			return Palos.CORAZONES.getSimbolo();
		}
		else if (numero == 1) {
			return Palos.DIAMANTES.getSimbolo();
		}
		else if (numero == 1) {
			return Palos.PICAS.getSimbolo();
		}
		else {
			return Palos.TREBOLES.getSimbolo();
		}
	}
	
	public String getCifra() {
		numero = random.nextInt(13) + 1; //Genera un numero del 1 al 13.
		if (numero == 1) {
			return Valores.AS.getSimbolo();
		}
		else if (numero == 2) {
			return Valores.DOS.getSimbolo();
		}
		else if (numero == 3) {
			return Valores.TRES.getSimbolo();
		}
		else if (numero == 4) {
			return Valores.CUATRO.getSimbolo();
		}
		else if (numero == 5) {
			return Valores.CINCO.getSimbolo();
		}
		else if (numero == 6) {
			return Valores.SEIS.getSimbolo();
		}
		else if (numero == 7) {
			return Valores.SIETE.getSimbolo();
		}
		else if (numero == 8) {
			return Valores.OCHO.getSimbolo();
		}
		else if (numero == 9) {
			return Valores.NUEVE.getSimbolo();
		}
		else if (numero == 10) {
			return Valores.DIEZ.getSimbolo();
		}
		else if (numero == 11) {
			return Valores.J.getSimbolo();
		}
		else if (numero == 12) {
			return Valores.Q.getSimbolo();
		}
		else {
			return Valores.K.getSimbolo();
		}
	}
	
	public String crearCarta() {//Crea una carta.
		String palo;
		String number;
		do {
			palo = getPalo(); //Obtiene el palo.
			number = getCifra(); //Obtiene el numero.
		} while (ultimoPalo.equals(palo) && ultimoNumber.equals(number)); //Comprueba que no sean iguales que la carta anterior.
		
		ultimoPalo = palo; //Guarda el palo que haya salido para no repetirlo mas tarde.
	    ultimoNumber = number; //Guarda el numero que haya salido para no repetirlo mas tarde.
		
		Carta carta = new Carta(number, palo); //Crea la carta.
		return carta.toString();
	}

}
