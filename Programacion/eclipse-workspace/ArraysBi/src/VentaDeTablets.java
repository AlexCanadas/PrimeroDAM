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
		int opcion; 
		String codigo, dni = null;
		Scanner sc = new Scanner (System.in);
		final int CLIENTESCOLUMNAS = 4;
		final int TABLETSCOLUMNAS = 6;
		final int FILAS = 100;
		String tablets [][] = new String [FILAS][TABLETSCOLUMNAS];
		String clientes [][] = new String [FILAS][CLIENTESCOLUMNAS];
		boolean tablet = false;
		boolean cliente = false;
		int indiceCliente = -1;
		int indiceTablet = -1;
		
		
		do {
			System.out.println("--------------MENÚ--------------");
			System.out.println("1. Dar de alta una tablet");
			System.out.println("2. Dar de alta a un cliente");
			System.out.println("3. Vender una tablet a un cliente");
			System.out.println("4. Mostrar tablets disponibles para la venta");
			System.out.println("5. Mostrar tablets compradas por un cliente en concreto");
			System.out.println("6. Salir");
			opcion=sc.nextInt();
			
			switch (opcion) {
			case 1: 
				System.out.println("Introduce el código de la tablet: ");
				codigo=sc.next();
				for (int filas=0; filas<tablets.length; filas++) {
					if (tablets[filas][0]!=null && tablets[filas][0].equals(codigo)) {
						System.out.println("Esta tablet ya existe en la base de datos, seleccione otra opción");
						tablet=true;
						break;
					}
					if (!tablet) {
						tablets[filas][0]=codigo;
						System.out.println("Introduce el número de serie: ");
						tablets[filas][1]=sc.next();
						System.out.println("Introduce la marca de la tablet: ");
						tablets[filas][2]=sc.next();
						System.out.println("Introduce el color de la tablet: ");
						tablets[filas][3]=sc.next();
						System.out.println("Introduce el precio de la tablet: ");
						tablets[filas][4]=sc.next();
						System.out.println("Tablet registrada correctamente");
						System.out.println("");
						break;
					}
				}
				tablet=false;
				break;
			case 2:
				System.out.println("Introduce el DNI del nuevo cliente: ");
				dni=sc.next();
				for (int filas=0; filas<clientes.length; filas++) {
					if (clientes[filas][0]!=null && clientes[filas][0].equals(dni)) {
						System.out.println("Este cliente ya existe en la base de datos, seleccione otra opción");
						System.out.println("");
						cliente=true;
						break;
					}
					if (!cliente) {
						clientes[filas][0]=dni;
						System.out.println("Introduce el nombre: ");
						clientes[filas][1]=sc.next();
						System.out.println("Introduce los apellidos: ");
						sc.nextLine();
						clientes[filas][2]=sc.nextLine();
						System.out.println("Introduce el teléfono: ");
						clientes[filas][3]=sc.next();
						System.out.println("Cliente registrado correctamente");
						System.out.println("");
						break;
					}
				}
				cliente=false;
				break;
				
			case 3:
			    System.out.println("Introduce el código de la tablet a vender: ");
			    codigo = sc.next();
			    // Busca la tablet en el array tablets
			    for (int filas = 0; filas < tablets.length; filas++) {
			        if (tablets[filas][0] != null && tablets[filas][0].equals(codigo)) {
			            indiceTablet = filas;
			            break;
			        } else if (tablets[filas][0] == null) {
			            System.out.println("La tablet no se ha dado de alta. Debe darse de alta antes de hacer la compra");
			            System.out.println("");
			            tablet = true;
			            break;
			        }
			    }
			    // Si se encontró la tablet, busca al comprador en el array clientes
			    if (indiceTablet != -1) {
			        System.out.println("Introduce el DNI del comprador: ");
			        dni = sc.next();
			        for (int i = 0; i < clientes.length; i++) {
			            if (clientes[i][0] != null && clientes[i][0].equals(dni)) {
			                indiceCliente = i;
			                break;
			            }
			        }
			    }
			    // Realiza las acciones dependiendo de los índices encontrados
			    if (indiceTablet != -1 && indiceCliente != -1) {
			        // Registra la venta
			        tablets[indiceTablet][5] = dni;
			        System.out.println("La tablet con código " + tablets[indiceTablet][0] +
			                " se registró como vendida al cliente con DNI " + clientes[indiceCliente][0]);
			        System.out.println("");
			    }
			    tablet = false;
			    break;

			case 4:
				
			case 5:
				
			
			case 6: 
				System.out.print("¡Hasta pronto!");
				break;
			}
		}while(opcion!=6);
	
	
	
	
	}
}