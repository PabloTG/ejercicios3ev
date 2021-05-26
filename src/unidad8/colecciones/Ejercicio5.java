package unidad8.colecciones;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ejercicio5 {

	public static void main(String[] args) {
		// n�meros que har�n falta
		int n, k, x;
		// para almacenar los n�meros
		Queue<Integer> cola = new LinkedList<Integer>();
		// para almacenar los n�meros mientras los compruebo
		Queue<Integer> auxiliar = new LinkedList<Integer>();
		// para buscar el n�mero menor si hace falta
		int cabeza, menor;
		boolean encontrado = false;
		// para aceptar los n�meros por teclado
		Scanner entrada = new Scanner(System.in);
		// inicializo los n�meros
		try {
			n = entrada.nextInt();
			k = entrada.nextInt();
			x = entrada.nextInt();
			// a�ado los n�meros declarados a la cola
			for (int i = 1; i <= n; i++) {
				cola.offer(entrada.nextInt());
			} // fin for entrada
				// retiro los n�meros declarados de la cola
			for (int i = 1; i <= k; i++) {
				cola.poll();
			} // fin for salida
				// compruebo si X est� en la cola:
				// si ya no hay n�meros, lo anuncio
			if (cola.size() == 0)
				System.out.println("0");
			// si a�n hay n�meros,
			else {
				// por cada n�mero a�n en cola:
				for (int i = 0; i < cola.size(); i++) {
					cabeza = cola.poll(); // lo saco de la cola,
					if (cabeza == x) { // si es el n�mero que busco,
						System.out.println("true"); // lo anuncio,
						encontrado = true; // y evito la b�squeda del menor
					} // fin encontrado
					else // si no lo es,
						auxiliar.add(cabeza); // lo a�ado a la cola auxiliar para luego buscar el m�s peque�o
				} // fin for comprobar
					// si X no estaba a�n en la cola, busco el n�mero m�s peque�o:
				if (!encontrado) {
					// cojo el primer n�mero como referencia,
					menor = auxiliar.poll();
					for (int i = 0; i < auxiliar.size(); i++) { // por cada n�mero en auxiliar,
						cabeza = auxiliar.poll(); // lo tomo,
						if (cabeza < menor)
							menor = cabeza; // y si es menor que la referencia lo almaceno
					} // fin for buscar menor
						// muestro el menor n�mero a�n en la lista
					System.out.println(menor);
				} // fin if no encontrado
			} // fin else quedan n�meros
		} // fin try
		catch (InputMismatchException ime) {
			System.err.println("Este ejercicio s�lo acepta n�meros enteros.");
		} // fin catch
		finally { // pase lo que pase, cierro el esc�ner
			entrada.close();
		}
	} // fin main
} // fin clase
