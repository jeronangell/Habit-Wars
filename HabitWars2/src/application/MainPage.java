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
		BorderPane main= new BorderPane();
		MyMenuBar menu=new MyMenuBar();
		PlayerStatPane playerPage=new PlayerStatPane();
		MainTasks mainTasks=new MainTasks();
		BorderPane center=new BorderPane();
		playerPage.setAll(mainTasks.openPlayerStats(userName,passWord));
		TaskPage taskPage=new TaskPage();
		main.setTop(menu);
		main.setCenter(center);
		center.setTop(playerPage);
		center.setCenter(taskPage);
		
		Scene scene = new Scene(main, 400, 400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		this.setOnCloseRequest(et ->{
			mainTasks.save();
		});
		this.setScene(scene);
		this.show();
	}

}
