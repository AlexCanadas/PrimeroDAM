package Biblioteca;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Pelicula extends Articulos {

	protected String director;
	
	public Pelicula(int idPelicula, String nombre, LocalDate fechaPublicacion, String director) {
		super(idPelicula, nombre, fechaPublicacion);

		this.director = director;
	}
	
	public Pelicula() {
	}

	@Override
	protected void mostrarDetalles() {
		System.out.println("Tipo: Película");
		System.out.println("ID: " + this.idArticulo);
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Fecha de publicación: " + this.fecha);	
        System.out.println("Director: " + this.director + "\n");
	}

	@Override
	public Articulos darDeAlta(Scanner sc) {
		System.out.println("Introduce el ID de la película: ");
		int idPelicula = sc.nextInt();
		System.out.println("Introduce el nombre de la película: ");
        String nombre = sc.next();
        System.out.println("Introduce la fecha de publicación (dd-MM-yyyy): ");
        String inputFecha = sc.next();
        LocalDate fechaPublicacion = LocalDate.parse(inputFecha, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        System.out.println("Introduce el nombre del director: ");
        String director = sc.next();
        Pelicula nuevaPelicula = new Pelicula(idPelicula, nombre, fechaPublicacion, director);
        return nuevaPelicula;
	}

	@Override
	public void darDeBaja(Scanner sc, ArrayList <Articulos> catalogo) {
		boolean articuloEncontrado = false;
		System.out.println("Introduce el ID de la película: ");
		int idPeliculaABuscar = sc.nextInt();
		for (Articulos articulo : catalogo) {
			if (articulo instanceof Pelicula) {
				Pelicula pelicula = (Pelicula) articulo; // Casting
				if (pelicula.idArticulo == idPeliculaABuscar) {
					articuloEncontrado = true;
					catalogo.remove(pelicula);
					System.out.println("Pelicula eliminada correctamente \n");
					return;
				}
			}
		}
		System.out.println("No se encontro esta película con el ID especificado \n");
	}

}
