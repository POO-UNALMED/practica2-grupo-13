package gestorAplicacion.terreno;
import manejoErrores.*;
import gestorAplicacion.empleado.*;
import java.io.Serializable;
import java.util.*;

/**
 * Esta clase define objetos de tipo Terreno que tiene un id que no puede ser
 * modificado una vez es definido la lista de cultivos que estan sembrados en
 * el, lista del tipo de cultivos presentes en el terreno, la lista de los
 * cultivos que en el momento permite que sean cultivados (solo uno por tipo),
 * la lista de todas las instancias creadas, la lista de campesinos que estan
 * trabajando en el terreno, el agronomo que se encuentra trabajando en el
 * momento ademas posee un tamano en hectareas, el tamano disponible que le
 * queda para cultivar y los parametros de nutrientes con los que quedo al
 * momento de ser creado
 */
public class Terreno implements Serializable {
	/** id que idenfica el terreno */
	private final String id;
	/** lista de los cultivos que se encuentran en el terreno */
	private LinkedList<Cultivo> cultivos = new LinkedList<Cultivo>();
	/** lista que guarda los cultivos que tiene sembrados */
	private LinkedList<String> tipos = new LinkedList<String>();
	/** lista de cultivos que pueden ser sembrados en el terreno */
	private LinkedList<String> cultivoPermitido = new LinkedList<String>();
	/** lista de los campesinos que trabajan en el terreno */
	private LinkedList<Campesino> campesinos = new LinkedList<Campesino>();
	/** Lista de todos los terrenos que se han creado */
	private static LinkedList<Terreno> terrenosTotales = new LinkedList<Terreno>();
	/** Agronomo que trabaja en el terreno */
	private Agronomo agronomo;
	/** Tamano del terreno creado */
	private int tamano;
	/** Tamano que posee el terreno en el cual se puede sembrar */
	private int tamanoDisponible;
	/**
	 * Cantidad de nitrogeno disponible (entre 0 y 1) que posee el terreno al ser
	 * creado
	 */
	private double nitrogenoDisponible;
	/**
	 * Cantidad de potasio disponible (entre 0 y 1) que posee el terreno al ser
	 * creado
	 */
	private double potasioDisponible;
	/**
	 * Cantidad de fosforo disponible (entre 0 y 1) que posee el terreno al ser
	 * creado
	 */
	private double fosforoDisponible;
	/**
	 * Cantidad de irrigacion disponible (entre 0 y 1) que posee el terreno al ser
	 * creado
	 */
	private double irrigacionActual;

	/**
	 * Metodo constructor para crear una instancia de la clase Terreno define su id
	 * El tamano en hectareas que tiene, los parametros de nutrientes (entre 0 y 1)
	 * y la irrigacion que tiene (entre 0 y 1) agrega el terreno a la lista de
	 * terrenos creados
	 * 
	 * @param id                  El parametro id, representa un numero que
	 *                            identifica el terreno
	 * @param tamano              El parametro tamano representa el tamano en
	 *                            hectareas del terreno
	 * @param nitrogenoDisponible El parametro nitrogeno representa el nitrogeno que
	 *                            tiene el terrreno
	 * @param potasioDisponible   El parametro potasio representa el potasio que
	 *                            tiene el terrreno
	 * @param fosforoDisponible   El parametro fosforo representa el fosforo que
	 *                            tiene el terrreno
	 * @param irrigacionActual    El parametro irrigacion representa la irrigacion
	 *                            que tiene el terrreno
	 */
	public Terreno(String id, int tamano, double nitrogenoDisponible, double potasioDisponible,
			double fosforoDisponible, double irrigacionActual) {
		this.id = id;
		this.tamano = tamano;
		this.nitrogenoDisponible = nitrogenoDisponible;
		this.potasioDisponible = potasioDisponible;
		this.fosforoDisponible = fosforoDisponible;
		this.irrigacionActual = irrigacionActual;
		this.tamanoDisponible = tamano;
		terrenosTotales.add(this);
	}

