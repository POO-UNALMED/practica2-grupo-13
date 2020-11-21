package uiMain;

import gestorAplicacion.terreno.Terreno;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class BuildDespedirCampesino {
	Label consulta = new Label();
	Label descripcionConsulta = new Label();
	Label tituloCriterios;
	Label tituloValores;
	VBox vBoxDespedirCampesino = new VBox();
	GridPane formulario = new GridPane();
	ComboBox comboBoxTerrenos;
	ComboBox comboBoxCampesinos;
	Button aceptarDespedirCampesino;
	public VBox vBoxBase() {
		consulta.setPadding(new Insets(25));
		descripcionConsulta.setPadding(new Insets(25));
		consulta.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		descripcionConsulta.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		vBoxDespedirCampesino.getChildren().addAll(consulta,descripcionConsulta);
		consulta.setText("Despedir Campesino");
		descripcionConsulta.setText("Desvincula un campesino de un terreno");
		vBoxDespedirCampesino.setAlignment(Pos.CENTER);
		
		tituloCriterios = new Label("Datos Campesino");
		tituloCriterios.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		tituloValores = new Label("Ingrese aqui");
		tituloValores.setFont(Font.font("Verdana", FontWeight.BOLD, 11));
		
		formulario.setVgap(13);
		formulario.setHgap(35);	
		formulario.add(this.tituloCriterios, 0, 0, 2, 1);
		formulario.add(this.tituloValores, 2, 0, 3, 1);
		formulario.add(new Label("Terreno"), 0, 1, 2, 1);
		formulario.add(new Label("Campesino"), 0, 2, 2, 1);
		comboBoxTerrenos = new ComboBox(FXCollections.observableArrayList(Terreno.mostrarTerrenosGUI()));
		comboBoxCampesinos = new ComboBox();
		comboBoxCampesinos.setEditable(false);
		formulario.add(comboBoxTerrenos, 2, 1, 3, 1);
		formulario.add(comboBoxCampesinos, 2, 2, 3, 1);
		
		vBoxDespedirCampesino.getChildren().add(formulario);
		formulario.setAlignment(Pos.CENTER);
		
		HBox botonesDespedirCampesino = new HBox();
		aceptarDespedirCampesino = new Button(" Aceptar ");
		botonesDespedirCampesino.getChildren().add(aceptarDespedirCampesino);
		aceptarDespedirCampesino.setAlignment(Pos.CENTER);
		botonesDespedirCampesino.setAlignment(Pos.CENTER);
		botonesDespedirCampesino.setMargin(aceptarDespedirCampesino, new Insets(20));
		botonesDespedirCampesino.setPadding(new Insets(20));
		vBoxDespedirCampesino.getChildren().add(botonesDespedirCampesino);
		
		return vBoxDespedirCampesino;
	}
}
