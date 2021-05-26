package unidad8.colecciones;

import java.util.Map;
import java.util.TreeMap;

public class Palabras {
	// para almacenar las palabras, sin repeticiones y con su longitud
	private static Map<String, Integer> contenido = new TreeMap<String, Integer>();

	// CONSTRUCTORES
	// constructor vacío
	public Palabras() {

	}

	// constructor con cadena de caracteres
	public Palabras(String entrada) {
		for (String palabra : entrada.split(" "))
			contenido.put(palabra, palabra.length());
	}

	// constructor con array de String
	public Palabras(String[] entrada) {
		for (String palabra : entrada)
			contenido.put(palabra, palabra.length());
	}

	// MÉTODOS
	// añadir servirá tanto si la variable palabras contiene
	// una sola palabra como si contiene varias
	public void añadir(String entrada) {
		for (String palabra : entrada.split(" "))
			contenido.put(palabra, palabra.length());
	}

	// lo sobrecargo para usar también arrays
	public void añadir(String[] entrada) {
		for (String palabra : entrada)
			contenido.put(palabra, palabra.length());
	}

	// para buscar una palabra
	public boolean buscar(String palabra) {
		return contenido.containsKey(palabra);
	}

	// para borrar todas las palabras:
	// sin añadir nuevas palabras
	public void borrar() {
		contenido.clear();
	}

	// añadiendo nuevas palabras
	public void borrar(String entrada) {
		contenido.clear();
		añadir(entrada);
	}

	// para listar palabras de una longitud concreta
	public void lista(int letras) {
		// si hay palabras de esa longitud
		if (contenido.containsValue(letras)) {
			contenido.forEach((palabra, caracteres) -> {
				if (caracteres == letras)
					System.out.println(palabra);
			});
		} else
			System.out.println("No hay palabras de esa longitud.");
	}
}
