package manejoErrores;

/**
 * 
 * Clase que controla los errores relacionados a la funcionalidad de examinar
 * los cultivos en busca de posibles amenazas, o despedir personal. Maneja el
 * caso en el que no se presente ningún agronomo en determinado terreno para que
 * pueda encargarse de examinar los cultivos del terreno asociado.
 *
 */
public class NoHayAgronomoException extends PersonasException {

	private String mensaje;

	public NoHayAgronomoException(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}
}
