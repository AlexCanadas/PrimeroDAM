package cuentaBancaria;

public class Cuenta {
	
	/*Crea una clase llamada Cuenta que tendrá los siguientes atributos: titular y cantidad (puede tener decimales).

El titular será obligatorio y la cantidad es opcional. Crea dos constructores que cumpla lo anterior.

Crea sus métodos get, set y toString.

Tendrá dos métodos especiales:

- ingresar(double cantidad): se ingresa una cantidad a la cuenta, si la cantidad introducida es negativa, no se hará nada.
- retirar(double cantidad): se retira una cantidad a la cuenta, si restando la cantidad actual a la que nos pasan es negativa, 
la cantidad de la cuenta pasa a ser 0.*/
	
	 String titular;
	 double cantidad;

	    // Creamos constructor con titular obligatorio y cantidad opcional
	    public Cuenta(String titular, double cantidad) {
	        this.titular = titular;
	    }

	    // Métodos getters y setters
	    public String getTitular() {
	        return titular;
	    }

	    public double getCantidad() {
	        return cantidad;
	    }

	    public void setTitular(String titular) {
	        this.titular = titular;
	    }

	    public void setCantidad(double cantidad) {
	        if (cantidad >= 0) {
	            this.cantidad = cantidad;
	        }
	    }

	    // Método para ingresar dinero
	    public void ingresar(double cantidad) {
	        if (cantidad > 0) {
	            this.cantidad += cantidad;
	            System.out.println("Ingreso exitoso. Nuevo saldo: " + this.cantidad);
	        } else {
	            System.out.println("Error: la cantidad ingresada debe ser positiva.");
	        }
	    }

	    // Método para retirar dinero
	    public void retirar(double cantidad) {
	        if (this.cantidad >= cantidad) {
	            this.cantidad -= cantidad;
	            System.out.println("Retiro exitoso. Nuevo saldo: " + this.cantidad);
	        } else {
	            System.out.println("Error: fondos insuficientes. Saldo actual: " + this.cantidad);
	        }
	    }

	    // Método toString para ver todos los datos de la cuenta
	    public String toString() {
	        return "Cuenta con titular: " + titular + ", cantidad: " + cantidad + "";
	    }
	    
	}