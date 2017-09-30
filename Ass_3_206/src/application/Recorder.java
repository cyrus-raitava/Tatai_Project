package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Recorder {

	private static Recorder r;
	
	private Label label = SceneStorage.getInstance().qc.label;
	private Button continueButton = SceneStorage.getInstance().qc.continueButton;
	private Button recordButton = SceneStorage.getInstance().qc.recordButton;
	private Button reRecordButton = SceneStorage.getInstance().qc.reRecordButton;
	private boolean transition1 = true;

	private ArrayList<String> saidWords = new ArrayList<String>();

	private Recorder() throws IOException {}

	public boolean success;
	public boolean retry = false;

	public static Recorder getInstance() throws IOException {
		if (r == null) {
			r = new Recorder();
		} 
		return r;
	}
	
	
	public void recordPress() throws IOException {
		label.setText("Recording...");
		label.setTextFill(Color.RED);

		ProcessBuilder builder = new ProcessBuilder("/bin/bash","-c", "cd /home/se206/"
				+ "Documents/HTK/MaoriNumbers;./GoSpeech");
		builder.start();



		Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2.6), ae -> {
			try {
				recordTransition();
			} catch (FileNotFoundException e) {
			} catch (IOException e) {
			}
		} ));
		timeline.setCycleCount(2);
		timeline.play();
		transition1 = true;
	}

	public void recordTransition() throws FileNotFoundException, IOException {
		if (transition1) {
			label.setText("Playback...");
			label.setTextFill(Color.BLUE);
			transition1 = false;
		} else {

			try (BufferedReader br = new BufferedReader(new FileReader("/home/se206/Documents"
					+ "/HTK/MaoriNumbers/recout.mlf"))) {
				String line = null;
				saidWords = new ArrayList<String>();
				while ((line = br.readLine()) != null) {
					if (!line.equals("#!MLF!#") && !line.equals("sil") 
							&& !line.equals("\"*/foo.rec\"") && !line.equals(".")) {
						saidWords.add(line);
					}
				}
			}

			ArrayList<String> num = RandomMaoriNums.getInstance().currentNum;
			success = true;
			for (String part : num) {

				String word = part;

				if (part == "whā") {
					word = "whaa";
				} else if (part == "mā") {
					word = "maa";
				}

				if (!saidWords.contains(word)){
					success = false;
					break;
				}
			}

			if (success) {
				label.setText("SUCCESS!");
				label.setTextFill(Color.BLACK);
				SceneStorage.getInstance().qc.currentScore++;
				retry = false;
			} else {
				label.setText("FAIL!");
				label.setTextFill(Color.BLACK);
				retry ^= true;
			}
			
			if (retry) {
				reRecordButton.setVisible(true);
			} else {
				recordButton.setText("Record");
				continueButton.setVisible(true);
			}




		}
	}
}
