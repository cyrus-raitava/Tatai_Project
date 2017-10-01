package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MenuController {

	@FXML
	private Label myLabel;
	
	@FXML
	private Button quitButton;
	
	@FXML
	private Button timataButton;
	
	@FXML
	private Button howToButton;
	
	@FXML
	private Button statsButton;
	
	/**Function that loads quit option as pop-up, to be utilized by the Quit button
	 * from the main menu. Note that the quit scene in itself is UNDECORATED.
	 * @param event
	 * @throws IOException
	 */
	public void quitPress(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("QuitPage.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        Scene scene = new Scene(root1);
        stage.setTitle("Quit Page");
        stage.setScene(scene);  
        stage.setResizable(false);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
	}
	
	/**
	 * When timata is pressed, change scenes to level menu
	 * @param event
	 * @throws IOException
	 */
	public void timataPress(ActionEvent event) throws IOException {
		Scene levelMenu = StorageAndSetUps.getInstance().levelMenu;
		Stage window = (Stage) timataButton.getScene().getWindow();
		window.setScene(levelMenu);
	}
	
	
	/**
	 * When how to play button is pressed, switch to instructions scene.
	 * @param event
	 * @throws IOException
	 */
	public void howTo(ActionEvent event) throws IOException {
		Scene instructions = StorageAndSetUps.getInstance().instructions;
		Stage window = (Stage) timataButton.getScene().getWindow();
		window.setScene(instructions);
	}
	
	/**
	 * When stats button is pressed, switch to statistics scene.
	 * @param event
	 * @throws IOException
	 */
	public void statsPress(ActionEvent event) throws IOException {
		Scene statistics = StorageAndSetUps.getInstance().statistics;
		Stage window = (Stage) timataButton.getScene().getWindow();
		window.setScene(statistics);
	}
}
