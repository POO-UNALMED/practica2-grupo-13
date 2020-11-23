package manejoErrores;

public class NoHayTerrenosException extends DominioException {
	
	private String mensaje;
	
    public NoHayTerrenosException(String mensaje1){
		mensaje = mensaje1;
	}

	public String getMensaje() {
		return mensaje;
	}

}
