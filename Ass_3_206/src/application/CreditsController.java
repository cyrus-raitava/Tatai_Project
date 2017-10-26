package application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.control.TextArea;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class CreditsController implements Initializable {
	@FXML
	private Label myLabel;
	
	@FXML
	private Button goBack;
	
	@FXML
	private TextArea creditsList = new TextArea();

	// Event Listener on Button[#goBack].onAction
	@FXML
	public void goBackPress(ActionEvent event) throws IOException{
		Scene menu = StorageAndSetUps.getInstance().menu;
		Stage window = (Stage) goBack.getScene().getWindow();
		window.setScene(menu);
	}
		
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		creditsList.setVisible(true);
		creditsList.setMaxWidth(540);
		creditsList.setEditable(false);
		creditsList.setWrapText(true);
		creditsList.setText("This game was designed/programmed by:\n\n");
		creditsList.appendText("CYRUS RAITAVA-KUMAR and TROY McLAREN\n\n");
		creditsList.appendText("Images used were supplied by:\n\n");
		creditsList.appendText("EMOTIKIS:\t\t\t© 2016 TE PUIA\n\n");
		creditsList.appendText("ACHIEVEMENT ICONS:\t© Noun Project Inc.\n\n");
		
		creditsList.appendText("The creators would like to thank the following key people, in the development of this application:\n\n");
		creditsList.appendText("\t-Nasser Giacaman and Catherine Watson\n");
		creditsList.appendText("\t-Our parents\n");
		creditsList.appendText("\t-The creators of Github\n\n");
		creditsList.appendText("Hope you enjoyed playing this game, almost as much as we enjoyed making it!");
		creditsList.setFont(Font.font("System", FontWeight.BOLD, 16));
		creditsList.positionCaret(0);
		creditsList.setVisible(true);
		creditsList.setMouseTransparent(false);
		creditsList.setFocusTraversable(false);
	
	}
}
