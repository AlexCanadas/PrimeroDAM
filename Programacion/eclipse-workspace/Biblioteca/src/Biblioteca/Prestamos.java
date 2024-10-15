package Biblioteca;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Prestamos {
	private static int contadorPrestamos = 0;
	
	protected LocalDate fechaComienzo, fechaFin, fechaSiguientePrestamo ;
	protected String dniUsuario;
	protected int idPrestamo, pkArticulo;
	protected double multa;
	protected boolean isActive;
	
	public Prestamos(LocalDate fechaComienzo, LocalDate fechaFin, String dniUsuario, int pkArticulo, boolean isActive) {
		this.idPrestamo = ++contadorPrestamos; // Creamos ID del préstamo automáticamente
		
		if (fechaComienzo != null) {
			this.fechaComienzo = fechaComienzo;
		}else {
			this.fechaComienzo = LocalDate.now();
		}
		this.fechaFin = fechaFin;
		this.fechaFin = LocalDate.now();
		this.dniUsuario = dniUsuario;
		this.pkArticulo = pkArticulo;
		this.isActive = true; // Ponemos en true el préstamo al crearse
		this.fechaSiguientePrestamo = null; // Iniciamos como null
		
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
	
	public LocalDate getFechaSiguientePrestamo() {
		return fechaSiguientePrestamo;
	}

	public void setFechaSiguientePrestamo(LocalDate fechaSiguientePrestamo) {
		this.fechaSiguientePrestamo = fechaSiguientePrestamo;
	}

	public double getMulta() {
		return multa;
	}

	public void setMulta(int multa) {
		this.multa = multa;
	}
	
	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	protected Prestamos hacerPrestamo (Scanner sc, String dni) {
		// Primero verificamos si hay una restricción de fecha para el próximo préstamo y la actualizamos si es necesario
	    if (this.fechaSiguientePrestamo != null) {
	        LocalDate fechaActual = LocalDate.now();
	        if (fechaActual.isBefore(this.fechaSiguientePrestamo)) {
	            System.out.println("No puedes hacer otro préstamo hasta después de: " + this.fechaSiguientePrestamo);
	            return null; // Devolver null indicando que no se puede hacer el préstamo
	        } 
	    }
		// Hacemos el préstamo
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
    	}else {
            fechaComienzo = LocalDate.now();
        }
    	System.out.println("¿En qué fecha quieres acabar el préstamo y devolver el artículo (dd-MM-yyyy)?: ");
    	String fechaFinIntroducida = sc.next();
        fechaFin = LocalDate.parse(fechaFinIntroducida, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        
        boolean isActive = true; // Marcamos el préstamo como activo
        this.fechaSiguientePrestamo = fechaFin.plusDays(7); // Ponemos 7 dias de restricción para el siguiente préstamo
        
    	Prestamos nuevoPrestamo = new Prestamos(fechaComienzo, fechaFin, dni, idArticulo, isActive);
    	
    	 // Mostramos el ID creado automáticamente y la duración del préstamo
        System.out.println("Préstamo creado con ID: " + nuevoPrestamo.getIdPrestamo());
        System.out.println("Este préstamos tendrá " + ChronoUnit.DAYS.between(fechaComienzo, fechaFin) + " días");
        System.out.println("Tenga en cuenta que de pasarse de la fecha estipulada de entrega tendrá una penalización \n");
        
    	return nuevoPrestamo;
    }
    
	protected void hacerDevolucion(Scanner sc, ArrayList<Prestamos>prestamos) {
	    System.out.println("Introduce el ID del artículo que quieres devolver: ");
	    int articulo = sc.nextInt();
	    
	    Iterator<Prestamos> iterator = prestamos.iterator();
	    while (iterator.hasNext()) {
	        Prestamos p = iterator.next();
	        if (p.getPkArticulo() == articulo) {
	            p.setActive(false);
	            iterator.remove(); // Eliminamos el préstamo
	            System.out.println("Devolución realizada con éxito.");
	            return;
	        }
	    }
	    
	    System.out.println("No se encontró ningún préstamo con el ID de artículo especificado.");
	}
    
    @Override
    public String toString() {
    	long diasRestantes = ChronoUnit.DAYS.between(fechaComienzo, fechaFin);
        return String.format("Préstamo con ID: %d\n" +
                            "DNI del usuario: %s\n" +
                            "ID del artículo: %d\n" +
                            "Fecha de comienzo del préstamo: %s\n" +
                            "Fecha fin del préstamo: %s\n" +
                            "El préstamo está activo: %b\n" +
                            "--------------------------------------------------\n",
                            this.getIdPrestamo(),
                            this.getDniUsuario(),
                            this.getPkArticulo(),
                            this.getFecha(),
                            this.getFechaFin(),
                            this.isActive());
    }
    
    // Método para calcular los días restantes hasta una fecha específica
    public static long calcularDiasRestantes(LocalDate fechaDevolucion) {
        LocalDate fechaActual = LocalDate.now();
        return ChronoUnit.DAYS.between(fechaActual, fechaDevolucion);
    }
    
    // Penalizamos con un 10% por día en caso de entregar tarde
    protected void penalizar (Scanner sc) {
    	System.out.println("Introduce la fecha en la que se produjo la devolución del artículo (dd-MM-yyyy): ");
    	String inputFecha = sc.next();
        LocalDate fechaDevolucion = LocalDate.parse(inputFecha, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    	if (fechaDevolucion.isAfter(fechaFin)) {
    		long diasRetraso = ChronoUnit.DAYS.between(this.fechaFin, LocalDate.now());
    		double porcentajeMultaPorDia = 0.10;
    		this.multa = diasRetraso * porcentajeMultaPorDia;
    		System.out.println("Al precio final del préstamo se le aplicará un " + this.multa + "% \n");
    	}else {
    		this.multa = 0;
    		System.out.println("El artículo de este préstamo se entrego a tiempo por lo que este préstamo no tendrá penalización");
    	}
    }
    
}
