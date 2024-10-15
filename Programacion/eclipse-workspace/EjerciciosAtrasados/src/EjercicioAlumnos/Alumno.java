package EjercicioAlumnos;

import java.util.ArrayList;

public class Alumno {
	String dni, nombre, direccion;
	
	// Creamos constructores con y sin parámetros
	public Alumno(String dni, String nombre, String direccion) {
		this.dni = dni;
		this.nombre = nombre;
		this.direccion = direccion;
	}
	public Alumno() {
		
	}
	
	// Creamos getters y setters
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
	
	// Creamos el método para comprobar el DNI
	protected boolean comprobarDNI(String dni, ArrayList<Alumno> registro, Alumno a1) {
		for (Alumno a : registro) {
			if (dni.equals(a.getDni())) {
                return true;
			}
		}
		return false;
	}
}
