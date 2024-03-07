package AlquilerVehiculos;

import java.util.Scanner;

public class FurgonetasDeCarga extends Vehiculos {
	protected double PMA;
	Scanner sc = new Scanner (System.in);
	
	// Constructor con el parámetro extra
    public FurgonetasDeCarga(double PMA) {
        super();
        this.PMA = PMA;
        precioAlquiler = PRECIOALQUILER;
    }
    // Constructor con parámetros
 	public FurgonetasDeCarga(String _matricula, int _diasAlquiler, double _precioAlquiler, int _plaza) {
 		super(_matricula, _diasAlquiler, _precioAlquiler, _plaza);
 		precioAlquiler = PRECIOALQUILER;
 	}
 	
    // Constructor sin parámetros
    public FurgonetasDeCarga() {
        super();
    }

    // Getter y setter para PMA
    public double getPMA() {
        return PMA;
    }

    public void setPMA(double PMA) {
        this.PMA = PMA;
    }

    @Override
    protected double calcularPrecioAlquiler(int _diasAlquiler, double _precioAlquiler, int _plaza) {
    	System.out.println("Introduce el PMA de esta fugoneta de carga: ");
    	PMA = sc.nextDouble();
        double precioFinal = _diasAlquiler * this.precioAlquiler + (20 * PMA);
        System.out.println("El precio de alquiler de esta furgoneta de carga con matrícula " + this.getMatricula() + 
        		" es de: " + precioFinal + " euros.\n");
        
        return precioFinal;
    }
}
