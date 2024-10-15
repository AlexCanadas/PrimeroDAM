import java.util.Scanner;

public class NAl100ConTresEstructuras {

	public static void main(String[] args) {
		
	// Programa que muestre los números desde N hasta 100 utilizando las tres estructuras.
		int empiece;
		int numero = 100;
		int numero2 = 100;
		int numero3 = 100;
		
	// Con while
		Scanner pregunta = new Scanner(System.in);
		System.out.println("Empecemos con While, ¿desde qué número deseas contar?");
		empiece = pregunta.nextInt();
	while (numero >= empiece) {
		System.out.println("El número: " + numero);
		numero = numero - 1;
		}
	
	// Con DoWhile
		Scanner pregunta1 = new Scanner(System.in);
		System.out.println("Ahora probemos con DoWhile, ¿desde qué número deseas contar?");
		empiece = pregunta1.nextInt();
	do {
		System.out.println("El número: " + numero2);
		numero2 = numero2 - 1;
		}	while(numero2 >= empiece); 
		
	
	// Con For
		Scanner pregunta3 = new Scanner(System.in);
		System.out.println("Ahora probemos con For, ¿desde qué número deseas contar?");	
		empiece = pregunta3.nextInt();
	for (numero3=100; numero3>=empiece; numero3=numero3-1) {
		System.out.println("El número " + numero3);
		}
	}
}
