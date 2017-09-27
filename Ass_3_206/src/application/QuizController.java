package application;

import java.io.IOException;

import javafx.animation.KeyFrame;
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
	protected Label label;

	@FXML
	protected AnchorPane ap;


	protected boolean mouseClicked = false;
	protected boolean hard;
	private int countdown = 3;

	public void recordPress(ActionEvent event) throws IOException {	
			label.setText(RandomMaoriNums.maoriNums(hard));
	}

	public void menuPress(ActionEvent event) throws IOException {
		Scene levelMenu = SceneStorage.getInstance().levelMenu;
		Stage window = (Stage) menuButton.getScene().getWindow();
		window.setScene(levelMenu);
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
