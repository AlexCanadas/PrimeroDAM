package cuentaEjercicio;

public class cuenta {
 /*Crea una clase llamada Cuenta que tendrá los siguientes atributos: titular y cantidad (puede tener decimales).

El titular será obligatorio y la cantidad es opcional. Crea dos constructores que cumpla lo anterior.

Crea sus métodos get, set y toString.

Tendrá dos métodos especiales:

ingresar(double cantidad): se ingresa una cantidad a la cuenta, si la cantidad introducida es negativa, no se hará nada.
retirar(double cantidad): se retira una cantidad a la cuenta, si restando la cantidad actual a la que nos pasan es negativa, la cantidad de la cuenta pasa a ser 0. */

	// atributos
String dni;
double cantidad, saldo;

// metodos
public void ingresarDinero (double cantidad) {
	saldo+=cantidad;
}
public void retirarDinero (double cantidad) {
	saldo-=cantidad;
}


// setters & getters
public String getDni() {
	return dni;
}

public void setDni(String dni) {
	this.dni = dni;
}

public double getCantidad() {
	return cantidad;
}

public void setCantidad(double cantidad) {
	this.cantidad = cantidad;
}







}
