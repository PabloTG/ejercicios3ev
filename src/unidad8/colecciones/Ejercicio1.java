package unidad8.colecciones;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Ejercicio1 {
	public static void main(String[] args) {
		// elementos necesarios para realizar la operaci�n
		int numero = 0;
		Set<String> nombres = new LinkedHashSet<String>();
		Scanner entrada = new Scanner(System.in);
		System.out.println("�Cu�ntos nombres va a introducir?");
		numero = entrada.nextInt();
		if (numero > 0) {
			System.out.println("Por favor, introduzca los nombres: ");
			for (int i = 1; i <= numero; i++) {
				nombres.add(entrada.next());
			} // fin for entrada
			System.out.println("Estos son los nombres sin repeticiones: ");
			for (String nombre : nombres)
				System.out.println(nombre);
		} // fin if
		else
			System.out.println("No se pueden ordenar cero nombres o un n�mero negativo de nombres");
		entrada.close();
	} // fin main
} // fin clase