import java.util.Scanner;

public class Sueldo_del_trabajador {

	public static void main(String[] args) {
		 /* Elaborar un programa para calcular el sueldo de un trabajador, a partir de las horas trabajadas en la semana y la clase a la que pertenece:
			Trabajadores de clase “A”, se les paga 25 euros por hora.
			Trabajadores de clase “B”, se paga 20 euros por hora.
			Trabajadores de clase “C”, se les paga 15 euros por hora y
			Trabajadores de clase “D”, 10 euros por hora.
			Ingresar el número de horas trabajadas, la clase a la que pertenece y mostrar el sueldo del trabajador. 
			Una vez termina con un trabajador debe de volver al menú principal para seguir calculando los sueldos, 
			a no ser que el usuario le diga que quiere cerrar.*/
		
		Scanner sc = new Scanner(System.in);
        char opcion;
        double sueldo;

        //Creamos un DoWhile para que pida los datos una vez y se repita solo si el usuario confirma con S o s
        do {
            System.out.println("Ingrese el número de horas trabajadas:");
            double HorasTrabajadas = sc.nextDouble();

            System.out.println("Ingrese la clase del trabajador (A, B, C o D):");
            char ClaseTrabajador = sc.next().charAt(0);

            sueldo = CalcularSueldo(HorasTrabajadas, ClaseTrabajador);

            System.out.println("El sueldo del trabajador es: " + sueldo + " euros.");

            System.out.println("¿Quieres calcular algún otro sueldo? (S/N):");
            opcion = sc.next().charAt(0);

        } while (opcion == 'S' || opcion == 's');

        System.out.println("¡Que tengas un buen día!");
        
        sc.close();
    }

    //Definimos cada clase con su sueldo por hora y guardamos la multiplicación en el método "CalcularSueldo"
	public static double CalcularSueldo(double HorasTrabajadas, char ClaseTrabajador) {
        int SueldoPorHora;

        switch (ClaseTrabajador) {
            case 'A':
            case 'a':
            	SueldoPorHora = 25;
                break;
            case 'B':
            case 'b':
            	SueldoPorHora = 20;
                break;
            case 'C':
            case 'c':
            	SueldoPorHora = 15;
                break;
            case 'D':
            case 'd':
            	SueldoPorHora = 10;
                break;
            default:
                System.out.println("Esta clase no existe por lo que utilizaremos la tarifa más baja que son 10 euros por hora.");
                SueldoPorHora = 10;
                break;
        }

        return HorasTrabajadas * SueldoPorHora;
    }

	public static void MostrarMenu() {
		System.out.println("-- Menú --");
		System.out.println("1. Calcular sueldo");
		System.out.println("2. Salir");
	}
}
