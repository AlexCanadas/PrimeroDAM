package Concesionario;

import java.util.ArrayList;

public class Venta {
	protected String matricula;
	protected String dni;

	// Creamos el constructor con y sin parámetros
	public Venta(String _matricula, String _dni) {
		this.matricula = _matricula;
		this.dni = _dni;
	}

	public void Venta1(String _matricula, String _dni) {
	}

	// Creamos getters & setters
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
}
