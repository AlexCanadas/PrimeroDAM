package Biblioteca;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Revista extends Articulos {

	protected String editor;
	
	public Revista(int idRevista, String nombre, LocalDate fechaPublicacion, String editor) {
		super(idRevista, nombre, fechaPublicacion);

		this.editor = editor;
	}
	

	public Revista() {
	}


	@Override
	protected void mostrarDetalles() {
		System.out.println("Tipo: Revista");
		System.out.println("Id: " + this.idArticulo);
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Fecha de publicación: " + this.fecha);
		System.out.println("Editor: " + this.editor + "\n");
		
	}

	@Override
	public Articulos darDeAlta(Scanner sc) {
		System.out.println("Introduce el ID de la revista: ");
		int idRevista = sc.nextInt();
		System.out.println("Introduce el nombre de la revista: ");
        String nombre = sc.next();
        System.out.println("Introduce la fecha de publicación (dd-MM-yyyy): ");
        String inputFecha = sc.next();
        LocalDate fechaPublicacion = LocalDate.parse(inputFecha, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        System.out.println("Introduce el nombre del editor: ");
        String editor = sc.next();
        Revista nuevaRevista = new Revista(idRevista, nombre, fechaPublicacion, editor);
        return nuevaRevista;
	}

	@Override
	public void darDeBaja(Scanner sc, ArrayList <Articulos> catalogo) {
		boolean articuloEncontrado = false;
		System.out.println("Introduce el ID de la revista: ");
		int idRevistaABuscar = sc.nextInt();
		for (Articulos articulo : catalogo) {
			if (articulo instanceof Revista) {
				Revista revista = (Revista) articulo; // Casting
				if (revista.idArticulo == idRevistaABuscar) {
					articuloEncontrado = true;
					catalogo.remove(revista);
					System.out.println("El libro se ha dado de baja correctamente \n");
					return;
				}
			}
		}
		System.out.println("No se encontró esta revista con el ID proporcionado \n");

	}

}
