package AlquilerVehiculos;

public class Camiones extends Vehiculos {
	@Override
	protected double calcularPrecioAlquiler(int _diasAlquiler, double _precioAlquiler, int _plaza) {
		double precioBase = this.PRECIOALQUILER * 40;
		
		return precioBase ;
	}
}
