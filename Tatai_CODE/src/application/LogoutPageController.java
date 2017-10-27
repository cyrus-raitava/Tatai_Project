package application;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;

import javafx.event.ActionEvent;

import javafx.scene.control.Label;
import javafx.stage.Stage;

public class LogoutPageController {
	/**
	 * Create JavaFX controls for the LogOut Scene: the purpose of this scene is to
	 * allow the user to confirm whether or not they want to 
	 */
	@FXML
	private Label displayLabel;
	
	@FXML
	private Button No;
	
	@FXML
	private Button Yes;
	
	@FXML
	private Label myLabel;

	/**
	 * This is the functionality for the No Button of the LogOut Scene: it closes the pop-up
	 * confirmation window, bringing the user back to their main menu screen.
	 * 
	 * @param event
	 */
	@FXML
	public void NoPressed(ActionEvent event) {
		
		// Closes the window that holds the No Button.
		Stage stage = (Stage) No.getScene().getWindow();
		stage.close();
		
	}
	
	/**
	 * This is the functionality for the Yes Button of the LogOut Scene: it closes the pop-up
	 * confirmation window, and changes the scene behind it from the Menu Scene, to the UserLogin Scene.
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void YesPressed(ActionEvent event) throws IOException {
		
		// Disables the loginConfirm and deleteUser buttons, so that upon going back to the UserLogin Scene,
		// the user cannot login without selecting a user first from the Combo Box.

		StorageAndSetUps.getInstance().ulc.loginConfirm.setDisable(true);
		StorageAndSetUps.getInstance().ulc.deleteUser.setDisable(true);
		
		// Changes window back to the userLogin scene
		
		Scene userLogin = StorageAndSetUps.getInstance().userLogin;
		
		Stage window = (Stage) Yes.getScene().getWindow();
		window.close();
		
		window = (Stage) StorageAndSetUps.getInstance().mc.timataButton.getScene().getWindow();
		
		window.setScene(userLogin);
	}
}
