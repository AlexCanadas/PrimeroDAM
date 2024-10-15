package Futbol;

public class Futbol {
	String nombre, posicion;
	int edad;
	
	public Futbol(String nombre, String posicion, int edad) {
		this.nombre = nombre;
		this.posicion = posicion;
		this.edad = edad;
	}

	public Futbol() {

	}

	public int getEdad() {
		return edad;
	}
	
	public boolean mayorDeEdad() {
		if(edad<18) {
			return false;
		}
		return true;
	}
	
}
