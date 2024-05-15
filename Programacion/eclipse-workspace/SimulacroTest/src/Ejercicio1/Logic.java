package Ejercicio1;

import java.util.ArrayList;
import java.util.Scanner;

public class Logic {
	Scanner sc = new Scanner(System.in);
	ArrayList<Usuario> listaUsuarios = new ArrayList<>();
	int opcion;
	boolean datosCompletos = false;
	Usuario usuarioActual = new Usuario();

	public void iniciarAplicacion() {

		do {
			mostrarMenu();
			opcion = sc.nextInt();
			sc.nextLine();

			switch (opcion) {
			case 1:
				rellenarNombreYApellidos(sc, usuarioActual);
				break;
			case 2:
				rellenarContraseña(sc, usuarioActual);
				break;
			case 3:
				rellenarDni(sc, usuarioActual);
				break;
			case 4:
				if (verificarDatosCompletos(usuarioActual)) {
					datosCompletos = true;
					listaUsuarios.add(usuarioActual);
					System.out.println("Que tengas un buen día \n");
					System.out.println(usuarioActual);
				} else {
					System.out.println("Faltan datos por rellenar");
				}
				break;
			default:
				System.out.println("Opción incorrecta, inténtelo de nuevo \n");
			}

		} while (opcion != 4 || !datosCompletos);
		sc.close();

	}

	public static void mostrarMenu() {
		System.out.println("\nMenú de opciones");
		System.out.println("1. Rellenar usuario");
		System.out.println("2. Rellenar contraseña");
		System.out.println("3. Rellenar DNI");
		System.out.println("4. Finalizar");
	}

	public static void rellenarNombreYApellidos(Scanner sc, Usuario usuario) {
		System.out.println("Introduce el nombre: ");
		String nombre = sc.nextLine().trim();
		System.out.println("Introduce los apellidos: ");
		String apellidos = sc.nextLine().trim();
		usuario.setNombre(nombre);
		usuario.setApellido(apellidos);
	}

	public static void rellenarContraseña(Scanner sc, Usuario usuario) {
		System.out.println("Introduce la contraseña: ");
		String contraseña = sc.nextLine().trim();
		usuario.setContraseña(contraseña);
	}

	public static void rellenarDni(Scanner sc, Usuario usuario) {
		System.out.println("Introduce el DNI: ");
		String dni = sc.nextLine().trim();
		try {
			LongitudDNINoValidaException.validarDni(dni);
			UltimoDigitoNoLetraException.validarDni2(dni);
			usuario.setDni(dni);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

	}

	public static boolean verificarDatosCompletos(Usuario usuario) {
		return usuario.getNombre() != null && !usuario.getNombre().isEmpty() && usuario.getApellido() != null
				&& !usuario.getApellido().isEmpty() && usuario.getContraseña() != null
				&& !usuario.getContraseña().isEmpty() && usuario.getDni() != null && !usuario.getDni().isEmpty();

	}
}
