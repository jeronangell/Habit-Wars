package visualAspects;

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
	private EventHandler<ActionEvent> delAction = null;
	private EventHandler<ActionEvent> toTopAction =null;
	private EventHandler<ActionEvent> toBotomAction = null;
	private EventHandler<ActionEvent> editAction =null;
	private EventHandler<ActionEvent> onCheckAction =null;
	private boolean checked=false;
	private String name="";
	private Button deleteBtn = new Button("Delete");
	private Button sendTotopBtn = new Button("to top");
	private Button sendToBottomBtn = new Button("to bottom");
	private Button editBtn = new Button("edit");
	private CheckBox taskAcomplishChk=new CheckBox("task name");
	private HBox chbxhb=new HBox();
	public HBox bx=new HBox();
	
	public TaskPane(){
		//builds the task pane
		editBtn.setPadding(new Insets(0,11,0,11));
		deleteBtn.setPadding(new Insets(0,11,0,11));
		
		bx.setSpacing(4);
		bx.setPadding(new Insets(5,10,5,10));
		bx.setAlignment(Pos.TOP_RIGHT);
		bx.setPrefWidth(290);
		bx.getChildren().addAll(deleteBtn,editBtn,sendTotopBtn,sendToBottomBtn);
		
		sendTotopBtn.setPadding(new Insets(0,11,0,11));
		sendToBottomBtn.setPadding(new Insets(0,11,0,11));
		
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
	// grants accessibility to other classes the task information
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		taskAcomplishChk.setText(name);
	}
	public EventHandler<ActionEvent> getDelAction() {
		return delAction;
	}
	public void setDelAction(EventHandler<ActionEvent> delAction) {
		this.delAction = delAction;
		deleteBtn.setOnAction(delAction);
	}
	public EventHandler<ActionEvent> getToTopAction() {
		return toTopAction;
	}
	public void setToTopAction(EventHandler<ActionEvent> toTopAction) {
		this.toTopAction = toTopAction;
		sendTotopBtn.setOnAction(toTopAction);
	}
	public EventHandler<ActionEvent> getToBotomAction() {
		return toBotomAction;
	}
	public void setToBotomAction(EventHandler<ActionEvent> toBotomAction) {
		this.toBotomAction = toBotomAction;
		sendToBottomBtn.setOnAction(toBotomAction);
	}
	public EventHandler<ActionEvent> getEditAction() {
		return editAction;
	}
	public void setEditAction(EventHandler<ActionEvent> editAction) {
		this.editAction = editAction;
		editBtn.setOnAction(editAction);
	}
	public EventHandler<ActionEvent> getOnCheckAction() {
		return onCheckAction;
	}
	public void setOnCheckAction(EventHandler<ActionEvent> onCheckAction) {
		this.onCheckAction = onCheckAction;
		taskAcomplishChk.setOnAction(onCheckAction);
	}
	public boolean isChecked() {
		checked=taskAcomplishChk.isSelected();
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
		taskAcomplishChk.setSelected(checked);
	}
	
}
