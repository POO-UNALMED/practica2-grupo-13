package manejoErrores;
/**
 * 
 * Clase que controla los errores relacionados a la funcionalidad de 
 * exterminar amenazas presentes en los cultivos. Maneja el caso en 
 * el que no se presente ningún agronomo en determinado terreno para que 
 * pueda encargarse de las posibles amenazas en los cultivos del terreno 
 * asociado.
 *
 */
public class NoAgronomoToExterminarException extends PersonasException{

	private String mensaje;
	
    public NoAgronomoToExterminarException (String mensaje){
		this.mensaje = mensaje;
	}
	public String getMensaje() {
		return mensaje;
	}

}
