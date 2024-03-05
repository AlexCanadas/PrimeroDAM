package EjercicioAlumnos;

import java.util.ArrayList;
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
		ArrayList<Alumno> registro = new ArrayList();
		Alumno a = new Alumno();
	
	do {
		mostrarMenu();
		System.out.println("Selecciona la opción que deseas realizar:");
		opcion = sc.nextInt();
		
		 switch (opcion) {
         case 1:
             altaAlumno(registro, sc, a);
             break;
         case 2:
             bajaAlumno(registro, sc, a);
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
	
	public static void altaAlumno(ArrayList<Alumno> registro, Scanner sc, Alumno a) {
		// rellenar
		Alumno nuevoAlumno = new Alumno(); // Crear una nueva instancia de Alumno
		System.out.println("Introduce el DNI del alumno a dar de alta: ");
		String dni = sc.next();
		if (!a.comprobarDNI(dni, registro, nuevoAlumno)) {
			nuevoAlumno.setDni(dni);
	        registro.add(nuevoAlumno);
	        System.out.println("El alumno con DNI " + nuevoAlumno.getDni() + " ha sido registrado correctamente.\n");
	    } else {
	        System.out.println("El alumno con DNI " + dni + " ya está registrado en la base de datos.\n");
	    }
	}
	
	public static void bajaAlumno(ArrayList<Alumno> registro, Scanner sc, Alumno a) {
		System.out.println("Introduce el DNI del alumno a dar de baja: ");
		String dni = sc.next();
	    a.setDni(dni);
	    for (Alumno a1 : registro) {
	        if (a1.equals(a)) {
	            registro.remove(a1);
	            System.out.println("El alumno con DNI " + dni + " ha sido eliminado correctamente.\n");
	            return;
	        }
	    }
	    System.out.println("No se encontró ningún alumno con el DNI " + dni + ".\n");
	}
	
	public static void modificarAlumno(ArrayList<Alumno> registro, Scanner sc, Alumno a) {
		// rellenar
	}

}
