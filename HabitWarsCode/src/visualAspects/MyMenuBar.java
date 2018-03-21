package visualAspects;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.shape.Rectangle;

public class MyMenuBar extends MenuBar {
	
	//this page creates the menu bar
	private MenuItem btnLogout= new MenuItem("Log out");;
	private MenuItem btnReset= new MenuItem("reset");
	private MenuItem btnSettings= new MenuItem("Settings");
	
	public MyMenuBar() {
		Menu menuFile;
		 Menu menuEdit;
		 Menu menuView;
		 Menu menuUser;
		 Rectangle rect = new Rectangle();
		    rect.setHeight(100);
		    rect.setWidth(100);

        menuFile = new Menu("File");
       // --- Menu Edit
        menuEdit = new Menu("Edit");
       // --- Menu View
        menuView = new Menu("View");
       // --- Menu View
        menuUser = new Menu("User");
        btnSettings= new MenuItem("settings");
       menuUser.getItems().addAll(btnLogout,btnReset);
       
		this.getMenus().addAll(menuUser);
	}
// alow other pages to set the actions
	public void setLogoutAction(EventHandler<ActionEvent> logout) {
		btnLogout.setOnAction(logout);
		
	}
	public void setSettingsAction(EventHandler<ActionEvent> settings) {
		btnSettings.setOnAction(settings);
		
	}
	public void setResetAction(EventHandler<ActionEvent> settings) {
		btnReset.setOnAction(settings);
		
	}
}
