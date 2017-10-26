package application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
/**
 * 
 * @author cyrus
 *
 */
public class AchievementsController {
	
	
	/**
	 * Create all necessary ImageView/Button controls, for the Achievements scene.
	 */
	
	@FXML
	private Button returnButton;

	@FXML
	public ImageView arrowIcon;
	
	@FXML
	public ImageView streakIcon;
	
	@FXML
	public ImageView scrollIcon;
	
	@FXML
	public ImageView scholarIcon;
	
	@FXML
	public ImageView starIcon;
	
	@FXML
	public ImageView wreathIcon;
	
	@FXML 
	public Label arrowText;
	
	@FXML 
	public Label streakText;
	
	@FXML 
	public Label scrollText;

	@FXML 
	public Label scholarText;

	@FXML 
	public Label starText;

	@FXML 
	public Label wreathText;


	/**
	 * FXML method that returns the user to the menu, from the Achievements Scene.
	 * @param event
	 * @throws IOException
	 */
	
	@FXML
	public void returnPress(ActionEvent event) throws IOException {
		Scene menu = StorageAndSetUps.getInstance().menu;
		Stage window = (Stage) returnButton.getScene().getWindow();
		window.setScene(menu);
		
	}
	
	/**
	 *  Create public variable, that specifies for the opacity function, which icon to change the opacity of.
	 */
	public static String icon;

	/**
	 * Method that determines what image is being hovered over, and then shifts the opacity of that image
	 * accordingly, onMouseEntered.
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void opacityChangeUp(MouseEvent event) throws IOException{
		
		String image = (String) event.getPickResult().getIntersectedNode().getId();
		
		icon = (String) image;
		
		
		if (image.equals("arrowIcon")) {
			StorageAndSetUps.getInstance().achc.arrowIcon.setOpacity(1.0);
		} else if (image.equals("streakIcon")) {
			StorageAndSetUps.getInstance().achc.streakIcon.setOpacity(1.0);
		} else if (image.equals("scrollIcon")) {
			StorageAndSetUps.getInstance().achc.scrollIcon.setOpacity(1.0);
		} else if (image.equals("scholarIcon")) {
			StorageAndSetUps.getInstance().achc.scholarIcon.setOpacity(1.0);
		} else if (image.equals("starIcon")) {
			StorageAndSetUps.getInstance().achc.starIcon.setOpacity(1.0);
		} else if (image.equals("wreathIcon")) {
			StorageAndSetUps.getInstance().achc.wreathIcon.setOpacity(1.0);
		} else {
			
		}
		
		
	}

	/**
	 * Method that determines what image is being hovered over, and then shifts the opacity of that image
	 * accordingly, onMouseExited.
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void opacityChangeDown(MouseEvent event) throws IOException{
		
		String image = (String) AchievementsController.icon;
		
		if (image.equals("arrowIcon")) {
			StorageAndSetUps.getInstance().achc.arrowIcon.setOpacity(0.3);
		} else if (image.equals("streakIcon")) {
			StorageAndSetUps.getInstance().achc.streakIcon.setOpacity(0.3);
		} else if (image.equals("scrollIcon")) {
			StorageAndSetUps.getInstance().achc.scrollIcon.setOpacity(0.3);
		} else if (image.equals("scholarIcon")) {
			StorageAndSetUps.getInstance().achc.scholarIcon.setOpacity(0.3);
		} else if (image.equals("starIcon")) {
			StorageAndSetUps.getInstance().achc.starIcon.setOpacity(0.3);
		} else if (image.equals("wreathIcon")) {
			StorageAndSetUps.getInstance().achc.wreathIcon.setOpacity(0.3);
		} else {
			
		}
		
		}
	
}
