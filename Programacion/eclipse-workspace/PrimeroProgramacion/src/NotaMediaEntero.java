import java.util.Scanner;

public class NotaMediaEntero {

		public static void main(String[] args) {
			int nota1, nota2, nota3;
			int suma, division;
			String nombre;
			
			Scanner Pregunta= new Scanner(System.in);
			System.out.println("Hola, ¿cómo te llamas?");
			nombre=Pregunta.next();
			System.out.println("Bienvenido " + nombre);
			
			
			Scanner Notas= new Scanner(System.in);
			System.out.println("Dime tu nota en Sistemas: ");
			nota1=Notas.nextInt();
			
			System.out.println("Dime tu nota en Bases de datos: ");
			nota2=Notas.nextInt();
			
			System.out.println("Dime tu nota en Programación: ");
			nota3=Notas.nextInt();
			
			suma = nota1 + nota2 + nota3;
			division = suma / 3;
			
			System.out.println("Tu nota media es: ");
			System.out.println(division);
			
			

		}

	}