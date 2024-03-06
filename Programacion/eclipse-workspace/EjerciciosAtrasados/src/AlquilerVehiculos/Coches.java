package AlquilerVehiculos;

public class Coches extends Vehiculos {

	@Override
	protected double calcularPrecioAlquiler(int _diasAlquiler, double _precioAlquiler, int _plaza) {
		double precioBase = this.getDiasAlquiler() * this.getPRECIOALQUILER();
		double precioPlaza = 1.5 * this.getPlaza() * this.getDiasAlquiler();
		
		return precioBase * precioPlaza;
	}
}
