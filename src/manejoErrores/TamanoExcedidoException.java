package manejoErrores;
/**
 * 
 * Clase que permite controlar errores en la funcionalidad de cultivar,
 * en el caso en que el tamaño de lo que se desea cultivar excede el tamaño 
 * disponible en el terreno en el que se desea ejecutar la funcionalidad
 *
 */
public class TamanoExcedidoException extends DominioException {

	private String mensaje;
	public TamanoExcedidoException(String mensaje) {
		super();
		this.mensaje = mensaje;
	}
	public String getMensaje() {
		return mensaje;
	}
}
