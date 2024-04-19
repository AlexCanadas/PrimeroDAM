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
		int opcion;
		System.out.println("Indica que número de habitación quieres modificar: ");
		int numHab = sc.nextInt();
		
		for (Habitaciones modHab : h) {
			if (modHab instanceof HabDoble) {
				if (modHab.getNumHabitacion()==numHab) {
					System.out.println("Indica que dato quieres modificar de la habitacion: ");
					do {
						System.out.println("1. Número de habitación");
						System.out.println("2. Metros cuadrados");
						System.out.println("3. Cambiar el número de camas");	
						System.out.println("4. Cambiar si tiene terraza o no");
						System.out.println("5. Salir");
						opcion = sc.nextInt();
		
						switch(opcion) {
						case 1: 
							System.out.println("Introduce cual será el nuevo número de habitación: ");
							int nuevoNumeroHabitacion = sc.nextInt();
							if (!existeNumHab(h, nuevoNumeroHabitacion)) {
								modHab.setNumHabitacion(nuevoNumeroHabitacion);
							}else {
								System.out.println("Ya existe una habitación con este numéro \n");
							}
							break;
						case 2:
							System.out.println("Introduce cuantos metros cuadrados tiene ahora la habitación: ");
							double nuevosMetrosCuadrados =sc.nextDouble();
							modHab.setMetrosCuadrados(nuevosMetrosCuadrados);
							System.out.println("Modificado los metros cuadrados de esta habitación \n");
							break;
						case 3: 
							System.out.println("Introduce el nuevo número de camas de esta habitación: ");
							int numCamasNuevo = sc.nextInt();
							((HabDoble) modHab).setNumCamas(numCamasNuevo);
							System.out.println("Modificado el numero de camas \n");
							break;
						case 4: 
							System.out.println("Introduce cuantos niños hay ahora en esta habitación: ");
							int numNiñosNuevo = sc.nextInt();
							((HabFamiliar) modHab).setNumCamas(numNiñosNuevo);
							System.out.println("Modificado el numero de camas \n");
							break;
						case 5: 
							System.out.println("Volviendo al menú de administradores \n");
							break;
						default: System.out.println("Opción, incorrecta, inténtelo de nuevo \n");
						}
					}while(opcion!=5);
				}
			}
		}
		
	}

	@Override
	public boolean existeNumHab(ArrayList<Habitaciones> h, int numHab) {
		for (Habitaciones habitacion : h) {
			if (habitacion.getNumHabitacion() == numHab) {
				return true;
			}
		}
		return false;
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
