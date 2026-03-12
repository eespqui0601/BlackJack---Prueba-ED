package juego;

import java.util.ArrayList;

public class Jugador {
	
	private EstadoJugador estado;
	private ArrayList<String> mano;
	
	public Jugador(EstadoJugador estado) {
		mano = new ArrayList<>();
		this.estado = estado;
	}

	public void setEstado(EstadoJugador estado) {
		this.estado = estado;
	}

	public EstadoJugador getEstado() {
		return estado;
	}

	public boolean recibirCarta(EstadoJugador estado) { //Indica si el jugador recibe una carta o no dependiendo de si se ha plantado o no.
		if (estado.equals(EstadoJugador.PLANTADO)) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public void guardarCarta(String carta) {
		mano.add(carta);
	}
	
	public void mostrarMano() {
	    for (String carta : mano) {
	        System.out.println(carta);
	    }
	}
	
	public ArrayList<String> getMano() {
		return mano;
	}

}
