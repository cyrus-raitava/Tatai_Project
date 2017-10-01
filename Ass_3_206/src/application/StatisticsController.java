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
		Scene menu = StorageAndSetUps.getInstance().menu;
		Stage window = (Stage) returnButton.getScene().getWindow();
		window.setScene(menu);
	}
	
	
	// Initialize String ListViews, to be linked to ObservableLists, for the display of relevant Statistics.
	
	@FXML
	ListView<String> easyList = new ListView<String>();
	
	@FXML
	ListView<String> hardList = new ListView<String>();

	public static ObservableList<String> listHard = FXCollections.observableArrayList();
	public static ObservableList<String> listEasy = FXCollections.observableArrayList();
	
	// Initialize the numbers of relevant sessions as zero, upon the beginning of the program.
	
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
			// Determine if session is Hard or Easy: if the session is Hard, create String to add to the Hard ListView,
			// and consequently the Hard ObservableList.
			if (hard) {
				
				// Increment the hardSessions counter. 
				
				hardSession++;
				
				String sessionNum = "" + hardSession;
				
				// Format String to add to Hard ListView.
				
				String format = "Session " + sessionNum + "\t\t" + sessionScore + "/10";
				
				listHard.add(format);
			} else {
				
				// If level chosen is Easy, then increment easySessions counter: similar to the formatting for the Hard ListView,
				// add the formatted String to the ListView, passing in the current session number as well as the SessionScore, before adding it.
				
				easySession++;
				
				String sessionNum = "" + easySession;
				
				String format = "Session " + sessionNum + "\t\t" + sessionScore + "/10";
				
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
