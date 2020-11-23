package manejoErrores;

public class NoHayAgronomoException extends PersonasException {

	private String mensaje;
	
	public NoHayAgronomoException(String mensaje){
		this.mensaje = mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}
}
