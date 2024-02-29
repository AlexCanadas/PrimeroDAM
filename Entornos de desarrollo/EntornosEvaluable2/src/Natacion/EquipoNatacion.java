package Natacion;

public class EquipoNatacion {
	private String nombre;
    private String dni;
    private String fecha;
    private int edad;
    private int dorsal;
    private double puntuacion;
    private double dificultad;

    public EquipoNatacion(String _nombre, String _dni, String _fecha, int _edad, int _dorsal, double _puntuacion, double _dificultad) {
        this.nombre = _nombre;
        this.dni = _dni;
        this.fecha = _fecha;
        this.edad = _edad;
        this.dorsal = _dorsal;
        this.puntuacion = _puntuacion;
        this.dificultad = _dificultad;
    }

    public double puntuacionFinal() {
        return puntuacion * dificultad;
    }

    public boolean MayorDeEdad() {
        return edad >= 18; 
    }

	protected String getNombre() {
		return nombre;
	}

	protected void setNombre(String _nombre) {
		this.nombre = _nombre;
	}

	protected String getDni() {
		return dni;
	}

	protected void setDni(String _dni) {
		this.dni = _dni;
	}

	protected String getFecha() {
		return fecha;
	}

	protected void setFecha(String _fecha) {
		this.fecha = _fecha;
	}

	protected int getEdad() {
		return edad;
	}

	protected void setEdad(int _edad) {
		this.edad = _edad;
	}

	protected int getDorsal() {
		return dorsal;
	}

	protected void setDorsal(int _dorsal) {
		this.dorsal = _dorsal;
	}

	protected double getPuntuacion() {
		return puntuacion;
	}

	protected void setPuntuacion(double _puntuacion) {
		this.puntuacion = _puntuacion;
	}

	protected double getValorDificultad() {
		return dificultad;
	}

	protected void setValorDificultad(double _dificultad) {
		this.dificultad = _dificultad;
	}
}

