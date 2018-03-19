package tasks;

import edit.Editing_Page;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class TaskPage extends Pane{
	
	public TaskPage() {
		Editing_Page edit=new Editing_Page();
		Button newTask=new Button("New Task");
		newTask.setLayoutY(10);
		newTask.setLayoutX(20);
		
		
		newTask.setOnAction(e->{
			edit.newTask();
		});
		ScrollPane taskScroll = new ScrollPane();
		taskScroll.setContent(edit.getTkpane());
		taskScroll.setPannable(true);
		taskScroll.setLayoutY(40);
		taskScroll.setLayoutX(10);
		taskScroll.setStyle("-fx-border-color: black ; -fx-border-width: 1px ;");
		taskScroll.setMinViewportWidth(300);
		taskScroll.prefViewportHeightProperty().bind(this.heightProperty().subtract(60));
		this.getChildren().addAll(newTask,taskScroll);
	}
}
