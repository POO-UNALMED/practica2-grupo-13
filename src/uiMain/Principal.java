package uiMain;

import java.util.ArrayList;
import java.util.LinkedList;

import com.sun.javafx.scene.control.behavior.ComboBoxListViewBehavior;

import gestorAplicacion.empleado.Agronomo;
import gestorAplicacion.empleado.Campesino;
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
					
				}else if(control.equals(examinarCultivo)) {
					
				}else if(control.equals(cultivar)) {
					
				}else if(control.equals(cosechar)) {
					
				}else if(control.equals(addTerreno)) {
					
				}else if(control.equals(fertelizarIrrigar)) {
					
				}
			}
		}	
	}
	public Node getComboBox (final int row, final int column, GridPane gridPane) {
	    Node result = null;
	    ObservableList<Node> childrens = gridPane.getChildren();

	    for (Node node : childrens) {
	        if(gridPane.getRowIndex(node) == row && gridPane.getColumnIndex(node) == column) {
	            result = node;
	            break;
	        }
	    }

	    return result;
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
			}

		}
	}

}
