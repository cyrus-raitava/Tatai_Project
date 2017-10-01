package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class LevelMenuController {
	
	@FXML
	private Button easyGoButton;
	
	@FXML
	private Button hardGoButton;
	
	@FXML
	private Button mainMenuButton;
	
	/**
	 * When 'Go!' button for easy is pressed, move to quiz scene with hard set to 
	 * false.
	 * @param event
	 * @throws IOException
	 */
	public void easyGoPress(ActionEvent event) throws IOException {
		SceneStorage.getInstance().quizSetup(); // reset quiz to initial state
		SceneStorage.getInstance().qc.hard = false; // set hard to false
		
		// swap scenes
		Scene quiz = SceneStorage.getInstance().quiz;
		Stage window = (Stage) easyGoButton.getScene().getWindow();
		window.setScene(quiz);
	}
	
	
	
	/**
	 * When 'Go!' button for hard is pressed, move to quiz scene with hard set to 
	 * true.
	 * @param event
	 * @throws IOException
	 */
	public void hardGoPress(ActionEvent event) throws IOException {
		SceneStorage.getInstance().quizSetup(); // reset quiz to initial state
		SceneStorage.getInstance().qc.hard = true; // set hard to true
		
		// swap scenes
		Scene quiz = SceneStorage.getInstance().quiz;
		Stage window = (Stage) hardGoButton.getScene().getWindow();
		window.setScene(quiz);
	}
	
	
	/**
	 * When MainMenu is pressed, switch to menu scene.
	 * @param event
	 * @throws IOException
	 */
	public void mainMenuPress(ActionEvent event) throws IOException {
		Scene menu = SceneStorage.getInstance().menu;
		Stage window = (Stage) hardGoButton.getScene().getWindow();
		window.setScene(menu);
	}
	

}
