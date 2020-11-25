package uiMain;

import BaseDatos.SerializacionC;
import BaseDatos.SerializacionG;
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

/**
 * Esta clase define la ventana de inicio del programa con sus respectivos
 * componentes. Contiene el Stage y la escena inicial de la ejecución, será la
 * encargada de dar la bienvenida al usuario cuando se ponga en marcha el
 * aplicativo.
 *
 */
public class Inicio extends Application {
	/** Paneles de la vista */
	BorderPane p4 = new BorderPane();
	GridPane p6 = new GridPane();

	Label bienvenida = new Label("¡¡  Bienvenidos a Cultivatron, tu simulador de cultivos preferido  !!  ");
	TextArea Hdescripcion = new TextArea(
			"Mi nombre es José David Rueda, tengo 19 años, nací el 20 de diciembre del 2000. Estudio ingeniería de sistemas, estoy cursando "
					+ "el cuarto semestre, he vivido toda mi vida en Medellin, en el barrio Belen, me gusta el futbol, los videojuegos" +
					" y la musica.");
	TextArea Sdescripcion;
	/** Imagenes de los cultivos pertenecientes al dominio */
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
	/** Imagenes de las hojas de vida de cada integrante */
	ImageView ifotoHojaVida1 = new ImageView();
	ImageView ifotoHojaVida2 = new ImageView();
	ImageView ifotoHojaVida3 = new ImageView();
	ImageView ifotoHojaVida4 = new ImageView();
	Button sigVentana;
	Stage windowInicio;
	Scene inicio;
	/**
	 * atributo que representa la ventana principal donde se accede a todas las
	 * consultas {@link Principal}
	 */
	Principal ventanaPrincipal = new Principal();
	/**
	 * Instancia que enlanza a la ventana de inicio con la ventana principal
	 * atributo que nos permite hacer enlace con la ventana principal del usiario
	 */
	Inicio iniAux = this;

