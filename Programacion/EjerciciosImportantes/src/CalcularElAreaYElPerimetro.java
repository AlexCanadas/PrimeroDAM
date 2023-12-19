import java.text.DecimalFormat;
import java.util.Scanner;

public class CalcularElAreaYElPerimetro {

	public static void main(String[] args) {
		/*Crea una aplicación que permite calcular el área y el perímetro de un círculo, cuadrado, rectángulo y triángulo. 
		 * El usuario puede elegir qué figura quiere e introducir los valores necesarios para que se muestren los resultados. 
		 * La aplicación  termina cuando el usuario lo indique.*/

		Scanner sc = new Scanner(System.in);
		int opcion;
		double var1, var2, var3, area, p;
		
		do {
			MostrarMenu();
			System.out.println("Selecciona de que figura querrías saber las dimensiones:");
			opcion = sc.nextInt();
			
			switch (opcion) {
				case 1: 
					// Acción para un círculo
					System.out.println("Has seleccionado círculo.");
					System.out.print("Ingrese el radio del círculo en centímetros: ");
                    var1 = sc.nextDouble();
                    p = 2*Math.PI*var1;
                    MostrarPerimetroDosDecimales(p);
                    area = Math.PI*(Math.pow(var1, 2));
                    MostrarAreaDosDecimales(area);
                    break;
				case 2: 
					// Acción para un cuadrado
					System.out.println("Has seleccionado cuadrado.");
					System.out.print("Ingrese el lado del cuadrado en centímetros: ");
                    var1 = sc.nextDouble();
                    p = var1 * 4;
                    MostrarPerimetroDosDecimales(p);
                    area = Math.pow(var1, 2);
                    MostrarAreaDosDecimales(area);
					break;
				case 3: 
					// Acción para un rectángulo
					System.out.println("Has seleccionado rectángulo.");
					System.out.print("Ingrese el lado corto del rectángulo en centímetros: ");
                    var1 = sc.nextDouble();
					System.out.print("Ingrese el lado largo del rectángulo en centímetros: ");
                    var2 = sc.nextDouble();
                    p = 2*(var1 + var2);
                    MostrarPerimetroDosDecimales(p);
                    area = var1 * var2;
                    MostrarAreaDosDecimales(area);
					break;
				case 4: 
					// Acción para un triángulo
					System.out.println("Has seleccionado triángulo.");
					System.out.print("Ingrese la medida del lado A en centímetros: ");
					var1 = sc.nextDouble();
					System.out.print("Ingrese la medida del lado B en centímetros: ");
                    var2 = sc.nextDouble();
					System.out.print("Ingrese la medida del lado C en centímetros: ");
					var3 = sc.nextDouble();
					p = var1+var2+var3;
	                area = Math.sqrt(p/2 * (p/2 - var1) * (p/2 - var2) * (p/2 - var3));
	                if (Double.isNaN(area) || area <= 0) {
	                    System.out.println("Este triángulo no puede existir.");
	                } else {
	                	MostrarPerimetroDosDecimales(p);
	                	MostrarAreaDosDecimales(area); 
	                }
	                area = Math.sqrt(p/2 * (p/2 - var1) * (p/2 - var2) * (p/2 - var3));
					break;
				case 5:
                     //Salir del menú
                    System.out.println("¡Que tengas un buen día!");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
				}
				System.out.println();
	
		} 	while (opcion != 5);
		   
			sc.close();
    	}
	
			public static void MostrarMenu() {
				System.out.println("-- Menú --");
				System.out.println("1. Círculo");
				System.out.println("2. Cuadrado");
				System.out.println("3. Rectángulo");
				System.out.println("4. Triángulo");
				System.out.println("5. Salir");
			}
			
			// Mostrar resultados con dos decimales
		    public static void MostrarAreaDosDecimales(double area) {
		    	DecimalFormat formato = new DecimalFormat("#.##");
		    	System.out.println("El área es: " + formato.format(area));
		    	System.out.println();
		    }
		    public static void MostrarPerimetroDosDecimales(double perimetro) {
		    	DecimalFormat formato = new DecimalFormat("#.##");
		    	System.out.println();
		    	System.out.println("El perímetro es: " + formato.format(perimetro));
		    }
}

			