import java.util.Scanner;

public class EjercicioMediaCompi {

	public static void main(String[] args) {
		
				// Variables y constantes
		String nombre, apellidos, valor1, valor2, valor3;
		double nota1, nota2, nota3, media, totalnotas;
		Scanner scan=new Scanner(System.in);
		
		//Petición de datos
		System.out.println("Toda puntuación introducida en el programa debe ir del 0 al 10, de lo contrario, volverá a preguntarlas.");
		System.out.println("Dime tu nombre: ");
		nombre=scan.next();
		System.out.println("Dime tus apellidos: ");
		apellidos=scan.next();
		
		do {
			System.out.println("Dime la nota del primer trimestre: ");
			valor1=scan.next();
			valor1=valor1.replace(",",".");
			nota1=Double.parseDouble(valor1);
			
			System.out.println("La del segundo, por favor: ");
			valor2=scan.next();
			valor2=valor2.replace(",",".");
			nota2=Double.parseDouble(valor2);
			
			System.out.println("Terminamos con la del tercer trimestre "+nombre+":");
			valor3=scan.next();
			valor3=valor3.replace(",",".");
			nota3=Double.parseDouble(valor3);
		} while (nota1>10 || nota2>10 || nota3>10);
		
		//Operaciones
		totalnotas=nota1+nota2+nota3;
		media=totalnotas/3;
		
		//Mostrar resultados
		System.out.println("Bienvenido "+nombre+" "+apellidos+" tu nota de este curso es: "+media+
		". Gracias por confiar en nosotros.");
		
	}

}
