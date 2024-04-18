
public class HabIndividual extends Habitaciones {
	private String tipoCama;
	private boolean bañoPrivado;
	
	public HabIndividual(boolean estaDisponible, int numHabitacion, int precioNoche, double metrosCuadrados,
			String tipoCama, boolean bañoPrivado) {
		super(estaDisponible, numHabitacion, precioNoche, metrosCuadrados);
		this.tipoCama = tipoCama;
		this.bañoPrivado = bañoPrivado;
	}

	public String getTipoCama() {
		return tipoCama;
	}

	public void setTipoCama(String tipoCama) {
		this.tipoCama = tipoCama;
	}

	public boolean isBañoPrivado() {
		return bañoPrivado;
	}

	public void setBañoPrivado(boolean bañoPrivado) {
		this.bañoPrivado = bañoPrivado;
	}
	
	
	
	
	
}
