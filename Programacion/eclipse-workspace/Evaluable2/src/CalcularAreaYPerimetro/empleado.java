package CalcularAreaYPerimetro;

public class empleado {
String nombre, dni;
int edad;
boolean casado;

//Creamos constructor con parámetros de entrada
protected empleado (String nombre, String dni, int edad, double salario) {
    this.nombre = nombre;
    this.dni = dni;
    this.edad = edad;
    this.salario = salario;
}

//Creamos constructor sin parámetros de entrada
protected empleado () {
    
}

//Creamos getters y setters
public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getDni() {
	return dni;
}

public boolean isCasado() {
	return casado;
}

public void setCasado(boolean casado) {
	this.casado = casado;
}

double salario;

public void setDni(String dni) {
	this.dni = dni;
}

public int getEdad() {
	return edad;
}

public void setEdad(int edad) {
	if (edad>=18 && edad<=45) {
	this.edad = edad; 
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






//toString




//Creamos método para aumentar el salario basado en porcentaje










}
