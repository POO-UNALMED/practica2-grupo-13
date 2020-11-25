package uiMain; // package

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Optional;

import com.sun.javafx.scene.control.behavior.ComboBoxListViewBehavior;

import gestorAplicacion.Amenaza;
import gestorAplicacion.empleado.Agronomo;
import gestorAplicacion.empleado.Campesino;
import gestorAplicacion.terreno.Cultivo;
import gestorAplicacion.terreno.Terreno;
import javafx.application.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.*;
import manejoErrores.*;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Esta clase define los elementos que tendrá la escena puesta en la ventana
 * principal de usuario. Tiene como fin definir y crear la escena que
 * reemplazará la escena inical del Stage. En dicha escena, generada por esta
 * clase, se observarán todos los formularios dispuestos para las disferentes
 * consultas y funcionalidades de las que dispone el programa. De igual forma,
 * esta clase realiza dichos procesos de consultas y funcionalidades del
 * aplicativo ya que es quien recibe la información brindada por el usuario para
 * tales fines.
 *
 */
public class Principal {
	Scene principal;
	/**
	 * Instancia de la clase Inicio con la que esta asociado la ventana Principal
	 * {@link Inicio}
	 */
	Inicio linkInicio;

	BorderPane vBox0;

	GridPane formulario = new GridPane();
	/** Vista para contratar un agronomo {@link BuildContrartarAgronomo} */
	BuildContrartarAgronomo iContratarAgronomo;
	/** Vista para contratar un campesino {@link BuildContrartarCampesino} */
	BuildContrartarCampesino iContratarCampesino;
	/** Vista para despedir un campesino {@link BuildDespedirCampesino} */
	BuildDespedirCampesino iDespedirCampesino;
	/** Vista para despedir un agronomo {@link BuildDespedirAgronomo} */
	BuildDespedirAgronomo iDespedirAgronomo;
	/**
	 * Vista para la produccion total de los cultivos {@link BuildProduccionTotal}
	 */
	BuildProduccionTotal iProduccionTotal;
	/** Vista para exminar un cultivo {@link BuildExaminarCultivo} */
	BuildExaminarCultivo iExaminarCultivo;
	/** Vista para cultivar en un terreno {@link BuildCultivar} */
	BuildCultivar iCultivar;
	/** Vista para cosechar un cultivo {@link BuildCosechar} */
	BuildCosechar iCosechar;
	/** Vista para agregar un terreno {@link BuildAddTerreno} */
	BuildAddTerreno iAddTerreno;
	/** Vista para fertilizar e irrigar un terreno {@link iFertilizarIrrigar} */
	BuildFertilizarIrrigar iFertilizarIrrigar;

	MenuItem agronomo1;
	MenuItem campesino1;
	MenuItem agronomo2;
	MenuItem campesino2;
	MenuItem totalProduction;
	MenuItem examinarCultivo;
	MenuItem cultivar;
	MenuItem cosechar;
	MenuItem addTerreno;
	MenuItem fertelizarIrrigar;

	ArrayList<String> cedulasCampesinos;
	String idTerrenoSeleccionado;
	String cedulaSeleccionada;
	String cedulaAgronomo;
	String cultivoSeleccionado;

	public static int amenazasFallidas = 0;

