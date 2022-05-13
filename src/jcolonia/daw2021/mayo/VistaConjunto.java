package jcolonia.daw2021.mayo;

import java.util.Scanner;

public class VistaConjunto extends Vista{

	public VistaConjunto(String título, Scanner scEntrada) {
		super(título, scEntrada);		
	}

	public void mostrarListado(ListaNúmeros conjunto) {
		
		
		for(int i =0;i<conjunto.getNúmSumandos();i++) {
			System.out.printf("%3.d → %f\n",i+1,conjunto.toListaString().get(i) );
		}
	}
	
}
