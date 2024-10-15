package Figuras2D;

public class Circulo extends Figuras2D {
	private double radio;

	public Circulo(String nombre, double radio) {
		super(nombre);
		this.radio = radio;
	}

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}

	@Override
	public double calcularPerimetro() {
		return 2 * Math.PI * radio;
	}

	@Override
	public String toString() {
		return "Circulo{" + "Nombre='" + getNombre() + '\'' + ", radio=" + radio + ", perímetro: " + calcularPerimetro()
				+ '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		if (!super.equals(o))
			return false;
		Circulo circulo = (Circulo) o;
		return Double.compare(circulo.radio, radio) == 0;
	}

}
