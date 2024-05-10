package Ejercicio2;

public class Tablet extends Producto {

    public Tablet(double precio, String marca, String modelo, String memoria, int descuento) {
		super(precio, marca, modelo, memoria, descuento);
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
	
	/*
	 * public boolean equals(Object o) { if (o instanceof TelefonoMovil) { return
	 * this.marca.equals(((Tablet)o).getMarca()) &&
	 * this.modelo.equals(((Tablet)o).getModelo()) &&
	 * this.memoria.equals(((Tablet)o).getMemoria()); }else { return
	 * super.equals(o); } }
	 */

	@Override
    public String toString() {
        return "\nTablet: \n" +
                "Marca: " + getMarca() + "\n" +
                "Modelo: " + getModelo() + "\n" +
                "Precio original: " + getPrecio() + "€\n" +
                "Descuento: " + getDescuento() + "%\n" +
                "Precio final: " + calcularPrecioFinal() + "€\n";
    }

	@Override
	public double calcularPrecioFinal() {
		
		double descuentoExacto = getPrecio() * (getDescuento() / 100.0);
		double precioFinal = getPrecio() - descuentoExacto;
		
		return precioFinal;
	}

	

   
}