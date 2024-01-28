package ejercicioAlumnos;

import java.util.Scanner;

public class Alumno {
	/*Crea una clase Alumno con el método comprobarDNI. La clase contendrá un constructor por defecto, 
	un constructor con parámetros y los métodos getters y setters.
	
	Crea una clase principal que te permita dar de alta alumnos, dar de baja o modificar sus datos.
	
	La clase principal la trabajaremos en clase, por ahora tenéis que hacer la clase Alumno.*/
		
	String alumno;
	String dni;
	int edad;
	
	
	// Creamos constructor para Alumno
	public Alumno (String alumno) {
		this.alumno=alumno;
	}
	
	// Creamos el constructor con parámetros 
	public Alumno (String alumnos[][], String alumno, String dni, int edad) {
		this.alumno=alumno;
		this.dni=dni;
		this.edad=edad;
	}

	// Generamos getters y setters 
	public String getAlumno() {
		return alumno;
	}

	public void setAlumno(String alumno) {
		this.alumno = alumno;
	}

	public String getdni() {
		return dni;
	}

	public void setNotaMedia(String dni) {
		this.dni = dni;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	// Generamos métodos (dar de alta, dar de baja y modificar datos)
	public void alta(String alumnos[][], String alumno, String edad, Scanner sc) {
	      alumnos[0][0]=dni;
	      System.out.print("Ingrese el nombre del alumno: ");
	      alumno = sc.next();
	      alumnos[0][1]=alumno;
	      System.out.print("Ingrese la edad del alumno: ");
	      edad = sc.next();
	      alumnos[0][2]=edad;
	      System.out.println("");
	}
	
	public void baja (String dni, Scanner sc) {
		  System.out.print("Ingrese el DNI del alumno: ");
	      dni = sc.next();
	      System.out.println("");
	}
	
	public void modificarDatos (String alumno, String dni, int edad) {
		
	}
	
	public String toString() {
		return alumno; //cambiar
		
	}
	
	
	
}

