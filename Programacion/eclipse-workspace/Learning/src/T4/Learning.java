package T4;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Random;

public class Learning {

	public static void main(String[] args) {
										// T4
		// con el método toString() de la clase Integer convertimos el entero a cadena
		int numero = 1;
		String cadena = Integer.toString(numero);
		System.out.println(numero + " " + cadena);
		
		// a través del método parseInt convertimos la cadena a un número entero
		cadena = "123456";
		int numeroEntero = Integer.parseInt(cadena);
		System.out.println(cadena + " " + numeroEntero);
		
		Character.isDigit('A'); // devolverá False, ya que la A no es un dígito numérico
		Character.isDigit('2'); // devolverá True, ya que el 2 sí que es un dígito numérico
		Character.isUpperCase('A'); // devolverá True, ya que el carácter ‘A’ está en mayúsculas
		Character.isLowerCase('a'); // devolverá True, ya que el carácter ‘a’ está en minúsculas
		char caracterMinusculas = Character.toLowerCase('A'); // guarda en la variable la letra ‘a’ (‘A’ en minúsculas)
		
		Random semillaAleatorio = new Random(); // creación de un objeto de la clase Random
		int numeroAleatorio = semillaAleatorio.nextInt(); // genera un número aleatorio entero
		float numeroAleatorioDecimal= semillaAleatorio.nextFloat(); // crea núm. aleat. tipo float entre 0 y 1
		
		int numeroRedondeado = (int) Math.round(5.2); // redondea 5.2 y devuelve 5
		numeroRedondeado = (int) Math.round(5.9); // redondea 5.9 y devuelve 6
		int mayor = Math.max(10, 2); // devuelve 10, el valor mayor de los dos
		int menor = Math.min(10, 2); // devuelve 2, el valor menor de los dos
		double raiz = Math.sqrt(36); // devuelve 6.0, la raíz cuadrada de 36
		double potencia = Math.pow(2, 5); // devuelve 32, el resultado de 2 elevado a 5
		int radio = 0; double area = 2*Math.PI*radio; // calcula la superficie de una circunferencia
		
		Date hoy = new Date(); // crea un objeto Date con la fecha de hoy
		SimpleDateFormat formatea = new SimpleDateFormat("dd/mm/yyyy");
		System.out.println("Hoy es " + formatea.format(hoy));
		
		
											// Arrays
		// Vectores
		int[] arrayEnteros;
		arrayEnteros = new int[100];
		
	}

}
