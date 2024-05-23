import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Objeto1 test = new Objeto1();
		Scanner sc = new Scanner(System.in);
		ArrayList<Objeto1> prueba = new ArrayList<>();

		Objeto1 nuevoObj = new Objeto1("Alex", "castaño", 33, true);

		try {
			Objeto1.escribirObjetoEnArchivo("src/test.txt", nuevoObj);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			BufferedReader br = new BufferedReader(new FileReader("src/test.txt"));
			String linea = br.readLine();
			if (linea != null) {
				try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/test.txt", true))) {
					bw.write("Hola mundo");
					bw.newLine();
				}
			}
		} catch (Exception e) {
			e.getMessage();
		}

		try {
			Objeto1.escribirAlgoEnArchivo("src/test.txt");
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

		try {
			Objeto1.lista();
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

		try {
			File f = new File("alex.txt");
			if (f.createNewFile()) {
				System.out.println("Archivo creado correctamente" + f.getName());
			} else {
				System.out.println("No se pudo crear el archivo");
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

		String nombreArchivo = "alex.txt";

		// Escribir en el archivo
		try (BufferedWriter wr = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
			wr.write("Probando probando");
			wr.newLine();
		} catch (IOException e) {
			System.out.println("Error al escribir en el archivo: " + e.getMessage());
		}

		// Leer y sobrescribir en el archivo
		try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
			String linea;
			while ((linea = br.readLine()) != null) {
				String[] elementos = linea.split(",");
				for (String elemento : elementos) {
					System.out.print(elemento + " ");
				}
				System.out.println();
			}
		} catch (IOException e) {
			System.out.println("Error al leer el archivo: " + e.getMessage());
		}

	}

}
