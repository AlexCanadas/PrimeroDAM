import java.text.DecimalFormat;
import java.util.Scanner;

public class CalculadoraParte2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int opcion;
        double num1, num2, mayor, menor, resultado;
        String seguir = null;
        
        do { 
        	System.out.println("Ingrese primer número");
        	num1=sc.nextDouble();
        	do {
        		MostrarMenu();
        		System.out.print("Seleccione una opción: ");
        		opcion = sc.nextInt();

        		switch (opcion) {
                	case 1:
                		// Acción para sumar
                		System.out.println("Has seleccionado sumar.");
                		System.out.print("Ingrese el segundo número: ");
	                    num2 = sc.nextDouble();
	                    resultado = num1 + num2;
	                    MostrarDosDecimales(resultado);
	                    num1 = resultado;
	                 // Opción para seguir con resultado como num1
	            		System.out.println("Quieres seguir: SI o NO");
	            		seguir=sc.next();
	                    break;
	                case 2:
	                    // Acción para restar
	                    System.out.println("Ha seleccionado restar.");
	                    System.out.print("Ingrese el segundo número: ");
	                    num2 = sc.nextDouble();
	                    menor = Math.min(num1, num2);
	                    mayor = Math.max(num1, num2);
	                    resultado = mayor - menor;
	                    MostrarDosDecimales(resultado);
	                    num1 = resultado;
	                 // Opción para seguir con resultado como num1
	            		System.out.println("Quieres seguir: SI o NO");
	            		seguir=sc.next();
	                    break;
	                case 3:
	                    // Acción para multiplicar
	                    System.out.println("Ha seleccionado multiplicar.");
	                    System.out.print("Ingrese el segundo número: ");
	                    num2 = sc.nextDouble();
	                    resultado = num1 * num2;
	                    MostrarDosDecimales(resultado);
	                    num1 = resultado;
	                 // Opción para seguir con resultado como num1
	            		System.out.println("Quieres seguir: SI o NO");
	            		seguir=sc.next();
	                    break;
	                case 4:
	                    // Acción para dividir
	                    System.out.println("Ha seleccionado dividir.");
	                    System.out.print("Ingrese el segundo número: ");
	                    num2 = sc.nextDouble();
	                    if (num2 == 0) {
	                    	System.out.println("No es posible usar 0 como opción");
	                    }
	                    else {
	                    resultado = num1 / num2;
	                    MostrarDosDecimales(resultado);
	                    num1 = resultado;
	                 // Opción para seguir con resultado como num1
	            		System.out.println("Quieres seguir: SI o NO");
	            		seguir=sc.next();
	                    }
	                    break;
	                case 5:
	                    // Acción para resto
	                    System.out.println("Ha seleccionado resto (%).");
	                    System.out.print("Ingrese el segundo número: ");
	                    num2 = sc.nextDouble();
	                    resultado = num1 % num2;
	                    MostrarDosDecimales(resultado);
	                    num1 = resultado;
	                 // Opción para seguir con resultado como num1
	            		System.out.println("Quieres seguir: SI o NO");
	            		seguir=sc.next();
	                    break;
	                case 6:
	                    // Salir del menú
	                    System.out.println("¡Que tengas un buen día!");
	                    break;
	                default:
	                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
	                    break;
        			}
        	
	        } while (seguir.equalsIgnoreCase("SI"));
        } while (opcion !=6);

        sc.close();
    }
	
	    public static void MostrarMenu() {
	        System.out.println("-- Calculadora --");
	        System.out.println("1. Sumar");
	        System.out.println("2. Restar");
	        System.out.println("3. Multiplicar");
	        System.out.println("4. Dividir");
	        System.out.println("5. Resto");
	        System.out.println("6. Salir");
	    }
	    
	    // Mostrar resultado con dos decimales
	    public static void MostrarDosDecimales(double resultado) {
	    	DecimalFormat formato = new DecimalFormat("#.##");
	    	System.out.println("El resultado es: " + formato.format(resultado));
	    	System.out.println();
	    }
}


