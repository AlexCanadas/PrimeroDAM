package Ejercicio2;

public class Tablet extends Producto {

	// Constructor vacío
	public Tablet() {
		super();
	}

	// Constructor con parámetros que se heredan
	public Tablet(String modelo, String marca, String memoria, double precio, double descuento) {
		super(modelo, marca, memoria, precio, descuento);
	}

	// Método para calcular el precio final
	@Override
	public double calcularPrecioFinal() {
		double descuentoExacto = getPrecio() * (getDescuento() / 100.0);
		double precioFinal = getPrecio() - descuentoExacto;

		return precioFinal;
	}

	// Método para comparar objetos
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

	// Método toString pàra imprimir por pantalla
	@Override
	public String toString() {
		return "\n Tablet \n {modelo: " + modelo + " \n marca: " + marca + " \n memoria: " + memoria + " \n precio: "
				+ precio + "€ \n descuento: " + descuento + "% \n Precio final(): " + calcularPrecioFinal() + "€ }";
	}

}
