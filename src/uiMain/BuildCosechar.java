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

public class BuildCosechar {
	Label consulta = new Label();
	Label descripcionConsulta = new Label();
	VBox vBoxCosechar = new VBox();
	FieldPanel Cosechar;
	ComboBox terrenosCombo;
	Button aceptarCosechar;
	Button borrarCosechar;
	
	public VBox vBoxBase() {
		consulta.setPadding(new Insets(25));
		descripcionConsulta.setPadding(new Insets(25));
		consulta.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		descripcionConsulta.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		vBoxCosechar.getChildren().addAll(consulta,descripcionConsulta);
		consulta.setText("Cosechar");
		descripcionConsulta.setText("Recolecta la cosecha seleccionada");
		vBoxCosechar.setAlignment(Pos.CENTER);
		
		String[] campos = {"Terreno" };
		String[] valores = {""};
		boolean[] editable = {};
		Cosechar = new FieldPanel("", campos, "Seleccionar terreno", valores, editable);
		terrenosCombo = new ComboBox(FXCollections.observableArrayList(Terreno.mostrarTerrenosGUI()));
		terrenosCombo.setPrefWidth(150);
		Cosechar.formulario.add(terrenosCombo, 2, 1, 3, 1);
		
		vBoxCosechar.getChildren().add(Cosechar.formulario);
		Cosechar.formulario.setAlignment(Pos.CENTER);
		
		HBox botonesCosechar = new HBox();
		aceptarCosechar = new Button(" Aceptar ");
		botonesCosechar.getChildren().addAll(aceptarCosechar);
		aceptarCosechar.setAlignment(Pos.CENTER);
		botonesCosechar.setAlignment(Pos.CENTER);
		botonesCosechar.setPadding(new Insets(20));
		botonesCosechar.setMargin(aceptarCosechar, new Insets(20));
		vBoxCosechar.getChildren().add(botonesCosechar);
		
		return vBoxCosechar;
	}
}
