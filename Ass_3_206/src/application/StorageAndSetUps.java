package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

// Create class to use for allowing access to instances of different scenes, as well as their respective controllers
// (and the variables/methods within those controllers).

public class StorageAndSetUps {

	// Initialize SceneStorage instance.
	private static StorageAndSetUps ss;
	
	// Initialize variables of type ___Controller, to allow access to individual controllers.
	
	public QuizController qc;
	public StatisticsController sc;
	public ScoreController scc;
	public LevelMenuController lmc;

	
	public Scene menu,quiz,levelMenu,instructions,score, statistics;
	
	// Specify variables within SceneStorage instances, that may be accessed.
	
	private StorageAndSetUps() throws IOException {
		menu = new Scene(FXMLLoader.load(getClass().getResource("Menu.fxml")));
		levelMenu = new Scene(FXMLLoader.load(getClass().getResource("LevelMenu.fxml")));
		instructions = new Scene(FXMLLoader.load(getClass().getResource("Instructions.fxml")));
		scoreLoader();
		statsLoader();
		quizLoader();
		levelMenuLoader();
	}
	
	// Create constructor method that creates instances of SceneStorage, from which individual scenes may be loaded.
	
	public static StorageAndSetUps getInstance() throws IOException {
		if (ss == null) {
			ss = new StorageAndSetUps();
		}
		return ss;
	}
	
	// Method that allows for access to the LevelMenuController
	
	private void levelMenuLoader() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("LevelMenu.fxml"));
		levelMenu = new Scene(loader.load());
		lmc = loader.getController();
		
	}
	// Method that allows for access to the ScoreController.
	
	private void scoreLoader() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Score.fxml"));
		score = new Scene(loader.load());
		scc = loader.getController();
	}
	
	// Method that allows for access to the StatsController.
	
	private void statsLoader() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Statistics.fxml"));
		statistics = new Scene(loader.load());
		sc = loader.getController();
	}
	
	// Method that allows for access to the QuizController.
	
	private void quizLoader() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Quiz.fxml"));
		quiz = new Scene(loader.load());
		qc = loader.getController();
		quizSetup();
	}
	
	// When method is called upon, necessary buttons are made invisible, allows for re-usage of FXML
	// scene setup, without having to actually change scene.
	
	public void quizSetup() {
		
		if (qc.hard) {
			String sessionNum = "Hard Session " + (StatisticsController.hardSession + 1);
			qc.sessionLabel.setText(sessionNum);
		} else {
			String sessionNum = "Easy Session " + (StatisticsController.easySession + 1);
			qc.sessionLabel.setText(sessionNum);
		}
		
		String questionNum = (qc.questionCount + 1) + "/10";
		qc.questionLabel.setText(questionNum);
		
		
		qc.recordButton.setVisible(false);
		qc.reRecordButton.setVisible(false);
		qc.menuButton.setVisible(false);
		qc.label.setTextFill(Color.BLACK);
		qc.label.setText("Click to Start!");
		qc.mouseClicked = false;
		qc.continueButton.setVisible(false);
		qc.questionCount = 0;
		qc.currentScore = 0;
		qc.progBar.setVisible(false);
		qc.number.setVisible(false);
		qc.expectedAnswer.setVisible(false);
		qc.questionLabel.setVisible(false);
	}
}
