package Ejercicio2;

import java.util.Objects;

public abstract class Producto {
	// Declaramos las variables comunes que heredarán las subclases
	protected String modelo, marca, memoria;
	double precio, descuento;

	// Constructor vacío
	public Producto() {

	}

	// Constructor con todos los parámetros
	public Producto(String modelo, String marca, String memoria, double precio, double descuento) {
		this.modelo = modelo;
		this.marca = marca;
		this.memoria = memoria;
		this.precio = precio;
		this.descuento = descuento;
	}

	// Getters y Setters
	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getMemoria() {
		return memoria;
	}

	public void setMemoria(String memoria) {
		this.memoria = memoria;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	// Método equals para comparar objetos
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Double.doubleToLongBits(descuento) == Double.doubleToLongBits(other.descuento)
				&& Objects.equals(marca, other.marca) && Objects.equals(memoria, other.memoria)
				&& Objects.equals(modelo, other.modelo)
				&& Double.doubleToLongBits(precio) == Double.doubleToLongBits(other.precio);
	}

	// Método toString para imprimir por pantalla
	@Override
	public String toString() {
		return "\\n Producto \\n {modelo: " + modelo + " \\n marca: " + marca + " \\n memoria: " + memoria
				+ " \\n precio: " + precio + "}";
	}

	// Método abstracto para calcular el precio final después del descuento aplicado
	public abstract double calcularPrecioFinal();

}
