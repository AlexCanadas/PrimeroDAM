import java.util.Scanner;

public class UnoANConTresEstructuras {

	public static void main(String[] args) {
		
	// Programa que muestre los números del 1 hasta N utilizando las tres estructuras.
		int limite;
		int numero = 1;
		int numero2 = 1;
		int numero3 = 1;
		
	// Con while
		Scanner pregunta = new Scanner(System.in);
		System.out.println("Empecemos con While, ¿hasta qué número deseas contar?");
		limite = pregunta.nextInt();
	while (numero <= limite) {
		System.out.println("El número: " + numero);
		numero = numero + 1;
		}
	
	// Con DoWhile
		Scanner pregunta1 = new Scanner(System.in);
		System.out.println("Ahora probemos con DoWhile, ¿hasta qué número deseas contar?");
		limite = pregunta1.nextInt();
	do {
		System.out.println("El número: " + numero2);
		numero2 = numero2 + 1;
		}	while(numero2 <= limite); 
		
	
	// Con For
		Scanner pregunta3 = new Scanner(System.in);
		System.out.println("Ahora probemos con For, ¿hasta qué número deseas contar?");	
		limite = pregunta3.nextInt();
	for (numero3=1; numero3<=limite; numero3=numero3+1) {
		System.out.println("El número " + numero3);
		}
	}
}
