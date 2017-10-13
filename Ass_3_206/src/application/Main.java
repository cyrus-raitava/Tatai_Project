package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

	Stage window;


	@Override
	public void start(Stage primaryStage) {
		try {

			PersistentStats.createFile();
			PersistentStats.loadStats();
			
			window = primaryStage; // set primary stage

			Scene scene = StorageAndSetUps.getInstance().menu; // load menu scene

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
