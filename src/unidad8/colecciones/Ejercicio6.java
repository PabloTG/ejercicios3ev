package unidad8.colecciones;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class Ejercicio6 {

	// Nota: asumo que cada número es único y que los comandos serán correctos

	public static void main(String[] args) {
		// para contener los datos
		Map<Integer, String> agenda = new TreeMap<Integer, String>();
		// para aceptar comandos
		Scanner entrada = new Scanner(System.in);
		// para terminar el programa
		boolean salir = false;
		try { // uso un bloque try/catch por si hay problemas con la entrada de datos
			do {
				// muestro el prompt
				System.out.println("> ");
				// acepto el comando
				String[] comando = entrada.nextLine().split(":");
				
				// si el comando introducido es "salir", cierro el bucle
				if (comando[0].trim().equals("salir"))
					salir = true;
				
				// si el comando introducido es "contactos", muestro los nombres:
				else if (comando[0].trim().equals("contactos")) {
					// los almaceno en un TreeSet para que estén ordenados,
					TreeSet<String> contactos = new TreeSet<>();
					for (String nombre : agenda.values())
						contactos.add(nombre);
					// y los imprimo
					for (String nombre : contactos)
						System.out.println(nombre);
				} // fin if contactos
				
				// si el comando es "eliminar", busco el nombre proporcionado:
				else if (comando[0].trim().equals("eliminar")) {
					// si no existe, lo anuncio,
					if (!agenda.containsValue(comando[1].trim()))
						System.out.println("No existe un contacto con ese nombre.");
					// y si existe, borro todas las entradas asociadas a él
					else {
						// como un contacto puede tener más de un número asociado,
						// para no provocar una ConcurrentModificationException
						// borrándolos con un bucle o un iterador mediante remove():
						// declaro un nuevo mapa,
						Map<Integer, String> auxiliar = new TreeMap<Integer, String>();
						// lo lleno con los contactos que no quiero borrar,
						agenda.forEach((numero, nombre) -> {
							if (!nombre.equals(comando[1].trim()))
								auxiliar.put(numero, nombre);
						});
						// borro agenda,
						agenda.clear();
						// y la relleno con los contactos conservados
						auxiliar.forEach((numero, nombre) -> agenda.put(numero, nombre));
					} // fin else interno eliminar
				} // fin if eliminar
				
					// si el comando es "buscar", busco el nombre proporcionado:
				else if (comando[0].trim().equals("buscar")) {
					// si no existe, lo anuncio
					if (!agenda.containsValue(comando[1].trim()))
						System.out.println("No existe un contacto con ese nombre.");
					// y si existe, muestro los números asociados a él:
					else {
						// declaro un mapa auxiliar para contener los resultados,
						Map<Integer, String> auxiliar = new TreeMap<Integer, String>();
						// vuelco los resultados al mapa auxiliar,
						agenda.forEach((numero, nombre) -> {
							if (nombre.equals(comando[1].trim()))
								auxiliar.put(numero, nombre);
						});
						// e itero los resultados para no imprimir una coma al final
						Iterator<Entry<Integer, String>> iterador = auxiliar.entrySet().iterator();
						String imprimir = iterador.next().getKey().toString();
						while (iterador.hasNext())
							imprimir += ", " + iterador.next().getKey();
						System.out.println(imprimir);
					} // fin else interno buscar
				} // fin if buscar
				
				else {
					// si no es uno de los comandos anteriores, añado una entrada a la agenda
					String valorViejo = agenda.put(Integer.parseInt(comando[1].trim()), comando[0]);
					// si el valor anterior es igual que el nuevo, lo anuncio
					if (valorViejo != null && valorViejo.equals(comando[0].trim()))
						System.out.println("Ese contacto ya tiene asociado ese número.");
				} // fin else añadir
			} while (!salir); // fin do
		} // fin try
		catch (Exception e) {
			System.err.println("Ha ocurrido un error: " + e.toString());
		} finally {
			entrada.close(); // cierro el escáner
		}
	} // fin main
} // fin clase
