import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Cliente extends Personas {
	private String nombre;
	static String rutaArchivo = "Reservas.txt";

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
		System.out.println("\n----- Menú Clientes-----");
		System.out.println("1. Reservar una habitación con fecha concreta"); 
		System.out.println("2. Ver todas las habitaciones que están disponibles"); 
		System.out.println("3. Comprobar si tienes reservas actualmente");
		System.out.println("4. Salir");
		opcion=sc.nextInt();
	
		switch(opcion) {
		case 1: 
			System.out.println("Introduce que habitación quieres reservar: ");
			int hab = sc.nextInt();
			boolean habEncontrada = false;
			
			for (Habitaciones habABuscar : h) {
				if (habABuscar.getNumHabitacion()==hab) {
					habEncontrada = true;
					System.out.println("Introduce la fecha en la que quieres reservar (dd-MM-yyyy): ");
					String fechaIntroducida = sc.next();
					LocalDate fechaAReservar = LocalDate.parse(fechaIntroducida, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
					System.out.println("Introduce de cuantas noches será la reserva: ");
					int noches = sc.nextInt();
						if (habABuscar.isEstaDisponible()) {
							Reservas nuevaReserva = new Reservas(fechaAReservar, hab, alias, noches);
							r.add(nuevaReserva);
							nuevaReserva.setReservaActiva(true);
							habABuscar.setEstaDisponible(false);
							System.out.println("Habitación " + nuevaReserva.getNumHabitacion() + " reservada correctamente");
							System.out.println(nuevaReserva.toString());
							
							try {
								File archivo = new File(rutaArchivo); // Instanciamos la clase File
								if (!archivo.exists()) {
									archivo.createNewFile();
								}
									// Pasamos true para que solo añada la información en el fichero "archivo"
						            FileWriter fw = new FileWriter(archivo, true);

						            // Crear un BufferedWriter para escribir en el archivo
						            BufferedWriter bw = new BufferedWriter(fw);
						            
						            bw.write(nuevaReserva.toString());  // Escribir los datos de la reserva en el archivo
						            bw.newLine(); // Saltar a una nueva línea para la próxima reserva
						            
						            bw.close();
							
							}catch (IOException e) {
					            System.err.println("Error al guardar la reserva: " + e.getMessage());
							}
							
						}else {
							System.out.println("Lo sentimos, esta habitación no está disponible");
						}
						break;
				}
			}
			break;
		case 2:
			habEncontrada = false;
			for (Habitaciones comprobarHabitaciones : h) {
				if (comprobarHabitaciones.estaDisponible) {
					habEncontrada = true;
					System.out.println(comprobarHabitaciones);
				}
			}
			if (!habEncontrada) {
				System.out.println("No hay habitaciones disponibles en este momento \n");
			}
			break;
		case 3: 
			boolean reservaEncontrada = false;
			for (Reservas comprobarReservas : r) {
				if (comprobarReservas.getAliasCliente().equals(alias)) {
					if (comprobarReservas.reservaActiva) {
						reservaEncontrada = true;
						System.out.println(comprobarReservas);
					}
				}
			}
			if (!reservaEncontrada) {
				System.out.println("No tienes reservas hechas actualmente \n");
			}
			break;
		case 4:
			System.out.println("Volviendo al menú principal para introducir nuevas credenciales \n");
			return;
		default: 
			System.out.println("Opción no válida \n");
		}
		
	}while(opcion!=4);
}


}
