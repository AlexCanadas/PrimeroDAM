package cuentaBancaria;

import java.util.Scanner;

public class principal {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String titular;
        double cantidad = 0;
        int opcion = 0;
        
        System.out.println("Ingrese el nombre del titular: ");
        titular = sc.next();
        // Crear una cuenta con titular y cantidad
        Cuenta c1 = new Cuenta(titular, cantidad);
        c1.setTitular(titular);
        
        do {
            mostrarMenu(opcion, sc);
            System.out.println("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    ingresarDinero(c1, sc);
                    break;
                case 2:
                    retirarDinero(c1, sc);
                    break;
                case 3:
                    mostrarEstado(c1);
                    break;
                case 4:
                    System.out.println("¡Que tengas un buen día!");
                    break;
                default:
                    System.out.println("Opción inválida. Inténtelo de nuevo por favor.");
                    System.out.println("");
            }
        } while (opcion != 4);

        sc.close();
    }

	public static void mostrarMenu(int opcion, Scanner sc) {
        System.out.println("-- Cuenta --");
        System.out.println("1. Ingresar");
        System.out.println("2. Retirar");
        System.out.println("3. Conocer estado actual");
        System.out.println("4. Salir");
    }
	public static void ingresarDinero(Cuenta c1, Scanner sc) {
		  // Retirar dinero
        System.out.print("Ingrese la cantidad a ingresar: ");
        double ingreso = sc.nextDouble();
        c1.ingresar(ingreso);
        System.out.println("");
	}
	public static void retirarDinero(Cuenta c1, Scanner sc) {
		// Retirar dinero
		System.out.print("Ingrese la cantidad a retirar: ");
        double retiro = sc.nextDouble();
        c1.retirar(retiro);
        System.out.println("");
	}
	public static void mostrarEstado(Cuenta c1) {
		// Mostrar información actualizada de la cuenta
		System.out.println(c1);
		System.out.println("");
	}
	
}

