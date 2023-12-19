import java.util.Scanner;

public class LeerDosNumerosYMostrarDeMenorAMayor {

	public static void main(String[] args) {
		// Programa que lea dos números y muestre los números desde el menor hasta el mayor.

		int respuesta, respuesta2;
		
		// Preguntamos los dos números
		System.out.println("Nos hará falta un poco de ayuda por tu parte y que introduzcas dos números");
		Scanner pregunta1 = new Scanner(System.in);
		System.out.println("Introduzca el primer número");
		respuesta = pregunta1.nextInt();
		Scanner pregunta2 = new Scanner (System.in);
		System.out.println("Introduzca ahora el segundo número");
		respuesta2 = pregunta2.nextInt();
		
		int minimo = Math.min(respuesta, respuesta2);
		int maximo = Math.max(respuesta, respuesta2);
		for (int i= minimo; i <= maximo; i++) {
		System.out.println("El número: " + i);
		}
	}

}
