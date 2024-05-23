import java.io.BufferedReader;
import java.io.BufferedWriter;
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

	}

}
