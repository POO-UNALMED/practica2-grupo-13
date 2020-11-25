package uiMain;

import gestorAplicacion.terreno.Cultivo;
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
 * necesarios para el formulario específico de la funcionalidad *Producción
 * total*, puesta en el menú de funcionalidades proporcionadas por le programa
 *
 */
public class BuildProduccionTotal {
	/** Representa el tipo de consulta visible */
	Label consulta = new Label();
	/** Representa la descripcion de la consulta consulta visible */
	Label descripcionConsulta = new Label();
	/** Contenedor de todos los elementos que posee la vista */
	VBox vBoxProduccionTotal = new VBox();
	/** Panel de llenado de datos {@link FieldPanel} */
	FieldPanel produccionTotal;

	/**
	 * Metodo que construye toda la vista necesaria para mostrar la produccion total
	 * 
	 * @return
	 */
	public VBox vBoxBase() {
		consulta.setPadding(new Insets(25));
		descripcionConsulta.setPadding(new Insets(25));
		consulta.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		descripcionConsulta.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		vBoxProduccionTotal.getChildren().addAll(consulta, descripcionConsulta);
		consulta.setText("Produccion Total de los Cultivos");
		descripcionConsulta.setText("Muestra el total de hectareas que se han producido en cada cultivo");
		vBoxProduccionTotal.setAlignment(Pos.CENTER);

		String[] campos = { "Cantidad de papas:", "Cantidad de sandias:", "Cantidad de mangos:", "Cantidad de bananos:",
				"Cantidad de fresas:" };
		String[] valores = { String.valueOf(Cultivo.getPapaProducida()), String.valueOf(Cultivo.getSandiaProducida()),
				String.valueOf(Cultivo.getMangoProducido()), String.valueOf(Cultivo.getBananoProducido()),
				String.valueOf(Cultivo.getFresaProducida()) };
		boolean[] editable = { false, false, false, false, false };
		produccionTotal = new FieldPanel("Cantidad por tipo", campos, "Produccion total por tipo", valores, editable);

		vBoxProduccionTotal.getChildren().add(produccionTotal.formulario);
		produccionTotal.formulario.setAlignment(Pos.CENTER);

		return vBoxProduccionTotal;
	}

}
