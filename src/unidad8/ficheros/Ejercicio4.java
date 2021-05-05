package unidad8.ficheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		// para declarar la ruta del archivo
		String ruta = "";
		// si hay argumento, lo uso
		if (args.length != 0)
			ruta = args[0];
		else { // si no hay argumento, acepto la ruta por teclado:
			Scanner entrada = new Scanner(System.in);
			// la solicito por pantalla,
			System.out.println("Por favor, introduzca la ruta del archivo a procesar: ");
			// la leo del escáner,
			ruta = entrada.next();
			// cierro el escáner
			entrada.close();
		} // fin else

		// variable para manejar el archivo
		File archivo = new File(ruta);
		// variables para contar caracteres, palabras y líneas
		int caracteres = 0;
		int palabras = 0;
		int lineas = 0;
		// variable para almacenar la lectura
		int lectura = 0;
		try { // lectura en bloque try para manejar excepciones
			FileReader leer = new FileReader(archivo);
			// leo un carácter de archivo y lo almaceno en lectura
			lectura = leer.read();
			// si hay caracteres, hay como mínimo una palabra y una línea
			if (lectura != -1) {
				palabras++;
				lineas++;
			} // fin if archivo con contenido
			while (lectura != -1) { // si no es el final del archivo,
				caracteres++; // cuento un carácter
				if (lectura == ' ') // si es un espacio,
					palabras++; // cuento una palabra
				if (lectura == '\n') { // si es un salto de línea,
					lineas++; // cuento una línea y una palabra
					palabras++; // (asumo que un salto de línea empezará una nueva línea con al menos una
								// palabra)
				} // fin if salto de línea
				lectura = leer.read(); // leo el siguiente carácter
			} // fin while
			leer.close(); // cierro el flujo de datos
		} // fin try
		catch (FileNotFoundException fnfe) {
			System.out.println("Archivo no encontrado.");
		} // fin catch FNFE
		catch (IOException ioe) {
			System.out.println("Error E/S.");
		} // fin catch IOE

		// declaro un archivo para manejar la salida
		File salida = new File("contaje.out");
		// abro el flujo de datos al nuevo fichero
		try { // manejo la salida en un bloque try para controlar las excepciones
			FileOutputStream escribir = new FileOutputStream(salida, true);
			// paso los datos a array de bytes
			String texto = "El archivo " + ruta + " contiene " + caracteres + " caracteres, " + palabras
					+ " palabras y " + lineas + " líneas.\n";
			byte[] textoEnBytes = texto.getBytes();
			// escribo los bytes en el archivo (al ser append = true
			// los datos se añadirán en vez de borrar los anteriores)
			escribir.write(textoEnBytes);
			// cierro el flujo de datos
			escribir.close();
			// aviso de que la operación finalizó con éxito
			System.out.println("Archivo contaje.out actualizado");
		} // fin try
		catch (FileNotFoundException fnfe) {
			System.out.println("Archivo no encontrado.");
		} // fin catch FNFE
		catch (IOException ioe) {
			System.out.println("Error E/S.");
		} // fin IOE
	} // fin main
}