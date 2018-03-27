# Habit-Wars
 <font size="+2">
 to start my program run the file in the Habit-Wars/src/start/main.java

## Synopsis
This game is to help people be more productive by giving rewards for doing real-life tasks. The program is rather simple when you first start the program, it will ask you for a username and password. If you don't have a login you may create one by clicking the new user button and adding a username & password and your character's name then click log in and enter your username and password. Then you may create tasks that you need to do each day I currently have it so tasks can only be set to be required daily you may put in the name of your task and the difficulty of that task if that task has not been completed by the end of the day you will lose hit points. If you lose all your hit points you lose one level, all of your exp (experience), gold, and one of your gear that you may collect, though so far there is no gear to receive.

## Code Example

I split my code into four different folders actions information start and visual aspects.

the code below starts my program.

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
The reason I created this program is to help myself and others to get and stay motivated to accomplish there short and long turn goals. Far to often the lure of instant gratification out ways the drive to accomplish our goals, and I am hoping this game can help me harness my addictive personality to make my dreams a reality.

## Installation
Clone my repository than in eclipse create a new Java project and make HabitWarsCode the directory opens the src folder then the start package then start.Java. and hit run.

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
The reference documents are located in the user info folder in the habitWarsCode folder and the rest are created as new users are created.

## Tests
The code is started by running the main.java in HabitwarsCode/src/start/Main.java.

     TaskActionControler tac = new TaskActionControler();

        tac.login.login();
        tac.login.setLoginAction(e -> {
            if (tac.login.loginAct()) {
                startPro(tac, primaryStage);
                tac.login.close();
            }
        });

## Contributors

To contribute just clone the repository then commit and push when you have changes you would like to add with comments.

## License

Your guess is as good as mine.

