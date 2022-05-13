package jcolonia.daw2021.mayo;

import java.util.Scanner;


/**
 * Clase VistaConjunto.
 * @author Fernando Gómez
 * @since java 11
 * @version 1.2
 */
public class VistaConjunto extends Vista{

	/**
	 * Constructor de la clase
	 *
	 * @param título texto a mostrar al elegir la opción
	 * @param scEntrada datos por parametro del usuario
	 */
	public VistaConjunto(String título, Scanner scEntrada) {
		super(título, scEntrada);		
	}

	/**
	 * Muestra el listado.
	 *
	 * @param conjunto lista de doubles
	 */
	public void mostrarListado(ListaNúmeros conjunto) {
		String valorATexto="";
		
		for(int i =0;i<conjunto.getNúmSumandos();i++) {
			valorATexto=String.format("%s",conjunto.toListaString().get(i));
			System.out.printf("%d → %s\n",i+1,valorATexto);
		}
	}
	
}
