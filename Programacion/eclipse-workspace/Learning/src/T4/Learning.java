package T4;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.Scanner;

public class Learning {

	public static void main(String[] args) {
		// T4
		// con el método toString() de la clase Integer convertimos el entero a cadena
		int numero = 1;
		String cadena = Integer.toString(numero);
		System.out.println(numero + " " + cadena);
		// O también
		String cadena1 = String.valueOf(numero);

		// a través del método parseInt convertimos la cadena a un número entero
		cadena = "123456";
		int numeroEntero = Integer.parseInt(cadena);
		System.out.println(cadena + " " + numeroEntero);

		// de String a int - parseDouble
		double doble = Double.parseDouble(cadena);

		Character.isDigit('A'); // devolverá False, ya que la A no es un dígito numérico
		Character.isDigit('2'); // devolverá True, ya que el 2 sí que es un dígito numérico
		Character.isUpperCase('A'); // devolverá True, ya que el carácter ‘A’ está en mayúsculas
		Character.isLowerCase('a'); // devolverá True, ya que el carácter ‘a’ está en minúsculas
		char caracterMinusculas = Character.toLowerCase('A'); // guarda en la variable la letra ‘a’ (‘A’ en minúsculas)

		Random semillaAleatorio = new Random(); // creación de un objeto de la clase Random
		int numeroAleatorio = semillaAleatorio.nextInt(); // genera un número aleatorio entero
		float numeroAleatorioDecimal = semillaAleatorio.nextFloat(); // crea núm. aleat. tipo float entre 0 y 1

		int numeroRedondeado = (int) Math.round(5.2); // redondea 5.2 y devuelve 5
		numeroRedondeado = (int) Math.round(5.9); // redondea 5.9 y devuelve 6
		int mayor = Math.max(10, 2); // devuelve 10, el valor mayor de los dos
		int menor = Math.min(10, 2); // devuelve 2, el valor menor de los dos
		double raiz = Math.sqrt(36); // devuelve 6.0, la raíz cuadrada de 36
		double potencia = Math.pow(2, 5); // devuelve 32, el resultado de 2 elevado a 5
		int radio = 0;
		double area = 2 * Math.PI * radio; // calcula la superficie de una circunferencia

		Date hoy = new Date(); // crea un objeto Date con la fecha de hoy
		SimpleDateFormat formatea = new SimpleDateFormat("dd/mm/yyyy");
		System.out.println("Hoy es " + formatea.format(hoy));

		// Arrays
		// Vectores o Arrays unidimensionales
		int[] arrayEnteros;
		arrayEnteros = new int[100];
		int[] arrayEnteros1 = new int[100]; // crearla y darle tamaño de una vez
		for (int indice = 0; indice < arrayEnteros.length; indice++) { // recorrer el array
			System.out.println("El contenido de la posición " + indice + " es " + arrayEnteros[indice]);
		}
		Scanner teclado = new Scanner(System.in); // introducir datos externamente
		int[] arrayEnteros3 = new int[6];
		for (int indice = 0; indice < 6; indice++) {
			System.out.print("Introduzca el valor para la posición " + indice + ": ");
			arrayEnteros3[indice] = teclado.nextInt();

			// Matrices o Arrays multidimensionales
			int[][] matriz = new int[3][4];
			int[][] matriz2 = { { 8, 3, 10, 6 }, { 10, 4, 11, 12 }, { 13, 17, 4, 0 } }; // iniciamos el array con 3
																						// filas y 4 columnas
			int filas = arrayEnteros.length; // nos devuelve la cantidad de filas que tiene la matriz
			int columnas = matriz[0].length; // devuelve la cantidad de columnas de la primera fila, que será la misma
												// que en el resto de filas
			Scanner teclado1 = new Scanner(System.in);
			int[][] matriz1 = new int[3][3]; // aqui introducimos un valor en un punto exacto del Array
			for (int fila = 0; fila < matriz1.length; fila++) {
				for (int columna = 0; columna < matriz1[fila].length; columna++) {
					System.out.print("Introduzca el contenido de la posición [" + fila + "," + columna + "]: ");
					matriz1[fila][columna] = teclado1.nextInt();
				}
			}

			String str = "Hola";
			char primerCaracter = str.charAt(0); // 'H'
			String str2 = "abcdef";
			String subcadena1 = str2.substring(2, 4); // "cd"
			String subcadena2 = str2.substring(3); // "def"

		}

	}

}
