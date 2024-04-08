package Biblioteca;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Prestamos {
	private static int contadorPrestamos = 0;
	
	//boolean isPrestamoActive; // Cambiamos true/false al registrar prestamos
	protected LocalDate fechaComienzo;
	protected LocalDate fechaFin;
	String dniUsuario;
	int idPrestamo, pkArticulo;
	
	public Prestamos(LocalDate fechaComienzo, LocalDate fechaFin, String dniUsuario, int pkArticulo) {
		this.idPrestamo = ++contadorPrestamos; // Asignar ID único al nuevo préstamo
		
		if (fechaComienzo != null) {
			this.fechaComienzo = fechaComienzo;
		}else {
			this.fechaComienzo = LocalDate.now();
		}
		this.fechaFin = fechaFin;
		this.fechaFin = LocalDate.now();
		this.dniUsuario = dniUsuario;
		this.pkArticulo = pkArticulo;
	}

	public Prestamos() {
	}

	public int getIdPrestamo() {
		return idPrestamo;
	}

	public void setIdPrestamo(int idPrestamo) {
		this.idPrestamo = idPrestamo;
	}

	public String getDniUsuario() {
		return dniUsuario;
	}

	public void setDniUsuario(String dniUsuario) {
		this.dniUsuario = dniUsuario;
	}

	public int getPkArticulo() {
		return pkArticulo;
	}

	public void setPkArticulo(int pkArticulo) {
		this.pkArticulo = pkArticulo;
	}

	/*
	 * public boolean isPrestamoActive() { return isPrestamoActive; }
	 * 
	 * public void setPrestamoActive(boolean prestamoActive) { isPrestamoActive =
	 * prestamoActive; }
	 */

    public LocalDate getFecha() {
        return fechaComienzo;
    }

    public void setFecha(LocalDate fechaComienzo) {
        this.fechaComienzo = fechaComienzo;
    }
	
    public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	protected Prestamos hacerPrestamo (Scanner sc, String dni) {
    	System.out.println("Introduce el ID del árticulo para realizar el préstamo: ");
    	int idArticulo = sc.nextInt();
    	System.out.println("¿Quieres empezar el préstamo hoy?");
    	System.out.println("Si = S || NO = N");
    	char respuesta = Character.toUpperCase(sc.next().charAt(0));
    	LocalDate fechaComienzo = LocalDate.now();
    	if (respuesta == 'N') {
    		System.out.println("Introdue la fecha de comienzo del préstamo (dd-MM-yyyy): ");
    		String inputFecha = sc.next();
            fechaComienzo = LocalDate.parse(inputFecha, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    	}
    	System.out.println("¿En qué fecha quieres acabar el préstamo y devolver el artículo (dd-MM-yyyy)?: ");
    	String fechaFinIntroducida = sc.next();
        fechaFin = LocalDate.parse(fechaFinIntroducida, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        
    	Prestamos nuevoPrestamo = new Prestamos(fechaComienzo, fechaFin, dni, idArticulo);
    	
    	 // Mostrar el ID del préstamo creado
        System.out.println("Préstamo creado con ID: " + nuevoPrestamo.getIdPrestamo());
        
    	return nuevoPrestamo;
    }
    
    protected void hacerDevolucion(Scanner sc, ArrayList <Prestamos> prestamos) {
    	System.out.println("Introduce el ID del artículo que quieres devolver: ");
		int articulo = sc.nextInt();
		for (Prestamos p : prestamos) {
			if (p.getPkArticulo() == articulo) {
				prestamos.remove(p);
			}
		}
    }
    
    public String toString(Prestamos p) {
		return String.format("Préstamo con ID: " +p.getIdPrestamo() + 
								"Dni del usuario: " +p.getDniUsuario() + 
								"ID del artículo: " +p.getPkArticulo() + 
								"Fecha de comienzo del préstamo: " + p.getFecha() + 
								"Fecha fin del préstamo: " +p.getFechaFin() +
								"Cantidad de días para acabar el préstamo: " +p.calcularDiasRestantes(fechaFin) + 
							"--------------------------------------------------\n" );
    	
    }
    
 // Método para calcular los días restantes hasta una fecha específica
    public static long calcularDiasRestantes(LocalDate fechaDevolucion) {
        LocalDate fechaActual = LocalDate.now();
        return fechaActual.until(fechaDevolucion).getDays();
    }
    
}
