package Ejercicio1;

public class LongitudDNINoValidaException {
	public static void validarDni(String dni) throws IllegalArgumentException {
		if (dni.length() != 9) {
			throw new IllegalArgumentException("La longitud del DNI debe ser de 9 caracteres");
		}
	}

}
