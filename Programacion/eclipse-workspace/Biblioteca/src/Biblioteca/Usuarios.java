package Biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Usuarios extends Personas {

	public Usuarios(String dni, String nombre, int edad) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.edad = edad;
	}
	
	public Usuarios() {
		super();
	}
	
	protected Personas altaUsuario(Scanner sc, String dniIntroducido) {
		System.out.println("Introduce nombre:");
		String nombre = sc.next();
		System.out.println("Introduce la edad:");
		int edad = sc.nextInt();
		Usuarios nuevoUsuario = new Usuarios (dniIntroducido, nombre, edad);
		
		return nuevoUsuario;
	}
	
	public static void menuUsuario(Scanner sc, ArrayList <Personas> biblioteca, ArrayList <Prestamos> prestamos, 
			ArrayList <Articulos> catalogo) {
		int opcionUsuario;
		System.out.println("Por favor, introduce tu DNI: ");
		String dniIntroducido = sc.next();
		
		for (Personas usuario : biblioteca) {
			if (usuario instanceof Usuarios && usuario.dni.equals(dniIntroducido)) {
				 
			do {
			System.out.println("----- Menú Usuarios-----");
			System.out.println("1. Hacer un préstamo o varios a la vez."); // OK, no varios a la vez
			System.out.println("2. Hacer una devolución o varias a la vez."); // OK, no varios a la vez
			System.out.println("3. Ver sus préstamos en activo para ver los días que le quedan para la devolución.");
			System.out.println("4. Salir");
			opcionUsuario=sc.nextInt();
			
				switch(opcionUsuario) {
				case 1: 
					Prestamos nuevoPrestamo_ = new Prestamos(); // Crear instancia de prestamos
					nuevoPrestamo_ = nuevoPrestamo_.hacerPrestamo(sc, dniIntroducido);
					prestamos.add(nuevoPrestamo_);
					System.out.println("El DNI del usuario adquiriendo el préstamo ID " + nuevoPrestamo_.getIdPrestamo() +
							" es " + nuevoPrestamo_.getDniUsuario());
					break;
					
				case 2:
					Prestamos prestamoBaja = new Prestamos();
					prestamoBaja.hacerDevolucion(sc, prestamos);
					break;
					
				case 3:
					boolean prestamoEncontrado = false;
				    for (Prestamos verPrestamos : prestamos) {
				        // Mostrar préstamos en activo y días para la devolucion
				        if (verPrestamos.getDniUsuario().equals(dniIntroducido)) {
				            System.out.println(verPrestamos.toString());
				            prestamoEncontrado = true;
				        }
				    }
				    
				    if (!prestamoEncontrado) {
				        System.out.println("No hay préstamos asociados actualmente al DNI proporcionado \n");
				    }
				    break;
					
				case 4:
					System.out.println("Que tengas un buen día");
					break;
				default: System.out.println("Opción no válida \n");
		        	break;
				}
			
			}while (opcionUsuario!=4);
			}	
		}
		// Falta sc.close();
		System.out.println("No se encuentra este usuario en la base de datos");
	}
	
}
