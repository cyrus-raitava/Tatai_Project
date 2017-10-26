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
		dataPane.setText("Tēnā Koe! Our game Tātai will teach you Math, and how to pronounce Māori numbers!");
		dataPane.appendText("\n");
		dataPane.appendText("\nYou can start on the Practise Level, and then progress through Easy, to Medium, and finally Hard.");
		dataPane.appendText("\n\nAfter choosing your level, the game will display an equation to you: try to pronounce the answer in Māori!");
		dataPane.appendText("\n\nIf you are right, you will get a point. After 10 questions, you will get your score, which you can view -with all your other session scores- on the Statistics option!");
		dataPane.appendText("\n\nYou can only unlock the Medium Level after you have gotten 8/10 or more in the Easy Level, and so on with the Hard Level.");
		dataPane.appendText("\n\nYour scores from previous sessions will stay recorded in the Statistics, unless you decide to clear them with the Clear buttons (under the Statistics page).");
		dataPane.appendText("\n\nYou can also earn achievements by answering more and more questions, and view all of them in the Achievements option");
		dataPane.appendText("\n\nAll the best, and Waimarie Pai! (Good Luck!)");
		dataPane.positionCaret(0);
		dataPane.setVisible(true);
	
	}
}
