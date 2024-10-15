package Figuras2D;

public class Rectangulo extends Figuras2D {
	private double base;
	private double altura;

	public Rectangulo(String nombre, double base, double altura) {
		super(nombre);
		this.base = base;
		this.altura = altura;
	}

	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	@Override
	public double calcularPerimetro() {
		return 2 * (base + altura);
	}

	@Override
	public String toString() {
		return "Rectangulo{" + "nombre='" + getNombre() + '\'' + ", base=" + base + ", altura=" + altura
				+ ", perímetro: " + calcularPerimetro() + '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		if (!super.equals(o))
			return false;
		Rectangulo that = (Rectangulo) o;
		return Double.compare(that.base, base) == 0 && Double.compare(that.altura, altura) == 0;
	}

}