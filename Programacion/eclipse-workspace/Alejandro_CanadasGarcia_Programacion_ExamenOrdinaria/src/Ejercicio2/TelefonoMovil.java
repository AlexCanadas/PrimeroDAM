package Ejercicio2;

public class TelefonoMovil extends Producto {

	// Constructor vacío
	public TelefonoMovil() {
		super();
	}

	// Constructor con parámetros que se heredan
	public TelefonoMovil(String modelo, String marca, String memoria, double precio, double descuento) {
		super(modelo, marca, memoria, precio, descuento);
	}

	// Método pàra calcular precio final
	@Override
	public double calcularPrecioFinal() {
		double descuentoExacto = getPrecio() * (getDescuento() / 100.0);
		double precioFinal = getPrecio() - descuentoExacto;

		return precioFinal;
	}

	// Método equals para comparar objetos
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

	// Método toString para imrpimir por pantalla
	@Override
	public String toString() {
		return "\n Telefono Movil \n {modelo: " + modelo + " \n marca: " + marca + " \n memoria: " + memoria
				+ " \n precio: " + precio + "€ \n descuento: " + descuento + "% \n Precio final: "
				+ calcularPrecioFinal() + "€ }";
	}

}
