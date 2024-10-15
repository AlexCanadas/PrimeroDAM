package Ejercicio1;

import java.util.ArrayList;
import java.util.Scanner;

public class Logic {

	public static void iniciarAplicacion() {
		// Creamos el arrayList de tipo Usuario
		ArrayList<Usuario> listaUsuarios = new ArrayList<>();
		int opcion;
		Scanner sc = new Scanner(System.in);
		// Instanciamos Usuario para poder acceder a sus métodos y atributos
		Usuario nuevoUsuario = new Usuario();
		// Bandera booleana para poder salir del menú
		boolean salir = false;

		do {
			mostrarMenu();
			opcion = sc.nextInt();
			sc.nextLine();

			switch (opcion) {
			case 1:
				// Llamamos al método para rellenar nombre y apellido
				rellenarNombre(sc, nuevoUsuario);
				break;
			case 2:
				// Llamamos al método para rellenar la contraseña
				rellenarApellidos(sc, nuevoUsuario);
				break;
			case 3:
				// Llamamos al método para rellenar el DNI
				rellenarDni(sc, nuevoUsuario);
				break;
			case 4:
				// Comprobamos que estén todos los datos rellenos
				if (datosCompletos(nuevoUsuario)) {
					// Añadimos al nuevo usuario al arrayList listaUsuarios
					listaUsuarios.add(nuevoUsuario);
					// Después de verificar que están todos los datos, marcamos salir como true
					salir = true;
					// Imprimimos los datos del formulario con el toString
					System.out.println(nuevoUsuario);
					System.out.println("¡Que tengas un buen día!");
				}
				break;
			default:
				System.out.println("Opción incorrecta, inténtelo de nuevo \n");
			}

		} while (opcion != 4 || !salir);

		sc.close();

	}

	// Método para mostrar el menú de opciones
	public static void mostrarMenu() {
		System.out.println("\n----Menú de opciones----");
		System.out.println("1. Introduce el nombre");
		System.out.println("2. Introduce los apellidos del usuario");
		System.out.println("3. Introduce el DNI del usuario");
		System.out.println("4. Salir");
	}

	// Método para pedir el nombre del usuario
	public static void rellenarNombre(Scanner sc, Usuario nuevoUsuario) {
		System.out.println("Introduce el nombre del usuario: ");
		String nombre = sc.nextLine().trim();
		nuevoUsuario.setNombre(nombre);

	}

	// Método para pedir los apellidos
	public static void rellenarApellidos(Scanner sc, Usuario nuevoUsuario) {
		System.out.println("Introduce los apellidos del usuario: ");
		String apellidos = sc.nextLine().trim();
		nuevoUsuario.setApellido(apellidos);
	}

	// Método para rellenar el DNI
	public static void rellenarDni(Scanner sc, Usuario nuevoUsuario) {
		System.out.println("Introduce el DNI del usuario: ");
		String dni = sc.nextLine().trim();
		// Lanzamos las dos excepciones y si cumple con ellas guardamos el DNI
		// introducido
		try {
			LongitudDNINoValidaException.longitudDni(dni);
			UltimoDigitoNoLetraException.ultimoDigitoDni(dni);
			nuevoUsuario.setDni(dni);
			// Si fallase algo lanzamos el toString con el mensaje de la excepción creada
			// correspondiente
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

	}

	// Método para verificar si todos los datos están completos
	public static boolean datosCompletos(Usuario nuevoUsuario) {
		if (nuevoUsuario.getNombre() != null && nuevoUsuario.getApellidos() != null && nuevoUsuario.getDni() != null) {
			return true;
		} else {
			// Lanzamos mensaje en caso de faltar datos por cumplimentar
			System.out.println("Faltan datos por rellenar \n");
		}
		return false;

	}

}
