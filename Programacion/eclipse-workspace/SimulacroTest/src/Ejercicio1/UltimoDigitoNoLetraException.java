package Ejercicio1;

public class UltimoDigitoNoLetraException {
	public static void comprobarUltimoDigito(String dni) throws IllegalArgumentException {
		char ultimoChar = dni.charAt(8);
		if (!Character.isLetter(ultimoChar)) {
			throw new IllegalArgumentException("El último dígito debe ser una letra \n");
		}
	}
}
