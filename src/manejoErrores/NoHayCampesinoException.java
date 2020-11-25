package manejoErrores;

/**
 * 
 * Clase que controla los errores relacionados a la ejecución de funcionalidades
 * que requieran de campesinos para ser ejecutadas. Funcionalidades como
 * cultivar, cosechar, despedir personal, fertilizar e irrigar, en donde se
 * verifica que hayan campesinos que puedan realizarlas
 *
 */
public class NoHayCampesinoException extends PersonasException {

	private String mensaje;

	public NoHayCampesinoException(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}

}
