package application;

import java.io.IOException;

import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class QuizController {

	@FXML
	protected Button recordButton;

	@FXML
	protected Button menuButton;

	@FXML
	protected Button beginButton;

	@FXML
	protected Button continueButton;

	@FXML
	protected Label label;

	@FXML
	protected AnchorPane ap;


	protected boolean mouseClicked = false;
	protected boolean hard;
	protected int questionCount = 0;
	private int countdown = 3;

	public void recordPress(ActionEvent event) throws IOException {
		questionCount++;
		recordButton.setVisible(false);
		menuButton.setVisible(false);
		label.setText("Recording...");
		label.setTextFill(Color.RED);
		PauseTransition delay = new PauseTransition(Duration.seconds(0.5));
		delay.setOnFinished( e -> {
			label.setText("Recorded!");
			label.setTextFill(Color.BLACK);
			continueButton.setVisible(true);
		});
		delay.play();	
	}

	public void continuePress(ActionEvent event) throws IOException {
		continueButton.setVisible(false);
		
		if (questionCount == 10) {
			questionCount = 0;
			Scene score = SceneStorage.getInstance().score;
			Stage window = (Stage) menuButton.getScene().getWindow();
			window.setScene(score);
		} else {
			recordButton.setVisible(true);
			menuButton.setVisible(true);
			label.setText(RandomMaoriNums.maoriNums(hard));
			label.setTextFill(Color.web("#24970f"));
		}
	}

	public void menuPress(ActionEvent event) throws IOException {
		Scene levelMenu = SceneStorage.getInstance().levelMenu;
		Stage window = (Stage) menuButton.getScene().getWindow();
		window.setScene(levelMenu);
		questionCount = 0;
	}

	public void mouseClick(MouseEvent e) throws IOException {
		if (mouseClicked) {
		} else {
			mouseClicked = true;
			label.setTextFill(Color.RED);
			label.setText("3");
			delay(1);
		}
	}

	private void delay(double seconds) {
		Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(seconds), ae -> countdown() ));
		timeline.setCycleCount(4);
		timeline.play();
	}

	private void countdown() {
		countdown--;
		if (countdown == 0) {
			label.setText("Haere!");
		} else if (countdown == -1){
			countdown = 3;
			label.setTextFill(Color.web("#24970f"));

			label.setText(RandomMaoriNums.maoriNums(hard));

			menuButton.setVisible(true);
			recordButton.setVisible(true);
		} else {
			label.setText(Integer.toString(countdown));
		}

	}


}
