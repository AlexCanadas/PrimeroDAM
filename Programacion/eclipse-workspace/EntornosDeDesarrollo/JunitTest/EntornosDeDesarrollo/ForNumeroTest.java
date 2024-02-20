package EntornosDeDesarrollo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class ForNumeroTest {

	@Test
	void test() {
Scanner sc = new Scanner(System.in);
		
		System.out.println("Ingrese un número: ");
		int numero = sc.nextInt();
		
		for (int i=0; i<10; i++) {
			System.out.println("Número " + (i+1) + ": " + numero++);
		}

		sc.close();
	}

}
