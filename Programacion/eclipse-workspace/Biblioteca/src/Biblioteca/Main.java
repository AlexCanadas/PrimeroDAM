package Biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ArrayList <Personas> biblioteca = new ArrayList<>();
		ArrayList <Articulos> catalogo = new ArrayList<>();
		ArrayList <Prestamos> prestamos = new ArrayList<>();
		
		Administradores admin = new Administradores("Alex", "47411148Y", 33); // Creo un administrador Alex
		biblioteca.add(admin);
		
		// Comprobamos si es admin, usuario o no está registrado aún
		System.out.println("Introduce tu DNI:");	
		String dniIntroducido = sc.next();
		
		boolean encontrado = false;
		for (Personas i : biblioteca) {
			if (i instanceof Administradores) {
				Administradores administrador = (Administradores) i;
				if (administrador.getDni().equals(dniIntroducido)) {
					System.out.println("Bienvenido administrador " + administrador.getNombre() + "\n");
					Administradores menuAdministrador = new Administradores();
					menuAdministrador.menuAdmin(sc, biblioteca, prestamos, catalogo);
					//menuAdmin(sc, biblioteca, prestamos, catalogo);
					encontrado = true;
					break;
				}
			}
			else if (i instanceof Usuarios) {
				Usuarios usuario = (Usuarios) i;
				if (usuario.getDni().equals(dniIntroducido)) {
					System.out.println("Bienvenido usuario " + usuario.getNombre() + "\n");
					Usuarios menuUsuario = new Usuarios();
					menuUsuario.menuUsuario(sc, biblioteca, prestamos, catalogo);
					//menuUsuario(sc, biblioteca, prestamos, catalogo);
					encontrado = true;
					break;
				}
			}
		}
		if (!encontrado) {
		    System.out.println("Lo siento, no está registrado en el sistema, contacte con un administrador\n");
		}
	}
}
