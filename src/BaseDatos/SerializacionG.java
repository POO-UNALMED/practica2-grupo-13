package BaseDatos;

import gestorAplicacion.*;
import gestorAplicacion.empleado.*;
import gestorAplicacion.terreno.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.io.FileNotFoundException;
/**
 * 
 * Clase encargada de guardar las instancias creadas
 *
 */
public class SerializacionG {
	/** Crea un nuevo fichero*/
	static File fichero = new File("");
	/** Abre el flujo de datos*/
	static ObjectOutputStream entradas;

	public static void Save() {
		/**
		 * Se guardan todos los cultivos creados
		 */
		try {
			entradas = new ObjectOutputStream(new FileOutputStream(fichero.getAbsolutePath() + "\\src\\BaseDatos\\temp\\Cultivos.txt"));
			for (int i = 0; i < Cultivo.getCultivos().size(); i++) {
				entradas.writeObject(Cultivo.getCultivos().get(i));
			}
			entradas.close();
		} catch (IOException e) {
			System.out.println("ERROR" + e.getMessage() + "  " + e.toString());
		}
		/**
		 * Se guardan todas las instancias de Terrenos creadas
		 */
		try {
			entradas = new ObjectOutputStream(
					new FileOutputStream(fichero.getAbsolutePath() + "\\src\\BaseDatos\\temp\\Terrenos.txt"));
			for (int i = 0; i < Terreno.getTerrenos().size(); i++) {
				Terreno terreno = Terreno.getTerrenos().get(i);
				entradas.writeObject(terreno);
			}
			entradas.close();
		} catch (IOException e) {
			System.out.println("ERROR" + e.getMessage() + "  " + e.toString());
		}
	}
}
