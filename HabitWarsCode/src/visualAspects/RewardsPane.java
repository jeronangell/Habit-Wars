package visualAspects;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

public class RewardsPane extends VBox{
	//this page needs to have 3 status bars and any time i change any of the values 
	//the perspective bars get changed as well when those values get changed.
	private EventHandler<ActionEvent> healAction =null;
	private Button healBtn=new Button("healing Potion");
	private Button treasurChestBtn=new Button("treasure chest");
	public RewardsPane(){
		healBtn.setTooltip(new Tooltip("gives you 15 hit points and costs 25 gold"));
		treasurChestBtn.setTooltip(new Tooltip("coming soon"));
		healBtn.setOnAction(healAction);
		this.getChildren().addAll(healBtn,treasurChestBtn);
		
	}
	public void healBtnclicked() {
		System.out.println("heal button clicked");
	}
	public EventHandler<ActionEvent> getHealAction() {
		return healAction;
	}
	public void setHealAction(EventHandler<ActionEvent> healAction) {
		this.healAction = healAction;
		healBtn.setOnAction(healAction);
	}
	
}
