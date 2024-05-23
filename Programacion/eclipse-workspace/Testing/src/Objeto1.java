import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Objeto1 {

	String name, hairColor;
	int age;
	boolean isMarried;

	public Objeto1(String name, String hairColor, int age, boolean isMarried) {
		this.name = name;
		this.hairColor = hairColor;
		this.age = age;
		this.isMarried = isMarried;
	}

	public Objeto1() {
	}

	public Objeto1(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String _name) {
		this.name = _name;
	}

	public String getHairColor() {
		return hairColor;
	}

	public void setHairColor(String _hairColor) {
		this.hairColor = _hairColor;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int _age) {
		this.age = _age;
	}

	public boolean isMarried() {
		return isMarried;
	}

	public void setMarried(boolean _isMarried) {

		this.isMarried = _isMarried;
	}

	public String toString() {
		System.out.println();
		return "Objeto con nombre " + name + ", color de pelo " + hairColor + ", edad " + age + ", casado " + isMarried;
	}

	public static ArrayList<Objeto1> lista() throws IOException {
		ArrayList<Objeto1> listaOtro = new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader("peliculas.txt"));

		String linea;
		while ((linea = br.readLine()) != null) {
			String elementos[] = linea.split(",");

			if (elementos.length == 5) {
				Objeto1 otro1 = new Objeto1();
				listaOtro.add(otro1);
			}
		}
		br.close();

		return listaOtro;
	}

	public static ArrayList<Objeto1> salida(String nombreArchivo, ArrayList<Objeto1> loquesea) throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {

			String linea;
			while ((linea = br.readLine()) != null) {
				String[] elementos = linea.split(",");

				String name = elementos[0].trim();
				String haircolor = elementos[1].trim();
				int age = Integer.parseInt(elementos[2].trim());
				boolean isMarried = Boolean.parseBoolean(elementos[3].trim());
				Objeto1 nuevoObj = new Objeto1(name, haircolor, age, isMarried);
				loquesea.add(nuevoObj);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return loquesea;

	}

	public static void escribirObjetoEnArchivo(String nombreArchivo, Objeto1 obj) throws IOException {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
			bw.write(obj.getName() + "," + obj.getHairColor() + "," + obj.getAge() + "," + obj.isMarried());
			bw.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void escribirAlgoEnArchivo(String nombreArchivo) throws IOException {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
			bw.write("Esto es un ejemplo de escritura");
			bw.newLine();
		}
	}

}
