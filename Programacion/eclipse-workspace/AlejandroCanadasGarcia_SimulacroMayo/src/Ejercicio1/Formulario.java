package Ejercicio1;

import java.util.ArrayList;
import java.util.Scanner;

public class Formulario {

    public static void main(String[] args) {
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int opcion;
        Usuario usuarioActual = null;
        boolean datosCompletos = false;

        do {
            MostrarMenu();
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    usuarioActual = new Usuario();  // Nuevo Usuario
                    rellenarNombreYApellidos(sc, usuarioActual);
                    break;

                case 2:
                    if (usuarioActual != null) {
                        rellenarContraseña(sc, usuarioActual);
                    }
                    break;

                case 3:
                    if (usuarioActual != null) {
                        rellenarDni(sc, usuarioActual);
                    }
                    break;

                case 4:
                    if (usuarioActual != null && verificarDatosCompletos(usuarioActual)) {
                        listaUsuarios.add(usuarioActual);  // Añadimos si está completo
                        System.out.println("¡Que tengas un buen día! \n" + usuarioActual);
                        datosCompletos = true;
                    } else {
                        System.out.println("Faltan datos por rellenar.\n");
                    }
                    break;

                default:
                    System.out.println("Opción no válida, inténtelo nuevamente");
            }

        } while (opcion != 4 || !datosCompletos);

        sc.close();
    }

    public static void MostrarMenu() {
        System.out.println("\nMenú de opciones");
        System.out.println("1. Rellenar usuario");
        System.out.println("2. Rellenar contraseña");
        System.out.println("3. Rellenar DNI");
        System.out.println("4. Finalizar");
    }

    public static void rellenarNombreYApellidos(Scanner sc, Usuario usuario) {
        System.out.println("Introduce el nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Introduce los apellidos: ");
        String apellidos = sc.nextLine();
        usuario.setNombre(nombre);
        usuario.setApellido(apellidos);
    }

    public static void rellenarContraseña(Scanner sc, Usuario usuario) {
        System.out.println("Introduce la contraseña: ");
        String contraseña = sc.nextLine();
        usuario.setContraseña(contraseña);
    }

    public static void rellenarDni(Scanner sc, Usuario usuario) {
        System.out.println("Introduce el DNI: ");
        String dni = sc.nextLine();
        try {
            LongitudDNINoValidaException.validarDNI(dni);
            UltimoDigitoNoLetraException.validarDNI2(dni);
            usuario.setDni(dni);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static boolean verificarDatosCompletos(Usuario usuario) {
        return usuario.getNombre() != null && !usuario.getNombre().isEmpty() &&
               usuario.getApellido() != null && !usuario.getApellido().isEmpty() &&
               usuario.getDni() != null && !usuario.getDni().isEmpty() &&
               usuario.getContraseña() != null && !usuario.getContraseña().isEmpty();
    }
}