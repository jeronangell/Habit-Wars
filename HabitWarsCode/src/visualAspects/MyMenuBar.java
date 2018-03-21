package visualAspects;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class MyMenuBar extends MenuBar {
	
	
	private MenuItem btnLogout= new MenuItem("Log out");;
	private MenuItem btnReset= new MenuItem("reset");
	private MenuItem btnSettings= new MenuItem("Settings");
	
	public MyMenuBar() {
		Menu menuFile;
		 Menu menuEdit;
		 Menu menuView;
		 Menu menuUser;
		 
        menuFile = new Menu("File");

       // --- Menu Edit
        menuEdit = new Menu("Edit");
       
       // --- Menu View
        menuView = new Menu("View");
       // --- Menu View
        menuUser = new Menu("User");
        
        btnSettings= new MenuItem("settings");
       menuUser.getItems().addAll(btnLogout,btnReset,btnSettings);
       
		this.getMenus().addAll(menuFile, menuEdit, menuView,menuUser);
	}

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
