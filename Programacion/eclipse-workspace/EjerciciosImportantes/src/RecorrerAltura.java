import java.util.Scanner;

public class RecorrerAltura {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N, menor=0, mayor=0;
		double arrayAlturas [], suma=0, media;
			
			// Pedimos y guardamos la cantidad de personas
			System.out.println("Ingresa la cantidad de gente de la que posteriormente sabremos su altura: ");
			N=sc.nextInt();
			
			// Ponemos una condición por si acaso dan algún dato menor a 1
			while(N <= 0) {
			System.out.println("La cantidad de personas debe ser mayor que 0, intentalo de nuevo: ");
			N=sc.nextInt();
			}
			
			// Pedimos y guardamos cada altura dentro del array
			arrayAlturas = new double [N];
			for (int i=0; i < N; i++) {
				System.out.println("Ingresa la altura de la persona " + (i+1) + ": ");
				arrayAlturas[i]= sc.nextDouble(); 
				}
			
			// Hacemos la suma
			for (int i=0; i < N; i++) {
				suma += arrayAlturas[i];
			}
			
			// Calculamos la media
			media = suma / arrayAlturas.length;
			
			// Sacamos la cantidad menor y mayor a la media
			for (int i = 0; i < N; i++) {
				if (arrayAlturas[i] < media) {
		            menor++;
		        } else if (arrayAlturas[i] > media) {
		        	mayor++;
		          }
		    }
			
			System.out.println("Hay una media de altura de: " + media);
			System.out.println("Hay " + menor + " personas por debajo de la media");
			System.out.println("Hay " + mayor + " personas por encima de la media");
			
			sc.close();
	}
}



