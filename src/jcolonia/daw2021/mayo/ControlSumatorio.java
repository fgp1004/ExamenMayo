package jcolonia.daw2021.mayo;

import java.util.Scanner;

/**
 * GestiÃ³n de nÃºmeros Â«decimalesÂ»: recogida y visualizaciÃ³n de la suma.
 * 
 * @versiÃ³n 2022.3.1
 * @author <a href="dmartin.jcolonia@gmail.com">David H. MartÃ­n</a>
 * 
 */

/*Esto es un ejemplo del uso de commits para GitHub*/

public class ControlSumatorio {
	/**
	 * Texto identificativo de las funciones de la aplicaciÃ³n que aparecerÃ¡n en el
	 * menÃº principal.
	 */
	private static final String[] OPCIONES_MENÃš_PRINCIPAL = { "Agregar valor", "Mostrar valores", "Mostrar suma",
			"Restablecer", "SALIR" };

	/**
	 * TÃ­tulo de la aplicaciÃ³n. Se mostrarÃ¡ como encabezado del menÃº principal.
	 */
	private static final String TÃ�TULO_MENÃš_PRINCIPAL = "Sumatorio";

	/**
	 * Recurso asociado a la entrada estÃ¡ndar de la aplicaciÃ³n. Debe ser un objeto
	 * Ãºnico a compartir con las diferentes vistas creadas.
	 */
	private Scanner entrada;

	private ListaNÃºmeros conjunto;

	private VistaMenÃºBÃ¡sico menÃºPrincipal;

	public ControlSumatorio(Scanner in) {
		this.entrada = in;
		conjunto = new ListaNÃºmeros();
	}

	private void buclePrincipal() throws SumatorioNumberException {
		int opciÃ³nElegida;
		boolean fin = false;

		menÃºPrincipal = new VistaMenÃºBÃ¡sico(TÃ�TULO_MENÃš_PRINCIPAL, entrada, OPCIONES_MENÃš_PRINCIPAL);

		// Bucle general
		do {
			menÃºPrincipal.mostrarTÃ­tulo1();
			menÃºPrincipal.mostrarOpciones();
			opcionElegida = menuPrincipal.pedirOpcion();
			switch (opcionElegida) {
			case 5: // SALIR
				fin = true;
				Vista.mostrarAviso("Â¡Â¡Â¡A-D-I-O-S!!");
				break;
			case 1: // OpciÃ³n 1: Entrada datos
				cargarSumando();
				break;
			case 2: // OpciÃ³n 2: Mostrar sumandos
				mostrarSumandos();
				break;
			case 3: // OpciÃ³n 3: Mostrar suma
				mostrarSuma();
				break;
			case 4: // OpciÃ³n 4: Reset
				restablecer();
				break;
			default: // OpciÃ³n no esperada: abortar
				ejecutarGenÃ©rico(opciÃ³nElegida);
				System.err.println("Error interno de programa - operaciÃ³n pendiente de desarrollo");
				System.exit(1);
			}
		} while (!fin);
	}


	/**
	 * AÃ±ade valores tipo double a la lista 
	 * 
	 * @throws SumatorioNumberException
	 */
	private void cargarSumando() throws SumatorioNumberException {
		VistaAgregar aÃ±adir=new VistaAgregar("Introduzca un nuevo valor",entrada);
		double numeroAÃ±adir=0.0;
		double numeroAÃ±adido;			
		
		numeroAÃ±adido=aÃ±adir.agregarValor(numeroAÃ±adir);
		conjunto.add(numeroAÃ±adido);
	}
	
	
	/**
	 * Muestra la lista con los valores
	 */
	private void mostrarSumandos() {
		VistaConjunto listaSumandos=new VistaConjunto("Texto orientativo", entrada);
		listaSumandos.mostrarListado(conjunto);
	}
	
	
	/**
	 * Muestra de manera ordenada el contenido de la lista y el resultado final
	 */
	private void mostrarSuma() {
		VistaSuma sumatorio=new VistaSuma("", entrada);
		sumatorio.obtenerResuladoSuma(conjunto);
	}
	
	/**
	 * Inicializa la lista para eliminar el contenido de antes
	 */
	private void restablecer() {
		conjunto = new ListaNÃºmeros();
	}
	
	/**
	 * Muestra un texto indicando la opciÃ³n elegida por el usuario
	 * 
	 * @param id
	 */
	private void ejecutarGenÃ©rico(int id) {
		String mensaje;
		mensaje = String.format("%n  Ha elegido la opciÃ³n %d: Â«%sÂ»", id, OPCIONES_MENÃš_PRINCIPAL[id - 1]);
		Vista.mostrarTexto(mensaje);
	}
	
	
	/**
	 * MÃ©todo main 
	 * 
	 * @param args
	 * @throws SumatorioNumberException
	 */
	public static void main(String[] args) throws SumatorioNumberException {
		Scanner entrada = new Scanner(System.in);

		ControlSumatorio control = new ControlSumatorio(entrada);
		control.buclePrincipal();
		entrada.close();
	}
}
