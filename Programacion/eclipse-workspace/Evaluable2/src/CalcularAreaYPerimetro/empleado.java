package CalcularAreaYPerimetro;

public class empleado {
String nombre, dni;
int edad;
boolean casado;
double salario;

//Creamos constructor con parámetros de entrada
protected empleado (String _nombre, String _dni, int _edad, double _salario) {
    this.nombre = _nombre;
    this.dni = _dni;
    this.edad = _edad;
    this.salario = _salario;
}

//Creamos constructor sin parámetros de entrada
protected empleado () {
    
}

//Creamos getters y setters
public String getNombre() {
	return nombre;
}

public void setNombre(String _nombre) {
	this.nombre = _nombre;
}

public String getDni() {
	return dni;
}

public boolean isCasado() {
	return casado;
}

public void setCasado(boolean _casado) {
	this.casado = _casado;
}

public void setDni(String _dni) {
	this.dni = _dni;
}

public int getEdad() {
	return edad;
}

public void setEdad(int _edad) {
	if (edad>=18 && edad<=45) {
	this.edad = _edad; 
	} else {
		System.out.println("La edad debe estar comprendida entre 18 y 45 años");
	}
}

public double getSalario() {
	return salario;
}

public void setSalario(double salario) {
	this.salario = salario;
}

//Creamos método que permita mostrar la clasificación según la edad





//toString para imprimir los datos del empleado por pantalla 




//Creamos método para aumentar el salario basado en porcentaje (este % será un dato pasado como parámetro al método)










}
