package jcolonia.daw2021.mayo;

import java.util.Scanner;


/**
 * Clase VistaSuma.
 * @author Fernando Gómez
 * @since java 11
 * @version 1.2
 */

/*Otro comentario para GitHub de otra clase*/

public class VistaSuma extends Vista{

	/**
	 * Constructor de la clase
	 *
	 * @param título texto a mostrar al elegir la opción
	 * @param scEntrada datos por parametro del usuario
	 */
	public VistaSuma(String título, Scanner scEntrada) {
		super(título, scEntrada);
	}

	/**
	 * Obtiene la lista con el resultado de la suma.
	 *
	 * @param conjunto lista con doubles
	 */
	public void obtenerResuladoSuma(ListaNúmeros conjunto) {
		System.out.printf(conjunto.toString());		
	}

}
