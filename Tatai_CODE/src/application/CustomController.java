package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CustomController {

	@FXML 
	Button advanced;
	
	@FXML 
	Label warning;
	
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
	 * When a checkbox is pressed display a warning message if all are unchecked or else do not.
	 * @param event
	 * @throws IOException
	 */
	public void checkBox(ActionEvent event) throws IOException {
		boolean div = !checkBoxDiv.isSelected();
		boolean times = !checkBoxTimes.isSelected();
		boolean plus = !checkBoxPlus.isSelected();
		boolean minus = !checkBoxMinus.isSelected();
		
		if (div && times && plus && minus) {
			warning.setVisible(true);
		} else {
			warning.setVisible(false);
		}
	}
	
	
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
