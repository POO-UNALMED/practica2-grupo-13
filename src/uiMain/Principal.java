package uiMain;

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

public class Principal {
	Scene principal;
	/**
	 * Instancia de la clase Inicio con la que esta asociado la ventana Principal
	 */
	Inicio linkInicio;

	BorderPane vBox0;
	
	GridPane formulario = new GridPane();
	
	
	BuildContrartarAgronomo iContratarAgronomo;
	BuildContrartarCampesino iContratarCampesino;
	BuildDespedirCampesino iDespedirCampesino;
	BuildDespedirAgronomo iDespedirAgronomo;
	BuildProduccionTotal iProduccionTotal;
	BuildExaminarCultivo iExaminarCultivo;
	BuildCultivar iCultivar;
	BuildCosechar iCosechar;
	BuildAddTerreno iAddTerreno;
	BuildFertilizarIrrigar iFertilizarIrrigar;
	
	FieldPanel despedirAgronomo;
	
	
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
	
	ComboBox comboBoxAddTerreno;
	ComboBox comboBoxAddTerrenoC;
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
				"El aplicativo creado simula el comportamiento de procesos agrícolas básicos como asignación de terrenos, creación de cultivos, recolección, sembrado, ataque de pestes y contratación de personal.\r\n" + "\n"
						+ "Se permite al usuario tener un manejo y visión generales de los componentes básicos presentes para la administración adecuada de los mismos. Al registrar terrenos el usuario tiene la libertad de sembrar en ellos cultivos de los siguientes tipos: banano, papa, sandía, mango y fresa pero en cada terreno solo se permite un tipo, quiere decir que si en un terreno ya hay un cultivo de papa no puede haber otro de papa, pero sí puede haber de otros tipos. Dichos cultivos tienen ciertas especificaciones de elementos que requieren para poder cultivarse; niveles de nitrógeno, potasio, fósforo y además una adecuada irrigación, estas propiedades deben estar presentes en el terreno donde se desean plantar. El usuario podrá observar dicha información en el programa. \r\n"
				   +"\n"+ "Los empleados que el usuario puede contratar se derivan en campesinos y agrónomos, donde los campesinos se asignan a un solo terreno y allí se encargan de labores como sembrado y recolección de cultivos. Además cuando se requiera fertilizar un terreno para que este sea apto para la siembra de todos los tipos de cultivos el campesino será el encargado de llevar a cabo dicha tarea. Por otro lado, los agrónomos, de los cuales habrá uno por cada terreno, se encargan de orientar a los campesinos y de aplicar los pesticidas adecuados para cada amenaza cuando un cultivo esté bajo ataque de alguna, pues existen tres tipos de pestes que atacan a los cultivos: maleza, hongo y plagas, para las cuales se tiene sus respectivos pesticidas.\r\n"
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

