package application;

import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.stage.Stage;
import login.Login_Page;
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws FileNotFoundException {
		//adding the task action controller
		//this basically creates the main pages views
		Login_Page logPage=new Login_Page();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