	public void start(Stage primaryStage) {
		this.windowInicio = primaryStage;

		/** Nodo raiz de la escena */
		VBox root = new VBox(5);

		/** Contiene todos los elementos de la venta Inicio */
		HBox contenedor = new HBox(30);
		BorderPane p1 = new BorderPane();
		BorderPane p2 = new BorderPane();
		FlowPane p3 = new FlowPane();
		FlowPane p5 = new FlowPane();
		sigVentana = new Button("Pasar ventana");

		/** Menu principal */
		MenuBar menuPrincipal = new MenuBar();
		Menu barraPrincipal = new Menu("Inicio");
		MenuItem salir = new MenuItem("Salir");
		MenuItem descripcion = new MenuItem("Descripcion");
		SeparatorMenuItem separador = new SeparatorMenuItem();
		menuPrincipal.getMenus().addAll(barraPrincipal);
		barraPrincipal.getItems().addAll(salir, separador, descripcion);
		bienvenida.setAlignment(Pos.CENTER);
		bienvenida.setFont(Font.font("Verdana", FontWeight.BOLD, 15));

		salirHandlerClass salirH = new salirHandlerClass();
		salir.setOnAction(salirH);

		root.getChildren().add(menuPrincipal);
		root.getChildren().add(contenedor);

		/**
		 * Variables que guardan cada una de las cinco imagenes que se ubican en el pane
		 */
		/** P4 */
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

		/** Asignacion de los handler */
		icultivos1.setOnMouseExited(mouseHandler);
		icultivos2.setOnMouseExited(mouseHandler);
		icultivos3.setOnMouseExited(mouseHandler);
		icultivos4.setOnMouseExited(mouseHandler);
		icultivos5.setOnMouseExited(mouseHandler);
		/** Modifica el tamano la imagen */
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
		/**
		 * Variables que guardan cada una de las imagenes de los integrantes del grupo
		 * que se ubican en el P6
		 */
		Image jose1 = new Image(getClass().getResourceAsStream("./imagenes/jose1.jpg"));
		Image jose2 = new Image(getClass().getResourceAsStream("./imagenes/jose2.jpg"));
		Image jose3 = new Image(getClass().getResourceAsStream("./imagenes/jose3.jpg"));
		Image jose4 = new Image(getClass().getResourceAsStream("./imagenes/jose4.jpg"));
		ifotoHojaVida1.setImage(jose1);
		ifotoHojaVida2.setImage(jose2);
		ifotoHojaVida3.setImage(jose3);
		ifotoHojaVida4.setImage(jose4);

		/** Modifica el tamano la imagen */
		ifotoHojaVida1.setFitHeight(100);
		ifotoHojaVida1.setPreserveRatio(true);
		ifotoHojaVida2.setFitHeight(100);
		ifotoHojaVida2.setPreserveRatio(true);
		ifotoHojaVida3.setFitHeight(100);
		ifotoHojaVida3.setPreserveRatio(true);
		ifotoHojaVida4.setFitHeight(100);
		ifotoHojaVida4.setPreserveRatio(true);

		/** Pane P1 */
		p1.setPrefSize(500, 400);
		p1.setTop(p3);
		p1.setCenter(p4);
		/** Pane P2 */
		p2.setPrefSize(500, 400);
		p2.setTop(p5);
		p2.setCenter(p6);

		contenedor.getChildren().addAll(p1, p2);

		/** Label y TextArea */
		Hdescripcion.setPadding(new Insets(10, 10, 10, 10));
		bienvenida.setPadding(new Insets(10, 10, 10, 10));

		p3.getChildren().add(bienvenida);
		SdescripcionHandlerClass SdescripcionHandler = new SdescripcionHandlerClass();
		descripcion.setOnAction(SdescripcionHandler);

		/** Pane P4 */
		p4.setBottom(sigVentana);
		p4.setAlignment(sigVentana, Pos.CENTER);
		p4.setAlignment(icultivos1, Pos.CENTER);
		p4.setAlignment(icultivos2, Pos.CENTER);
		p4.setAlignment(icultivos3, Pos.CENTER);
		p4.setAlignment(icultivos4, Pos.CENTER);
		p4.setAlignment(icultivos5, Pos.CENTER);
		p4.setPadding(new Insets(10, 10, 10, 10));
		p4.setTop(icultivos1);

		/** Pane P6 */
		p6.setPadding(new Insets(20, 20, 20, 20));
		p6.setVgap(12);
		p6.setHgap(12);
		p6.add(ifotoHojaVida1, 0, 0);
		p6.add(ifotoHojaVida2, 0, 1);
		p6.add(ifotoHojaVida3, 1, 0);
		p6.add(ifotoHojaVida4, 1, 1);
		p6.setAlignment(Pos.CENTER);

		primaryStage.setTitle("Inicio");
		inicio = new Scene(root, 1240, 580);
		primaryStage.setScene(inicio);
		primaryStage.show();

		/** Botón que lleva a la ventana principal del usuario */
		SigVentanaHandlerClass sigVentanaHandler = new SigVentanaHandlerClass();
		sigVentana.setOnAction(sigVentanaHandler);

		/** Pane P5 */
		p5.getChildren().add(Hdescripcion);
		Hdescripcion.setOnMouseClicked(mouseHandler);
		Hdescripcion.setEditable(false); /** No se edita la descripción */
		Hdescripcion.setWrapText(true); /** Acoplar texto al FlowPane */
		p2.setPadding(new Insets(15, 15, 15, 15));

	}

