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
		
		VBox root0 = new VBox(5);
		HBox root = new HBox(30);
		BorderPane p1 = new BorderPane();
		BorderPane p2 = new BorderPane();
		FlowPane p3 = new FlowPane();
		BorderPane p4 = new BorderPane();
		FlowPane p5 = new FlowPane();
		GridPane p6 = new GridPane();
		Button sigVentana = new Button("Pasar ventana");	
		MenuBar menuPrincipal = new MenuBar();
		Menu barraPrincipal = new Menu("Inicio");
		MenuItem salir = new MenuItem("Salir");
		MenuItem descripcion = new MenuItem("Descripcion");
		SeparatorMenuItem separador = new SeparatorMenuItem();
		menuPrincipal.getMenus().addAll(barraPrincipal);
		barraPrincipal.getItems().addAll(salir,separador,descripcion);
		
		root0.getChildren().add(menuPrincipal);
		root0.getChildren().add(root);
		
		Image cultivos1 = new Image(getClass().getResourceAsStream("./imagenes/cultivos1.jpg"));
		ImageView icultivos1 = new ImageView(cultivos1);
		ImageView icultivos2 = new ImageView(cultivos1);
		ImageView icultivos3 = new ImageView(cultivos1);
		ImageView icultivos4 = new ImageView(cultivos1);
		ImageView icultivos5 = new ImageView(cultivos1);
		
		icultivos1.setFitHeight(200);
		icultivos1.setPreserveRatio(true);
		icultivos2.setFitHeight(100);
		icultivos2.setPreserveRatio(true);
		icultivos3.setFitHeight(100);
		icultivos3.setPreserveRatio(true);
		icultivos4.setFitHeight(100);
		icultivos4.setPreserveRatio(true);
		icultivos5.setFitHeight(100);
		icultivos5.setPreserveRatio(true);
		
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
		p4.setAlignment(icultivos1, Pos.CENTER);
		p4.setPadding(new Insets (10,10,10,10));
		p4.setTop(icultivos1);
		p6.setPadding(new Insets(20,20,20,20));
		p6.setVgap(12);
		p6.setHgap(12);
		
		p6.add(icultivos2, 0, 0);
		p6.add(icultivos3, 0, 1);
		p6.add(icultivos4, 1, 0);
		p6.add(icultivos5, 1, 1);
		p6.setAlignment(Pos.CENTER);
		
		primaryStage.setTitle("Inicio");
		Scene scene = new Scene(root0, 860,350);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	
	public static void main(String[] args) {
		launch (args);
	}
	
	
	
	
}
