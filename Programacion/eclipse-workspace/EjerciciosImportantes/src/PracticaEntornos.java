import java.util.Scanner;

public class PracticaEntornos {

	public static void main(String[] args) {
		
		
		/*1- Pedir un número al usuario y mostrar los 20 números siguientes al dado.
		2- Pedir un número y si es mayor de 100, mostrar los 10 números siguientes al dado de dos en dos. 10,12,14,16,... 
		y si es menor o igual a 100, mostrar en pantalla los diez primeros números desde el 0 en adelante. 0,1,2,3,...9,10
		3- Salir*/
		Scanner sc = new Scanner(System.in);
		int opcion, numero; 
		
	
		do {
			MostrarMenu();
			System.out.println("Selecciona una opción:");
			opcion = sc.nextInt();
			
			switch (opcion) {
				case 1: 
					// Acción para opción 1
					System.out.println("Introduce un número:");
					numero = sc.nextInt();
					for (int i=numero; i<numero+20; i++) {
						System.out.println("El número " + i);
						}
                    break;
				case 2: 
					// Acción para opción 2
					System.out.println("Introduce un número:");
					numero = sc.nextInt();
					if (numero>100) {
					for (int i=numero; i<numero+20; i+=2) {
						System.out.println("El número " + i);
						}
					} else
						for (int i=0; i<=10; i++) {
						System.out.println("El número " + i);
						}
					break;
				case 3:
                     //Salir del menú
                    System.out.println("¡Que tengas un buen día!");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
				}
				System.out.println();
	
		} 	while (opcion != 3);
		   
			sc.close();
    	}
	
			public static void MostrarMenu() {
				System.out.println("-- Menú --");
				System.out.println("1. Introducir un número y mostrar los 20 siguientes");
				System.out.println("2. Introducir un número y si es >100 mostrar 10 siguientes, si es <100 mostrar del 0 al 10");
				System.out.println("3. Salir");
			}

	}


