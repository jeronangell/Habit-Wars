package application;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.Pane;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws FileNotFoundException {
		//adding the task action controller
		//this basically creates the main pages views
		TaskActionControler tac = new TaskActionControler();
		File userStatFile= new File("userInfo/curintUser.txt");
		Scanner fileReader = new Scanner(userStatFile);
		String userline = fileReader.nextLine();
		if(userline.length()>5) {
			startPro(tac,primaryStage);
		}else {
		tac.login.login();
		tac.login.setLoginAction(e -> {
			startPro(tac,primaryStage);
		});
		}
	}

	private void startPro(TaskActionControler tac, Stage primaryStage) {
		tac.login.loginAct();
		BorderPane main= new BorderPane();
		Pane root = new Pane();
		
		 main.setTop(tac.menuBar);
	       
	     main.setCenter(root);
		 tac.menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
		//creates a scroolPane to place tasks in
		ScrollPane taskScroll = new ScrollPane();
		taskScroll.setContent(tac.tkpane);
		taskScroll.setPannable(true);
		taskScroll.setLayoutY(200);
		taskScroll.setLayoutX(50);
		taskScroll.setMinViewportWidth(310);
		taskScroll.setStyle("-fx-border-color: black ; -fx-border-width: 1px ;");
		taskScroll.prefViewportHeightProperty().bind(primaryStage.heightProperty().subtract(290));
		//Create the button that adds tasks
		Button taskbutton = new Button("new task");
		taskbutton.setLayoutY(170);
		taskbutton.setLayoutX(30);
		taskbutton.setOnAction(et -> {
			tac.addNewTask();
		});
		
		tac.open();
		root.getChildren().addAll(tac.userPane, taskScroll, taskbutton);
		Scene scene = new Scene(main, 400, 400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setOnCloseRequest(et -> tac.save());
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
