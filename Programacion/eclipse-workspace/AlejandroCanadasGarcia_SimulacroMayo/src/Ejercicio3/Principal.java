package Ejercicio3;

import java.io.IOException;
import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {

		ArrayList<Pelicula> peliculasArray = new ArrayList<Pelicula>();

		// Se crean objetos de tipo Película y se añaden al ArrayList
		Pelicula p1 = new Pelicula("Sin novedad en el frente", "Edward Berger", 7.2, 5.6, 8.3);
		Pelicula p2 = new Pelicula("Los Fabelman", "Steven Spielberg", 7.3, 6.5, 7.8);

		peliculasArray.add(p1);
		peliculasArray.add(p2);

		// Se recorre el ArrayList con un foreach
		for (Pelicula item : peliculasArray) {
			System.out.println(item);
		}

		// Leer películas desde el fichero
		try {
			ArrayList<Pelicula> variable = Pelicula.leerPeliculas("peliculas.txt", peliculasArray);
			for (Pelicula p : variable) {
				System.out.println("Película: " + p.getTitulo() + ", Director: " + p.getDirector()
						+ ", Puntuación Media: " + p.PuntuacionMedia());
			}
		} catch (IOException e) {
			System.out.println("\nError al leer el archivo: " + e.getMessage());
		}

	}

}
