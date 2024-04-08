package Biblioteca;

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
}
