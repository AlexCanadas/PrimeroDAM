
public abstract class Habitaciones {
	private boolean estaDisponible;
	private int numHabitacion;
	private int precioNoche;
	private double metrosCuadrados;
	
	public Habitaciones(boolean estaDisponible, int numHabitacion, int precioNoche, double metrosCuadrados) {
		this.estaDisponible = estaDisponible;
		this.numHabitacion = numHabitacion;
		this.precioNoche = precioNoche;
		this.metrosCuadrados = metrosCuadrados;
	}

	public boolean isEstaDisponible() {
		return estaDisponible;
	}

	public void setEstaDisponible(boolean estaDisponible) {
		this.estaDisponible = estaDisponible;
	}

	public int getNumHabitacion() {
		return numHabitacion;
	}

	public void setNumHabitacion(int numHabitacion) {
		this.numHabitacion = numHabitacion;
	}

	public int getPrecioNoche() {
		return precioNoche;
	}

	public void setPrecioNoche(int precioNoche) {
		this.precioNoche = precioNoche;
	}

	public double getMetrosCuadrados() {
		return metrosCuadrados;
	}

	public void setMetrosCuadrados(double metrosCuadrados) {
		this.metrosCuadrados = metrosCuadrados;
	}

	
	
	
	
	
	
	
}
