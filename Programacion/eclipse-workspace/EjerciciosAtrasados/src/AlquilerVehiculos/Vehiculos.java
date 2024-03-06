package AlquilerVehiculos;

public class Vehiculos {
String matricula;
int diasAlquiler, plaza;
double precioAlquiler;
final double PRECIOALQUILER = 50;

	// Creamos los getters & setters
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String _matricula) {
		this.matricula = _matricula;
	}
	public int getDiasAlquiler() {
		return diasAlquiler;
	}
	public void setDiasAlquiler(int _diasAlquiler) {
		this.diasAlquiler = _diasAlquiler;
	}
	public int getPlaza() {
		return plaza;
	}
	public void setPlaza(int _plaza) {
		this.plaza = _plaza;
	}
	public double getPrecioAlquiler() {
		return precioAlquiler;
	}
	public void setPrecioAlquiler(double _precioAlquiler) {
		this.precioAlquiler = _precioAlquiler;
	}
	public double getPRECIOALQUILER() {
		return PRECIOALQUILER;
	}
	
	// Creamos constructor vacío
	public Vehiculos() {
	}
	
	// Creamos constructor con parámetros
	public Vehiculos(String _matricula, int _diasAlquiler, double _precioAlquiler, int _plaza) {
		this.matricula = _matricula;
		this.diasAlquiler = _diasAlquiler;
		this.precioAlquiler = _precioAlquiler;
		this.plaza = _plaza;
	}
	
	// Creamos método para calcular el precio final
	protected double calcularPrecioAlquiler (int _diasAlquiler, double _precioAlquiler, int _plaza) {
		double precioAlquiler = PRECIOALQUILER;
		
		return precioAlquiler;
	}


}
