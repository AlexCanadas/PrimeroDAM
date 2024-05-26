package Ejercicio2;

import java.util.ArrayList;

public class Prueba {

	public static void main(String[] args) {
		// Declaramos el array de tipo Producto
		ArrayList<Producto> productos = new ArrayList<>();
		// Creamos un objeto móvil
		TelefonoMovil movil = new TelefonoMovil("Iphone", "12", "32", 200.0, 5.0);
		productos.add(movil);
		// Creamos un objeto tablet
		Tablet tablet = new Tablet("Samsung", "Galaxy", "64", 320.0, 8.0);
		productos.add(tablet);

		// Recorremos el array e imprimimos mediante el toString
		for (Producto p : productos) {
			System.out.println(p);
		}
	}

}
