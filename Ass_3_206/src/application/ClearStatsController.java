package application;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import java.io.IOException;
import java.io.PrintWriter;

import javafx.event.ActionEvent;

import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ClearStatsController {
	
	
	@FXML
	public Button No;
	
	@FXML
	public Button Yes;
	
	@FXML
	public Label levelLabel;
	
	@FXML
	public Label displayLabel;
	
	@FXML
	public Label displayLabel1;
	
	@FXML
	public Button ok;
	
	@FXML
	public Label warningLabel;
	
	@FXML
	public void okPressed(ActionEvent event) {
		Stage stage = (Stage) ok.getScene().getWindow();
		stage.close();
	}

	// Event Listener on Button[#No].onAction
	@FXML
	public void NoPressed(ActionEvent event) throws IOException {
	
		Stage stage = (Stage) No.getScene().getWindow();
		stage.close();
	}
	// Event Listener on Button[#Yes].onAction
	@FXML
	public void YesPressed(ActionEvent event) throws IOException {
		
		String level = StatisticsController.levelChosen;
		clearStats(level);
		
		Stage stage = (Stage) Yes.getScene().getWindow();
		stage.close();
	}

	/**
	 * 
	 * @param difficulty
	 * @throws IOException
	 * 
	 * clearStats() method takes in parameter string 'difficulty', and then clear
	 * the corresponding arrayList and text file, for that given difficulty level.
	 */
	
	public void clearStats(String difficulty) throws IOException {
		
		// Gets current working directory
		
		String pwd = System.getProperty("user.dir");
		
		PrintWriter pw;
		
		if (difficulty.equals("easy")) {
			
			pw = new PrintWriter(pwd + "/TataiResources/" + UserLogin.username + "easyStats.txt");
			pw.close();
			
			StorageAndSetUps.getInstance().sc.listEasy.clear();
		} else if (difficulty.equals("medium")) {
			
			pw = new PrintWriter(pwd + "/TataiResources/" + UserLogin.username + "mediumStats.txt");
			pw.close();
			
			StorageAndSetUps.getInstance().sc.listMedium.clear();
		} else if (difficulty.equals("hard")) {
			
			pw = new PrintWriter(pwd + "/TataiResources/" + UserLogin.username + "hardStats.txt");
			pw.close();
			StorageAndSetUps.getInstance().sc.listHard.clear();
			
		} else {
		}
	}
}
