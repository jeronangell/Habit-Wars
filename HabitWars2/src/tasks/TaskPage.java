package tasks;

import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class TaskPage extends Pane{
	public TaskPage() {
		Button newTask=new Button("New Task");
		newTask.setLayoutY(10);
		newTask.setLayoutX(20);
		
		VBox tkpane = new VBox();
		newTask.setOnAction(e->{
			TaskPane task=new TaskPane();
			task.setName("run");
			task.toBack();
			tkpane.getChildren().addAll(task);
		});
		ScrollPane taskScroll = new ScrollPane();
		taskScroll.setContent(tkpane);
		taskScroll.setPannable(true);
		taskScroll.setLayoutY(40);
		taskScroll.setLayoutX(10);
		taskScroll.setStyle("-fx-border-color: black ; -fx-border-width: 1px ;");
		taskScroll.setMinViewportWidth(300);
		taskScroll.prefViewportHeightProperty().bind(this.heightProperty().subtract(60));
		this.getChildren().addAll(newTask,taskScroll);
	}
}
