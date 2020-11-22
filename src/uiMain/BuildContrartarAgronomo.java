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

public class BuildContrartarAgronomo {
	Label consulta = new Label();
	Label descripcionConsulta = new Label();
	VBox vBoxContratarAgronomo = new VBox();
	FieldPanel contratarAgronomo;
	ComboBox terrenosCombo;
	Button aceptarAgronomo;
	Button borrarAgronomo;
	public VBox vBoxBase() {
		consulta.setPadding(new Insets(25));
		descripcionConsulta.setPadding(new Insets(25));
		consulta.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		descripcionConsulta.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		vBoxContratarAgronomo.getChildren().addAll(consulta,descripcionConsulta);
		consulta.setText("Contratar Agronomo");
		descripcionConsulta.setText("Vincula un agronomo a un terreno");
		vBoxContratarAgronomo.setAlignment(Pos.CENTER);
		
		String[] campos = {"Nombre", "Sueldo", "Cedula"};
		String[] valores = {"", "", ""};
		boolean[] editable = {true, true, true};
		contratarAgronomo = new FieldPanel("Datos agronomo", campos, "Ingrese aqui", valores, editable);
		terrenosCombo = new ComboBox(FXCollections.observableArrayList(Terreno.mostrarTerrenosGUI()));
		terrenosCombo.setPrefWidth(150);
		contratarAgronomo.formulario.add(new Label("Terreno"), 0, 4, 2, 1);
		contratarAgronomo.formulario.add(terrenosCombo, 2, 4, 3, 1);
		
		vBoxContratarAgronomo.getChildren().add(contratarAgronomo.formulario);
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
		vBoxContratarAgronomo.getChildren().add(botonesContratarAgronomo);
		
		return vBoxContratarAgronomo;
	}
}
