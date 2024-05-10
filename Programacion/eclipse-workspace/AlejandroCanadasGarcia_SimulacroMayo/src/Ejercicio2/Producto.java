package Ejercicio2;

public abstract class Producto {
    protected double precio;
    protected String marca, modelo, memoria;
    protected int descuento;

   

    public Producto(double precio, String marca, String modelo, String memoria, int descuento) {
		this.precio = precio;
		this.marca = marca;
		this.modelo = modelo;
		this.memoria = memoria;
		this.descuento = descuento;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMemoria() {
		return memoria;
	}

	public void setMemoria(String memoria) {
		this.memoria = memoria;
	}

	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String toString() {
        return "Producto: " +
        		"Marca: " + getMarca() + "\n" +
                "Modelo: " + getModelo() + "\n" +
                "Precio original: " + getPrecio() + "€\n" +
                "Descuento: " + getDescuento() + "%\n" +
                "Precio final: " + calcularPrecioFinal() + "€\n";
    }

	public abstract double calcularPrecioFinal();


}
