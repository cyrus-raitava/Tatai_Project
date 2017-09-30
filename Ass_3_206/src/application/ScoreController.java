package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ScoreController {

	
	@FXML
	private Button levelMenuButton;
	
	@FXML
	public Button hardTransition;
	
	public void hardTransitionPressed(ActionEvent event) throws IOException {
		SceneStorage.getInstance().quizSetup();
		SceneStorage.getInstance().qc.hard = true;
		Scene quiz = SceneStorage.getInstance().quiz;
		Stage window = (Stage) hardTransition.getScene().getWindow();
		window.setScene(quiz);
	}
	
	@FXML
	protected Label score;
	
	public void levelMenuPress(ActionEvent event) throws IOException {
		Scene levelMenu = SceneStorage.getInstance().levelMenu;
		Stage window = (Stage) levelMenuButton.getScene().getWindow();
		window.setScene(levelMenu);
	}


}