		// ComboBox terrenos = new ComboBox(FXCollections.observableArrayList(numbers));

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
				// Definir el encabezado de la alerta
				a.setContentText("Sergio \nJose \nJan \nLeimar \nSantiago");
				a.show();
			}
		});
		
		//Handlers contratar
		HandlerMenu handler = new HandlerMenu();
		agronomo1.setOnAction(handler);
		HandlerMenu handlerC = new HandlerMenu();
		campesino1.setOnAction(handlerC);
		
		//Handlers despedir
		HandlerMenu handlerDA = new HandlerMenu();
		agronomo2.setOnAction(handlerDA);
		HandlerMenu handlerDC = new HandlerMenu();
		campesino2.setOnAction(handlerDC);
		
		//Handler produccion total
		HandlerMenu handlerTP = new HandlerMenu();
		totalProduction.setOnAction(handlerTP);
		
		//Handler examinarCultivo
		HandlerMenu handlerEC = new HandlerMenu();
		examinarCultivo.setOnAction(handlerEC);
		
		//Handler cultivar
		HandlerMenu handlerCul = new HandlerMenu();
		cultivar.setOnAction(handlerCul);
		
		//Handler cosechar
		HandlerMenu handlerCos = new HandlerMenu();
		cosechar.setOnAction(handlerCos);
		
		//Handler addTerreno
		HandlerMenu handlerTer = new HandlerMenu();
		addTerreno.setOnAction(handlerTer);
		
		//Handler fertilizarIrrigar
		HandlerMenu handlerFer = new HandlerMenu();
		fertelizarIrrigar.setOnAction(handlerFer);
		
		
		ayuda.getItems().add(acercaDe);
		barraPrincipal.getMenus().addAll(archivo, procesos_Consultas, ayuda);
		vBox0.setTop(barraPrincipal);
		vBox0.setMargin(barraPrincipal, new Insets(15));
		return principal;

	}
	class HandlerMenu implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e) {
			Object control=e.getSource();
			if(control instanceof MenuItem){
					if(control.equals(agronomo1)){						
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
						}catch(NoHayTerrenosException excep) {
							Alert alertaTerreno = new Alert(AlertType.ERROR);
							alertaTerreno.setHeaderText(excep.getMessage());
							alertaTerreno.setContentText(excep.mensaje);
							alertaTerreno.show();
						}	
					}else if (control.equals(campesino1)) {
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
						}catch(DominioException excep) {
							Alert alertaTerreno = new Alert(AlertType.ERROR);
							alertaTerreno.setHeaderText(excep.getMessage());
							alertaTerreno.setContentText("No dispone de terrenos, por favor cree uno");
							alertaTerreno.show();
						}							
					}else if(control.equals(campesino2)) {
						try {
							Terreno.verificacionTerrenos();
							iDespedirCampesino = new BuildDespedirCampesino();
							VBox vBoxBase = iDespedirCampesino.vBoxBase();
							vBox0.setCenter(vBoxBase);
							iDespedirCampesino.comboBoxTerrenos.valueProperty().addListener(new ChangeListener<String>() {
								@Override
								public void changed(ObservableValue ov, String t, String idTerreno){
									Terreno terrenoToDespedir = Terreno.buscarTerreno(idTerreno);
									int sizeComboBoxCampesinos = iDespedirCampesino.comboBoxCampesinos.getItems().size();
									for (int j = 0; j < sizeComboBoxCampesinos; j++) {
										iDespedirCampesino.comboBoxCampesinos.getItems().remove(0);
									}
									try {
										Campesino.verificarCampesinos(Terreno.getTerrenos().indexOf(terrenoToDespedir));
										iDespedirCampesino.comboBoxCampesinos.getItems().addAll(terrenoToDespedir.getCedulasCampesinos());
										idTerrenoSeleccionado = idTerreno;
									}catch(PersonasException excep) {
										Alert alertaTerreno = new Alert(AlertType.ERROR);
										alertaTerreno.setHeaderText(excep.getMessage());
										alertaTerreno.setContentText("No hay campesinos contratados");
										alertaTerreno.show();
									}							
								}
							});							
						}catch(DominioException excep) {
							Alert alertaTerreno = new Alert(AlertType.ERROR);
							alertaTerreno.setHeaderText(excep.getMessage());
							alertaTerreno.setContentText("No dispone de terrenos, por favor cree uno");
							alertaTerreno.show();
						}

						iDespedirCampesino.comboBoxCampesinos.valueProperty().addListener(new ChangeListener<String>() {
							@Override
							public void changed(ObservableValue ov, String t, String cedula) {
								cedulaSeleccionada = cedula;
							}
						});
						campesinoHandlerClass hDespedirCampesino = new campesinoHandlerClass();
						iDespedirCampesino.aceptarDespedirCampesino.setOnAction(hDespedirCampesino);	
				}else if(control.equals(agronomo2)) {//despedir
					try {
						Terreno.verificacionTerrenos();
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
					}catch(DominioException excep) {
						Alert alertaTerreno = new Alert(AlertType.ERROR);
						alertaTerreno.setHeaderText(excep.getMessage());
						alertaTerreno.setContentText("No dispone de terrenos, por favor cree uno");
						alertaTerreno.show();
					}		
				}else if(control.equals(totalProduction)) {
					iProduccionTotal = new BuildProduccionTotal();
					VBox vBoxBase = iProduccionTotal.vBoxBase();
					vBox0.setCenter(vBoxBase);
				}else if(control.equals(examinarCultivo)) {
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
					
				}else if(control.equals(cultivar)) {
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
					
				}else if(control.equals(cosechar)) {
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
					
				}else if(control.equals(addTerreno)) {
					iAddTerreno = new BuildAddTerreno();
					VBox vBoxBase = iAddTerreno.vBoxBase();
					vBox0.setCenter(vBoxBase);
					
					TerrenoHandlerClass terrenoHandler = new TerrenoHandlerClass();
					iAddTerreno.aceptarAddTerreno.setOnAction(terrenoHandler);
					iAddTerreno.borrarAddTerreno.setOnAction(terrenoHandler);
					
				}else if(control.equals(fertelizarIrrigar)) {
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
				}
			}
		}	
	}
	
	class agronomoHandlerClass implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e) {
			Object control = e.getSource();	
			if (iContratarAgronomo!=null && control.equals(iContratarAgronomo.aceptarAgronomo)) { // Verificiar con un catch que si exista un terreno
				try {
					Terreno terrenoSeleccionadoAgronomo = Terreno.buscarTerreno(idTerrenoSeleccionado);
					Terreno.verificacionAgronomo(Terreno.getTerrenos().indexOf(terrenoSeleccionadoAgronomo));
					try {
						int sueldo = Integer.parseInt(iContratarAgronomo.contratarAgronomo.getValue(1));
						int cedula = Integer.parseInt(iContratarAgronomo.contratarAgronomo.getValue(2));
						Agronomo agro = new Agronomo(iContratarAgronomo.contratarAgronomo.getValue(0), sueldo, cedula, terrenoSeleccionadoAgronomo);
						System.out.println(agro);
					}catch(NumberFormatException excep) {
						Alert alertaDato= new Alert(AlertType.ERROR);
						alertaDato.setHeaderText("Se ha ingresado un tipo de dato no valido");
						alertaDato.show();
					}	
			
				}catch(PersonasException excep) {
					Alert alertaAgronomo = new Alert(AlertType.ERROR);
					alertaAgronomo.setHeaderText(excep.getMessage());
					alertaAgronomo.setContentText("El terreno seleccionado ya posee un agronomo");
					alertaAgronomo.show();
				}catch(IndexOutOfBoundsException excep) {
					Alert alertaDato = new Alert(AlertType.ERROR);
					alertaDato.setHeaderText("Ha dejado un campo vacio");
					alertaDato.show();
				}
			}
			else if (iContratarAgronomo!=null && control.equals(iContratarAgronomo.borrarAgronomo)) {
				iContratarAgronomo.contratarAgronomo.borrarValue();
			}else if(iDespedirAgronomo!=null && control.equals(iDespedirAgronomo.aceptarDespedirAgronomo)) {
				Agronomo  agronomoOut = Agronomo.getAgronomo(Integer.parseInt(cedulaAgronomo));
				agronomoOut.renunciar(Agronomo.getAgronomos().indexOf(agronomoOut));
			    iDespedirAgronomo.comboBoxCedulaA.getItems().remove(cedulaAgronomo);
			
			}
		}
	}
	class campesinoHandlerClass implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e) {
			Object control = e.getSource();	
			if (iContratarCampesino!=null && control.equals(iContratarCampesino.aceptarCampesino)) {
				try {
					Terreno terrenoSeleccionadoCampesino = Terreno.buscarTerreno(idTerrenoSeleccionado);
					int sueldo = Integer.parseInt(iContratarCampesino.contratarCampesino.getValue(1));
					int cedula = Integer.parseInt(iContratarCampesino.contratarCampesino.getValue(2));
					Campesino campe = new Campesino(iContratarCampesino.contratarCampesino.getValue(0), sueldo, cedula, terrenoSeleccionadoCampesino);
				}catch(NumberFormatException excep) {
					Alert alertaDato= new Alert(AlertType.ERROR);
					alertaDato.setHeaderText("Se ha ingresado un tipo de dato no valido");
					alertaDato.show();
				}	
				
			}
			else if (iContratarCampesino!=null && control.equals(iContratarCampesino.borrarCampesino)) {
				iContratarCampesino.contratarCampesino.borrarValue();
			}else if(iDespedirCampesino!=null && control.equals(iDespedirCampesino.aceptarDespedirCampesino)) {		
				try {
					Terreno terrenoCampesino = Terreno.buscarTerreno(idTerrenoSeleccionado);
					Campesino campesinoDespedido = new Campesino();
					campesinoDespedido = Campesino.buscarCampesino(terrenoCampesino,Integer.parseInt(cedulaSeleccionada));
					campesinoDespedido.renunciar2(terrenoCampesino, campesinoDespedido);
					iDespedirCampesino.comboBoxCampesinos.getItems().remove(cedulaSeleccionada);
				}catch(NumberFormatException excep) {
					Alert alertaDato= new Alert(AlertType.ERROR);
					alertaDato.setHeaderText("Se ha ingresado un tipo de dato no valido");
					alertaDato.show();
				}	
			}else if(iFertilizarIrrigar!=null && control.equals(iFertilizarIrrigar.aceptarFertilizarIrrigar)) {
				Terreno tierraMala = Terreno.buscarTerreno(idTerrenoSeleccionado);
				Campesino irrigador = tierraMala.getCampesinos().getLast();
				irrigador.fertilizar(tierraMala);
			}
		}
	}
	
	class CultivoHandlerClass implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e) {
			Object control = e.getSource();
			Terreno terrenoU;
			Cultivo cultivoU;
			if (iExaminarCultivo != null && control.equals(iExaminarCultivo.aceptarExaminarCultivo)) {
				String tipo = "";
				String terreno = "";
				boolean amenaza;
				boolean lado = false;
				for (int i = 0; i < cultivoSeleccionado.length(); i ++) {
					if (cultivoSeleccionado.charAt(i) != "-".charAt(0) && lado == false) {
						tipo += cultivoSeleccionado.charAt(i);
					}else if (cultivoSeleccionado.charAt(i) == "-".charAt(0)) {
						lado = true;
					}else {
						terreno += cultivoSeleccionado.charAt(i);
					}
				}
				terrenoU = Terreno.buscarTerreno(terreno);
				cultivoU = terrenoU.buscarCultivo(tipo);
				System.out.println(terrenoU.getCultivos());
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
						 System.out.println("Si eee");
					 }
					
				}else {
					Alert noAmenaza = new Alert(AlertType.INFORMATION);
					noAmenaza.setTitle("Tranquilo");
					// Definir el encabezado de la alerta
					noAmenaza.setHeaderText("El cultivo seleccionado no tiene amenazas");
					// Mostrar el dialog
					noAmenaza.show();
				}
				
