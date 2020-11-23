package manejoErrores;

public class NoHayCultivoException extends DominioException{

private String mensaje;
	
	public NoHayCultivoException(String mensaje){
		this.mensaje = mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}

}
