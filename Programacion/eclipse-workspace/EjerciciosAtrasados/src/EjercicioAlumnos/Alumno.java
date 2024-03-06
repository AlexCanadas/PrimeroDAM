package EjercicioAlumnos;

import java.util.ArrayList;

public class Alumno {
	String dni, nombre, direccion;
	
	// Creamos constructores con y sin parámetros
	public Alumno(String dni) {
		
		this.dni = dni;
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
	
	// Creamos el método para verificar si existe el DNI
	/*protected boolean existeDNI(String dni, ArrayList<Alumno> registro) {
		for (Alumno a : registro) {
			if (dni.equals(a.getDni())) {
	            System.out.println("El DNI " + dni + " ya está registrado en la base de datos.\n");
	            return true; // El DNI existe en la base de datos
	        }
	    }
	    System.out.println("Este DNI no existe en la base de datos.\n");
	    return false; // El DNI no existe en la base de datos
	}*/
	
	
	
}
