package uiMain;

import gestorAplicacion.empleado.Agronomo;
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
import uiMain.Principal.agronomoHandlerClass;

/**
 * 
 * Esta clase define elementos escenciales para la escena puesta en la ventana
 * principal de usuario, su principal objetivo es crear un VBox base que será
 * puesto en la escena antes mencionada, en él se evidenciarán los componentes
 * necesarios para el formulario específico de la funcionalidad *Despedir
 * (agronomos)*, puesta en el menú de funcionalidades proporcionadas por le
 * programa
 *
 */
public class BuildDespedirAgronomo {
	/** Representa el tipo de consulta visible */
	Label consulta = new Label();
	/** Representa la descripcion de la consulta consulta visible */
	Label descripcionConsulta = new Label();
	Label tituloCriterios;
	Label tituloValores;
	/** Contenedor de todos los elementos que posee la vista*/
	VBox vBoxDespedirAgronomo = new VBox();
	GridPane formulario = new GridPane();
	ComboBox comboBoxCedulaA;
	Button aceptarDespedirAgronomo;

	/**
	 * Metodo que construye toda la vista necesaria para despedir un agronomo
	 * 
	 * @return VBox con todo el contenido de la ventana
	 */
	public VBox vBoxBase() {
		consulta.setPadding(new Insets(25));
		descripcionConsulta.setPadding(new Insets(25));
		consulta.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		descripcionConsulta.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		vBoxDespedirAgronomo.getChildren().addAll(consulta, descripcionConsulta);
		consulta.setText("Despedir Agronomo");
		descripcionConsulta.setText("Desvincula un agronomo del terreno en que esta");
		vBoxDespedirAgronomo.setAlignment(Pos.CENTER);

		tituloCriterios = new Label("Datos Agronomo");
		tituloCriterios.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		tituloValores = new Label("Ingrese aqui");
		tituloValores.setFont(Font.font("Verdana", FontWeight.BOLD, 12));

		formulario.setVgap(13);
		formulario.setHgap(35);
		formulario.add(this.tituloCriterios, 0, 0, 2, 1);
		formulario.add(this.tituloValores, 2, 0, 3, 1);
		Label tituloAux = new Label();
		tituloAux.setText("Agronomos");
		tituloAux.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
		formulario.add(tituloAux, 0, 1, 2, 1);
		comboBoxCedulaA = new ComboBox(FXCollections.observableArrayList(Agronomo.mostrarAgronomosGUI()));
		comboBoxCedulaA.setPrefWidth(150);
		formulario.add(comboBoxCedulaA, 2, 1, 3, 1);

		vBoxDespedirAgronomo.getChildren().add(formulario);
		formulario.setAlignment(Pos.CENTER);
		formulario.setAlignment(Pos.CENTER);

		HBox botonesDespedirAgronomo = new HBox();
		aceptarDespedirAgronomo = new Button(" Aceptar ");
		aceptarDespedirAgronomo.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
		botonesDespedirAgronomo.getChildren().add(aceptarDespedirAgronomo);
		aceptarDespedirAgronomo.setAlignment(Pos.CENTER);
		botonesDespedirAgronomo.setAlignment(Pos.CENTER);
		botonesDespedirAgronomo.setMargin(aceptarDespedirAgronomo, new Insets(20));
		botonesDespedirAgronomo.setPadding(new Insets(20));
		vBoxDespedirAgronomo.getChildren().add(botonesDespedirAgronomo);

		return vBoxDespedirAgronomo;
	}
}
