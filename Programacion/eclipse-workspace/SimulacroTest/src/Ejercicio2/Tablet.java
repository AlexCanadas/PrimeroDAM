package Ejercicio2;

public class Tablet extends Producto {

	public Tablet() {
		super();
	}

	public Tablet(String modelo, String marca, double precio, double descuento) {
		super(modelo, marca, precio, descuento);
	}

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

	@Override
	public double calcularPrecioFinal() {
		double precioFinal = precio - (precio * (descuento / 100.0));
		return precioFinal;
	}

	@Override
	public String toString() {
		return "Tablet {\n Modelo: " + modelo + "\n Marca: " + marca + "\n Precio: " + precio + "\n Descuento:"
				+ descuento + "\n Precio Final: " + calcularPrecioFinal() + "} \n";
	}

}
