import java.util.Scanner;

public class OrdenProgramando {

	public static void main(String[] args) {
		//Variables y constantes 
		String nombre;
		Scanner NombreScanner = new Scanner(System.in);
		
		//Petición de datos
		System.out.print("Dime tu nombre: ");
		nombre = NombreScanner.next();
		
		//Operaciones
		
		//Mostrar resultados
		System.out.print("Tu nombre es : " + nombre);

	}

}
