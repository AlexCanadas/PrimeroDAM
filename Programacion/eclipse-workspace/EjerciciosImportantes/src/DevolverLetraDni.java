import java.util.Scanner;

public class DevolverLetraDni {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arrayDni[], suma = 0, posicion = 0;
		char letra, arrayLetras[] = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 
				'L', 'C', 'K', 'E'};
		
		System.out.println("A continuación, necesitaremos que introduzcas tu número de DNI uno a uno sin la letra por favor");
		// Guardamos los 8 números del Dni en el array
		arrayDni = new int [8];
		for (int i=0; i < arrayDni.length; i++) {
		System.out.println("Introduce el número " + (i+1) + ": ");
		arrayDni[i] = sc.nextInt();
		}

		// Sumamos y calculamos la posición en la que encontraremos la letra
		for (int i=0; i < arrayDni.length; i++) {
			suma += arrayDni[i];
			posicion = suma % 23;
		}
		
		// Asignamos a letra el valor del número correspondiente a posición en la array Letras
		letra = arrayLetras[posicion];

        System.out.println("La letra de tu DNI es la: " + letra);
        System.out.println("Por lo que tu DNI completo sería: " + arrayDni[0] + arrayDni[1] + arrayDni[2] + arrayDni[3] + arrayDni[4] + arrayDni[5] 
        		+ arrayDni[6] + arrayDni[7] + letra);

		sc.close();
	}
}
