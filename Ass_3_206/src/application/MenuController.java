package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MenuController {

	
	@FXML
	private Button timataButton;
	
	@FXML
	private Button howToButton;
	
	public void timataPress(ActionEvent event) throws IOException {
		Scene levelMenu = SceneStorage.getInstance().levelMenu;
		Stage window = (Stage) timataButton.getScene().getWindow();
		window.setScene(levelMenu);
	}
	
	public void howTo(ActionEvent event) throws IOException {
		Scene instructions = SceneStorage.getInstance().instructions;
		Stage window = (Stage) timataButton.getScene().getWindow();
		window.setScene(instructions);
	}
	
	public void statsPress(ActionEvent event) throws IOException {
		Scene statistics = SceneStorage.getInstance().statistics;
		Stage window = (Stage) timataButton.getScene().getWindow();
		window.setScene(statistics);
	}
}
