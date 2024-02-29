
public class EquipoNatacion {
	private String nombre;
    private String dni;
    private String fecha;
    private int edad;
    private int dorsal;
    private double puntuacion;
    private double valorDificultad;

    public EquipoNatacion(String nombre, String dni, String fecha, int edad, int dorsal, double puntuacion, double valorDificultad) {
        this.nombre = nombre;
        this.dni = dni;
        this.fecha = fecha;
        this.edad = edad;
        this.dorsal = dorsal;
        this.puntuacion = puntuacion;
        this.valorDificultad = valorDificultad;
    }

    public double calcularPuntuacionFinal() {
        return puntuacion * valorDificultad;
    }

    public boolean esMayorDeEdad() {
        return edad >= 18; 
    }

	protected String getNombre() {
		return nombre;
	}

	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}

	protected String getDni() {
		return dni;
	}

	protected void setDni(String dni) {
		this.dni = dni;
	}

	protected String getFecha() {
		return fecha;
	}

	protected void setFecha(String fecha) {
		this.fecha = fecha;
	}

	protected int getEdad() {
		return edad;
	}

	protected void setEdad(int edad) {
		this.edad = edad;
	}

	protected int getDorsal() {
		return dorsal;
	}

	protected void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	protected double getPuntuacion() {
		return puntuacion;
	}

	protected void setPuntuacion(double puntuacion) {
		this.puntuacion = puntuacion;
	}

	protected double getValorDificultad() {
		return valorDificultad;
	}

	protected void setValorDificultad(double valorDificultad) {
		this.valorDificultad = valorDificultad;
	}
}
