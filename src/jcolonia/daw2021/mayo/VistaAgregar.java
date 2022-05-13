package jcolonia.daw2021.mayo;

import java.util.Scanner;


/**
 * Clase VistaAgregar.
 * @author Fernando Gómez
 * @since java 11
 * @version 1.2
 */
public class VistaAgregar extends Vista {

	/**
	 * Constructor de la clase 
	 *
	 * @param título texto a mostrar al elegir la opción
	 * @param scEntrada datos por parametro del usuario
	 */
	public VistaAgregar(String título, Scanner scEntrada) {
		super(título, scEntrada);		
	}

	/**
	 * Agrega un valor a la lista
	 *
	 * @param valoresLista the valores lista
	 * @return the double
	 */
	public double agregarValor(Double valoresLista) {
		String líneaTexto="";
		double líneaNumeroGrande=0.0;
		boolean seguir=true;
		
		while(seguir) {
			try {
				System.out.println("\nIntroduzca un nuevo valor: ");
				líneaTexto = getEntrada().nextLine();
				if(líneaTexto.equals("")){
					System.out.println("Campo vacío");
				}else {	
					líneaNumeroGrande = Double.parseDouble(líneaTexto);
					seguir=false;
					System.out.println("\t→Se ha agregado un nuevo valor");
				}
			}catch(Exception ex) {
				System.err.printf("El valor «%s» no es válido%n", líneaNumeroGrande);
			}
			
		}
		return líneaNumeroGrande;
	}
	
}
