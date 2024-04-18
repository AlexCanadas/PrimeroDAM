
public class HabDoble extends Habitaciones {
	
	private int numCamas;
	private boolean tieneTerraza;
	
	public HabDoble(boolean estaDisponible, int numHabitacion, int precioNoche, double metrosCuadrados, int numCamas,
			boolean tieneTerraza) {
		super(estaDisponible, numHabitacion, precioNoche, metrosCuadrados);
		this.numCamas = numCamas;
		this.tieneTerraza = tieneTerraza;
	}

	public int getNumCamas() {
		return numCamas;
	}

	public void setNumCamas(int numCamas) {
		this.numCamas = numCamas;
	}

	public boolean isTieneTerraza() {
		return tieneTerraza;
	}

	public void setTieneTerraza(boolean tieneTerraza) {
		this.tieneTerraza = tieneTerraza;
	}
	
	
	

}
