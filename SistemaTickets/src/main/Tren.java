package main;

import java.util.Scanner;

public class Tren {

	//Elementos del tren
	
	
	public int numeroDeVagones;
	Vagon vagonA = new Vagon();
	Scanner teclado = new Scanner(System.in);
	
	
	
	//Cosntructores
	public Tren() {
		
	}
	
	public Tren(int nDeVagones ) {
		numeroDeVagones = nDeVagones;
	}
	
	
	//Get y Set del tren
	public void setNumeroVagon(int nuevoNumeroDeVagones) {
		numeroDeVagones = nuevoNumeroDeVagones;
	}
	public int getNumeroVagon() {
		return numeroDeVagones;
	}
	
	public void crearVagonesVacio(int numVagones) {
		
	}
	
	
//	public void mensajeTren(String vagon[][]) {
//		System.out.println("El tren esta sidento creado...");
//		System.out.println("El tren tiene: "+getNumeroVagon()+" vagones.");
//		System.out.println("¿Cuantas filas tiene el vagon?");
//		int filasPedidas = teclado.nextInt();
//		System.out.println("¿Cuantas columnas tiene el vagon?");
//		int columnasPedidas = teclado.nextInt();
//		rellenarVagonVacio(vagonArrai[][], int numAsientosFila, int numAsientosColumna)
//
//	}
	
}
