package application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class StatisticsController implements Initializable {

	/*
	 * Controller class for Statistics FXML scene. Return Button and returnPress()
	 * field/methods implemented to return back to menu screen.
	 * 
	 */
	
	@FXML
	private Button returnButton;
	
	public void returnPress(ActionEvent event) throws IOException {
		Scene menu = SceneStorage.getInstance().menu;
		Stage window = (Stage) returnButton.getScene().getWindow();
		window.setScene(menu);
	}
	
	
	
	@FXML
	ListView<String> easyList = new ListView<String>();
	
	@FXML
	ListView<String> hardList = new ListView<String>();

	public static ObservableList<String> listHard = FXCollections.observableArrayList();
	public static ObservableList<String> listEasy = FXCollections.observableArrayList();
	
	static int easySession = 0;
	static int hardSession = 0;
	
	// Method to be invoked when sessionScore is to be added. When called, String will
	// be added to ListView, in the relevant format. This will then be visually updated
	// within the ListView, that is within the Statistics FXML.
	
	public void addSessionScore(int sessionScore, boolean hard) {
		
		
		// Place constraints on range of input sessionScore (should not be greater than
		// or less than zero.
		
		if ((sessionScore < 0) || (sessionScore > 10)) {
			
		} else {
			
			if (hard) {
				hardSession++;
				
				String sessionNum = "" + hardSession;
				
				String format = "Session Number: " + sessionNum + "\t\t" + sessionScore + "/10";
				
				listHard.add(format);
			} else {
				easySession++;
				
				String sessionNum = "" + easySession;
				
				String format = "Session Number: " + sessionNum + "\t\t" + sessionScore + "/10";
				
				listEasy.add(format);
			}

		
		}
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		easyList.setItems(listEasy);
		hardList.setItems(listHard);
	}
}
