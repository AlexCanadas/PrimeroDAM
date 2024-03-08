package Concesionario;

public class Vehiculos {
	String matricula, color, marca, modelo;

	// Generamos getters & setters
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	// Generamos constructores con y sin parámetros
	public Vehiculos() {
		super();
	}

	public Vehiculos(String matricula, String color, String marca, String modelo) {
		super();
		this.matricula = matricula;
		this.color = color;
		this.marca = marca;
		this.modelo = modelo;
	}
	
	
	
	
	
}
