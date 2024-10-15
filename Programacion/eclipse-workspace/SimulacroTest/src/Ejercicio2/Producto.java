package Ejercicio2;

import java.util.Objects;

public abstract class Producto {
	String modelo, marca;
	double precio, descuento;

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

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	public Producto() {

	}

	public Producto(String modelo, String marca, double precio, double descuento) {
		this.modelo = modelo;
		this.marca = marca;
		this.precio = precio;
		this.descuento = descuento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descuento, marca, modelo, precio);
	}

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
				&& Objects.equals(marca, other.marca) && Objects.equals(modelo, other.modelo)
				&& Double.doubleToLongBits(precio) == Double.doubleToLongBits(other.precio);
	}

	public abstract double calcularPrecioFinal();

	@Override
	public String toString() {
		return "Producto {\n Modelo: " + modelo + "\n Marca: " + marca + "\n Precio: " + precio + "\n Descuento:"
				+ descuento + "\n Precio Final: " + calcularPrecioFinal() + "} \n";
	}

}
