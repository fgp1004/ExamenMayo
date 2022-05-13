package jcolonia.daw2021.mayo;

import java.util.Scanner;

/**
 * Gestión de números «decimales»: recogida y visualización de la suma.
 * 
 * @versión 2022.3.1
 * @author <a href="dmartin.jcolonia@gmail.com">David H. Martín</a>
 * 
 */
public class ControlSumatorio {
	/**
	 * Texto identificativo de las funciones de la aplicación que aparecerán en el
	 * menú principal.
	 */
	private static final String[] OPCIONES_MENÚ_PRINCIPAL = { "Agregar valor", "Mostrar valores", "Mostrar suma",
			"Restablecer", "SALIR" };

	/**
	 * Título de la aplicación. Se mostrará como encabezado del menú principal.
	 */
	private static final String TÍTULO_MENÚ_PRINCIPAL = "Sumatorio";

	/**
	 * Recurso asociado a la entrada estándar de la aplicación. Debe ser un objeto
	 * único a compartir con las diferentes vistas creadas.
	 */
	private Scanner entrada;

	private ListaNúmeros conjunto;

	private VistaMenúBásico menúPrincipal;

	public ControlSumatorio(Scanner in) {
		this.entrada = in;
		conjunto = new ListaNúmeros();
	}

	private void buclePrincipal() throws SumatorioNumberException {
		int opciónElegida;
		boolean fin = false;

		menúPrincipal = new VistaMenúBásico(TÍTULO_MENÚ_PRINCIPAL, entrada, OPCIONES_MENÚ_PRINCIPAL);

		// Bucle general
		do {
			menúPrincipal.mostrarTítulo1();
			menúPrincipal.mostrarOpciones();
			opciónElegida = menúPrincipal.pedirOpción();
			switch (opciónElegida) {
			case 5: // SALIR
				fin = true;
				Vista.mostrarAviso("¡¡¡A-D-I-O-S!!");
				break;
			case 1: // Opción 1: Entrada datos
				cargarSumando();
				break;
			case 2: // Opción 2: Mostrar sumandos
				mostrarSumandos();
				break;
			case 3: // Opción 3: Mostrar suma
				mostrarSuma();
				break;
			case 4: // Opción 4: Reset
				restablecer();
				break;
			default: // Opción no esperada: abortar
				ejecutarGenérico(opciónElegida);
				System.err.println("Error interno de programa - operación pendiente de desarrollo");
				System.exit(1);
			}
		} while (!fin);
	}


	/**
	 * Añade valores tipo double a la lista 
	 * 
	 * @throws SumatorioNumberException
	 */
	private void cargarSumando() throws SumatorioNumberException {
		VistaAgregar añadir=new VistaAgregar("Introduzca un nuevo valor",entrada);
		double numeroAñadir=0.0;
		double numeroAñadido;			
		
		numeroAñadido=añadir.agregarValor(numeroAñadir);
		conjunto.add(numeroAñadido);
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
		conjunto = new ListaNúmeros();
	}
	
	/**
	 * Muestra un texto indicando la opción elegida por el usuario
	 * 
	 * @param id
	 */
	private void ejecutarGenérico(int id) {
		String mensaje;
		mensaje = String.format("%n  Ha elegido la opción %d: «%s»", id, OPCIONES_MENÚ_PRINCIPAL[id - 1]);
		Vista.mostrarTexto(mensaje);
	}
	
	
	/**
	 * Método main 
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
