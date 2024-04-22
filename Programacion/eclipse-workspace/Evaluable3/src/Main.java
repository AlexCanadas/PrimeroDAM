import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ArrayList <Personas> personas = new ArrayList<>();
		Administrador nuevoAdmin = new Administrador("alex", "password", "test@email.com", 1);
		personas.add(nuevoAdmin);
		Cliente nuevoCliente = new Cliente("cliente1", "password", "cliente@email.com", "clienteNombre");
		personas.add(nuevoCliente);
		
		ArrayList <Reservas> reservas = new ArrayList<>();
		ArrayList <Habitaciones> habitaciones = new ArrayList<>();
		
		Scanner sc = new Scanner (System.in);
		int opcion;
		
		do {
			System.out.println("¡Bienvenido!");
			
			System.out.println("1. Introducir credenciales");
			System.out.println("2. Salir");
			
			try {
				opcion = sc.nextInt();
				
				switch(opcion) {
					case 1:
					System.out.println("Comprobemos tus credenciales \n");
					System.out.println("Introduce tu alias: ");
					String aliasIntroducido = sc.next();
					
					boolean aliasEncontrado = false;
					
					for (Personas personaABuscar : personas) {
						if (personaABuscar instanceof Administrador) {
							if (personaABuscar.getAlias().equals(aliasIntroducido)) {
								aliasEncontrado = true;
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
								aliasEncontrado = true;
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
					}
					if (!aliasEncontrado) {
						System.out.println("No encontramos tu alias en el sistema, por favor, contacte con un administrador \n");
					}
					break;
					case 2: 
						System.out.println("¡Que tengas un buen día!");
						break;
					default: 
						System.out.println("Opción no válida \n");
				}
			}catch (InputMismatchException e) {
				System.err.println("Error: Debes ingresar el número 1 o el 2 \n");
	            sc.next(); // Limpiamos el scanner
	            opcion = 0; // Valor inválido para volver al bucle
				
				}
		}while(opcion!=2);
			
			sc.close();
	}
	
}
