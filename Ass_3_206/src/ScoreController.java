package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ScoreController {

	
	@FXML
	private Button levelMenuButton;
	
	public void levelMenuPress(ActionEvent event) throws IOException {
		Scene levelMenu = SceneStorage.getInstance().levelMenu;
		Stage window = (Stage) levelMenuButton.getScene().getWindow();
		window.setScene(levelMenu);
	}

}
