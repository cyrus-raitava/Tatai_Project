package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MenuController {

	@FXML
	private Label myLabel;
	
	@FXML
	private Button logOutButton;
	
	@FXML
	public Button timataButton;
	
	@FXML
	private Button howToButton;
	
	@FXML
	private Button statsButton;
	
	@FXML
	private Button achievementsButton;
	
	@FXML
	private Button creditsButton;
	
	@FXML
	public ImageView menuUserStatus;
	
	@FXML
	public Label userStatus;
	
	@FXML
	public Label userLabel;
	
	@FXML
	public Label achieveNotify;
	
	public void achievementsPress(ActionEvent event) throws IOException {
		
		StorageAndSetUps.getInstance().mc.achieveNotify.setVisible(false);
		Scene achievements = StorageAndSetUps.getInstance().achievements;		
		Stage window = (Stage) achievementsButton.getScene().getWindow();
		window.setScene(achievements);
	}
	
	public void creditsPress(ActionEvent event) throws IOException {
		Scene credits = StorageAndSetUps.getInstance().credits;
		Stage window = (Stage) creditsButton.getScene().getWindow();
		window.setScene(credits);
	}
	
	/**Function that loads quit option as pop-up, to be utilized by the Quit button
	 * from the main menu. Note that the quit scene in itself is UNDECORATED.
	 * @param event
	 * @throws IOException
	 */
	public void logOutPress(ActionEvent event) throws IOException {
	
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LogoutPage.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        Scene scene = new Scene(root1);
        stage.setTitle("Log Out Page");
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