	/**
	 * Metodo constructor para crear una instancia de la clase de Terreno con
	 * parametros de nutrientes e irrigacion aleatorios
	 * 
	 * @param id     El parametro id, representa un numero que identifica el terreno
	 * @param tamano El parametro tamano representa el tamano en hectareas del
	 *               terreno
	 */
	public Terreno(String id, int tamano) {
		this(id, tamano, Math.random(), Math.random(), Math.random(), Math.random());
	}

	/**
	 * Metodo que verifica si posee los parametros de nutrientes, nivel de
	 * irrigacion necesarios para cultivar el tipo de cultivo correspondiente (papa,
	 * sandia, mango, banano o fresa), si cumple con los requisitos, agrega a la
	 * lista cultivoPermitido el tipo si no estaba cultivado
	 * 
	 * @return cultivoPermitido, lista de los cultivos que se encuentran sembrados
	 *         en el tereno
	 */
	public LinkedList<String> getCultivoPermitido() {
		if (nitrogenoDisponible >= 0.3 && potasioDisponible >= 0.4 && fosforoDisponible >= 0.4
				&& irrigacionActual >= 0.2) {
			if (cultivoPermitido.contains("papa") == false) {
				cultivoPermitido.add("papa");
			}
		}
		if (nitrogenoDisponible >= 0.1 && potasioDisponible >= 0.3 && fosforoDisponible >= 0.5
				&& irrigacionActual >= 0.5) {
			if (cultivoPermitido.contains("sandia") == false) {
				cultivoPermitido.add("sandia");
			}
		}
		if (nitrogenoDisponible >= 0.5 && potasioDisponible >= 0.3 && fosforoDisponible >= 0.2
				&& irrigacionActual >= 0.3) {
			if (cultivoPermitido.contains("mango") == false) {
				cultivoPermitido.add("mango");
			}
		}
		if (nitrogenoDisponible >= 0.3 && potasioDisponible >= 0.1 && fosforoDisponible >= 0.2
				&& irrigacionActual >= 0.6) {
			if (cultivoPermitido.contains("banano") == false) {
				cultivoPermitido.add("banano");
			}
		}
		if (nitrogenoDisponible >= 0.3 && potasioDisponible >= 0.4 && fosforoDisponible >= 0.5
				&& irrigacionActual >= 0.4) {
			if (cultivoPermitido.contains("fresa") == false) {
				cultivoPermitido.add("fresa");
			}
		}

		return cultivoPermitido;
	}

	/**
	 * Metodo que agrega a la lista culivos permitidos un nuevo tipo de cultivo
	 * sembrado
	 * 
	 * @param cultivoP nuevo tipo de cultivo sembrado que fue agragado al terreno
	 */
	public void agregrarCultivoP(String cultivoP) {
		this.cultivoPermitido.add(cultivoP);
	}

	/**
	 * Metodo que devulve la lista de todos los campesinos que trabajan en un
	 * terreno especifico
	 * 
	 * @return LinkedList<Campesino> lista con las instancias de los campesinos que
	 *         trabajan en el terreno
	 */
	public LinkedList<Campesino> getCampesinos() {
		return this.campesinos;
	}

	/**
	 * Metodo que agrega un campesino a la lista de los campesinos que actualmente
	 * trabajan en el terreno
	 * 
	 * @param campesino, Representa el campesino contratado
	 */
	public void agregarCampesino(Campesino campesino) {
		this.campesinos.add(campesino);
	}

	/**
	 * Metodo que devuelve todos los tipos de cultivos que se encuentran sembrados
	 * en el terreno
	 * 
	 * @return LinkedList<Srting> la lista contiene en forma de texto los tipos de
	 *         cultivos
	 */
	public LinkedList<String> getTipos() {
		return this.tipos;
	}

	/**
	 * Metodo que agrega un tipo de cultivo (papa, sandia, mango, banano o fresa) a
	 * la lista de los tipos
	 * 
	 * @param tipo, contiene los tipos de cultivos
	 */
	public void agregarTipo(String tipo) {
		this.tipos.add(tipo);
	}

	/**
	 * Metodo que devuelve una lista con todas las instancias de la clase Cultivo
	 * {@link Cultivo}
	 * 
	 * @return LinkedList<Cultivo> lista que guarda todos los cultivos sembrados en
	 *         un Terreno
	 */
	public LinkedList<Cultivo> getCultivos() {
		return this.cultivos;
	}

