package juego;

import java.util.ArrayList;

public class GestorPartida {
	
	Partida partida = new Partida();
	Baraja baraja = new Baraja();
	
	public boolean iniciarPartida(String texto) {
		if(texto.equalsIgnoreCase("Y")) {
			System.out.println("¡¡Que empieze el juego!!");
			return true;
		}
		else if(texto.equalsIgnoreCase("N")) {
			System.out.println("Hasta la proxima partida.");
			return false;
		}
		else {
			System.out.println("Ha ocurrido un error inesperado.");
			return false;
		}
	}
	
	public Jugador crearJugador() {
		Jugador player = new Jugador(EstadoJugador.PEDIR);
		return player;
	}
	
	public EstadoJugador eleccion(String texto) {
		if (texto.equalsIgnoreCase("C")) {
			System.out.println("Decides pedir otra carta");
			return EstadoJugador.PEDIR;
		}
		else if (texto.equalsIgnoreCase("P")) {
			System.out.println("Te has plantado ¬_¬.");
			return EstadoJugador.PLANTADO;
		}
		else {
			System.out.println("Ha ocurrido un error.");
			return EstadoJugador.PLANTADO;
		}
	}
	
	public String checkPedir(EstadoJugador estado) {
		if (estado.equals(EstadoJugador.PEDIR)) {
			return baraja.crearCarta();
		}
		else {
			return null;
		}
	}
	
	public boolean checkEstado(EstadoJugador estadoj1, EstadoJugador estadoj2) {
		if (estadoj1.equals(EstadoJugador.PLANTADO) || estadoj2.equals(EstadoJugador.PLANTADO)) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public void repartirInicial(Jugador jugador) {
	    jugador.guardarCarta(baraja.crearCarta());
	    jugador.guardarCarta(baraja.crearCarta());
	}
	
	public int obtenerPuntos(String cartaCompleta) {
		String simbolo;
		if (cartaCompleta.charAt(0) == 1 && cartaCompleta.charAt(1) == 0) {
			simbolo = "10";
		}
		else {
			simbolo = "" + cartaCompleta.charAt(0);
		}
	    for (Valores valores : Valores.values()) { //Recorre todos los simbolos de el enum valores
	        if (valores.getSimbolo().equals(simbolo)) { //Si algun simbolo coincide con el simbolo de la carta
	            return valores.getNumero(); //Devuelve el valor de la carta en puntos
	        }
	    }
	    return 0;
	}
	
	public int conteoPuntos(ArrayList<String> mano) {
		int total = 0;
		int puntos = 0;
		int A = 0;
		
		for(String simbolo : mano) {
			puntos = obtenerPuntos(simbolo);
			total += puntos;
			
			if (simbolo.equals("A")) {
				A++;
			}
		}
		
		while (A > 0 && total + 10 <= 21) {
	        total += 10; // Sumamos 10 al total por cada carta de As si no superamos 21 .
	        A--; 
	    }
		
		return total;
	}

}
