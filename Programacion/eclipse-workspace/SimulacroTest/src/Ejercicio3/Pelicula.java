package Ejercicio3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Pelicula {
	String titulo, director;
	double puntuacion1, puntuacion2, puntuacion3;

	public Pelicula(String titulo, String director, double puntuacion1, double puntuacion2, double puntuacion3) {
		this.titulo = titulo;
		this.director = director;
		this.puntuacion1 = puntuacion1;
		this.puntuacion2 = puntuacion2;
		this.puntuacion3 = puntuacion3;
	}

	public Pelicula() {

	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public double getPuntuacion1() {
		return puntuacion1;
	}

	public void setPuntuacion1(double puntuacion1) {
		this.puntuacion1 = puntuacion1;
	}

	public double getPuntuacion2() {
		return puntuacion2;
	}

	public void setPuntuacion2(double puntuacion2) {
		this.puntuacion2 = puntuacion2;
	}

	public double getPuntuacion3() {
		return puntuacion3;
	}

	public void setPuntuacion3(double puntuacion3) {
		this.puntuacion3 = puntuacion3;
	}

	public double calcularPuntuacionmedia() {
		double puntuacionFinal = (puntuacion1 + puntuacion2 + puntuacion3) / 3;
		return puntuacionFinal;
	}

	public static ArrayList<Pelicula> leerPeliculas(String nombreFichero) throws IOException {
		ArrayList<Pelicula> peliculasArray = new ArrayList<>();
		nombreFichero = "peliculas.txt";
		FileReader fr = new FileReader(nombreFichero);
		BufferedReader br = new BufferedReader(fr);

		String linea;
		while ((linea = br.readLine()) != null) {
			String elementos[] = linea.split(",");

			if (elementos.length == 5) {
				Pelicula p1 = new Pelicula(elementos[0], elementos[1], Double.parseDouble(elementos[2]),
						Double.parseDouble(elementos[3]), Double.parseDouble(elementos[4]));
				peliculasArray.add(p1);
			}
		}
		br.close();
		return peliculasArray;
	}

	@Override
	public String toString() {
		return "\n Pelicula \n {titulo: " + titulo + " \n director: " + director + " \n puntuacion1: " + puntuacion1
				+ " \n puntuacion2: " + puntuacion2 + " \n puntuacion3: " + puntuacion3 + "}";
	}

}
