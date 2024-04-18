import java.util.ArrayList;
import java.util.Scanner;

public class HabFamiliar extends Habitaciones{

	private int numCamas;
	private int numNiños;
	
	Scanner sc = new Scanner(System.in);
	
	public HabFamiliar(int numHabitacion, double metrosCuadrados, int numCamas,
			int numNiños) {
		super(numHabitacion, metrosCuadrados);
		this.numCamas = numCamas;
		this.numNiños = numNiños;
		this.estaDisponible = true;
		this.precioNoche = 80;
	}

	public HabFamiliar() {
	}

	public int getNumCamas() {
		return numCamas;
	}

	public void setNumCamas(int numCamas) {
		this.numCamas = numCamas;
	}

	public int getNumNiños() {
		return numNiños;
	}

	public void setNumNiños(int numNiños) {
		this.numNiños = numNiños;
	}


	@Override
	public void altaHabitacion(ArrayList <Habitaciones> h) {
		System.out.println("Introduce el número de habitación: ");
		int numHabitacion = sc.nextInt();
		System.out.println("Introduce los metros cuadrados de la habitación: ");
		double metrosCuadrados = sc.nextDouble();
		System.out.println("Introduce si tiene baño privado (SI O NO: ");
		int numCamas = sc.nextInt();
		System.out.println("Introduce el número de niños que dormirán en la habitación: ");
		int numNiños = sc.nextInt();
		
		HabFamiliar nuevaHab = new HabFamiliar(numHabitacion, metrosCuadrados, numCamas, numNiños);
		h.add(nuevaHab);
		nuevaHab.toString();
		
	}

	@Override
	public void bajaHabitacion(ArrayList <Habitaciones> h) {
		System.out.println("Introduce el número de habitación a dar de baja: ");
		int numHab = sc.nextInt();
		for (Habitaciones hab : h) {
			if (hab instanceof HabFamiliar) {
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
                "Número de camas: %d\n" +
                "Número de niños: %d\n" +
                "Está disponible actualmente: %b\n" +
                "Precio por noche: %d\n" +
                "--------------------------------------------------\n",
                this.getNumHabitacion(),
                this.getMetrosCuadrados(),
                this.getNumCamas(),
                this.getNumNiños(),
                this.isEstaDisponible(),
                this.getPrecioNoche());
		

	}

	
	
	
}
