package uiMain;
import java.util.ArrayList;

import gestorAplicacion.empleado.Agronomo;
import javafx.application.*;
import javafx.collections.FXCollections;
import javafx.geometry.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class FieldPanel extends Pane{
	GridPane formulario;
	Label tituloCriterios;
	Label tituloValores;
	TextField[] datosUsuario;
	
	FieldPanel (String tituloCriterios, String[] criterios, String tituloValores, String[] valores, boolean[] habilitado) {
		datosUsuario = new TextField[criterios.length];
		formulario = new GridPane();
		this.tituloCriterios = new Label(tituloCriterios);
		this.tituloCriterios.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		this.tituloValores = new Label(tituloValores);
		this.tituloValores.setFont(Font.font("Verdana", FontWeight.BOLD, 11));
		formulario.add(this.tituloCriterios, 0, 0, 2, 1);
		formulario.add(this.tituloValores, 2, 0, 3, 1);
		formulario.setVgap(13);
		formulario.setHgap(35);
		
		int count = 1;
		for (String campo : criterios) {
			Label nombreCampo = new Label(campo);
			formulario.add(nombreCampo, 0, count, 2, 1);
			count++;
		}
		
		for (int i = 0; i < habilitado.length; i++) {
			TextField valorCampo = new TextField(valores[i]);
			valorCampo.setEditable(habilitado[i]);
			formulario.add(valorCampo, 2, i+1, 3, 1);
			datosUsuario[i] = valorCampo;
		}	
	}
	public String getValue(int indice) {
		System.out.println(datosUsuario[indice].getText());
		return (datosUsuario[indice].getText());
	}
	public void borrarValue() {
		for (int i = 0; i < datosUsuario.length; i ++) {
			datosUsuario[i].clear();
		}
	}
}
