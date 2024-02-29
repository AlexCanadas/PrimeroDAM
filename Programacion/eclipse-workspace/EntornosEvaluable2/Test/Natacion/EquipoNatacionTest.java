package Natacion;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class EquipoNatacionTest {

	@Test
	public void CalcularPuntuacionFinal() {
        EquipoNatacion equipo = new EquipoNatacion("Nombre", "dni", "fecha", 30, 3, 10.5, 4.0);
        double finalCalculada = equipo.puntuacionFinal();
        assertEquals(42.0, finalCalculada);
    }
    
    @Test
    public void MayorDeEdad() {
    	EquipoNatacion MenorEdad = new EquipoNatacion("Nombre2", "dni2", "fecha2", 15, 2, 5.5, 4.0);
        assertEquals(false, MenorEdad.MayorDeEdad()); 
        EquipoNatacion equipoMayorEdad = new EquipoNatacion("Nombre3", "dni3", "fecha3", 20, 4, 9.0, 3.5);
        assertEquals(true, equipoMayorEdad.MayorDeEdad());
    }
    
    @Test
    public void DatosPrueba() {
        ArrayList<EquipoNatacion> lista = new ArrayList<>();
        lista.add(new EquipoNatacion("Nombre", "dni", "fecha", 15, 2, 5.5, 4.0));
        lista.add(new EquipoNatacion("Nombre1", "dni1", "fecha1", 20, 4, 9.0, 3.5));
        assertFalse(lista.isEmpty(), "La lista se encuentra vacía, debería tener datos.");
        assertEquals(2, lista.size(), "Se requieren al menos dos elementos en la lista.");
    }
}
