
public class MayorDeEdad {

	public static void main(String[] args) {
		 final byte MAYORIA_DE_EDAD_LEGAL = 18; 
		 // final para hacer este dato una constante no posible de cambiar

		    String edadActual = "33";

		    byte edadActualNumerica = Byte.parseByte(edadActual);
		    // Convierte la cadena edadActual en un valor numérico de tipo byte. La función Byte.parseByte() se utiliza para convertir una cadena en un valor de tipo byte

		    System.out.println("Tengo " + (edadActualNumerica - MAYORIA_DE_EDAD_LEGAL) + " años más que la Edad Legal");

	}

}
