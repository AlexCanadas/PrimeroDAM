package Ejercicio3;

public class Pelicula {
String titulo, director;
int puntuacion1, puntuacion2, puntuacion3;
public Pelicula(String titulo, String director, int puntuacion1, int puntuacion2, int puntuacion3) {

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
public int getPuntuacion1() {
	return puntuacion1;
}
public void setPuntuacion1(int puntuacion1) {
	this.puntuacion1 = puntuacion1;
}
public int getPuntuacion2() {
	return puntuacion2;
}
public void setPuntuacion2(int puntuacion2) {
	this.puntuacion2 = puntuacion2;
}
public int getPuntuacion3() {
	return puntuacion3;
}
public void setPuntuacion3(int puntuacion3) {
	this.puntuacion3 = puntuacion3;
}


public double calcularMedia () {
	double puntuacionFinal;
	puntuacionFinal = (puntuacion1+puntuacion2+puntuacion3)/3;
	
	return puntuacionFinal;
}

public String toString() {
    return "\nTablet: \n" +
            "Título: " + titulo + "\n" +
            "Director: " + director + "\n" +
            "Puntuación 1: " + puntuacion1 + "\n" +
            "Puntuación 2: " + puntuacion2 + "\n" +
            "Puntuación 3: " + puntuacion3 + "\n";
}

}
