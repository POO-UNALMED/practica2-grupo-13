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
 * Esta clase define elementos escenciales para la escena puesta en la ventana
 * principal de usuario, su principal objetivo es crear un VBox base que será
 * puesto en la escena antes mencionada, en él se evidenciarán los componentes
 * necesarios para el formulario específico de la funcionalidad *Cosechar*,
 * puesta en el menú de funcionalidades proporcionadas por le programa
 *
 */
public class BuildCosechar {
	/** Representa el tipo de consulta visible */
	Label consulta = new Label();
	/** Representa la descripcion de la consulta consulta visible */
	Label descripcionConsulta = new Label();
	/** Contenedor de todos los elementos que posee la vista*/
	VBox vBoxCosechar = new VBox();
	/** Panel de llenado de datos {@link FieldPanel} */
	FieldPanel Cosechar;
	ComboBox terrenosCombo;
	Button aceptarCosechar;

	/**
	 * Metodo que construye toda la vista necesaria para cosechar
	 * 
	 * @return VBox con todo el contenido de la ventana
	 */
	public VBox vBoxBase() {
		consulta.setPadding(new Insets(25));
		descripcionConsulta.setPadding(new Insets(25));
		consulta.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		descripcionConsulta.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		vBoxCosechar.getChildren().addAll(consulta, descripcionConsulta);
		consulta.setText("Cosechar");
		descripcionConsulta.setText("Recolecta la cosecha seleccionada");
		vBoxCosechar.setAlignment(Pos.CENTER);

		String[] campos = { "Terreno" };
		String[] valores = { "" };
		boolean[] editable = {};
		Cosechar = new FieldPanel("", campos, "Seleccionar terreno", valores, editable);
		terrenosCombo = new ComboBox(FXCollections.observableArrayList(Terreno.mostrarTerrenosGUI()));
		terrenosCombo.setPrefWidth(150);
		Cosechar.formulario.add(terrenosCombo, 2, 1, 3, 1);

		vBoxCosechar.getChildren().add(Cosechar.formulario);
		Cosechar.formulario.setAlignment(Pos.CENTER);

		HBox botonesCosechar = new HBox();
		aceptarCosechar = new Button(" Aceptar ");
		aceptarCosechar.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
		botonesCosechar.getChildren().addAll(aceptarCosechar);
		aceptarCosechar.setAlignment(Pos.CENTER);
		botonesCosechar.setAlignment(Pos.CENTER);
		botonesCosechar.setPadding(new Insets(20));
		botonesCosechar.setMargin(aceptarCosechar, new Insets(20));
		vBoxCosechar.getChildren().add(botonesCosechar);

		return vBoxCosechar;
	}
}
