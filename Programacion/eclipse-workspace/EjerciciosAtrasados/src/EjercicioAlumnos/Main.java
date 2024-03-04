package EjercicioAlumnos;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		/*
		 * Crea una clase Alumno con el método comprobarDNI. La clase contendrá un
		 * constructor por defecto, un constructor con parámetros y los métodos getters
		 * y setters.
		 * Crea una clase principal que te permita dar de alta alumnos, dar de baja o
		 * modificar sus datos.
		 */
		Scanner sc = new Scanner(System.in);
		int opcion;
	
	do {
		mostrarMenu();
		System.out.println("Selecciona la opción que deseas realizar:");
		opcion = sc.nextInt();
		
		 switch (opcion) {
         case 1:
             
             break;
         case 2:
             
             break;
         case 3:
            
             break;
         case 4:
             System.out.println("¡Que tengas un buen día!");
             break;
         default:
             System.out.println("Opción inválida. Inténtelo de nuevo por favor.");
             System.out.println("");
     }
	
	}while(opcion!=4);

	}
	
	public static void mostrarMenu() {
        System.out.println("----- Administración de alumnos -----");
        System.out.println("1. Dar de alta a un alumno");
        System.out.println("2. Dar de baja a un alumno");
        System.out.println("3. Modificar datos de un alumno");
        System.out.println("4. Salir");
    }

}
