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
 *para el formulario específico de la funcionalidad *Agregar terrenos*, puesta
 *en el menú de  funcionalidades proporcionadas por le programa
 *
 */
public class BuildAddTerreno {
	/** Representa el tipo de consulta visible*/
	Label consulta = new Label();
	/** Representa la descripcion de la consulta consulta visible*/
	Label descripcionConsulta = new Label();
	/** Contenedor de todos los elementos que posee la vista de Add Terreno*/ 
	VBox vBoxAddTerreno = new VBox();
	/** Panel de llenado de datos {@link FieldPanel}*/
	FieldPanel AddTerreno;
	Button aceptarAddTerreno;
	Button borrarAddTerreno;
	
	/**
	 * Metodo que construye toda la vista necesaria para anadir un terreno al sistema
	 * @return VBox con todo el contenido de la ventana
	 */
	public VBox vBoxBase() {
		consulta.setPadding(new Insets(25));
		descripcionConsulta.setPadding(new Insets(25));
		consulta.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		descripcionConsulta.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		vBoxAddTerreno.getChildren().addAll(consulta,descripcionConsulta);
		consulta.setText("Agregar Terreno");
		descripcionConsulta.setText("Agrega un terreno");
		vBoxAddTerreno.setAlignment(Pos.CENTER);
		
		String[] campos = {"Id","Tamaño" };
		String[] valores = {"",""};
		boolean[] editable = {true,true};
		AddTerreno = new FieldPanel("Datos terreno", campos, "Ingrese aqui", valores, editable);
		
		vBoxAddTerreno.getChildren().add(AddTerreno.formulario);
		AddTerreno.formulario.setAlignment(Pos.CENTER);
		
		HBox botonesAddTerreno = new HBox();
		aceptarAddTerreno = new Button(" Aceptar ");
		aceptarAddTerreno.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
		borrarAddTerreno = new Button(" Borrar ");
		botonesAddTerreno.getChildren().addAll(aceptarAddTerreno,borrarAddTerreno);
		aceptarAddTerreno.setAlignment(Pos.CENTER);
		borrarAddTerreno.setAlignment(Pos.CENTER);
		borrarAddTerreno.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
		botonesAddTerreno.setAlignment(Pos.CENTER);
		botonesAddTerreno.setPadding(new Insets(20));
		botonesAddTerreno.setMargin(aceptarAddTerreno, new Insets(20));
		botonesAddTerreno.setMargin(borrarAddTerreno, new Insets(20));
		vBoxAddTerreno.getChildren().add(botonesAddTerreno);
		
		return vBoxAddTerreno;
	}
}
