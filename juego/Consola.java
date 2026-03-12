package juego;

import java.util.Scanner;

public class Consola {
	
	Scanner keyboard = new Scanner(System.in);
	
	public void linea(String mensaje) { //Escribe una linea de texto.
		System.out.println(mensaje);
	}
	
	public String teclado() { //Recibe un mensaje del usuario por consola.
		String texto = keyboard.nextLine();
		return texto;
	}
	
	public void cerrar() {
		keyboard.close();
	}

}
