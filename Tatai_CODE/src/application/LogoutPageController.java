package application;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;

import javafx.event.ActionEvent;

import javafx.scene.control.Label;
import javafx.stage.Stage;

public class LogoutPageController {
	
	@FXML
	private Label displayLabel;
	
	@FXML
	private Button No;
	
	@FXML
	private Button Yes;
	
	@FXML
	private Label myLabel;

	// Event Listener on Button[#No].onAction
	@FXML
	public void NoPressed(ActionEvent event) {
		
		Stage stage = (Stage) No.getScene().getWindow();
		stage.close();
		
	}
	
	// Event Listener on Button[#Yes].onAction
	@FXML
	public void YesPressed(ActionEvent event) throws IOException {

		StorageAndSetUps.getInstance().ulc.loginConfirm.setDisable(true);
		StorageAndSetUps.getInstance().ulc.deleteUser.setDisable(true);
		
		Scene userLogin = StorageAndSetUps.getInstance().userLogin;
		
		Stage window = (Stage) Yes.getScene().getWindow();
		window.close();
		
		window = (Stage) StorageAndSetUps.getInstance().mc.timataButton.getScene().getWindow();
		
		window.setScene(userLogin);
	}
}
