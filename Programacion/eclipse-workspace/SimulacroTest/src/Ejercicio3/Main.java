package Ejercicio3;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<Pelicula> p = new ArrayList<>();

		Pelicula nuevaPelicula = new Pelicula("Sin novedad en el frente", "Edward Berger", 7.2, 5.6, 8.3);
		Pelicula nuevaPelicula2 = new Pelicula("Los Fabelman", "Steven Spielberg", 7.3, 6.5, 7.8);

		p.add(nuevaPelicula);
		p.add(nuevaPelicula2);

		for (Pelicula peliculas : p) {
			System.out.println(peliculas);
		}

		try {
			ArrayList<Pelicula> var = Pelicula.leerPeliculas("peliculas.txt");
			for (Pelicula pTexto : var) {
				System.out.println(pTexto);
			}
		} catch (IOException e) {
			System.out.println("\nError al leer el archivo: " + e.getMessage());
		}

	}

}
