package manejoErrores;

@SuppressWarnings("serial")
public class PersonasException extends ErrorAplicacion {

	public PersonasException() {
		super();
	}
	public PersonasException(int tamano) {
		super();
		tamanoExcedente = tamano;
	}
	private static int tamanoExcedente;
	public static int getTamanoExcedente(){
		return tamanoExcedente;
	}
}
