package edit;

import java.time.LocalDate;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import tasks.TaskInfo;

public class EditPage {

		
		public EditPage(TaskInfo task) {
			Pane dialogVbox = new Pane();
			TextField taskNameTF=new TextField(task.getName());
			TextField daytf=new TextField("");
			Button saveBtn=new Button("save");
			ComboBox<String> dellayTimeFrameCbx=new ComboBox<String>();
			ComboBox<String> difficultyCbx=new ComboBox<String>();
			boolean[] dayOfWeekBool =new boolean[7];
			FlowPane weekPane = new FlowPane();
			TextField numtext=new TextField();
			LocalDate startdate=LocalDate.now();
			DatePicker startDateDp=new DatePicker();
	       
	        Label taskNameLbl=new Label("task Name");
	        taskNameLbl.setLayoutY(10);
	        taskNameLbl.setLayoutX(35);
	        
	        taskNameTF.setLayoutY(30);
	        taskNameTF.setLayoutX(30);
	        
	       
	        
			saveBtn.setLayoutY(320);
	        saveBtn.setLayoutX(40);
	        Label repeatLbl=new Label("repeat");
	        repeatLbl.setLayoutX(50);
	        repeatLbl.setLayoutY(130);
	       
	        dellayTimeFrameCbx.setValue(dellayTimeFrameCbx.getItems().get(task.getTimeType()));
	        dellayTimeFrameCbx.getItems().addAll("Daily","Weekly","Monthly","Yearly");
	        dellayTimeFrameCbx.setLayoutY(150);
	        dellayTimeFrameCbx.setLayoutX(40);
	        difficultyCbx.setValue(difficultyCbx.getItems().get(task.getDificulty()));
	        difficultyCbx.getItems().addAll("Trivial","Easy","Medium","Hard");
	        difficultyCbx.setLayoutY(90);
	        difficultyCbx.setLayoutX(40);
	        
	        startDateDp.setLayoutX(150);
	        startDateDp.setLayoutY(150);
	        startDateDp.setMaxWidth(100);
	        startDateDp.setValue(task.getStartDate());
	        StackPane timeHolderStp=new StackPane();
	        timeHolderStp.setLayoutY(180);
	        timeHolderStp.setLayoutX(20);
	        timeHolderStp.setMinWidth(180);
	        timeHolderStp.setMinHeight(120);
	        // a text field is to be placed within my stack pane and will only accept int
	        numtext.setLayoutY(70);
	        numtext.setLayoutX(10);
	        numtext.setMaxWidth(80);
	       
	        weekPane.setVgap(6);
	        weekPane.setHgap(2);
	        
	        weekPane.setMaxWidth(250);
	        weekPane.setMinHeight(120);
	        weekPane.getChildren().addAll(sundayBtn,mondayBtn,tusedayBtn,wednesdayBtn,thursdayBtn,fridayBtn,saterdayBtn);
	        timeHolderStp.getChildren().addAll(numtext,weekPane);
	        dialogVbox.getChildren().addAll(taskNameTF,taskNameLbl,saveBtn,dellayTimeFrameCbx,repeatLbl,difficultyCbx,timeHolderStp,startDateDp);
	        Scene dialogScene = new Scene(dialogVbox, 300, 400);
	        this.setScene(dialogScene);
	        this.show();
			
		}
		

	}
}
