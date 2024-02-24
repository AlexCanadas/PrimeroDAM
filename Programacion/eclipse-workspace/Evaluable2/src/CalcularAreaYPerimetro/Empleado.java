package CalcularAreaYPerimetro;

public class Empleado {
	
	  String nombre, dni; 
	  int edad; 
	  boolean casado; 
	  double salario;
	 

	//Creamos constructor con parámetros de entrada
	protected Empleado (String _nombre, String _dni, int _edad, boolean _casado, double _salario) {
	    this.nombre = _nombre;
	    this.dni = _dni;
	    this.edad = _edad;
	    this.casado = _casado;
	    this.salario = _salario;
	}
	
	//Creamos constructor sin parámetros de entrada
	protected Empleado () {
	    
	}
	
	//Creamos getters y setters
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String _nombre) {
		this.nombre = _nombre;
	}
	
	public String getDni() {
		return dni;
	}
	public void setDni(String _dni) {
		this.dni = _dni;
	}
	
	public boolean isCasado() {
		return casado;
	}
	
	public void setCasado(boolean _casado) {
		this.casado = _casado;
	}
	public boolean getCasado() {
		return casado;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public void setEdad(int _edad) {
		if (_edad>=18 && _edad<=45) {
		this.edad = _edad; 
		} else {
			System.out.println("La edad debe estar comprendida entre 18 y 45 años");
		}
	}
	
	public double getSalario() {
		return salario;
	}
	
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	//Creamos método que permita mostrar la clasificación según la edad
	protected void clasificacion(int edad) {
		if (edad<=21) {
			System.out.println("Principiante");
		}
		else if (edad >=22 && edad<=35) {
			System.out.println("Intermedio");
		}
		else {
			System.out.println("Senior");
		}
	}

	@Override
	//toString para imprimir los datos del empleado por pantalla 
	public String toString () {
		return "Nombre: " + this.nombre + ", DNI: " + this.dni + ", Edad: " + 
	this.edad + ", Salario: " + this.salario;
	}

	//Creamos método para aumentar el salario basado en porcentaje (este % será un dato pasado como parámetro al método)
	protected void aumentarSalario (int porcentaje) {
		 double aumento = porcentaje / 100.0; 
		 double nuevoSalario = getSalario()*(1+aumento); 
		 setSalario(nuevoSalario);
	}
}
