package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class InstructionsController implements Initializable {

	@FXML
	private Label myLabel;
	
	@FXML
	public TextArea dataPane = new TextArea();
	
	@FXML
	public Label disclaimer;
	

	@FXML
	private Button returnButton;
	
	/**
	 * Switches to main menu scene when return button is pressed
	 * @param event
	 * @throws IOException
	 */
	public void returnPress(ActionEvent event) throws IOException {
		Scene menu = StorageAndSetUps.getInstance().menu;
		Stage window = (Stage) returnButton.getScene().getWindow();
		window.setScene(menu);
	}
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		disclaimer.setVisible(true);
		
		
		dataPane.setMaxWidth(540);
		dataPane.setEditable(false);
		dataPane.setWrapText(true);
		dataPane.setText("Tēnā Koe! Our game Tātai will teach you how to pronounce Māori numbers!");
		dataPane.appendText("\n");
		dataPane.appendText("\nFirstly, pick the level you want to play on: the Easy level will test you on numbers 1 to 9, and the Hard level will test you on numbers 1 to 99.");
		dataPane.appendText("\n\nAfter choosing your level, the game will display a number to you: try to pronounce it in Māori!");
		dataPane.appendText("\n\nIf you are right, you will get a point. After 10 questions, you will get your score, which you can view -with all your other session scores- on the Statistics option!");
		dataPane.appendText("\n\nAll the best, and Waimarie Pai! (Good Luck!)");
		dataPane.positionCaret(0);
		dataPane.setVisible(true);
	
	}
}