	/**
	 * Handler para los enventos del raton
	 */
	EventHandler<MouseEvent> mouseHandler = new EventHandler<MouseEvent>() {
		/** Usados para el cambio de imagenes */
		int cont = 2;
		int contH = 2;

		@Override
		public void handle(MouseEvent mouseEvent) {
			if ((mouseEvent.getEventType().toString()).equals("MOUSE_EXITED")) {
				if (cont == 6) {
					cont = 1;
				}
				/** Controla el orden en el cambio de las imagenes */
				if (cont == 1) {
					p4.setTop(null);
					p4.setTop(icultivos1);
				} else if (cont == 2) {
					p4.setTop(null);
					p4.setTop(icultivos2);
				} else if (cont == 3) {
					p4.setTop(null);
					p4.setTop(icultivos3);
				} else if (cont == 4) {
					p4.setTop(null);
					p4.setTop(icultivos4);
				} else if (cont == 5) {
					p4.setTop(null);
					p4.setTop(icultivos5);
				}
				cont++;
			} else if ((mouseEvent.getEventType().toString()).equals("MOUSE_CLICKED")) {
				if (contH == 6) {
					contH = 1;
				}
				/** Controla el orden en el cambio de las descripciones */
				if (contH == 1) {
					Hdescripcion.setText(
							"Mi nombre es José David Rueda, tengo 19 años, nací el 20 de diciembre del 2000. Estudio ingeniería de sistemas, estoy cursando "
									+ "el cuarto semestre, he vivido toda mi vida en Medellin, en el barrio Belen, me gusta el futbol, los videojuegos" +
									" y la musica.");

					Image jose1 = new Image(getClass().getResourceAsStream("./imagenes/jose1.jpg"));
					Image jose2 = new Image(getClass().getResourceAsStream("./imagenes/jose2.jpg"));
					Image jose3 = new Image(getClass().getResourceAsStream("./imagenes/jose3.jpg"));
					Image jose4 = new Image(getClass().getResourceAsStream("./imagenes/jose4.jpg"));

					ifotoHojaVida1.setImage(jose1);
					ifotoHojaVida2.setImage(jose2);
					ifotoHojaVida3.setImage(jose3);
					ifotoHojaVida4.setImage(jose4);

					ifotoHojaVida1.setFitHeight(100);
					ifotoHojaVida1.setPreserveRatio(true);
					ifotoHojaVida2.setFitHeight(100);
					ifotoHojaVida2.setPreserveRatio(true);
					ifotoHojaVida3.setFitHeight(100);
					ifotoHojaVida3.setPreserveRatio(true);
					ifotoHojaVida4.setFitHeight(100);
					ifotoHojaVida4.setPreserveRatio(true);

				} else if (contH == 2) {
					Hdescripcion.setText(
							"Soy Jan Michael Muñoz Botero, estudiante de ingeniería de sistemas, tengo 18 años, nací el 17 de febrero de 2002 y actualmente estoy en mi cuarto semestre");

					Image michael1 = new Image(getClass().getResourceAsStream("./imagenes/michael1.jpg"));
					Image michael2 = new Image(getClass().getResourceAsStream("./imagenes/michael2.jpg"));
					Image michael3 = new Image(getClass().getResourceAsStream("./imagenes/michael3.jpg"));
					Image michael4 = new Image(getClass().getResourceAsStream("./imagenes/michael4.jpg"));

					ifotoHojaVida1.setImage(michael1);
					ifotoHojaVida2.setImage(michael2);
					ifotoHojaVida3.setImage(michael3);
					ifotoHojaVida4.setImage(michael4);

					ifotoHojaVida1.setFitHeight(100);
					ifotoHojaVida1.setPreserveRatio(true);
					ifotoHojaVida2.setFitHeight(100);
					ifotoHojaVida2.setPreserveRatio(true);
					ifotoHojaVida3.setFitHeight(100);
					ifotoHojaVida3.setPreserveRatio(true);
					ifotoHojaVida4.setFitHeight(100);
					ifotoHojaVida4.setPreserveRatio(true);

				} else if (contH == 3) {
					Hdescripcion.setText(
							"El es Sergio Alejandro Bermudez Gomez, nacio el 29 de octubre del 2000. Es estudiante de ingenieria de sistemas e informatica."
							+ "Le gusta el fútbol y el Counter Strike. Su lugar de nacimiento es Apartado, Antioquia (Uraba) pero crecio en Caldas, pasando de vereda en vereda"
							+ " casi toda su vida la ha pasado en el campo");

					Image sergio1 = new Image(getClass().getResourceAsStream("./imagenes/sergio1.jpg"));
					Image sergio2 = new Image(getClass().getResourceAsStream("./imagenes/sergio2.jpg"));
					Image sergio3 = new Image(getClass().getResourceAsStream("./imagenes/sergio3.jpg"));
					Image sergio4 = new Image(getClass().getResourceAsStream("./imagenes/sergio4jpg.jpg"));

					ifotoHojaVida1.setImage(sergio1);
					ifotoHojaVida2.setImage(sergio2);
					ifotoHojaVida3.setImage(sergio3);
					ifotoHojaVida4.setImage(sergio4);

					ifotoHojaVida1.setFitHeight(100);
					ifotoHojaVida1.setPreserveRatio(true);
					ifotoHojaVida2.setFitHeight(100);
					ifotoHojaVida2.setPreserveRatio(true);
					ifotoHojaVida3.setFitHeight(100);
					ifotoHojaVida3.setPreserveRatio(true);
					ifotoHojaVida4.setFitHeight(100);
					ifotoHojaVida4.setPreserveRatio(true);

				} else if (contH == 4) {

					Hdescripcion.setText(
							"¡Hola! Soy Bolkar Leimar Ocampo Montoya, estudiante de ingeniería de sistemas y actualmente me encuentro cursando mi cuarto semestre. Nací el 27 de septiembre del 2000."
							+ "Soy aficionado a los videojuegos, son mi pasatiempo favorito");

					Image bolkar1 = new Image(getClass().getResourceAsStream("./imagenes/bolkar1.jpg"));
					Image bolkar2 = new Image(getClass().getResourceAsStream("./imagenes/bolkar2.jpg"));
					Image bolkar3 = new Image(getClass().getResourceAsStream("./imagenes/bolkar3.jpg"));
					Image bolkar4 = new Image(getClass().getResourceAsStream("./imagenes/bolkar4.jpg"));

					ifotoHojaVida1.setImage(bolkar1);
					ifotoHojaVida2.setImage(bolkar2);
					ifotoHojaVida3.setImage(bolkar3);
					ifotoHojaVida4.setImage(bolkar4);

					ifotoHojaVida1.setFitHeight(100);
					ifotoHojaVida1.setPreserveRatio(true);
					ifotoHojaVida2.setFitHeight(100);
					ifotoHojaVida2.setPreserveRatio(true);
					ifotoHojaVida3.setFitHeight(100);
					ifotoHojaVida3.setPreserveRatio(true);
					ifotoHojaVida4.setFitHeight(100);
					ifotoHojaVida4.setPreserveRatio(true);

				} else if (contH == 5) {
					Hdescripcion.setText(
							"Saludos, soy Santiago Castro Tabares, estudiante de ingeniería de sistemas y actualmente me encuentro cursando mi cuarto semestre. vivo en el municipio de la Ceja Antiquia \n"
									+ "\nApasionado por el saber");

					Image santiago1 = new Image(getClass().getResourceAsStream("./imagenes/santiago1.jpg"));
					Image santiago2 = new Image(getClass().getResourceAsStream("./imagenes/santiago2.jpg"));
					Image santiago3 = new Image(getClass().getResourceAsStream("./imagenes/santiago3.jpg"));
					Image santiago4 = new Image(getClass().getResourceAsStream("./imagenes/santiago4.jpg"));

					ifotoHojaVida1.setImage(santiago1);
					ifotoHojaVida2.setImage(santiago2);
					ifotoHojaVida3.setImage(santiago3);
					ifotoHojaVida4.setImage(santiago4);

					ifotoHojaVida1.setFitHeight(100);
					ifotoHojaVida1.setPreserveRatio(true);
					ifotoHojaVida2.setFitHeight(100);
					ifotoHojaVida2.setPreserveRatio(true);
					ifotoHojaVida3.setFitHeight(100);
					ifotoHojaVida3.setPreserveRatio(true);
					ifotoHojaVida4.setFitHeight(100);
					ifotoHojaVida4.setPreserveRatio(true);

				}
				contH++;
			}
		}

	};

