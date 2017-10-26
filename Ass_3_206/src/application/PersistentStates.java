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
	
	public static void setUps() throws IOException {
		
		PersistentStates.createStartFile();
		PersistentStates.loadStats(UserLogin.username);
		PersistentStates.defaultAchievements();
		PersistentStates.stageUnlockSet(UserLogin.username);
		PersistentStates.achievementsLoad(UserLogin.username);	
		
		
	}
	
	public static void defaultAchievements() throws IOException {
		
		StorageAndSetUps.getInstance().achc.arrowIcon.setOpacity(0.3);
		StorageAndSetUps.getInstance().achc.scholarIcon.setOpacity(0.3);
		StorageAndSetUps.getInstance().achc.scrollIcon.setOpacity(0.3);
		StorageAndSetUps.getInstance().achc.starIcon.setOpacity(0.3);
		StorageAndSetUps.getInstance().achc.streakIcon.setOpacity(0.3);
		StorageAndSetUps.getInstance().achc.wreathIcon.setOpacity(0.3);
			
		StorageAndSetUps.getInstance().achc.arrowText.setText("LOCKED");
		StorageAndSetUps.getInstance().achc.arrowText.setVisible(true);
		StorageAndSetUps.getInstance().achc.arrowText.setWrapText(true);
		StorageAndSetUps.getInstance().achc.arrowText.setAlignment(Pos.CENTER);
		
		StorageAndSetUps.getInstance().achc.scholarText.setText("LOCKED");
		StorageAndSetUps.getInstance().achc.scholarText.setVisible(true);
		StorageAndSetUps.getInstance().achc.scholarText.setWrapText(true);
		StorageAndSetUps.getInstance().achc.scholarText.setAlignment(Pos.CENTER);
		
		StorageAndSetUps.getInstance().achc.scrollText.setText("LOCKED");
		StorageAndSetUps.getInstance().achc.scrollText.setVisible(true);
		StorageAndSetUps.getInstance().achc.scrollText.setWrapText(true);
		StorageAndSetUps.getInstance().achc.scrollText.setAlignment(Pos.CENTER);
		
		StorageAndSetUps.getInstance().achc.starText.setText("LOCKED");
		StorageAndSetUps.getInstance().achc.starText.setVisible(true);
		StorageAndSetUps.getInstance().achc.starText.setWrapText(true);
		StorageAndSetUps.getInstance().achc.starText.setAlignment(Pos.CENTER);
		
		StorageAndSetUps.getInstance().achc.streakText.setText("LOCKED");
		StorageAndSetUps.getInstance().achc.streakText.setVisible(true);
		StorageAndSetUps.getInstance().achc.streakText.setWrapText(true);
		StorageAndSetUps.getInstance().achc.streakText.setAlignment(Pos.CENTER);
		
		StorageAndSetUps.getInstance().achc.wreathText.setText("LOCKED");
		StorageAndSetUps.getInstance().achc.wreathText.setVisible(true);
		StorageAndSetUps.getInstance().achc.wreathText.setWrapText(true);
		StorageAndSetUps.getInstance().achc.wreathText.setAlignment(Pos.CENTER);
		
		StorageAndSetUps.getInstance().mc.menuUserStatus.setOpacity(0.3);
		StorageAndSetUps.getInstance().mc.userStatus.setText("");
		StorageAndSetUps.getInstance().mc.userStatus.setVisible(false);
		StorageAndSetUps.getInstance().mc.userStatus.setAlignment(Pos.CENTER);
		
		
		
	}
	
	
	public static void createStartFile() throws IOException {

		// Gets current working directory
		String pwd = System.getProperty("user.dir");

		File resource = new File(pwd + "/TataiResources");
	
		
		File fileUserList = new File(pwd + "/TataiResources/userList.txt");
		
		if(!resource.exists()) {
			resource.mkdir();
		}
		
		if (!fileUserList.exists()) {
			fileUserList.createNewFile();
		}


	}
	
	


	public static void loadStats(String username) throws IOException {

		// Gets current working directory
		String pwd = System.getProperty("user.dir");

		File fileEasy = new File(pwd + "/TataiResources/" + username + "easyStats.txt");

		File fileMedium = new File(pwd + "/TataiResources/" + username + "mediumStats.txt");

		File fileHard = new File(pwd + "/TataiResources/" + username + "hardStats.txt");

		try {

			
			
			Scanner sE = new Scanner(fileEasy);

			String score, format;

			int easySessionNum = 0;

			while (sE.hasNextLine()) {
				easySessionNum++;
				score = sE.nextLine();
				format = "Session " + easySessionNum + ":\t" + score + "/10";
				StorageAndSetUps.getInstance().sc.listEasy.add(format);

				StorageAndSetUps.getInstance().sc.easySession = easySessionNum;
			}

			sE.close();

			Scanner sM = new Scanner(fileMedium);

			int mediumSessionNum = 0;

			while (sM.hasNextLine()) {
				mediumSessionNum++;
				score = sM.nextLine();
				format = "Session " + mediumSessionNum + ":\t" + score + "/10";
				
				
				StorageAndSetUps.getInstance().sc.listMedium.add(format);

				StorageAndSetUps.getInstance().sc.mediumSession = mediumSessionNum;
			}

			sM.close();

			Scanner sH = new Scanner(fileHard);

			int hardSessionNum = 0;

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

	public static void appendStat(int sessionScore, Level level, String username) throws IOException {

		BufferedWriter bw = null;
		FileWriter fw = null;

		try {

			// Gets current working directory
			String pwd = System.getProperty("user.dir");

			File file;

			if (level == Level.HARD) {
				file = new File(pwd + "/TataiResources/" + username + "hardStats.txt");
			} else if (level == level.EASY){
				file = new File(pwd + "/TataiResources/" + username + "easyStats.txt");
			} else  {
				file = new File(pwd + "/TataiResources/" + username + "mediumStats.txt");
			}

			fw = new FileWriter(file.getAbsoluteFile(), true);
			bw = new BufferedWriter(fw);

			String score = sessionScore + "\n";

			bw.write(score);

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
	
	public static void achievementsLoad(String username) throws IOException {
		
		// Gets current working directory
		String pwd = System.getProperty("user.dir");
		
		File fileEasy = new File(pwd + "/TataiResources/" + username + "easyStats.txt");

		File fileMedium = new File(pwd + "/TataiResources/" + username + "mediumStats.txt");

		File fileHard = new File(pwd + "/TataiResources/" + username + "hardStats.txt");
		
		accuracyUnlock(fileEasy);
		accuracyUnlock(fileMedium);
		accuracyUnlock(fileHard);
		
		streakUnlock(fileEasy);
		streakUnlock(fileMedium);
		streakUnlock(fileHard);
		
		PersistentStates.correctNumber = 0;
		
		correctUnlock(fileEasy, 50);
		correctUnlock(fileMedium, 50);
		correctUnlock(fileHard, 50);
		
		PersistentStates.correctNumber = 0;
		
		correctUnlock(fileEasy, 100);
		correctUnlock(fileMedium, 100);
		correctUnlock(fileHard, 100);
		
		PersistentStates.totalAnswered = 0;
		
		wreathUnlock(fileEasy);
		wreathUnlock(fileMedium);
		wreathUnlock(fileHard);

	}
	
	public static void accuracyUnlock(File file) throws IOException {
		
		Scanner s = new Scanner(file);
		
		int sessionNum = 0;
		int score;
		
		while (s.hasNextLine()) {
			sessionNum++;
			score = (Integer.parseInt(s.nextLine()));
			
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
	
	
	
	public static void streakUnlock(File file) throws IOException {
		
		Scanner s = new Scanner(file);
		
		int sessionNum = 0;
		int score;
		
		int streak = 0;
		
		while (s.hasNextLine()) {
			sessionNum++;
			score = (Integer.parseInt(s.nextLine()));
			
			if (score != 10) {
				streak = 0;
			} else {
				streak++;
			}
			
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
	
	public static int correctNumber;
	
	public static void correctUnlock(File file, int limit) throws IOException {
		
		Scanner s = new Scanner(file);
		
		String score;
		
		int add;
		
		while (s.hasNextLine()) {
			score = s.nextLine();
			
			add = (Integer.parseInt(score));
			
			PersistentStates.correctNumber += add;
			
			if (PersistentStates.correctNumber >= limit) {
				
				StorageAndSetUps.getInstance().achc.scrollIcon.setOpacity(1.0);
				
				switch (limit) {
				case 50:
					StorageAndSetUps.getInstance().achc.scrollIcon.setOpacity(1.0);
					StorageAndSetUps.getInstance().achc.scrollIcon.setMouseTransparent(true);
					StorageAndSetUps.getInstance().achc.scrollIcon.setImage(new Image("/images/C_SCROLL.png", true));
					StorageAndSetUps.getInstance().achc.scrollText.setText("At least " + limit + " questions correct, total");
					StorageAndSetUps.getInstance().achc.scrollText.setAlignment(Pos.CENTER);
					break;
				case 100:
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
	
	public static int totalAnswered;
	
	public static void wreathUnlock(File file) throws IOException {
		
		Scanner s = new Scanner(file);
		
		String score;
		
		int session = 0;
		
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
