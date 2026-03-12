package juego;

import java.util.ArrayList;

public class Main {
	public void main() {
		
		boolean continuar = true;
		String carta;
		String textoUsuario;
		int puntosJugador1;
		int puntosJugador2;
		ArrayList<String> manoJugador1;
		ArrayList<String> manoJugador2;
		
		Baraja baraja = new Baraja();
		Partida partida = new Partida();
		Consola consola = new Consola();
		GestorPartida gestor = new GestorPartida(); 
		
		//Empieza la partida
		partida.inicio();
		textoUsuario = consola.teclado();
		gestor.iniciarPartida(textoUsuario);
		
		//Crea los jugadores
		Jugador player1 = gestor.crearJugador(); 
		Jugador player2 = gestor.crearJugador();
		
		//Reparte las dos primeras cartas
		gestor.repartirInicial(player1);
		gestor.repartirInicial(player2);
		
		//Bucle principal
		while(continuar == true) {
			
			partida.rondas();
			
			//Turno del jugador 1
			player1.mostrarMano();
			partida.decision();
			textoUsuario = consola.teclado();
			player1.setEstado(gestor.eleccion(textoUsuario)); //Te permite decidir si quieres pedir otra carta o plantarte.
			carta = gestor.checkPedir(player1.getEstado()); //Comprueba lo que has elegido.
			if (player1.getEstado().equals(EstadoJugador.PEDIR)) {
				player1.guardarCarta(carta); //Guarda la carta que te haya salido en la lista
				player1.mostrarMano();
			}
			continuar = gestor.checkEstado(player1.getEstado(), player2.getEstado()); //Comprobar si ambos jugadores se han plantado
			manoJugador1 = player1.getMano(); //Esto calcula si te pasas de 21.
			puntosJugador1 = gestor.conteoPuntos(manoJugador1);
			if (puntosJugador1 > 21) {
				player1.setEstado(EstadoJugador.PLANTADO);
			}
			continuar = gestor.checkEstado(player1.getEstado(), player2.getEstado());
			partida.siguienteJugador();
			
			//Turno del jugador 2
			player2.mostrarMano();
			partida.decision();
			textoUsuario = consola.teclado();
			player2.setEstado(gestor.eleccion(textoUsuario)); //Te permite decidir si quieres pedir otra carta o plantarte.
			carta = gestor.checkPedir(player2.getEstado()); //Comprueba lo que has elegido. 
			if (player2.getEstado().equals(EstadoJugador.PEDIR)) {
				player2.guardarCarta(carta); //Guarda la carta que te haya salido en la lista
				player2.mostrarMano();
			}
			continuar = gestor.checkEstado(player1.getEstado(), player2.getEstado()); //Comprobar si ambos jugadores se han plantado
			manoJugador2 = player2.getMano(); //Esto calcula si te pasas de 21.
			puntosJugador2 = gestor.conteoPuntos(manoJugador2);
			if (puntosJugador2 > 21) {
				player2.setEstado(EstadoJugador.PLANTADO);
			}
			continuar = gestor.checkEstado(player1.getEstado(), player2.getEstado());
			if (continuar == true) {
				partida.siguienteJugador();
			}
			
		}
		
		manoJugador1 = player1.getMano(); 
		puntosJugador1 = gestor.conteoPuntos(manoJugador1);
		System.out.println("El Jugador 1 ha acabado la partida con " + puntosJugador1 + " puntos");
		
		manoJugador2 = player2.getMano(); 
		puntosJugador2 = gestor.conteoPuntos(manoJugador2);
		System.out.println("El Jugador 2 ha acabado la partida con " + puntosJugador2 + " puntos");
		
		if(puntosJugador1 > 21 && puntosJugador2 > 21) {
			System.out.println("Ambos jugadores han perdido :-(");
		}
		else if (puntosJugador1 > 21 || puntosJugador2 > puntosJugador1) {
			System.out.println("El jugador 1 ha perdido. \n¡¡Gana el Jugador 2!!");
		}
		else if (puntosJugador2 > 21 || puntosJugador1 > puntosJugador2) {
			System.out.println("El jugador 2 ha perdido. \n¡¡Gana el Jugador 1!!");
		}
		else {
			System.out.println("Hay un empate!!");
		}
		
		consola.cerrar();
		
	}
	public static void main(String[] args) {
		new Main().main();
	}
}
