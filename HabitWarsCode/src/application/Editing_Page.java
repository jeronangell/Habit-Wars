package application;

import java.time.LocalDate;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Editing_Page extends  Stage{
	private  Pane dialogVbox = new Pane();
	public TextField taskNameTF=new TextField("");
	public TextField daytf=new TextField("");
	public   Button saveBtn=new Button("save");
	public ComboBox<String> dellayTimeFrameCbx=new ComboBox<String>();
	public ComboBox<String> difficultyCbx=new ComboBox<String>();
	public boolean[] dayOfWeekBool =new boolean[7];
	public FlowPane weekPane = new FlowPane();
	public TextField numtext=new TextField();
	private LocalDate startdate=LocalDate.now();
	private DatePicker startDateDp=new DatePicker();
	public Editing_Page() {
		
		this.initModality(Modality.APPLICATION_MODAL);
		this.initOwner(null);
       
        Label taskNameLbl=new Label("task Name");
        taskNameLbl.setLayoutY(10);
        taskNameLbl.setLayoutX(35);
        
        taskNameTF.setLayoutY(30);
        taskNameTF.setLayoutX(30);
        
        Button sundayBtn=new Button("Sunday");
        Button mondayBtn=new Button("Monday");
        Button tusedayBtn=new Button("Tuseday");
        Button wednesdayBtn=new Button("Wednesday");
        Button thursdayBtn=new Button("Thursday");
        Button fridayBtn=new Button("Friday");
        Button saterdayBtn=new Button("Saterday");
        weekPane.setVisible(false);
		sundayBtn.setOnAction(new EventHandler<ActionEvent>() {
		    @Override 
		    public void handle(ActionEvent e) {
		    	if(dayOfWeekBool[0]==false){
		    		sundayBtn.setStyle("-fx-background-color: #0000ff");
		    		dayOfWeekBool[0]=true;
		    	}else{
		    		sundayBtn.setStyle("");
			    	dayOfWeekBool[0]=false;
		    	}
		    }
		});
		mondayBtn.setOnAction(new EventHandler<ActionEvent>() {
		    @Override 
		    public void handle(ActionEvent e) {
		    	if(dayOfWeekBool[1]==false){
		    		mondayBtn.setStyle("-fx-background-color: #0000ff");
		    		dayOfWeekBool[1]=true;
		    	}else{
		    		mondayBtn.setStyle("");
			    	dayOfWeekBool[1]=false;
		    	}
		    }
		});
		tusedayBtn.setOnAction(new EventHandler<ActionEvent>() {
		    @Override 
		    public void handle(ActionEvent e) {
		    	if(dayOfWeekBool[2]==false){
		    		tusedayBtn.setStyle("-fx-background-color: #0000ff");
		    		dayOfWeekBool[2]=true;
		    	}else{
		    		tusedayBtn.setStyle("");
			    	dayOfWeekBool[2]=false;
		    	}
		    }
		});
		wednesdayBtn.setOnAction(new EventHandler<ActionEvent>() {
		    @Override 
		    public void handle(ActionEvent e) {
		    	if(dayOfWeekBool[3]==false){
		    		wednesdayBtn.setStyle("-fx-background-color: #0000ff");
		    		dayOfWeekBool[3]=true;
		    	}else{
		    		wednesdayBtn.setStyle("");
			    	dayOfWeekBool[3]=false;
		    	}
		    }
		});
		thursdayBtn.setOnAction(new EventHandler<ActionEvent>() {
		    @Override 
		    public void handle(ActionEvent e) {
		    	if(dayOfWeekBool[4]==false){
		    		thursdayBtn.setStyle("-fx-background-color: #0000ff");
		    		dayOfWeekBool[4]=true;
		    	}else{
		    		thursdayBtn.setStyle("");
			    	dayOfWeekBool[4]=false;
		    	}
		    }
		});
		fridayBtn.setOnAction(new EventHandler<ActionEvent>() {
		    @Override 
		    public void handle(ActionEvent e) {
		    	if(dayOfWeekBool[5]==false){
		    		fridayBtn.setStyle("-fx-background-color: #0000ff");
		    		dayOfWeekBool[5]=true;
		    	}else{
		    		fridayBtn.setStyle("");
			    	dayOfWeekBool[5]=false;
		    	}
		    }
		});
		saterdayBtn.setOnAction(new EventHandler<ActionEvent>() {
		    @Override 
		    public void handle(ActionEvent e) {
		    	if(dayOfWeekBool[6]==false){
		    		saterdayBtn.setStyle("-fx-background-color: #0000ff");
		    		dayOfWeekBool[6]=true;
		    	}else{
		    		saterdayBtn.setStyle("");
			    	dayOfWeekBool[6]=false;
		    	}
		    }
		});
        
		saveBtn.setLayoutY(320);
        saveBtn.setLayoutX(40);
        Label repeatLbl=new Label("repeat");
        repeatLbl.setLayoutX(50);
        repeatLbl.setLayoutY(130);
       
        dellayTimeFrameCbx.setValue("Daily");
        dellayTimeFrameCbx.getItems().addAll("Daily","Weekly","Monthly","Yearly");
        dellayTimeFrameCbx.setLayoutY(150);
        dellayTimeFrameCbx.setLayoutX(40);
        difficultyCbx.setValue("Trivial");
        difficultyCbx.getItems().addAll("Trivial","Easy","Medium","Hard");
        difficultyCbx.setLayoutY(90);
        difficultyCbx.setLayoutX(40);
        
        startDateDp.setLayoutX(150);
        startDateDp.setLayoutY(150);
        startDateDp.setMaxWidth(100);
        startDateDp.setValue(startdate);
        setStartdate(startDateDp.getValue());
        StackPane timeHolderStp=new StackPane();
        timeHolderStp.setLayoutY(180);
        timeHolderStp.setLayoutX(20);
        timeHolderStp.setMinWidth(180);
        timeHolderStp.setMinHeight(120);
        // a text field is to be placed within my stack pane and will only accept int
        numtext.setLayoutY(70);
        numtext.setLayoutX(10);
        numtext.setMaxWidth(80);
        timeHolderStp.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
       
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
	public LocalDate getStartdate() {
		return startDateDp.getValue();
	}
	public void setStartdate(LocalDate startdate) {
		this.startdate = startdate;
		startDateDp.setValue(startdate);
	}

}
