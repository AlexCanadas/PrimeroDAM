import java.util.Scanner;

public class Recorrer10Numeros {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double num [] = new double [10];
		int negativos=0, positivos=0, ceros=0;
		
		// Rellenamos el array
		for (int i = 0; i < num.length; i++) {
		System.out.println("Introduce el número " + (i+1) + ": ");
		num[i] = sc.nextDouble();
		}
		
		// Sacamos cuantos números son positivos, negativos e igual a 0
		for (int i = 0; i < num.length; i++) {
			if (num[i]>0){
				positivos++;
			} else if (num[i]==0) {
				ceros++;
				} else {
					negativos++;
			}
		}
			System.out.println("La cantidad de números positivos es: " +positivos);
			System.out.println("La cantidad de números igual a 0 es: " +ceros);
			System.out.println("La cantidad de números negativos es: " +negativos);
		
			sc.close();		
	}
}


