package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ComboBox;

public class UserLoginController implements Initializable {

	@FXML
	public Button quitButton;

	@FXML
	public Label myLabel;

	@FXML
	public ComboBox<String> userList = new ComboBox<String>();

	@FXML
	public Button loginExistingUser;

	@FXML
	public Button createNewUser;

	@FXML
	public Button loginConfirm;

	@FXML
	public Button goBack;

	@FXML
	public TextField userNameInput;

	@FXML
	public Button createUser;

	@FXML
	public Label warningLabel;

	@FXML
	public Button deleteUser;

	@FXML
	public void chooseUser(ActionEvent event) throws IOException {

		StorageAndSetUps.getInstance().ulc.loginConfirm.setDisable(false);
		StorageAndSetUps.getInstance().ulc.deleteUser.setDisable(false);
	}

	@FXML
	public void deleteUserPress(ActionEvent event) throws IOException {

		if (userList.getSelectionModel().isEmpty()) {
			StorageAndSetUps.getInstance().ulc.warningLabel.setAlignment(Pos.CENTER);
			StorageAndSetUps.getInstance().ulc.warningLabel.setText("Warning! Please select a user to delete.");
			StorageAndSetUps.getInstance().ulc.warningLabel.setVisible(true);

		} else {

			UserLogin.username = userList.getSelectionModel().getSelectedItem();

			StorageAndSetUps.getInstance().ulc.warningLabel.setVisible(false);

			StorageAndSetUps.getInstance().ulc.loginConfirm.setDisable(true);
			StorageAndSetUps.getInstance().ulc.deleteUser.setDisable(true);

			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			Scene scene = StorageAndSetUps.getInstance().deleteUser;
			StorageAndSetUps.getInstance().duc.nameLabel.setText(UserLogin.username);
			stage.setTitle("Delete User");
			stage.setScene(scene);  
			stage.setResizable(false);
			stage.initStyle(StageStyle.UNDECORATED);
			stage.show();
		}
	}

	@FXML
	public void createPress(ActionEvent event) {

		try {

			String proposedUser = StorageAndSetUps.getInstance().ulc.userNameInput.getText();

			if ((proposedUser.equals(null)) || (proposedUser.equals("")) || (UserLoginController.listUser.contains(proposedUser))) {

				StorageAndSetUps.getInstance().ulc.warningLabel.setText("Warning! You must enter a valid name. It cannot be a name you have already entered");
				StorageAndSetUps.getInstance().ulc.warningLabel.setWrapText(true);
				StorageAndSetUps.getInstance().ulc.warningLabel.setAlignment(Pos.CENTER);

				StorageAndSetUps.getInstance().ulc.warningLabel.setVisible(true);

			} else if (proposedUser.length() > 10) {

				StorageAndSetUps.getInstance().ulc.warningLabel.setText("Warning! Your username cannot be longer than 10 characters.");
				StorageAndSetUps.getInstance().ulc.warningLabel.setWrapText(true);
				StorageAndSetUps.getInstance().ulc.warningLabel.setAlignment(Pos.CENTER);

				StorageAndSetUps.getInstance().ulc.warningLabel.setVisible(true); 
			}  else {

				StorageAndSetUps.getInstance().ulc.warningLabel.setVisible(false);
				UserLogin.username = proposedUser;

				UserLogin.addUser(proposedUser);

				StorageAndSetUps.getInstance().ulc.loginExistingUser.setDisable(false);

				UserLogin.defaultScreen();
			}

			StorageAndSetUps.getInstance().ulc.userNameInput.setText("");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	public void goBackPress(ActionEvent event) throws IOException {
		UserLogin.defaultScreen();

	}


	// Event Listener on Button[#quitButton].onAction
	@FXML
	public void quitPress(ActionEvent event) throws IOException{
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

	// Event Listener on Button[#loginExistingUser].onAction
	@FXML
	public void loginExistingUserPress(ActionEvent event) throws IOException {

		StorageAndSetUps.getInstance().ulc.loginConfirm.setDisable(true);
		StorageAndSetUps.getInstance().ulc.deleteUser.setDisable(true);

		StorageAndSetUps.getInstance().ulc.userList.setVisible(true);
		StorageAndSetUps.getInstance().ulc.loginConfirm.setVisible(true);
		StorageAndSetUps.getInstance().ulc.loginExistingUser.setVisible(false);
		StorageAndSetUps.getInstance().ulc.createNewUser.setVisible(false);
		StorageAndSetUps.getInstance().ulc.quitButton.setVisible(false);
		StorageAndSetUps.getInstance().ulc.goBack.setVisible(true);
		StorageAndSetUps.getInstance().ulc.deleteUser.setVisible(true);

	}

	// Event Listener on Button[#createNewUser].onAction
	@FXML
	public void createNewUserPress(ActionEvent event) throws IOException {
		StorageAndSetUps.getInstance().ulc.loginExistingUser.setVisible(false);
		StorageAndSetUps.getInstance().ulc.userList.setVisible(false);
		StorageAndSetUps.getInstance().ulc.createNewUser.setVisible(false);
		StorageAndSetUps.getInstance().ulc.goBack.setVisible(true);
		StorageAndSetUps.getInstance().ulc.quitButton.setVisible(false);

		StorageAndSetUps.getInstance().ulc.userNameInput.setVisible(true);
		StorageAndSetUps.getInstance().ulc.createUser.setVisible(true);
	}


	// Event Listener on Button[#loginConfirm].onAction
	@FXML
	public void loginConfirmPress(ActionEvent event) throws IOException {

		if (userList.getSelectionModel().isEmpty()) {
			StorageAndSetUps.getInstance().ulc.warningLabel.setText("Warning! You must select a user before logging in.");
			StorageAndSetUps.getInstance().ulc.warningLabel.setVisible(true);
		} else {
			UserLogin.username = userList.getSelectionModel().getSelectedItem();
			StorageAndSetUps.getInstance().ulc.warningLabel.setVisible(false);
			userList.getSelectionModel().clearSelection();
		}

		UserLogin.createUserFiles(UserLogin.username);
		PersistentStates.setUps();


		StorageAndSetUps.getInstance().mc.userLabel.setText("Hi " + UserLogin.username + "!");
		Scene menu = StorageAndSetUps.getInstance().menu;		
		Stage window = (Stage) loginConfirm.getScene().getWindow();
		window.setScene(menu);


	}

	public static ObservableList<String> listUser = FXCollections.observableArrayList();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		userList.setItems(listUser);
	}



}
