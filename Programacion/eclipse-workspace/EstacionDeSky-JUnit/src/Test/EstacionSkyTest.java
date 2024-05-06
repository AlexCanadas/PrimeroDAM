package Test;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import EstacionSky.EstacionSky;

public class EstacionSkyTest {

	EstacionSky e = new EstacionSky();
	
	@Test
	public void verificarProfit() {
		e.setEsquiadores(12);
		Assertions.assertTrue(e.calcularProfit() > 50, "El precio debería ser mayor a 50");
	}
}
