package Ejercicio2;

public class TelefonoMovil extends Producto {
	protected String marca, modelo, memoria;
	protected int descuento;

    public TelefonoMovil(double precio, String marca, String modelo, String memoria, int descuento) {
        super(precio);
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

	@Override
    public String toString() {
        return "\nTeléfono móvil: \n" +
                "Marca: " + marca + "\n" +
                "Modelo: " + modelo + "\n" +
                "Precio: " + getPrecio() + "€\n" +
                "Descuento: " + getDescuento() + "%\n";
    }

	@Override
	public double calcularPrecioFinal() {
		double descuentoExacto = getPrecio() * (getDescuento()/100);
		double precioFinal = getPrecio() - descuentoExacto;

		return precioFinal;
	}

	

    
}