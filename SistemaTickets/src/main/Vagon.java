package main;

import java.util.Arrays;
import java.util.Scanner;

import javax.sound.midi.Soundbank;

public class Vagon {

	// Elementos del vagon

	Scanner teclado = new Scanner(System.in);
	public int numeroDeAsientosPorFila;
	public int numeroDeAsientosPorColumna;
	public String vagonVacio[][];
	Main main = new Main();

	// Contructores

	public Vagon() {

	}

	public Vagon(int numAsientosFila, int numAsientosColumna) {
		numeroDeAsientosPorFila = numAsientosFila;
		numeroDeAsientosPorColumna = numAsientosColumna;
	}

	// Get y Set del vagon

	public void setNumeroAsientosPorFila(int nuevoNumAsientosFila) {
		numeroDeAsientosPorFila = nuevoNumAsientosFila;
	}

	public void setNumeroAsientosColumna(int nuevoNumAsientosColumna) {
		numeroDeAsientosPorColumna = nuevoNumAsientosColumna;
	}

	public int getNumeroAsientosFila() {
		return numeroDeAsientosPorFila;
	}

	public int getNumeroAsientosColumna() {
		return numeroDeAsientosPorColumna;
	}

	// Se crea un vagon y se llena de plazas Libres="L"
	public void crearVagon() {
		// public void crearVagon(String vagonVacio[][]) {
		System.out.println("El vagon esta sidento creado...");
		System.out.println("¿Cuantas filas tiene el vagon?");
		int filasPedidas = teclado.nextInt();
		setNumeroAsientosPorFila(filasPedidas);
		System.out.println("¿Cuantas columnas tiene el vagon?");
		int columnasPedidas = teclado.nextInt();
		setNumeroAsientosColumna(columnasPedidas);
		// String vagonInicial[][] = new String [filasPedidas][columnasPedidas];
		vagonVacio = new String[filasPedidas][columnasPedidas];
		for (int i = 0; i < filasPedidas; i++) {
			for (int j = 0; j < columnasPedidas; j++) {
				vagonVacio[i][j] = "|L|";
				System.out.print(vagonVacio[i][j]);
			}
			System.out.println();
		}
	}

	// Recorre el array y lo imprime
	public void mostrarVagon() {
		System.out.println("Estado actual del vagon");
		for (int i = 0; i < getNumeroAsientosFila(); i++) {
			for (int j = 0; j < getNumeroAsientosColumna(); j++) {
				System.out.print(vagonVacio[i][j]);
			}
			System.out.println();
		}
	}

	// Cuando un ticket es comprado, se pasa la posicion del asiento comprado
	// Y se escribe una X en la posicion
	// Una vez comprado se muestra el vagon llmanado a mostrarVagon()
	public void actualizarPlazas(int plazaFila, int plazaColumna) {
		System.out.println("Actualizando plazas del vagon");
		vagonVacio[plazaFila][plazaColumna] = "|X|";
		mostrarVagon();
	}

	// Comprobar si el ticket elegido esta disponible
	public boolean comprobarTicket(Vagon v, int plazaFila, int plazaColumna) {
		System.out.println("Comprobando ticket...");
		for (int i = 0; i < v.getNumeroAsientosFila(); i++) {
			for (int j = 0; j < v.getNumeroAsientosColumna(); j++) {
				if (vagonVacio[plazaFila][plazaColumna] == "|X|") {
					System.out.println("Ese ticket ya ha sido comprado");
					System.out.println("Intentelo otra vez");
					return false;
				}
			}
		}
		return true;
	}

	// Para los tickets automaticos
	// Buscar el primer ticket disponible
	// Devolver la posiciones libre
	public String primerTicketDisponible() {
		String ticketLibre = "|L|";
		String ticketLibrePosicion;
		for (int i = 0; i < getNumeroAsientosFila(); i++) {
			for (int j = 0; j < getNumeroAsientosColumna(); j++) {
				if (vagonVacio[i][j].equals(ticketLibre)) {
					ticketLibrePosicion = Integer.toString(i) +" "+ Integer.toString(j);
					return ticketLibrePosicion;
				}
			}
		}
		return null;
	}

	//Recibe la posicion libre
	//La leo la covierto a int
	//La envio a actualizarPLazas
	public void primerTicketDisponibleEncontrado() {
		primerTicketDisponible();
		int f; int c;
		String ticket = primerTicketDisponible();
		String[] dividir = ticket.split(" ");
		String fila = dividir[0];
		String columna = dividir[1];
		System.out.println(fila);
		System.out.println(columna);
		f = Integer.parseInt(fila);
		c = Integer.parseInt(columna);
		actualizarPlazas(f, c);
	}

}
