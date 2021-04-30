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
		// para informar de si existe
		existe(comprobar);
		// para informar sobre si es un fichero o un directorio
		// y sobre su tamaño en el caso de ser un fichero
		ficheroDirectorio(comprobar);
		// para informar sobre su nombre y los permisos de lectura y escritura
		permisos(comprobar);
		// cierro el escáner
		entrada.close();
	} // fin main

	private static void existe(File archivo) {
		String existe = "";
		if (!archivo.exists())
			existe = "no ";
		System.out.println("La ruta " + archivo.getAbsolutePath() + " hace referencia a un fichero o directorio que "
				+ existe + "existe.");
	} // fin existe

	private static void ficheroDirectorio(File archivo) {
		if (archivo.exists()) {
			String ficheroDirectorio = "";
			if (archivo.isFile())
				ficheroDirectorio = "fichero de " + archivo.length() + " bytes de tamaño.";
			if (archivo.isDirectory())
				ficheroDirectorio = "directorio.";
			System.out.println("La ruta " + archivo.getAbsolutePath() + " hace referencia a un " + ficheroDirectorio);
		} // fin if
	} // fin ficheroDirectorio
	
	private static void permisos(File archivo) {
		// para completar el texto mostrado
		String tipo = "";
		if (archivo.isFile()) tipo = "archivo";
		if (archivo.isDirectory()) tipo = "directorio";
		// para mostrar los permisos y el nombre
		if (archivo.canRead() && archivo.canWrite()) System.out.println("Tiene permisos de acceso y escritura sobre el " + tipo + " de nombre " + archivo.getName());
		if (archivo.canRead() && !archivo.canWrite()) System.out.println("Tiene permiso de acceso pero no de escritura sobre el " + tipo + " de nombre " + archivo.getName());
		if (!archivo.canRead() && !archivo.canWrite()) System.out.println("No tiene permiso ni de acceso ni de escritura sobre el " + tipo + " de nombre " + archivo.getName());
	} // fin permisos
} // fin clase
