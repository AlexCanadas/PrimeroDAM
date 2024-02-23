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
		programador c1 = new programador(lineasDecCodigoPorHora, lenguajeDominante, nombre, dni, edad,
				casado, salario);
		ArrayList<empleado> registro = new ArrayList<>();
		
	do {
		mostrarMenu();
		System.out.println("Elige que opción deseas realizar: ");
		opcion = sc.nextInt();
		
		switch (opcion) {
		case 1: 
			System.out.println("Introduce el DNI:");
			
			System.out.println("Introduce el nombre y apellido:");
			
			System.out.println("Introduce la edad:");
			
			System.out.println("Introduce si esta casado (si/no):");
			
			System.out.println("Introduce el salario que comenzará ganando:");
			
			System.out.println("Introduce el lenguaje de programación dominante:");
			
			System.out.println("Introduce el lenguaje la cantidad de líneas de código por hora que realiza:");
			
			alta(c1, sc);
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
	
	protected static void alta(programador c1, Scanner sc) {
		 c1.setDni(dni); 
		 c1.setNombre(nombre);
		 c1.setEdad(edad);
		 c1.setCasado(casado);
		 c1.setSalario(salario);
	}
	
	protected static void baja() {
		
	}
	
	protected static void aumentarSalario() {
		
	}
}
