package application;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

public class SceneStorage {

	private static SceneStorage ss;
	
	public QuizController qc;
	public StatisticsController sc;
	public ScoreController scc;

	
	public Scene menu,quiz,levelMenu,instructions,score, statistics;
	
	ObservableList<String> list = FXCollections.observableArrayList();
	
	private SceneStorage() throws IOException {
		menu = new Scene(FXMLLoader.load(getClass().getResource("Menu.fxml")));
		levelMenu = new Scene(FXMLLoader.load(getClass().getResource("LevelMenu.fxml")));
		instructions = new Scene(FXMLLoader.load(getClass().getResource("Instructions.fxml")));
		scoreLoader();
		statsLoader();
		quizLoader();
	}
	
	public static SceneStorage getInstance() throws IOException {
		if (ss == null) {
			ss = new SceneStorage();
		}
		return ss;
	}
	
	private void scoreLoader() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Score.fxml"));
		score = new Scene(loader.load());
		scc = loader.getController();
	}
	
	private void statsLoader() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Statistics.fxml"));
		statistics = new Scene(loader.load());
		sc = loader.getController();
	}
	
	private void quizLoader() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Quiz.fxml"));
		quiz = new Scene(loader.load());
		qc = loader.getController();
		quizSetup();
	}
	

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
