import java.util.Scanner;

public class VentaDeTablets {

	public static void main(String[] args) {
		/* Desarrollar una aplicación que me permita guardar diferentes tipos de tablets y venderlas a los clientes.
		Debes de tener una o varias arrays para guardar las tables que están disponibles para vender y realizar 
		las ventas a los clientes. Haz un menú para que el usuario vea las diferentes opciones que puede realizar:
			1.- Dar de alta una tablet.
			2.- Dar de alta un cliente.
			3.- Vender una tablet a un cliente.
			4.- Mostrar tablets disponibles para la venta.
			5.- Mostrar tablets compradas por un cliente en concreto.
			6.- Salir. */
		int opcion, opcionVenta;
		final int FILAS = 100;
		final int COLUMNAS = 6;
		String numeroSerie, dni;
		boolean tablet=false, cliente=false;
		Scanner sc = new Scanner (System.in);
		String tablets [][] = new String [FILAS][COLUMNAS];
		String clientes [][] = new String [FILAS][COLUMNAS];
		int filasCliente = -1;
		
		do {
			System.out.println("1. Dar de alta una tablet");
			System.out.println("2. Dar de alta un cliente");
			System.out.println("3. Vender una tablet a un cliente");
			System.out.println("4. Mostrar tablets disponibles para la venta");
			System.out.println("5. Mostrar tables compradas por un cliente en concreto");
			System.out.println("6. Salir");
			opcion=sc.nextInt();
			
			switch (opcion) {
				case 1: 
					System.out.println("Ingresa el número de serie de la tablet: ");
					numeroSerie=sc.next();
					//Comprobamos si esta tablet ya está registrada
					for (int filas=0;filas<FILAS;filas++) {
						if (tablets[filas][0]!=null&&tablets[filas][0].equals(numeroSerie)){
							System.out.println("Esta tablet ya se registró anteriormente, por favor, seleccione otra opción");
							System.out.println();
							tablet=true;
							break;
						}
					}
					//Registramos tablet en la fila que se ha encontrado vacío el numeroSerie
					if (!tablet){
						for (int filas=0;filas<FILAS;filas++){
							if (tablets[filas][0]==null) {
									tablets[filas][0] = numeroSerie;
									System.out.println("Ingresa la marca de la tablet: ");
									tablets[filas][1]=sc.next();
									System.out.println("Ingresa el color de la tablet: ");
									tablets[filas][2]=sc.next();
									System.out.println("Ingresa el año de la tablet: ");
									tablets[filas][3]=sc.next();
									System.out.println("Ingresa el precio de la tablet: ");
									tablets[filas][4]=sc.next();
									System.out.println("Esta tablet ha sido registrada correctamente");
									System.out.println();
									break;
							}
						}
					}
					tablet=false;
					break;			
				case 2:
					System.out.println("Ingresa el DNI:");
					dni=sc.next();
					// Comprobamos si el cliente ya estaba registrado
					for (int filas=0;filas<FILAS;filas++) {
						if (clientes[filas][0]!=null&&clientes[filas][0].equals(dni)) {
							System.out.println("Este cliente ya está registrado en el sistema, por favor, elija otra opción");
							System.out.println();
							cliente=true;
							break;
						}
					}
					// Registramos al cliente si se ha encontrado vacío el dni
					if (!cliente) {
						for (int filas=0;filas<FILAS;filas++) {
							if (clientes[filas][0]==null) {
									clientes[filas][0]=dni;
									System.out.println("Ingresa el nombre del cliente:");
									clientes[filas][1]=sc.next();
									System.out.println("Ingresa el primer apellido del cliente:");
									clientes[filas][2]=sc.next();
									System.out.println("Ingresa el teléfono del cliente:");
									clientes[filas][3]=sc.next();
									System.out.println("Este cliente ha sido registrado correctamente");
									System.out.println();
									break;							
							}
						}
					}
					cliente=false;
					break;
				case 3: 
					// Introducimos DNI y si existe guardamos la fila donde está registrado en filasCliente
					System.out.println("Introduce el DNI del comprador: ");
					dni=sc.next();
					for (int filas=0;filas<FILAS;filas++) {
						if (clientes[filas][0]!=null&&clientes[filas][0].equals(dni)) {
							filasCliente=filas;
							break;
						}
					}	
					//Opción en caso de no encontrarlo
					if (filasCliente == -1) {
						System.out.println("Este cliente no fue dado de alta anteriormente, por favor, registrelo antes de la compra");
						System.out.println();
					//Mostramos tablets a la venta
					}else {
						System.out.println("Estas son las tablets a la venta actualmente: ");
						for (int filas=0;filas<FILAS;filas++) {
							if (tablets[filas][0]!=null) {
								System.out.println((filas ++)+". "+tablets[filas][1] +" "+tablets[filas][4]+", numero de serie: "+tablets[filas][0]);
							}
						}
						
						System.out.println("Seleccione la tablet que se va a adquirir (1-" + FILAS + "):");
						opcionVenta=sc.nextInt();
						
						if(opcionVenta >=1 && opcionVenta<= FILAS) {
							String tabletVendida = tablets[opcionVenta - 1][1];
				            String marcaTabletVendida = tablets[opcionVenta - 1][2];
				            String serietabletVendida=  tablets[opcionVenta - 1][0];
				            clientes[filasCliente][3] = tabletVendida;  
				            clientes[filasCliente][4] = marcaTabletVendida;
				            clientes[filasCliente][5] = serietabletVendida;
				            tablets[opcionVenta - 1] = new String[COLUMNAS]; 
						
				            System.out.println("Venta realizada. Tablet " + tabletVendida + " vendida a " + clientes[filasCliente][1] + " " + clientes[filasCliente][2]);
				            System.out.println();
				        } else {
				            System.out.println("Opción no válida. Seleccione una opción válida.");
				            System.out.println();
				        }
					}
					break;
				case 4:
					//Mostramos tablets a la venta
					System.out.println("Tablets actualmente a la venta: ");
					for (int filas=0; filas<FILAS; filas++) {
						if (tablets[filas][0]!=null) {
							System.out.println((filas + 1) + ". " + tablets[filas][1] + " " + tablets[filas][4]+" euros, Numero de serie: "+tablets[filas][0]);
						}
					}
					
				case 5:
					System.out.println("Introduce el CIF del cliente para mostrar las tablets vendidas:");
				    dni = sc.next();
				    
				    //Misma ejecución que anteriormente, si se encuentra el cliente se guarda fila en filasCliente
				    filasCliente=-1;
				    for (int filas=0;filas<FILAS;filas++) {
				        if (clientes[filas][0]!=null&&clientes[filas][0].equals(dni)) {
				            filasCliente=filas;
				            break;
				        }
				    }
				    
				    //Misma ejecución de antes por si no se encuentra el cliente
				    if (filasCliente==-1) {
				        System.out.println("Cliente no encontrado en el registro.");
				        System.out.println();
				    } else {
				        System.out.println("Tablets vendidas a " + clientes[filasCliente][1] + " " + clientes[filasCliente][2] + " (CIF: " + dni + "):");
				        boolean tabletsVendidas=false;
				        
				        for (int filas=0;filas<FILAS;filas++) {
				            if (clientes[filas][0]!=null&&clientes[filas][0].equals(dni)&&clientes[filas][3]!=null&&clientes[filas][4]!=null) {
				                System.out.println("   - " + clientes[filas][3] + " " + clientes[filas][4] + ", Numero de serie: " + clientes[filas][5]) ;
				                tabletsVendidas = true;
				            }
				        }
				        
				        if (!tabletsVendidas) {
				            System.out.println("No hay tablets vendidas a este cliente.");
				            System.out.println();
				        }
				    }
				    break;	
					
				case 6:
					System.out.println("¡Que tengas un buen día!");
					break;
				default: 
						System.out.println("Opción incorrecta"); 
			}
			
		}while (opcion!=6);
	}
}


