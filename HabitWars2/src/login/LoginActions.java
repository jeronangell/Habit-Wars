package login;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import application.MainPage;

public class LoginActions {

	public boolean login(String userName, String passWord) {
		if(checkUserRecords(userName,passWord)) {
			
			MainPage mainPage=new MainPage(userName,passWord);
			return true;
		}else {
			return false;
		}
	}
	private boolean checkUserRecords(String userName, String passWord) {
		// opens a file and checks if the user name and password match any in file.
				File file = new File("userInfo/login.txt");
				System.out.println(file.exists());


		if(file.exists())
				try {
					userName=userName.toLowerCase();
				    Scanner scanner = new Scanner(file);
				    while (scanner.hasNextLine()) {
				    	
				    String[] nst = scanner.nextLine().split(" ");
				   // System.out.println( nst[0]);
				    	if(userName.equals(nst[0].toLowerCase())&&passWord.equals(nst[1])){
				    		
				    		return true;
				    	}
				    }
				    scanner.close();
				} catch (FileNotFoundException e) {
				    e.printStackTrace();
				} 
				return false;
	}
	public void newAcount(String userName, String passWord,String CharecterName) {
		// TODO Auto-generated method stub
		
	}

}
