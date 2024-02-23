package CalcularAreaYPerimetro;

import java.util.ArrayList;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int opcion;
		
		// Creamos el arrayList;
		ArrayList<Programador> registro = new ArrayList<>();
		
	do {
		mostrarMenu();
		System.out.println("Elige que opción deseas realizar: ");
		opcion = sc.nextInt();
		
		switch (opcion) {
		case 1: 
			 alta(registro, sc);
			 break;
			 
		case 2: 
			baja (registro, sc);
			break; 
			
		case 3: 
			aumentarSalario(registro, sc);
			break; 
			
		case 4: 
			System.out.println("¡Que tengas un buen día!");
			break; 
			
		 default:
             System.out.println("Opción inválida. Inténtelo de nuevo por favor.");
             System.out.println("");
		}
	
	} while (opcion != 4);
}

	public static void mostrarMenu() {
		System.out.println("---------Menú---------");
		System.out.println("1. Dar de alta un programador");
		System.out.println("2. Dar de baja un programador");
		System.out.println("3. Aumentar salario de un programador");
		System.out.println("4. Salir");
	}
	
	protected static void alta(ArrayList<Programador> registro, Scanner sc) {
		String nombre, dni;
		int edad;
		boolean casado;
		double salario;
		int lineasDecCodigoPorHora;
		String lenguajeDominante;
		
		 System.out.println("Introduce el DNI:");
		 dni = sc.next();	   
		 System.out.println("Introduce el nombre y apellido:");
		 nombre = sc.next();  
		 System.out.println("Introduce la edad:"); 
		 edad = sc.nextInt(); 
		 System.out.println("Introduce si esta casado (si/no):");
			 String respuesta = sc.next().toLowerCase(); // Cambiamos la respuesta a minúsculas para hacer la comparación más sencilla
				if (respuesta.equals("si")) {
				    casado = true;
				} else if (respuesta.equals("no")) {
				    casado = false;
				} else {
				    System.out.println("Respuesta no válida. Se asumirá que no está casado.");
				    casado = false; // Ponemos no casado si la respuesta no es correcta
				}
		 System.out.println("Introduce el salario que comenzará ganando:");
		 salario = sc.nextDouble();
		 System.out.println("Introduce el lenguaje de programación dominante:");
		 lenguajeDominante = sc.next();
		 System.out.println("Introduce la cantidad de líneas de código por hora que realiza:");
		 lineasDecCodigoPorHora = sc.nextInt();  
		 
		 // Creamos un nuevo objeto programador con los detalles proporcionados
		 Programador nuevoProgramador = new Programador(lineasDecCodigoPorHora, lenguajeDominante, nombre, dni, 
				 edad, casado, salario);

		 // Agregamos el nuevo programador al ArrayList
		 registro.add(nuevoProgramador);
		 
		 System.out.println("El programador con DNI: " + dni + " + nombre: " + nombre 
		 		+ "ha sido registrado correctamente");
	}
	
	protected static void baja(ArrayList<Programador> registro, Scanner sc) {
		System.out.println("Introduce el DNI del programador a eliminar: ");
		String dni = sc.next();
		for (Programador p : registro) {
			if (dni.equals(p.getDni())) {
				registro.remove(p);
				System.out.println("El programador con DNI: " + dni + " y nombre: " + p.getNombre() + " ha sido eliminado");
				break;
			}
			else {
				System.out.println("Este DNI no existe en la base de datos");
				break;
			}
		}
	}
	
	protected static void aumentarSalario(ArrayList<Programador> registro, Scanner sc) {
		System.out.println("Introduce el DNI del programador que recibirá el aumento: ");
		String dni = sc.next();
		for (Programador p : registro) {
			if (dni.equals(p.getDni())) {
		System.out.println("Introduce que procentaje de aumento de salario va a recibir el programador: ");
		int porcentaje = sc.nextInt();
		System.out.println("El salario actual era de: " + p.getSalario());
		p.aumentarSalario(porcentaje);
		System.out.println("El nuevo salario será de: " + p.getSalario());
			}
			else {
				System.out.println("Este DNI no está registrado en la base de datos");
			}
		}
	}
}
