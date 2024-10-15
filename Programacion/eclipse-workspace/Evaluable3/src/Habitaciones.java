import java.util.ArrayList;

public abstract class Habitaciones {
	protected boolean estaDisponible=true;
	private int numHabitacion;
	protected int precioNoche;
	private double metrosCuadrados;
	
	public Habitaciones(int numHabitacion, double metrosCuadrados) {
		this.numHabitacion = numHabitacion;
		this.metrosCuadrados = metrosCuadrados;
		this.estaDisponible = true;
		this.precioNoche = 50;
	}

	public Habitaciones() {
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
	
	
	public abstract void altaHabitacion(ArrayList <Habitaciones> h);

	public abstract void bajaHabitacion(ArrayList <Habitaciones> h);

	public abstract void modificarHabitacion(ArrayList <Habitaciones> h);
	
	public abstract boolean existeNumHab(ArrayList <Habitaciones> h, int numHab);
	
	public abstract String toString();
	
	
}
