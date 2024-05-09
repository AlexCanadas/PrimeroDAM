package Ejercicio2;

public abstract class Producto {
    private double precio;

    public Producto(double precio) {
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String toString() {
        return "Producto{" +
                "precio=" + precio +
                '}';
    }

	public abstract double calcularPrecioFinal();


}
