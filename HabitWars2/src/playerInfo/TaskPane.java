package playerInfo;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class TaskPane extends VBox{
	// builds the taskPane
	
	private boolean checked=false;
	private String name="";
	private CheckBox taskAcomplishChk=new CheckBox("task name");
	public TaskPane(){
		HBox chbxhb=new HBox();
		HBox bx=new HBox();
		Button deleteBtn = new Button("Delete");
		deleteBtn.setPadding(new Insets(0,11,0,11));
		deleteBtn.setOnAction(e->{
			
		});
		this.setStyle("-fx-border-color: black;");
		bx.setStyle(" -fx-background-color: #404040;");
		Button sendTotopBtn = new Button("to top");
		sendTotopBtn.setOnAction(e->{
			
		});
		Button sendToBottomBtn = new Button("to bottom");
		sendTotopBtn.setOnAction(e->{
			
		});
		Button editBtn = new Button("edit");
		editBtn.setPadding(new Insets(0,11,0,11));
		editBtn.setOnAction(e->{
			
		});
		
		
		bx.setSpacing(4);
		bx.setPadding(new Insets(5,10,5,10));
		bx.setAlignment(Pos.TOP_RIGHT);
		bx.setPrefWidth(290);
		bx.getChildren().addAll(deleteBtn,editBtn,sendTotopBtn,sendToBottomBtn);
		
		sendTotopBtn.setPadding(new Insets(0,11,0,11));
		sendToBottomBtn.setPadding(new Insets(0,11,0,11));
		
		chbxhb.setPadding(new Insets(10,13,10,11));
		chbxhb.setPrefWidth(200);
		chbxhb.setAlignment(Pos.CENTER_LEFT);
		chbxhb.getChildren().add(taskAcomplishChk);
		chbxhb.setStyle(" -fx-background-color: lightblue;");
		taskAcomplishChk.setWrapText(true);
		this.setMinWidth(300);
		this.getChildren().addAll(bx,chbxhb);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		taskAcomplishChk.setText(name);
	}
	
	
}
