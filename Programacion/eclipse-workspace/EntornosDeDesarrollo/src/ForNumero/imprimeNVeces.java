package ForNumero;

import java.util.Scanner;

public class imprimeNVeces {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Ingrese un número: ");
		int numero = sc.nextInt();
		
		for (int i=0; i<10; i++) {
			System.out.println("Número " + (i+1) + ": " + numero++);
		}

		sc.close();
	}

}
