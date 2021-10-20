package main;

import java.util.Scanner;



public class Ticket {

	//Elementos de un ticket
	
	public String ticket = "X";
	public int filaTicket;
	public int columnaTicket;
	Scanner teclado = new Scanner(System.in);
	
	
	//Objeto vagon
	
	//Constructores
	
	public Ticket() {
		
	}
	
	public Ticket(String tickt) {
		tickt = ticket;
	}
	
	
	public void setFilaTicket(int nuevaFilaTicket) {
		filaTicket = nuevaFilaTicket;
	}
	
	public void setColumnaTicket(int nuevaColumnaTicket) {
		columnaTicket = nuevaColumnaTicket;
	}
	
	public int getFilaTicket() {
		return filaTicket;
	}
	
	public int getColumnaTicket() {
		return columnaTicket;
	}
	
	
	//Comprar un ticket
	//Se pide la posicion del asiento por teclado
	//se envia al metodo comprarTicket, para ver su disponibilidad, sino esta disponible vuelve al menu
	//Si esta disponible actualiza las plazas
	public void comprarTicket(Vagon v) {
		System.out.println("Comprar ticket");
		System.out.println("Introduce la fila");
		int plazaFila = teclado.nextInt();
		System.out.println("Introduce la columna");
		int plazaColumna = teclado.nextInt();
		//boolean comprobar = v.comprobarTicket(v, plazaFila, plazaColumna);
		//System.out.println(comprobar);
		if(v.comprobarTicket(v, plazaFila, plazaColumna) == false) {
			Main.menu();
		}else {
			System.out.println("Ticket comprado");
			v.actualizarPlazas(plazaFila, plazaColumna);
		}
		
	}
	
	//Metodo para comprar un ticket automatico
	//Llama al metodo primerTicketDisponible() de la clase Vagon
	public void comprarTicketAutomatico(Vagon v) {
		System.out.println("Comprando ticket automatico...");
		//v.primerTicketDisponible();
		v.primerTicketDisponibleEncontrado();
	}
	
	
}
