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
            modificarAlumno(registro, sc, a);
             break;
         case 4:
             System.out.println("¡Que tengas un buen día!");
             break;
         default:
             System.out.println("Opción inválida. Inténtelo de nuevo por favor. /n");
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
	
	public static void mostrarMenuModificar() {
        System.out.println("----- Dato a modificar -----");
        System.out.println("1. Nombre");
        System.out.println("2. Dirección");
        System.out.println("3. Salir");
    }
	
	public static void altaAlumno(ArrayList<Alumno> registro, Scanner sc, Alumno a) {
		// Creamos una nueva instancia de Alumno para poder iterar correctamente
		Alumno nuevoAlumno = new Alumno(); 
		System.out.println("Introduce el DNI del alumno a dar de alta: ");
		String dni = sc.next();
		if (!a.comprobarDNI(dni, registro, nuevoAlumno)) {
			nuevoAlumno.setDni(dni);
			System.out.println("Introduce el nombre del alumno a dar de alta: ");
			String nombre = sc.next();
			nuevoAlumno.setNombre(nombre);
			System.out.println("Introduce la dirección del alumno a dar de alta: ");
			String direccion = sc.next();
			nuevoAlumno.setDireccion(direccion);;
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
	    System.out.println("Introduce el DNI del alumno del que modificar datos: ");
	    String dni = sc.next();
	    boolean encontrado = false; 
	    for (Alumno a1 : registro) {
	        if (a1.getDni().equals(dni)) {
	            encontrado = true;
	            mostrarMenuModificar();
	            int opcion = sc.nextInt();
	            switch (opcion) {
	                case 1:
	                    System.out.println("El nombre actual de este alumno es: " + a1.getNombre());
	                    System.out.println("Introduce el nuevo nombre de este alumno: ");
	                    String nombre = sc.next();
	                    a1.setNombre(nombre);
	                    System.out.println("Aquí te mostramos los datos de este alumno desde ahora. DNI: " + a1.getDni() +
	                            " nombre: " + a1.getNombre() + " y dirección: " + a1.getDireccion() + "\n");
	                    break;
	                case 2:
	                    System.out.println("La dirección actual de este alumno es: " + a1.getDireccion());
	                    System.out.println("Introduce la nueva dirección de este alumno: ");
	                    String direccion = sc.next();
	                    a1.setDireccion(direccion);
	                    System.out.println("Aquí te mostramos los datos de este alumno desde ahora. DNI: " + a1.getDni() +
	                            " nombre: " + a1.getNombre() + " y dirección: " + a1.getDireccion() + "\n");
	                    break;
	                case 3:
	                    System.out.println("¡Que tengas un buen día!");
	                    break;
	                default:
	                    System.out.println("Opción inválida. Inténtelo de nuevo por favor. \n");
	            }
	            break;
	        }
	    }
	    if (!encontrado) {
	        System.out.println("No se encontró ningún alumno con el DNI " + dni + ".\n");
	    }
	}

		
}