// Comprobar que el usuario ingrese un tamaño apropiado,  un cultivo permitido segun el terreno, y un tipo cultivo que no se haya creado anteriormente en ese terreno
			}else if (iCultivar != null && control.equals(iCultivar.aceptarCultivar)) { 
				Terreno terrenoUsuario;
				terrenoUsuario = Terreno.buscarTerreno(idTerrenoSeleccionado);
				ChoiceDialog tipoCultivos = new ChoiceDialog(terrenoUsuario.getCultivoPermitido().get(0),terrenoUsuario.getCultivoPermitido());				
		       	tipoCultivos.setHeaderText("Cultivos Permitidos"); 
		      	tipoCultivos.setContentText("Seleccione un cultivo que es permitido"); 
		      	tipoCultivos.showAndWait(); 
		      	String tipoSeleccionado = (String) tipoCultivos.getSelectedItem();
		      	
// Se puede usar la variable resultado para verificar si se creó (devuelve "se ha creado exitosamente" en el caso afirmativo)
		      	String resultado = (Cultivo.crearCultivo(tipoSeleccionado, Integer.parseInt(iCultivar.cultivar.getValue(0)), terrenoUsuario));
		      	System.out.println(resultado);
			}else if (iCultivar != null && control.equals(iCultivar.borrarCultivar)) {
				iCultivar.cultivar.borrarValue();
			}
			
			else if(iCosechar != null && control.equals(iCosechar.aceptarCosechar)) {
				Terreno terrenoUsuario;
				terrenoUsuario = Terreno.buscarTerreno(idTerrenoSeleccionado);
				ChoiceDialog tipoCultivos = new ChoiceDialog(terrenoUsuario.getTipos().get(0),terrenoUsuario.getTipos());				
		       	tipoCultivos.setHeaderText("Cultivos"); 
		      	tipoCultivos.setContentText("Seleccione un cultivo para recolectar"); 
		      	tipoCultivos.showAndWait(); 
		      	String tipoSeleccionado = (String) tipoCultivos.getSelectedItem();
		      	Cultivo cultivoRecolectar = terrenoUsuario.buscarCultivo(tipoSeleccionado);
		      	Campesino recolector = terrenoUsuario.getCampesinos().peek(); //Verificación de que haya campesinos, si no pailas 
		      	recolector.recolectar(cultivoRecolectar);
		      	
			}		
			
		} 
		
	}
	class TerrenoHandlerClass implements EventHandler<ActionEvent>{
		
		public void handle(ActionEvent evento) {
			Object control = evento.getSource();
			if(iAddTerreno != null && control.equals(iAddTerreno.aceptarAddTerreno)) {
				Terreno terrenoCreado = new Terreno(iAddTerreno.AddTerreno.getValue(0), Integer.parseInt(iAddTerreno.AddTerreno.getValue(1)));
				System.out.println(terrenoCreado.toString());
			}else if(iAddTerreno != null && control.equals(iAddTerreno.borrarAddTerreno)){
				iAddTerreno.AddTerreno.borrarValue();
			}
		}
	}

}
