package unidad8.colecciones;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Ejercicio3 {

	public static void main(String[] args) {
		// para aceptar el texto por teclado
		System.out.println("Por favor, introduzca el texto a procesar:");
		Scanner entrada = new Scanner(System.in);
		String texto = entrada.nextLine();
		entrada.close();
		// paso las palabras a un array
		String[] palabras = texto.split(" ");
		// conjunto tendrá todas las palabras, repetidas o no
		Set<String> conjunto = new LinkedHashSet<String>();
		// repetidas tendrá sólo las palabras repetidas
		Set<String> repetidas = new LinkedHashSet<String>();
		// por cada palabra en el array:
		for (String palabra : palabras) {
			if (!conjunto.contains(palabra)) // si no está contenida ya en conjunto,
				conjunto.add(palabra); // la añado,
			else // y si ya está,
				repetidas.add(palabra); // la añado a repetidas
		} // fin for
		// la diferencia entre conjuntos serán las palabras no repetidas
		conjunto.removeAll(repetidas);
		// imprimo los resultados
		System.out.println("Palabras repetidas: " + repetidas);
		System.out.println("Palabras únicas: " + conjunto);
	}

}
