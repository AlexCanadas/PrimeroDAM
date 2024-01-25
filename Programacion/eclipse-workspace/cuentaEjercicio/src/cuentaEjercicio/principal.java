package cuentaEjercicio;

import java.util.Scanner;

public class principal {

	public static void main(String[] args) {
		String dni, iban;
		double cantidad, saldo;
		Scanner sc = new Scanner (System.in);

		// objeto uno
		cuenta c1 = new cuenta();
		System.out.println(c1.getDni());
		c1.setDni("Alex");
		System.out.println(c1.getDni());
		
		System.out.println("Introduce el iban de la cuenta: ");
		iban=sc.next();
		System.out.println("Introduce el DNI del titular: ");
		dni=sc.next();
		
		
	}

}
