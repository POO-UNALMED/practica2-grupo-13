package uiMain;

import java.util.LinkedList;

import gestorAplicacion.empleado.Agronomo;
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
	
	MenuItem agronomo1;
	MenuItem campesino1;

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
		MenuItem agronomo2 = new MenuItem("Agronomo");
		MenuItem campesino2 = new MenuItem("Campesino");
		subMenuDespedir.getItems().addAll(agronomo2, new SeparatorMenuItem(), campesino2);
		// termina submenu de despedir

		MenuItem totalProduction = new MenuItem("Produccion total");
		MenuItem examinarCultivo = new MenuItem("Examinar cultivo");
		MenuItem cultivar = new MenuItem("Cultivar");
		MenuItem cosechar = new MenuItem("Cosechar");
		MenuItem addTerreno = new MenuItem("Agregar terreno");
		MenuItem fertelizarIrrigar = new MenuItem("Fertilizar e irrigar");

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
		
		//Handlers
		HandlerMenu handler = new HandlerMenu();
		agronomo1.setOnAction(handler);
		
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
					descripcionConsulta.setText("Vincula un agronomo a la app");
					String[] campos = {"Nombre", "Sueldo", "Cedula", "Terrenio"};
					String[] valores = {"Nombre", "Sueldo", "Cedula", "Terrenio"};
					boolean[] editable = {true, true, true, true};
					FieldPanel contratarAgronomo = new FieldPanel("Datos agronomo", campos, "Ingrese aqui", valores, editable); 
					vBox1.getChildren().addAll(contratarAgronomo.formulario);
				}
				
			}
		}	
	}

}
