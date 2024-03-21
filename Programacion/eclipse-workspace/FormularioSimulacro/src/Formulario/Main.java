package Formulario;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int opcion;
		Scanner sc = new Scanner(System.in);
		ArrayList<DatosFormulario> f = new ArrayList();
		
		do {
			mostrarMenu();
			opcion = sc.nextInt();
			switch (opcion) {
			case 1:
                rellenarNombre(sc, f);
                break;
            case 2:
                rellenarApellidos(sc, f);
                break;
            case 3:
                rellenarDni(sc, f);
                break;
            case 4:
                rellenarEmail(sc, f);
                break;
            case 5:
                if (!f.isEmpty() && verificarDatosCompletos(f.get(f.size() - 1))) {
                    System.out.println("¡Que tengas un buen día! \n");
                    System.out.println("Datos del formulario completado:");
                } else {
                    System.out.println("Faltan datos por rellenar.\n");
                }
                break;
            default:
                System.out.println("Opción no válida \n");
                break;
			}
		}while(opcion!=5);
	}
	
	public static void mostrarMenu() {
		System.out.println("----- Menú de opciones -----");
		System.out.println("1. Rellenar nombre");
		System.out.println("2. Rellenar apellidos");
		System.out.println("3. Rellenar DNI");
		System.out.println("4. Rellenar e-mail");
		System.out.println("5. Salir");
	}
	
	public static void rellenarNombre(Scanner sc, ArrayList<DatosFormulario> f) {
        System.out.println("Introduce el nombre: ");
        String nombre = sc.next();
        DatosFormulario datos = obtenerUltimo(f);
        datos.setNombre(nombre);
    }

    public static void rellenarApellidos(Scanner sc, ArrayList<DatosFormulario> f) {
        System.out.println("Introduce los apellidos: ");
        String apellidos = sc.next();
        sc.nextLine();
        DatosFormulario datos = obtenerUltimo(f);
        datos.setApellidos(apellidos);
    }

    public static void rellenarDni(Scanner sc, ArrayList<DatosFormulario> f) {
        System.out.println("Introduce el DNI: ");
        String dni = sc.next();
        DatosFormulario datos = obtenerUltimo(f);
        datos.setDni(dni);
    }

    public static void rellenarEmail(Scanner sc, ArrayList<DatosFormulario> f) {
        System.out.println("Introduce el e-mail: ");
        String email = sc.next();
        DatosFormulario datos = obtenerUltimo(f);
        datos.setEmail(email);
    }

    public static boolean verificarDatosCompletos(DatosFormulario datos) {
        return datos.getNombre() != null && datos.getApellidos() != null && 
        		datos.getDni() != null && datos.getEmail() != null;
    }

    public static DatosFormulario obtenerUltimo(ArrayList<DatosFormulario> f) {
        if (f.isEmpty()) {
            f.add(new DatosFormulario());
        }
        return f.get(f.size() - 1);
    }
}
