package Ejercicio1;

public class LongitudDNINoValidaException {
	public static void comprobarLongitudDni(String dni) throws IllegalArgumentException {
		if (dni.length() != 9) {
			throw new IllegalArgumentException("El DNI debe tener 9 caracteres \n");
		}
	}
}
