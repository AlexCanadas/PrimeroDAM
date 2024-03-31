package Biblioteca;

import java.sql.Date;

public class Prestamos {
	boolean isPrestamoActive;
	Date fecha;
	
	public Prestamos(boolean isPrestamoActive, Date fecha) {
		
		this.isPrestamoActive = isPrestamoActive;
		this.fecha = fecha;
	}

	public Prestamos() {
		
	}
	
	
	
}
