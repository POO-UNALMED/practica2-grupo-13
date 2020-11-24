package gestorAplicacion.empleado;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import gestorAplicacion.terreno.*;
import gestorAplicacion.*;
import manejoErrores.*;
/**
 * Esta clase define objetos de tipo Agronomo, que hereda de la clase Empleado
 * contienen todos los atributos que posee la clase Empleado Las instancias de
 * la clase Agronomo deben ser asignadas a un Terreno al momento de ser creadas
 */
public class Agronomo extends Empleado implements Serializable {
	/** Lista de todos los agrnomos contratados */
	private static LinkedList<Agronomo> agronomos = new LinkedList<Agronomo>();

	/**
	 * Constructor por defecto de la clase Agronomo
	 */
	public Agronomo() {
	}

	/**
	 * Constructor para crear una instancia Agronomo Establece a una instancia de
	 * Terreno el agronomo encargado Agrega a la lista agronomos la instancia creada
	 * 
	 * @param nombre  El parametro nombre establece el nombre del Agronomo usando a
	 *                su padre
	 * @param sueldo  El parametro sueldo establece el sueldo del Agronomo usando a
	 *                su padre
	 * @param cedula  El parametro cedula establece la cedula del Agronomo usando a
	 *                su padre
	 * @param terreno El parametro Terreno establece el Terreno del Agronomo usando
	 *                a su padre
	 */
	public Agronomo(String nombre, int sueldo, int cedula, Terreno terreno) {
		super(nombre, sueldo, cedula, terreno);
		terreno.setAgronomo(this);
		agronomos.add(this);
	}

	/**
	 * Metodo que erradica una amenaza, recibe la Amenaza que debe erradicarse y el
	 * cultivo que la padece el metodo verifica que el terreno en el que se
	 * encuentra el cultivo tenga un agronomo encargado crea una instancia de
	 * pesticida capaz de erradicar la amenaza en cuestion, y manda a matar la
	 * amenaza
	 * 
	 * @param amenaza El parametro amenaza es la instancia de Amenaza que esta
	 *                atacando
	 * @param cultivo El parametro Cultivo es la instancia de Cultivo que esta bajo
	 *                ataque
	 */
	public static void erradicarAmenaza(Amenaza amenaza, Cultivo cultivo) {
		if (cultivo.getTerreno().getAgronomo() != null) {
			Pesticida pesticida = new Pesticida(amenaza);
			pesticida.matarAmenaza(cultivo);
		} else {
		}
	}

	/**
	 * Metodo que muestra todas las instancias de Agronomo creadas
	 * 
	 * @return devuleve un String con las cedulas de cada uno de los agronomos
	 */
	public static String mostrarAgronomos() {
		String muestra = "";
		int contador = 1;
		for (Integer i = 0; i < agronomos.size(); i++) {
			muestra = muestra + (contador) + ". " + agronomos.get(i).getCedula() + "\n";
			contador++;
		}
		return (muestra);
	}
	public static void verificarDespedirAgronomo() throws NoHayAgronomoException{
		if(agronomos.isEmpty()) {
			throw new NoHayAgronomoException("No tiene agronomos para despedir");
		}
	}

	/**
	 * Metodo renunciar, que genera un numero aleatorio x (entre 0 y 1) que
	 * representa una probabilidad del 15% de que un empleado pueda renunciar,
	 * generea el numero random y (entre 0 y el size de la lista agronomos) que
	 * representa un indice para seleccionar un empleado aleatorio que renuncia si x
	 * es menor a 0.15
	 */
	public String renunciar() {
		boolean renuncia = false;
		String agronomo = "";
		double x = Math.random();
		int y = (int) Math.random() * agronomos.size();
		if ((x < 0.1) && (agronomos.size() > 0)) {
			renuncia = true;
			agronomo = agronomos.get(y).toString();		
			agronomos.get(y).getTerreno().setAgronomo(null);
			agronomos.remove(y);
		}
		if(renuncia) {
			return agronomo;
		}else {
			return "No renuncia";
		}
	}

	/**
	 * Metodo renunciar que recibe como parametro el indice que corresponde al
	 * agronomo que renunciara, luego borra el terreno al que esta asociado el
	 * agronomoo y lo elimina de la lista agronomos
	 * 
	 * @param opcionElegida El parametro opcionElegida es el indice en la lista
	 *                      agronomos que corresponde al agronomo que quiere
	 *                      renunciar
	 */
	public void renunciar(int opcionElegida) {
		agronomos.get(opcionElegida).getTerreno().setAgronomo(null);
		agronomos.remove(opcionElegida);
	}

	/**
	 * Metodo toString
	 * 
	 * @return devuelve un string con todos los atributos de la instancia Agronomo
	 */
	@Override
	public String toString() {
		return ("\n" + "El agronomo con:" + "\n" + "Nombre: " + this.getNombre() + "\n" + "Cedula: " + this.getCedula()
				+ "\n" + "Sueldo: " + this.getSueldo() + "\n" + "Vinculado a terreno: " + this.getTerreno().getId());
	}

	/**
	 * Metodo estatico que retorna la lista de todos los agronomos creados
	 * 
	 * @return Parametro agronomos que guarda cada instancia de Agronomo creada
	 */
	public static LinkedList<Agronomo> getAgronomos() {
		return agronomos;
	}
	
	
	public static LinkedList<String> mostrarAgronomosGUI() {
		LinkedList<String> Agronomos = new LinkedList<String>();
		for (int i = 0; i < agronomos.size(); i++) {
			 Agronomos.add(Integer.toString(agronomos.get(i).getCedula()));
		}
		return (Agronomos);
	}
	
	public static Agronomo getAgronomo(int cedula) {
		Iterator<Agronomo> agronomo = agronomos.iterator();
		Agronomo aExistente = null;
		while (agronomo.hasNext()) {
			Agronomo a = (Agronomo) agronomo.next();
			if (a.getCedula() == cedula) {
				aExistente = a;
			}
		}
		return aExistente;
	}
}