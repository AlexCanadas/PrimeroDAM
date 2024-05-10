package Ejercicio2;

import java.util.ArrayList;

public class Prueba {

	public static void main(String[] args) {
		ArrayList <Producto> p = new ArrayList<>();

		TelefonoMovil tm = new TelefonoMovil(300, "Samsung", "Galaxy", "120", 5);
		p.add(tm);
		Tablet ta = new Tablet(260, "Samsung", "GalaxyPro", "250", 10);
		p.add(ta);	
		
		for (Producto productos : p) {
			if (productos instanceof TelefonoMovil) {
                System.out.println(productos);
            } else if (productos instanceof Tablet) {
                System.out.println(productos);
            }
		}

		
	}

}
