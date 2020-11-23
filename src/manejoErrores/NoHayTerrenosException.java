package manejoErrores;

public class NoHayTerrenosException extends DominioException {
	public String mensaje;
	
    public NoHayTerrenosException(String mensaje1){
		mensaje = mensaje1;
	}

}
