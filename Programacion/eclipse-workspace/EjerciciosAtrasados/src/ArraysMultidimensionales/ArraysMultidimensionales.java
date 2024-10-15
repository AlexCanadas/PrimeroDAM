package ArraysMultidimensionales;

import java.util.Scanner;

public class ArraysMultidimensionales {

	public static void main(String[] args) {
		//1. Crear una matriz de 3×3 con los números del 1 al 9. Mostrar por pantalla en forma de matriz.
		 int matriz [][] = new int [3][3];
		 // Llenamos la matriz
		 int numeros = 1;
		 System.out.println("Ejercicio 1: ");
		 for (int filas=0; filas<matriz.length; filas++) {
			 for (int columnas=0; columnas<matriz[0].length; columnas++) {
				 matriz[filas][columnas] = numeros;
				 numeros++;
			 }
		 }
		 //Imprimimos la matriz
		 for (int filas=0; filas<matriz.length; filas++) {
			 for (int columnas=0; columnas<matriz[0].length; columnas++) {
				 System.out.print("[" + matriz[filas][columnas] + "]");
			    }
			    System.out.println();
		 }
		 
		//2. Crear una matriz de 5 filas y n columnas (se pide al usuario). Rellenarlo con números aleatorios entre 0 y 10.
		 Scanner sc = new Scanner(System.in);
		 int FILAS2 = 5;
		 int COLUMNAS2;
		 System.out.println("");
		 System.out.println("Ejercicio 2: ");
		 // Pedimos el n columnas
		 System.out.println("Introduce el número de columnas que desea: ");
		 COLUMNAS2 = sc.nextInt();
		 int matriz2[][] = new int[FILAS2][COLUMNAS2]; // Definimos la matriz ahora que sabemos las columnas
		 // Rellenamos la matriz con números aleatorios
		 for (int filas2 = 0; filas2<matriz2.length; filas2++) {
			 for (int columnas2 = 0; columnas2<matriz2[0].length; columnas2++) {
				 matriz2[filas2][columnas2] = (int) (Math.random()*11);
			 }
		 }
		 // Imprimimos la matriz
		 for (int filas2 = 0; filas2<matriz2.length; filas2++) {
			 for (int columnas2 = 0; columnas2<matriz2[0].length; columnas2++) {
				 System.out.print("[" + matriz2[filas2][columnas2] + "]");
			 }
			    System.out.println();
		 }		 
			 
		/*3. Crear dos matrices de n filas x n columnas y sumar sus valores, los resultados se deben almacenar en otra matriz. 
		Los valores y el tamaño No, serán insertados por el usuario. Mostrar las matrices originales y el resultado.*/
		System.out.println("");
		System.out.println("Ejercicio 3: ");
		int FILAS3;
		int COLUMNAS3;
		System.out.println("Introduce las filas que desea en los arrays: ");
		FILAS3 = sc.nextInt();
		System.out.println("Introduce las columnas que desea en los arrays: ");
		COLUMNAS3 = sc.nextInt();
		// Creamos las 3 matrices ahora que sabemos su tamaño
		int matriz3[][] = new int[FILAS3][COLUMNAS3];
		int matriz4[][] = new int[FILAS3][COLUMNAS3];
		int matriz5[][] = new int[FILAS3][COLUMNAS3];
		// Rellenamos primer array
		System.out.println("Primera matriz.\nIntroduce el valor para la posición: ");
		for (int filas3=0; filas3<matriz3.length; filas3++) {
			for (int columnas3=0; columnas3<matriz3.length; columnas3++) {
				System.out.println("["+filas3+"]["+columnas3+"]: ");
				matriz3[filas3][columnas3] = sc.nextInt();
			}
		}
		// Rellenamos el segundo array
		System.out.println("Segunda matriz.\nIntroduce el valor para la posición: ");
		for (int filas4=0; filas4<matriz4.length; filas4++) {
			for (int columnas4=0; columnas4<matriz4.length; columnas4++) {
				System.out.println("["+filas4+"]["+columnas4+"]: ");
				matriz4[filas4][columnas4] = sc.nextInt();
			}
		}
		// Sumamos ambos arrays en los introducimos en el tercer array
		for (int filas5=0; filas5<matriz5.length; filas5++) {
		    for (int columnas5=0; columnas5<matriz5[0].length; columnas5++) {
		        matriz5[filas5][columnas5] = matriz3[filas5][columnas5] + matriz4[filas5][columnas5];
		    }
		}

		// Mostrar la matriz3 ingresada
		System.out.println("La primera matriz ingresada es:");
		for (int filas3=0; filas3<matriz3.length; filas3++) {
		    for (int columnas3=0; columnas3<matriz3[0].length; columnas3++) {
		        System.out.print("["+matriz3[filas3][columnas3]+"]");
		    }
		    System.out.println();
		}
		//Mostrar la matriz4 ingresada
		System.out.println("La segunda matriz ingresada es:");
		for (int filas4=0; filas4<matriz4.length; filas4++) {
		    for (int columnas4=0; columnas4<matriz4[0].length; columnas4++) {
		        System.out.print("["+matriz4[filas4][columnas4]+"]");
		    }
		    System.out.println();
		}
		// Imprimimos el tercer array con los resultados
		System.out.println("La tercera matriz resultante de la suma entre los dos primeros arrays es:");
		for (int filas5=0; filas5<matriz5.length; filas5++) {
		    for (int columnas5=0; columnas5<matriz5[0].length; columnas5++) {
		        System.out.print("[" + matriz5[filas5][columnas5]+"]");
		    }
		    System.out.println();
		}
	}
}
