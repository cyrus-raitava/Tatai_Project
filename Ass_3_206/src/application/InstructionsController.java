package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class InstructionsController {

	
	@FXML
	private Button returnButton;
	
	public void returnPress(ActionEvent event) throws IOException {
		Scene menu = SceneStorage.getInstance().menu;
		Stage window = (Stage) returnButton.getScene().getWindow();
		window.setScene(menu);
	}
}
