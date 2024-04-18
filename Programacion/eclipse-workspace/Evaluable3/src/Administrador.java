import java.util.ArrayList;
import java.util.Scanner;

public class Administrador extends Personas {
	private int codigoAdmin;

	public Administrador(String alias, String contraseña, String email, int codigoAdmin) {
		super(alias, contraseña, email);
		this.codigoAdmin = codigoAdmin;
	}

	public Administrador() {
	}

	public int getCodigoAdmin() {
		return codigoAdmin;
	}
	
	public void setCodigoAdmin(int codigoAdmin) {
		this.codigoAdmin = codigoAdmin;
	}
	
	public static void menuAdmin(ArrayList <Personas> p, ArrayList <Habitaciones> h, ArrayList <Reservas> r, String alias) {
		int opcion; 
		Scanner sc = new Scanner (System.in);
		do {
			System.out.println("----- Menú Administradores-----");
			System.out.println("1. Dar de alta una habitación."); 
			System.out.println("2. Dar de baja una habitación."); 
			System.out.println("3. Modificar datos de una habitación.");
			System.out.println("4. Ver todas las habitaciones que están reservadas.");
			System.out.println("5. Ver todas las habitaciones que están disponibles.");
			System.out.println("6. Ver reservas de un cliente en concreto.");
			System.out.println("7. Salir");
			opcion=sc.nextInt();
		
			switch(opcion) {
			case 1: 
				break;
			case 2:
				break;
			case 3: 
				break;
			case 4:
				break;
			case 5:
				break;
			case 6: 
				break;
			case 7:
				System.out.println("Que tengas un buen día");
				break;
			default: 
				System.out.println("Opción no válida \n");
				break;
			}
			
		}while(opcion!=7);
	}
}


