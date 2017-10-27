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
	public Button mediumTransition;
	@FXML
	public Button hardTransition;
	
	/**
	 * When mediumTransition button is pressed, it moves to the medium quiz setup. 
	 * @param event
	 * @throws IOException
	 */
	public void mediumTransitionPressed(ActionEvent event) throws IOException {
		PersistentStates.stageUnlockSet(UserLogin.username);
		PersistentStates.achievementsLoad(UserLogin.username);	
				
		// set quizLevel to medium
		StorageAndSetUps.getInstance().qc.level = Level.MEDIUM;
				
		// reset quizController to defaults 
		StorageAndSetUps.getInstance().quizSetup();
		Scene quiz = StorageAndSetUps.getInstance().quiz;
		Stage window = (Stage) mediumTransition.getScene().getWindow();
		window.setScene(quiz);
	}
	
	/**
	 * When hardTransition button is pressed, it moves to the hard quiz setup. 
	 * @param event
	 * @throws IOException
	 */
	public void hardTransitionPressed(ActionEvent event) throws IOException {
		PersistentStates.stageUnlockSet(UserLogin.username);
		PersistentStates.achievementsLoad(UserLogin.username);	
		
		// reset quizController to defaults after setting level as hard
		StorageAndSetUps.getInstance().qc.level = Level.HARD;
		StorageAndSetUps.getInstance().quizSetup();
		Scene quiz = StorageAndSetUps.getInstance().quiz;
		Stage window = (Stage) hardTransition.getScene().getWindow();
		window.setScene(quiz);
	}
	
	@FXML
	protected Label score;
	
	/**
	 * When level menu is pressed, scene is switched to level menu.
	 * @param event
	 * @throws IOException
	 */
	public void levelMenuPress(ActionEvent event) throws IOException {
		PersistentStates.stageUnlockSet(UserLogin.username);
		PersistentStates.achievementsLoad(UserLogin.username);	
		
		Scene levelMenu = StorageAndSetUps.getInstance().levelMenu;
		Stage window = (Stage) levelMenuButton.getScene().getWindow();
		window.setScene(levelMenu);
	}


}
