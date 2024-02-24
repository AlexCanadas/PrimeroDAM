package CalcularAreaYPerimetro;

import java.util.ArrayList;
import java.util.Scanner;

public class main {
 
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int opcion;
		// Creamos objeto e para usar toString más adelante
		Programador e = new Programador();
		
		// Creamos el arrayList;
		ArrayList<Programador> registro = new ArrayList<>();
		
	do {
		mostrarMenu();
		System.out.println("Elige que opción deseas realizar: ");
		opcion = sc.nextInt();
		
		switch (opcion) {
		case 1: 
			alta(registro, sc, e);
			break;
			 
		case 2: 
			baja (registro, sc, e);
			break; 
			
		case 3: 
			aumentarSalario(registro, sc);
			break; 
			
		case 4: 
			System.out.println("¡Que tengas un buen día!");
			break; 
			
		 default:
             System.out.println("Opción inválida. Inténtelo de nuevo por favor.");
             System.out.println("");
		}
	
	} while (opcion != 4);
}

	public static void mostrarMenu() {
		System.out.println("---------Menú---------");
		System.out.println("1. Dar de alta un programador");
		System.out.println("2. Dar de baja un programador");
		System.out.println("3. Aumentar salario de un programador");
		System.out.println("4. Salir");
	}
	
	protected static void alta(ArrayList<Programador> registro, Scanner sc, Empleado e) {
	    String nombre, dni;
	    int edad;
	    boolean casado = false;
	    double salario;
	    int lineasDecCodigoPorHora;
	    String lenguajeDominante;

	    System.out.println("Introduce el DNI:");
	    dni = sc.next();
	    boolean dniDuplicado = false;
	    // Comprobamos si ya existe este DNI
	    comprobarDni(registro, dni);
	    // Verificamos si el DNI ya está duplicado y pedimos los datos
	    if (!dniDuplicado) {
	        // Solicitamos los datos del nuevo programador
	        System.out.println("Introduce el nombre y apellido:");
	        nombre = sc.next();
	        e.setNombre(nombre);
	        sc.nextLine();
	        System.out.println("Introduce la edad:");
	        edad = sc.nextInt();
	        e.setEdad(edad);
	        System.out.println("Introduce si está casado (si/no):");
	        String respuesta = sc.next().toLowerCase();
	        comprobarRespuesta(respuesta);
	        System.out.println("Introduce el salario que comenzará ganando:");
	        salario = sc.nextDouble();
	        e.setSalario(salario);
	        System.out.println("Introduce el lenguaje de programación dominante:");
	        lenguajeDominante = sc.next();
	        System.out.println("Introduce la cantidad de líneas de código por hora que realiza:");
	        lineasDecCodigoPorHora = sc.nextInt();

	        // Creamos un nuevo objeto programador con los detalles proporcionados
	        Programador nuevoProgramador = new Programador(lineasDecCodigoPorHora, lenguajeDominante, nombre, dni,
	                edad, casado, salario);

	        // Agregamos el nuevo programador al ArrayList
	        registro.add(nuevoProgramador);

	        // Mostramos mensaje de confirmación de alta
	        System.out.println("El programador con los siguientes datos se ha registrado correctamente: ");
	        System.out.println(nuevoProgramador.toString());
	    }
	}
	
	protected static void baja(ArrayList<Programador> registro, Scanner sc, Empleado e) {
		System.out.println("Introduce el DNI del programador a eliminar: ");
		String dni = sc.next();
		boolean dniExiste = existeDni(registro, dni);
		if(dniExiste) {
			for (Programador p : registro) {
	            if (dni.equals(p.getDni())) {
	                registro.remove(p);
	                // Mostramos mensaje de confirmación de baja
	                System.out.println("El programador con los siguientes datos se ha dado de baja correctamente: ");
	                System.out.println(p.toString());
	                break;
	            }
	        }
		}
	}

	protected static void aumentarSalario(ArrayList<Programador> registro, Scanner sc) {
		System.out.println("Introduce el DNI del programador que recibirá el aumento: ");
		String dni = sc.next();
		for (Programador p : registro) {
			if (dni.equals(p.getDni())) {
		System.out.println("Introduce que procentaje de aumento de salario va a recibir el programador: ");
		int porcentaje = sc.nextInt();
		System.out.println("El salario actual era de: " + p.getSalario());
		p.aumentarSalario(porcentaje);
		System.out.println("El nuevo salario será de: " + p.getSalario());
			}
			else {
				System.out.println("Este DNI no está registrado en la base de datos");
			}
		}
	}
	
	protected static void comprobarDni(ArrayList<Programador> registro, String dni) {
		boolean dniDuplicado;
		for (Programador p : registro) {
	        if (dni.equals(p.getDni())) {
	            // Mostramos mensaje sobre el DNI duplicado
	            System.out.println("Este DNI ya existe en la base de datos");
	            dniDuplicado = true; // Camabiamos a true en caso de que exista
	            break;
	        }
	    }
	}
	
	protected static boolean existeDni (ArrayList<Programador> registro, String dni) {
		for (Programador p : registro) {
			if (dni.equals(p.getDni())) {
				return true;
			}
		}
		System.out.println("Este DNI no existe en la base de datos");
		return false;

	}
	
	protected static void comprobarRespuesta (String respuesta) {
		boolean casado;
		Programador e = new Programador();
		if (respuesta.equals("si")) {
            casado = true;
            e.setCasado(casado);
        } else if (respuesta.equals("no")) {
            casado = false;
            e.setCasado(casado);
        } else {
            System.out.println("Respuesta no válida. Se asumirá que no está casado.");
            casado = false;
            e.setCasado(casado);
        }
	}
}
