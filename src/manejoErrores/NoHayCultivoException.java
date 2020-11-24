package manejoErrores;
/**
 * 
 * Clase que controla los errores relacionados a la ejecución
 * de funcionalidades que requieran de cultivos para ser ejecutadas.
 * Funcionalidades como cosechar, fertilizar e irrigar o consultar la producción total,
 * donde se verifica que hayan cultivos sobre los cuales se pueden realizar dichas accaciones
 * o tomar información de ellos para las consultas.
 *
 */
public class NoHayCultivoException extends DominioException{

private String mensaje;
	
	public NoHayCultivoException(String mensaje){
		this.mensaje = mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}

}
