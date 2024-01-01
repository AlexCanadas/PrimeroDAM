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
		final int FILAS = 100;
		final int COLUMNAS = 5;
		String numeroSerie, dni;
		boolean tablet=false, cliente=false;
		Scanner sc = new Scanner (System.in);
		String tablets [][] = new String [FILAS][COLUMNAS];
		String clientes [][] = new String [FILAS][COLUMNAS];
		
		do {
			System.out.println("Dar de alta una tablet");
			System.out.println("Dar de alta un cliente");
			System.out.println("Vender una tablet a un cliente");
			System.out.println("Mostrar tablets disponibles para la venta");
			System.out.println("Mostrar tables compradas por un cliente en concreto");
			System.out.println("Salir");
			opcion=sc.nextInt();
			
			switch (opcion) {
				case 1: 
					System.out.println("Dime el número de serie");
					numeroSerie=sc.next();
					//Comprobamos si esta tablet ya está registrada
					for (int filas=0;filas<FILAS;filas++) {
						if (tablets[filas][0]!=null && tablets[filas][0].equals(numeroSerie)){
							System.out.println("Esta tablet ya se registró anteriormente, por favor, seleccione otra opción");
							tablet=true;
							break;
						}
					}
					//Registramos tablet en la fila que se ha encontrado vacío el numeroSerie
					if (!tablet){
						for (int filas=0;filas<FILAS;filas++){
							if (tablets[filas][0]==null) {
								tablets[filas][0] = numeroSerie;
								System.out.println("Ingresa la marca de la tablet:");
								tablets[filas][1]=sc.next();
								System.out.println("Ingresa el color de la tablet:");
								tablets[filas][2]=sc.next();
								System.out.println("Ingresa el año de la tablet:");
								tablets[filas][3]=sc.next();
								System.out.println("Ingresa el precio de la tablet:");
								tablets[filas][4]=sc.next();
								filas=FILAS;
							}
						}
					}
					tablet=false;
					break;			
				case 2:
					System.out.println("Ingresa el DNI:");
					dni=sc.next();
					// Comprobamos si el cliente ya estaba registrado
					for (int filas=0;filas>FILAS;filas++) {
						if (clientes[filas][0]!=null && clientes[filas][0].equals(dni)) {
							System.out.println("Este cliente ya está registrado en el sistema, por favor, elija otra opción");
							cliente=true;
							break;
						}
					}
					if (!cliente) {
						for (int filas=0; filas>FILAS;filas++) {
							if (clientes[filas][0]==null) {
								clientes[filas][0]=dni;
								System.out.println("Ingresa el nombre del cliente:");
								clientes[filas][1]=sc.next();
								System.out.println("Ingresa el primer apellido del cliente:");
								clientes[filas][2]=sc.next();
								System.out.println("Ingresa la dirección del cliente:");
								clientes[filas][3]=sc.next();
								System.out.println("Ingresa el teléfono del cliente:");
								clientes[filas][4]=sc.next();
								filas=FILAS;							
							}
						}
					}
					cliente=false;
					break;
				case 3:
				case 4:
				case 5:
				case 6:
					System.out.println("¡Que tengas un buen día!");
					break;
				default: 
						System.out.println("Opción incorrecta");
			}
			
		}while (opcion!=6);
		}
}


