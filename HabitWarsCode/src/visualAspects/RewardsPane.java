package visualAspects;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.FlowPane;

public class RewardsPane extends FlowPane {
	// this page needs to have 3 status bars and any time i change any of the values
	// the perspective bars get changed as well when those values get changed.
	private EventHandler<ActionEvent> healAction = null;
	private Button healBtn = new Button("healing Potion");
	private Button treasurChestBtn = new Button("treasure chest");

	public RewardsPane() {
		this.setMaxWidth(200);
		healBtn.setTooltip(new Tooltip("costs 25 gold heals 15 hitpoints"));
		treasurChestBtn.setTooltip(new Tooltip("coming soon"));
		healBtn.setOnAction(healAction);

		this.getChildren().addAll(healBtn, treasurChestBtn);

	}

	// Allows other cases to edit the buttons actions
	public EventHandler<ActionEvent> getHealAction() {
		return healAction;
	}

	public void setHealAction(EventHandler<ActionEvent> healAction) {
		this.healAction = healAction;
		healBtn.setOnAction(healAction);
	}

}
