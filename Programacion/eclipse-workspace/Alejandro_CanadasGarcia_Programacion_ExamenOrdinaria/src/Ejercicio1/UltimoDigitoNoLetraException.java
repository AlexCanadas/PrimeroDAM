package Ejercicio1;

public class UltimoDigitoNoLetraException {

	public static void ultimoDigitoDni(String dni) throws IllegalArgumentException {
		// Creamos una variable para leer el último dígito
		char ultimoChar = dni.charAt(8);
		// Comprobamos si el último dígito es una letra
		if (!Character.isLetter(ultimoChar)) {
			// Si no es letra, lanzamos la excepción
			throw new IllegalArgumentException("El último dígito del DNI siempre debe de ser una letra.");
		}
	}
}
