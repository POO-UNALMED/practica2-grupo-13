package manejoErrores;
/**
 * 
 * Clase para el manejo de errores relacionados con las amenazas 
 * presentes en los diferentes cultivos. Su objetivo es controlar y 
 * emitir determinado mensaje con respecto al error 
 *
 */
public class CultivoAmenazaException extends DominioException{

private String mensaje;
	
	public CultivoAmenazaException(String mensaje){
		this.mensaje = mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}

}
