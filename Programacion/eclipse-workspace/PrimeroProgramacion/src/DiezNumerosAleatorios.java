import java.util.Scanner;

public class DiezNumerosAleatorios {

	public static void main(String[] args) {
		/* Pide por teclado dos números y genera 10 números aleatorios entre ellos. 
		Usa el método Math.random para generar el número aleatorio
		(recuerda el casting de double a int) */

		System.out.println("Introduce dos números");
		Scanner scanner=new Scanner(System.in);
		System.out.println("Introduce el primer número");
		int NumeroUno=scanner.nextInt();
		System.out.println("Introduce el segundo número");
		int NumeroDos=scanner.nextInt();
		int contador=0;
		
		for (int i=0;contador<10;i++) {
			int NumeroAleatorio=(int) (Math.random()*100);
			if(NumeroAleatorio>NumeroUno&&NumeroAleatorio<NumeroDos) {
				System.out.println(NumeroAleatorio);
				contador++;
			}
		}
		scanner.close();
	}
}
