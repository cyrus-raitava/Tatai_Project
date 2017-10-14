package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CustomController {

	@FXML 
	Button advanced;
	
	@FXML 
	Button levelMenuButton;
	
	@FXML 
	CheckBox checkBoxTimes;
	@FXML 
	CheckBox checkBoxDiv;
	@FXML 
	CheckBox checkBoxPlus;
	@FXML 
	CheckBox checkBoxMinus;
	
	
	/**
	 * Pop up window is displayed for advanced custom settings. Nothing can be done on this 
	 * scene when this other window is open.
	 * @param event
	 * @throws IOException
	 */
	public void advancedPress(ActionEvent event) throws IOException {
		Scene scene = StorageAndSetUps.getInstance().advanced;
		Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Advanced Settings");
        stage.setScene(scene);  
        stage.setResizable(false);
        stage.show();
	}
	
	/**
	 * Switch scene to the level menu.
	 * @param event
	 * @throws IOException
	 */
	public void levelMenuPress(ActionEvent event) throws IOException {
		Scene levelMenu = StorageAndSetUps.getInstance().levelMenu;
		Stage window = (Stage)levelMenuButton.getScene().getWindow();
		window.setScene(levelMenu);
	}
}
