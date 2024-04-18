import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ArrayList <Personas> personas = new ArrayList<>();
		Administrador nuevoAdmin = new Administrador("alex", "password", "test@email.com", 1);
		personas.add(nuevoAdmin);
		ArrayList <Reservas> reservas = new ArrayList<>();
		ArrayList <Habitaciones> habitaciones = new ArrayList<>();
		
		Scanner sc = new Scanner (System.in);
		
		System.out.println("¡Bienvenido!");
		System.out.println("Comprobemos tus credenciales \n");
		System.out.println("Introduce tu alias: ");
		String aliasIntroducido = sc.next();
		for (Personas personaABuscar : personas) {
			if (personaABuscar instanceof Administrador) {
				if (personaABuscar.getAlias().equals(aliasIntroducido)) {
					System.out.println("Introduce tu contraseña: ");
					String contraseñaIntroducida = sc.next();
					if (personaABuscar.getContraseña().equals(contraseñaIntroducida)) {
						Administrador admin = new Administrador();
						admin.menuAdmin(personas, habitaciones, reservas, aliasIntroducido);
					}
					else {
						System.out.println("Contraseña incorrecta, por favor, inténtelo de nuevo: ");
						return;
					}
				}
			}
			if (personaABuscar instanceof Cliente) {
				if (personaABuscar.getAlias().equals(aliasIntroducido)) {
					System.out.println("Introduce tu contraseña: ");
					String contraseñaIntroducida = sc.next();
					if (personaABuscar.getContraseña().equals(contraseñaIntroducida)) {
						Cliente cliente = new Cliente();
						cliente.menuCliente(personas, habitaciones, reservas, aliasIntroducido);
					}
					else {
						System.out.println("Contraseña incorrecta, por favor, inténtelo de nuevo: ");
						return;
					}
				}
			}
			if (!personaABuscar.getAlias().equals(aliasIntroducido)) {
				System.out.println("No encontramos tu alias en el sistema, por favor, contacte con un administrador.");
				break;
			}
		}
		
	}


	
	
	
}
