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
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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

	@FXML
	private Button easyClear;
	
	public static String levelChosen;
	
	public static void changeDisplayMessage(boolean change) throws IOException {
		
		if (change) {
			StorageAndSetUps.getInstance().csc.displayLabel.setText("There are no");
			StorageAndSetUps.getInstance().csc.displayLabel1.setText("Statistics");
			StorageAndSetUps.getInstance().csc.ok.setVisible(true);
			StorageAndSetUps.getInstance().csc.warningLabel.setVisible(false);
			StorageAndSetUps.getInstance().csc.No.setVisible(false);
			StorageAndSetUps.getInstance().csc.Yes.setVisible(false);
		
		} else {
			StorageAndSetUps.getInstance().csc.displayLabel.setText("Are you sure you want to delete:");
			StorageAndSetUps.getInstance().csc.displayLabel1.setText("Statistics?");
			StorageAndSetUps.getInstance().csc.ok.setVisible(false);
			StorageAndSetUps.getInstance().csc.Yes.setVisible(true);
			StorageAndSetUps.getInstance().csc.No.setVisible(true);
			StorageAndSetUps.getInstance().csc.warningLabel.setVisible(true);
		}
		
	}
	
	public void easyClearPress(ActionEvent event) throws IOException {
		StatisticsController.levelChosen = "easy";
		
		if (StatisticsController.listEasy.isEmpty()) {
			StatisticsController.changeDisplayMessage(true);
			
		} else {
			StatisticsController.changeDisplayMessage(false);
		}
		
		StorageAndSetUps.getInstance().csc.levelLabel.setText("Easy");
		StorageAndSetUps.getInstance().csc.levelLabel.setTextFill(Paint.valueOf("#4dc313"));
		StorageAndSetUps.getInstance().csc.levelLabel.setFont(new Font("System", 49));
		
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        Scene scene = StorageAndSetUps.getInstance().clearStats;
        stage.setTitle("Clear Easy Statistics");
        stage.setScene(scene);  
        stage.setResizable(false);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
	}
	
	@FXML
	private Button mediumClear;
	
	public void mediumClearPress(ActionEvent event) throws IOException {
		StatisticsController.levelChosen = "medium";
		
		if (StatisticsController.listMedium.isEmpty()) {
			StatisticsController.changeDisplayMessage(true);
		} else {
			StatisticsController.changeDisplayMessage(false);
		}
		
		StorageAndSetUps.getInstance().csc.levelLabel.setText("Medium");
		StorageAndSetUps.getInstance().csc.levelLabel.setTextFill(Paint.valueOf("#ff8800"));
		StorageAndSetUps.getInstance().csc.levelLabel.setFont(new Font("System", 49));
		
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        Scene scene = StorageAndSetUps.getInstance().clearStats;
        stage.setTitle("Clear Medium Statistics");
        stage.setScene(scene);  
        stage.setResizable(false);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
	}
	
	@FXML
	private Button hardClear;
	
	public void hardClearPress(ActionEvent event) throws IOException {
		StatisticsController.levelChosen = "hard";
		
		if (StatisticsController.listHard.isEmpty()) {
			StatisticsController.changeDisplayMessage(true);
		} else {
			StatisticsController.changeDisplayMessage(false);
		}
		
		
		StorageAndSetUps.getInstance().csc.levelLabel.setText("Hard");
		StorageAndSetUps.getInstance().csc.levelLabel.setTextFill(Paint.valueOf("#0055ff"));
		StorageAndSetUps.getInstance().csc.levelLabel.setFont(new Font("System", 49));
		
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        Scene scene = StorageAndSetUps.getInstance().clearStats;
        stage.setTitle("Clear Hard Statistics");
        stage.setScene(scene);  
        stage.setResizable(false);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
	}
	
	
	
	
	// Initialize String ListViews, to be linked to ObservableLists, for the display of relevant Statistics.
	
	@FXML
	ListView<String> easyList = new ListView<String>();
	
	@FXML
	ListView<String> mediumList = new ListView<String>();
	
	@FXML
	ListView<String> hardList = new ListView<String>();

	public static ObservableList<String> listHard = FXCollections.observableArrayList();
	public static ObservableList<String> listMedium = FXCollections.observableArrayList();
	public static ObservableList<String> listEasy = FXCollections.observableArrayList();
	
	// Initialize the numbers of relevant sessions as zero, upon the beginning of the program.
	
	public static int easySession;
	public static int mediumSession;
	public static int hardSession;
	
	// Method to be invoked when sessionScore is to be added. When called, String will
	// be added to ListView, in the relevant format. This will then be visually updated
	// within the ListView, that is within the Statistics FXML.
	
	public void addSessionScore(int sessionScore, Level level) throws IOException {
		
		
		// Place constraints on range of input sessionScore (should not be greater than
		// or less than zero.
		
		if ((sessionScore < 0) || (sessionScore > 10)) {
			
		} else {
			// Determine if session is Hard or Easy: if the session is Hard, create String to add to the Hard ListView,
			// and consequently the Hard ObservableList.
			if (level == Level.HARD) {
				
				
				// Increment the hardSessions counter. 
				
				hardSession++;
				
				String sessionNum = "" + hardSession;
				
				// Format String to add to Hard ListView.
				
				String format = "Session " + sessionNum + ":\t" + sessionScore + "/10";
				
				listHard.add(format);
				
				// Alongside adding score to ArrayList<String>, append score to relevant text file,
				// to retain as a persistent statistic.
				
				PersistentStates.appendStat(sessionScore, level, UserLogin.username);
				
				
				
			} else if (level == Level.EASY){
				
				// If level chosen is Easy, then increment easySessions counter: similar to the formatting for the Hard ListView,
				// add the formatted String to the ListView, passing in the current session number as well as the SessionScore, before adding it.
				
				easySession++;
				
				String sessionNum = "" + easySession;
				
				String format = "Session " + sessionNum + ":\t" + sessionScore + "/10";
				
				listEasy.add(format);
				
				PersistentStates.appendStat(sessionScore, level, UserLogin.username);
				
			} else if (level == Level.MEDIUM) {
				// If level chosen is Easy, then increment easySessions counter: similar to the formatting for the Hard ListView,
				// add the formatted String to the ListView, passing in the current session number as well as the SessionScore, before adding it.
				
				mediumSession++;
				
				String sessionNum = "" + mediumSession;
				
				String format = "Session " + sessionNum + ":\t" + sessionScore + "/10";
				
				listMedium.add(format);
				
				PersistentStates.appendStat(sessionScore, level, UserLogin.username);
			}

		
		}
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		easyList.setItems(listEasy);
		mediumList.setItems(listMedium);
		hardList.setItems(listHard);
	}
}