	/**
	 * Metodo que agrega un nuevo cultivo sembrado y reduce el tamano disponible del
	 * Terreno
	 * 
	 * @param cultivo que se va a sembrar en el terreno
	 */
	public void agregarCultivo(Cultivo cultivo) {
		this.cultivos.add(cultivo);
		tamanoDisponible -= cultivo.getTamano();
	}

	/**
	 * Metodo que devuelve todos los terrenos que han sido creados
	 * 
	 * @return LinkedList<Terreno> contiene todos los terrenos creados
	 */
	public static LinkedList<Terreno> getTerrenos() {
		return terrenosTotales;
	}
	public static void verificacionTerrenos() throws NoHayTerrenosException {
		if(terrenosTotales.isEmpty()) {
			throw new NoHayTerrenosException("No hay terrenos, por favor, asigne uno");
		}
	}
	public static void verificacionIdTerrenos(String id) throws IdTerrenoException {
		if(buscarTerreno(id) != null) {
			throw new IdTerrenoException("Ya existe un terreno con este ID");
		}
	}
	public static void verificacionContratarAgronomo(Terreno terreno) throws NoHayAgronomoException{
		if(terreno.agronomo != null) {
			throw new NoHayAgronomoException("Ya tiene un agronomo vinculado a este terreno");
		}
	}
	public static void verificacionCampesino(int index) throws NoHayCampesinoException{
		if(terrenosTotales.get(index).campesinos.size() == 0) {
			throw new NoHayCampesinoException("No tiene un campesino contratado para realizar la labor");
		}
	}
	public static void verificacionCampesino(Terreno terreno) throws NoHayCampesinoException{
		if(terreno.campesinos.isEmpty()) {
			throw new NoHayCampesinoException("No tiene campesinos contratados para despedir");
		}
	}
	public void verificarTamano(int tamano) throws TamanoExcedidoException {
		if(this.tamanoDisponible < tamano) {
			throw new TamanoExcedidoException("El tamaño ha sido excedido por: " + (tamano-this.tamanoDisponible) + " hectareas");
		}
	}
	public static void verificacionAgronomoExterminar(Terreno terreno) throws NoAgronomoToExterminarException{
		if(terreno.getAgronomo() == null) {
			throw new NoAgronomoToExterminarException("No tiene un agronomo contratado para realizar la labor de exterminacion");
		}
	}

	/**
	 * Metodo que retorna la instancia de un terreno que se busca por su id
	 * 
	 * @param id, el id del terreno que quiere ser buscado
	 * @return Terreno, devulve la instancia del terreno al ser encontrado, puede
	 *         ser null si no es encontrado
	 */
	public static Terreno buscarTerreno(String id) {
		Iterator<Terreno> terreno = terrenosTotales.iterator();
		Terreno tExistente = null;
		while (terreno.hasNext()) {
			Terreno t = (Terreno) terreno.next();
			if (t.getId().equals(id)) {
				tExistente = t;
			}
		}
		return tExistente;
	}
	
	public Cultivo buscarCultivo(String tipo) {
		Iterator<Cultivo> cultivo = this.getCultivos().iterator();
		Cultivo cExistente = null;
		while (cultivo.hasNext()) {
			Cultivo c = (Cultivo) cultivo.next();
			if (c.getTipoCultivo().equals(tipo)) {
				cExistente = c;
			}
		}
		return cExistente;
	}

	/**
	 * Metodo que informa al usuario los cultivos que pueden ser sembrados en el
	 * terreno
	 * 
	 * @return texto con los tipos de cultivos que el terreno permite, aquellos que
	 *         no estan sembrados
	 */
	public String cultivosPermitidos() {
		ListIterator iterador = cultivoPermitido.listIterator();
		StringBuffer lista = new StringBuffer("Los cultivos que permite el terreno son:\n");
		while (iterador.hasNext()) {
			String tipo = (String) iterador.next();
			lista.append(tipo + "\n");
		}
		return lista.toString();
	}

