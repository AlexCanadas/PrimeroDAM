package Biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Administradores extends Personas{

	public Administradores(String nombre, String dni, int edad) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.edad = edad;
	}
	public Administradores() {
		super();
	}

	public static void menuAdmin(Scanner sc, ArrayList <Personas> biblioteca, ArrayList <Prestamos> prestamos,
			ArrayList <Articulos> catalogo) {
		int opcionAdmin;

		do {
		System.out.println("----- Menú Administradores -----");
		System.out.println("1. Dar de alta a un usuario para poder hacer los préstamos"); 
		System.out.println("2. Penalizar a un usuario por no haber devuelto en fecha");
		System.out.println("3. Dar de alta un artículo"); 
		System.out.println("4. Dar de baja artículos"); 
		System.out.println("5. Ver los préstamos de un cliente"); 
		System.out.println("6. Acceder al menú de usuarios"); 
		System.out.println("7. Salir");
		opcionAdmin=sc.nextInt();
		
		switch(opcionAdmin) {
		case 1: 
			System.out.println("Introduce el DNI del nuevo usuario:");
			String dniIntroducido = sc.next();
			boolean usuarioExiste = false;
			
			for (Personas i : biblioteca) {
				if (i instanceof Usuarios) {
					if (dniIntroducido.equals(i.getDni())) {
						usuarioExiste = true;
						System.out.println("Este usuario ya existe en la base de datos");
						break;
					}
				}
			}
			 if (!usuarioExiste) {
			        Usuarios usuario = new Usuarios();
			        Personas nuevaPersonaARegistrar = usuario.altaUsuario(sc, dniIntroducido);
			        biblioteca.add(nuevaPersonaARegistrar);
			    }
			    break;
			    
		case 2: 
			System.out.println("Introduce el DNI del usuario a penalizar: ");
			String dni = sc.next();
			for (Personas buscarUsuario : biblioteca) {
				if(buscarUsuario.getDni().equals(dni)) {
					System.out.println("Introduce el ID del préstamo al que añadir una penalización: ");
					long idPrestamo = sc.nextLong();
					for (Prestamos buscarPrestamo : prestamos) {
						if (buscarPrestamo.getIdPrestamo()==idPrestamo) {
							buscarPrestamo.penalizar(sc);
						}
					}
				}
			}
			break;
			
		case 3: 
			System.out.println("Introduce que tipo de artículo quieres dar de alta:");
			System.out.println("L = Libro, R = Revista, P = Película");
			char articulo = Character.toUpperCase(sc.next().charAt(0));
				switch(articulo) {
				case 'L': 
					Libro libro = new Libro();
					Articulos nuevoArticuloLibro = libro.darDeAlta(sc);
					catalogo.add(nuevoArticuloLibro);
					Articulos ultimoArticuloLibro = catalogo.get(catalogo.size() - 1);
		            System.out.println("Detalles del último artículo agregado:");
		            ultimoArticuloLibro.mostrarDetalles();
					break;
				case 'R': 
					Revista revista = new Revista();
					Articulos nuevoArticuloRevista = revista.darDeAlta(sc);
					catalogo.add(nuevoArticuloRevista);
					Articulos ultimoArticuloRevista = catalogo.get(catalogo.size() - 1);
		            System.out.println("Detalles del último artículo agregado:");
		            ultimoArticuloRevista.mostrarDetalles();
					break;
				case 'P': 
					Pelicula pelicula = new Pelicula();
					Articulos nuevoArticuloPelicula = pelicula.darDeAlta(sc);
					catalogo.add(nuevoArticuloPelicula);
					Articulos ultimoArticuloPelicula = catalogo.get(catalogo.size() - 1);
		            System.out.println("Detalles del último artículo agregado:");
		            ultimoArticuloPelicula.mostrarDetalles();
					break;
				}
			break;
			
		case 4: 
			menuBaja(sc, catalogo);
			break;
			
		case 5: 
			boolean dniEncontrado = false;
			System.out.println("Introduce el DNI del usuario del que ver sus préstamos: ");
			String dniAMostrar = sc.next();

			for (Prestamos prestamo : prestamos) {
			    if (prestamo.getDniUsuario().equals(dniAMostrar)) {
			        dniEncontrado = true;
			        System.out.println("Préstamo asociado al DNI: " + dniAMostrar);
			        System.out.println(prestamo.toString()); // Mostramos detalles del préstamo
			    }
			}

			if (!dniEncontrado) {
			    System.out.println("No hay préstamos asociados al DNI proporcionado: " + dniAMostrar);
			}
			break;
			
		case 6: 
			Usuarios usuario = new Usuarios();
	        usuario.menuUsuario(sc, biblioteca, prestamos, catalogo);
		break;
		
		case 7: System.out.println("Que tengas un buen día");
			break;
		default: System.out.println("Opción no válida \n");
        	break;
		}
		
		}while (opcionAdmin!=7);
		sc.close();
	}
	
	protected static void menuBaja(Scanner sc, ArrayList<Articulos>catalogo) {
		System.out.println("Selecciona que tipo de artículo quieres dar de baja: ");
		System.out.println("L = Libro, R = Revista, P = Película");
		char articulo =  Character.toUpperCase(sc.next().charAt(0));
		switch(articulo) {
		case 'L':
			Libro libro = new Libro();
			libro.darDeBaja(sc, catalogo);
			break;
		case 'R':
			Revista revista = new Revista();
			revista.darDeBaja(sc, catalogo);
			break;
		case 'P': 
			Pelicula pelicula = new Pelicula();
			pelicula.darDeBaja(sc, catalogo);
			break;
		}
	}
}
