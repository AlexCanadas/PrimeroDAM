package Moldes;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Moldes {

    /**
     * Método para mostrar un menú típico.
     */
    public void menu() {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        int opcion;

        while (!salir) {
            System.out.println("\nMenú:");
            System.out.println("1. Opción 1");
            System.out.println("2. Opción 2");
            System.out.println("3. Opción 3");
            System.out.println("4. Salir");

            try {
                System.out.print("Selecciona una opción: ");
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Has seleccionado Opción 1");
                        break;
                    case 2:
                        System.out.println("Has seleccionado Opción 2");
                        break;
                    case 3:
                        System.out.println("Has seleccionado Opción 3");
                        break;
                    case 4:
                        System.out.println("Saliendo...");
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no válida");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, introduce un número.");
                scanner.next(); // Limpiar el scanner
            }
        }
    }

    /**
     * Método para demostrar un uso típico de switch.
     */
    public void ejemploSwitch() {
        int numero = 3;

        switch (numero) {
            case 1:
                System.out.println("Caso 1");
                break;
            case 2:
                System.out.println("Caso 2");
                break;
            case 3:
                System.out.println("Caso 3");
                break;
            default:
                System.out.println("Caso por defecto");
                break;
        }
    }
    
    /**
     * Método para demostrar el uso de un array unidimensional con un bucle for.
     */
    public void ejemploArrayUnidimensional() {
        int[] numeros = {10, 20, 30, 40, 50};

        System.out.println("\nArray unidimensional:");
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Índice " + i + ": " + numeros[i]);
        }
    }
    
    /**
     * Método para demostrar el uso de un array bidimensional con un bucle for.
     */
    public void ejemploArrayBidimensional() {
        int[][] matriz = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("\nArray bidimensional:");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Método para demostrar el uso de ArrayList.
     */
    public void ejemploArrayList() {
        List<String> lista = new ArrayList<>();
        lista.add("Elemento 1");
        lista.add("Elemento 2");
        lista.add("Elemento 3");

        System.out.println("\nContenido del ArrayList:");
        for (String elemento : lista) {
            System.out.println(elemento);
        }
    }

    /**
     * Método para demostrar el uso de un bucle for.
     */
    public void ejemploFor() {
        System.out.println("\nBucle for del 1 al 5:");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Valor de i: " + i);
        }
    }

    /**
     * Método para demostrar el uso de un bucle foreach.
     */
    public void ejemploForEach() {
        List<String> lista = new ArrayList<>();
        lista.add("Elemento A");
        lista.add("Elemento B");
        lista.add("Elemento C");

        System.out.println("\nBucle foreach:");
        for (String elemento : lista) {
            System.out.println(elemento);
        }
    }

    /**
     * Método para demostrar el uso de un bucle while.
     */
    public void ejemploWhile() {
        int contador = 1;

        System.out.println("\nBucle while del 1 al 5:");
        while (contador <= 5) {
            System.out.println("Valor de contador: " + contador);
            contador++;
        }
    }

    /**
     * Método para demostrar el uso de un bucle do-while.
     */
    public void ejemploDoWhile() {
        int contador = 1;

        System.out.println("\nBucle do-while del 1 al 5:");
        do {
            System.out.println("Valor de contador: " + contador);
            contador++;
        } while (contador <= 5);
    }
}