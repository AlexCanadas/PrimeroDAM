package AlquilerVehiculos;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		// Creamos un objeto por cada clase de vehículo
		Coches coche1 = new Coches("999LMN", 5, 50.0, 5);
		Microbuses microbus1 = new Microbuses("123ABC", 8, 50.0, 2);
		FurgonetasDeCarga furgoneta1 = new FurgonetasDeCarga("456DEF", 3, 50.0, 6);
		Camiones camion1 = new Camiones("789GHI", 8, 50.0, 1);
		
		// Creamos un array para añadir el nuevo/s vehículo/s a la lista
		ArrayList<Coches> alquilerCoches = new ArrayList<Coches>();
		alquilerCoches.add(coche1);
		ArrayList<Microbuses> alquilerMicrobuses = new ArrayList<Microbuses>();
		alquilerMicrobuses.add(microbus1);
		ArrayList<FurgonetasDeCarga> alquilerFurgonetas = new ArrayList<FurgonetasDeCarga>();
		alquilerFurgonetas.add(furgoneta1);
		ArrayList<Camiones> alquilerCamiones = new ArrayList<Camiones>();
		alquilerCamiones.add(camion1);

		// Calcular precios de alquiler y mostrarlo por pantalla  int _diasAlquiler, double _precioAlquiler, int _plaza
		for (Coches co : alquilerCoches) {
					co.calcularPrecioAlquiler(co.getDiasAlquiler(), co.getPrecioAlquiler(), co.getPlaza());
		}
		for (Microbuses m : alquilerMicrobuses) {
					m.calcularPrecioAlquiler(m.getDiasAlquiler(), m.getPrecioAlquiler(), m.getPlaza());
		}
		for (FurgonetasDeCarga f : alquilerFurgonetas) {
					f.calcularPrecioAlquiler(f.getDiasAlquiler(), f.getPrecioAlquiler(), f.getPlaza());
		}
		for (Camiones ca : alquilerCamiones) {
					ca.calcularPrecioAlquiler(ca.getDiasAlquiler(), ca.getPrecioAlquiler(), ca.getPlaza());
		}
		
	}

}
