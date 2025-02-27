package gestorAplicacion;

import java.io.Serializable;

import gestorAplicacion.terreno.*;
/**
 * Esta clase define objetos de tipo Pesticida que tienen un tipo pudiendo ser (Insecticida, Herbicida y Fungicida)
 * de acuerdo al tipo la instancia puede erradicar las Amenazas en los cultivos, posee un color de acuerdo a su tipo
 * y la Amenaza a la cual la instancia Pesticida esta asociado
 *
 */
public class Pesticida implements Serializable{
	/**Tipo de pesticida: Insecticida, Herbicida, Fungicida*/
	private String tipo;
	/**Color asociado al tipo de pesticida: Rojo(Insecticida), Verde(Herbicida), Blanco(Fungicida)*/
	private String color;
	/**Amenaza que va exterminar la instancia de pesticida creada*/
	private Amenaza amenaza;
	/**
	 * Constructor para crear una instancia de tipo Pesticida que recibe la instancia de Amenaza 
	 * a la cual esta asociado, de acuerdo al tipo de Amenaza que se pase como parametro se estable el tipo de 
	 * Pesticida
	 * @param amenaza, Parametro amenaza que representa una instacia de tipo Amenaza que ataca un cultivo
	 */
	public Pesticida(Amenaza amenaza) {
		this.amenaza = amenaza;
		if(amenaza.getTipo().equals("Plaga")) {
			this.tipo="Insecticida";
			this.color="Rojo";
		}
		else if(amenaza.getTipo().equals("Maleza")) {
			this.tipo="Herbicida";
			this.color="Verde";
		}
		else if(amenaza.getTipo().equals("Hongo")) {
			this.tipo="Fungicida";
			this.color="Blanco";
		}
	}
	// Cierre del constructor
	/**
	 * Constructor para crear una instancia de Pesticida que recibe el tipo de Pesticida y el Color que va 
	 * a tener la instancia de Pesticida
	 * @param tipo, Parametro que establece el tipo de Pesticida
	 * @param color, Parametro que establece el color del Pesticida
	 */
	public Pesticida(String tipo, String color) {
		this.tipo=tipo;
		this.color=color;
	}
	// Cierre del constructor
	/**
	 * Metodo matarAmenaza recibe el cultivo que esta siendo amenazado y establece su amenaza como nula
	 * @param c, Parametro que representa la instancia de tipo Cultivo que esta siendo atacado
	 */
	public void matarAmenaza(Cultivo c) {
		c.setAmenaza(null);
	}
	// Cierre del metodo matarAmenaza
}
