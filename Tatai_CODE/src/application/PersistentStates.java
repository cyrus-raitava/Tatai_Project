package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javafx.geometry.Pos;
import javafx.scene.image.Image;

public class PersistentStates {
	
	
	/**
	 * Method to be called for aiding in the set-up of a user's achievements, statistics
	 * and unlocked stages, as they login to the application.
	 * @throws IOException
	 */
	public static void setUps() throws IOException {
		
		PersistentStates.createStartFile();
		PersistentStates.loadStats(UserLogin.username);
		PersistentStates.defaultAchievements();
		PersistentStates.stageUnlockSet(UserLogin.username);
		PersistentStates.achievementsLoad(UserLogin.username);	
		
		
	}
	
	
	/**
	 * Method that sets the look-and-feel of the Achievement Icons in their
	 * default state: to be called prior to the achievements being loaded on.
	 * @throws IOException
	 */
	public static void defaultAchievements() throws IOException {
		
		StorageAndSetUps.getInstance().achc.arrowIcon.setOpacity(0.3);
		StorageAndSetUps.getInstance().achc.scholarIcon.setOpacity(0.3);
		StorageAndSetUps.getInstance().achc.scrollIcon.setOpacity(0.3);
		StorageAndSetUps.getInstance().achc.starIcon.setOpacity(0.3);
		StorageAndSetUps.getInstance().achc.streakIcon.setOpacity(0.3);
		StorageAndSetUps.getInstance().achc.wreathIcon.setOpacity(0.3);
			
		StorageAndSetUps.getInstance().achc.arrowIcon.setImage(new Image("/images/U_ACCURATE.png", true));
		StorageAndSetUps.getInstance().achc.arrowText.setText("LOCKED");
		StorageAndSetUps.getInstance().achc.arrowText.setVisible(true);
		StorageAndSetUps.getInstance().achc.arrowText.setWrapText(true);
		StorageAndSetUps.getInstance().achc.arrowText.setAlignment(Pos.CENTER);
		
		StorageAndSetUps.getInstance().achc.scholarIcon.setImage(new Image("/images/U_STUDENT.png", true));
		StorageAndSetUps.getInstance().achc.scholarText.setText("LOCKED");
		StorageAndSetUps.getInstance().achc.scholarText.setVisible(true);
		StorageAndSetUps.getInstance().achc.scholarText.setWrapText(true);
		StorageAndSetUps.getInstance().achc.scholarText.setAlignment(Pos.CENTER);
		
		StorageAndSetUps.getInstance().achc.scrollIcon.setImage(new Image("/images/U_SCROLL.png", true));
		StorageAndSetUps.getInstance().achc.scrollText.setText("LOCKED");
		StorageAndSetUps.getInstance().achc.scrollText.setVisible(true);
		StorageAndSetUps.getInstance().achc.scrollText.setWrapText(true);
		StorageAndSetUps.getInstance().achc.scrollText.setAlignment(Pos.CENTER);
		
		StorageAndSetUps.getInstance().achc.starIcon.setImage(new Image("/images/U_STAR.png", true));
		StorageAndSetUps.getInstance().achc.starText.setText("LOCKED");
		StorageAndSetUps.getInstance().achc.starText.setVisible(true);
		StorageAndSetUps.getInstance().achc.starText.setWrapText(true);
		StorageAndSetUps.getInstance().achc.starText.setAlignment(Pos.CENTER);
		
		StorageAndSetUps.getInstance().achc.streakIcon.setImage(new Image("/images/U_RISING.png", true));
		StorageAndSetUps.getInstance().achc.streakText.setText("LOCKED");
		StorageAndSetUps.getInstance().achc.streakText.setVisible(true);
		StorageAndSetUps.getInstance().achc.streakText.setWrapText(true);
		StorageAndSetUps.getInstance().achc.streakText.setAlignment(Pos.CENTER);
		
		StorageAndSetUps.getInstance().achc.wreathIcon.setImage(new Image("/images/U_WREATH.png", true));
		StorageAndSetUps.getInstance().achc.wreathText.setText("LOCKED");
		StorageAndSetUps.getInstance().achc.wreathText.setVisible(true);
		StorageAndSetUps.getInstance().achc.wreathText.setWrapText(true);
		StorageAndSetUps.getInstance().achc.wreathText.setAlignment(Pos.CENTER);
		
		
		StorageAndSetUps.getInstance().mc.menuUserStatus.setImage(new Image("/images/U_WREATH.png", true));
		StorageAndSetUps.getInstance().mc.menuUserStatus.setOpacity(0.3);
		StorageAndSetUps.getInstance().mc.userStatus.setText("");
		StorageAndSetUps.getInstance().mc.userStatus.setVisible(false);
		StorageAndSetUps.getInstance().mc.userStatus.setAlignment(Pos.CENTER);
		
		
		
	}
	
