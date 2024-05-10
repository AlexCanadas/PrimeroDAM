package Ejercicio1;

import java.util.ArrayList;
import java.util.Scanner;

public class Formulario {

	public static void main(String[] args) {
		int opcion;
		Scanner sc = new Scanner(System.in);
		ArrayList<DatosFormulario> f = new ArrayList<>();
		boolean datosCompletados = false;
		
		do {
			mostrarMenu();
			opcion = sc.nextInt();
			switch (opcion) {
			case 1:
                rellenarUsuario(sc, f);
                break;
            case 2:
                rellenarContraseña(sc, f);
                break;
            case 3:
                rellenarDni(sc, f);
                break;
            case 4:
                if (!f.isEmpty() && verificarDatosCompletos(f.get(f.size() - 1))) {
                    System.out.println("¡Que tengas un buen día! \n");
                    obtenerUltimo(f);
                    System.out.println(f);
                    datosCompletados = true;
                } else {
                    System.out.println("Faltan datos por rellenar.\n");
                }
                break;
            default:
                System.out.println("Opción no válida \n");
                break;
			}
		}while(opcion!=4 || datosCompletados);
		
	}
	
	public static void mostrarMenu() {
		System.out.println("----- Menú de opciones -----");
		System.out.println("1. Rellenar usuario");
		System.out.println("2. Rellenar contraseña");
		System.out.println("3. Rellenar DNI");
		System.out.println("4. Salir");
	}

	public static void rellenarUsuario(Scanner sc, ArrayList<DatosFormulario> f) {
        System.out.println("Introduce el nombre de usuario: ");
        String nombreUsuario = sc.next();
        DatosFormulario datos = obtenerUltimo(f);
        datos.setUsuario(nombreUsuario);
    }

    public static void rellenarContraseña(Scanner sc, ArrayList<DatosFormulario> f) {
        System.out.println("Introduce la contraseña: ");
        String contraseña = sc.next();
        DatosFormulario datos = obtenerUltimo(f);
        datos.setContraseña(contraseña);
    }

    public static void rellenarDni(Scanner sc, ArrayList<DatosFormulario> f) {
        System.out.println("Introduce el DNI: ");
        String dni = sc.next();
        DatosFormulario datos = obtenerUltimo(f);
        datos.setDni(dni);
    }

    //Método para verificar que tengamos todos los datos
    public static boolean verificarDatosCompletos(DatosFormulario datos) {
        return datos.getUsuario() != null && datos.getContraseña() != null && 
        		datos.getDni() != null;
    }
    
    //Método para obtener el último usuario
    public static DatosFormulario obtenerUltimo(ArrayList<DatosFormulario> f) {
        if (f.isEmpty()) {
            f.add(new DatosFormulario());
        }
        return f.get(f.size() - 1);
    }
}
