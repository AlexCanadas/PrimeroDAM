package Ejercicio1;

import java.util.Scanner;

public class Logic {

	public static void iniciarAplicacion() {

		int opcion;
		Scanner sc = new Scanner(System.in);
		Usuario nuevoUsuario = new Usuario();
		boolean salir = false;

		do {
			mostrarMenu();
			opcion = sc.nextInt();
			sc.nextLine();

			switch (opcion) {
			case 1:
				rellenarUsuario(sc, nuevoUsuario);
				break;
			case 2:
				rellenarContraseña(sc, nuevoUsuario);
				break;
			case 3:
				rellenarDni(sc, nuevoUsuario);
				break;
			case 4:
				if (datosCompletos(nuevoUsuario)) {
					salir = true;
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

	public static void mostrarMenu() {
		System.out.println("----Menú de opciones----");
		System.out.println("1. Introduce el nombre de usuario");
		System.out.println("2. Introduce la contraseña del usuario");
		System.out.println("3. Introduce el DNI del usuario");
		System.out.println("4. Salir");
	}

	public static void rellenarUsuario(Scanner sc, Usuario nuevoUsuario) {
		System.out.println("Introduce el nombre del usuario: ");
		String nombre = sc.nextLine().trim();
		nuevoUsuario.setUsuario(nombre);
	}

	public static void rellenarContraseña(Scanner sc, Usuario nuevoUsuario) {
		System.out.println("Introduce la contraseña del usuario: ");
		String contraseña = sc.nextLine().trim();
		nuevoUsuario.setContraseña(contraseña);
	}

	public static void rellenarDni(Scanner sc, Usuario nuevoUsuario) {
		System.out.println("Introduce el DNI del usuario: ");
		String dni = sc.nextLine().trim();
		try {
			LongitudDNINoValidaException.comprobarLongitudDni(dni);
			UltimoDigitoNoLetraException.comprobarUltimoDigito(dni);
			nuevoUsuario.setDni(dni);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

	}

	public static boolean datosCompletos(Usuario nuevoUsuario) {
		if (nuevoUsuario.getUsuario() != null && nuevoUsuario.getContraseña() != null
				&& nuevoUsuario.getDni() != null) {
			return true;
		} else {
			System.out.println("Faltan datos por rellenar \n");
		}
		return false;

	}

}
