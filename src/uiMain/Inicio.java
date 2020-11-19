package uiMain;
import javafx.application.*;
import javafx.geometry.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class Inicio extends Application{

	Label bienvenida = new Label("Welcome");
	Label vida = new Label("HOjass de vida");
	BorderPane p4 = new BorderPane();
	Image cultivos1;
	Image cultivos2;
	Image cultivos3;
	Image cultivos4;
	Image cultivos5;
	ImageView icultivos1;
	ImageView icultivos2;
	ImageView icultivos3;
	ImageView icultivos4;
	ImageView icultivos5;
	
	
	public void start(Stage primaryStage) {
		
		//Nodo raiz de la escena
		VBox root = new VBox(5);
		
		//Contiene todos los elementos de la venta Inicio
		HBox contenedor = new HBox(30);
		BorderPane p1 = new BorderPane();
		BorderPane p2 = new BorderPane();
		FlowPane p3 = new FlowPane();
		FlowPane p5 = new FlowPane();
		GridPane p6 = new GridPane();
		Button sigVentana = new Button("Pasar ventana");
		
		//Menu
		MenuBar menuPrincipal = new MenuBar();
		Menu barraPrincipal = new Menu("Inicio");
		MenuItem salir = new MenuItem("Salir");
		MenuItem descripcion = new MenuItem("Descripcion");
		SeparatorMenuItem separador = new SeparatorMenuItem();
		menuPrincipal.getMenus().addAll(barraPrincipal);
		barraPrincipal.getItems().addAll(salir,separador,descripcion);
		
		root.getChildren().add(menuPrincipal);
		root.getChildren().add(contenedor);
		
		// Imagenes de la app P4
		cultivos1 = new Image(getClass().getResourceAsStream("./imagenes/cultivos1.jpg"));
		cultivos2 = new Image(getClass().getResourceAsStream("./imagenes/cultivos2.jpg"));
		cultivos3 = new Image(getClass().getResourceAsStream("./imagenes/cultivos3.jpg"));
		cultivos4 = new Image(getClass().getResourceAsStream("./imagenes/cultivos4.jpg"));
		cultivos5 = new Image(getClass().getResourceAsStream("./imagenes/cultivos5.jpg"));
		icultivos1 = new ImageView(cultivos1);
		icultivos2 = new ImageView(cultivos2);
		icultivos3 = new ImageView(cultivos3);
		icultivos4 = new ImageView(cultivos4);
		icultivos5 = new ImageView(cultivos5);
		
		icultivos1.setOnMouseExited(mouseHandler);
		icultivos2.setOnMouseExited(mouseHandler);
		icultivos3.setOnMouseExited(mouseHandler);
		icultivos4.setOnMouseExited(mouseHandler);
		icultivos5.setOnMouseExited(mouseHandler);
		icultivos1.setFitHeight(220);
		icultivos1.setPreserveRatio(true);
		icultivos2.setFitHeight(220);
		icultivos2.setPreserveRatio(true);
		icultivos3.setFitHeight(220);
		icultivos3.setPreserveRatio(true);
		icultivos4.setFitHeight(220);
		icultivos4.setPreserveRatio(true);
		icultivos5.setFitHeight(220);
		icultivos5.setPreserveRatio(true);
		
		
		ImageView fotoHojaVida1 = new ImageView(cultivos1);
		ImageView fotoHojaVida2 = new ImageView(cultivos1);
		ImageView fotoHojaVida3 = new ImageView(cultivos1);
		ImageView fotoHojaVida4 = new ImageView(cultivos1);
		
	
		fotoHojaVida1.setFitHeight(100);
		fotoHojaVida1.setPreserveRatio(true);
		fotoHojaVida2.setFitHeight(100);
		fotoHojaVida2.setPreserveRatio(true);
		fotoHojaVida3.setFitHeight(100);
		fotoHojaVida3.setPreserveRatio(true);
		fotoHojaVida4.setFitHeight(100);
		fotoHojaVida4.setPreserveRatio(true);
		
		p1.setPrefSize(500,400);
		p2.setPrefSize(500,400);
		
		contenedor.getChildren().addAll(p1,p2);
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
		p4.setAlignment(icultivos2, Pos.CENTER);
		p4.setAlignment(icultivos3, Pos.CENTER);
		p4.setAlignment(icultivos4, Pos.CENTER);
		p4.setAlignment(icultivos5, Pos.CENTER);
		p4.setPadding(new Insets (10,10,10,10));
		p4.setTop(icultivos1);
		p6.setPadding(new Insets(20,20,20,20));
		p6.setVgap(12);
		p6.setHgap(12);
		
		p6.add(fotoHojaVida1, 0, 0);
		p6.add(fotoHojaVida2, 0, 1);
		p6.add(fotoHojaVida3, 1, 0);
		p6.add(fotoHojaVida4, 1, 1);
		p6.setAlignment(Pos.CENTER);
		
		primaryStage.setTitle("Inicio");
		Scene scene = new Scene(root, 860,350);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}  EventHandler<MouseEvent> mouseHandler = new EventHandler<MouseEvent>() {
		int cont = 2;
        @Override
        public void handle(MouseEvent mouseEvent) {
        	String direction = "";
        	if (cont==6) {
				cont = 1;
			}
        	System.out.println(mouseEvent.getEventType());
        		
        	if (cont==1) {
        		p4.setTop(null);
            	p4.setTop(icultivos1);
			}else if (cont==2) {
				p4.setTop(null);
            	p4.setTop(icultivos2);
			}else if (cont==3) {
				p4.setTop(null);
            	p4.setTop(icultivos3);
			}else if (cont==4) {
				p4.setTop(null);
            	p4.setTop(icultivos4);
			}else if (cont==5) {
				p4.setTop(null);
            	p4.setTop(icultivos5);
			}
        	System.out.println(cont);
        	cont++;
        }
    };
	
	
	public static void main(String[] args) {
		launch (args);
	}

}
