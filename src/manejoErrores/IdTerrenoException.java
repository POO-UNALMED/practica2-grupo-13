package manejoErrores;
/**
 * 
 * Clase para el manejo de errores relacionados con los terrenos
 * para el caso espec�fico su Id (identificador �nico). Controla que 
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
