package AlquilerVehiculos;

public class Camiones extends Vehiculos {
	// Constructor vacío
	public Camiones() {
		super();
		precioAlquiler = PRECIOALQUILER;
	}
	
	// Constructor con parámetros
	public Camiones(String _matricula, int _diasAlquiler, double _precioAlquiler, int _plaza) {
		super(_matricula, _diasAlquiler, _precioAlquiler, _plaza);
		precioAlquiler = PRECIOALQUILER;
	}
	
	@Override
	protected void calcularPrecioAlquiler(int _diasAlquiler, int _plaza) {
		double precioFinal = (this.getPrecioAlquiler() * _diasAlquiler) + 40;
		System.out.println("El precio de alquiler de este camión con matrícula " + this.getMatricula() + 
				" es de: " + precioFinal + " euros.\n");

	}
}
