package edit;

import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import tasks.TaskInfo;
import tasks.TaskPage;
import tasks.TaskPane;

public class Editing_Page extends  Stage{
	private VBox tkpane = new VBox();
	private ArrayList<TaskInfo> taskInfo=new ArrayList<TaskInfo>();
	private TextField taskNameTF=new TextField("Default");
	private DatePicker startDateDp=new DatePicker();
	private ComboBox<String> difficultyCbx=new ComboBox<String>();
	private Button saveBtn=new Button("Save");
	public Editing_Page() {
		VBox main= new VBox();
		HBox taskNameSect=new HBox();
		
		Label taskNameLbl=new Label("Task Name");
		taskNameSect.getChildren().addAll(taskNameLbl, taskNameTF);
		
		HBox dateSect=new HBox();
		Label dewDateLbl=new Label("Start Date");
		
		dateSect.getChildren().addAll(dewDateLbl, startDateDp);
		HBox DificultySect=new HBox();
		Label dificultyLbl=new Label("Set Dificulty");
		difficultyCbx.getItems().addAll("Trivial","Easy","Medium","Hard");
		DificultySect.getChildren().addAll(dificultyLbl,difficultyCbx);
		
		
		main.getChildren().addAll(taskNameSect,dateSect,DificultySect,saveBtn);
		Scene scene = new Scene(main, 300, 300);
		
		this.setScene(scene);
		
		
	}

	public VBox getTkpane() {
		return tkpane;
	}

	public void setTkpane(VBox tkpane) {
		this.tkpane = tkpane;
	}

	public void newTask() {
		saveBtn.setOnAction(e->{
			
			TaskInfo taskInfo=new TaskInfo();
			taskInfo.setName(taskNameTF.getText());
			taskInfo.setStartDate(startDateDp.getValue());
			taskInfo.setDificulty(difficultyCbx.getValue().SelectedIndex);
			this.taskInfo.add(taskInfo);
			TaskPane taPane=new TaskPane(taskInfo);
			tkpane.getChildren().add(taPane );
		});
		this.show();
		
	}

	public ArrayList<TaskInfo> getTaskInfo() {
		return taskInfo;
	}

	public void setTaskInfo(ArrayList<TaskInfo> taskInfo) {
		this.taskInfo = taskInfo;
	}

}
