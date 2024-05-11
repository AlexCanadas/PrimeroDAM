import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Objeto1 test = new Objeto1();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce el nombre: ");
		String nombre = sc.next();
		test.setName(nombre);
		System.out.println("Introduce la edad: ");
		int edad = sc.nextInt();
		test.setAge(edad);
		System.out.println("Introduce si esta casado o no: ");
		String casado = sc.next();
		boolean casadoBoolean = casado.equalsIgnoreCase("si");
		test.setMarried(casadoBoolean);
		System.out.println("Introduce el color de pelo: ");
		String colorPelo = sc.next();
		test.setHairColor(colorPelo);
		System.out.println(test);
		
		ArrayList<Objeto1> arrayTest = new ArrayList();
		System.out.println("Introduce el nombre: ");
		nombre = sc.next();
		System.out.println("Introduce la edad: ");
		edad = sc.nextInt();
		System.out.println("Introduce si esta casado o no: ");
		casado = sc.next();
		casadoBoolean = casado.equalsIgnoreCase("si");
		System.out.println("Introduce el color de pelo: ");
		colorPelo = sc.next();
		Objeto1 obj = new Objeto1(nombre, colorPelo, edad, casadoBoolean);
		
		arrayTest.add(test);
		arrayTest.add(obj);
		arrayTest.add(new Objeto1("roberto", 30));
		
		for (Objeto1 i : arrayTest) { //Todos los objetos del arrayList
			System.out.println(i);
		}
		
		for (Objeto1 i : arrayTest) { //Solo el objeto obj 
			if (i instanceof Objeto1) {
				if (i.equals(obj)) {
					System.out.println(i);
				}
			}
		}
		
		for (Objeto1 i: arrayTest) { //Solo el objeto que tenga de nombre alex
			if (i.getName().equals("alex")) {
				System.out.println("Ahora encontramos el objeto de manera mas complicada: " + i + "\n");
			}
		}
		
		try {
			//ArrayList <Objeto1> variable = Objeto1.lista();
			for (Objeto1 p : Objeto1.lista()) {
				System.out.println(p.getName() + p.getHairColor() + p.getAge());
				
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		
	}

}
