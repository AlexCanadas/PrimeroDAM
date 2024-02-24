package CalcularAreaYPerimetro;

public class Programador extends Empleado {
	int lineasDecCodigoPorHora;
	String lenguajeDominante;

	// Creamos constructor con parámetros de entrada
	public Programador(int lineasDecCodigoPorHora, String lenguajeDominante, String nombre, 
			String dni, int edad, boolean casado, double salario) {
	    super(nombre, dni, edad, casado, salario); // Llama al constructor de la clase base empleado
	    this.lineasDecCodigoPorHora = lineasDecCodigoPorHora;
	    this.lenguajeDominante = lenguajeDominante;
	}
	
	// Creamos constructor sin parámetros de entrada
	public Programador () {
		super();
	}
	
	// Generamos Setters & Getters
	public int getLineasDecCodigoPorHora() {
		return lineasDecCodigoPorHora;
	}
	
	public void setLineasDecCodigoPorHora(int lineasDecCodigoPorHora) {
		this.lineasDecCodigoPorHora = lineasDecCodigoPorHora;
	}
	
	public String getLenguajeDominante() {
		return lenguajeDominante;
	}
	
	public void setLenguajeDominante(String lenguajeDominante) {
		this.lenguajeDominante = lenguajeDominante;
	}
}
