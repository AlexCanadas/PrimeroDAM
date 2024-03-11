package Concesionario;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int opcion;
		Scanner sc = new Scanner(System.in);
		ArrayList<Vehiculos> inventarioVehiculos = new ArrayList<>();
		ArrayList<Clientes> registroClientes = new ArrayList<>();
		ArrayList<Venta> ventaRealizada = new ArrayList<>();
		
		do {
			mostrarMenu();
			opcion = sc.nextInt();
			switch(opcion) {
				case 1: 
					altaCliente(sc, registroClientes);
					break; 
				case 2: 
					altaVehiculo(sc, inventarioVehiculos);
					break;
				case 3: 
					venta(sc, registroClientes, inventarioVehiculos, ventaRealizada);
					break;
				case 4: 
					vehiculosCliente (sc, ventaRealizada);
					break;
				case 5: 
					vehiculosVenta (sc, ventaRealizada, inventarioVehiculos);
					break;
				case 6: System.out.println("¡Que tengas buen día!");
					break;
				default: System.out.println("Opción errónea, intentelo de nuevo.\n");
			}
		}while(opcion!=6);
	}

	public static void mostrarMenu() {
		System.out.println("----- Menú -----");
		System.out.println("1. Dar de alta a un cliente");
		System.out.println("2. Dar de alta a un vehículo");
		System.out.println("3. Registrar venta de un vehículo a un cliente");
		System.out.println("4. Mostrar vehículos de un cliente");
		System.out.println("5. Mostrar vehículos a la venta actualmente");
		System.out.println("6. Salir");
	}
	
	public static void altaCliente(Scanner sc, ArrayList<Clientes> registroClientes) {
	    boolean clienteEncontrado = false;
	    System.out.println("Introduce el dni del nuevo cliente: ");
        String dni = sc.next();
	        for (Clientes c : registroClientes) {
	            if (dni.equals(c.getDni())) {
	                clienteEncontrado = true;
	                System.out.println("Este cliente ya está registrado en la base de datos.\n");
	                break;
	            }
	        }
	        if (!clienteEncontrado) {
	            System.out.println("Introduce el nombre del nuevo cliente: ");
	            String nombre = sc.next();
	            System.out.println("Introduce la dirección nuevo cliente: ");
	            String direccion = sc.next();
	            System.out.println("Introduce la edad cliente: ");
	            int edad = sc.nextInt();
	            
	            Clientes nuevoCliente = new Clientes(dni, nombre, direccion, edad);
	            registroClientes.add(nuevoCliente);
	            System.out.println("Cliente registrado con DNI " + nuevoCliente.getDni() + " correctamente.\n");
	            clienteEncontrado = true;  
	        }
	}

	
	public static void altaVehiculo(Scanner sc, ArrayList<Vehiculos> inventarioVehiculos) {
		boolean vehiculoEncontrado = false;
		System.out.println("Introduce la matrícula del nuevo vehículo: ");
		String matricula = sc.next();
		for (Vehiculos v : inventarioVehiculos) {
			if (matricula.equals(v.getMatricula())) {
				vehiculoEncontrado = true;
				System.out.println("Este vehículo ya está registrado en la base de datos.\n");
				break;
				}	
		}
		if (!vehiculoEncontrado) {
			System.out.println("Introduce el color del nuevo vehículo: ");
			String color = sc.next();
			System.out.println("Introduce la marca del nuevo vehículo: ");
			String marca = sc.next();
			System.out.println("Introduce el modelo del nuevo vehículo: ");
			String modelo = sc.next();
				
			Vehiculos nuevoVehiculo = new Vehiculos(matricula, color, marca, modelo);
			inventarioVehiculos.add(nuevoVehiculo);
			vehiculoEncontrado = true;
			System.out.println("Vehículo registrado con matrícula " + nuevoVehiculo.getMatricula() + " correctamente.\n");
		}
	}
	
	public static void venta(Scanner sc, ArrayList<Clientes> registroClientes, ArrayList<Vehiculos> inventarioVehiculos, 
			ArrayList<Venta> ventaRealizada) {
		System.out.println("Introduce el DNI del cliente que adquiere un vehículo: ");
		String dni = sc.next();
		boolean clienteEncontrado = false;
		boolean vehiculoEncontrado = false;
		for (Clientes c : registroClientes) {
			if (dni.equals(c.getDni())) {
				clienteEncontrado = true;
				System.out.println("Introduce la matrícula del vehículo vendido: ");
				String matricula = sc.next();
				for (Vehiculos v : inventarioVehiculos) {
					if (matricula.equals(v.getMatricula())) {
						vehiculoEncontrado = true;
						Venta nuevaVenta = new Venta(matricula, dni);
						ventaRealizada.add(nuevaVenta);
						System.out.println("Venta del vehículo matrícula " + nuevaVenta.getMatricula() + " registrada correctamente "
								+ "para el cliente con DNI " + nuevaVenta.getDni() + ".\n");
						break;
					}
				}
					if (!vehiculoEncontrado) {
						System.out.println("Este vehículo no se encuentra registrado en el sistema.\n");
					}
			}
		}
			if (!clienteEncontrado) {
				System.out.println("Este cliente no se encuentra registrado en el sistema.\n");
			}
		
	}
	
	public static void vehiculosCliente (Scanner sc, ArrayList<Venta> ventasRealizadas) {
		System.out.println("Introduce el DNI del cliente del que ver su registro de vehículos: ");
		String dni = sc.next();
		boolean clienteEncontrado = false;
			for (Venta v : ventasRealizadas) {
				if (dni.equals(v.getDni())) {
					clienteEncontrado = true;
					System.out.println("El cliente con DNI " + v.getDni() + " tiene el vehículo: \n" + 
		                           "Matrícula: " + v.getMatricula() + "\n"); 
				}
			}
			if (!clienteEncontrado) {
		        System.out.println("El cliente con DNI " + dni + " no tiene vehículos registrados.\n");
		    }
	}
	
	public static void vehiculosVenta(Scanner sc, ArrayList<Venta> ventasRealizadas, ArrayList<Vehiculos> inventarioVehiculos) {
		boolean vehiculoEncontrado = false;
		System.out.println("Vehículos a la venta actualmente: \n");
		for (Vehiculos v : inventarioVehiculos) {
			if(!ventasRealizadas.contains(v.getMatricula())) {
				vehiculoEncontrado = true;
				 System.out.println("Matrícula: " + v.getMatricula() + ", Marca: " + v.getMarca() +
		                    ", Modelo: " + v.getModelo() + ", Color: " + v.getColor());
			} 
		}
		if (!vehiculoEncontrado) {
	        System.out.println("No hay vehículos disponibles a la venta.\n");
	    }
	}
}

