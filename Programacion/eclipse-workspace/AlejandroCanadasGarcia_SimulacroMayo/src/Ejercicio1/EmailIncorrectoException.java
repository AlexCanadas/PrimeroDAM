package Ejercicio1;

public class EmailIncorrectoException {
	public static void EmailIncorrecto(String email) throws IllegalArgumentException {
		if (!email.contains("@") || !email.contains(".")) {
			throw new IllegalArgumentException("El formato del e-mail no es válido.");
		}
	}
}
