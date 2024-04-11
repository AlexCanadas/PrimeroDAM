package Biblioteca;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Articulos {
	protected String nombre;
	protected LocalDate fecha;
	protected int idArticulo;

	public Articulos(int idArticulo, String nombre, LocalDate fecha) {
		this.idArticulo = idArticulo;
		this.nombre = nombre;
		this.fecha = fecha;
	}
	
	public Articulos() {
		
	}
	
	public int getIdArticulo() {
		return idArticulo;
	}
	public void setIdArticulo(int idArticulo) {
		this.idArticulo = idArticulo;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	} 
	
	protected abstract void mostrarDetalles();
	
	public abstract Articulos darDeAlta(Scanner sc);
	
	public abstract void darDeBaja (Scanner sc, ArrayList <Articulos> catalogo);


}