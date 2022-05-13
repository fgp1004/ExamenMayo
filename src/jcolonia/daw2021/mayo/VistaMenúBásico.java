package jcolonia.daw2021.mayo;

import static java.lang.System.out;

import java.util.Scanner;


/**
 * Clase VistaMenúBásico.
 *
 * @author Fernando Gómez
 * @version 1.2
 * @since java 11
 */
public class VistaMenúBásico extends Vista{

	/** Opciones del menú principal. */
	private String[] opcionesMenúPrincipal;

	/**
	 * COnstructor de la clase
	 *
	 * @param texto 
	 * @param entrada opción del usuario
	 * @param opcionesMenúPrincipal  opciones del menú 
	 */
	public VistaMenúBásico(String texto, Scanner entrada, String[] opcionesMenúPrincipal) {
		super(texto, entrada);
		this.opcionesMenúPrincipal=opcionesMenúPrincipal;
	}

	/**
	 * Muestra las opciones del menú
	 */
	public void mostrarOpciones() {
		for (int i = 0; i < opcionesMenúPrincipal.length; i++) {
			out.printf("%d) %s\n", i + 1, opcionesMenúPrincipal[i]);
		}
		
	}

	/**
	 * Solicita la opción del menú
	 *
	 * @return número
	 */
	public int pedirOpción() {
		String lineaTexto;
		int número = 0;
		boolean numEsCorrecto = false;
		
		while (!numEsCorrecto) {
			try {
				lineaTexto = getEntrada().nextLine();
				número = Integer.parseInt(lineaTexto);
				if (número < 0 || número > opcionesMenúPrincipal.length) {
					out.println("No ha elegido una opcion valida.");
					throw new NumberFormatException("Valor introducido fuera de rango de opciones.\n");
				} else {
					numEsCorrecto = true;
				}
			} catch (NumberFormatException ex) {
				out.printf("\tNo es una de las opciones validas: «%s»%n", ex.getMessage());
			}
		}

		return número;
	}
	
	

}
