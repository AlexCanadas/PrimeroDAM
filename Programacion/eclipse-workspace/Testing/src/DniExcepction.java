
public class DniExcepction {

	public static void comprobarDni(String dni) throws IllegalArgumentException {
		char ultimoChar = dni.charAt(8);
		if (!Character.isLetter(ultimoChar)) {
			throw new IllegalArgumentException("El DNI tiene que acabar en letra");
		}
	}
}
