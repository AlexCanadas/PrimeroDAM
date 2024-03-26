import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner (System.in);
		int opcion;
		
		do {
			System.out.println("Hola Usuario, que deseas hacer?");
			Logica.mostrarmenu();
			opcion=sc.nextInt();
			Logica.menu(opcion);	
		}while(opcion!=5);
	}
}
