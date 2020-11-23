package manejoErrores;

public class IdTerrenoException extends DominioException {

	private String mensaje;
	
    public IdTerrenoException (String mensaje){
		this.mensaje = mensaje;
	}
	public String getMensaje() {
		return mensaje;
	}
}
