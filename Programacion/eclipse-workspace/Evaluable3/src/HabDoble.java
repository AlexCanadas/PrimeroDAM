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
		System.out.println("Introduce el nuevo número de camas de esta habitación: ");
		int numCamas = sc.nextInt();
		System.out.println("Tiene terraza (SI O NO):");
		String boolTerraza = sc.next().toUpperCase();
		boolean tieneTerraza = false;
		if (boolTerraza.equals("SI")) {
			tieneTerraza = true;
		} else if(!boolTerraza.equals("NO")) {
			System.out.println("Respuesta incorrecta, se entenderá que no tiene terraza");
		}
		HabDoble nuevaHab = new HabDoble(numHabitacion, metrosCuadrados, numCamas, tieneTerraza);
		h.add(nuevaHab);
		System.out.println(nuevaHab);
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
							if (tieneTerraza) {
								((HabIndividual) modHab).setBañoPrivado(!tieneTerraza);
								System.out.println("Ahora esta habitación no tiene terraza \n");
							}
							if (!tieneTerraza){
								((HabIndividual) modHab).setBañoPrivado(tieneTerraza);
								System.out.println("Ahora esta habitación tiene terraza \n");
							}
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
                 "Metros cuadrados: %.2f\n" +
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
