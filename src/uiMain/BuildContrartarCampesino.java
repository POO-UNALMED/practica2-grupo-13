package uiMain;

import gestorAplicacion.terreno.Terreno;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class BuildContrartarCampesino {
	Label consulta = new Label();
	Label descripcionConsulta = new Label();
	VBox vBoxContratarCampesino = new VBox();
	FieldPanel contratarCampesino;
	ComboBox terrenosCombo;
	Button aceptarCampesino;
	Button borrarCampesino;
	public VBox vBoxBase() {
		consulta.setPadding(new Insets(25));
		descripcionConsulta.setPadding(new Insets(25));
		consulta.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		descripcionConsulta.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		vBoxContratarCampesino.getChildren().addAll(consulta,descripcionConsulta);
		consulta.setText("Contratar Campesino");
		descripcionConsulta.setText("Vincula un campesino a un terreno");
		vBoxContratarCampesino.setAlignment(Pos.CENTER);
		
		String[] campos = {"Nombre", "Sueldo", "Cedula"};
		String[] valores = {"", "", ""};
		boolean[] editable = {true, true, true};
		contratarCampesino = new FieldPanel("Datos campesino", campos, "Ingrese aqui", valores, editable); 
		terrenosCombo = new ComboBox(FXCollections.observableArrayList(Terreno.mostrarTerrenosGUI()));
		terrenosCombo.setPrefWidth(150);
		contratarCampesino.formulario.add(new Label("Terreno"), 0, 4, 2, 1);
		contratarCampesino.formulario.add(terrenosCombo, 2, 4, 3, 1);
		
		vBoxContratarCampesino.getChildren().add(contratarCampesino.formulario);
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
		vBoxContratarCampesino.getChildren().add(botonesContratarCampesino);
		
		return vBoxContratarCampesino;
	}
}
