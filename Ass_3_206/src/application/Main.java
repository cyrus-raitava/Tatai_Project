package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

	Stage window;


	@Override
	public void start(Stage primaryStage) {
		try {

			window = primaryStage; 

			Scene scene = SceneStorage.getInstance().menu;

			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

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
