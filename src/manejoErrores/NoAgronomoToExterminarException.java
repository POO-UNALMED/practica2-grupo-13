package manejoErrores;

public class NoAgronomoToExterminarException extends PersonasException{

	private String mensaje;
	
    public NoAgronomoToExterminarException (String mensaje){
		this.mensaje = mensaje;
	}
	public String getMensaje() {
		return mensaje;
	}

}
