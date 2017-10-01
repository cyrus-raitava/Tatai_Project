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
	
	/**
	 * When hardTransition button is pressed, it moves to the hard quiz setup. 
	 * @param event
	 * @throws IOException
	 */
	public void hardTransitionPressed(ActionEvent event) throws IOException {
		SceneStorage.getInstance().qc.hard = true;
		SceneStorage.getInstance().quizSetup();
		Scene quiz = SceneStorage.getInstance().quiz;
		Stage window = (Stage) hardTransition.getScene().getWindow();
		window.setScene(quiz);
		// reset quizController to defaults 
	}
	
	@FXML
	protected Label score;
	
	/**
	 * When level menu is pressed, scene is switched to level menu.
	 * @param event
	 * @throws IOException
	 */
	public void levelMenuPress(ActionEvent event) throws IOException {
		Scene levelMenu = SceneStorage.getInstance().levelMenu;
		Stage window = (Stage) levelMenuButton.getScene().getWindow();
		window.setScene(levelMenu);
	}


}
