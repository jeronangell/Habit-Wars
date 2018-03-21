# Habit-Wars
 <font size="+2">
 to start my program run the file in the Habit-Wars/src/start/main.java

## Synopsis
this game is to help people be more productive by giving rewards for doing real life tasks. the program is rather simple 
 when you first start the program, it will ask you for a username and password. If you don't have a log in may create one
 by clicking the new user button and adding a user name password and your character's name then click login and enter in your
 user name and password. then you may create tasks that you need to do each day I currently
 have it so tasks can only be set to daily requirement you may put in the name of your task and the difficulty of that task 
 if that task has not been completed by the end of the day you will lose hit points if you lose all your hit points you lose one level, all of your exp, gold, and one of your gear that you may collect though so far there is gear to receive.

## Code Example

I split my code in to four difrent folders actions information start and visualAspects.
this starts the login page then when the user is verifide the main page opens

public void start(Stage primaryStage) throws FileNotFoundException {
		// adding the task action controller
		// this basically creates the main pages views
		TaskActionControler tac = new TaskActionControler();

		tac.login.login();
		tac.login.setLoginAction(e -> {
			if (tac.login.loginAct()) {
				startPro(tac, primaryStage);
				tac.login.close();
			}
		});

	}
		

## Motivation
the reason I created this program? is because at times i feel that i have a low amount of motivation to do things. like take a shower eat clean or any other task that is needed in the day so I decided that I would create a game that would help you improve your life, and hear it is sort of. it needs a lot of work.

## Installation
clone my repository then in eclipse create a new java project and make HabitWarsCode java directory
open the src folder then the start package then start.java. and hit run
BorderPane main = new BorderPane();
		Pane root = new Pane();

//this shows the main page
		tac.open();
		root.getChildren().addAll(tac.userPane, taskScroll, taskbutton, toDolist, tac.rewardPane);
		Scene scene = new Scene(main, 510, 400);
		primaryStage.setOnCloseRequest(et -> tac.save());
		primaryStage.setScene(scene);
		primaryStage.show();
  
## API Reference
the refrence documpents are located in userinfo folder in the habitWarsCode folder and the rest  are created as new users are created.

## Tests
the code is started by runing the main.java in HabitwarsCode/src/start/Main.java.
TaskActionControler tac = new TaskActionControler();

		tac.login.login();
		tac.login.setLoginAction(e -> {
			if (tac.login.loginAct()) {
				startPro(tac, primaryStage);
				tac.login.close();
			}
		});

## Contributors

to contribute just clone the repository then commit and push when you have changes you would like to add with comments.

## License

your guess is as good as mine
