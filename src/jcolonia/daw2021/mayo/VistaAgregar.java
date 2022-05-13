package jcolonia.daw2021.mayo;

import java.util.Scanner;

public class VistaAgregar extends Vista {

	public VistaAgregar(String título, Scanner scEntrada) {
		super(título, scEntrada);		
	}

	public double agregarValores(Double valoresLista) {
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
