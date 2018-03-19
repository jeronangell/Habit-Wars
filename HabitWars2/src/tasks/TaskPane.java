package tasks;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class TaskPane extends Pane{
	// builds the taskPane
	
	public TaskPane(){
		
	}
	public TaskPane(TaskInfo taskInfo) {
		boolean checked=false;
		 String name="";
		 Button deleatBtn = new Button("Deleat");
		 Button sendTotopBtn = new Button("to top");
		 Button sendToBotomBtn = new Button("to botom");
		 Button editBtn = new Button("edit");
		 CheckBox taskAcomplishChk=new CheckBox("task name");
		 HBox chbxhb=new HBox();
		 HBox bx=new HBox();
		editBtn.setPadding(new Insets(0,11,0,11));
		deleatBtn.setPadding(new Insets(0,11,0,11));
		taskAcomplishChk.setText(taskInfo.getName());
		bx.setSpacing(4);
		bx.setPadding(new Insets(5,10,5,10));
		bx.setAlignment(Pos.TOP_RIGHT);
		bx.setPrefWidth(290);
		bx.getChildren().addAll(deleatBtn,editBtn,sendTotopBtn,sendToBotomBtn);
		
		sendTotopBtn.setPadding(new Insets(0,11,0,11));
		sendToBotomBtn.setPadding(new Insets(0,11,0,11));
		
		chbxhb.setPadding(new Insets(0,13,0,11));
		chbxhb.setPrefWidth(200);
		chbxhb.getChildren().add(taskAcomplishChk);
		chbxhb.layoutYProperty().bind(bx.heightProperty());
		taskAcomplishChk.setWrapText(true);
		this.setWidth(400);
		this.setMinWidth(300);
		this.setMinHeight(70);
		this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		this.getChildren().addAll(bx,chbxhb);
	}
	
	
	
	
}
