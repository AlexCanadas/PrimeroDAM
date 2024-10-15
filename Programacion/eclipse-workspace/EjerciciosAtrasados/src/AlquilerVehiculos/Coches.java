package AlquilerVehiculos;

public class Coches extends Vehiculos {

	// Constructor vacío
	public Coches() {
		super();
		precioAlquiler = PRECIOALQUILER;
	}
	
	// Constructor con parámetros
	public Coches(String _matricula, int _diasAlquiler, double _precioAlquiler, int _plaza) {
		super(_matricula, _diasAlquiler, _precioAlquiler, _plaza);
	}

	@Override
	protected void calcularPrecioAlquiler(int _diasAlquiler, int _plaza) {
		// Calcular el precio adicional por plaza y día para coches
		double precioAdicionalPlaza = 1.5 * _plaza * _diasAlquiler;
		// Calcular el precio total sumando el precio base y el precio adicional por plaza y día
		double precioFinal = (this.getPrecioAlquiler() * _diasAlquiler) + precioAdicionalPlaza;
		System.out.println("El precio de alquiler de este coche con matrícula " + this.getMatricula() + 
				" es de: " + precioFinal + " euros.\n");

	}
}
