package gestorAplicacion;

import java.io.Serializable;
import java.util.*;
import gestorAplicacion.terreno.*;
/**
 * Esta clase define objetos de tipo Amenaza, que pueden ser de tres tipos Hongos, Malezas
 * o Plagas que pueden o no atacar a los cultvios sembrados en los terrenos
 */
public class Amenaza implements Serializable, IAmenaza {
	/** El tipo de la amenaza cuando se crea  que pueden ser de tres tipos Hongos, Malezas
	 * o Plagas */
	private String tipoAmenaza;
	/** Cultivo al cual esta atacando la amenaza*/
	private Cultivo cultivo; 
	/** Cantidad de hectareas que la amenaza le quita al cultivo que esta atacando*/
	private double cantidad;
	
	/**
	 * Constructor para crear una instancia de Amenaza
	 * Establece el tipo de amenza que es, el cultivo que va a amenazar
	 * y la cantidad de siembra que va a afectar 
	 * @param tipoAmenaza El parametro tipoAmenaza representa el tipo de amenaza 
	 * @param cultivo El parametro cultivo representa el cultivo que va a atacar 
	 * @param cantidad El parametro cantidad representa la cantidad de hectareas
	 * de siembra que va a afectar cuando ataque
	 */
	public Amenaza(String tipoAmenaza, Cultivo cultivo, double cantidad) {
		this.tipoAmenaza = tipoAmenaza;
		this.cultivo = cultivo;
		this.cantidad = cantidad;
	}
	/**
	 * Metodo que genera un numero aleatorio entre 0 y 2, para establecer el tipo de amenaza que 
	 * sera candidata a atacar
	 */
	public Amenaza() {
		int randomParaTipoAmenaza = (int) Math.floor(Math.random()*3);
		this.tipoAmenaza = AMENAZAS[randomParaTipoAmenaza];
	}
	/**
	 * Metodo toString
	 * @return devuelve un string con todos los atributos de la instancia Amenaza
	 */
	@Override
	public String toString() {
		return ("La amenaza" + "\n" + "De tipo: " + this.getTipo() + "\n" + "Infecto " + this.cantidad + " hectareas"
				+ "\n" + "Del cultivo: " + this.cultivo + "\n" + "Del terreno: " + this.cultivo.getTerreno());
	}
	/**
	 * Metodo getCultivo que devuelve el cultivo al que esta asociado la amenaza
	 * @return cultivo, representa un instancia de la clase Cultivo
	 */
	public Cultivo getCultivo() {
		return cultivo;
	}
	/**
	 * Metodo getTipo que devuelve el tipo de amenaza al que esta asociado la amenaza
	 * @return tipoAmenza, representa el tipo de Amenaza de la cual es la instancia
	 */
	public String getTipo() {
		return this.tipoAmenaza;
	}
	/**
	 * Metodo que selecciona un cultivo al azar, verificando que no esta atacado en el momento 
	 * y que tiene una cantidad de hectareas sembradas en un terreno para poder ser atacado
	 * @return null si no hay cultivo que cumpla lo requirimientos para ser atacado, o el cultivo que sera 
	 * atacado
	 */
	@Override
	public Cultivo econtrarCultivoParaAmenazar() {
		Cultivo cultivo = null;
		LinkedList<Cultivo> cultivos = Cultivo.getCultivos();
		if (cultivos.isEmpty()) {
			return cultivo;
		}
		int randomParaSacarCultivo = (int) Math.floor(Math.random()*cultivos.size());
		cultivo = cultivos.get(randomParaSacarCultivo);

		if (cultivo.estaAmenzado() || !cultivo.tieneTamano()) {
			return null;
		}
		return cultivo;
	}
	/**
	 * Metodo que genera un numero aleaotorio que representa la probabilidad que una amenaza ataque
	 * @return False si el random no esta entre 0 y 0.15 o True en el otro caso
	 */
	@Override
	public boolean esMomentoDeAmenazar() {
		double randomParaAmenazar = Math.random();
		return randomParaAmenazar >= 0 && randomParaAmenazar <= 0.15;
	}
	/**
	 * Metodo que establece la cantidad de hectareas que afectara en el cultivo, y establece la ameneza 
	 * bajo la cual el cultivo esta siendo atacado
	 */
	@Override
	public boolean atacarCultivo() {
		Cultivo cultivo = this.econtrarCultivoParaAmenazar();
		if (cultivo == null) {
			return false;
		}
		this.cultivo = cultivo;
		this.cantidad = Math.random() * cultivo.getTamano();
		this.cultivo.setAmenaza(this);
		return true;
	}
}
