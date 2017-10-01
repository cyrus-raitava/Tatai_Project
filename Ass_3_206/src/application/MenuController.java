package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * @author t-mcl
 *
 */
public class MenuController {

	
	@FXML
	private Button timataButton;
	
	@FXML
	private Button howToButton;
	
	@FXML
	private Button statsButton;
	
	/**
	 * When timata is pressed, change scenes to level menu
	 * @param event
	 * @throws IOException
	 */
	public void timataPress(ActionEvent event) throws IOException {
		Scene levelMenu = SceneStorage.getInstance().levelMenu;
		Stage window = (Stage) timataButton.getScene().getWindow();
		window.setScene(levelMenu);
	}
	
	
	/**
	 * When how to play button is pressed, switch to instructions scene.
	 * @param event
	 * @throws IOException
	 */
	public void howTo(ActionEvent event) throws IOException {
		Scene instructions = SceneStorage.getInstance().instructions;
		Stage window = (Stage) timataButton.getScene().getWindow();
		window.setScene(instructions);
	}
	
	/**
	 * When stats button is pressed, switch to statistics scene.
	 * @param event
	 * @throws IOException
	 */
	public void statsPress(ActionEvent event) throws IOException {
		Scene statistics = SceneStorage.getInstance().statistics;
		Stage window = (Stage) timataButton.getScene().getWindow();
		window.setScene(statistics);
	}
}
