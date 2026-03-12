package juego;

public class Partida {
	
	private int counter = 1;
	
	public void inicio() {
		System.out.println("----------BlackJack----------");
		System.out.println("Para comenzar pulse Y");
		System.out.println("Para finalizar el juego pulse N");
	}
	
	public void rondas() {
		System.out.println("----------Ronda " + counter + "----------");
		counter++;
		System.out.println("Empieza el Jugador 1");
	}
	
	public void decision() {
		System.out.println("¿Que vas a hacer?");
		System.out.println("Para pedir otra carta introduce C");
		System.out.println("Para plantarse introduce P");
	}
	
	public void siguienteJugador() {
		System.out.println("Fin del turno del jugador 1");
		System.out.println("Le toca ahora al jugador 2");
	}

}
