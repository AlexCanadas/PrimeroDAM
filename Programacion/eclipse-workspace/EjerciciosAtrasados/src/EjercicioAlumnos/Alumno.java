package EjercicioAlumnos;

public class Alumno {
	String dni;

	// Creamos constructores con y sin parámetros
	public Alumno(String dni) {
		super();
		this.dni = dni;
	}
	public Alumno() {
		super();
	}
	
	// Creamos getters y setters
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	// Creamos el método para comprobar el DNI
	protected void comprobarDNI() {
		
	}
	
	
}
