package application;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

// Create class to use for allowing access to instances of different scenes, as well as their respective controllers
// (and the variables/methods within those controllers).

public class SceneStorage {

	// Initialize SceneStorage instance.
	private static SceneStorage ss;
	
	// Initialize variables of type ___Controller, to allow access to individual controllers.
	
	public QuizController qc;
	public StatisticsController sc;
	public ScoreController scc;

	
	public Scene menu,quiz,levelMenu,instructions,score, statistics;
	
	// Specify variabels within SceneStorage instances, that may be accessed.
	
	private SceneStorage() throws IOException {
		menu = new Scene(FXMLLoader.load(getClass().getResource("Menu.fxml")));
		levelMenu = new Scene(FXMLLoader.load(getClass().getResource("LevelMenu.fxml")));
		instructions = new Scene(FXMLLoader.load(getClass().getResource("Instructions.fxml")));
		scoreLoader();
		statsLoader();
		quizLoader();
	}
	
	// Create constructor method that creates instances of SceneStorage, from which individual scenes may be loaded.
	
	public static SceneStorage getInstance() throws IOException {
		if (ss == null) {
			ss = new SceneStorage();
		}
		return ss;
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
		qc.recordButton.setVisible(false);
		qc.reRecordButton.setVisible(false);
		qc.menuButton.setVisible(false);
		qc.label.setTextFill(Color.BLACK);
		qc.label.setText("Click to Start!");
		qc.mouseClicked = false;
		qc.continueButton.setVisible(false);
		qc.questionCount = 0;
		qc.currentScore = 0;
	}
}
