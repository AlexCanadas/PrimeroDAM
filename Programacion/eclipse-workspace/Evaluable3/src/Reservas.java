import java.time.LocalDate;

public class Reservas {
	private LocalDate fechaComienzo;
	private int numHabitacion; 
	private String aliasCliente;
	private int duracionNoches;
	private int nochesReserva;
	
	public Reservas(LocalDate fechaComienzo, int numHabitacion, String aliasCliente, int duracionNoches,
			int nochesReserva) {
		this.fechaComienzo = fechaComienzo;
		this.numHabitacion = numHabitacion;
		this.aliasCliente = aliasCliente;
		this.duracionNoches = duracionNoches;
		this.nochesReserva = nochesReserva;
	}

	public LocalDate getFechaComienzo() {
		return fechaComienzo;
	}

	public void setFechaComienzo(LocalDate fechaComienzo) {
		this.fechaComienzo = fechaComienzo;
	}

	public int getNumHabitacion() {
		return numHabitacion;
	}

	public void setNumHabitacion(int numHabitacion) {
		this.numHabitacion = numHabitacion;
	}

	public String getAliasCliente() {
		return aliasCliente;
	}

	public void setAliasCliente(String aliasCliente) {
		this.aliasCliente = aliasCliente;
	}

	public int getDuracionNoches() {
		return duracionNoches;
	}

	public void setDuracionNoches(int duracionNoches) {
		this.duracionNoches = duracionNoches;
	}

	public int getNochesReserva() {
		return nochesReserva;
	}

	public void setNochesReserva(int nochesReserva) {
		this.nochesReserva = nochesReserva;
	}
	
    
    
}
