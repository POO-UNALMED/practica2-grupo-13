package uiMain;

import java.util.ArrayList;
import java.util.LinkedList;

import gestorAplicacion.empleado.Agronomo;
import gestorAplicacion.empleado.Campesino;
import gestorAplicacion.terreno.Terreno;
import javafx.application.*;
import javafx.collections.FXCollections;
import javafx.geometry.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.*;
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
	Label consulta = new Label();
	Label descripcionConsulta = new Label();
	GridPane formulario = new GridPane();
	VBox vBox1;
	FieldPanel contratarAgronomo;
	FieldPanel contratarCampesino;
	FieldPanel despedirAgronomo;
	FieldPanel despedirCampesino;
	
	
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
	
	Button aceptarAgronomo;
	Button borrarAgronomo;
	Button aceptarCampesino;
	Button borrarCampesino;

	public Scene crearPrincipal() {
		VBox vBox0 = new VBox();
		vBox1 = new VBox();
		vBox1.setAlignment(Pos.CENTER);
		
		
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
		
		//Label
		consulta.setPadding(new Insets(25));
		descripcionConsulta.setPadding(new Insets(25));
		consulta.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		descripcionConsulta.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		
		
		ayuda.getItems().add(acercaDe);
		barraPrincipal.getMenus().addAll(archivo, procesos_Consultas, ayuda);
		vBox1.setMargin(barraPrincipal, new Insets(15));
		vBox1.getChildren().add(barraPrincipal);
		vBox0.getChildren().add(vBox1);
		return principal;

	}
	class HandlerMenu implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e) {
			Object control=e.getSource();
			if(control instanceof MenuItem){
				if(control.equals(agronomo1)){
					
					vBox1.getChildren().addAll(consulta,descripcionConsulta);
					consulta.setText("Contratar Agronomo");
					descripcionConsulta.setText("Vincula un agronomo a un terreno");
					String[] campos = {"Nombre", "Sueldo", "Cedula", "Terreno"};
					String[] valores = {"", "", "", ""};
					boolean[] editable = {true, true, true, true};
					contratarAgronomo = new FieldPanel("Datos agronomo", campos, "Ingrese aqui", valores, editable, Terreno.mostrarTerrenosGUI()); 
					vBox1.getChildren().addAll(contratarAgronomo.formulario);
					contratarAgronomo.formulario.setAlignment(Pos.CENTER);
					
					HBox botonesContratarAgronomo = new HBox();
					aceptarAgronomo = new Button(" Aceptar ");
					borrarAgronomo = new Button(" Borrar ");
					botonesContratarAgronomo.getChildren().addAll(aceptarAgronomo,borrarAgronomo);
					aceptarAgronomo.setAlignment(Pos.CENTER);
					borrarAgronomo.setAlignment(Pos.CENTER);
					botonesContratarAgronomo.setAlignment(Pos.CENTER);
					botonesContratarAgronomo.setPadding(new Insets(20));
					botonesContratarAgronomo.setMargin(aceptarAgronomo, new Insets(20));
					botonesContratarAgronomo.setMargin(borrarAgronomo, new Insets(20));
					vBox1.getChildren().add(botonesContratarAgronomo);
					
					agronomoHandlerClass hContratarAgronomo = new agronomoHandlerClass();
					aceptarAgronomo.setOnAction(hContratarAgronomo);
					borrarAgronomo.setOnAction(hContratarAgronomo);
					
				}else if (control.equals(campesino1)) {
					vBox1.getChildren().addAll(consulta,descripcionConsulta);
					consulta.setText("Contratar Campesino");
					descripcionConsulta.setText("Vincula un campesino a un terreno");
					String[] campos = {"Nombre", "Sueldo", "Cedula", "Terreno"};
					String[] valores = {"", "", "", ""};
					boolean[] editable = {true, true, true, true};
					contratarCampesino = new FieldPanel("Datos campesino", campos, "Ingrese aqui", valores, editable,Terreno.mostrarTerrenosGUI()); 
					vBox1.getChildren().addAll(contratarCampesino.formulario);
					contratarCampesino.formulario.setAlignment(Pos.CENTER);
										
					HBox botonesContratarCampesino = new HBox();
					aceptarCampesino = new Button(" Aceptar ");
					borrarCampesino = new Button(" Borrar ");
					botonesContratarCampesino.getChildren().addAll(aceptarCampesino,borrarCampesino);
					aceptarCampesino.setAlignment(Pos.CENTER);
					borrarCampesino.setAlignment(Pos.CENTER);
					botonesContratarCampesino.setAlignment(Pos.CENTER);
					botonesContratarCampesino.setPadding(new Insets(20));
					botonesContratarCampesino.setMargin(aceptarCampesino, new Insets(20));
					botonesContratarCampesino.setMargin(borrarCampesino, new Insets(20));
					vBox1.getChildren().add(botonesContratarCampesino);
					
					campesinoHandlerClass hContratarCampesino = new campesinoHandlerClass();
					aceptarCampesino.setOnAction(hContratarCampesino);
					borrarCampesino.setOnAction(hContratarCampesino);
				}else if(control.equals(agronomo2)) {//despedir
					vBox1.getChildren().addAll(consulta,descripcionConsulta);
					consulta.setText("Despedir Agronomo");
					descripcionConsulta.setText("Desvincula un agronomo de un terreno");
					String[] campos = {"Agronomo"};
					String[] valores = {""};
					boolean[] editable = {true};
					
					despedirAgronomo = new FieldPanel("Datos Agronomo", campos, "Ingrese aqui", valores, editable,Agronomo.mostrarAgronomosGUI()); 
					vBox1.getChildren().addAll(despedirAgronomo.formulario);
					despedirAgronomo.formulario.setAlignment(Pos.CENTER);
				}else if(control.equals(campesino2)) {//despedir
					vBox1.getChildren().addAll(consulta,descripcionConsulta);
					consulta.setText("Despedir Campesino");
					descripcionConsulta.setText("Desvincula un campesino de un terreno");
					String[] campos = {"Terreno", "Campesino"};
					String[] valores = {"", ""};
					boolean[] editable = {true, true};
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
	
	class agronomoHandlerClass implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e) {
			Object control = e.getSource();	
			if (control.equals(aceptarAgronomo)) { // Verificiar con un catch que si exista un terreno
				Agronomo agro = new Agronomo(contratarAgronomo.getValue(0), Integer.parseInt(contratarAgronomo.getValue(1)), Integer.parseInt(contratarAgronomo.getValue(2)), new Terreno("12", 0));
			}
			else if (control.equals(borrarAgronomo)) {
				contratarAgronomo.borrarValue();
			}
		}
	}
	class campesinoHandlerClass implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e) {
			Object control = e.getSource();	
			if (control.equals(aceptarCampesino)) { // Verificiar con un catch que si exista un terreno
				Campesino campe = new Campesino(contratarCampesino.getValue(0), Integer.parseInt(contratarCampesino.getValue(1)), Integer.parseInt(contratarCampesino.getValue(2)), new Terreno("666", 0));
			}
			else if (control.equals(borrarCampesino)) {
				contratarCampesino.borrarValue();
			}
		}
	}

}
