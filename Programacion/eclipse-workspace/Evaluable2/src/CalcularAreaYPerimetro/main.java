package CalcularAreaYPerimetro;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int opcion;

		mostrarMenu();
		System.out.println("Elige que opción deseas realizar: ");
		opcion = sc.nextInt();
		
		switch (opcion) {
		case 1: 
			
			break; 
		case 2: 
			
			break; 
		case 3: 
	
			break; 
		case 4: 
	
			break; 
		}
	
	}

	public static void mostrarMenu() {
		System.out.println("---------Menú---------");
		System.out.println("1. Dar de alta un programador");
		System.out.println("2. Dar de baja un programador");
		System.out.println("3. Aumentar salario de un programador");
		System.out.println("4. Salir");
	}
	
	protected static void alta() {
		
	}
	
	protected static void baja() {
		
	}
	
	protected static void aumentarSalario() {
		
	}
}
