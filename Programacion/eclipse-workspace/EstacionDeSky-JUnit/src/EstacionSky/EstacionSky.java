package EstacionSky;

public class EstacionSky {
	int pistas, esquiadores, precioForfait;
	String nombreEstacion;
	
	
	public EstacionSky(int pistas, int esquiadores, String nombreEstacion) {
		this.pistas = pistas;
		this.esquiadores = esquiadores;
		this.nombreEstacion = nombreEstacion;
		precioForfait = 50;
	}

	public EstacionSky(int esquiadores) {
		this.esquiadores = esquiadores;
		precioForfait = 50;
	}

	public EstacionSky() {
		precioForfait = 50;
	}
	
	
	
	public int getPistas() {
		return pistas;
	}

	public void setPistas(int pistas) {
		this.pistas = pistas;
	}

	public int getEsquiadores() {
		return esquiadores;
	}

	public void setEsquiadores(int esquiadores) {
		this.esquiadores = esquiadores;
	}

	public int getPrecioForfait() {
		return precioForfait;
	}

	public void setPrecioForfait(int precioForfait) {
		this.precioForfait = precioForfait;
	}

	public String getNombreEstacion() {
		return nombreEstacion;
	}

	public void setNombreEstacion(String nombreEstacion) {
		this.nombreEstacion = nombreEstacion;
	}

	public double calcularProfit() {
		double profit = esquiadores * precioForfait;
		return profit;
	}
	
	
	
}
