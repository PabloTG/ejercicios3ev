package unidad8.colecciones;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ejercicio5 {

	public static void main(String[] args) {
		// números que harán falta
		int n, k, x;
		// para almacenar los números
		Queue<Integer> cola = new LinkedList<Integer>();
		// para almacenar los números mientras los compruebo
		Queue<Integer> auxiliar = new LinkedList<Integer>();
		// para buscar el número menor si hace falta
		int cabeza, menor;
		boolean encontrado = false;
		// para aceptar los números por teclado
		Scanner entrada = new Scanner(System.in);
		// inicializo los números
		try {
			n = entrada.nextInt();
			k = entrada.nextInt();
			x = entrada.nextInt();
			// añado los números declarados a la cola
			for (int i = 1; i <= n; i++) {
				cola.offer(entrada.nextInt());
			} // fin for entrada
				// retiro los números declarados de la cola
			for (int i = 1; i <= k; i++) {
				cola.poll();
			} // fin for salida
				// compruebo si X está en la cola:
				// si ya no hay números, lo anuncio
			if (cola.size() == 0)
				System.out.println("0");
			// si aún hay números,
			else {
				// por cada número aún en cola:
				for (int i = 0; i < cola.size(); i++) {
					cabeza = cola.poll(); // lo saco de la cola,
					if (cabeza == x) { // si es el número que busco,
						System.out.println("true"); // lo anuncio,
						encontrado = true; // y evito la búsqueda del menor
					} // fin encontrado
					else // si no lo es,
						auxiliar.add(cabeza); // lo añado a la cola auxiliar para luego buscar el más pequeño
				} // fin for comprobar
					// si X no estaba aún en la cola, busco el número más pequeño:
				if (!encontrado) {
					// cojo el primer número como referencia,
					menor = auxiliar.poll();
					for (int i = 0; i < auxiliar.size(); i++) { // por cada número en auxiliar,
						cabeza = auxiliar.poll(); // lo tomo,
						if (cabeza < menor)
							menor = cabeza; // y si es menor que la referencia lo almaceno
					} // fin for buscar menor
						// muestro el menor número aún en la lista
					System.out.println(menor);
				} // fin if no encontrado
			} // fin else quedan números
		} // fin try
		catch (InputMismatchException ime) {
			System.err.println("Este ejercicio sólo acepta números enteros.");
		} // fin catch
		finally { // pase lo que pase, cierro el escáner
			entrada.close();
		}
	} // fin main
} // fin clase
