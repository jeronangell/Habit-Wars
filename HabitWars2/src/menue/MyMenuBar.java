package menue;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class MyMenuBar extends MenuBar {
	
	

	public MyMenuBar() {
		MenuActions act= new MenuActions();
		MenuItem btnLogout;
		MenuItem btnSettings;
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
        btnLogout= new MenuItem("Log out");
        btnLogout.setOnAction(e->act.logout());
        btnSettings= new MenuItem("settings");
       menuUser.getItems().addAll(btnLogout,btnSettings);
       
		this.getMenus().addAll(menuFile, menuEdit, menuView,menuUser);
	}
}
