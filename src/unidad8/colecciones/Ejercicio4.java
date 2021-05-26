package unidad8.colecciones;

import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		// para almacenar las palabras
		Palabras contenido = new Palabras();
		// para el bucle
		boolean repetir = true;
		// solicito comando
		System.out.println("Introduzca comando:\n> ");
		do {
			// acepto comando
			Scanner entrada = new Scanner(System.in);
			String comando = entrada.nextLine();
			// si el comando empieza por "añadir: ", añado las palabras que sigan
			if (comando.startsWith("añadir: ")) {
				contenido.añadir(comando.substring(8));
				System.out.println("> ");
			}
			// si el comando empieza por "lista ", busco
			// las palabras de la longitud siga
			else if (comando.startsWith("lista ")) {
				contenido.lista(Integer.parseInt(comando.substring(6)));
				System.out.println("> ");
			}
			// si el comando es "borrar", borro las palabras almacenadas
			else if (comando.equals("borrar")) {
				contenido.borrar();
				System.out.println("> ");
			}
			// si el comando empieza por "borrar: ", borro las
			// palabras almacenadas y añado las que sigan
			else if (comando.startsWith("borrar: ")) {
				contenido.borrar(comando.substring(8));
				System.out.println("> ");
			}
			// si el comando es "fin", termino el bucle
			else if (comando.equalsIgnoreCase("fin")) {
				entrada.close();
				repetir = false;
			} else
				System.out.println("\"añadir: \" añade palabras\n\"lista X\" busca palabras " + 
			"de longitud X\n\"borrar\" borra la lista\n\"borrar: \" reemplaza la lista" + 
			"\n\"fin\" finaliza el programa\n\n> ");
		} while (repetir == true);
	} // fin main
} // fin clase
