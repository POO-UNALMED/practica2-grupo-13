package uiMain;

import javafx.application.*;
import javafx.geometry.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Principal{
	
	public Scene crearPrincipal() {
		VBox vBox0=new VBox();
		Scene principal;
		principal = new Scene(vBox0, 1240, 580);
		
		Label nombrePrograma=new Label("Cultivatron");
		
		vBox0.getChildren().add(nombrePrograma);
		VBox vBox1= new VBox();
		
		MenuBar barraPrincipal = new MenuBar();
		Menu archivo = new Menu("Archivo");
		Menu procesos_Consultas = new Menu("Procesos y consultas");
		Menu ayuda = new Menu("Ayuda");
		barraPrincipal.getMenus().addAll(archivo,procesos_Consultas,ayuda);
		
		vBox1.getChildren().add(barraPrincipal);
		vBox0.getChildren().add(vBox1);
		return principal;

	}

}
