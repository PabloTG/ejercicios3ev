package unidad8.colecciones;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Ejercicio7 {
	public static void main(String[] args) {
		// atributos
		int m = 0, n = 0;
		Set<Integer> conjuntoUno = new HashSet<Integer>(), conjuntoDos = new HashSet<Integer>();
		Scanner entrada = new Scanner(System.in);
		// acepto el tamaño de los conjuntos
		m = entrada.nextInt();
		n = entrada.nextInt();
		// añado números a los conjuntos
		for (int i = 1; i <= m; i++)
			conjuntoUno.add(entrada.nextInt());
		for (int i = 1; i <= n; i++)
			conjuntoDos.add(entrada.nextInt());
		// cierro el escáner
		entrada.close();
		// compruebo los números en común entre los conjuntos
		conjuntoUno.retainAll(conjuntoDos);
		// y los imprimo
		System.out.println(conjuntoUno);
	} // fin main
} // fin clase