	/**
	 * This method creates the necessary resource folder, and checks to see if
	 * a file called 'userList.txt' is in that folder, and if neither exist then it 
	 * will create both.
	 * 
	 * @throws IOException
	 */
	public static void createStartFile() throws IOException {

		// Gets current working directory
		String pwd = System.getProperty("user.dir");

		// Create new file variables, for the resources directory and userList.txt file
		File resource = new File(pwd + "/TataiResources");
		File fileUserList = new File(pwd + "/TataiResources/userList.txt");
		
		
		// Checks if either folder exists, and if not then creates them
		if(!resource.exists()) {
			resource.mkdir();
		}
		
		if (!fileUserList.exists()) {
			fileUserList.createNewFile();
		}


	}
	
	

	/**
	 * This method takes a String input representing the user's Username, and
	 * loads their corresponding Statistics into the application, so that the user can view
	 * them upon logging in.
	 * 
	 * @param username
	 * @throws IOException
	 */
	public static void loadStats(String username) throws IOException {

		// Gets current working directory
		String pwd = System.getProperty("user.dir");

		// Create file variables, specific to the user's user name 
		File fileEasy = new File(pwd + "/TataiResources/" + username + "easyStats.txt");

		File fileMedium = new File(pwd + "/TataiResources/" + username + "mediumStats.txt");

		File fileHard = new File(pwd + "/TataiResources/" + username + "hardStats.txt");
		
		// Clear whatever is currently in the Observable Lists, as every time they login the Statistics
		// should not be appended onto whatever is already there
		StatisticsController.listEasy.clear();
		StatisticsController.listMedium.clear();
		StatisticsController.listHard.clear();
		
		try {

			// Create scanner to go through the user's Easy Statistics text file
			Scanner sE = new Scanner(fileEasy);

			String score, format;

			int easySessionNum = 0;

			// Use scanner to go through the file, reading each subsequent number character, converting it to 
			// a desired format, and then adding it to the releavnt Observable List in the application.
			while (sE.hasNextLine()) {
				easySessionNum++;
				score = sE.nextLine();
				format = "Session " + easySessionNum + ":\t" + score + "/10";
				StorageAndSetUps.getInstance().sc.listEasy.add(format);

				StorageAndSetUps.getInstance().sc.easySession = easySessionNum;
			}

			sE.close();

			// Create scanner to go through the user's Medium Statistics text file
			Scanner sM = new Scanner(fileMedium);

			int mediumSessionNum = 0;

			// Use scanner to go through the file, reading each subsequent number character, converting it to 
			// a desired format, and then adding it to the relevant Observable List in the application.
			while (sM.hasNextLine()) {
				mediumSessionNum++;
				score = sM.nextLine();
				format = "Session " + mediumSessionNum + ":\t" + score + "/10";
	
				StorageAndSetUps.getInstance().sc.listMedium.add(format);

				StorageAndSetUps.getInstance().sc.mediumSession = mediumSessionNum;
			}

			sM.close();

			// Create scanner to go through the user's Medium Statistics text file
			Scanner sH = new Scanner(fileHard);

			int hardSessionNum = 0;

			// Use scanner to go through the file, reading each subsequent number character, converting it to 
			// a desired format, and then adding it to the relevant Observable List in the application.
			while (sH.hasNextLine()) {
				hardSessionNum++;
				score = sH.nextLine();
				format = "Session " + hardSessionNum + ":\t" + score + "/10";
				StorageAndSetUps.getInstance().sc.listHard.add(format);
				StorageAndSetUps.getInstance().sc.hardSession = hardSessionNum;
			}

			sH.close();

		} finally {

		}

	}

