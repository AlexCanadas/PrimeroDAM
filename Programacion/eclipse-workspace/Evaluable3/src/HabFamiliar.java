
public class HabFamiliar extends Habitaciones{

	private int numCamas;
	private int numNiños;
	
	public HabFamiliar(boolean estaDisponible, int numHabitacion, int precioNoche, double metrosCuadrados, int numCamas,
			int numNiños) {
		super(estaDisponible, numHabitacion, precioNoche, metrosCuadrados);
		this.numCamas = numCamas;
		this.numNiños = numNiños;
	}

	public int getNumCamas() {
		return numCamas;
	}

	public void setNumCamas(int numCamas) {
		this.numCamas = numCamas;
	}

	public int getNumNiños() {
		return numNiños;
	}

	public void setNumNiños(int numNiños) {
		this.numNiños = numNiños;
	}

	
	
	
}
