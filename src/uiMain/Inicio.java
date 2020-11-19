package uiMain;
import javafx.application.*;
import javafx.geometry.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class Inicio extends Application{

	Label bienvenida = new Label("Welcome");
	Label vida = new Label("HOjass de vida");
	
	
	public void start(Stage primaryStage) {
		
		HBox root = new HBox(30);
		BorderPane p1 = new BorderPane();
		BorderPane p2 = new BorderPane();
		FlowPane p3 = new FlowPane();
		BorderPane p4 = new BorderPane();
		FlowPane p5 = new FlowPane();
		GridPane p6 = new GridPane();
		Button sigVentana = new Button("Pasar ventana");		
		Image cultivos1 = new Image(getClass().getResourceAsStream("./Imagenes/cultivos1.jpg"));
		
		p1.setPrefSize(500,400);
		p2.setPrefSize(500,400);
		
		root.getChildren().addAll(p1,p2);
		p1.setTop(p3);
		p1.setCenter(p4);
		p2.setTop(p5);
		p2.setCenter(p6);
		vida.setPadding(new Insets(10,10,10,10));
		bienvenida.setPadding(new Insets(10,10,10,10));
		
		p3.getChildren().add(bienvenida);
		p5.getChildren().add(vida);
		p4.setBottom(sigVentana);
		p4.setAlignment(sigVentana, Pos.CENTER);
		p4.setPadding(new Insets (10,10,10,10));
		p4.setTop(new ImageView(cultivos1));

		root.setStyle("-fx-background-color: GREEN;");
		p1.setStyle("-fx-background-color: BLUE;");
		p2.setStyle("-fx-background-color: RED;");
		p3.setStyle("-fx-background-color: BLACK;");
		p5.setStyle("-fx-background-color: ORANGE;");
		
		
		
		
		primaryStage.setTitle("Inicio");
		Scene scene = new Scene(root, 600,600);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}
	
	public static void main(String[] args) {
		launch (args);
	}
	
	
	
	
}
