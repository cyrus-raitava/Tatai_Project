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

	private Label label = StorageAndSetUps.getInstance().qc.label;
	private Button continueButton = StorageAndSetUps.getInstance().qc.continueButton;
	private Button reRecordButton = StorageAndSetUps.getInstance().qc.reRecordButton;
	private boolean transition1 = true;

	private ArrayList<String> saidWords = new ArrayList<String>();

	private Recorder() throws IOException {}

	public boolean success;
	public boolean retry = false;

	/**
	 * Singleton pattern
	 * @return
	 * @throws IOException
	 */
	public static Recorder getInstance() throws IOException {
		if (r == null) {
			r = new Recorder();
		} 
		return r;
	}


	/**
	 * Sets recording functionality.
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void recordPress() throws IOException, InterruptedException {
		label.setText("Recording..."); // set label to 'recording...'
		label.setTextFill(Color.RED); // set colour to red

		// set record time depending on whether on hard or easy level
		double time = 3.5;


		// run bash script for audio recognition using 'time' for recording time
		ProcessBuilder builder = new ProcessBuilder("/bin/bash","-c", "cd /home/se206/Documents/HTK/MaoriNumbers ; arecord -d " + time + " -r 22050 -c 1 -i -t wav -f s16_LE foo.wav ; " + 
				"HVite -H HMMs/hmm15/macros -H HMMs/hmm15/hmmdefs -C user/configLR  -w user/wordNetworkNum -o SWT -l '*' -i recout.mlf -p 0.0 -s 5.0  user/dictionaryD user/tiedList foo.wav ; " + 
				"aplay foo.wav ; " + 
				"rm foo.wav");
		builder.start();


		// create a transition for recording to sync in time with bash process
		Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(time), ae -> {
			try {
				recordTransition(time);
			} catch (FileNotFoundException e) {
			} catch (IOException e) {
			}
		} ));
		timeline.setCycleCount(2); // run twice
		timeline.play();

		StorageAndSetUps.getInstance().qc.progressBar(time,true); // set the progress bar

		transition1 = true; // store transition state
	}

	/**
	 * Sets playback transition and determines whether response is correct, then
	 * edits the scene. 
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void recordTransition(double time) throws FileNotFoundException, IOException {
		if (transition1) {
			StorageAndSetUps.getInstance().qc.progressBar(time, false);

			label.setText("Playback..."); // change label
			label.setTextFill(Color.BLUE); // make label blue

			transition1 = false; 
		} else {

			StorageAndSetUps.getInstance().qc.progBar.setVisible(false);

			// read voice recognition file
			try (BufferedReader br = new BufferedReader(new FileReader("/home/se206/Documents"
					+ "/HTK/MaoriNumbers/recout.mlf"))) {
				String line = null;

				// variable to store said words
				saidWords = new ArrayList<String>();

				// store said words in string 
				while ((line = br.readLine()) != null) {
					// ignore parts of file that are not said words
					if (!line.equals("#!MLF!#") && !line.equals("sil") 
							&& !line.equals("\"*/foo.rec\"") && !line.equals(".")) {
						saidWords.add(line);
					}
				}
			}

			// access current word string
			ArrayList<String> num = RandomMaoriNums.getInstance().currentNum;

			// determine whether all words were said
			success = false;
			for (String part : num) {
				success = true;
				String word = part;

				// ensure accents are interpreted in the same way
				if (part == "whā") {
					word = "whaa";
				} else if (part == "mā") {
					word = "maa";
				}

				if (!saidWords.contains(word)){
					success = false; // if any word is not said, then it is unsuccessful
					break;
				}
			}


			if (success) {
				label.setText("KA PAI!"); // set label to success text
				label.setTextFill(Color.GREEN); // set to black

				// increment the current score
				StorageAndSetUps.getInstance().qc.currentScore++;

				// do not allow a retry attempt
				retry = false;

			} else {
				retry ^= true; // toggle retry to ensure retry can only occur once per question.
			}


			if (retry) {
				// rerecord appears if user is allowed a re-attempt
				label.setText("" + RandomMaoriNums.getInstance().currentEquation); // set label to current number
				label.setTextFill(Color.PURPLE); // set to green
				reRecordButton.setVisible(true);
				StorageAndSetUps.getInstance().qc.number.setVisible(true);
			} else {
				// display expected answer if wrong and already retried.
				if (!success) {
					label.setText(RandomMaoriNums.getInstance().currentEquation + " = " + RandomMaoriNums.getInstance().currentAns); // set label to fail text
					label.setTextFill(Color.RED); // set to black
					StorageAndSetUps.getInstance().qc.expectedAnswer.setVisible(true);
					String text = "You should have said \"";
					int i = 0;
					for (String s : RandomMaoriNums.getInstance().currentNum) {
						i++;
						if (i == RandomMaoriNums.getInstance().currentNum.size()) {
							text = text + s ;
						} else {
							text = text + s + " ";
						}
					}
					text = text + "\"";
					StorageAndSetUps.getInstance().qc.expectedAnswer.setText(text);
				}
				continueButton.setVisible(true);
			}




		}
	}
}
