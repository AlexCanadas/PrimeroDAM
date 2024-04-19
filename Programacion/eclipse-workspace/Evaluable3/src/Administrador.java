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
				System.out.println("Introduce si la habitación a dar de alta es Individual, Doble o Familiar: ");
				System.out.println("1. Individual");
				System.out.println("2. Doble");
				System.out.println("3. Familiar");
				System.out.println("4. Salir");
				int respuesta = sc.nextInt();
				
				switch(respuesta) {
				case 1:
					HabIndividual ind = new HabIndividual();
					ind.altaHabitacion(h);
					break;
				case 2:
					HabDoble doble = new HabDoble();
					doble.altaHabitacion(h);
					break;
				case 3:
					HabFamiliar fam = new HabFamiliar();
					fam.altaHabitacion(h);
					break;
				case 4:
					System.out.println("Volviendo al menú principal de administradores \n");
					break;
				default: System.out.println("Opción incorrecta");
				}
				break;
			case 2:
					System.out.println("Introduce si la habitación a dar de baja es Individual, Doble o Familiar: ");
					System.out.println("1. Individual");
					System.out.println("2. Doble");
					System.out.println("3. Familiar");
					System.out.println("4. Salir");
					respuesta = sc.nextInt();
					
					switch(respuesta) {
					case 1:
						HabIndividual ind = new HabIndividual();
						ind.bajaHabitacion(h);
						break;
					case 2:
						HabDoble doble = new HabDoble();
						doble.bajaHabitacion(h);
						break;
					case 3:
						HabFamiliar fam = new HabFamiliar();
						fam.bajaHabitacion(h);
						break;
					case 4:
						System.out.println("Volviendo al menú principal de administradores \n");
						break;
					default: System.out.println("Opción incorrecta");
					}
					break;
			case 3: 
					System.out.println("Introduce si la habitación de la que modificar datos es Individual, Doble o Familiar: ");
					System.out.println("1. Individual");
					System.out.println("2. Doble");
					System.out.println("3. Familiar");
					System.out.println("4. Salir");
					respuesta = sc.nextInt();
					
					switch(respuesta) {
					case 1:
						HabIndividual ind = new HabIndividual();
						ind.modificarHabitacion(h);
						break;
					case 2:
						HabDoble doble = new HabDoble();
						doble.modificarHabitacion(h);
						break;
					case 3:
						HabFamiliar fam = new HabFamiliar();
						fam.modificarHabitacion(h);
						break;
					case 4:
						System.out.println("Volviendo al menú principal de administradores \n");
						return;
					default: System.out.println("Opción incorrecta");
					}
					break;
			case 4:
				System.out.println("Habitaciones reservadas: ");
				for (Habitaciones reservadas : h) {
					if(!reservadas.estaDisponible){
						System.out.println(reservadas.toString() + "\n");
						} else if (reservadas.estaDisponible) {
							System.out.println("Actualmente no hay habitaciones reservadas");
						}
					}
				break;
			case 5:
				System.out.println("Habitaciones disponibles: ");
				for (Habitaciones disponibles : h) {
					if(disponibles.estaDisponible){
						System.out.println(disponibles.toString() + "\n");
						} else if (!disponibles.estaDisponible) {
							System.out.println("Actualmente no hay habitaciones disponibles");
						}
				}
				break;
			case 6:
				System.out.println("Introduce el alias del cliente: ");
				String aliasIntroducido = sc.next();
				for (Reservas verReserva : r) {
					if (verReserva.getAliasCliente().equals(aliasIntroducido)) {
						System.out.println("Las reservas de este cliente son:");
						System.out.println(verReserva.toString());
					}
				}
				break;
			case 7:
				System.out.println("Volviendo al menú principal para introducir nuevas credenciales \n");
				break;
			default: 
				System.out.println("Opción no válida \n");
				break;
			}
			
		}while(opcion!=7);
	}
}