	public Scene crearPrincipal() {
		VBox vBoxRoot = new VBox();
		Label nombrePrograma = new Label("Cultivatron");
		nombrePrograma.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		nombrePrograma.setPadding(new Insets(15));
		vBoxRoot.getChildren().add(nombrePrograma);
		vBox0 = new BorderPane();
		vBoxRoot.getChildren().add(vBox0);
		principal = new Scene(vBoxRoot, 1240, 580);

		TextArea instructions = new TextArea(
				"El aplicativo creado simula el comportamiento de procesos agrícolas básicos como asignación de terrenos, creación de cultivos, recolección, sembrado, ataque de pestes y contratación de personal.\r\n"
						+ "\n"
						+ "Se permite al usuario tener un manejo y visión generales de los componentes básicos presentes para la administración adecuada de los mismos. Al registrar terrenos el usuario tiene la libertad de sembrar en ellos cultivos de los siguientes tipos: banano, papa, sandía, mango y fresa pero en cada terreno solo se permite un tipo, quiere decir que si en un terreno ya hay un cultivo de papa no puede haber otro de papa, pero sí puede haber de otros tipos. Dichos cultivos tienen ciertas especificaciones de elementos que requieren para poder cultivarse; niveles de nitrógeno, potasio, fósforo y además una adecuada irrigación, estas propiedades deben estar presentes en el terreno donde se desean plantar. El usuario podrá observar dicha información en el programa. \r\n"
						+ "\n"
						+ "Los empleados que el usuario puede contratar se derivan en campesinos y agrónomos, donde los campesinos se asignan a un solo terreno y allí se encargan de labores como sembrado y recolección de cultivos. Además cuando se requiera fertilizar un terreno para que este sea apto para la siembra de todos los tipos de cultivos el campesino será el encargado de llevar a cabo dicha tarea. Por otro lado, los agrónomos, de los cuales habrá uno por cada terreno, se encargan de orientar a los campesinos y de aplicar los pesticidas adecuados para cada amenaza cuando un cultivo esté bajo ataque de alguna, pues existen tres tipos de pestes que atacan a los cultivos: maleza, hongo y plagas, para las cuales se tiene sus respectivos pesticidas.\r\n"
						+ "");
		instructions.setFont(Font.font("Bahnschrift", FontWeight.THIN, 16));
		instructions.setWrapText(true);
		instructions.setPrefHeight(400);
		instructions.setEditable(false);
		vBox0.setMargin(instructions, new Insets(30));
		vBox0.setCenter(instructions);
		// MenuBar
		MenuBar barraPrincipal = new MenuBar();

		// Menu de Archivo
		Menu archivo = new Menu("Archivo");
		MenuItem usuario = new MenuItem("Usuario");
		MenuItem salir = new MenuItem("Salir");
		archivo.getItems().addAll(usuario, new SeparatorMenuItem(), salir);

		usuario.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Alert a = new Alert(AlertType.INFORMATION);
				a.setTitle("Nombre de la aplicacion");
				// Definir el encabezado de la alerta
				a.setHeaderText("Cultivatron");
				// Mostrar el dialog
				a.show();
			}
		});
		salir.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				/** Usamos el atributo que hace referencia a la instancia de la clase Inicio */
				linkInicio.windowInicio.setScene(linkInicio.inicio);
			}
		});
		// Termina el menu Archivo

		// Menu de procesos y consultas
		Menu procesos_Consultas = new Menu("Procesos y consultas");
		// Submenu de contratar
		Menu subMenuContratar = new Menu("Contratar");
		agronomo1 = new MenuItem("Agronomo");
		campesino1 = new MenuItem("Campesino");
		subMenuContratar.getItems().addAll(agronomo1, new SeparatorMenuItem(), campesino1);
		// termina submenu de contratar
		// Submenu de despedir
		Menu subMenuDespedir = new Menu("Despedir");
		agronomo2 = new MenuItem("Agronomo");
		campesino2 = new MenuItem("Campesino");
		subMenuDespedir.getItems().addAll(agronomo2, new SeparatorMenuItem(), campesino2);
		// termina submenu de despedir

		totalProduction = new MenuItem("Produccion total");
		examinarCultivo = new MenuItem("Examinar cultivo");
		cultivar = new MenuItem("Cultivar");
		cosechar = new MenuItem("Cosechar");
		addTerreno = new MenuItem("Agregar terreno");
		fertelizarIrrigar = new MenuItem("Fertilizar e irrigar");

		procesos_Consultas.getItems().addAll(subMenuContratar, new SeparatorMenuItem(), subMenuDespedir);
		procesos_Consultas.getItems().addAll(new SeparatorMenuItem(), totalProduction);
		procesos_Consultas.getItems().addAll(new SeparatorMenuItem(), examinarCultivo);
		procesos_Consultas.getItems().addAll(new SeparatorMenuItem(), cultivar);
		procesos_Consultas.getItems().addAll(new SeparatorMenuItem(), cosechar);
		procesos_Consultas.getItems().addAll(new SeparatorMenuItem(), addTerreno);
		procesos_Consultas.getItems().addAll(new SeparatorMenuItem(), fertelizarIrrigar);
		// Termina menu de procesos y consultas

		Menu ayuda = new Menu("Ayuda");
		MenuItem acercaDe = new MenuItem("Acerca de");
		acercaDe.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Alert a = new Alert(AlertType.INFORMATION);

				a.setTitle("Nombres de autores");
				a.setHeaderText("Cultivatron");
				a.setContentText("Sergio \nJose \nJan \nLeimar \nSantiago");
				a.show();
			}
		});
		ayuda.getItems().add(acercaDe);
		barraPrincipal.getMenus().addAll(archivo, procesos_Consultas, ayuda);
		vBox0.setTop(barraPrincipal);
		vBox0.setMargin(barraPrincipal, new Insets(15));

		/** Handlers contratar */
		HandlerMenu handler = new HandlerMenu();
		agronomo1.setOnAction(handler);
		HandlerMenu handlerC = new HandlerMenu();
		campesino1.setOnAction(handlerC);

		/** Handlers despedir */
		HandlerMenu handlerDA = new HandlerMenu();
		agronomo2.setOnAction(handlerDA);
		HandlerMenu handlerDC = new HandlerMenu();
		campesino2.setOnAction(handlerDC);

		/** Handler produccion total */
		HandlerMenu handlerTP = new HandlerMenu();
		totalProduction.setOnAction(handlerTP);

		/** Handler examinarCultivo */
		HandlerMenu handlerEC = new HandlerMenu();
		examinarCultivo.setOnAction(handlerEC);

		/** Handler cultivar */
		HandlerMenu handlerCul = new HandlerMenu();
		cultivar.setOnAction(handlerCul);

		/** Handler cosechar */
		HandlerMenu handlerCos = new HandlerMenu();
		cosechar.setOnAction(handlerCos);

		/** Handler addTerreno */
		HandlerMenu handlerTer = new HandlerMenu();
		addTerreno.setOnAction(handlerTer);

		/** Handler fertilizarIrrigar */
		HandlerMenu handlerFer = new HandlerMenu();
		fertelizarIrrigar.setOnAction(handlerFer);

		return principal;

	}

	/**
	 * Metodo que hace una renuncia aleatoria del personal
	 */
	private static void renunciaAleatoria() {
		String campesinoRenuncia = new Campesino().renunciar();
		String agronomoRenuncia = new Agronomo().renunciar();
		if (!campesinoRenuncia.equals("No renuncia")) {
			Alert alertaRenuncia = new Alert(AlertType.WARNING);
			alertaRenuncia.setHeaderText(campesinoRenuncia);
			alertaRenuncia.setContentText("Ha renunciado");
			alertaRenuncia.show();
		}
		if (!agronomoRenuncia.equals("No renuncia")) {
			Alert alertaRenuncia = new Alert(AlertType.WARNING);
			alertaRenuncia.setHeaderText(agronomoRenuncia);
			alertaRenuncia.setContentText("Ha renunciado");
			alertaRenuncia.show();
		}
	}

	/**
	 * Metodo que verifia si se creo un amaenza bajo los criterios del sistema y
	 * avisa al usario
	 */
	private static void controlAmenazas() {
		Amenaza amenaza = new Amenaza();
		if (amenaza.esMomentoDeAmenazar() && amenaza.atacarCultivo()) {
			Alert alertaAmenaza = new Alert(AlertType.WARNING);
			alertaAmenaza.setHeaderText("La amenaza: " + amenaza.getTipo() + " esta atacando al cultivo "
					+ amenaza.getCultivo().getTipoCultivo() + " en el terreno con id "
					+ amenaza.getCultivo().getTerreno().getId() + "\n");
			alertaAmenaza.show();
		} else {
			amenazasFallidas++;
		}

	}

	/** Handler para las acciones hechas sobre el menu */
	class HandlerMenu implements EventHandler<ActionEvent> {
		@SuppressWarnings("unchecked")
		public void handle(ActionEvent e) {

			controlAmenazas();
			renunciaAleatoria();

			Object control = e.getSource();
			if (control instanceof MenuItem) {
				/** Contratar un agronomo */
				if (control.equals(agronomo1)) {
					try {
						Terreno.verificacionTerrenos();
						iContratarAgronomo = new BuildContrartarAgronomo();
						VBox vBoxBase = iContratarAgronomo.vBoxBase();
						vBox0.setCenter(vBoxBase);
						iContratarAgronomo.terrenosCombo.valueProperty().addListener(new ChangeListener<String>() {
							@Override
							public void changed(ObservableValue ov, String t, String idTerreno) {
								idTerrenoSeleccionado = idTerreno;
							}
						});
						agronomoHandlerClass hContratarAgronomo = new agronomoHandlerClass();
						iContratarAgronomo.aceptarAgronomo.setOnAction(hContratarAgronomo);
						iContratarAgronomo.borrarAgronomo.setOnAction(hContratarAgronomo);
					} catch (NoHayTerrenosException excep) {
						Alert alertaTerreno = new Alert(AlertType.ERROR);
						alertaTerreno.setHeaderText(excep.getMessage());
						alertaTerreno.setContentText(excep.getMensaje());
						alertaTerreno.show();
					}
					/** Contratar un campesino */
				} else if (control.equals(campesino1)) {
					try {
						Terreno.verificacionTerrenos();
						iContratarCampesino = new BuildContrartarCampesino();
						VBox vBoxBase = iContratarCampesino.vBoxBase();
						vBox0.setCenter(vBoxBase);

						iContratarCampesino.terrenosCombo.valueProperty().addListener(new ChangeListener<String>() {
							@Override
							public void changed(ObservableValue ov, String t, String idTerreno) {
								idTerrenoSeleccionado = idTerreno;
							}
						});

						campesinoHandlerClass hContratarCampesino = new campesinoHandlerClass();
						iContratarCampesino.aceptarCampesino.setOnAction(hContratarCampesino);
						iContratarCampesino.borrarCampesino.setOnAction(hContratarCampesino);
					} catch (NoHayTerrenosException excep) {
						Alert alertaTerreno = new Alert(AlertType.ERROR);
						alertaTerreno.setHeaderText(excep.getMessage());
						alertaTerreno.setContentText(excep.getMensaje());
						alertaTerreno.show();
					}
					/** Despedir un campesino */
				} else if (control.equals(campesino2)) {
					try {
						Terreno.verificacionTerrenos();
						iDespedirCampesino = new BuildDespedirCampesino();
						VBox vBoxBase = iDespedirCampesino.vBoxBase();
						vBox0.setCenter(vBoxBase);
						iDespedirCampesino.comboBoxTerrenos.valueProperty().addListener(new ChangeListener<String>() {
							@Override
							public void changed(ObservableValue ov, String t, String idTerreno) {
								Terreno terrenoToDespedir = Terreno.buscarTerreno(idTerreno);
								int sizeComboBoxCampesinos = iDespedirCampesino.comboBoxCampesinos.getItems().size();
								for (int j = 0; j < sizeComboBoxCampesinos; j++) {
									iDespedirCampesino.comboBoxCampesinos.getItems().remove(0);
								}
								try {
									Terreno.verificacionCampesino(terrenoToDespedir);
									iDespedirCampesino.comboBoxCampesinos.getItems()
											.addAll(terrenoToDespedir.getCedulasCampesinos());
									idTerrenoSeleccionado = idTerreno;
								} catch (NoHayCampesinoException excep) {
									Alert alertaTerreno = new Alert(AlertType.ERROR);
									alertaTerreno.setHeaderText(excep.getMessage());
									alertaTerreno.setContentText(excep.getMensaje());
									alertaTerreno.show();
								}
							}
						});
						iDespedirCampesino.comboBoxCampesinos.valueProperty().addListener(new ChangeListener<String>() {
							@Override
							public void changed(ObservableValue ov, String t, String cedula) {
								cedulaSeleccionada = cedula;
							}
						});
						campesinoHandlerClass hDespedirCampesino = new campesinoHandlerClass();
						iDespedirCampesino.aceptarDespedirCampesino.setOnAction(hDespedirCampesino);
					} catch (NoHayTerrenosException excep) {
						Alert alertaTerreno = new Alert(AlertType.ERROR);
						alertaTerreno.setHeaderText(excep.getMessage());
						alertaTerreno.setContentText(excep.getMensaje());
						alertaTerreno.show();
					}
					/** Despedir un agronomo */
				} else if (control.equals(agronomo2)) {
					try {
						Terreno.verificacionTerrenos();
						Agronomo.verificarDespedirAgronomo();
						iDespedirAgronomo = new BuildDespedirAgronomo();
						VBox vBoxBase = iDespedirAgronomo.vBoxBase();
						vBox0.setCenter(vBoxBase);
						iDespedirAgronomo.comboBoxCedulaA.valueProperty().addListener(new ChangeListener<String>() {
							@Override
							public void changed(ObservableValue ov, String t, String cedulaA) {
								cedulaAgronomo = cedulaA;
							}
						});
						agronomoHandlerClass hDespedirAgronomo = new agronomoHandlerClass();
						iDespedirAgronomo.aceptarDespedirAgronomo.setOnAction(hDespedirAgronomo);
					} catch (NoHayTerrenosException excep) {
						Alert alertaTerreno = new Alert(AlertType.ERROR);
						alertaTerreno.setHeaderText(excep.getMessage());
						alertaTerreno.setContentText(excep.getMensaje());
						alertaTerreno.show();
					} catch (NoHayAgronomoException excep) {
						Alert alertaTerreno = new Alert(AlertType.ERROR);
						alertaTerreno.setHeaderText(excep.getMessage());
						alertaTerreno.setContentText(excep.getMensaje());
						alertaTerreno.show();
					}
					/** Total de la produccion de los cultivos */
				} else if (control.equals(totalProduction)) {
					iProduccionTotal = new BuildProduccionTotal();
					VBox vBoxBase = iProduccionTotal.vBoxBase();
					vBox0.setCenter(vBoxBase);
					/** Examinar un cultivo */
				} else if (control.equals(examinarCultivo)) {
					try {
						Cultivo.verificacionCultivos();
						iExaminarCultivo = new BuildExaminarCultivo();
						VBox vBoxBase = iExaminarCultivo.vBoxBase();
						vBox0.setCenter(vBoxBase);
						iExaminarCultivo.comboBoxCultivos.valueProperty().addListener(new ChangeListener<String>() {
							@Override
							public void changed(ObservableValue ov, String t, String cultivo) {
								cultivoSeleccionado = cultivo;
							}
						});
						CultivoHandlerClass examinarHandler = new CultivoHandlerClass();
						iExaminarCultivo.aceptarExaminarCultivo.setOnAction(examinarHandler);
					} catch (NoHayCultivoException excep) {
						Alert alertaTerreno = new Alert(AlertType.ERROR);
						alertaTerreno.setHeaderText(excep.getMessage());
						alertaTerreno.setContentText(excep.getMensaje());
						alertaTerreno.show();
					}
					/** Cultivar un tipo de cultivo en un terreno */
				} else if (control.equals(cultivar)) {
					try {
						Terreno.verificacionTerrenos();
						iCultivar = new BuildCultivar();
						VBox vBoxBase = iCultivar.vBoxBase();
						vBox0.setCenter(vBoxBase);
						iCultivar.terrenosCombo.valueProperty().addListener(new ChangeListener<String>() {
							@Override
							public void changed(ObservableValue ov, String t, String terreno) {
								idTerrenoSeleccionado = terreno;
							}
						});
						CultivoHandlerClass cultivarHandler = new CultivoHandlerClass();
						iCultivar.aceptarCultivar.setOnAction(cultivarHandler);
						iCultivar.borrarCultivar.setOnAction(cultivarHandler);
					} catch (NoHayTerrenosException excep) {
						Alert alertaTerreno = new Alert(AlertType.ERROR);
						alertaTerreno.setHeaderText(excep.getMessage());
						alertaTerreno.setContentText(excep.getMensaje());
						alertaTerreno.show();
					}
					/** Cosechar un cultivo */
				} else if (control.equals(cosechar)) {
					try {
						Terreno.verificacionTerrenos();
						iCosechar = new BuildCosechar();
						VBox vBoxBase = iCosechar.vBoxBase();
						vBox0.setCenter(vBoxBase);
						iCosechar.terrenosCombo.valueProperty().addListener(new ChangeListener<String>() {
							@Override
							public void changed(ObservableValue ov, String t, String terreno) {
								idTerrenoSeleccionado = terreno;
							}
						});
						CultivoHandlerClass cosecharHandler = new CultivoHandlerClass();
						iCosechar.aceptarCosechar.setOnAction(cosecharHandler);
					} catch (NoHayTerrenosException excep) {
						Alert alertaTerreno = new Alert(AlertType.ERROR);
						alertaTerreno.setHeaderText(excep.getMessage());
						alertaTerreno.setContentText(excep.getMensaje());
						alertaTerreno.show();
					}
					/** Agregar un terreno */
				} else if (control.equals(addTerreno)) {
					iAddTerreno = new BuildAddTerreno();
					VBox vBoxBase = iAddTerreno.vBoxBase();
					vBox0.setCenter(vBoxBase);

					TerrenoHandlerClass terrenoHandler = new TerrenoHandlerClass();
					iAddTerreno.aceptarAddTerreno.setOnAction(terrenoHandler);
					iAddTerreno.borrarAddTerreno.setOnAction(terrenoHandler);
					/** fertilizar un terreno para poder ser cultivado */
				} else if (control.equals(fertelizarIrrigar)) {
					try {
						Terreno.verificacionTerrenos();
						iFertilizarIrrigar = new BuildFertilizarIrrigar();
						VBox vBoxBase = iFertilizarIrrigar.vBoxBase();
						vBox0.setCenter(vBoxBase);
						iFertilizarIrrigar.terrenosCombo.valueProperty().addListener(new ChangeListener<String>() {
							@Override
							public void changed(ObservableValue ov, String t, String terreno) {
								idTerrenoSeleccionado = terreno;
							}
						});
						campesinoHandlerClass hFertilizarIrrigar = new campesinoHandlerClass();
						iFertilizarIrrigar.aceptarFertilizarIrrigar.setOnAction(hFertilizarIrrigar);
					} catch (NoHayTerrenosException excep) {
						Alert alertaTerreno = new Alert(AlertType.ERROR);
						alertaTerreno.setHeaderText(excep.getMessage());
						alertaTerreno.setContentText(excep.getMensaje());
						alertaTerreno.show();
					}
				}
			}
		}
	}

	/** Handler para las acciones que tienen que ver con los agronomos */
	class agronomoHandlerClass implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
			Object control = e.getSource();
			// si se quiere contratar un agronomo
			if (iContratarAgronomo != null && control.equals(iContratarAgronomo.aceptarAgronomo)) {
				try {
					// Verificiar que exista un terreno
					Terreno terrenoSeleccionadoAgronomo = Terreno.buscarTerreno(idTerrenoSeleccionado);
					Terreno.verificacionContratarAgronomo(terrenoSeleccionadoAgronomo);
					try {
						int sueldo = Integer.parseInt(iContratarAgronomo.contratarAgronomo.getValue(1));
						int cedula = Integer.parseInt(iContratarAgronomo.contratarAgronomo.getValue(2));
						Agronomo agro = new Agronomo(iContratarAgronomo.contratarAgronomo.getValue(0), sueldo, cedula,
								terrenoSeleccionadoAgronomo);
						Alert contratoAgronomo = new Alert(AlertType.INFORMATION);
						contratoAgronomo.setHeaderText(agro.toString());
						contratoAgronomo.setContentText("Ha sido contratado");
						contratoAgronomo.show();
						iContratarAgronomo.contratarAgronomo.borrarValue();
					} catch (NumberFormatException excep) {
						Alert alertaDato = new Alert(AlertType.ERROR);
						alertaDato.setHeaderText("Se ha ingresado un tipo de dato no valido");
						alertaDato.show();
					}

				} catch (NoHayAgronomoException excep) {
					Alert alertaAgronomo = new Alert(AlertType.ERROR);
					alertaAgronomo.setHeaderText(excep.getMessage());
					alertaAgronomo.setContentText(excep.getMensaje());
					alertaAgronomo.show();
				} catch (IndexOutOfBoundsException excep) {
					Alert alertaDato = new Alert(AlertType.ERROR);
					alertaDato.setHeaderText("Ha dejado un campo vacio");
					alertaDato.show();
				} catch (NullPointerException excep) {
					Alert alertaDato = new Alert(AlertType.ERROR);
					alertaDato.setHeaderText("Se ha ingresado un tipo de dato no valido");
					alertaDato.show();
				}
				// Si se quiere borrar la vista de contratar un agronomo
			} else if (iContratarAgronomo != null && control.equals(iContratarAgronomo.borrarAgronomo)) {
				iContratarAgronomo.contratarAgronomo.borrarValue();
				/// Si se quiere despedir un agronomo
			} else if (iDespedirAgronomo != null && control.equals(iDespedirAgronomo.aceptarDespedirAgronomo)) {
				Agronomo agronomoOut = Agronomo.getAgronomo(Integer.parseInt(cedulaAgronomo));
				agronomoOut.renunciar(Agronomo.getAgronomos().indexOf(agronomoOut));
				iDespedirAgronomo.comboBoxCedulaA.getItems().remove(cedulaAgronomo);
				Alert despidoAgronomo = new Alert(AlertType.INFORMATION);
				despidoAgronomo.setHeaderText(agronomoOut.toString());
				despidoAgronomo.setContentText("Ha sido despedido");
				despidoAgronomo.show();
			}
		}
	}

	/** Handler para las acciones que tienen que ver con los campesinos */
	class campesinoHandlerClass implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
			Object control = e.getSource();
			// Si se quiere contratar un campesino
			if (iContratarCampesino != null && control.equals(iContratarCampesino.aceptarCampesino)) {
				try {
					Terreno terrenoSeleccionadoCampesino = Terreno.buscarTerreno(idTerrenoSeleccionado);
					int sueldo = Integer.parseInt(iContratarCampesino.contratarCampesino.getValue(1));
					int cedula = Integer.parseInt(iContratarCampesino.contratarCampesino.getValue(2));
					Campesino campe = new Campesino(iContratarCampesino.contratarCampesino.getValue(0), sueldo, cedula,
							terrenoSeleccionadoCampesino);
					Alert contratoCampesino = new Alert(AlertType.INFORMATION);
					contratoCampesino.setHeaderText(campe.toString());
					contratoCampesino.setContentText("Ha sido contratado");
					contratoCampesino.show();
					iContratarCampesino.contratarCampesino.borrarValue();
				} catch (NumberFormatException excep) {
					Alert alertaDato = new Alert(AlertType.ERROR);
					alertaDato.setHeaderText("Se ha ingresado un tipo de dato no valido");
					alertaDato.show();
				}
				// Si se quiere borrar la vista de contratar un campesino
			} else if (iContratarCampesino != null && control.equals(iContratarCampesino.borrarCampesino)) {
				iContratarCampesino.contratarCampesino.borrarValue();
				// Si se quiere despedir un campesino
			} else if (iDespedirCampesino != null && control.equals(iDespedirCampesino.aceptarDespedirCampesino)) {
				try {
					Terreno terrenoCampesino = Terreno.buscarTerreno(idTerrenoSeleccionado);
					Campesino campesinoDespedido = new Campesino();
					campesinoDespedido = Campesino.buscarCampesino(terrenoCampesino,
							Integer.parseInt(cedulaSeleccionada));
					campesinoDespedido.renunciar(terrenoCampesino, campesinoDespedido);
					iDespedirCampesino.comboBoxCampesinos.getItems().remove(cedulaSeleccionada);
					Alert despidoCampesino = new Alert(AlertType.INFORMATION);
					despidoCampesino.setHeaderText(campesinoDespedido.toString());
					despidoCampesino.setContentText("Ha sido despedido");
					despidoCampesino.show();
				} catch (NumberFormatException excep) {
					Alert alertaDato = new Alert(AlertType.ERROR);
					alertaDato.setHeaderText("Se ha ingresado un tipo de dato no valido");
					alertaDato.show();
				}
				// cuando se quiere fertilizar un terreno con algun campesino
			} else if (iFertilizarIrrigar != null && control.equals(iFertilizarIrrigar.aceptarFertilizarIrrigar)) {

				try {
					Terreno tierraMala = Terreno.buscarTerreno(idTerrenoSeleccionado);
					int index = Terreno.getTerrenos().indexOf(tierraMala);
					Terreno.verificacionCampesino(index);
					Campesino irrigador = tierraMala.getCampesinos().getLast();
					irrigador.fertilizar(tierraMala);
					int sizeComboBoxTerrenos = iFertilizarIrrigar.terrenosCombo.getItems().size();
					for (int j = 0; j < sizeComboBoxTerrenos; j++) {
						iFertilizarIrrigar.terrenosCombo.getItems().remove(0);
					}
					iFertilizarIrrigar.terrenosCombo.getItems().addAll(Terreno.mostrarTerrenosGUI());
					Alert fertilizar = new Alert(AlertType.INFORMATION);
					fertilizar.setHeaderText("El terreno ha sido fertilizado");
					fertilizar.show();
				} catch (NoHayCampesinoException excep) {
					int sizeComboBoxTerrenos = iFertilizarIrrigar.terrenosCombo.getItems().size();
					for (int j = 0; j < sizeComboBoxTerrenos; j++) {
						iFertilizarIrrigar.terrenosCombo.getItems().remove(0);
					}
					Alert alertaCampesino = new Alert(AlertType.ERROR);
					alertaCampesino.setHeaderText(excep.getMessage());
					alertaCampesino.setContentText(excep.getMensaje());
					Optional<ButtonType> result = alertaCampesino.showAndWait();
					if (result.isPresent() && result.get() == ButtonType.OK) {
						iFertilizarIrrigar.terrenosCombo.getItems().addAll(Terreno.mostrarTerrenosGUI());
					}
				} catch (IndexOutOfBoundsException excep) {
					Alert alertaDato = new Alert(AlertType.ERROR);
					alertaDato.setHeaderText("Ha dejado un campo vacio");
					alertaDato.show();
				}
			}
		}
	}

	/** Handler para las acciones que tienen que ver con los cultivos */
	class CultivoHandlerClass implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
			Object control = e.getSource();
			Terreno terrenoU;
			Cultivo cultivoU;
			// Si se quiere examinar un cultivo
			if (iExaminarCultivo != null && control.equals(iExaminarCultivo.aceptarExaminarCultivo)) {
				try {
					String tipo = "";
					String terreno = "";
					boolean amenaza;
					boolean lado = false;
					for (int i = 0; i < cultivoSeleccionado.length(); i++) {
						if (cultivoSeleccionado.charAt(i) != "-".charAt(0) && lado == false) {
							tipo += cultivoSeleccionado.charAt(i);
						} else if (cultivoSeleccionado.charAt(i) == "-".charAt(0)) {
							lado = true;
						} else {
							terreno += cultivoSeleccionado.charAt(i);
						}
					}
					terrenoU = Terreno.buscarTerreno(terreno);
					terrenoU.verificacionAgronomoExterminar(terrenoU);
					cultivoU = terrenoU.buscarCultivo(tipo);
					int sizeComboBoxCultivos = iExaminarCultivo.comboBoxCultivos.getItems().size();
					for (int j = 0; j < sizeComboBoxCultivos; j++) {
						iExaminarCultivo.comboBoxCultivos.getItems().remove(0);
					}
					if (cultivoU.getAmenaza() != null) {
						Alert amenazaU = new Alert(AlertType.WARNING);
						amenazaU.setTitle(" CUIDADO !! ");
						// Definir el encabezado de la alerta
						amenazaU.setHeaderText(" Tienes una amenaza en el cultivo seleccionado, ¿Desea exterminarla? ");
						// Mostrar el dialog
						ButtonType type = new ButtonType("Cancelar", ButtonData.CANCEL_CLOSE);
						amenazaU.getDialogPane().getButtonTypes().add(type);
						Optional<ButtonType> result = amenazaU.showAndWait();
						if (result.isPresent() && result.get() == ButtonType.OK) {
							Amenaza amenazaExterminar = cultivoU.getAmenaza();
							Agronomo.erradicarAmenaza(amenazaExterminar, cultivoU);
							iExaminarCultivo.comboBoxCultivos.getItems().addAll(Cultivo.mostrarCultivosGUI());
						} else {
							iExaminarCultivo.comboBoxCultivos.getItems().addAll(Cultivo.mostrarCultivosGUI());
						}
					} else {
						Alert noAmenaza = new Alert(AlertType.INFORMATION);
						noAmenaza.setTitle("Tranquilo");
						noAmenaza.setHeaderText("El cultivo seleccionado no tiene amenazas");
						Optional<ButtonType> result = noAmenaza.showAndWait();
						if (result.isPresent() && result.get() == ButtonType.OK) {
							iExaminarCultivo.comboBoxCultivos.getItems().addAll(Cultivo.mostrarCultivosGUI());
						}
					}

				} catch (NoAgronomoToExterminarException excep) {
					Alert alertaAgronomo = new Alert(AlertType.ERROR);
					alertaAgronomo.setHeaderText(excep.getMessage());
					alertaAgronomo.setContentText(excep.getMensaje());
					alertaAgronomo.show();
				} catch (NullPointerException excep) {
					Alert noDato = new Alert(AlertType.ERROR);
					noDato.setHeaderText("¡Debe seleccionar un cultivo!");
					noDato.show();
				}
				// Si se quire cultivar un cultivo
				// Comprobar que el usuario ingrese un tamaño apropiado, un cultivo permitido
				// segun el terreno, y un tipo cultivo que no se haya creado anteriormente en
				// ese terreno
			} else if (iCultivar != null && control.equals(iCultivar.aceptarCultivar)) {
				try {
					Terreno terrenoUsuario;
					terrenoUsuario = Terreno.buscarTerreno(idTerrenoSeleccionado);
					Terreno.verificacionCampesino(Terreno.getTerrenos().indexOf(terrenoUsuario));
					int tamano = Integer.parseInt(iCultivar.cultivar.getValue(0));
					terrenoUsuario.verificarTamano(tamano);
					if (terrenoUsuario.getCultivoPermitido().size() != 0) {
						ChoiceDialog tipoCultivos = new ChoiceDialog(terrenoUsuario.getCultivoPermitido().get(0),
								terrenoUsuario.getCultivoPermitido());
						tipoCultivos.setHeaderText("Cultivos Permitidos");
						tipoCultivos.setContentText("Seleccione un cultivo que es permitido");
						Optional<ButtonType> result = tipoCultivos.showAndWait();
						if (result.isPresent() && ButtonType.OK.getText().equals("Aceptar") || ButtonType.OK.getText().equals("OK")) {
							String tipoSeleccionado = (String) tipoCultivos.getSelectedItem();
							// Se puede usar la variable resultado para verificar si se creó (devuelve "se
							// ha creado exitosamente" en el caso afirmativo)
							String resultado = (Cultivo.crearCultivo(tipoSeleccionado, tamano, terrenoUsuario));
							if (resultado.equals("Se ha creado exitosamente")) {
								Alert crearCultivo = new Alert(AlertType.INFORMATION);
								crearCultivo.setHeaderText("El cultivo se ha creado exitosamente");
								crearCultivo.show();
							} else {
								Alert crearCultivo = new Alert(AlertType.WARNING);
								crearCultivo.setHeaderText("Este cultivo ya estaba creado en este terreno");
								crearCultivo.show();
							}
						} else {

						}
					} else {
						Alert alertaCultivos = new Alert(AlertType.ERROR);
						alertaCultivos
								.setHeaderText("No se puede cultivar en este terreno, por favor, fertilice e irrigue");
						alertaCultivos.show();
					}
				} catch (NoHayCampesinoException excep) {
					Alert alertaCampesino = new Alert(AlertType.ERROR);
					alertaCampesino.setHeaderText(excep.getMessage());
					alertaCampesino.setContentText(excep.getMensaje());
					alertaCampesino.show();
				} catch (TamanoExcedidoException excep) {
					Alert alertaTamano = new Alert(AlertType.ERROR);
					alertaTamano.setHeaderText(excep.getMessage());
					alertaTamano.setContentText(excep.getMensaje());
					alertaTamano.show();
				} catch (NumberFormatException excep) {
					Alert alertaDato = new Alert(AlertType.ERROR);
					alertaDato.setHeaderText("Se ha ingresado un tipo de dato no valido");
					alertaDato.show();
				} catch (IndexOutOfBoundsException excep) {
					Alert alertaDato = new Alert(AlertType.ERROR);
					alertaDato.setHeaderText("Ha dejado un campo vacio");
					alertaDato.show();
				}
				// si se quiere elimar la vista para cultivar un cultivo
			} else if (iCultivar != null && control.equals(iCultivar.borrarCultivar)) {
				iCultivar.cultivar.borrarValue();
			}
			// si se quiere cosechar un cultivo
			else if (iCosechar != null && control.equals(iCosechar.aceptarCosechar)) {
				try {
					Terreno terrenoUsuario;
					terrenoUsuario = Terreno.buscarTerreno(idTerrenoSeleccionado);
					Terreno.verificacionCampesino(Terreno.getTerrenos().indexOf(terrenoUsuario));
					if (terrenoUsuario.getCultivos().isEmpty()) {
						Alert alertaDato = new Alert(AlertType.ERROR);
						alertaDato.setHeaderText("¡No tienes cultivos para recolectar en este terreno!");
						alertaDato.show();
					} else {
						ChoiceDialog tipoCultivos = new ChoiceDialog(terrenoUsuario.getTipos().get(0),
								terrenoUsuario.getTipos());
						tipoCultivos.setHeaderText("Cultivos");
						tipoCultivos.setContentText("Seleccione un cultivo para recolectar");
						Optional<ButtonType> result = tipoCultivos.showAndWait();
						if (result.isPresent() && ButtonType.OK.getText().equals("Aceptar") || ButtonType.OK.getText().equals("OK")) {
							String tipoSeleccionado = (String) tipoCultivos.getSelectedItem();
							Cultivo cultivoRecolectar = terrenoUsuario.buscarCultivo(tipoSeleccionado);
							cultivoRecolectar.verificacionAmenaza();
							Campesino recolector = terrenoUsuario.getCampesinos().peek(); // Verificación de que haya
																							// campesinos, si no pailas
							recolector.recolectar(cultivoRecolectar);
							Alert recolectarCultivo = new Alert(AlertType.INFORMATION);
							recolectarCultivo.setHeaderText("Cultivo recolectado");
							recolectarCultivo.show();
						} else {

						}
					}
				} catch (NoHayCampesinoException excep) {
					Alert alertaCampesino = new Alert(AlertType.ERROR);
					alertaCampesino.setHeaderText(excep.getMessage());
					alertaCampesino.setContentText(excep.getMensaje());
					alertaCampesino.show();
				} catch (IndexOutOfBoundsException excep) {
					Alert alertaDato = new Alert(AlertType.ERROR);
					alertaDato.setHeaderText("Ha dejado un campo vacio");
					alertaDato.show();
				} catch (CultivoAmenazaException excep) {
					Alert alertaAmenaza = new Alert(AlertType.ERROR);
					alertaAmenaza.setHeaderText(excep.getMessage());
					alertaAmenaza.setContentText(excep.getMensaje());
					alertaAmenaza.show();
				}
			}

		}

	}

	/** Handler para las acciones que tienen que ver con los terrenos */
	class TerrenoHandlerClass implements EventHandler<ActionEvent> {

		public void handle(ActionEvent evento) {
			Object control = evento.getSource();
			// Si se quiere agregar un terreno
			if (iAddTerreno != null && control.equals(iAddTerreno.aceptarAddTerreno)) {
				try {
					String idTerreno = iAddTerreno.AddTerreno.getValue(0);
					Terreno.verificacionIdTerrenos(idTerreno);
					int tamanoTerreno = Integer.parseInt(iAddTerreno.AddTerreno.getValue(1));
					Terreno terrenoCreado = new Terreno(idTerreno, tamanoTerreno);
					Alert crearTerreno = new Alert(AlertType.INFORMATION);
					crearTerreno.setHeaderText(terrenoCreado.toString());
					crearTerreno.show();
					iAddTerreno.AddTerreno.borrarValue();
				} catch (IdTerrenoException excep) {
					Alert alertaID = new Alert(AlertType.ERROR);
					alertaID.setHeaderText(excep.getMessage());
					alertaID.setContentText(excep.getMensaje());
					alertaID.show();
				} catch (NumberFormatException excep) {
					Alert alertaDato = new Alert(AlertType.ERROR);
					alertaDato.setHeaderText("Se ha ingresado un tipo de dato no valido");
					alertaDato.show();
				}
			} else if (iAddTerreno != null && control.equals(iAddTerreno.borrarAddTerreno)) {
				iAddTerreno.AddTerreno.borrarValue();
			}
		}
	}
}
