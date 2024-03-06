package AlquilerVehiculos;

public class Microbuses extends Vehiculos {

	@Override
	protected double calcularPrecioAlquiler(int _diasAlquiler, double _precioAlquiler, int _plaza) {
		double PMA = 0;
		double precioFinal = (this.PRECIOALQUILER + 20) * PMA;
		
		return precioFinal;
	}
	
}
