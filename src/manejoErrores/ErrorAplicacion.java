package manejoErrores;

@SuppressWarnings("serial")
public class ErrorAplicacion extends Exception {
	
	public ErrorAplicacion() {
		super("Manejo de errores de la aplicacion: ");
	}
	public ErrorAplicacion(String mensaje) {
		super(mensaje);
	}
}
