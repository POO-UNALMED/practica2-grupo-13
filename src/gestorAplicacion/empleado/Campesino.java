package gestorAplicacion.empleado;
import gestorAplicacion.terreno.*;
import manejoErrores.*;
import java.io.Serializable;
import java.util.*;
/**
 * Esta clase define objetos de tipo Campesino, que hereda de la clase Empleado
 * contienen todos los atributos que posee la clase Empleado
 * Las instancias de la clase Empleado deben ser asignadas a un Terreno al momento de ser creadas 
 */
public class Campesino extends Empleado implements Serializable{
	/**
	 * Constructor por defecto de la clase Campesino
	 */
	public Campesino() {
	}
	/**
	 * Constructor para crear una instancia de Empleado
	 * Establece a una instancia de Terreno el campesino que va a trabajar en el
	 * @param nombre El parametro nombre establece el nombre del Campesino usando a su padre
	 * @param sueldo El parametro sueldo establece el sueldo del Campesino usando a su padre
	 * @param cedula El parametro cedula establece la cedula del Campesino usando a su padre
	 * @param terreno El parametro Terreno establece el Terreno en el que trabajara
	 * el campesino usando a su padre
	 */
	public Campesino(String nombre, int sueldo, int cedula, Terreno terreno) {
		super(nombre, sueldo, cedula, terreno);
		terreno.agregarCampesino(this);
	}
	/**
	 * Metodo renunciar, que genera un numero aleatorio x (entre 0 y 1) que representa 
	 * una probabilidad del 15% de que un empleado pueda renunciar, obtiene la lista de todos
	 * los terrenos creados, obtiene los campesinos que trabajan en cadad Terreno y selecciona 
	 * al primero para que renuncie solo si x reprenseta menos del 15 por ciento de 
	 * probabiliad 
	 * 
	 */
	public String renunciar() {
		boolean renuncia = false;
		String campesino = "";
		double x = Math.random();
		if ((x < 0.1) && (Terreno.getTerrenos().size() > 0)) {
			for(int i = 0; i < Terreno.getTerrenos().size(); i++) {
				if(Terreno.getTerrenos().get(i).getCampesinos().size() > 0) {
					renuncia = true;
					campesino = Terreno.getTerrenos().get(i).getCampesinos().get(0).toString();
					Terreno.getTerrenos().get(i).getCampesinos().remove(0);
					break;
				}
			}
		}
		if(renuncia) {
			return campesino;
		}else {
			return "No renuncia";
		}
	}
	/**
	 * Metodo que remueve el campesino que se encuentra en el terreno trabajando
	 * @param terrrenoRenuncia El terreno al cual pertenece el campesino que se va a despedir
	 * @param campsinoDespedido El campesino que se va a despedir
	 */
	public void renunciar(Terreno terrrenoRenuncia, Campesino campsinoDespedido) {
		terrrenoRenuncia.getCampesinos().remove(campsinoDespedido);
	}
	/**
	 * Metodo que muestra todas las instancias de Campesino creadas
	 * @return devuleve un String con las cedulas de cada uno de los Campesinos en todos
	 * los terrenos existentes
	 */
	public static String mostrarCampesinos(Terreno terreno) {
		String muestra = "";
		for (Integer i = 0; i < terreno.getCampesinos().size(); i ++){
			muestra = muestra + (i+1) + ". "+ terreno.getCampesinos().get(i).getCedula() + "\n";
		}
		return(muestra);
	}
	/**
	 * Metodo toString
	 * @return devuelve un string con todos los atributos de la instancia Campesino
	 */
	@Override
	public String toString() {
		return("\n" + "El campesino con:" + "\n" + "Nombre: " + this.getNombre() + "\n" + "Cedula: " + this.getCedula() + "\n" +
				"Sueldo: " + this.getSueldo() + "\n" + "Vinculado a terreno: " + this.getTerreno().getId());
	}
	
	/**
	 * Metodo recolectar, que recoge toda la cantidad sembrada en cultivo, aumentando el tamano
	 * disponible en el terreno que estaba, luego eliminando el cultivo para que pueda
	 * ser sembrado posteriormente de nuevo, y aumenta la cantidad producida de acuerdo 
	 * al tipo de cultivo
	 * @param cultivo Parametro cultivo que representa el cultivo que se quiere recolectar
	 */
	public void recolectar(Cultivo cultivo) {
		//Modificar el size disponible del terreno que contiene el cultivo que se esta recolectando
		int tempSize = cultivo.getTamano();
		cultivo.getTerreno().setTamanoDisponible(tempSize);
		LinkedList<Cultivo> tempCultivos = new LinkedList<Cultivo>();
	
		
		//Sumar la candidad producida por tipo 
		String tempTypeCrop = cultivo.getTipoCultivo();
		switch(tempTypeCrop) {
		case "papa": Cultivo.setPapaProducida(tempSize); break;
		case "sandia": Cultivo.setSandiaProducida(tempSize); break;
		case "mango": Cultivo.setMangoProducido(tempSize); break;
		case "banano": Cultivo.setBananoProducido(tempSize); break;
		case "fresa": Cultivo.setFresaProducida(tempSize); break;
		}
		//Remove del cultivo en la lista de los cultivos estan en el terreno
		this.getTerreno().getCultivos().remove(cultivo);
		this.getTerreno().getTipos().remove(cultivo.getTipoCultivo());
		tempCultivos = Cultivo.getCultivos();
		int indicet = tempCultivos.indexOf(cultivo);
		//Se elimina el cultivo recolectado
		try {
			for (Cultivo temp : Cultivo.getCultivos()) {
				if ((temp.getTerreno().getId().equals(cultivo.getTerreno().getId())) && temp.getTipoCultivo().equals(cultivo.getTipoCultivo()) ){
					Cultivo.getCultivos().remove(temp);
				}
			}
		}catch(ConcurrentModificationException e){}
		
		
	}
	/**
	 * Metodo que recibe el terreno que se quiere fertilizar para poder sembrar cultivos
	 * en el
	 * @param terreno Parametro Terreno que representa uns instancia de la clase Terreno
	 */
	public void fertilizar(Terreno terreno) {
		terreno.fertilizarTerreno();
	}
	/**
	 * Metodo que busca un campesino por terreno y cedula
	 * @param terreno parametro que representa el terreno donde se encuentra el campesino
	 * @param cedula parametro que representa la cedula del campesino que se va a buscar
	 * @return la instancia del campesino que coincide con los parametros de busqueda
	 */
	public static Campesino buscarCampesino(Terreno terreno,int cedula) {
		Iterator<Campesino> campesino = terreno.getCampesinos().iterator();
		Campesino cExistente = null;
		while (campesino.hasNext()) {
			Campesino c = (Campesino) campesino.next();
			if (c.getCedula() == cedula) {
				cExistente = c;
			}
		}
		return cExistente;
	}

}
 