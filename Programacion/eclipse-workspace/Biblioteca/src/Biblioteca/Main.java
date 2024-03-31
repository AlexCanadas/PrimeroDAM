package Biblioteca;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;


public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ArrayList <Personas> biblioteca = new ArrayList();
		//Usuarios user = new Usuarios();
		Administradores admin = new Administradores("Alex", "47411159Y", 33);
		biblioteca.add(admin);
		
		System.out.println("Introduce tu DNI:");	
		String dniIntroducido = sc.next();
		
		boolean encontrado = false;
		for (Personas i : biblioteca) {
			if (i instanceof Administradores) {
				Administradores administrador = (Administradores) i;
				if (administrador.getDni().equals(dniIntroducido)) {
					System.out.println("Bienvenido administrador " + administrador.getNombre() + "\n");
					menuAdmin(biblioteca);
					encontrado = true;
					break;
				}
			}
			else if (i instanceof Usuarios) {
				Usuarios usuario = (Usuarios) i;
				if (usuario.getDni().equals(dniIntroducido)) {
					System.out.println("Bienvenido usuario " + usuario.getNombre() + "\n");
					menuUsuario();
					encontrado = true;
					break;
				}
			}
		}
		if (!encontrado) {
		    System.out.println("Lo siento, no está registrado en el sistema, contacte con un administrador\n");
		}
	}

	public static void menuAdmin(ArrayList <Personas> b) {
		Scanner sc = new Scanner(System.in);
		int opcionAdmin;

		do {
		System.out.println("----- Menú Administradores -----");
		System.out.println("1. Dar de alta a un usuario para poder hacer los préstamos");
		System.out.println("2. Penalizar a un usuario por no haber devuelto en fecha");
		System.out.println("3. Dar de alta un artículo");
		System.out.println("4. Dar de baja artículos");
		System.out.println("5. Ver los préstamos de un cliente");
		System.out.println("6. Salir");
		opcionAdmin=sc.nextInt();
		
		switch(opcionAdmin) {
		case 1: 
			System.out.println("Introduce el DNI del nuevo usuario:");
			String dniIntroducido = sc.next();
			boolean usuarioExiste = false;
			
			for (Personas i : b) {
				if (i instanceof Usuarios) {
					if (dniIntroducido.equals(i.getDni())) {
						usuarioExiste = true;
						System.out.println("Este usuario ya existe en la base de datos");
						break;
					}
				}
			}
			 if (!usuarioExiste) {
			        System.out.println("Introduce el nombre del nuevo usuario:");
			        String nombre = sc.next();
			        System.out.println("Introduce la edad del nuevo usuario:");
			        int edad = sc.nextInt();
			        Usuarios nuevoUsuario = new Usuarios(nombre, dniIntroducido, edad);
			    }
			    break;
		case 2: 
			break;
		case 3: 
			System.out.println("Introduce que tipo de artículo quieres dar de alta:");
			System.out.println("L = Libro, R = Revista, P = Película");
			char articulo = Character.toUpperCase(sc.next().charAt(0));
				switch(articulo) {
				case 'L': 
					System.out.println("Introduce el nombre del libro: ");
					String nombre = sc.next();
					System.out.println("Introduce la fecha de publicación: ");
					//Date fecha = sc.next();
					break;
				case 'R': 
					
					break;
				case 'P': 
					
					break;
		}
			break;
		case 4: 
			break;
		case 5: 
			break;
		case 6: 
			break;
		default: System.out.println("Opción no válida \n");
        	break;
		}
		
		}while (opcionAdmin!=6);
		sc.close();
	}
	
	public static void menuUsuario() {
		Scanner sc = new Scanner(System.in);
		int opcionUsuario;
		
		do {
		System.out.println("----- Menú Usuarios-----");
		System.out.println("1. Hacer un préstamo o varios a la vez.");
		System.out.println("2. Hacer una devolución o varias a la vez.");
		System.out.println("3. Ver sus préstamos en activo para ver los días que le quedan para la devolución.");
		System.out.println("4. Salir");
		opcionUsuario=sc.nextInt();
		
		switch(opcionUsuario) {
		case 1: 
			
			break;
		case 2:
			
			break;
		case 3:
			
			break;
		case 4:
			
			break;
		default: System.out.println("Opción no válida \n");
        	break;
		}
		
		}while (opcionUsuario!=6);
		sc.close();
	}
	
}
