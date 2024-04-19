import java.time.LocalDate;

public class Reservas {
	private LocalDate fechaComienzo;
	private int numHabitacion; 
	private String aliasCliente;
	private int nochesReserva;
	protected boolean reservaActiva;
	
	public Reservas(LocalDate fechaComienzo, int numHabitacion, String aliasCliente, 
			int nochesReserva) {
		this.fechaComienzo = fechaComienzo;
		this.numHabitacion = numHabitacion;
		this.aliasCliente = aliasCliente;
		this.nochesReserva = nochesReserva;
		this.reservaActiva = true;
	}

	public Reservas() {

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

	public int getNochesReserva() {
		return nochesReserva;
	}

	public void setNochesReserva(int nochesReserva) {
		this.nochesReserva = nochesReserva;
	}
	
	public boolean isReservaActiva() {
		return reservaActiva;
	}

	public void setReservaActiva(boolean reservaActiva) {
		this.reservaActiva = reservaActiva;
	}
	
    public String toString() {
		return String.format("Alias de cliente: %s\n" +
				"Número de habitación: %d\n" +
				"Fecha comienzo: %s\n" +
				"Noches reservadas: %d\n" +
				"Reserva Activa: %b\n" +
				"--------------------------------------------------\n",
				this.getAliasCliente(),
				this.getNumHabitacion(),
				this.getFechaComienzo(),
				this.getNochesReserva(),
				this.isReservaActiva());
    }
    
}
