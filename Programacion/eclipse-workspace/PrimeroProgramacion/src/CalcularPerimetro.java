
public class CalcularPerimetro {
	
    public static void main(String[] args) {
        //Definir el radio del círculo
        double radio = 4;
        
        //Calcular el perímetro utilizando la fórmula
        double perimetro = 2 * Math.PI * radio;
        
        //Mostrar el resultado
        System.out.println("El perímetro del círculo con radio " + radio + " es: " + perimetro);
    }
}