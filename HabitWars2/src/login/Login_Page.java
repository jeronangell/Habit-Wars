package login;

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
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Login_Page extends Stage{
	
	private boolean logedIN=true;
	public Login_Page(){
		
		MyTextField userNameTf= new MyTextField("UserName");
		MyTextField PaswordTf = new MyTextField("Password");
		MyButton newUserPageBtn = new MyButton("New User Page");
		MyButton loginBtn= new MyButton("Login");
		VBox logInPage=new VBox();
		VBox newUserPage=new VBox();
		MyTextField addUserTf=new MyTextField("UserName");
		MyTextField charecterTf=new MyTextField("Charecter Name");
		MyTextField addPasswordTf=new MyTextField("Password");
		MyButton newAcountBtn=new MyButton("New Acount");
		MyButton loginPageBtn=new MyButton("Login page");
		LoginActions loginAct = new LoginActions();
		newUserPageBtn.setOnAction(e->{
			logInPage.setVisible(false);
			newUserPage.setVisible(true);
		});
		loginPageBtn.setOnAction(e->{
			logInPage.setVisible(true);
			newUserPage.setVisible(false);
		});
		loginBtn.setOnAction(e->{
			
			if(loginAct.login(userNameTf.getText(),PaswordTf.getText())) {
				this.close();
			}
		});
		newAcountBtn.setOnAction(e->{
			loginAct.newAcount(userNameTf.getText(),PaswordTf.getText(),charecterTf.getText());
		});
		
		
		logInPage.setVisible(true);
		newUserPage.setVisible(false);
		
		logInPage.setSpacing(6);
		Insets inst = new Insets(10, 10, 10, 10);
		logInPage.setPadding(inst);
		logInPage.getChildren().addAll(userNameTf,PaswordTf,loginBtn,newUserPageBtn);
		
		newUserPage.setSpacing(6);
		newUserPage.setPadding(inst);
		newUserPage.getChildren().addAll(addUserTf,addPasswordTf,charecterTf,newAcountBtn,loginPageBtn);
		
		StackPane stc=new StackPane(); 
		stc.getChildren().addAll(logInPage,newUserPage);
		Scene scene = new Scene(stc,400,400);
		
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		this.setScene(scene);
		this.initModality(Modality.APPLICATION_MODAL);
		this.show();
		logedIN=false;
		
	}
		public boolean isLogedIN() {
		return logedIN;
	}
	public void setLogedIN(boolean logedIN) {
		this.logedIN = logedIN;
	}
		class MyButton extends Button{

			public MyButton(String string) {
				// TODO Auto-generated constructor stub
				Font fnt=Font.font(20);
				this.setText(string);
				this.setFont(fnt);
			}
			
		}
		class MyTextField extends TextField{

			public MyTextField(String str) {
				// TODO Auto-generated constructor stub
				this.setPromptText(str);
				Font fnt=Font.font(20);
				this.setFont(fnt);
			}
			
		}
	
}
