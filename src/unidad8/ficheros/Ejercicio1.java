package unidad8.ficheros;

import java.io.File;
import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		// solicito la ruta a comprobar
		System.out.println("Por favor, introduzca la ruta a comprobar: ");
		// acepto la ruta por teclado
		Scanner entrada = new Scanner(System.in);
		String ruta = entrada.nextLine();
		// paso la ruta a una variable File para manejarla
		File comprobar = new File(ruta);
		// para informar si no existe
		if (!comprobar.exists())
			System.out.println("La ruta " + comprobar.getAbsolutePath()
					+ " no hace referencia a un archivo o directorio existente.");
		// si existe, se comprueba el resto
		else {
			// para informar sobre si es un fichero o un directorio
			// y sobre su tamaño en el caso de ser un fichero
			ficheroDirectorio(comprobar);
			// para informar sobre su nombre y los permisos de lectura y escritura
			permisos(comprobar);
		} // fin if
			// cierro el escáner
		entrada.close();
	} // fin main

	private static void ficheroDirectorio(File archivo) {
		// declaro una cadena de caracteres para completar el texto
		String ficheroDirectorio = "";
		// si es un archivo, lo anuncio junto con su tamaño
		if (archivo.isFile())
			ficheroDirectorio = "fichero de " + archivo.length() + " bytes de tamaño.";
		// si es un directorio, lo anuncio
		if (archivo.isDirectory())
			ficheroDirectorio = "directorio.";
		// muestro el resultado por pantalla
		System.out.println("La ruta " + archivo.getAbsolutePath() + " hace referencia a un " + ficheroDirectorio);
	} // fin ficheroDirectorio

	private static void permisos(File archivo) {
		// para completar el texto mostrado
		String tipo = "";
		if (archivo.isFile())
			tipo = "archivo";
		if (archivo.isDirectory())
			tipo = "directorio";
		// para mostrar los permisos y el nombre
		if (archivo.canRead() && archivo.canWrite())
			System.out.println(
					"Tiene permisos de lectura y escritura sobre el " + tipo + " de nombre " + archivo.getName());
		if (archivo.canRead() && !archivo.canWrite())
			System.out.println("Tiene permiso de lectura pero no de escritura sobre el " + tipo + " de nombre "
					+ archivo.getName());
		if (!archivo.canRead() && archivo.canWrite())
			System.out.println("Tiene permiso de escritura pero no de lectura sobre el " + tipo + " de nombre "
					+ archivo.getName());
		if (!archivo.canRead() && !archivo.canWrite())
			System.out.println("No tiene permiso ni de lectura ni de escritura sobre el " + tipo + " de nombre "
					+ archivo.getName());
	} // fin permisos
} // fin clase
