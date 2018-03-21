package actions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import information.TaskInfo;
import information.UserInfo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import visualAspects.Editing_Page;
import visualAspects.Login_Page;
import visualAspects.MyMenuBar;
import visualAspects.PlayerStatPane;
import visualAspects.RewardsPane;
import visualAspects.TaskPane;

/*what still needs to be done
 *
 * add a user sign in page
 * Allow the user to reset his stats
 * add random rewards
 * add treasure chest rewards.
 * add long goals
 * add habits you want to have
 * 
 */
/*what i have done
 * added scroll pane.
 * Determine if the user forgot to do a task.
 * i made it so when the user closes the page it saves the users stats
 * the user can add as many task boxes as he would like.
 * placed the task information in an array list
 * changed a few of the object names to match what they are to make it easer to understand
 * save the information from the task boxes
 * open the task box information.
 * add mana gains.
 * 
 */
public class TaskActionControler {
	public VBox tkpane = new VBox();
	public PlayerStatPane userPane = new PlayerStatPane();
	public Login_Page login=new Login_Page();
	private UserInfo userInfo = new UserInfo(50, 0, 0, 0, 1);
	private ArrayList<TaskInfo> taskInfoArrayList = new ArrayList<TaskInfo>();
	private int idcount = 0;
	private int curentLvl = 0;
	public RewardsPane rewardPane=new RewardsPane();
	private String username;
	private String passWord;
	public MyMenuBar menuBar=new MyMenuBar();
	//resets all information
	public void reset() {
		userInfo.resetAll(50, 0, 0, 0, 1);
		idcount=0;
		tkpane.getChildren().clear();
		taskInfoArrayList = new ArrayList<TaskInfo>();
		save();
		
	}
	
	// Constructed
	public TaskActionControler(){
		
		userPane.setLayoutY(30);
		userPane.setLayoutX(10);
		tkpane.setSpacing(6);
		rewardPane.setHealAction(e->{
			if(userInfo.getGold()>25&&userInfo.getHealth()<50){
			userInfo.setHealth(userInfo.getHealth()+15);
			userInfo.setGold(userInfo.getGold()-25);
			userPane.setHpint(userInfo.getHealth());
			userPane.setGold((int) userInfo.getGold());
			}else
			System.out.println("you have full health");
		});
	}
	// creates a new task
	public void addNewTask() {
		TaskPane taskPane = new TaskPane();

		taskPane.getId();

		TaskInfo curintTk = new TaskInfo();
		curintTk.setId(idcount);
		idcount++;
		taskInfoArrayList.add(curintTk);
		taskInfoArrayList.get(taskInfoArrayList.size() - 1).getId();
		taskPane = setTaskPaneActions(taskPane, curintTk);
		tkpane.getChildren().add(taskPane);
		taskPane.toBack();
		editTask(taskPane, taskInfoArrayList.size() - 1);
		// this is the task button controls

	}
	//opens a task using TaskInfo
	public void openTask(TaskInfo curintTk) {
		TaskPane taskPane = new TaskPane();
		taskPane.setName(curintTk.getName());
		taskPane.setChecked(curintTk.isChecked());
		idcount = curintTk.getId() + 1;
		taskPane = setTaskPaneActions(taskPane, curintTk);
		tkpane.getChildren().add(taskPane);
		taskPane.toBack();
		// this is the task button controls

	}
	
