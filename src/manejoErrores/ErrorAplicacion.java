package manejoErrores;
/**
 * 
 *Clase definida para llevar el control de los errores presentes en
 *la ejecuci�n del programa 
 *
 */
@SuppressWarnings("serial")
public class ErrorAplicacion extends Exception {
	
	public ErrorAplicacion() {
		super("Manejo de errores de la aplicacion: ");
	}
}