	/**
	 * This function is used to write to a user's specific statistics text file after they have finished a session
	 * within the game: it takes as input the sessionsScore, the level of which the user was on, and the user's username.
	 * It then appends whatever that score was- in string form- at the end of the specific user's, particular text file.
	 * @param sessionScore
	 * @param level
	 * @param username
	 * @throws IOException
	 */
	public static void appendStat(int sessionScore, Level level, String username) throws IOException {

		BufferedWriter bw = null;
		FileWriter fw = null;

		try {

			// Gets current working directory
			String pwd = System.getProperty("user.dir");

			File file;

			// Creates file object, depending on the difficulty the user completed the session on
			if (level == Level.HARD) {
				file = new File(pwd + "/TataiResources/" + username + "hardStats.txt");
			} else if (level == Level.EASY){
				file = new File(pwd + "/TataiResources/" + username + "easyStats.txt");
			} else  {
				file = new File(pwd + "/TataiResources/" + username + "mediumStats.txt");
			}

			fw = new FileWriter(file.getAbsoluteFile(), true);
			bw = new BufferedWriter(fw);

			// Formats the score as a String
			String score = sessionScore + "\n";

			// Writes the score to the file
			bw.write(score);

		} finally {

			try {

				// Closes the writer objects, after having used them
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
	
	
	/**
	 * This method loads up the Achievements a particular user may or may not have unlocked, and is mostly called
	 * only as they login to their own username. This ensures individual users can access their individual achievements,
	 * outside of each other's.
	 * @param username
	 * @throws IOException
	 */
	public static void achievementsLoad(String username) throws IOException {
		
		// Gets current working directory
		String pwd = System.getProperty("user.dir");
		
		
		// Create necessary file objects (with the files themselves already existing)
		
		File fileEasy = new File(pwd + "/TataiResources/" + username + "easyStats.txt");

		File fileMedium = new File(pwd + "/TataiResources/" + username + "mediumStats.txt");

		File fileHard = new File(pwd + "/TataiResources/" + username + "hardStats.txt");
		
		// Call the accuracyUnlock() method on all of their statistics
		accuracyUnlock(fileEasy);
		accuracyUnlock(fileMedium);
		accuracyUnlock(fileHard);
		
		// Call the streakUnlock() method on all of their statistics
		streakUnlock(fileEasy);
		streakUnlock(fileMedium);
		streakUnlock(fileHard);
		
		// Initialize the number of correct questions as zero, everytime the method is called
		PersistentStates.correctNumber = 0;
		
		// Call the correctUnlock() method on all of their statistics
		correctUnlock(fileEasy, 50);
		correctUnlock(fileMedium, 50);
		correctUnlock(fileHard, 50);
		
		// Re-initialize the number of correct questions as zero, everytime the method is called
		PersistentStates.correctNumber = 0;
		
		// Call the correctUnlock() method on all of their statistics
		correctUnlock(fileEasy, 100);
		correctUnlock(fileMedium, 100);
		correctUnlock(fileHard, 100);
		
		// Initialize the number of total answered questions as zero, everytime the method is called
		PersistentStates.totalAnswered = 0;
		
		// Call the wreathUnlock() method on all of their statistics
		wreathUnlock(fileEasy);
		wreathUnlock(fileMedium);
		wreathUnlock(fileHard);

	}
	
	/**
	 * This method specifically checks a given file, to see if it contains statistics that unlocks
	 * the accuracy Achievement (if the file contains a score of 10)
	 * @param file
	 * @throws IOException
	 */
	public static void accuracyUnlock(File file) throws IOException {
		
		Scanner s = new Scanner(file);
		
		int sessionNum = 0;
		int score;
		
		// Uses the scanner object to check through each subsequent score within the file
		while (s.hasNextLine()) {
			sessionNum++;
			score = (Integer.parseInt(s.nextLine()));
			
			// Will only 'unlock' the achievement, if one of the scores is 10
			if (score == 10) {
				StorageAndSetUps.getInstance().achc.arrowIcon.setOpacity(1.0);
				StorageAndSetUps.getInstance().achc.arrowIcon.setMouseTransparent(true);
				StorageAndSetUps.getInstance().achc.arrowIcon.setImage(new Image("/images/C_ACCURACY.png", true));
				StorageAndSetUps.getInstance().achc.arrowText.setText("10/10 in at least one session");
				StorageAndSetUps.getInstance().achc.arrowText.setAlignment(Pos.CENTER);
				return;
			}
			
		}
	}
	
	
	/**
	 * This method specifically checks a given file, to see if it contains statistics that unlocks
	 * the streak Achievement (if the file contains 3 consecutive sessions of 10)
	 * @param file
	 * @throws IOException
	 */
	public static void streakUnlock(File file) throws IOException {
		
		Scanner s = new Scanner(file);
		
		int sessionNum = 0;
		int score;
		
		int streak = 0;
		
		// Uses scanner instance, to go through file, checking for any set of consecutive scores of 10
		while (s.hasNextLine()) {
			sessionNum++;
			score = (Integer.parseInt(s.nextLine()));
			
			if (score != 10) {
				streak = 0;
			} else {
				streak++;
			}
			
			// 'Unlocks' Streak achievement, if constraints are met
			if (streak == 3) {
				StorageAndSetUps.getInstance().achc.streakIcon.setOpacity(1.0);
				StorageAndSetUps.getInstance().achc.streakIcon.setMouseTransparent(true);
				StorageAndSetUps.getInstance().achc.streakIcon.setImage(new Image("/images/C_RISING.png", true));
				StorageAndSetUps.getInstance().achc.streakText.setText("10/10 in at least 3 consecutive sessions");
				StorageAndSetUps.getInstance().achc.streakText.setAlignment(Pos.CENTER);
				StorageAndSetUps.getInstance().achc.streakText.setWrapText(true);

			}
		}
	}
	
	// Variable that allows continual summation of the number of questions answered correctly
	public static int correctNumber;
	
	/**
	 * This method specifically checks a given file, to see if it contains statistics that unlocks
	 * the correct Achievements (if the file contains a summed number of correct answers, that are
	 * either 50 or 100 questions).
	 * @param file
	 * @throws IOException
	 */
	public static void correctUnlock(File file, int limit) throws IOException {
		
		Scanner s = new Scanner(file);
		
		String score;
		
		int add;
		
		// Uses scanner instance to go through file, summing the number of questions answered 
		// correctly, and continually checking if this summed value is either above 50,
		// or above 100
		while (s.hasNextLine()) {
			score = s.nextLine();
			
			add = (Integer.parseInt(score));
			
			PersistentStates.correctNumber += add;
			
			if (PersistentStates.correctNumber >= limit) {
				
				StorageAndSetUps.getInstance().achc.scrollIcon.setOpacity(1.0);
				
				switch (limit) {
				case 50:
					
					// if the input limit is 50, it will unlock the scroll Icon
					StorageAndSetUps.getInstance().achc.scrollIcon.setOpacity(1.0);
					StorageAndSetUps.getInstance().achc.scrollIcon.setMouseTransparent(true);
					StorageAndSetUps.getInstance().achc.scrollIcon.setImage(new Image("/images/C_SCROLL.png", true));
					StorageAndSetUps.getInstance().achc.scrollText.setText("At least " + limit + " questions correct, total");
					StorageAndSetUps.getInstance().achc.scrollText.setAlignment(Pos.CENTER);
					break;
				case 100:
					
					//if the input limit is 100, it will unlock the scholar icon
					StorageAndSetUps.getInstance().achc.scholarIcon.setOpacity(1.0);
					StorageAndSetUps.getInstance().achc.scholarIcon.setMouseTransparent(true);
					StorageAndSetUps.getInstance().achc.scholarIcon.setImage(new Image("/images/C_STUDENT.png", true));
					StorageAndSetUps.getInstance().achc.scholarText.setText("At least " + limit + " questions correct, total");
					StorageAndSetUps.getInstance().achc.scholarText.setAlignment(Pos.CENTER);
					break;
				}
				
			}
			
			
		}
		
		
	}
	
	// Variable to help keep track of the total number of questions answered.
	public static int totalAnswered;
	
	/**
	 * Method that helps continually check the number of total questions the user has answered. If they
	 * answer:
	 * -20 or more questions they get the Bronze Badge
	 * -50 or more questions they get the Silver Badge
	 * -100 or more questions they get the Gold Badge
	 * -250 or more questions they get the Platinum Badge
	 * -500 or more questions, they get the Diamond Badge
	 * 
	 * Note also that the user's main screen badge updated, as they progress through the stages, in answering
	 * questions.
	 * 
	 * @param file
	 * @throws IOException
	 */
	public static void wreathUnlock(File file) throws IOException {
		
		Scanner s = new Scanner(file);
		
		String score;
		
		int session = 0;
		
		// Use scanner instance to go through, summing up the number
		// of questions answered as 10*(however many scores exist in the user's statistics files),
		// as for every session the user has played, 
		while (s.hasNextLine()) {
			score = s.nextLine();
			session++;
		}
		
		PersistentStates.totalAnswered += session*10;
		
		if ((PersistentStates.totalAnswered >= 20) && (PersistentStates.totalAnswered < 50)) {
			StorageAndSetUps.getInstance().achc.wreathIcon.setImage(new Image("/images/BRONZE_WREATH.png", true));
			StorageAndSetUps.getInstance().achc.wreathIcon.setMouseTransparent(true);
			StorageAndSetUps.getInstance().achc.wreathText.setText("Answered at least 20 questions total.");
			StorageAndSetUps.getInstance().achc.wreathText.setAlignment(Pos.CENTER);
			StorageAndSetUps.getInstance().achc.wreathIcon.setOpacity(1.0);
			
			StorageAndSetUps.getInstance().mc.menuUserStatus.setImage(new Image("/images/BRONZE_WREATH.png", true));
			StorageAndSetUps.getInstance().mc.userStatus.setText("BRONZE USER");
			StorageAndSetUps.getInstance().mc.userStatus.setAlignment(Pos.CENTER);
			StorageAndSetUps.getInstance().mc.userStatus.setVisible(true);
			StorageAndSetUps.getInstance().mc.menuUserStatus.setOpacity(0.4);
			
		} else if ((PersistentStates.totalAnswered >= 50) && (PersistentStates.totalAnswered < 100)) {
			StorageAndSetUps.getInstance().achc.wreathIcon.setImage(new Image("/images/SILVER_WREATH.png", true));
			StorageAndSetUps.getInstance().achc.wreathIcon.setMouseTransparent(true);
			StorageAndSetUps.getInstance().achc.wreathText.setText("Answered at least 50 questions total.");
			StorageAndSetUps.getInstance().achc.wreathText.setAlignment(Pos.CENTER);
			StorageAndSetUps.getInstance().achc.wreathIcon.setOpacity(1.0);
			
			StorageAndSetUps.getInstance().mc.menuUserStatus.setImage(new Image("/images/SILVER_WREATH.png", true));
			StorageAndSetUps.getInstance().mc.userStatus.setText("SILVER USER");
			StorageAndSetUps.getInstance().mc.userStatus.setAlignment(Pos.CENTER);
			StorageAndSetUps.getInstance().mc.userStatus.setVisible(true);
			StorageAndSetUps.getInstance().mc.menuUserStatus.setOpacity(0.4);
			
		} else if ((PersistentStates.totalAnswered >= 100) && (PersistentStates.totalAnswered < 250)) {
			StorageAndSetUps.getInstance().achc.wreathIcon.setImage(new Image("/images/GOLD_WREATH.png", true));
			StorageAndSetUps.getInstance().achc.wreathIcon.setMouseTransparent(true);
			StorageAndSetUps.getInstance().achc.wreathText.setText("Answered at least 100 questions total.");
			StorageAndSetUps.getInstance().achc.wreathText.setAlignment(Pos.CENTER);
			StorageAndSetUps.getInstance().achc.wreathIcon.setOpacity(1.0);
			
			StorageAndSetUps.getInstance().mc.menuUserStatus.setImage(new Image("/images/GOLD_WREATH.png", true));
			StorageAndSetUps.getInstance().mc.userStatus.setText("GOLD USER");
			StorageAndSetUps.getInstance().mc.userStatus.setAlignment(Pos.CENTER);
			StorageAndSetUps.getInstance().mc.userStatus.setVisible(true);
			StorageAndSetUps.getInstance().mc.menuUserStatus.setOpacity(0.4);
			
			
		} else if ((PersistentStates.totalAnswered >= 250) && (PersistentStates.totalAnswered < 500)) {
			StorageAndSetUps.getInstance().achc.wreathIcon.setImage(new Image("/images/PLATINUM_WREATH.png", true));
			StorageAndSetUps.getInstance().achc.wreathIcon.setMouseTransparent(true);
			StorageAndSetUps.getInstance().achc.wreathText.setText("Answered at least 250 questions total.");
			StorageAndSetUps.getInstance().achc.wreathText.setAlignment(Pos.CENTER);
			StorageAndSetUps.getInstance().achc.wreathIcon.setOpacity(1.0);
			
			StorageAndSetUps.getInstance().mc.menuUserStatus.setImage(new Image("/images/PLATINUM_WREATH.png", true));
			StorageAndSetUps.getInstance().mc.userStatus.setText("PLATINUM USER");
			StorageAndSetUps.getInstance().mc.userStatus.setAlignment(Pos.CENTER);
			StorageAndSetUps.getInstance().mc.userStatus.setVisible(true);
			StorageAndSetUps.getInstance().mc.menuUserStatus.setOpacity(0.4);
			
			
		} else if ((PersistentStates.totalAnswered >= 500)) {
			StorageAndSetUps.getInstance().achc.wreathIcon.setImage(new Image("/images/DIAMOND.png", true));
			StorageAndSetUps.getInstance().achc.wreathIcon.setMouseTransparent(true);
			StorageAndSetUps.getInstance().achc.wreathText.setText("Answered at least 500 questions total.");
			StorageAndSetUps.getInstance().achc.wreathText.setAlignment(Pos.CENTER);
			StorageAndSetUps.getInstance().achc.wreathIcon.setOpacity(1.0);
			
			StorageAndSetUps.getInstance().mc.menuUserStatus.setImage(new Image("/images/DIAMOND.png", true));
			StorageAndSetUps.getInstance().mc.userStatus.setText("DIAMOND USER");
			StorageAndSetUps.getInstance().mc.userStatus.setAlignment(Pos.CENTER);
			StorageAndSetUps.getInstance().mc.userStatus.setVisible(true);
			StorageAndSetUps.getInstance().mc.menuUserStatus.setOpacity(0.4);
			
			
		} else {
			
		}
	
	}
	
	public static void stageUnlockSet(String username) throws IOException {
				
		// Gets current working directory
		String pwd = System.getProperty("user.dir");
		
		File fileLevels = new File(pwd + "/TataiResources/" + username + "persistentLevels.txt");
		
		Scanner sL = new Scanner(fileLevels);
		
		String stage;
		
		int line = 0;
		
		try {
			
			while (sL.hasNextLine()) {
				line++;
				
				stage = sL.nextLine();
				

				if ((Integer.parseInt(stage) == 1) && (line == 2)) {
					StorageAndSetUps.getInstance().lmc.mediumGoButton.setDisable(false);
					StorageAndSetUps.getInstance().lmc.mediumMessage.setVisible(false);
					
				}
				
				if ((Integer.parseInt(stage) == 1) && (line == 3)) {
					StorageAndSetUps.getInstance().lmc.hardGoButton.setDisable(false);
					StorageAndSetUps.getInstance().lmc.hardMessage.setVisible(false);
				}
				
				if ((Integer.parseInt(stage) == 1) && (line == 4)) {
					
//					StorageAndSetUps.getInstance().lmc.customGoButton.setDisable(false);
//					StorageAndSetUps.getInstance().lmc.customSettings.setVisible(true);
//					StorageAndSetUps.getInstance().lmc.customMessage.setVisible(false);
					
					StorageAndSetUps.getInstance().achc.starIcon.setImage(new Image("/images/GOLD_STAR.png", true));
					StorageAndSetUps.getInstance().achc.starIcon.setOpacity(1.0);
					StorageAndSetUps.getInstance().achc.starIcon.setMouseTransparent(true);
					
					StorageAndSetUps.getInstance().achc.starText.setText("You unlocked all levels!");
					StorageAndSetUps.getInstance().achc.starText.setAlignment(Pos.CENTER);

					
				}
				

				
			}
			
			sL.close();
			
		} finally {
			
		}
	}

	

}
