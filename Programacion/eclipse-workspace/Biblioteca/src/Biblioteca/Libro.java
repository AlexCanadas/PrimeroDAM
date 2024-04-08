package Biblioteca;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Libro extends Articulos {

	String autor;
	long isbn;
	protected int idLibro;
	
	public Libro(int idLibro, long isbn, String nombre, LocalDate fechaPublicacion, String autor) {
        super(idLibro, nombre, fechaPublicacion);

        this.autor = autor;
        this.isbn = isbn;
	}
	
	public Libro() {
	}

	@Override
	protected void mostrarDetalles() {
		System.out.println("Tipo: Libro");
		System.out.println("ID: " + this.idLibro);
		System.out.println("ISBN: " + this.isbn);
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Fecha de publicación: " + this.fecha);
		System.out.println("Autor: " + this.autor + "\n");
		
	}


	@Override
	public Articulos darDeAlta(Scanner sc) {
		System.out.println("Introduce el ID del libro: ");
        int idLibro = sc.nextInt();
		System.out.println("Introduce el ISBN: ");
        long isbn = sc.nextLong();
		System.out.println("Introduce el nombre del libro: ");
        String nombre = sc.next();
        System.out.println("Introduce la fecha de publicación (dd-MM-yyyy): ");
        String inputFecha = sc.next();
        LocalDate fechaPublicacion = LocalDate.parse(inputFecha, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        System.out.println("Introduce el nombre del autor: ");
        String autor = sc.next();
        Libro nuevoLibro = new Libro(idLibro, isbn, nombre, fechaPublicacion, autor);
        return nuevoLibro;
	}

	@Override
	public void darDeBaja(Scanner sc, ArrayList <Articulos> catalogo) {
		System.out.println("Introduce el ID del libro: ");
        int idLibroABuscar = sc.nextInt();
        for (Articulos articulo : catalogo) {
        	if (articulo instanceof Libro) {
        		Libro libro = (Libro) articulo; // Casting
        		if (libro.idLibro == idLibroABuscar) {
        			catalogo.remove(libro);
        			System.out.println("El libro se ha dado de baja correctamente \n");
        			return;
        		}
        	}
        }
		System.out.println("No se encontró este libro con el ID especificado \n");
	}
	
}


