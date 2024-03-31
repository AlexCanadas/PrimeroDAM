package Biblioteca;

import java.sql.Date;

public abstract class Articulos {
String nombre;
Date fecha;
public Articulos(String nombre, Date fecha) {
	this.nombre = nombre;
	this.fecha = fecha;
}
public Articulos() {
	
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public Date getFecha() {
	return fecha;
}
public void setFecha(Date fecha) {
	this.fecha = fecha;
} 


}
