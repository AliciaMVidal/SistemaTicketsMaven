package main;

import java.net.URL;
import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class Main {
	private static Logger logger = LogManager.getLogger(Main.class);


	//Crear las instancias de vagon y ticket
	static Vagon vagonObj = new Vagon();
	static Ticket ticketObj = new Ticket();

	public static void main(String[] args) {

		//Crear el vagon
		vagonObj.crearVagon();
		//Ir al menu,
		menu();

	}

	//Crear un menu 
	
	public static void menu() {
		
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		URL url = loader.getResource("log4j.properties");
		PropertyConfigurator.configure(url);
		logger.info("Este es el fichero de configuración: " + url);
		logger.warn("Esto es un aviso");
		
		System.out.println("Introduza el numero de la opcion que quieres realizar");
		System.out.println("1 - Ver el estado del tren");
		System.out.println("2 - Comprar un ticket automatico");
		System.out.println("3 - Comprar un ticket introduciendo posicion");
		System.out.println("4 - Cerrar la compra de tickets");
		Scanner teclado = new Scanner(System.in);
		int opcion = teclado.nextInt();
		
		//Crear un switch para hacer el menu 
		//Cuando se realice la opcion elegida se vuelve al menu
		switch (opcion) {
		case 1:
			logger.info("El usuario ha usando la opcion de menu: " + opcion);
			System.out.println("Ver estado del tren");
			vagonObj.mostrarVagon();
			menu();
			break;
		case 2:	
			logger.info("El usuario ha usando la opcion de menu: " + opcion);
			System.out.println("Comprando primer ticket disponible...");
			ticketObj.comprarTicketAutomatico(vagonObj);
			menu();
			break;
		case 3:
			logger.info("El usuario ha usando la opcion de menu: " + opcion);
			System.out.println("Comprar un ticket introduciendo posicion");
			ticketObj.comprarTicket(vagonObj);
			menu();
			break;
		case 4:
			logger.info("El usuario ha usando la opcion de menu: " + opcion);
			System.out.println("Cerrando compra de tickets...");
			System.exit(0);
			break;
		default:
			logger.info("El usuario ha usando la opcion de menu: " + opcion);
			System.out.println("Opcion erronea");
			menu();
		}

	}
}
