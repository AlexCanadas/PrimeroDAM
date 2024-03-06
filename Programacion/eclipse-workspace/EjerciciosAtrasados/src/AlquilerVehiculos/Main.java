package AlquilerVehiculos;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		// Creamos un objeto por cada clase de vehículo
		Coches coche1 = new Coches();
		Microbuses microbus1 = new Microbuses();
		FurgonetasDeCarga furgoneta1 = new FurgonetasDeCarga();
		Camiones camion1 = new Camiones();
		
		// Creamos un array para añadir el nuevo/s vehículo/s a la lista
		ArrayList<Coches> alquilerCoches = new ArrayList<Coches>();
		alquilerCoches.add(coche1);
		ArrayList<Microbuses> alquilerMicrobuses = new ArrayList<Microbuses>();
		alquilerMicrobuses.add(microbus1);
		ArrayList<FurgonetasDeCarga> alquilerFurgonetas = new ArrayList<FurgonetasDeCarga>();
		alquilerFurgonetas.add(furgoneta1);
		ArrayList<Camiones> alquilerCamiones = new ArrayList<Camiones>();
		alquilerCamiones.add(camion1);

		// Calcular precios de alquiler y mostrarlo por pantalla
		for (Coches co : alquilerCoches) {
			System.out.println("El coche con matrícula " + co.getMatricula() +
					" tiene que pagar: ");
		}
		for (Microbuses m : alquilerMicrobuses) {
			System.out.println("El micro-bus con matrícula " + m.getMatricula() +
					" tiene que pagar: ");
		}
		for (FurgonetasDeCarga f : alquilerFurgonetas) {
			System.out.println("La furgoneta de carga con matrícula " + f.getMatricula() +
					" tiene que pagar: ");
		}
		for (Camiones ca : alquilerCamiones) {
			System.out.println("El camión con matrícula " + ca.getMatricula() +
					" tiene que pagar: " + ca.calcularPrecioAlquiler(0, 0, 0));
		}
		
	}

}
