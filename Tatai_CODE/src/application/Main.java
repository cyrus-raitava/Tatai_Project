package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Main extends Application {

	Stage window;

	@Override
	public void start(Stage primaryStage) {
		
		try {
			
			// Call specific method for creating necessary files and subsequent folder structure
			
			PersistentStates.createStartFile();
			
			// Load the created users, and set the necessary controls as being visible or not,
			// in the UserLogin screen, prior to showing it.
			
			UserLogin.loadUsers();
			UserLogin.startUp();
			
			window = primaryStage; // set primary stage
			
			Scene scene = StorageAndSetUps.getInstance().userLogin; // load menu scene

			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm()); // set style

			// set constraints of the stage
			window.setTitle("Tātai");
			window.setScene(scene);
			window.show();
			window.setResizable(false);
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
