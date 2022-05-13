package jcolonia.daw2021.mayo;

import java.util.Scanner;

public class VistaSuma extends Vista{

	public VistaSuma(String título, Scanner scEntrada) {
		super(título, scEntrada);
	}

	public void obtenerResuladoSuma(ListaNúmeros conjunto) {
		System.out.printf(conjunto.toString());		
	}

}
