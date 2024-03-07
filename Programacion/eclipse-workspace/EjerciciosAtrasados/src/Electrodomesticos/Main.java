package Electrodomesticos;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ArrayList<Electrodomestico> e = new ArrayList();
		Scanner sc = new Scanner (System.in);
		
		mostrarMenu();
		int opcion = sc.nextInt();
		switch (opcion) {
		case 1:
			
			break;
		case 2:
			break;
		case 3:
			Television t4 = new Television(400,5,"negro",'C',56,true);
			e.add((Television)t4);
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		case 7:
			calcularPrecioFinal(e);
			break;
		case 8:
			break;
		case 9:
			break;
		case 10:
			break;
			
		}while(opcion!=10);
		
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
	
	public static void mostrarMenu() {
		System.out.println("----- Menú de opciones -----");
		System.out.println("1. Dar de alta electrodoméstico");
		System.out.println("2. Dar de alta lavadora");
		System.out.println("3. Dar de alta televisor");
		System.out.println("4. Mostrar precio final de un electrodoméstico");
		System.out.println("5. Mostrar precio final de todos los electrodomésticos");
		System.out.println("6. Mostrar precio final de un televisor");
		System.out.println("7. Mostrar precio final de todos los televisores");
		System.out.println("8. Mostrar precio final de una lavadora");
		System.out.println("9. Mostrar precio final de todas las lavadoras");
		System.out.println("10. Salir");
	}
	
	public static void calcularPrecioFinal(ArrayList<Electrodomestico>listaE) {
		double precioTotal=0;
		for(Electrodomestico t4 : listaE) {
			if(t4 instanceof Television) {
				precioTotal=((Television)t4).getPrecioBase();
			}
		}
			System.out.println("El precio total de todos los televiores es: " + precioTotal);
	}
}
