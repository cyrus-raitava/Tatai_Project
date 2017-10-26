package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class QuitPageController {
	 
	
	@FXML
	private Label displayLabel;
	
	@FXML
	private Label myLabel;
	
	@FXML
	private Button Yes;
	
	@FXML
	private Button No;
	
	
	/**'No' Button functionality: returns user to Main Menu if pressed.
	 * @param event
	 */
	@FXML
	public void NoPressed(ActionEvent event) {
		Stage stage = (Stage) No.getScene().getWindow();
		stage.close();
	}
	
	/**'Yes' Quit Button functionality: quits application with exit code of 0, if pressed.
	 * @param event
	 */
	@FXML
	public void YesPressed(ActionEvent event) {
		System.exit(0);
	}
	
}
