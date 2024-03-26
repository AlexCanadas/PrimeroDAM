import java.util.ArrayList;
import java.util.Scanner;

public class Logica {
static Scanner scl = new Scanner (System.in);
static ArrayList<Usuario> listaUsuarios = new ArrayList<>();

	public static void mostrarmenu () {
		System.out.println("Opcion 1: Dar de alta a un nuevo usuario");
		System.out.println("Opcion 2: Ver usuarios creados");
		System.out.println("Opcion 3: Modificar usuario");
		System.out.println("Opcion 4: Borrar usuario");
		System.out.println("Opcion 5: Salir");
	}

		protected static void menu(int opcion) {
	        switch (opcion) {
	     case 1: crearUsuario();
            break;
		case 2: mostrarUsuarios();
			break;
		case 3: modificarUsuarios();
			break;
		case 4:borrarUsuario();
			break;
		case 5: System.out.println("Salir");
			break;
			default: System.out.println("Por favor selecciona una opcion valida");
		}
	}
		protected static boolean comprobarDNICorrecto(String dniCompleto) {
		    if (dniCompleto.length() != 9) {
		        System.out.println("El DNI debe tener exactamente 9 caracteres.");
		        return false;
		    }
		    try {   
		        int dni = Integer.parseInt(dniCompleto.substring(0, 8));
		        char letra = Character.toUpperCase(dniCompleto.charAt(8));
		        char letraCalculada = Character.toUpperCase(calcularLetraDNI(dni));
		        if (letra == letraCalculada) {
		            return true;
		        } else {
		            System.out.println("La letra del DNI no es correcta.");
		            return false;
		        }
		    } catch (NumberFormatException e) {	    
		        System.out.println("El número de DNI debe contener solo caracteres numéricos.");
		        return false;
		    } catch (StringIndexOutOfBoundsException e) {  
		        System.out.println("La longitud del DNI es incorrecta.");
		        return false;
		    }
		}
	 
		private static char calcularLetraDNI(int dni) {
	        String tablaLetras = "TRWAGMYFPDXBNJZSQVHLCKE";
	        int resto = dni % 23;
	        char letra = tablaLetras.charAt(resto);
	        return letra;
	 }  
		protected static boolean validarEmail(String email) {
		    String regex = "^(.+)@(.+)$";
		    return email.matches(regex);
		}
		
		protected static boolean usuarioexiste (String dni) {
			boolean existe = false;
			for(Usuario usuario: listaUsuarios) {
				if(usuario.getDni().equals(dni)) {
					existe=true;
					break;
				}
			}
			return existe;
		}
		protected static void crearUsuario() {
			 System.out.println("*Creación de un usuario*");
	            String dniCompleto;
	            boolean dniCorrecto;
	            boolean usuarioExistente = false;
	            do {
	                System.out.println("Ingresa el DNI del usuario");
	                dniCompleto = scl.next();
	                scl.nextLine();
	                dniCorrecto = comprobarDNICorrecto(dniCompleto);
	                if (!dniCorrecto) {
	                    System.out.println("El DNI introducido no es válido. Inténtalo de nuevo.");
	                } else {
	                    usuarioExistente = usuarioexiste(dniCompleto);
	                    if (usuarioExistente) {
	                        System.out.println("El usuario con este DNI ya existe. Inténtalo de nuevo.");
	                    }
	                }
	            } while (!dniCorrecto || usuarioExistente);
	            System.out.println("Introduce el nombre del nuevo usuario");
	            String nombre = "";
	            while (nombre.isEmpty()) {
	                nombre = scl.nextLine().trim();
	                if (nombre.isEmpty()) {
	                    System.out.println("El nombre no puede estar vacío. Inténtalo de nuevo.");
	                }
	            }
	            System.out.println("Introduce el apellido del usuario");
	            String apellido = "";
	            while (apellido.isEmpty()) {
	                apellido = scl.nextLine().trim();
	                if (apellido.isEmpty()) {
	                    System.out.println("El apellido no puede estar vacío. Inténtalo de nuevo.");
	                }
	            }
	            boolean emailValido;
	            String email;
	            do {
	                System.out.println("Introduce el email del usuario");
	                email = scl.nextLine().trim();
	                emailValido = validarEmail(email);
	                if (!emailValido) {
	                    System.out.println("El email introducido no es válido. Inténtalo de nuevo.");
	                }
	            } while (!emailValido);
	                Usuario nuevoUsuario = new Usuario (dniCompleto,nombre, apellido, email);
	                listaUsuarios.add(nuevoUsuario);
	                System.out.println("Usuario creado correctamente");   
		}
		
		protected static void mostrarUsuarios() {
			System.out.println("Mostrar Usuarios*");
		    if (listaUsuarios.isEmpty()) {
		        System.out.println("No hay usuarios creados.");
		    } else {
		        for (Usuario usuario : listaUsuarios) {
		            System.out.println(usuario);
		        }
		    }
		}
		public static void modificarUsuarios() {
			System.out.println("*Modificar Usuaruios*");
		    System.out.println("Ingresa el DNI del usuario que deseas modificar:");
		    String dniModificar = scl.next();
		    scl.nextLine();
		    boolean usuarioEncontrado = false;
		    for (Usuario usuario : listaUsuarios) {
		        if (usuario.getDni().equals(dniModificar)) {
		            usuarioEncontrado = true;
		            System.out.println("¿Qué dato deseas modificar? (nombre, apellido o email)");
		            String datoModificar = scl.nextLine();
		            switch (datoModificar.toLowerCase()) {
		                case "nombre":
		                    System.out.println("Ingrese el nuevo nombre:");
		                    String nuevoNombre = scl.nextLine();
		                    usuario.setNombre(nuevoNombre);
		                    break;
		                case "apellido":
		                    System.out.println("Ingrese el nuevo apellido:");
		                    String nuevoApellido = scl.nextLine();
		                    usuario.setApellido(nuevoApellido);
		                    break;
		                case "email":
		                    System.out.println("Ingrese el nuevo email:");
		                    String nuevoEmail = scl.nextLine();
		                    while (!validarEmail(nuevoEmail)) {
		                        System.out.println("El email introducido no es válido. Inténtalo de nuevo:");
		                        nuevoEmail = scl.nextLine();
		                    }
		                    usuario.setEmail(nuevoEmail);
		                    break;
		                default:
		                    System.out.println("Opción inválida.");
		                    break;
		            }
		            System.out.println("Usuario modificado correctamente.");
		            break;
		        }
		    }
		    if (!usuarioEncontrado) {
		        System.out.println("El usuario con DNI " + dniModificar + " no fue encontrado.");
		    }  
		}
		protected static void borrarUsuario() {
			System.out.println("*Borrar Usuario*");
			System.out.println("Ingresa el DNI del usuario que deseas borrar:");
		    String dniBorrar = scl.next();
		    scl.nextLine();
		    boolean usuarioEliminado = false;
		    for (Usuario usuario : listaUsuarios) {
		        if (usuario.getDni().equals(dniBorrar)) {
		            listaUsuarios.remove(usuario);
		            usuarioEliminado = true;
		            System.out.println("Usuario borrado correctamente.");
		            break;
		        }
		    }
		    if (!usuarioEliminado) {
		        System.out.println("El usuario con DNI " + dniBorrar + " no fue encontrado.");
		    }
		}
}

