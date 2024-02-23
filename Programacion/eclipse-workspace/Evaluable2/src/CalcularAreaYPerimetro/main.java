package CalcularAreaYPerimetro;

import java.util.ArrayList;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int opcion;
		String nombre = null, dni = null;
		int edad = 0;
		boolean casado = false;
		double salario = 0;
		int lineasDecCodigoPorHora = 0;
		String lenguajeDominante = null;
		
		// Creamos el arrayList;
		ArrayList<programador> registro = new ArrayList<>();
		
		programador c1 = new programador(lineasDecCodigoPorHora, lenguajeDominante, nombre, dni, edad,
				casado, salario);
		
	do {
		mostrarMenu();
		System.out.println("Elige que opción deseas realizar: ");
		opcion = sc.nextInt();
		
		switch (opcion) {
		case 1: 
			 alta(registro, sc);
				
			 break;
			 
		case 2: 
			
			break; 
			
		case 3: 
	
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
	
	protected static void alta(ArrayList<programador> registro, Scanner sc) {
		 System.out.println("Introduce el DNI:");
		 String dni = sc.next();
		    
		 System.out.println("Introduce el nombre y apellido:");
		 String nombre = sc.next();
		    
		 System.out.println("Introduce la edad:");
		 int edad = sc.nextInt();
		    
		 System.out.println("Introduce si esta casado (si/no):");
			 String respuesta = sc.next().toLowerCase(); // Convertimos la respuesta a minúsculas para hacer la 
			 // comparación más sencilla
				boolean casado;
				if (respuesta.equals("si")) {
				    casado = true;
				} else if (respuesta.equals("no")) {
				    casado = false;
				} else {
				    System.out.println("Respuesta no válida. Se asumirá que no está casado.");
				    casado = false; // Si la respuesta no es "si" ni "no", se asume que no está casado
				}
		 System.out.println("Introduce el salario que comenzará ganando:");
		 double salario = sc.nextDouble();
		    
		 System.out.println("Introduce el lenguaje de programación dominante:");
		 String lenguajeDominante = sc.next();
		 
		    
		 System.out.println("Introduce la cantidad de líneas de código por hora que realiza:");
		 int lineasDecCodigoPorHora = sc.nextInt();  
		 
		 // Crear un nuevo objeto programador con los detalles proporcionados
		 programador nuevoProgramador = new programador(lineasDecCodigoPorHora, lenguajeDominante, nombre, dni, 
				 edad, casado, salario);

		 // Agregar el nuevo programador al ArrayList
		 registro.add(nuevoProgramador);
	}
	
	protected static void baja() {
		
	}
	
	protected static void aumentarSalario() {
		
	}
	
}
