package Ejercicio2;

import java.util.ArrayList;

public class Prueba {

	public static void main(String[] args) {
		ArrayList<Producto> productos = new ArrayList<>();
		TelefonoMovil movil = new TelefonoMovil("12", "apple", 300, 5);
		productos.add(movil);
		Tablet tablet = new Tablet("X", "Samsung", 206, 8);
		productos.add(tablet);

		for (Producto p : productos) {
			System.out.println(p);
		}

	}

}
