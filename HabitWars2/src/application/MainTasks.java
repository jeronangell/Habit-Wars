package application;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

import playerInfo.PlayerStats;

public class MainTasks {

	public PlayerStats openPlayerStats(String userName, String passWord) {
		PlayerStats playStats = new PlayerStats();
			//this opens all information from the saved documents.
			String ust = "";
			try {
				
				File userStatFile= new File(userName+"Files/userInfo.txt");
				Scanner fileReader = new Scanner(userStatFile); 
				ust = fileReader.nextLine();
				playStats.readUserString(ust);
				fileReader.close();
				

			} catch (IOException e) {
				e.printStackTrace();
			}
		

		return playStats;
	}

	public void save() {
		// TODO Auto-generated method stub
		
	}

}
