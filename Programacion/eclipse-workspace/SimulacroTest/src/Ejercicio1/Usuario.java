package Ejercicio1;

public class Usuario {

	protected String nombre, apellido, contraseña, dni;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Usuario(String nombre, String apellido, String contraseña, String dni) {

		this.nombre = nombre;
		this.apellido = apellido;
		this.contraseña = contraseña;
		this.dni = dni;
	}

	public Usuario() {

	}

	@Override
	public String toString() {
		return "Datos del formulario: \n" + "Nombre: " + nombre + "\n" + "Apellido: " + apellido + "\n" + "Contraseña: "
				+ contraseña + "\n" + "DNI: " + dni;
	}

}
