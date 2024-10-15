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
		String boolRespuesta = sc.next().toUpperCase();
		boolean bañoPrivado = false;
		if (boolRespuesta.equals("SI")) {
			bañoPrivado = true;
		} else if (!boolRespuesta.equals("NO")) {
			System.out.println("Respuesta no válida, se asumirá que no tiene baño \n");
		} 
		HabIndividual nuevaHab = new HabIndividual(numHabitacion, metrosCuadrados, bañoPrivado);
		h.add(nuevaHab);
		System.out.println("Habitación creada correctamente");
        System.out.println(nuevaHab);
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
		int opcion;
		System.out.println("Indica que número de habitación quieres modificar: ");
		int numHab = sc.nextInt();
		
		for (Habitaciones modHab : h) {
			if (modHab instanceof HabIndividual) {
				if (modHab.getNumHabitacion()==numHab) {
					System.out.println("Indica que dato quieres modificar de la habitacion: ");
					do {
						System.out.println("1. Número de habitación");
						System.out.println("2. Metros cuadrados");
						System.out.println("3. Cambiar si tiene baño o no");	
						System.out.println("4. Salir");
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
							if (bañoPrivado) {
								((HabIndividual) modHab).setBañoPrivado(!bañoPrivado);
								System.out.println("Ahora esta habitación no tiene baño privado \n");
							}
							if (!bañoPrivado){
								((HabIndividual) modHab).setBañoPrivado(bañoPrivado);
								System.out.println("Ahora esta habitación tiene baño privado \n");
							}
							break;
						case 4: 
							System.out.println("Volviendo al menú de administradores \n");
							break;
						default: System.out.println("Opción, incorrecta, inténtelo de nuevo \n");
						}
					}while(opcion!=4);
				}
			}
		}
	}
	
	public boolean existeNumHab(ArrayList <Habitaciones> h, int numHab) {
		for (Habitaciones habitacion : h) {
			if (habitacion.getNumHabitacion() == numHab) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		
        return String.format("Habitacion INDIVIDUAL \n" +
        					"Número de habitación: %d\n" +
                            "Metros cuadrados: %.2f\n" +
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
