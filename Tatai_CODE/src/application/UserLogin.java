package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UserLogin {

	public static String username;

	/*
	 * Sets the layout of the scene that the user is presented when they first open the application.
	 */
	public static void startUp() {
		
		try {

			// appropriate buttons are set to invisible so only , create and
			// login with existing users are visible.
			StorageAndSetUps.getInstance().ulc.userList.setVisible(false);
			StorageAndSetUps.getInstance().ulc.loginConfirm.setVisible(false);
			StorageAndSetUps.getInstance().ulc.goBack.setVisible(false);
			StorageAndSetUps.getInstance().ulc.createUser.setVisible(false);
			StorageAndSetUps.getInstance().ulc.userNameInput.setVisible(false);
			StorageAndSetUps.getInstance().ulc.warningLabel.setVisible(false);
			StorageAndSetUps.getInstance().ulc.deleteUser.setVisible(false);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

	/*
	 * This method adds a user to the existing list of users.
	 * @param String username = name of new user
	 */
	public static void addUser(String username) {

		// Gets current working directory
		String pwd = System.getProperty("user.dir");

		BufferedWriter bw = null;
		FileWriter fw = null;

		try {

			// ensure new username does not already exist and add it
			if (!StorageAndSetUps.getInstance().ulc.listUser.contains(username)) {

				StorageAndSetUps.getInstance().ulc.listUser.add(username);

				File file = new File(pwd + "/TataiResources/userList.txt");

				fw = new FileWriter(file.getAbsoluteFile(), true);
				bw = new BufferedWriter(fw);

				String name = username + "\n";

				bw.write(name);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {

				if (bw != null) {
					bw.close();
				}

				if (fw != null) {
					fw.close();

				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}


	}

	/*
	 * Sets default visibilities of login buttons so that only create and existing user buttons are
	 * visible.
	 * @throws IOException
	 */
	public static void defaultScreen() throws IOException {
		StorageAndSetUps.getInstance().ulc.userList.setVisible(false);
		StorageAndSetUps.getInstance().ulc.loginConfirm.setVisible(false);
		StorageAndSetUps.getInstance().ulc.loginExistingUser.setVisible(true);
		StorageAndSetUps.getInstance().ulc.createNewUser.setVisible(true);
		StorageAndSetUps.getInstance().ulc.goBack.setVisible(false);
		StorageAndSetUps.getInstance().ulc.quitButton.setVisible(true);
		StorageAndSetUps.getInstance().ulc.userNameInput.setVisible(false);
		StorageAndSetUps.getInstance().ulc.createUser.setVisible(false);
		StorageAndSetUps.getInstance().ulc.userNameInput.setText("");
		StorageAndSetUps.getInstance().ulc.warningLabel.setVisible(false);
		StorageAndSetUps.getInstance().ulc.deleteUser.setVisible(false);
		StorageAndSetUps.getInstance().ulc.userList.getSelectionModel().clearSelection();
		
	}

	/*
	 * Creates files to store user progress for session scores and stage unlock.
	 * @param String username = name of user
	 * @throws IOException
	 */
	public static void createUserFiles(String username) throws IOException {
		
		// Gets current working directory
		String pwd = System.getProperty("user.dir");
		
		// Create files for all stats and levelUnlock
		File fileEasy = new File(pwd + "/TataiResources/" + username + "easyStats.txt");
		File fileMedium = new File(pwd + "/TataiResources/" + username + "mediumStats.txt");
		File fileHard = new File(pwd + "/TataiResources/" + username + "hardStats.txt");
		File fileLevels = new File(pwd + "/TataiResources/" + username + "persistentLevels.txt");
		
		// Ensure new files are created only if they do not already exist
		if(!fileEasy.exists()) {
			fileEasy.createNewFile();
		}

		if(!fileMedium.exists()) {
			fileMedium.createNewFile();
		}

		if(!fileHard.exists()) {
			fileHard.createNewFile();
		}
		
		if(!fileLevels.exists()) {
			fileLevels.createNewFile();
		}
		
	}
	
	/*
	 * Loads the list of users so they appear in the user dropdown box.
	 * @throws IOException
	 */
	public static void loadUsers() throws IOException {

		// Gets current working directory
		String pwd = System.getProperty("user.dir");

		// Create user list file if it does not already exist.
		File fileUserList = new File(pwd + "/TataiResources/userList.txt");
		if (!fileUserList.exists()) {
			fileUserList.createNewFile();
		}

		try {

			Scanner s = new Scanner(fileUserList);

			String user;

			// read in users from file
			while (s.hasNextLine()) {

				user = s.nextLine();

				// add user to list of users
				UserLoginController.listUser.add(user);

			}

			s.close();

			// if the list is empty, disable the login button.
			if (UserLoginController.listUser.isEmpty()) {
				StorageAndSetUps.getInstance().ulc.loginExistingUser.setDisable(true);
			}


		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}

	}



}


