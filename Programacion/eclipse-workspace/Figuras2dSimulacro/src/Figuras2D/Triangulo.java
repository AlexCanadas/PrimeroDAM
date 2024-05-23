package Figuras2D;

public class Triangulo extends Figuras2D {
	private double lado1;
	private double lado2;
	private double lado3;

	public Triangulo(String nombre, double lado1, double lado2, double lado3) {
		super(nombre);
		this.lado1 = lado1;
		this.lado2 = lado2;
		this.lado3 = lado3;
	}

	public double getLado1() {
		return lado1;
	}

	public void setLado1(double lado1) {
		this.lado1 = lado1;
	}

	public double getLado2() {
		return lado2;
	}

	public void setLado2(double lado2) {
		this.lado2 = lado2;
	}

	public double getLado3() {
		return lado3;
	}

	public void setLado3(double lado3) {
		this.lado3 = lado3;
	}

	@Override
	public double calcularPerimetro() {
		return lado1 + lado2 + lado3;
	}

	@Override
	public String toString() {
		return "Triangulo{" + "nombre='" + getNombre() + '\'' + ", lado1=" + lado1 + ", lado2=" + lado2 + ", lado3="
				+ lado3 + ", perímetro: " + calcularPerimetro() + '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		if (!super.equals(o))
			return false;
		Triangulo triangulo = (Triangulo) o;
		return Double.compare(triangulo.lado1, lado1) == 0 && Double.compare(triangulo.lado2, lado2) == 0
				&& Double.compare(triangulo.lado3, lado3) == 0;
	}

}