	/** Clase que permite salir de la ventana de inicio */

	class salirHandlerClass implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
			SerializacionG.Save();
			Platform.exit();
			System.exit(0);
		}
	}

	/** Clase que genera un nuevo texto con la descripcion del proyecto */
	class SdescripcionHandlerClass implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
			Sdescripcion = new TextArea(
					"El programa tiene la capacidad de simular cómo se comportan algunos tipos de cultivos en ciertos terrenos, siendo atacados por plagas, maleza u hongos; y estos a su vez son exterminados por su respectivo tipo de pesticida. Existen empleados que se derivan en campesinos y administradores; siendo los primeros los trabajadores que siembran y recolectan los cultivos; y a su vez, los encargados de usar los pesticidas. Los administradores se encargan de contratar, despedir y dirigir a los campesinos para realizar las labores en los cultivos, también son los que investigan el tipo de amenaza bajo la que se encuentra la cosecha");
			Sdescripcion.setWrapText(true);
			Sdescripcion.setEditable(false);
			p4.setCenter(Sdescripcion);
			p4.setMargin(Sdescripcion, new Insets(13, 13, 13, 13));
		}
	}

	/** Clase que permite cambiar de ventana, yendo a la ventana principal */
	class SigVentanaHandlerClass implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
			ventanaPrincipal.linkInicio = iniAux;
			windowInicio.setScene(ventanaPrincipal.crearPrincipal());
		}
	}

	public static void main(String[] args) {
		SerializacionC.Load();
		launch(args);
	}

}
