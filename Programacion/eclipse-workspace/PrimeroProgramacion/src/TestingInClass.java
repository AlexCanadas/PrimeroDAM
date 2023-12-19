import java.util.Scanner;

public class TestingInClass {

	public static void main(String[] args) {
		
		
		//Variables más utilizados y estructura en java:
		//valor en número sin decimales 
		int numero = 5;
		//número con decimales 
		double numero2 = 6.0;
		//letra entre comillas simples
		char letra = 'd';
		//palabra o frase
		String palabra = "Javier N";
		//(dos factores) 
		boolean verdadero = false;
		//Constantes más utilizadas (siempre en mayúsculas):
		final int VALOR= 8;
		int num1=4, num2=6, suma, resto;
		
		suma=num1+num2;
		System.out.println("El resultado de la suma es: "+suma);
		resto = num1%num2;
		System.out.println("El resultado del resto es: "+resto);

		Scanner NombreScanner= new Scanner(System.in);
		System.out.println("Dime un número: ");
		int oper1=NombreScanner.nextInt();
		System.out.println(oper1);

	}

}
