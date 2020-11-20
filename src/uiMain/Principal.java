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

public class Principal extends Application{
	public Scene principal = new Scene(new BorderPane(), 1240, 580);
	
	public void start(Stage primaryStage) {
		
		primaryStage.setTitle("Principal");
		primaryStage.setScene(principal);
		primaryStage.show();
		
	}
	
}
