package tasks;

import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class TaskPage extends Pane{
	public TaskPage() {
		Button newTask=new Button("New Task");
		newTask.setLayoutY(20);
		newTask.setLayoutX(20);
		newTask.setOnAction(e->{
			
		});
		VBox tkpane = new VBox();
		ScrollPane taskScroll = new ScrollPane();
		taskScroll.setContent(tkpane);
		taskScroll.setPannable(true);
		taskScroll.setLayoutY(60);
		taskScroll.setLayoutX(80);
		taskScroll.setMinViewportWidth(310);
		taskScroll.setStyle("-fx-border-color: black ; -fx-border-width: 1px ;");
		this.getChildren().addAll(newTask,taskScroll);
	}
}
