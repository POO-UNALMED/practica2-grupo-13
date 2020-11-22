package uiMain;

import gestorAplicacion.empleado.Agronomo;
import gestorAplicacion.terreno.Cultivo;
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

public class BuildExaminarCultivo {

	
	Label consulta = new Label();
	Label descripcionConsulta = new Label();
	Label tituloCriterios;
	Label tituloValores;
	VBox vBoxExaminarCultivo = new VBox();
	GridPane formulario = new GridPane();
	ComboBox comboBoxCultivos;
	Button aceptarExaminarCultivo;
		
	public VBox vBoxBase() {
		consulta.setPadding(new Insets(25));
		descripcionConsulta.setPadding(new Insets(25));
		consulta.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		descripcionConsulta.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		vBoxExaminarCultivo.getChildren().addAll(consulta,descripcionConsulta);
		consulta.setText("Examinar Cultivos");
		descripcionConsulta.setText("Muestra si el cultivo escogido tiene una amenaza");
		vBoxExaminarCultivo.setAlignment(Pos.CENTER);

		tituloCriterios = new Label("Cultivos");
		tituloCriterios.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		tituloValores = new Label("Tipo de cultivo - id de su terreno");
		tituloValores.setFont(Font.font("Verdana", FontWeight.BOLD, 11));
			
		formulario.setVgap(13);
		formulario.setHgap(35);	
		formulario.add(this.tituloCriterios, 0, 0, 2, 1);
		formulario.add(this.tituloValores, 2, 0, 3, 1);
		formulario.add(new Label("Cultivos"), 0, 1, 2, 1);
		comboBoxCultivos = new ComboBox(FXCollections.observableArrayList(Cultivo.mostrarCultivosGUI()));
		formulario.add(comboBoxCultivos, 2, 1, 3, 1);
	
		vBoxExaminarCultivo.getChildren().add(formulario);
		formulario.setAlignment(Pos.CENTER);
		formulario.setAlignment(Pos.CENTER);
		
		HBox botonesExaminarCultivo = new HBox();
		aceptarExaminarCultivo = new Button(" Examinar ");
		botonesExaminarCultivo.getChildren().add(aceptarExaminarCultivo);
		aceptarExaminarCultivo.setAlignment(Pos.CENTER);
		botonesExaminarCultivo.setAlignment(Pos.CENTER);
		botonesExaminarCultivo.setMargin(aceptarExaminarCultivo, new Insets(20));
		botonesExaminarCultivo.setPadding(new Insets(20));
		vBoxExaminarCultivo.getChildren().add(botonesExaminarCultivo);
	
		return vBoxExaminarCultivo;
		
	}
	
}
