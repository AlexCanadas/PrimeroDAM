package Figuras2D;

import java.util.ArrayList;

public class Prueba {

	public static void main(String[] args) {
		ArrayList<Figuras2D> figuras = new ArrayList<>();

		figuras.add(new Circulo("Círculo 1", 3.5));
		figuras.add(new Rectangulo("Rectángulo 1", 4.0, 6.0));
		figuras.add(new Triangulo("Triángulo 1", 3.0, 4.0, 5.0));

		for (Figuras2D figura : figuras) {
			System.out.println(figura);
		}
	}
}