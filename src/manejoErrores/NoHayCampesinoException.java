package manejoErrores;

public class NoHayCampesinoException extends PersonasException {

private String mensaje;
	
	public NoHayCampesinoException(String mensaje){
		this.mensaje = mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}
	
}
