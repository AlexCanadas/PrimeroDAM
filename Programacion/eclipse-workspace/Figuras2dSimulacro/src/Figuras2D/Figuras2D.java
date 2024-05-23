package Figuras2D;

import java.util.Objects;

public abstract class Figuras2D implements FigurasGeometricas {
	private String nombre;

	public Figuras2D(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Figura2D{" + "Nombre='" + nombre + ", perímetro: " + calcularPerimetro() + '\'' + '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Figuras2D figura2D = (Figuras2D) o;
		return Objects.equals(nombre, figura2D.nombre);
	}

	@Override
	public abstract double calcularPerimetro();
}
