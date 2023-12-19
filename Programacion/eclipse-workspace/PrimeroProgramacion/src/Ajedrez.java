
public class Ajedrez {

	public static void main(String[] args) {
		// Colores de las casillas B&N
		final String CASILLA_NEGRA = "\u2588";
		final String CASILLA_BLANCA = "\u2591";
		// Lineas de la parte de arriba
		final String ARRIBA_IZQUIERDA = "\u250C";
		final String ARRIBA = "\u252C";
		final String ARRIBA_DERECHA = "\u2510";
		// Lineas intermedias
		final String HORIZONTAL = "\u2500";
		final String VERTICAL = "\u2502";
		final String IZQUIERDA = "\u251C";
		final String CENTRO = "\u253C";
		final String DERECHA = "\u2524";
		// Lineas de la parte de abajo
		final String ABAJO_IZQUIERDA = "\u2514";
		final String ABAJO = "\u2534";
		final String ABAJO_DERECHA = "\u2518";
		// Primera fila superior. Fila 8 parte de arriba
		System.out.print(ARRIBA_IZQUIERDA + HORIZONTAL );        
		System.out.print( HORIZONTAL + ARRIBA + HORIZONTAL);
		System.out.print( HORIZONTAL + ARRIBA + HORIZONTAL);
		System.out.print( HORIZONTAL + ARRIBA + HORIZONTAL);
		System.out.print( HORIZONTAL + ARRIBA + HORIZONTAL);
		System.out.print( HORIZONTAL + ARRIBA + HORIZONTAL);
		System.out.print( HORIZONTAL + ARRIBA + HORIZONTAL);
		System.out.print( HORIZONTAL + ARRIBA + HORIZONTAL);
		System.out.println(HORIZONTAL + ARRIBA_DERECHA);
		// Ultima fila inferior Fila 1. Fila de abajo
		/*System.out.print(ABAJO_IZQUIERDA + HORIZONTAL );
		System.out.print( HORIZONTAL + ABAJO + HORIZONTAL);
		System.out.print( HORIZONTAL + ABAJO + HORIZONTAL);
		System.out.print( HORIZONTAL + ABAJO + HORIZONTAL);
		System.out.print( HORIZONTAL + ABAJO + HORIZONTAL);
		System.out.print( HORIZONTAL + ABAJO + HORIZONTAL);
		System.out.print( HORIZONTAL + ABAJO + HORIZONTAL);
		System.out.print( HORIZONTAL + ABAJO + HORIZONTAL);
		System.out.print(HORIZONTAL + ABAJO_DERECHA);
		// Relleno fila 8
		System.out.print(VERTICAL + CASILLA_BLANCA);
		System.out.print(CASILLA_NEGRA + VERTICAL + CASILLA_BLANCA);
		System.out.print(CASILLA_NEGRA + VERTICAL + CASILLA_BLANCA);
		System.out.print(CASILLA_NEGRA + VERTICAL + CASILLA_BLANCA);
		System.out.print(CASILLA_NEGRA + VERTICAL + CASILLA_BLANCA);
		System.out.print(CASILLA_NEGRA + VERTICAL + CASILLA_BLANCA);
		System.out.print(CASILLA_NEGRA + VERTICAL + CASILLA_BLANCA);
		System.out.print(CASILLA_NEGRA + VERTICAL + CASILLA_BLANCA);
		System.out.println(CASILLA_NEGRA + VERTICAL);
		// Segunda fila superior Fila 7
		System.out.print(IZQUIERDA + HORIZONTAL);
		System.out.print(HORIZONTAL + CENTRO + HORIZONTAL);
		System.out.print(HORIZONTAL + CENTRO + HORIZONTAL);
		System.out.print(HORIZONTAL + CENTRO + HORIZONTAL);
		System.out.print(HORIZONTAL + CENTRO + HORIZONTAL);
		System.out.print(HORIZONTAL + CENTRO + HORIZONTAL);
		System.out.print(HORIZONTAL + CENTRO + HORIZONTAL);
		System.out.print(HORIZONTAL + CENTRO + HORIZONTAL);
		System.out.println(HORIZONTAL + DERECHA);*/
	}

}
