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
}
