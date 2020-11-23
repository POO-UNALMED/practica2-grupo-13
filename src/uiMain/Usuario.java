package uiMain;

import java.util.*;
import BaseDatos.SerializacionC;
import BaseDatos.SerializacionG;
import gestorAplicacion.empleado.*;
import gestorAplicacion.terreno.*;
import gestorAplicacion.*;
import manejoErrores.*;
/**
 *La clase Usuario define el compartamiento de la aplicacion, la forma en que el usario se mueve 
 *a traves de las funcionalidades que se ofrecen
 *	Contratar Empleados
 *	Despedir Empleados
 *	Produccion total de los cultivos
 *	Examinar los cultivos
 *	Cultivar y cosechar
 *	Agregar terrenos
 *	Fertilizar e irrigar terrenos
 */
public class Usuario {
	/** Permite saber cuantas amenzas desplegadas no resultaron atacando a los cultivos*/
	public static int amenazasFallidas = 0;
	
	static Scanner Sc = new Scanner(System.in);
	/** Lee las opciones numericas ingresadas por el usario*/
	static int readInt() {
		return Sc.nextInt();
	}
	/** Lee las opciones textuales ingresadas por el usario*/
	static String readLine() {
		return Sc.next();
	}
	/**
	 * Metodo encargado de contratar Empleados
	 * Si contrata un Campesino:
	 * 	Pide los datos necesarios para contratarlo y lo agrega a un Terreno seleccionado
	 * Si contrara un Agronomo:
	 * 	Pide los datos necesarios para contratarlo, verifica que el Terreno seleccionado no tenga un agronomo 
	 * 	asociado y finalmente contrata o no al agronomo asociandolo al Terreno seleccionado
	 */
	public static void contratar() {
		int opcionElegida;
		System.out.println("¿Qué trabajador desea contratar?");
		System.out.println("1. Campesino");
		System.out.println("2. Agronomo");
		System.out.println("3. Volver");
		opcionElegida = readInt();
		if ((opcionElegida == 1) || (opcionElegida == 2)) {
			String nombre; 
			int sueldo, cedula, terreno;
			try {   //////fsgfd
				Terreno.verificacionTerrenos();
				System.out.println("Ingrese el nombre:");
				nombre = readLine();
				System.out.println("Ingrese el sueldo:");
				sueldo = readInt();
				System.out.println("Ingrese el numero de cedula");
				cedula = readInt();
				System.out.println("Seleccione un terreno para vincular al trabajador");
				System.out.println(Terreno.mostrarTerrenos());
				terreno = readInt() - 1;
				if (opcionElegida == 1) {
					Campesino campe = new Campesino(nombre, sueldo, cedula, Terreno.getTerrenos().get(terreno));
					System.out.println("Se ha contratado un campesino.");
					System.out.println(campe);
				} else if (opcionElegida == 2) {
					try {
						Terreno.verificacionAgronomo(terreno);
						Agronomo agro = new Agronomo(nombre, sueldo, cedula, Terreno.getTerrenos().get(terreno));
						System.out.println("Se ha contratado un agronomo.");
						System.out.println(agro);
					}
					catch(PersonasException e) {
						System.out.println("Este terreno ya tiene un agronomo vinculado");
					}
				} else {}
			}
			catch(DominioException e) {
				System.out.println("No tiene terrenos, por favor, asigne uno");
			}
			catch(InputMismatchException e) {
				System.out.println("Se ha ingresado un tipo de dato no valido");
			}
		}	
	}
	/**
	 * Metedo encargado de despedir a los Empleados
	 * Si despide un campesino:
	 * 	Pide especificar de cual terreno quiere despedir a los Campesinos
	 * 	Valida si el el terreno posee Campesinos
	 * 	Elimina el campesino de la lista de los campesinos que posee el Terreno seleccionado
	 * Si despide un Agronomo
	 * 	Valida si existen Terrenos creados
	 * 	Valida si existen Agronomos contratados, si hay muestra la lista de los agronomos para 
	 * 	que sea seleccionado al que se quiere despedir
	 * 	de lo contario dice que no hay agronomos contratados 
	 */

