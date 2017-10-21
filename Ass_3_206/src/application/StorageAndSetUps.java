package application;

import java.io.IOException;

import javafx.collections.FXCollections;
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
	public AdvancedController ac;
	public CustomController cc;
	public ClearStatsController csc;
	public AchievementsController achc;
	public MenuController mc;
	public UserLoginController ulc;


	public Scene menu,quiz,levelMenu,instructions,score, statistics, advanced, custom, clearStats, achievements, userLogin;

	// Specify variables within SceneStorage instances, that may be accessed.

	private StorageAndSetUps() throws IOException {
		menu = new Scene(FXMLLoader.load(getClass().getResource("Menu.fxml")));
		levelMenu = new Scene(FXMLLoader.load(getClass().getResource("LevelMenu.fxml")));
		instructions = new Scene(FXMLLoader.load(getClass().getResource("Instructions.fxml")));
		clearStats = new Scene(FXMLLoader.load(getClass().getResource("ClearStats.fxml")));
		achievements = new Scene(FXMLLoader.load(getClass().getResource("Achievements.fxml")));
		userLogin = new Scene(FXMLLoader.load(getClass().getResource("UserLogin.fxml")));
		
		userLoginLoader();
		menuLoader();
		achievementsLoader();
		clearStatsLoader();
		customLoader();
		scoreLoader();
		statsLoader();
		quizLoader();
		levelMenuLoader();
		advancedLoader();
	}

	// Create constructor method that creates instances of SceneStorage, from which individual scenes may be loaded.

	public static StorageAndSetUps getInstance() throws IOException {
		if (ss == null) {
			ss = new StorageAndSetUps();
		}
		return ss;
	}
	
	// Method that allows for access to the UserLoginController
	
	private void userLoginLoader() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("UserLogin.fxml"));
		userLogin = new Scene(loader.load());
		ulc = loader.getController();
	}

	// Method that allows for access to the MenuController
	
	private void menuLoader() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
		menu = new Scene(loader.load());
		mc = loader.getController();
	}
	
	
	// Method that allows for access to the ClearStatsController
	
	private void clearStatsLoader() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("ClearStats.fxml"));
		clearStats = new Scene(loader.load());
		csc = loader.getController();
	}

	// Method that allows for access to the AchievementsController
	
	private void achievementsLoader() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Achievements.fxml"));
		achievements = new Scene(loader.load());
		achc = loader.getController();
	}
	
	// Method that allows for access to the CustomController

	private void customLoader() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Custom.fxml"));
		custom = new Scene(loader.load());
		cc = loader.getController();
	}

	// Method that allows for access to the AdvancedController

	private void advancedLoader() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Advanced.fxml"));
		advanced = new Scene(loader.load());
		ac = loader.getController();
		advancedSetup();
	}

	// Method that allows for access to the LevelMenuController

	private void levelMenuLoader() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("LevelMenu.fxml"));
		levelMenu = new Scene(loader.load());
		lmc = loader.getController();
		levelMenuSetup();
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

		if (qc.level == Level.HARD) {
			String sessionNum = "Hard Session";
			qc.sessionLabel.setText(sessionNum);
		} else if (qc.level == Level.MEDIUM) {
			String sessionNum = "Medium Session";
			qc.sessionLabel.setText(sessionNum);
		} else if (qc.level == Level.EASY) {
			String sessionNum = "Easy Session";
			qc.sessionLabel.setText(sessionNum);
		} else {
			String sessionNum = "Custom Session";
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
	
	public void levelMenuSetup() {
		lmc.mediumGoButton.setDisable(true);
		lmc.customGoButton.setDisable(true);
		lmc.customSettings.setVisible(false);
		lmc.hardGoButton.setDisable(true);
		
	}

	// When method is called upon, necessary buttons are made invisible, allows for re-usage of FXML
	// scene setup, without having to actually change scene.

	public void advancedSetup() {
		ac.plusDigits.setItems(FXCollections.observableArrayList("1 Digit", "2 Digits"));
		ac.plusDigits.setValue("2 Digits");

		ac.minusDigits.setItems(FXCollections.observableArrayList("1 Digit", "2 Digits"));
		ac.minusDigits.setValue("2 Digits");

		ac.plusVariables.setItems(FXCollections.observableArrayList("2 Variables", "3 Variables"));
		ac.plusVariables.setValue("2 Variables");

		ac.minusVariables.setItems(FXCollections.observableArrayList("2 Variables", "3 Variables"));
		ac.minusVariables.setValue("2 Variables");

		ac.divRange.setItems(FXCollections.observableArrayList("Up to 1", "Up to 2", "Up to 3",
				"Up to 4","Up to 5","Up to 6","Up to 7","Up to 8","Up to 9","Up to 10",
				"Up to 11","Up to 12","Up to 13","Up to 14","Up to 15"));
		ac.divRange.setValue("Up to 12");

		ac.timesRange.setItems(FXCollections.observableArrayList("Up to 1", "Up to 2", "Up to 3",
				"Up to 4","Up to 5","Up to 6","Up to 7","Up to 8","Up to 9","Up to 10",
				"Up to 11","Up to 12","Up to 13","Up to 14","Up to 15"));
		ac.timesRange.setValue("Up to 12");
		
		ac.setCheckBoxes();

	}
}
