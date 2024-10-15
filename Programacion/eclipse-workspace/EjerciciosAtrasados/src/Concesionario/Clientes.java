package Concesionario;

public class Clientes {
	protected String dni, nombre, direccion;
	protected int edad;
	
	// Generamos getters & setters
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	// Generamos constructores con y sin parámetros
	public Clientes() {
	}
	
	public Clientes(String dni, String nombre, String direccion, int edad) {
		this.dni = dni;
		this.nombre = nombre;
		this.direccion = direccion;
		this.edad = edad;
	}
	
	
	
}
