package Excepciones;

import java.beans.Statement;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Excepciones {

	// Checked Exceptions
	
	// Entrada / Salida
	public void manejarIOException() {
        try (BufferedReader reader = new BufferedReader(new FileReader("archivo_inexistente.txt"))) {
            System.out.println(reader.readLine());
        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el archivo: " + e.getMessage());
        }
    }

	// File que no existe
    public void manejarFileNotFoundException() {
        try (FileInputStream fis = new FileInputStream("archivo_no_existente.txt")) {
            System.out.println("Archivo abierto correctamente.");
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        }
    }

    // Unchecked Exceptions

    // Objeto null
    public void manejarNullPointerException() {
        String texto = null;
        try {
            System.out.println(texto.length());
        } catch (NullPointerException e) {
            System.out.println("Ocurrió un NullPointerException: " + e.getMessage());
        }
    }

    // Indice fuera del rango del Array
    public void manejarArrayIndexOutOfBoundsException() {
        int[] numeros = {1, 2, 3};
        try {
            System.out.println(numeros[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Índice fuera de rango: " + e.getMessage());
        }
    }

    // Error en Scanner
    public void manejarInputMismatchException() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce un número entero: ");
        try {
            int numero = scanner.nextInt();
            System.out.println("Número ingresado: " + numero);
        } catch (InputMismatchException e) {
            System.out.println("Tipo de dato incorrecto. Por favor, introduce un número entero.");
        } finally {
            scanner.close();
        }
    }

    // División aritmética
    public void manejarArithmeticException() {
        try {
            int resultado = 10 / 0;
            System.out.println("Resultado: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("Error aritmético: " + e.getMessage());
        }
    }

    // Conversión de cadena a número en formato no válido
    public void manejarNumberFormatException() {
    	// De cadena a número
        String numeroTexto = "123abc";
        try {
            int numero = Integer.parseInt(numeroTexto);
            System.out.println("Número convertido: " + numero);
        } catch (NumberFormatException e) {
            System.out.println("Formato de número incorrecto: " + e.getMessage());
        }

     // De número a cadena (simulación de excepción)
        Integer numero = null;
        try {
            String texto = String.valueOf(numero); // Esto convierte null a "null"
            System.out.println("Número convertido a cadena: " + texto);
        } catch (Exception e) {
            System.out.println("Ocurrió un error al convertir el número a cadena: " + e.getMessage());
        }
    }

    // Manejo de Ficheros

    public void crearArchivoTexto() {
        try (FileWriter writer = new FileWriter("archivo.txt")) {
            writer.write("Hola, mundo!\n");
            writer.write("Este es un archivo de texto.");
            System.out.println("Archivo creado y datos escritos correctamente.");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al escribir en el archivo: " + e.getMessage());
        }
    }

    public void leerArchivoTexto() {
        try (BufferedReader reader = new BufferedReader(new FileReader("archivo.txt"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el archivo: " + e.getMessage());
        }
    }


    public void eliminarArchivo() {
        File archivo = new File("archivo.txt");
        if (archivo.delete()) {
            System.out.println("Archivo eliminado correctamente.");
        } else {
            System.out.println("No se pudo eliminar el archivo.");
        }
    }
	
}
