package login;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Login_Page log=new Login_Page();
			BorderPane root = new BorderPane();
			Pane pagePane=new Pane();
			Button loginButton=new Button("login");
			loginButton.setLayoutY(200);
			loginButton.setLayoutX(20);
			loginButton.setOnAction(e->{
				log.login();
				
			});
			pagePane.getChildren().add(loginButton);
			root.getChildren().add(pagePane);
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
