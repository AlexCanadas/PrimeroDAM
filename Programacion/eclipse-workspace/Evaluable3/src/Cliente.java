import java.util.ArrayList;
import java.util.Scanner;

public class Cliente extends Personas {
	private String nombre;

public Cliente(String alias, String contraseña, String email, String nombre) {
	super(alias, contraseña, email);
	this.nombre = nombre;
}

public Cliente() {
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public static void menuCliente(ArrayList <Personas> p, ArrayList <Habitaciones> h, ArrayList <Reservas> r, String alias) {
	
	int opcion; 
	Scanner sc = new Scanner (System.in);
	do {
		System.out.println("----- Menú Clientes-----");
		System.out.println("1. Reservar una habitación."); 
		System.out.println("2. Ver todas las habitaciones que están disponibles."); 
		System.out.println("3. Comprobar si tienes reservas actualmente.");
		System.out.println("4. Salir");
		opcion=sc.nextInt();
	
		switch(opcion) {
		case 1: 
			break;
		case 2:
			break;
		case 3: 
			break;
		case 4:
			System.out.println("Que tengas un buen día");
			break;
		default: 
			System.out.println("Opción no válida \n");
			break;
		}
		
	}while(opcion!=4);
}


}
