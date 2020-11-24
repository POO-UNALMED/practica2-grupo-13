package manejoErrores;
/**
 * 
 * Clase que permite controlar errores en la funcionalidad de cultivar,
 * en el caso en que el tama�o de lo que se desea cultivar excede el tama�o 
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
