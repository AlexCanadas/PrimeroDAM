import java.text.DecimalFormat;
import java.util.Scanner;

public class Notas_media_de_clase {

	public static void main(String[] args) {
		/* Hacer una aplicación para mostrar la nota media de una clase, la nota más baja y la nota más alta.
		El usuario debe de indicar cuántas notas quiere introducir. Una vez introduzca todas las notas, 
		la aplicación debe mostrar por pantalla la media de clase, la nota más baja y la más alta.*/
	
		Scanner sc = new Scanner(System.in);
		int cantidad;
		double suma, media, NotaMinima, NotaMaxima;
		
		//Declaramos la cantidad total que van a darnos de notas
		System.out.println("Indica la cantidad de notas que vas a introducir: ");
		cantidad = sc.nextInt();
		
		//Declaramos e inicializamos el array notas marcando la longitud con cantidad que es el número de notas introducidas por el usuario
		double[] notas = new double[cantidad];
		
		//Pedimos una nota, la guardamos y pedimos la siguiente, así hasta llegar al límite "cantidad"
		for (int i = 0; i < cantidad; i++) {
				System.out.println("Introduce la nota " + (i+1) + ": ");
				notas[i] = sc.nextDouble();
		}
	
		//Calculamos la media
		suma = 0;
		for (int i = 0; i < cantidad; i++) {
			suma+= notas[i];
		}
		media = suma / cantidad;
	
		//Buscamos la nota más alta y más baja recorriendo el array
		NotaMinima = notas[0];
		NotaMaxima = notas[0];
		
		for (int i=0; i<cantidad; i++) {
			if (notas[i] < NotaMinima) {
				NotaMinima = notas[i];
			}
			if (notas[i] > NotaMaxima) {
				NotaMaxima = notas[i];
			}
		}
		sc.close();
		
		//Mostrar los resultados
		MostrarMediaDosDecimales(media);
    	System.out.println("La nota más baja es: " + NotaMinima);
    	System.out.println("La nota más alta es: " + NotaMaxima);
	}
	// Mostrar resultados con dos decimales
	public static void MostrarMediaDosDecimales(double media) {
    	DecimalFormat formato = new DecimalFormat("#.##");
    	System.out.println("La media de la clase es: " + formato.format(media));
    }
}

