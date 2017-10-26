package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UserLogin {

	public static String username;

	public static void startUp() {
		
		try {

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
	

	public static void addUser(String username) {

		// Gets current working directory
		String pwd = System.getProperty("user.dir");

		BufferedWriter bw = null;
		FileWriter fw = null;

		try {

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

	public static void createUserFiles(String username) throws IOException {
		
		// Gets current working directory
		String pwd = System.getProperty("user.dir");
		
		File fileEasy = new File(pwd + "/TataiResources/" + username + "easyStats.txt");

		File fileMedium = new File(pwd + "/TataiResources/" + username + "mediumStats.txt");

		File fileHard = new File(pwd + "/TataiResources/" + username + "hardStats.txt");
		
		File fileLevels = new File(pwd + "/TataiResources/" + username + "persistentLevels.txt");
		
		
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
	
	public static void loadUsers() throws IOException {

		// Gets current working directory
		String pwd = System.getProperty("user.dir");

		File fileUserList = new File(pwd + "/TataiResources/userList.txt");
		
		if (!fileUserList.exists()) {
			fileUserList.createNewFile();
		}

		try {

			Scanner s = new Scanner(fileUserList);

			String user;

			while (s.hasNextLine()) {

				user = s.nextLine();

				UserLoginController.listUser.add(user);

			}

			s.close();

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


