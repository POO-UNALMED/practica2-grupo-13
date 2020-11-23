package manejoErrores;

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
