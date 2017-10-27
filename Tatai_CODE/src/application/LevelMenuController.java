package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class LevelMenuController {
	/**
	 * Create all JavaFX controls, for the levelMenu Scene, for the user.
	 */
	
	@FXML
	protected Button easyGoButton;
	
	@FXML
	protected Button mediumGoButton;
	
	@FXML
	protected Button hardGoButton;
	
	@FXML
	protected Button customGoButton;
	
	@FXML
	protected Button customSettings;
	
	@FXML
	protected Button mainMenuButton;
	
	@FXML
	protected Label mediumMessage;
	@FXML
	protected Label hardMessage;
	@FXML
	protected Label customMessage;
	
	/**
	 * When 'Go!' button for easy is pressed, move to quiz scene with level set to 
	 * easy.
	 * @param event
	 * @throws IOException
	 */
	public void easyGoPress(ActionEvent event) throws IOException {
		StorageAndSetUps.getInstance().qc.level = Level.EASY;		
		StorageAndSetUps.getInstance().quizSetup();
		Scene quiz = StorageAndSetUps.getInstance().quiz;
		Stage window = (Stage) easyGoButton.getScene().getWindow();
		window.setScene(quiz);
	}
	
	/**
	 * When 'Go!' button for medium is pressed, move to quiz scene with level set to 
	 * medium.
	 * @param event
	 * @throws IOException
	 */
	public void mediumGoPress(ActionEvent event) throws IOException {
		StorageAndSetUps.getInstance().qc.level = Level.MEDIUM;
		StorageAndSetUps.getInstance().quizSetup();
		Scene quiz = StorageAndSetUps.getInstance().quiz;
		Stage window = (Stage) mediumGoButton.getScene().getWindow();
		window.setScene(quiz);
	}
	
	/**
	 * When 'Go!' button for hard is pressed, move to quiz scene with level set to 
	 * hard.
	 * @param event
	 * @throws IOException
	 */
	public void hardGoPress(ActionEvent event) throws IOException {
		StorageAndSetUps.getInstance().qc.level = Level.HARD;
		StorageAndSetUps.getInstance().quizSetup();
		Scene quiz = StorageAndSetUps.getInstance().quiz;
		Stage window = (Stage) hardGoButton.getScene().getWindow();
		window.setScene(quiz);
	}
	
	/**
	 * When 'Go!' button for hard is pressed, move to quiz scene with level set to 
	 * custom.
	 * @param event
	 * @throws IOException
	 */
	public void customGoPress(ActionEvent event) throws IOException {
		StorageAndSetUps.getInstance().qc.level = Level.CUSTOM;
		StorageAndSetUps.getInstance().quizSetup();
		Scene quiz = StorageAndSetUps.getInstance().quiz;
		Stage window = (Stage) customGoButton.getScene().getWindow();
		window.setScene(quiz);
	}
	
	/**
	 * When Custom Settings is pressed, scene is changed to the custom menu.
	 * @param event
	 * @throws IOException
	 */
	public void customSettingsPress(ActionEvent event) throws IOException {
		Scene custom = StorageAndSetUps.getInstance().custom;
		Stage window = (Stage) customSettings.getScene().getWindow();
		window.setScene(custom);
	}
	
	
	/**
	 * When MainMenu is pressed, switch to menu scene.
	 * @param event
	 * @throws IOException
	 */
	public void mainMenuPress(ActionEvent event) throws IOException {
		Scene menu = StorageAndSetUps.getInstance().menu;
		Stage window = (Stage) hardGoButton.getScene().getWindow();
		window.setScene(menu);
	}
	

}
