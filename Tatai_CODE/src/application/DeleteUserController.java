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
	
	/**
	 * This controller is for the DeleteUser scene, which is shown when the user
	 * selects a user from the UserLogin scene, and decides to try and delete it. This
	 * scene provides a safe option to deleting a user, prompting whoever is trying to delete the user,
	 * and double-checking whether they truly want to delete that user.
	 */
	
	@FXML
	private Label displayLabel;
	
	@FXML
	private Button No;
	
	@FXML
	private Button Yes;
	
	@FXML
	public Label nameLabel;

	/**
	 * This function returns the user to the UserLogin scene, upon choosing to NOT
	 * delete the user they selected. As implied, it is called when the 'No' Button is pressed.
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void NoPressed(ActionEvent event) throws IOException {
		
		// Grabs the scene from which the 'No' button is in, and closes it
		Stage stage = (Stage) No.getScene().getWindow();
		stage.close();
		
		// Resets the selection within the combobox, on the userLogin scene.
		StorageAndSetUps.getInstance().ulc.userList.getSelectionModel().clearSelection();
		
		// Sets the loginConfirm Button and deleteUser button as disabled, as they
		// can and only should be enabled, upon a selection being made, from within the userList combobox. 
		StorageAndSetUps.getInstance().ulc.loginConfirm.setDisable(true);
		StorageAndSetUps.getInstance().ulc.deleteUser.setDisable(true);
	}
	
	/**
	 * Alternatively, the Yes() function provides the functionality behind deleting the user, its
	 * subsequently generated files (e.g all of the easy/medium/hard .txt files, alongside the user's individual
	 * PersistentLevels.txt file.
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void YesPressed(ActionEvent event) throws IOException {
		
		// Firstly removes the user's name from the listUser ArrayList<String>, so
		// that it cannot be viewed in the UserLogin's Combo Box, straight away.
		StorageAndSetUps.getInstance().ulc.listUser.remove(UserLogin.username);
		
		// Gets current working directory
		String pwd = System.getProperty("user.dir");

		// In order to delete the chosen user's name persistently, it must also be 
		// deleted from the generated text file, called "userList.txt". Here,
		// the implementation has been to copy all of the names that AREN'T the chosen user
		// to a new, temporary .txt file. This has then been followed by deleting the original file,
		// and renaming the new one to reflect the name of the original.
		File inputFile = new File(pwd + "/TataiResources/userList.txt");
		File tempFile = new File(pwd + "/TataiResources/myTempFile.txt");

		// Assign and declare the reader for the input file, and the writer for the temp output file.
		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

		// Initialize the string representing the user chosen, to delete
		String userToDelete = UserLogin.username;
		String currentLine;

		// Create while loop that goes through all the lines in userList.txt, as long as the line
		// being read is NOT null
		while((currentLine = reader.readLine()) != null) {
			
		    // trim newline when comparing with userToDelete
		    String trimmedLine = currentLine.trim();
		    
		    
		    if(trimmedLine.equals(userToDelete)) continue;
		    writer.write(currentLine + System.getProperty("line.separator"));
		}
		
		// Close the respective writer and reader
		
		writer.close(); 
		reader.close(); 
		
		// Rename temp file as original filename
		
		boolean successful = tempFile.renameTo(inputFile);
		
		// Delete relevant text files, to user chosen.
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
	
		// Re-disable the loginConfirm and deleteUser buttons, to only be re-enabled upon
		// a subsequent selection within the userList Combo Box that holds the list of users, being made.
		
		StorageAndSetUps.getInstance().ulc.loginConfirm.setDisable(true);
		StorageAndSetUps.getInstance().ulc.deleteUser.setDisable(true);
		
		
		// Conclude all of this by closing  the pop-up window itself, bringing them back to the originak
		// userLogin screen.
		Stage stage = (Stage) Yes.getScene().getWindow();
		stage.close();
	}
}
