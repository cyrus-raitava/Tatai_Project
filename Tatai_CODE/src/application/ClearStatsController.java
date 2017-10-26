package application;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import java.io.IOException;
import java.io.PrintWriter;

import javafx.event.ActionEvent;

import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * 
 * @author cyrus
 *
 */
public class ClearStatsController {
	
	/**
	 * Create necessary JavaFX controls, for appropriate functionality on the ClearStats Scene.
	 * This involves a 'Yes' or 'No' confirmation, and necessary Buttons/Button Functions etc.
	 */
	
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
	
	
	/**
	 * This method is only used when there are no statistics to delete: the scene displays a message
	 * saying there are no statistics within a given level to be able to delete, and the 'ok' button allows 
	 * the user to close the pop-up window, and get back to the Statistics scene.
	 * @param event
	 */
	@FXML
	public void okPressed(ActionEvent event) {
		Stage stage = (Stage) ok.getScene().getWindow();
		stage.close();
	}

	/**
	 * Similar to the okPressed() function, the NoPressed() function closes the pop-up warning window, created
	 * when the user has pressed the clear button, for a particular level's statistics.
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void NoPressed(ActionEvent event) throws IOException {
	
		// Closes window that No Button resides in
		Stage stage = (Stage) No.getScene().getWindow();
		stage.close();
	}
	
	/**
	 * This function clears takes as input the levelChosen variable, which in itself
	 * represents which level the user has chosen to clear Statistics of (either Easy,
	 * Medium or Hard Statistics). It then calls on the clearStats() method, that sucessfully 
	 * clears the User's Level's Statistics, both in text-file and in the corresponding ArrayList<String>.
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void YesPressed(ActionEvent event) throws IOException {
		
		// Accesses static variable 'StatisticsController.levelChosen', and passes that on to another function that clears that level's statistics
		String level = StatisticsController.levelChosen;
		clearStats(level);
		
		//Closes pop-up window that the Yes Button resides in.
		Stage stage = (Stage) Yes.getScene().getWindow();
		stage.close();
	}

	/**
	 * 
	 * clearStats() method takes in parameter string 'difficulty', and then clears
	 * the corresponding arrayList and text file, for that given difficulty level.
	 * 
	 * @param difficulty
	 * @throws IOException

	 */
	
	public void clearStats(String difficulty) throws IOException {
		
		// Gets current working directory
		
		String pwd = System.getProperty("user.dir");
		
		// Create object to use, to clear stats level's txt file
		PrintWriter pw;
		
		// Determines the value of the difficulty level input, and then performs the necessary
		// steps in clearing the statistics of the given level: clearing the associated text file completely,
		// , as well as clearing the corresponding ArrayList<String> related to the level.
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
