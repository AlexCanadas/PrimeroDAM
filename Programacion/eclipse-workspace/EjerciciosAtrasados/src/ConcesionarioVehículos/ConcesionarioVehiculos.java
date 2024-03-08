package ConcesionarioVehículos;

import java.util.Scanner;

public class ConcesionarioVehiculos {

		public static void main(String[] args) {
			int opcion;
			final int FILAS=100;
			final int COLUMNAS=7;
			String matricula;
			boolean vehiculo=false;
			Scanner sc = new Scanner(System.in);
			String vehiculos [][] = new String [FILAS][COLUMNAS];
			
			do {
				System.out.println("Menu de opciones");
				System.out.println("1.- Dar de alta un vehículo");
				System.out.println("2.- Dar de baja un vehículo");
				System.out.println("3.- Modificar datos de un vehículo");
				System.out.println("4.- Mostrar datos de un vehiculo");
				System.out.println("5.- Vender un vehículo a un cliente");
				System.out.println("6.- Mostrar vehículos a la venta");
				System.out.println("7.- Salir");
				opcion=sc.nextInt();
				switch(opcion) {
					case 1: System.out.println("Dime la matricula");
							matricula=sc.next();
							//Buscamos la matricula en el array
							for (int filas=0;filas<FILAS;filas++) {
								if(vehiculos[filas][0]!=null && vehiculos[filas][0].equals(matricula)) {
									System.out.println("No se puede insertar, ya está guardado el vehículo \n");
									vehiculo=true;//En caso de encontrarlo
									break;
								}
							}
							//Preguntamos si existe o no dicho vehículo
							if(!vehiculo) {
								for (int filas=0;filas<FILAS;filas++) {
									if(vehiculos[filas][0]==null) {
										vehiculos[filas][0]=matricula;
										System.out.println("Dime la marca");
										vehiculos[filas][1]=sc.next();
										System.out.println("Dime el modelo");
										vehiculos[filas][2]=sc.next();
										System.out.println("Dime la color");
										vehiculos[filas][3]=sc.next();
										System.out.println("Dime el motor");
										vehiculos[filas][4]=sc.next();
										filas=FILAS;
									}
								}
								System.out.println("El vehículo se ha registrado correctamente \n");
							}
							vehiculo=false;
						break;
					case 2: System.out.println("Dime la matricula");
							matricula=sc.next();
							//Buscamos la matricula en el array
							for (int filas=0;filas<FILAS;filas++) {
								if(vehiculos[filas][0]!=null && vehiculos[filas][0].equals(matricula)) {
									vehiculos[filas][0]=null;
									System.out.println("Vehiculo eliminado correctamente \n");
									break;
								}
							}
						break;
					case 3: System.out.println("Dime la matricula");
							matricula=sc.next();
							//Buscamos la matricula en el array
							for (int filas=0;filas<FILAS;filas++) {
								if(vehiculos[filas][0]!=null && vehiculos[filas][0].equals(matricula)) {
									System.out.println("Dime la matricula nueva");
									vehiculos[filas][0]=sc.next();
									System.out.println("Matricula modificada correctamente \n");
									break;
								}
							}
						break;
					case 4: System.out.println("Dime la matricula");
							matricula=sc.next();
							//Buscamos la matricula en el array
							for (int filas=0;filas<FILAS;filas++) {
								if(vehiculos[filas][0]!=null && vehiculos[filas][0].equals(matricula)) {
									System.out.println("Matricula: "+vehiculos[filas][0]);
									System.out.println("Marca: "+vehiculos[filas][1]);
									System.out.println("Modelo: "+vehiculos[filas][2]);
									System.out.println("Color: "+vehiculos[filas][3]);
									System.out.println("Motor: "+vehiculos[filas][4] + "\n");
									break;
								}
							}
							break;	
					case 5: 
							for (int filas=0;filas<FILAS;filas++) {
								boolean cochesVenta = false;
								if (vehiculos[filas][0]!=null) {
									System.out.println("Introduce la matrícula del coche que será vendido: ");
									matricula=sc.next();
									if(vehiculos[filas][0].equals(matricula) && vehiculos[filas][5]==null) {
										System.out.println("Introduce el DNI del cliente que adquidirá un vehículo: ");
										vehiculos[filas][5]=sc.next();
										System.out.println("Introduce el nombre del comprador: ");
										vehiculos[filas][6]=sc.next();
										System.out.println("El vehículo con matrícula " + vehiculos[filas][0] + 
												" fue vendio al cliente con dni " + vehiculos[filas][5] + " y nombre " + vehiculos[filas][6] + "\n");
										cochesVenta=true;
										break;
									}
									if(vehiculos[filas][0]!=matricula && vehiculos[filas][0]!=null) {
										System.out.println("Este vehículo no se encuentra registrado en el sistema \n");
										break;
									}
								}
								if (!cochesVenta) {
									System.out.println("No tenemos vehículos a la venta actualmente \n");
									break;
								}
							}
							break;
					case 6: System.out.println("Los siguientes vehículos están actualmente a la venta: \n"); 
					    	boolean hayVehiculosDisponibles = false;
					    	for (int filas = 0; filas < vehiculos.length; filas++) {
						        if (vehiculos[filas][5] == null && vehiculos[filas][0] != null) {
						            System.out.println("Matrícula: " + vehiculos[filas][0] + ", marca: " + vehiculos[filas][1] + 
						                ", modelo: " + vehiculos[filas][2] + ", color:" + vehiculos[filas][3] + ", motor:" + vehiculos[filas][4] + "\n");
						            hayVehiculosDisponibles = true;
						        }
					    	}
					    	if (!hayVehiculosDisponibles) {
					        System.out.println("No hay vehículos disponibles a la venta en este momento. \n");
					    	}
					    	break;
					case 7: System.out.print("¡Hasta pronto!");
						break;
					default: System.out.print("Opcion incorrecta \n \n");
				}
			} while(opcion!=7);
			
		}
}

	

