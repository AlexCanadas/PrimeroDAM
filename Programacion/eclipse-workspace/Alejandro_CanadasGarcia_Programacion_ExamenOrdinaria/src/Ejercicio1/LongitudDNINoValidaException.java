package Ejercicio1;

public class LongitudDNINoValidaException {

	public static void longitudDni(String dni) throws IllegalArgumentException {
		// Comprobamos si el DNI es distinto a 9 dígitos
		if (dni.length() != 9) {
			// Si es distinto a 9 dígitos, lanzamos la excepción
			throw new IllegalArgumentException("La longitud del dni debe ser de 9 caracteres");
		}
	}
}
