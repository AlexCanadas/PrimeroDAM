import java.util.ArrayList;
import java.util.Scanner;

public class HabIndividual extends Habitaciones {
	private boolean bañoPrivado;
	
	Scanner sc = new Scanner (System.in);
	
	public HabIndividual(int numHabitacion, double metrosCuadrados,
			boolean bañoPrivado) {
		super(numHabitacion, metrosCuadrados);
		this.bañoPrivado = bañoPrivado;
		this.estaDisponible = true;
		this.precioNoche = 50;
	}

	public HabIndividual() {
		
	}

	public boolean isBañoPrivado() {
		return bañoPrivado;
	}

	public void setBañoPrivado(boolean bañoPrivado) {
		this.bañoPrivado = bañoPrivado;
	}


	@Override
	public void altaHabitacion(ArrayList <Habitaciones> h) {
		System.out.println("Introduce el número de habitación: ");
		int numHabitacion = sc.nextInt();
		System.out.println("Introduce los metros cuadrados de la habitación: ");
		double metrosCuadrados = sc.nextDouble();
		System.out.println("Introduce si tiene baño privado (SI O NO: ");
		boolean bañoPrivado = sc.nextBoolean();
		
		HabIndividual nuevaHab = new HabIndividual(numHabitacion, metrosCuadrados, bañoPrivado);
		h.add(nuevaHab);
		nuevaHab.toString();
	}

	@Override
	public void bajaHabitacion(ArrayList <Habitaciones> h) {
		System.out.println("Introduce el número de habitación a dar de baja: ");
		int numHab = sc.nextInt();
		for (Habitaciones hab : h) {
			if (hab instanceof HabIndividual) {
				if (hab.getNumHabitacion()== numHab) {
					System.out.println("Habitación dada de baja correctamente el número de habitación " + hab.getNumHabitacion() + " \n");
					h.remove(hab);
					return;
				}
			}
		}
		System.out.println("No se encuentra el número de habitación " + numHab + " en el sistema \n");
		
	}

	@Override
	public void modificarHabitacion(ArrayList <Habitaciones> h) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		
        return String.format("Número de habitación: %d\n" +
                            "Metros cuadrados: %f\n" +
                            "Tiene baño privado: %b\n" +
                            "Está disponible actualmente: %b\n" +
                            "Precio por noche: %d\n" +
                            "--------------------------------------------------\n",
                            this.getNumHabitacion(),
                            this.getMetrosCuadrados(),
                            this.isBañoPrivado(),
                            this.isEstaDisponible(),
                            this.getPrecioNoche());
                            
	}

	
	
	
	
	
	
}
