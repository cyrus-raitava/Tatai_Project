package application;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javafx.event.ActionEvent;

import javafx.scene.control.Label;
import javafx.stage.Stage;

public class DeleteUserController {
	
	@FXML
	private Label displayLabel;
	
	@FXML
	private Button No;
	
	@FXML
	private Button Yes;
	
	@FXML
	public Label nameLabel;

	// Event Listener on Button[#No].onAction
	@FXML
	public void NoPressed(ActionEvent event) throws IOException {
		Stage stage = (Stage) No.getScene().getWindow();
		stage.close();
		StorageAndSetUps.getInstance().ulc.userList.getSelectionModel().clearSelection();
		
		StorageAndSetUps.getInstance().ulc.loginConfirm.setDisable(true);
		StorageAndSetUps.getInstance().ulc.deleteUser.setDisable(true);
	}
	// Event Listener on Button[#Yes].onAction
	@FXML
	public void YesPressed(ActionEvent event) throws IOException {
		
		StorageAndSetUps.getInstance().ulc.listUser.remove(UserLogin.username);
		
		// Gets current working directory
		String pwd = System.getProperty("user.dir");

		File inputFile = new File(pwd + "/TataiResources/userList.txt");
		
		File tempFile = new File(pwd + "/TataiResources/myTempFile.txt");

		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

		String lineToRemove = UserLogin.username;
		String currentLine;

		while((currentLine = reader.readLine()) != null) {
		    // trim newline when comparing with lineToRemove
		    String trimmedLine = currentLine.trim();
		    if(trimmedLine.equals(lineToRemove)) continue;
		    writer.write(currentLine + System.getProperty("line.separator"));
		}
		writer.close(); 
		reader.close(); 
		boolean successful = tempFile.renameTo(inputFile);
		
		
		File fileEasy = new File(pwd + "/TataiResources/" + UserLogin.username + "easyStats.txt");

		File fileMedium = new File(pwd + "/TataiResources/" + UserLogin.username + "mediumStats.txt");

		File fileHard = new File(pwd + "/TataiResources/" + UserLogin.username + "hardStats.txt");
		
		File fileLevels = new File(pwd + "/TataiResources/" + UserLogin.username + "persistentLevels.txt");
		
		if (fileEasy.exists()) {
			fileEasy.delete();
		}
		
		if (fileMedium.exists()) {
			fileMedium.delete();
		}
		
		if (fileHard.exists()) {
			fileHard.delete();
		}
		
		if (fileLevels.exists()) {
			fileLevels.delete();
		}
	
		StorageAndSetUps.getInstance().ulc.loginConfirm.setDisable(true);
		StorageAndSetUps.getInstance().ulc.deleteUser.setDisable(true);
		
		Stage stage = (Stage) Yes.getScene().getWindow();
		stage.close();
	}
}
