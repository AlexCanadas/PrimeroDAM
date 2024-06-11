package Test;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import Futbol.Futbol;

public class FutbolTest {
	private Futbol jugador;
	
	/*
	 * @BeforeEach public void setUp() { jugador = new Futbol ("alex", "defensa",
	 * 19); }
	 */
	
	@Test
	public void comprobarEdad() {
	jugador = new Futbol ("alex", "defensa", 19);
	Assertions.assertTrue(jugador.mayorDeEdad(), "Mayor de edad");
	}
}