	/**
	 * Metodo que muestra los cultivos que estan sembrados en el cultivo
	 * 
	 * @return texto con los tipos de cultivos que se encuentran sembrados en el
	 *         terreno
	 */
	public String mostrarCultivos() {
		ListIterator iterador = tipos.listIterator();
		StringBuffer lista = new StringBuffer("Eliga una de las siguientes opciones \n");
		int i = 1;
		while (iterador.hasNext()) {
			String tipo = (String) iterador.next();
			lista.append("Opcion " + (i++) + ": " + tipo + "\n");
		}
		return lista.toString();
	}

	/**
	 * Metodo encargado de estabelcer los parametros necesarios para que un cultivo
	 * pueda ser creado en el terreno
	 * 
	 * @return la descripcion del terreno llamando ejecutando su propio metodo
	 *         toString
	 */
	public String fertilizarTerreno() {
		this.nitrogenoDisponible = 0.7;
		this.potasioDisponible = 0.7;
		this.fosforoDisponible = 0.7;
		this.irrigacionActual = 0.7;
		return this.toString();
	}

	/**
	 * Metodo que informa el tamano disponible para la creacion de nuevos cultivos
	 * 
	 * @return tamanoDisponible
	 */
	public int getTamanoDisponible() {
		return tamanoDisponible;
	}

	/**
	 * Metodo que actualiza el tamano disponible tel terreno
	 * 
	 * @param tamano, representa el tamano disponible del terreno
	 */
	public void setTamanoDisponible(int tamano) {
		this.tamanoDisponible += tamano;
	}

	/**
	 * Informa el agrnomo que trabaja en el terreno
	 * 
	 * @return la instancia de la clase Agrnomo asociada al terreno {@link Agronomo}
	 */
	public Agronomo getAgronomo() {
		return this.agronomo;
	}

	/**
	 * Metodo que le establece a un terreno el agrnomo que trabajara en el
	 * {@link Agronomo}
	 * 
	 * @param agronomo instancia de la clase Agrnomo asociada al terreno
	 *                 {@link Agronomo}
	 */
	public void setAgronomo(Agronomo agronomo) {
		this.agronomo = agronomo;
	}

	/**
	 * Metodo que informa el Id del terreno
	 * 
	 * @return id del terreno
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * Metodo encargado de mostrar todos los ids de los terrenos creados
	 * 
	 * @return String que describe en forma de texto todos los ids de los terrenos
	 *         creados
	 */
	public static String mostrarTerrenos() {
		String muestra = "";
		for (Integer i = 0; i < terrenosTotales.size(); i++) {
			muestra = muestra + "Opcion " + (i + 1) + ": " + terrenosTotales.get(i).getId() + "\n";
		}
		return (muestra);
	}

	/**
	 * Metodo que se escarga de mostrar los parametros con los que quedo el terreno
	 * creado
	 * 
	 * @return String que describe cada uno de los parametros que posee el terreno
	 */
	public String toString() {
		return "Se ha creado un nuevo terreno con las siguientes propiedades:\n" + "Nitrogeno disponible: "
				+ (Math.round(this.nitrogenoDisponible * 100.0) / 100.0) + "\n" + "Potasio disponible: "
				+ (Math.round(this.potasioDisponible * 100.0) / 100.0) + "\n" + "Fosforo disponible: "
				+ (Math.round(this.fosforoDisponible * 100.0) / 100.0) + "\n" + "Nivel de irrigacion: "
				+ (Math.round(this.irrigacionActual * 100.0) / 100.0);
	}
	public static ArrayList<String> mostrarTerrenosGUI() {
		ArrayList<String>terrenosId=new ArrayList<String>();
		for (Integer i = 0; i < terrenosTotales.size(); i++) {
			  terrenosId.add(terrenosTotales.get(i).getId());
		}
		return (terrenosId);
	}
	
	public ArrayList<String> getCedulasCampesinos(){
		Iterator<Campesino> campesino = this.getCampesinos().iterator();
		ArrayList<String> cedulasCampesinos = new ArrayList<String>();
		while (campesino.hasNext()) {
			Campesino c = (Campesino) campesino.next();
			cedulasCampesinos.add(String.valueOf(c.getCedula()));
		}
		return cedulasCampesinos;
	}

}
