package ejercicioAlumnos;

import java.util.Scanner;

public class principal {

	public static void main(String[] args) {
		
		int opcion;
		Scanner sc = new Scanner (System.in);
		String alumno = null;
		String dni = null;
		String edad = null;
		String alumnos[][] = new String[100][3];
		Alumno c1 = new Alumno(alumno);
		
		do {
			mostrarMenu();
			System.out.println("Ingrese que opción desea:");
			opcion = sc.nextInt();
			
			switch (opcion) {
			case 1: 
				System.out.println("Ingrese el DNI del alumno: ");
				dni = sc.next();
				for (int i=0; i<alumnos.length; i++) {
					if (alumnos[i][0]!=dni && alumnos [i][0]==null) {
						c1.alta(alumnos, alumno, edad, sc);
						System.out.println("El alumno " + alumno + " se registró correctamente");
					}
				}
				break;
			case 2: 
				
				break;
			case 3: 
				
				break;
			case 4: 
				
				break;
			default:
				System.out.println("Opción inválida, por favor, inténtelo de nuevo");
				System.out.println("");
			}
		} while (opcion!=4);
		
		sc.close();
	}

	
	public static void mostrarMenu() {
        System.out.println("-- Alumnos --");
        System.out.println("1. Dar de alta");
        System.out.println("2. Dar de baja");
        System.out.println("3. Cambiar detalles de registro");
        System.out.println("4. Salir");
    }
	
	public static void altaAlumno(Alumno[] alumnos, Scanner sc) {
		// rellenar
	}
	
	public static void bajaAlumno(Alumno[] alumnos, Scanner sc) {
		// rellenar
	}
	
	public static void modificarAlumno(Alumno[] alumnos, Scanner sc) {
		// rellenar
	}
	
}
