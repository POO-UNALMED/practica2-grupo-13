package manejoErrores;
/**
 * 
 * Clase para el manejo de errores relacionados con los terrenos
 * para el caso específico su Id (identificador único). Controla que 
 * no se presenten terrenos con el mismo Id.
 *
 */
public class IdTerrenoException extends DominioException {

	private String mensaje;
	
    public IdTerrenoException (String mensaje){
		this.mensaje = mensaje;
	}
	public String getMensaje() {
		return mensaje;
	}
}
