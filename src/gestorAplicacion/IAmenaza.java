package gestorAplicacion;

import gestorAplicacion.terreno.Cultivo;

/**
 * Clase que establece el compartamiento de las amenzas, saber si es momento de
 * atacar y a que cultivo, ademas establece los tipos de amenazas que atacan a
 * los tipos de cultivos soportados
 *
 */
public interface IAmenaza {
	/** Atributo que establece los tipos de amenzas */
	public static final String[] AMENAZAS = { "Hongo", "Maleza", "Plaga" };

	/**
	 * Metodo encargado de encontar un cultivo candidato a ser amenzado, que poseea
	 * hectareas sembradas y no se encuentre amenazado
	 * 
	 * @return un cultivo que cumple las condiciones para poder ser atacado o un
	 *         null en caso de no cumplir las condiciones
	 */
	Cultivo econtrarCultivoParaAmenazar();

	/**
	 * Metodo que establece aleatoriamente si despliega una amenaza o no
	 * 
	 * @return true: Se ataca, false: No se ataca
	 */
	boolean esMomentoDeAmenazar();

	/**
	 * Metodo que establece al cultivo previamente seleccionado la amenza desplegada
	 * 
	 * @return true: si se ataco con exito al cultivo previamente seleccionado
	 *         aleatoriamente
	 */
	boolean atacarCultivo();
}
