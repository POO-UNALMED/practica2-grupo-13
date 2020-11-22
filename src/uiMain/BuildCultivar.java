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

public class BuildCultivar {
 
	Label consulta = new Label();
	Label descripcionConsulta = new Label();
	VBox vBoxCultivar = new VBox();
	FieldPanel cultivar;
	ComboBox terrenosCombo;
	Button aceptarCultivar;
	Button borrarCultivar;
	
	public VBox vBoxBase() {
		consulta.setPadding(new Insets(25));
		descripcionConsulta.setPadding(new Insets(25));
		consulta.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		descripcionConsulta.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		vBoxCultivar.getChildren().addAll(consulta,descripcionConsulta);
		consulta.setText("Cultivar");
		descripcionConsulta.setText("Agrega un tipo de cultivo a el terreno seleccionado");
		vBoxCultivar.setAlignment(Pos.CENTER);
		
		String[] campos = {"Tama�o" };
		String[] valores = {""};
		boolean[] editable = {true};
		cultivar = new FieldPanel("Datos cultivo", campos, "Ingrese aqui", valores, editable);
		terrenosCombo = new ComboBox(FXCollections.observableArrayList(Terreno.mostrarTerrenosGUI()));
		terrenosCombo.setPrefWidth(150);
		cultivar.formulario.add(new Label("Terreno"), 0, 2, 2, 1);
		cultivar.formulario.add(terrenosCombo, 2, 2, 3, 1);
		
		vBoxCultivar.getChildren().add(cultivar.formulario);
		cultivar.formulario.setAlignment(Pos.CENTER);
		
		HBox botonesCultivar = new HBox();
		aceptarCultivar = new Button(" Aceptar ");
		borrarCultivar = new Button(" Borrar ");
		botonesCultivar.getChildren().addAll(aceptarCultivar,borrarCultivar);
		aceptarCultivar.setAlignment(Pos.CENTER);
		borrarCultivar.setAlignment(Pos.CENTER);
		botonesCultivar.setAlignment(Pos.CENTER);
		botonesCultivar.setPadding(new Insets(20));
		botonesCultivar.setMargin(aceptarCultivar, new Insets(20));
		botonesCultivar.setMargin(borrarCultivar, new Insets(20));
		vBoxCultivar.getChildren().add(botonesCultivar);
		
		return vBoxCultivar;
	}
	
	
}
