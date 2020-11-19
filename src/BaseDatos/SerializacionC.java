package BaseDatos;

import gestorAplicacion.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.LinkedList;
import gestorAplicacion.empleado.*;
import gestorAplicacion.terreno.*;
/**
 * Clase encargada de escribir las instancias antes serializadas
 *
 */
public class SerializacionC {
	/** Abre el flujo de datos*/
	private static ObjectInputStream entradas;
	/** Crea un nuevo fichero*/
	static File fichero = new File("");
	/** Objeto usado para escribir todas las instancias*/
	static Object Objeto;

	public static void Load() {
		/** 
		 * Se cargan las instancias de de cultivos
		 */
		try {
			entradas = new ObjectInputStream(new FileInputStream(fichero.getAbsolutePath() + "\\src\\BaseDatos\\temp\\Cultivos.txt"));
			Objeto = entradas.readObject();
			while (Objeto != null) {
			Cultivo.getCultivos().add((Cultivo) Objeto);
			Objeto = entradas.readObject();
			}
			entradas.close();

		} catch (java.io.IOException e) {
			
		} catch (ClassNotFoundException e) {
			
		} 
		/**
		 * Se escriben las instancias de Terrenos previamente creadas y se agrega a la lista de agronomos 
		 * los que estan asociados a los terrenos
		 */
		try {
			entradas = new ObjectInputStream(new FileInputStream(fichero.getAbsolutePath() + "\\src\\BaseDatos\\temp\\Terrenos.txt"));
			Objeto = entradas.readObject();
			while (Objeto != null) {
				Terreno.getTerrenos().add((Terreno) Objeto);
				Terreno tempTerreno = (Terreno) Objeto;
				if (tempTerreno.getAgronomo()!=null) {
					Agronomo.getAgronomos().add(tempTerreno.getAgronomo());
				}
				
				Objeto = entradas.readObject();
			}						
			entradas.close();
			
		} catch (java.io.IOException e) {

		} catch (ClassNotFoundException e) {

		}
				
	}
}
