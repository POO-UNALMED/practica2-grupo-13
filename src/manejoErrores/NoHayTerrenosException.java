package manejoErrores;

public class NoHayTerrenosException extends Verificacion {
	public String mensaje;
	
    public NoHayTerrenosException(String mensaje1){
		mensaje = mensaje1;
	}
    public String getMensaje() {
    	return super.getMessage();
    }
}