	public static void despedir() {
		int opcionElegida, opcionElegida2;
		try {
			Terreno.verificacionTerrenos();
			System.out.println("¿Qué trabajador desea despedir?");
			System.out.println("1. Campesino");
			System.out.println("2. Agronomo");
			System.out.println("3. Volver");
			opcionElegida = readInt();
			if (opcionElegida == 1) {
				System.out.println("Seleccione un terreno para mirar los campesinos que laboran en el");
				System.out.println(Terreno.mostrarTerrenos());
				opcionElegida = readInt() - 1;
				Campesino.verificarCampesinos(opcionElegida);
				System.out.println("Seleccione un campesino para despedir");
				System.out.println(Campesino.mostrarCampesinos(Terreno.getTerrenos().get(opcionElegida)));
				opcionElegida2 = readInt() - 1;
				System.out.println("Se ha despedio a: ");
				System.out.println(Terreno.getTerrenos().get(opcionElegida).getCampesinos().get(opcionElegida2));
				Terreno.getTerrenos().get(opcionElegida).getCampesinos().get(opcionElegida2).renunciar(opcionElegida,
						opcionElegida2);
			} else if (opcionElegida == 2) {
					Agronomo.verificarAgronomos();
					System.out.println("Seleccione un agronomo para despedir");
					System.out.println(Agronomo.mostrarAgronomos());
					opcionElegida = readInt() - 1;
					Agronomo.getAgronomos().get(opcionElegida).renunciar(opcionElegida);
			}
		}
		catch(DominioException e) {
			System.out.println("No tiene terrenos, por favor, asigne uno");
		}
		catch(PersonasException e) {
			System.out.println("No ha contratado este tipo de empleado");
		}
		catch(InputMismatchException e) {
			System.out.println("Se ha ingresado un tipo de dato no valido");
		}
	}
	/**
	 * Metodo que imprime por pantalla la cantidad producida de todos los tipos de cultivos en hectareas recogidas
	 * tipos: Papa, Sandia, Banano, Mango, Fresa
	 */
	public static void produccion() {
		try{
			Cultivo.verificacionProduccion();
			System.out.println("Cantidad producida de cada tipo de cultivo");
			System.out.println("Cantidad de papas: " + Cultivo.getPapaProducida() + " hectareas");
			System.out.println("Cantidad de sandias: " + Cultivo.getSandiaProducida() + " hectareas");
			System.out.println("Cantidad de bananos: " + Cultivo.getBananoProducido() + " hectareas");
			System.out.println("Cantidad de mangos: " + Cultivo.getMangoProducido() + " hectareas");
			System.out.println("Cantidad de fresas: " + Cultivo.getFresaProducida() + " hectareas");
		}
		catch(DominioException e){
			System.out.println("¡No has recolectado nada de tus cultivos!");
		}
	}
	/**
	 * Metodo que imprime todos los cultivos existentes en todos los terrenos
	 * y si estan o no bajo amenaza dando la opcion de erradicarla siempre que exista un agrnomo asociado al terreno 
	 * en el cual se encuentra dicho cultivo
	 */
	public static void examinarCultivo() {
		try {
			Cultivo.verificacionCultivos();
			int opcionElegida, opcionElegida2;
			System.out.println("Seleccione un cultivo:");
			System.out.println(Cultivo.mostrarCultivos());
			opcionElegida = readInt() - 1;
			System.out.println(Cultivo.getCultivos().get(opcionElegida));
			if (Cultivo.getCultivos().get(opcionElegida).getAmenaza() != (null)) {
				System.out.println("¿Desea aplicar pesticida para eliminar la amenaza del cultivo?");
				System.out.println("1. Si");
				System.out.println("2. No");
				opcionElegida2 = readInt();
				if (opcionElegida2 == 1) {
					Amenaza amenaza = Cultivo.getCultivos().get(opcionElegida).getAmenaza();
					Cultivo cultivo = Cultivo.getCultivos().get(opcionElegida);
					Agronomo.erradicarAmenaza(amenaza, cultivo);
				} else {}
			}
		}
		catch(DominioException e) {
			System.out.println("Debe cultivar primero");
		}
		catch(InputMismatchException e) {
			System.out.println("Se ha ingresado un tipo de dato no valido");
		}
	}
	/**
	 * Metodo que agrega un nuevo terreno para ser sembrado posteriormente
	 * Verifica que el id correspondiente al terreno ingresado no exista 
	 * y pide el tamano en hectareas del terreno que se quiere ingresar
	 */
	public static void agregarTerreno() {
		System.out.println("Indique el Id que le desea poner: ");
		String id = readLine();
		try {
			Terreno.verificacionIdTerrenos(id);
			System.out.println("Ahora indique el tamano deseado: ");
			int tamano = readInt();
			Terreno terrenoCreado = new Terreno(id, tamano);
			System.out.println("El terreno ha sido agregado exitosamente");
			System.out.println(terrenoCreado.toString());
		}
		catch(DominioException e){
			System.out.println("Un terreno ya tiene este id, por favor, indique otro");
		}
	}
	/**
	 * Metodo que modifica los parametros de nutrientes e irrigacion para que los cultivos puedas ser 
	 * sembrados en el terreno
	 * Verifica que existan Campesinos asociados al terreno, y manda a hacer la tarea a un campesino aleatorio
	 * Verifica que existan Terrenos para ser fertilizados
	 */
	public static void ferrigar() {
		try {
			Terreno.verificacionTerrenos();
			System.out.println("Escoja el terreno que desea fertilizar e irrigar: " + "\n");
			System.out.println(Terreno.mostrarTerrenos());
			int id = readInt() - 1;
			Terreno.verificacionCampesino(id);
			int trabajador = (int) Math.random() * (Terreno.getTerrenos().get(id).getCampesinos().size() - 1);
			Campesino campesinoFertiliza = Terreno.getTerrenos().get(id).getCampesinos().get(trabajador);
			campesinoFertiliza.fertilizar(Terreno.getTerrenos().get(id));
			Terreno.getTerrenos().get(id).getCultivoPermitido();
			System.out.println("Terreno fertilizado");
			System.out.println(Terreno.getTerrenos().get(id).cultivosPermitidos());
		}
		catch(DominioException e) {
			System.out.println("No posee terrenos para fertilizar e irrigar");
		}
		catch(PersonasException e) {
			System.out.println("No posee campesinos vinculados a ese terreno para realizar la labor");
		}
	}
	/**
	 * Metodo encargado de crear cultivos en un Terreno seleccionado y de recoger los que se sembro
	 * Verifica que existan Terrenos 
	 * Verifica que el tamano del cultivo que se quiere sembrar sea menor al tamano disponible en el terreno
	 * Verifca que el terreno posea los parametros necesarios para sembrar
	 * Verfica que existan campesinos trabajando en el terreno que puedan sembrar el cultivo seleccionado
	 * 
	 * Recoge las hectareas sembradas del cutivo seleccionado y suma a la respectiva cantadidad producida
	 */
	public static void cultivoyCosecha() {
		System.out.println(
				"Escoja la funcion a realizar:\nPara crear un cultivo ingrese 1\nPara recolectar un cultivo ingrese 2");
		try {
			int opcion = readInt();
			if (opcion == 1) {
					Terreno.verificacionTerrenos();
					System.out.println("Escoja la opcion del terreno en el que quiere sembrar: ");
					System.out.println(Terreno.mostrarTerrenos());
					int entrada = readInt();
					Terreno terreno = Terreno.getTerrenos().get(entrada - 1);
					Terreno.verificacionCampesino(entrada - 1);
					terreno.getCultivoPermitido();
					if (terreno.getCultivoPermitido().size() != 0) {
						try {
							System.out.println(terreno.cultivosPermitidos());
							System.out.println("Escriba el tipo que quiere sembrar: ");
							String tipo = readLine();
							System.out.println("Escriba el tamaño que desea que tenga el cultivo: ");
							int tamaño = readInt();
							terreno.verificarTamano(tamaño);
							System.out.println(Cultivo.crearCultivo(tipo, tamaño, terreno));
						}
						catch(PersonasException e) {
							System.out.println("Error, el tamano del cultivo supera al terreno por: ");
							System.out.println(PersonasException.getTamanoExcedente());
						}
					} else {
						System.out.println(
								"No dispone con los requerimientos suficientes para sembrar en este terreno, por favor irrigue o fertilice");
					}
			} else if (opcion == 2) {
					System.out.println("Escoja la opcion del terreno en el que quiere recolectar: ");
					System.out.println(Terreno.mostrarTerrenos());
					int entrada = readInt();
					Terreno terreno = Terreno.getTerrenos().get(entrada - 1);
					Terreno.verificacionCampesino(entrada - 1);
						if (terreno.getCultivos().isEmpty() == false) {
							System.out.println("Ingrese la opcion que corresponde al tipo ");
							System.out.println(terreno.mostrarCultivos());
							int eleccion = readInt();
							Cultivo cultivo = terreno.getCultivos().get(eleccion - 1);
							try {
								cultivo.verificacionAmenaza();
								Campesino campesino = terreno.getCampesinos().peek();
								System.out.println("Se ha recolectado del cultivo de tipo " + cultivo.getTipoCultivo() + " "
										+ cultivo.getTamano() + " hectareas.");
								campesino.recolectar(cultivo);
							}
							catch(DominioException e) {
								System.out.println("El cultivo se encuentra bajo una amenaza, por favor, exterminela para recolectar");
							}
						} else {
							System.out.println("El terreno no tiene cultivos, por favor cree uno");
						}
			}
		}
		catch(DominioException e) {
			System.out.println("No posee terrenos para cultivar, por favor, asigne al menos uno");
		}
		catch(PersonasException e){
			System.out.println("No dispone de campesinos en este terreno para relizar las labores");
		}
		catch(InputMismatchException e) {
			System.out.println("Se ha ingresado un tipo de dato no valido");
		}
		
	}
	/**
	 * Metodo que ejecuta la accion de una renuncia aleatoria para un campesino 
	 * {@link Campesino} y para un agronomo {@link Agronomo}
	 */
	public static void renunciaAleatoria() {
		new Campesino().renunciar();
		new Agronomo().renunciar();
	}
	/**
	 * Metodo que se encarga de ejecutar las acciones necesarias para desplegar una amenaza 
	 * e informa del exito de la opercion, ademas cuenta el numero de amenazas desplegadas no terminaron 
	 * danando ningun cultivo
	 */
	private static void controlAmenazas() {
		Amenaza amenaza = new Amenaza();
		if (amenaza.esMomentoDeAmenazar() && amenaza.atacarCultivo()) {
			System.out.println("La amenaza: " + amenaza.getTipo() + " esta atacando al cultivo " + amenaza.getCultivo().getTipoCultivo()
					+ " en el terreno con id " + amenaza.getCultivo().getTerreno().getId() + "\n");
		} else {
			amenazasFallidas++;
		}
		
	}
	/**
	 * main vista al usario que ejecuta todas las funcionalidades del programa
	 * @param args
	 */
	public static void main(String args[]) {
		SerializacionC.Load();
		int opcionElegida;
		do {
			controlAmenazas();
			renunciaAleatoria();
			System.out.println("\n" + "Selecciona una funcion");
			System.out.println("1. Contratar");
			System.out.println("2. Despedir");
			System.out.println("3. Produccion total de los cultivos");
			System.out.println("4. Examinar cultivos");
			System.out.println("5. Cultivar y cosechar");
			System.out.println("6. Agregar terreno");
			System.out.println("7. Fertilizar e irrigar terrenos");
			System.out.println("8. Terminar" + "\n");
			opcionElegida = readInt();
			switch (opcionElegida) {
			case 1:
				contratar();
				break;
			case 2:
				despedir();
				break;
			case 3:
				produccion();
				break;
			case 4:
				examinarCultivo();
				break;
			case 5:
				cultivoyCosecha();
				break;
			case 6:
				agregarTerreno();
				break;
			case 7:
				ferrigar();
				break;
			case 8:
				SerializacionG.Save();
				break;
			}
		} while (opcionElegida != 8);
	}
}