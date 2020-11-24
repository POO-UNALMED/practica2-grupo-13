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
/**
 * 
 *Esta clase define elementos escenciales para la escena puesta en la ventana
 *principal de usuario, su principal objetivo es crear un VBox base que será puesto 
 *en la escena antes mencionada, en él se evidenciarán los componentes necesarios
 *para el formulario específico de la funcionalidad *Fertilizar e irrigar*, puesta
 *en el menú de  funcionalidades proporcionadas por le programa
 *
 */
public class BuildFertilizarIrrigar {
	Label consulta = new Label();
	Label descripcionConsulta = new Label();
	VBox vBoxFertilizarIrrigar = new VBox();
	FieldPanel FertilizarIrrigar;
	ComboBox terrenosCombo;
	Button aceptarFertilizarIrrigar;
	
	public VBox vBoxBase() {
		consulta.setPadding(new Insets(25));
		descripcionConsulta.setPadding(new Insets(25));
		consulta.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		descripcionConsulta.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		vBoxFertilizarIrrigar.getChildren().addAll(consulta,descripcionConsulta);
		consulta.setText("Fertilizar e Irrigar");
		descripcionConsulta.setText("Fertiliza e irriga el terreno elegido");
		vBoxFertilizarIrrigar.setAlignment(Pos.CENTER);
		
		String[] campos = {"Terreno" };
		String[] valores = {""};
		boolean[] editable = {};
		FertilizarIrrigar = new FieldPanel("", campos, "Seleccionar terreno", valores, editable);
		terrenosCombo = new ComboBox(FXCollections.observableArrayList(Terreno.mostrarTerrenosGUI()));
		terrenosCombo.setPrefWidth(150);
		FertilizarIrrigar.formulario.add(terrenosCombo, 2, 1, 3, 1);
		
		vBoxFertilizarIrrigar.getChildren().add(FertilizarIrrigar.formulario);
		FertilizarIrrigar.formulario.setAlignment(Pos.CENTER);
		
		HBox botonesFertilizarIrrigar = new HBox();
		aceptarFertilizarIrrigar = new Button(" Aceptar ");
		aceptarFertilizarIrrigar.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
		botonesFertilizarIrrigar.getChildren().addAll(aceptarFertilizarIrrigar);
		aceptarFertilizarIrrigar.setAlignment(Pos.CENTER);
		botonesFertilizarIrrigar.setAlignment(Pos.CENTER);
		botonesFertilizarIrrigar.setPadding(new Insets(20));
		botonesFertilizarIrrigar.setMargin(aceptarFertilizarIrrigar, new Insets(20));
		vBoxFertilizarIrrigar.getChildren().add(botonesFertilizarIrrigar);
		
		return vBoxFertilizarIrrigar;
	}
}
