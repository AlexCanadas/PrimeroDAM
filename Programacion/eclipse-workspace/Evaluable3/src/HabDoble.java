import java.util.ArrayList;
import java.util.Scanner;

public class HabDoble extends Habitaciones {
	
	private int numCamas;
	private boolean tieneTerraza;
	
	Scanner sc = new Scanner (System.in);
	
	public HabDoble(int numHabitacion, double metrosCuadrados, int numCamas,
			boolean tieneTerraza) {
		super(numHabitacion, metrosCuadrados);
		this.numCamas = numCamas;
		this.tieneTerraza = tieneTerraza;
		this.estaDisponible = true;
		this.precioNoche = 70;
	}

	public HabDoble() {
	}

	public int getNumCamas() {
		return numCamas;
	}

	public void setNumCamas(int numCamas) {
		this.numCamas = numCamas;
	}

	public boolean isTieneTerraza() {
		return tieneTerraza;
	}

	public void setTieneTerraza(boolean tieneTerraza) {
		this.tieneTerraza = tieneTerraza;
	}
	

	@Override
	public void altaHabitacion(ArrayList <Habitaciones> h) {
		System.out.println("Introduce el número de habitación: ");
		int numHabitacion = sc.nextInt();
		System.out.println("Introduce los metros cuadrados de la habitación: ");
		double metrosCuadrados = sc.nextDouble();
		System.out.println("Introduce si tiene baño privado (SI O NO: ");
		int numCamas = sc.nextInt();
		System.out.println("Tiene terraza (SI O NO):");
		boolean tieneTerraza = sc.nextBoolean();
		
		HabDoble nuevaHab = new HabDoble(numHabitacion, metrosCuadrados, numCamas, tieneTerraza);
		h.add(nuevaHab);
		nuevaHab.toString();
		
	}

	@Override
	public void bajaHabitacion(ArrayList <Habitaciones> h) {
		System.out.println("Introduce el número de habitación a dar de baja: ");
		int numHab = sc.nextInt();
		for (Habitaciones hab : h) {
			if (hab instanceof HabDoble) {
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
                 "Tiene terraza: %b\n" +
                 "Está disponible actualmente: %b\n" +
                 "Precio por noche: %d\n" +
                 "--------------------------------------------------\n",
                 this.getNumHabitacion(),
                 this.getMetrosCuadrados(),
                 this.getNumCamas(),
                 this.isTieneTerraza(),
                 this.isEstaDisponible(),
                 this.getPrecioNoche());
	}
	
	
	

}
