package Figuras2D;

public class Circulo {
String nombre;
double radio;

//Constructor con parámetros
public Circulo(String nombre, double radio) {
	this.nombre = nombre;
	this.radio = radio;
}

//Getters & Setters
public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public double getRadio() {
	return radio;
}

public void setRadio(double radio) {
	this.radio = radio;
}

//Calculamos perímetro
public double calcularPerimetro() {
    return 2 * Math.PI * radio;
}

public String toString() {
    return "Círculo [nombre=" + nombre + ", radio=" + radio + "]";
}

public boolean equals(Circulo c) {
	boolean iguales = false;
	if (c.getNombre().equals(this.nombre) && c.getRadio() == this.radio){
		iguales = true;
	}
	return iguales;
}

}
