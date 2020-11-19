package manejoErrores;

@SuppressWarnings("serial")
public class Varios extends ErrorAplicacion {

	public Varios() {
		super();
	}
	public Varios(int tamano) {
		super();
		tamanoExcedente = tamano;
	}
	private static int tamanoExcedente;
	public static int getTamanoExcedente(){
		return tamanoExcedente;
	}
}
