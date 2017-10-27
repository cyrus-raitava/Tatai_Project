package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class QuizController {

	@FXML
	protected Button recordButton;

	@FXML
	protected Button reRecordButton;

	@FXML
	protected Button menuButton;

	@FXML
	protected Button beginButton;

	@FXML
	protected Button continueButton;

	@FXML
	protected Label label;
	
	@FXML
	protected Label sessionLabel;
	
	@FXML
	protected Label questionLabel;

	@FXML
	protected AnchorPane ap;
	
	@FXML
	protected ProgressBar progBar;
	protected double prog;
	protected double counts = 1000;
	
	@FXML
	protected Label expectedAnswer;
	
	@FXML
	protected Label number;


	protected boolean mouseClicked = false;
	protected Level level;
	protected int questionCount = 0;
	protected int currentScore;
	private int countdown = 3;


	/**
	 * Begins a recording process when record button is pressed.
	 * @param event
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	public void recordPress(ActionEvent event) throws IOException, InterruptedException {
		questionCount++; // question count is incremented
		recordButton.setVisible(false); // record button disappears
		menuButton.setVisible(false); // menu button disappears

		// Begin the recorder
		Recorder.getInstance().recordPress();
	}

	/**
	 * Begins a recording process when re-record button is pressed but does
	 * not increment question count!
	 * @param event
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	public void reRecordPress(ActionEvent event) throws IOException, InterruptedException {
		number.setVisible(false);
		reRecordButton.setVisible(false); // rerecord button disappears
		menuButton.setVisible(false); // menu button disappears

		// Begin the recorder
		Recorder.getInstance().recordPress(); 
	}


	/**
	 * Depending on the state of the QuizController, scene will either change to score
	 * or move on to next question when continue button is pressed.
	 * @param event
	 * @throws IOException
	 */
	public void continuePress(ActionEvent event) throws IOException {
		expectedAnswer.setVisible(false);
		String questionNum = (questionCount + 1) + "/10";
		questionLabel.setText(questionNum);
		
		String pwd = System.getProperty("user.dir");
		File file = new File(pwd + "/persistentLevels.txt");
		
		BufferedWriter bw = null;
		FileWriter fw = null;
		
		continueButton.setVisible(false); // continue button disappears

		// if the question is the tenth one, move to score scene
		if (questionCount == 10) {
			questionCount = 0; // reset question count


			// set medium transition to true only if the score is 8 or above and
			// we are on the easy level (hard = false)
			StorageAndSetUps.getInstance().scc.mediumTransition.setVisible(false);
			StorageAndSetUps.getInstance().scc.hardTransition.setVisible(false);
			if ((currentScore >= 8) && (level == Level.EASY)) {
				StorageAndSetUps.getInstance().scc.mediumTransition.setVisible(true);
				StorageAndSetUps.getInstance().lmc.mediumGoButton.setDisable(false);
				StorageAndSetUps.getInstance().lmc.mediumMessage.setVisible(false);
				
				// On top of this, write to the PersistentLevels.txt file, to retain medium stage unlock
				// for user's future sessions.
				
				fw = new FileWriter(file.getAbsoluteFile());
				
				bw = new BufferedWriter(fw);
				
				String mediumUnlock = "1\n1\n0\n0";
				
				bw.write(mediumUnlock);
				
				bw.close();
			
			}
			
			// set hard transition to true only if the score is 8 or above and
			// we are on the medium level (hard = false)
			if ((currentScore >= 8) && (level == Level.MEDIUM)) {
				StorageAndSetUps.getInstance().scc.hardTransition.setVisible(true);
				StorageAndSetUps.getInstance().lmc.hardGoButton.setDisable(false);
				StorageAndSetUps.getInstance().lmc.hardMessage.setVisible(false);
				
				// On top of this, write to the PersistentLevels.txt file, to retain hard stage unlock
				// for user's future sessions.
				
				fw = new FileWriter(file.getAbsoluteFile());
				
				bw = new BufferedWriter(fw);
				
				String hardUnlock = "1\n1\n1\n0";
				
				bw.write(hardUnlock);
				
				bw.close();

			}


			// Move to score scene
			Scene score = StorageAndSetUps.getInstance().score;
			Stage window = (Stage) menuButton.getScene().getWindow();
			window.setScene(score);

			// Set the label to the currentScore
			StorageAndSetUps.getInstance().scc.score.setText(currentScore + "/10");
			StorageAndSetUps.getInstance().sc.addSessionScore(currentScore, level);

			// if not 10th question, set a new number to record.
		} else {
			recordButton.setVisible(true); // record button appears
			menuButton.setVisible(true); // menu button appears

			// number is randomly reset
			label.setText(RandomMaoriNums.getInstance().maoriNums(level));

			// text colour set to green
			label.setTextFill(Color.PURPLE);
		}
	}

	/**
	 * Switches scene to level Menu, when menu button is pressed.
	 * @param event
	 * @throws IOException
	 */
	public void menuPress(ActionEvent event) throws IOException {
		Scene levelMenu = StorageAndSetUps.getInstance().levelMenu;
		Stage window = (Stage) menuButton.getScene().getWindow();
		window.setScene(levelMenu);
		questionCount = 0;
	}

	/**
	 * A countdown begins in the initial screen of the quiz when the mouse is
	 * clicked.
	 * @param e
	 * @throws IOException
	 */
	public void mouseClick(MouseEvent e) throws IOException {
		// ensure mouse can only be clicked once.
		if (mouseClicked) {
			// do nothing if mouse has already been clicked
		} else {
			mouseClicked = true; 

			// set text to red colour
			label.setTextFill(Color.RED);
			label.setText("3");

			// set countdown delay to begin countdown
			delay(1);
		}
	}

	/**
	 * Begins a countdown timer for the quiz scene at intervals of the input in seconds.
	 * @param seconds
	 */
	private void delay(double seconds) {
		// set a timeline to do countdown() 4 times at the input interval time (in seconds)
		Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(seconds), ae -> {
			try {
				countdown();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} )); 
		timeline.setCycleCount(4);
		timeline.play();
	}

	/**
	 * Edits the quiz label to a 3,2,1, Haere! countdown.
	 * @throws IOException 
	 */
	private void countdown() throws IOException {
		// decrease count
		countdown--;

		// set 'Haere!' if countdown has reached zero
		if (countdown == 0) {
			label.setText("Haere!");

			// if countdown has finished reset and change the label to a number
		} else if (countdown == -1){
			countdown = 3; // reset countdown 

			// set text colour to green
			label.setTextFill(Color.PURPLE);

			// set text to a random number
			label.setText(RandomMaoriNums.getInstance().maoriNums(level));
			
			// question label appears
			questionLabel.setVisible(true);

			menuButton.setVisible(true); // menu button appears
			recordButton.setVisible(true); // record button appears

			// set label to countdown value
		} else {
			label.setText(Integer.toString(countdown));
		}

	}
	
	
	/**
	 * Automates a progress bar with input time and direction.
	 * @param double time = the length of progress bar in seconds
	 * @param boolean up = true if progress bar is going left to right
	 */
	public void progressBar(double time, boolean up) {
		
		// set bar to visible and initialise to either full if going up or empty otherwise
		progBar.setVisible(true);
		if (up) {
			progBar.setProgress(0);
			prog = 0;
		} else {
			progBar.setProgress(1);
			prog = 1;
		}


		// Create a timeline counter to do something every count. THe count is set to time/seconds
		// because this will evenly distribute the progress of the bar.
		Timeline timeline2 = new Timeline(new KeyFrame(Duration.seconds(time/counts), ae -> {
			
			// increase progress until full
			if (up) {
				if (!(prog >= 1)) {
					prog = prog + 1/counts;
				} else {
					prog = 1;
				}

			// decrese progress until empty
			} else {
				if (!(prog <= 0)) {
					prog = prog - 1/counts;
				} else {
					prog = 0;
				}
			}

			progBar.setProgress(prog);
		} ));
		
		// set counts to one more than counts to ensure comopletion of progress bar.
		timeline2.setCycleCount((int)(counts + 1));
		timeline2.play();
	}


}
