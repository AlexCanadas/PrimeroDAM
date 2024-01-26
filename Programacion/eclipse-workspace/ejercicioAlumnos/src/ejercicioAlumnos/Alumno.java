package ejercicioAlumnos;

public class Alumno {
	/*Crea una clase Alumno con el método comprobarDNI. La clase contendrá un constructor por defecto, 
	un constructor con parámetros y los métodos getters y setters.
	
	Crea una clase principal que te permita dar de alta alumnos, dar de baja o modificar sus datos.
	
	La clase principal la trabajaremos en clase, por ahora tenéis que hacer la clase Alumno.*/
		
	String alumno;
	double notaMedia;
	int edad;
	
	
	// Creamos constructor para Alumno
	public Alumno (String alumno) {
		this.alumno=alumno;
	}
	
	// Creamos el constructor con parámetros 
	public Alumno (String alumno, double notaMedia, int edad) {
		this.alumno=alumno;
		this.notaMedia=notaMedia;
		this.edad=edad;
	}

	// Generamos getters y setters 
	public String getAlumno() {
		return alumno;
	}

	public void setAlumno(String alumno) {
		this.alumno = alumno;
	}

	public double getNotaMedia() {
		return notaMedia;
	}

	public void setNotaMedia(double notaMedia) {
		this.notaMedia = notaMedia;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	// Generamos métodos (dar de alta, dar de baja y modificar datos)
	public void alta(String alumno, double notaMedia, int edad) {
		
	}
	
	public void baja (String alumno, double notaMedia, int edad) {
		
	}
	
	public void modificarDatos (String alumno, double notaMedia, int edad) {
		
	}
	
	public String toString() {
		return alumno; //cambiar
		
	}
	
	
	
}

