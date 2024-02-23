package CalcularAreaYPerimetro;

public class programador extends empleado {
int lineasDecCodigoPorHora;
String lenguajeDominante;

//Creamos constructor con parámetros de entrada
protected programador (int lineasDecCodigoPorHora, String lenguajeDominante) {
  this.lineasDecCodigoPorHora = lineasDecCodigoPorHora;
  this.lenguajeDominante = lenguajeDominante;
}

//Creamos constructor sin parámetros de entrada
public programador(int lineasDecCodigoPorHora, String lenguajeDominante, String nombre, 
		String dni, int edad, boolean casado, double salario) {
    super(nombre, dni, edad, casado, salario); // Llama al constructor de la clase base (empleado)
    this.lineasDecCodigoPorHora = lineasDecCodigoPorHora;
    this.lenguajeDominante = lenguajeDominante;
}

public programador () {
	super();
}
//Métodos






}
