package uiMain;

import java.util.ArrayList;
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
		vBox0 = new BorderPane();
		
		principal = new Scene(vBox0, 1240, 580);

		Label nombrePrograma = new Label("Cultivatron");

		// VBox0
		vBox0.getChildren().add(nombrePrograma);
		
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
					
				}else if (control.equals(campesino1)) {
					
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
					
					
					
				}else if(control.equals(campesino2)) {//despedir // Debemos revisar esta !!!!!!
					
					iDespedirCampesino = new BuildDespedirCampesino();
					VBox vBoxBase = iDespedirCampesino.vBoxBase();
					vBox0.setCenter(vBoxBase);
					iDespedirCampesino.comboBoxTerrenos.valueProperty().addListener(new ChangeListener<String>() {
						@Override
						public void changed(ObservableValue ov, String t, String idTerreno) {
							ArrayList<String> cedulasCampesinos = new ArrayList<String>();
							Terreno terrenoToDespedir = Terreno.buscarTerreno(idTerreno);
							
							for (Campesino i : terrenoToDespedir.getCampesinos()) {
								cedulasCampesinos.add(Integer.toString(i.getCedula()));
							}
							
							for (int j = 0; j < iDespedirCampesino.comboBoxCampesinos.getItems().size(); j++) {
								iDespedirCampesino.comboBoxCampesinos.getItems().remove(j);
							}
							iDespedirCampesino.comboBoxCampesinos.getItems().addAll(cedulasCampesinos);
							idTerrenoSeleccionado = idTerreno;
						}
					});
					iDespedirCampesino.comboBoxCampesinos.valueProperty().addListener(new ChangeListener<String>() {
						@Override
						public void changed(ObservableValue ov, String t, String cedula) {
							if (cedula!=null) { //                      Tal vez aquí haya un erros. OJO!!!!!!
							}
							cedulaSeleccionada = cedula;
						}
					});
					campesinoHandlerClass hDespedirCampesino = new campesinoHandlerClass();
					iDespedirCampesino.aceptarDespedirCampesino.setOnAction(hDespedirCampesino);
					
				}else if(control.equals(agronomo2)) {//despedir
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
				Terreno terrenoSeleccionadoAgronomo = Terreno.buscarTerreno(idTerrenoSeleccionado);
				Agronomo agro = new Agronomo(iContratarAgronomo.contratarAgronomo.getValue(0), Integer.parseInt(iContratarAgronomo.contratarAgronomo.getValue(1)), Integer.parseInt(iContratarAgronomo.contratarAgronomo.getValue(2)), terrenoSeleccionadoAgronomo);
				
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
			if (iContratarCampesino!=null && control.equals(iContratarCampesino.aceptarCampesino)) { // Verificiar con un catch que si exista un terreno
				Terreno terrenoSeleccionadoCampesino = Terreno.buscarTerreno(idTerrenoSeleccionado);
				Campesino campe = new Campesino(iContratarCampesino.contratarCampesino.getValue(0), Integer.parseInt(iContratarCampesino.contratarCampesino.getValue(1)), Integer.parseInt(iContratarCampesino.contratarCampesino.getValue(2)), terrenoSeleccionadoCampesino);
			}
			else if (iContratarCampesino!=null && control.equals(iContratarCampesino.borrarCampesino)) {
				iContratarCampesino.contratarCampesino.borrarValue();
			}else if(iDespedirCampesino!=null && control.equals(iDespedirCampesino.aceptarDespedirCampesino)) {				
				Terreno terrenoCampesino = Terreno.buscarTerreno(idTerrenoSeleccionado);
				Campesino campesinoDespedido = new Campesino();
				campesinoDespedido = Campesino.buscarCampesino(terrenoCampesino,Integer.parseInt(cedulaSeleccionada));
				campesinoDespedido.renunciar2(terrenoCampesino, campesinoDespedido);
				iDespedirCampesino.comboBoxCampesinos.getItems().remove(cedulaSeleccionada);
			}else if(iFertilizarIrrigar!=null && control.equals(iFertilizarIrrigar.aceptarFertilizarIrrigar)) {
				System.out.println("fertiliceeee");
				//ACABAR XDXDXDX
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
				ArrayList<String>cultivos=new ArrayList<String>();
				for (int j = 0; j < terrenoUsuario.getCultivos().size(); j++) {
					cultivos.add(terrenoUsuario.getCultivos().get(j).getTipoCultivo());
				}
				ChoiceDialog tipoCultivos = new ChoiceDialog(cultivos.get(0),cultivos);				
		       	tipoCultivos.setHeaderText("Cultivos"); 
		      	tipoCultivos.setContentText("Seleccione un cultivo para recolectar"); 
		      	tipoCultivos.showAndWait(); 
		      	String tipoSeleccionado = (String) tipoCultivos.getSelectedItem();
		      	//acabar michael
			}
		} 
	}

}
