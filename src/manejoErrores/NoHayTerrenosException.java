package manejoErrores;
/**
 * 
 * Clase que controla los errores relacionados a la ejecuci�n
 * de funcionalidades que requieran de Terrenos para ser ejecutadas.
 * Funcionalidades como cultivar, cosechar, contratar o despedir personal,  
 * fertilizar e irrigar o consultar la producci�n total, donde se verifica 
 * que hayan terrenos sobre los cuales se pueden realizar dichas accaciones
 * o tomar informaci�n de ellos para las consultas.
 *
 */
public class NoHayTerrenosException extends DominioException {
	
	private String mensaje;
	
    public NoHayTerrenosException(String mensaje1){
		mensaje = mensaje1;
	}

	public String getMensaje() {
		return mensaje;
	}

}
