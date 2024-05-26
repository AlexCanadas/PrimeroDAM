package Ejercicio1;

public class Usuario {
	// Atributos
	protected String nombre, apellidos, dni;

	// Constructor vacío
	protected Usuario() {
	}

	// Constructor con parámetros
	protected Usuario(String nombre, String apellidos, String dni) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
	}

	// Getters & Setters
	protected String getNombre() {
		return nombre;
	}

	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}

	protected String getApellidos() {
		return apellidos;
	}

	protected void setApellido(String apellido) {
		this.apellidos = apellido;
	}

	protected String getDni() {
		return dni;
	}

	protected void setDni(String dni) {
		this.dni = dni;
	}

	// Creamos un toString para imprimior todos los datos por pantalla
	public String toString() {
		return "Datos del formulario:\n" + "Nombre: " + nombre + "\n" + "Apellidos: " + apellidos + "\n" + "DNI: " + dni
				+ "\n";
	}

}
