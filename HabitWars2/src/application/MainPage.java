package application;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import menue.MyMenuBar;
import playerInfo.PlayerStatPane;
import tasks.TaskPage;

public class MainPage extends Stage{
	public MainPage(String userName, String passWord) {
		VBox main= new VBox();
		MyMenuBar menu=new MyMenuBar();
		PlayerStatPane playerPage=new PlayerStatPane();
		MainTasks mainTasks=new MainTasks();
	
		playerPage.setAll(mainTasks.openPlayerStats(userName,passWord));
		TaskPage taskPage=new TaskPage();
		main.setSpacing(9);
		main.setMinHeight(200);
		main.getChildren().addAll(menu,playerPage,taskPage);
		
		Scene scene = new Scene(main, 400, 400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		this.setOnCloseRequest(et ->{
			mainTasks.save();
		});
		this.setScene(scene);
		this.show();
	}

}
