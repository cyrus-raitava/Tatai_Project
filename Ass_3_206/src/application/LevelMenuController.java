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
	
	public void easyGoPress(ActionEvent event) throws IOException {
		SceneStorage.getInstance().quizSetup();
		SceneStorage.getInstance().qc.hard = false;
		Scene quiz = SceneStorage.getInstance().quiz;
		Stage window = (Stage) easyGoButton.getScene().getWindow();
		window.setScene(quiz);
	}
	
	public void hardGoPress(ActionEvent event) throws IOException {
		SceneStorage.getInstance().quizSetup();
		SceneStorage.getInstance().qc.hard = true;
		Scene quiz = SceneStorage.getInstance().quiz;
		Stage window = (Stage) hardGoButton.getScene().getWindow();
		window.setScene(quiz);
	}
	
	public void mainMenuPress(ActionEvent event) throws IOException {
		Scene menu = SceneStorage.getInstance().menu;
		Stage window = (Stage) hardGoButton.getScene().getWindow();
		window.setScene(menu);
	}
	

}
