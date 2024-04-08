package Biblioteca;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

public class Prestamos {
	private static int contadorPrestamos = 0;
	
	protected LocalDate fechaComienzo;
	protected LocalDate fechaFin;
	String dniUsuario;
	int idPrestamo, pkArticulo;
	double multa;
	
	public Prestamos(LocalDate fechaComienzo, LocalDate fechaFin, String dniUsuario, int pkArticulo) {
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

	public double getMulta() {
		return multa;
	}

	public void setMulta(int multa) {
		this.multa = multa;
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
    	
    	 // Mostramos el ID creado automáticamente y la duración del préstamo
        System.out.println("Préstamo creado con ID: " + nuevoPrestamo.getIdPrestamo());
        System.out.println("Este préstamos tendrá " + ChronoUnit.DAYS.between(fechaComienzo, fechaFin) + " días");
        System.out.println("Tenga en cuenta que de pasarse de la fecha estipulada de entrega tendrá una penalización \n");
        
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
    
    @Override
    public String toString() {
    	long diasRestantes = ChronoUnit.DAYS.between(this.fechaComienzo, this.fechaFin);
        return String.format("Préstamo con ID: %d\n" +
                            "DNI del usuario: %s\n" +
                            "ID del artículo: %d\n" +
                            "Fecha de comienzo del préstamo: %s\n" +
                            "Fecha fin del préstamo: %s\n" +
                            "Cantidad de días para acabar el préstamo: %d\n" +
                            "--------------------------------------------------\n",
                            this.getIdPrestamo(),
                            this.getDniUsuario(),
                            this.getPkArticulo(),
                            this.getFecha(),
                            this.getFechaFin(),
                            diasRestantes);
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
