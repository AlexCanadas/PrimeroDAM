import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
		System.out.println("1. Reservar una habitación con fecha concreta"); 
		System.out.println("2. Ver todas las habitaciones que están disponibles"); 
		System.out.println("3. Comprobar si tienes reservas actualmente");
		System.out.println("4. Salir");
		opcion=sc.nextInt();
	
		switch(opcion) {
		case 1: 
			System.out.println("Introduce que habitación quieres reservar: ");
			int hab = sc.nextInt();
			for (Habitaciones habABuscar : h) {
				if (habABuscar.getNumHabitacion()==hab) {
					System.out.println("Introduce la fecha en la que quieres reservar (dd-MM-yyyy): ");
					String fechaIntroducida = sc.next();
					LocalDate fechaAReservar = LocalDate.parse(fechaIntroducida, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
					System.out.println("Introduce de cuantas noches será la reserva: ");
					int noches = sc.nextInt();
							for (Reservas nuevaReserva : r) {
								if(nuevaReserva.getNumHabitacion()==hab) {
									Reservas reserva = new Reservas(fechaAReservar, hab, alias, noches);
									r.add(nuevaReserva);
									reserva.setReservaActiva(true);
									habABuscar.setEstaDisponible(false);
									System.out.println("Habitación reservada correctamente \n" + nuevaReserva.toString());
								}
							}
				}
			}
			break;
		case 2:
			for (Habitaciones comprobarHabitaciones : h) {
				if (comprobarHabitaciones.estaDisponible) {
					comprobarHabitaciones.toString();
				}
			}
			break;
		case 3: 
			for (Reservas comprobarReservas : r) {
				if (comprobarReservas.getAliasCliente().equals(alias)) {
					if (comprobarReservas.reservaActiva) {
						comprobarReservas.toString();
					}
				}
			}
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
