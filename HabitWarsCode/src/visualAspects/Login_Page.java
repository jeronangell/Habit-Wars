package visualAspects;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Login_Page extends Stage {
	private TextField userNameTf = new TextField("");
	private TextField PaswordTf = new TextField("");
	private Button newUserBtn = new Button("New User Page");
	private Button loginBtn = new Button("Login");
	private Label statusLbl = new Label("Log In Status");
	private VBox logInfo = new VBox();
	private VBox newUserPage = new VBox();

	public Login_Page() {

		logInfo.setSpacing(6);
		logInfo.setPadding(new Insets(10, 10, 10, 10));
		logInfo.getChildren().addAll(statusLbl, userNameTf, PaswordTf, loginBtn, newUserBtn);
		newUserPage.setSpacing(6);
		newUserPage.setPadding(new Insets(10, 10, 10, 10));
		newUserPage.getChildren().addAll(addUserTf, addPasswordTf, charecterTf, saveBtn, loginPageBtn);
		StackPane stc = new StackPane();
		stc.getChildren().addAll(logInfo, newUserPage);
		Scene scene = new Scene(stc, 400, 400);
		this.setScene(scene);
		this.initModality(Modality.APPLICATION_MODAL);
		this.initOwner(null);
		this.show();

	}

	public void login() {
		// builds the login page
		Font fnt = Font.font(20);
		userNameTf.setPromptText("UserName");
		PaswordTf.setPromptText("Password");
		loginBtn.setFont(fnt);
		statusLbl.setFont(fnt);

		userNameTf.setFont(fnt);
		PaswordTf.setFont(fnt);

		newUserBtn.setFont(fnt);
		newUserBtn.setOnAction(e -> {
			newUser();
		});
		newUserPage.toBack();
		logInfo.setVisible(true);
		logInfo.toFront();
		newUserPage.setVisible(false);

	}

	private TextField addUserTf = new TextField();
	private TextField charecterTf = new TextField();
	private TextField addPasswordTf = new TextField();
	private Button saveBtn = new Button("Save");
	private Button loginPageBtn = new Button("Login page");

	private void newUser() {
		// builds the user page
		Font fnt = Font.font(20);
		addUserTf.setPromptText("UserName");
		addPasswordTf.setPromptText("Password");
		addPasswordTf.setTooltip(new Tooltip("spaces are not alowed, and must be more than 4 charecters long"));
		charecterTf.setPromptText("charecter name");
		addUserTf.setFont(fnt);
		addUserTf.setTooltip(new Tooltip("spaces are not alowed, and must be more than 4 charecters long"));
		addPasswordTf.setFont(fnt);
		charecterTf.setFont(fnt);
		saveBtn.setFont(fnt);
		loginBtn.setFont(fnt);
		loginPageBtn.setFont(fnt);
		loginPageBtn.setOnAction(e -> {
			newUserPage.toBack();
			logInfo.setVisible(true);
			logInfo.toFront();
			newUserPage.setVisible(false);
		});
		saveBtn.setOnAction(e -> {
			createUser();
		});
		logInfo.setVisible(false);
		newUserPage.setVisible(true);
		newUserPage.toFront();
	}

	private void createUser() {
		String userName = addUserTf.getText();
		String passWord = addPasswordTf.getText();
		String charectername = this.charecterTf.getText();
		File file = new File("userInfo/login.txt");
		if (userName.length() < 5) {
			return;
		}
		if (passWord.length() < 5) {
			return;
		}

		if (file.exists()) {
			try {
				userName = userName.toLowerCase();

				Scanner scanner = new Scanner(file);
				while (scanner.hasNextLine()) {
					String[] nst = scanner.nextLine().split(" ");
					if (userName.equals(nst[0].toLowerCase()))
						return;
				}
				scanner.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		try (FileWriter fw = new FileWriter("userInfo/login.txt", true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter out = new PrintWriter(bw)) {
			out.println(userName + " " + passWord);
			out.close();
			// more code
			File fi = new File(userName + "Files");
			fi.mkdirs();
			fi = new File(userName + "Files/userInfo.txt");
			PrintWriter output = new PrintWriter(fi);
			output.print("HP ,(50)LVL ,(1)GOLD ,(0)EXP ,(0)MANA ,(0)NAME ,(" + charectername + ")signin ,(9/03/2018)");
			output.close();
			fi = new File(userName + "Files/taskInfo.txt");
			fi.createNewFile();
		} catch (IOException e) {
			// exception handling left as an exercise for the reader
		}
		logInfo.setVisible(true);
		newUserPage.setVisible(false);
	}

	public void setLoginAction(EventHandler<ActionEvent> actionevent) {

		loginBtn.setOnAction(actionevent);
	}

	public boolean loginAct() {
		// checks and logs in the user.
		String userStr = userNameTf.getText();
		String passStr = PaswordTf.getText();
		if (checkforUser(userStr, passStr)) {
			File fi = new File("userInfo/curintUser.txt");

			try {
				PrintWriter output = new PrintWriter(fi);
				output.print(userStr + " " + PaswordTf);
				output.close();
				return true;
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// after i login i want this page to close and the main page to open
			this.close();
		}
		return false;
	}

	private boolean checkforUser(String userStr, String passStr) {
		// opens a file and checks if the user name and password match any in file.
		File file = new File("userInfo/login.txt");

		if (file.exists())
			try {
				userStr = userStr.toLowerCase();
				Scanner scanner = new Scanner(file);
				while (scanner.hasNextLine()) {

					String[] nst = scanner.nextLine().split(" ");
					if (userStr.equals(nst[0].toLowerCase()) && passStr.equals(nst[1])) {
						statusLbl.setText("you are loged in");
						return true;
					}
				}
				statusLbl.setText("the username did not match database");
				scanner.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		return false;
	}

}
