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

/**
 * 
 * Esta clase define elementos escenciales para la escena puesta en la ventana
 * principal de usuario, su principal objetivo es crear un VBox base que ser�
 * puesto en la escena antes mencionada, en �l se evidenciar�n los componentes
 * necesarios para el formulario espec�fico de la funcionalidad *Examinar
 * cultivo*, puesta en el men� de funcionalidades proporcionadas por le programa
 *
 */
public class BuildExaminarCultivo {
	/** Representa el tipo de consulta visible */
	Label consulta = new Label();
	/** Representa la descripcion de la consulta consulta visible */
	Label descripcionConsulta = new Label();
	Label tituloCriterios;
	Label tituloValores;
	/** Contenedor de todos los elementos que posee la vista */
	VBox vBoxExaminarCultivo = new VBox();
	GridPane formulario = new GridPane();
	ComboBox comboBoxCultivos;
	Button aceptarExaminarCultivo;

	/**
	 * Metodo que construye toda la vista necesaria para examinar un cultivo
	 * 
	 * @return VBox con todo el contenido de la ventana
	 */
	public VBox vBoxBase() {
		consulta.setPadding(new Insets(25));
		descripcionConsulta.setPadding(new Insets(25));
		consulta.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		descripcionConsulta.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		vBoxExaminarCultivo.getChildren().addAll(consulta, descripcionConsulta);
		consulta.setText("Examinar Cultivos");
		descripcionConsulta.setText("Muestra si el cultivo escogido tiene una amenaza");
		vBoxExaminarCultivo.setAlignment(Pos.CENTER);

		tituloCriterios = new Label("Cultivos");
		tituloCriterios.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		tituloValores = new Label("Tipo de cultivo - id de su terreno");
		tituloValores.setFont(Font.font("Verdana", FontWeight.BOLD, 12));

		formulario.setVgap(13);
		formulario.setHgap(35);
		formulario.add(this.tituloCriterios, 0, 0, 2, 1);
		formulario.add(this.tituloValores, 2, 0, 3, 1);
		Label tituloAux = new Label();
		tituloAux.setText("Cultivos");
		tituloAux.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
		formulario.add(tituloAux, 0, 1, 2, 1);
		comboBoxCultivos = new ComboBox(FXCollections.observableArrayList(Cultivo.mostrarCultivosGUI()));
		comboBoxCultivos.setPrefWidth(220);
		formulario.add(comboBoxCultivos, 2, 1, 3, 1);

		vBoxExaminarCultivo.getChildren().add(formulario);
		formulario.setAlignment(Pos.CENTER);
		formulario.setAlignment(Pos.CENTER);

		HBox botonesExaminarCultivo = new HBox();
		aceptarExaminarCultivo = new Button(" Examinar ");
		aceptarExaminarCultivo.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
		botonesExaminarCultivo.getChildren().add(aceptarExaminarCultivo);
		aceptarExaminarCultivo.setAlignment(Pos.CENTER);
		botonesExaminarCultivo.setAlignment(Pos.CENTER);
		botonesExaminarCultivo.setMargin(aceptarExaminarCultivo, new Insets(20));
		botonesExaminarCultivo.setPadding(new Insets(20));
		vBoxExaminarCultivo.getChildren().add(botonesExaminarCultivo);

		return vBoxExaminarCultivo;

	}

}