	private TaskPane setTaskPaneActions(TaskPane taskPane, TaskInfo curintTk) {
		// this determines what buttons and the check box on the taskPane
		taskPane.setDelAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				tkpane.getChildren().remove(taskPane);
				taskInfoArrayList.remove(curintTk);
			}
		});
		taskPane.setToBotomAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				taskPane.toFront();
				taskInfoArrayList.remove(curintTk);
				taskInfoArrayList.add(curintTk);
			}
		});
		taskPane.setToTopAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				taskPane.toBack();
				taskInfoArrayList.remove(curintTk);
				taskInfoArrayList.add(0, curintTk);
			}
		});
		//the check box for the task
		taskPane.setOnCheckAction(e -> {
			boolean checed = taskPane.isChecked();
			if (checed) {
				userInfo.setGold(userInfo.getGold() + (1 * (curintTk.getDificulty() + 1)));
				userPane.setGold((int) userInfo.getGold());
				userInfo.setExp(userInfo.getExp() + (5 * (curintTk.getDificulty() + 1)));
				userInfo.setMana(userInfo.getMana() + (1 * (curintTk.getDificulty() + 1)));
				userPane.setMana((int) userInfo.getMana());
				userPane.setExp((int) userInfo.getExp());
				userPane.setMaxExp((int) userInfo.getExpTillNext());
				if (userInfo.getLevel() != curentLvl) {
					curentLvl = userInfo.getLevel();
					userInfo.setHealth(50);
					userPane.setHpint(50);
					userPane.setlevel(userInfo.getLevel());
				}
			} else {
				userInfo.setGold(userInfo.getGold() - (1 * (curintTk.getDificulty() + 1)));
				userPane.setGold((int) userInfo.getGold());
				userInfo.setExp(userInfo.getExp() - (5 * (curintTk.getDificulty() + 1)));
				userInfo.setMana(userInfo.getMana() - (1 * (curintTk.getDificulty() + 1)));
				userPane.setExp((int) userInfo.getExp());
				userPane.setMaxExp((int) userInfo.getExpTillNext());
				userPane.setMana((int) userInfo.getMana());
			}
			int i = 0;
			for (TaskInfo tk : taskInfoArrayList) {
				if (tk.getId() == curintTk.getId()) {
					break;
				}
				i++;
			}
			taskInfoArrayList.get(i).setChecked(checed);
			curintTk.setChecked(checed);
		});
		// this button gets the index of the task in an array list then sends it
		// to a function that
		// opens an editing page and edits the information.
		taskPane.setEditAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				int i = 0;
				for (TaskInfo tk : taskInfoArrayList) {
					if (tk.getId() == curintTk.getId()) {
						break;
					}
					i++;
				}

				editTask(taskPane, i);
			}
		});
		return taskPane;

	}
	//allows the user to edit the task 
	private void editTask(TaskPane taskPane, int i) {
		Editing_Page editingPage = new Editing_Page();

		editingPage.setStartdate(taskInfoArrayList.get(i).getStartDate());

		editingPage.dellayTimeFrameCbx.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				if (editingPage.dellayTimeFrameCbx.getSelectionModel().getSelectedIndex() == 1) {
					editingPage.weekPane.setVisible(true);
					editingPage.numtext.setVisible(false);
				} else {
					editingPage.weekPane.setVisible(false);
					editingPage.numtext.setVisible(true);
				}

			}
		});
		// this controls the editing page save button to edit a task.
		editingPage.taskNameTF.setText(taskPane.getName());
		editingPage.saveBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				taskPane.setName(editingPage.taskNameTF.getText());

				if (taskInfoArrayList.size() > i) {
					taskInfoArrayList.get(i).setName(editingPage.taskNameTF.getText());
					taskInfoArrayList.get(i)
							.setRepeatEvery(editingPage.dellayTimeFrameCbx.getSelectionModel().getSelectedIndex());
					taskInfoArrayList.get(i)
							.setDificulty(editingPage.difficultyCbx.getSelectionModel().getSelectedIndex());
					taskInfoArrayList.get(i).setStartDate(editingPage.getStartdate());

					
				}
				editingPage.close();
				return;
			}
		});
	}

	public void save() {
		File file = new File(username+"Files/userInfo.txt");
		try {
			PrintWriter output = new PrintWriter(file);
			output.print(userInfo.toString());
			output.close();
			/*
			 * save tasks
			 */
			file = new File(username+"Files/taskInfo.txt");
			file.delete();
			output = new PrintWriter(file);
			output.print("");
			for (TaskInfo tk : taskInfoArrayList) {
				System.out.println(tk.toString());
				output.println(tk.toString());
			}
			output.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void checkDate() {
		//this determines weather the day has changed
		if (!userInfo.getCompDate().equals(LocalDate.now())) {
			tkpane.getChildren().clear();
			for (TaskInfo tempTask : taskInfoArrayList) {
				if (!tempTask.isChecked() && tempTask.isTaskDue()) {
					userInfo.setHealth(userInfo.getHealth() - (tempTask.getDificulty() + 1));
					userPane.setHpint(userInfo.getHealth());
					if(userInfo.getHealth()<=0) {
						userInfo.setHealth(50);
						userInfo.setGold(0);
						userInfo.setExp(0);
						if(userInfo.getLevel()>1)
						userInfo.setLevel(userInfo.getLevel()-1);
					}
				}
				tempTask.setChecked(false);
				userInfo.setCompDate(LocalDate.now());
				this.openTask(tempTask);

			}
		}
	}

	public void open() {
		//this opens all information from the saved documents.
		String ust = "";
		try {
			
			File userStatFile= new File("userInfo/curintUser.txt");
			Scanner fileReader = new Scanner(userStatFile);
			String userline = fileReader.nextLine();
			 username = userline.split(" ")[0];
			 passWord=userline.split(" ")[1];
			 userStatFile = new File(username+"Files/userInfo.txt");
			 
			 fileReader = new Scanner(userStatFile);
			ust = fileReader.nextLine();
			userInfo.readUserString(ust);
			fileReader.close();
			userStatFile = new File(username+"Files/taskInfo.txt");
			fileReader = new Scanner(userStatFile);
			while (fileReader.hasNextLine()) {

				TaskInfo tempTask = new TaskInfo();
				tempTask.readString(fileReader.nextLine());
				if (!userInfo.getCompDate().equals(LocalDate.now())) {

					if (!tempTask.isChecked() && tempTask.isTaskDue()) {
						userInfo.setHealth(userInfo.getHealth() - tempTask.getDificulty());
						if(userInfo.getHealth()<=0) {
							userInfo.setHealth(50);
							userInfo.setGold(0);
							userInfo.setExp(0);
							if(userInfo.getLevel()>1)
							userInfo.setLevel(userInfo.getLevel()-1);
						}
					}
					tempTask.setChecked(false);
				}

				
				this.openTask(tempTask);
				taskInfoArrayList.add(tempTask);
			}
			userInfo.setCompDate(LocalDate.now());
			fileReader.close();

			

		} catch (IOException e) {
			e.printStackTrace();
		}

		userPane.setAll(userInfo.getHealth(), userInfo.getLevel(), userInfo.getGold(), userInfo.getExp(),
				userInfo.getMana(), userInfo.getName());
		userPane.setMaxExp((int) userInfo.getExpTillNext());
	}

	public void settings() {
		
	}
}
