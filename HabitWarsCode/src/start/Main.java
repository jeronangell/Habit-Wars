package start;

import java.io.FileNotFoundException;

import actions.TaskActionControler;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws FileNotFoundException {
		//adding the task action controller
		//this basically creates the main pages views
		TaskActionControler tac = new TaskActionControler();
		
		tac.login.login();
		tac.login.setLoginAction(e -> {
			if(tac.login.loginAct()) {
			startPro(tac,primaryStage);
			tac.login.close();
			}
		});
		
	}

	private void startPro(TaskActionControler tac, Stage primaryStage) {
		// opens the main page.
		BorderPane main= new BorderPane();
		Pane root = new Pane();
		
		 main.setTop(tac.menuBar);
	       
	     main.setCenter(root);
		 tac.menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
		 tac.menuBar.setLogoutAction(e->{
			 tac.login.login();
				tac.login.setLoginAction(et -> {
					if(tac.login.loginAct()) {
					startPro(tac,primaryStage);
					tac.login.close();
					}
				});
			 primaryStage.close();
		 });
		 tac.menuBar.setResetAction(e->{
			tac.reset();
			 primaryStage.close();
			 tac.open();
			 primaryStage.show();
		 });
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
		
		Label toDolist = new Label("To Do List");
		toDolist.setLayoutY(170);
		toDolist.setLayoutX(140);
		
		tac.open();
		root.getChildren().addAll(tac.userPane, taskScroll, taskbutton,toDolist,tac.rewardPane);
		Scene scene = new Scene(main, 510, 400);
		primaryStage.setOnCloseRequest(et -> tac.save());
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
