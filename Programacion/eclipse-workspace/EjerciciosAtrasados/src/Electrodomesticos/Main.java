package Electrodomesticos;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<Electrodomestico> e = new ArrayList();
		
		// Creamos varios objetos Television
		Television t1 = new Television();
		Television t2 = new Television();
		Television t3 = new Television();
		// Creamos varios objetos Lavadora
		Lavadora l1 = new Lavadora();
		Lavadora l2 = new Lavadora();
		Lavadora l3 = new Lavadora();
		
		// Añadimos los objetos al ArrayList
		e.add(t1);
		e.add(t2);
		e.add(t3);
		e.add(l1);
		e.add(l2);
		e.add(l3);
		
		// Creamos e iniciamos las variables de precioTotal fuera del bucle
		double precioTotalLavadoras = 0;
	    double precioTotalTelevisiones = 0;
	    double precioTotalElectrodomesticos = 0;
	    
		// Recorremos el ArrayList con un foreach y creamos condición para cada tipo de objeto
		for (Electrodomestico _electrodomestico : e) {
			 if (_electrodomestico instanceof Lavadora) {
		            Lavadora varLavadora = (Lavadora) _electrodomestico; // Se hace un casting de _electrodomestico a Lavadora
		            varLavadora.precioFinal();
		            precioTotalLavadoras += varLavadora.getPrecioBase();  
		        }
			 if (_electrodomestico instanceof Television) {
				 	Television varTelevision = (Television) _electrodomestico; // Se hace un casting de _television a Television
				 	varTelevision.precioFinal();
		            precioTotalTelevisiones += varTelevision.getPrecioBase();
		        }
			 if (_electrodomestico instanceof Electrodomestico) {
				 	Electrodomestico varElectrodomestico = (Electrodomestico) _electrodomestico; // Se hace un casting de _electrodomestico a Electrodomestico
				 	varElectrodomestico.precioFinal();
		            precioTotalElectrodomesticos += varElectrodomestico.getPrecioBase();
		        }
		}
		// Mostramos resultado de cada suma por tipo de objeto
		System.out.println("Precio total de todas las lavadoras: " + precioTotalLavadoras + " euros");
	    System.out.println("Precio total de todas las televisiones: " + precioTotalTelevisiones + " euros");
	    System.out.println("Precio total de todos los electrodomésticos: " + precioTotalElectrodomesticos + " euros");
	}
}
