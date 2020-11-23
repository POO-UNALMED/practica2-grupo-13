package manejoErrores;

public class CultivoAmenazaException extends DominioException{

private String mensaje;
	
	public CultivoAmenazaException(String mensaje){
		this.mensaje = mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}

}
