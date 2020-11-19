package gestorAplicacion.empleado;

import java.io.Serializable;

import gestorAplicacion.terreno.*;

/**
 * Esta clase abstracta define objetos de tipo Empleado pueden ser Agronomos o
 * Campesinos que tienen un nombre, sueldo, cedulay, un terreno en el que
 * trabajan que se definen en su constructor
 */

public abstract class Empleado implements Serializable {
	/** Nombre del empleado contratado */
	protected String nombre;
	/** Sueldo con el que fue contratado el empleado */
	protected int sueldo;
	/** Cedula del empleado contratado */
	protected int cedula;
	/** Terreno en el cual trabaja el empleado */
	protected Terreno terreno;

	/**
	 * Constructor por defecto para Empleados, no recibe paremetros
	 */
	public Empleado() {
	}

	/**
	 * Constructor para instancias de tipo Empleado
	 * 
	 * @param nombre  establece el nombre del Empleado creado sean Agronomos o
	 *                Empleados
	 * @param sueldo  establece el sueldo que se le pagara al Empleado
	 * @param cedula  establece la cedula de cada Empleado
	 * @param terreno @senn(Terreno; gestorAplicacion.empleado) recibe como
	 *                parametro una instancia de la clase Terreno en la cual trabaja
	 *                el empleado
	 */
	public Empleado(String nombre, int sueldo, int cedula, Terreno terreno) {
		this.nombre = nombre;
		this.sueldo = sueldo;
		this.cedula = cedula;
		this.terreno = terreno;
	}

	/**
	 * Constructor para instancias de tipo Empleado que no reciben sueldo como
	 * paremetro
	 * 
	 * @param nombre  establece el nombre del Empleado creado sean Agronomos o
	 *                Empleados
	 * @param cedula  establece la cedula de cada Empleado
	 * @param terreno @senn(Terreno; gestorAplicacion.empleado) recibe como
	 *                parametro una instancia de la clase Terreno en la cual trabaja
	 *                el empleado
	 */
	public Empleado(String nombre, int cedula, Terreno terreno) {
		this.nombre = nombre;
		this.sueldo = 1000000;
		this.cedula = cedula;
		this.terreno = terreno;
	}

	/**
	 * Metodo general para que un Empleado renuncie
	 */
	public abstract void renunciar();

	/**
	 * Metodo que establece el nombre de un empleado
	 * 
	 * @param nombre parametro nombre que se le quiere establecer al Empleado
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo que devuelve el nombre de la instancia Empleado
	 * 
	 * @return devuelve el parametro nombre de la instancia
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo que establece el Sueldo de un empleado
	 * 
	 * @param sueldo parametro sueldo que se le quiere establecer al Empleado
	 */
	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}

	/**
	 * Metodo que devuelve el sueldo de la instancia Empleado
	 * 
	 * @return devuelve el parametro sueldo de la instancia Empleado
	 */
	public int getSueldo() {
		return sueldo;
	}

	/**
	 * Metodo que devuelve la cedula de la instancia Empleado
	 * 
	 * @return devuelve el parametro cedula de la instancia Empleado
	 */
	public int getCedula() {
		return cedula;
	}

	/**
	 * Metodo que establece la cedula de la instancia Empleado
	 * 
	 * @param cedula parametro cedula que se le quiere establecer al empleado
	 */
	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

	/**
	 * Metodo que establece el Terreno en el cual trabajara la instancia Empleado
	 * 
	 * @param terreno parametro Terreno que se le quiere establecer al empleado
	 */
	public void setTerreno(Terreno terreno) {
		this.terreno = terreno;
	}

	/**
	 * Metodo que devuelve el Terreno en la que trabaja la instancia Empleado
	 * 
	 * @return devuelve el parametro Terreno de la instancia Empleado
	 */
	public Terreno getTerreno() {
		return this.terreno;
	}
}
