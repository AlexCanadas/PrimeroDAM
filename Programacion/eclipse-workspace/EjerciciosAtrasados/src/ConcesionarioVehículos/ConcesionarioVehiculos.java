package ConcesionarioVehículos;

import java.util.Scanner;

public class ConcesionarioVehiculos {

		public static void main(String[] args) {
			int opcion;
			final int FILAS=100;
			final int COLUMNAS=7;
			String matricula, dni, nombre;
			boolean vehiculo=false;
			Scanner sc = new Scanner(System.in);
			String vehiculos [][] = new String [FILAS][COLUMNAS];
			
			do {
				System.out.println("Menu de opciones");
				System.out.println("1.- Dar de alta un vehículo");
				System.out.println("2.- Dar de baja un vehículo");
				System.out.println("3.- Modificar datos de un vehículo");
				System.out.println("4.- Mostrar datos de un vehiculo");
				System.out.println("5.- Dar de alta a un cliente");
				System.out.println("6.- Vender un vehículo a un cliente");
				System.out.println("7.- Mostrar vehículos a la venta");
				System.out.println("8.- Salir");
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
					case 4: 
							for (int filas=0;filas<FILAS;filas++) {
								if(vehiculos[filas][0]!=null) {
									System.out.println("Dime la matricula");
									matricula=sc.next();
									//Buscamos la matricula en el array
									for (filas=0;filas<FILAS;filas++) {
										if(vehiculos[filas][0]!=null && vehiculos[filas][0].equals(matricula)) {
											System.out.println("Matricula: "+vehiculos[filas][0]);
											System.out.println("Marca: "+vehiculos[filas][1]);
											System.out.println("Modelo: "+vehiculos[filas][2]);
											System.out.println("Color: "+vehiculos[filas][3]);
											System.out.println("Motor: "+vehiculos[filas][4] + "\n");
											break;
										}
									}
								}else {
									System.out.println("Este vehículo no esta registrado en el sitema \n");
									break;
								}
							}
							break;	
					case 5:
				            System.out.println("Introduce el DNI del nuevo cliente: ");
				            dni = sc.next();
				            System.out.println("Introduce el nombre del nuevo cliente: ");
				            nombre = sc.next();
	
				            // Agregar el nuevo cliente al primer vehículo disponible
				            for (int i = 0; i < vehiculos.length; i++) {
				                if (vehiculos[i][0] == null) { 
				                    vehiculos[i][5] = dni; 
				                    vehiculos[i][6] = nombre; 
				                    break; 
			                }
			            }
			            break;
					case 6: 
					    boolean vehiculoEncontrado = false;
					    boolean clienteEncontrado = false;

					    System.out.println("Introduce la matrícula del coche que será vendido: ");
					    matricula = sc.next();

					    // Buscamos el vehículo
					    for (int filas = 0; filas < FILAS; filas++) {
					        if (vehiculos[filas][0] != null && vehiculos[filas][0].equals(matricula)) {
					            vehiculoEncontrado = true;
					            if (vehiculos[filas][5] == null) {
					                System.out.println("Introduce el DNI del cliente que adquirirá el vehículo: ");
					                dni = sc.next();
					                // Buscamos al cliente
					                for (int i = 0; i < FILAS; i++) {
					                    if (vehiculos[i][5] != null && vehiculos[i][5].equals(dni)) {
					                        clienteEncontrado = true;
					                        vehiculos[filas][5] = dni;
					                        System.out.println("El vehículo con matrícula " + vehiculos[filas][0] + 
					                                           " fue vendido al cliente con DNI " + dni + 
					                                           " y nombre " + vehiculos[filas][6]);
					                        break;
					                    }
					                }
								    if (!clienteEncontrado) {
								    	System.out.println("No se encontró ningún cliente con ese DNI.");
								    }
					            } else {
					                System.out.println("Este vehículo ya ha sido vendido.");
					            }
					            break;
					        }
					    }
					    if (!vehiculoEncontrado) {
					        System.out.println("No se encontró ningún vehículo con esa matrícula.");
					    }
					    break;

					case 7: 
					    	boolean hayVehiculosDisponibles = false;
					    	for (int filas = 0; filas < vehiculos.length; filas++) {
						        if (vehiculos[filas][5] == null && vehiculos[filas][0] != null) {
						        	System.out.println("Los siguientes vehículos están actualmente a la venta: \n"); 
						            System.out.println("Matrícula: " + vehiculos[filas][0] + ", marca: " + vehiculos[filas][1] + 
						                ", modelo: " + vehiculos[filas][2] + ", color:" + vehiculos[filas][3] + ", motor:" + vehiculos[filas][4] + "\n");
						            hayVehiculosDisponibles = true;
						        }
					    	}
					    	if (!hayVehiculosDisponibles) {
					        System.out.println("No hay vehículos disponibles a la venta en este momento. \n");
					       
					    	}
					    	break;
					case 8:
						System.out.println("Introduce el DNI del cliente del que mostrar sus vehículos adquiridos");
						dni = sc.next();
						for (int filas =0;filas<FILAS;filas++) {
							if (vehiculos[filas][5].equals(dni) && vehiculos[filas][0]!=null) {
								System.out.println("Este cliente tiene los siguientes vehículos: \n" + vehiculos[filas][0] + "\n");
							}
							if (vehiculos[filas][5].equals(dni) && vehiculos[filas][0]==null) {
								System.out.println("Este cliente no tiene vehículos adquiridos \n");
								break;
							}
						}
						break;
					case 9: System.out.print("¡Hasta pronto!");
 						break;
					default: System.out.print("Opcion incorrecta \n \n");
				}
			} while(opcion!=9);
			
		}
}

	

