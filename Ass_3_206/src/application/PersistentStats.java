package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PersistentStats {
	
	public static void createFile() throws IOException {
		
		
		// Gets current working directory
		String pwd = System.getProperty("user.dir");
		
		File fileEasy = new File(pwd + "/easyStats.txt");
		
		File fileHard = new File(pwd + "/hardStats.txt");
		
		if(!fileEasy.exists()) {
			fileEasy.createNewFile();
		}
		
		if(!fileHard.exists()) {
			fileHard.createNewFile();
		}
		
		
	}
	
	
	public static void loadStats() throws IOException {
		
		// Gets current working directory
		String pwd = System.getProperty("user.dir");
		
		File fileEasy = new File(pwd + "/easyStats.txt");
		
		File fileHard = new File(pwd + "/hardStats.txt");
		
		try {
			
			Scanner sE = new Scanner(fileEasy);
			
			
			
			String score, format;
			
			int easySessionNum = 0;
			
			while (sE.hasNextLine()) {
				easySessionNum++;
				score = sE.nextLine();
				format = "Session " + easySessionNum + ":\t\t" + score + "/10";
				StorageAndSetUps.getInstance().sc.listEasy.add(format);
				
				StorageAndSetUps.getInstance().sc.easySession = easySessionNum;
			}
			
			sE.close();
			
			Scanner sH = new Scanner(fileHard);
			
			int hardSessionNum = 0;
			
			while (sH.hasNextLine()) {
				hardSessionNum++;
				score = sH.nextLine();
				format = "Session " + hardSessionNum + ":\t\t" + score + "/10";
				StorageAndSetUps.getInstance().sc.listHard.add(format);
				
				StorageAndSetUps.getInstance().sc.hardSession = hardSessionNum;
			}
			
			sH.close();
			
		} finally {
			
		}
	}
	
	public static void appendStat(int sessionScore, boolean hard) throws IOException {
		
		BufferedWriter bw = null;
		FileWriter fw = null;
		
		try {
		
		// Gets current working directory
		String pwd = System.getProperty("user.dir");
		
		File file;
		
		if (hard) {
		file = new File(pwd + "/hardStats.txt");
		} else {
		file = new File(pwd + "/easyStats.txt");
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
	
}
