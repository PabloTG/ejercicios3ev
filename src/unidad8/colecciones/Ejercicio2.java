package unidad8.colecciones;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Ejercicio2 {
	public static void main(String[] args) {
		// lista original
		List<Integer> listaOriginal = new ArrayList<Integer>();
		// generador de números aleatorios
		Random generador = new Random();
		// lleno la lista original con números aleatorios entre 1 y 100
		for (int i = 0; i < 100; i++)
			listaOriginal.add(generador.nextInt(100) + 1);
		// copio la lista original a un conjunto sin repeticiones
		Set<Integer> listaSinRepeticiones = new LinkedHashSet<Integer>();
		listaSinRepeticiones.addAll(listaOriginal);
		// copio la lista original en una lista ordenada sin repeticiones
		Set<Integer> listaOrdenada = new HashSet<Integer>();
		listaOrdenada.addAll(listaOriginal);

		// muestro la lista original con un iterador
		System.out.println("Lista original:");
		Iterator<Integer> iterador = listaOriginal.iterator();
		while (iterador.hasNext())
			System.out.print(iterador.next() + "  ");
		
		// muestro la lista sin repeticiones con un for mejorado
		System.out.println("\nLista sin repeticiones:");
		for (int numero : listaSinRepeticiones) System.out.print(numero + "  ");
		
		// muestro la lista ordenada con un forEach()
		System.out.println("\nLista ordenada y sin repeticiones:");
		listaOrdenada.forEach(numero -> System.out.print(numero + "  "));

	} // fin main
} // fin clase
