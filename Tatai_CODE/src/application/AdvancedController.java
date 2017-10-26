package application;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;


public class AdvancedController {

	/**
	 * Create necessary FXML controls, for the Advanced Settings tab of
	 * the Practise Mode.
	 */

	
	@FXML
	ChoiceBox<String> plusVariables;
	@FXML
	ChoiceBox<String> plusDigits;

	@FXML
	ChoiceBox<String> minusDigits;
	@FXML
	ChoiceBox<String> minusVariables;

	@FXML
	protected ChoiceBox<String> timesRange;
	@FXML
	protected ChoiceBox<String> divRange;

	/**
	 * Create and name all 15 checkboxes for the Advanced Multiplication Settings.
	 */

	@FXML 
	private CheckBox cb1x;
	@FXML 
	private CheckBox cb2x;
	@FXML 
	private CheckBox cb3x;
	@FXML 
	private CheckBox cb4x;
	@FXML 
	private CheckBox cb5x;
	@FXML 
	private CheckBox cb6x;
	@FXML 
	private CheckBox cb7x;
	@FXML 
	private CheckBox cb8x;
	@FXML 
	private CheckBox cb9x;
	@FXML 
	private CheckBox cb10x;
	@FXML 
	private CheckBox cb11x;
	@FXML 
	private CheckBox cb12x;
	@FXML 
	private CheckBox cb13x;
	@FXML 
	private CheckBox cb14x;
	@FXML 
	private CheckBox cb15x;

	/**
	 * Create and name all 15 checkboxes for the Advanced Division Settings.
	 */
	
	@FXML 
	private CheckBox cb1div;
	@FXML 
	private CheckBox cb2div;
	@FXML 
	private CheckBox cb3div;
	@FXML 
	private CheckBox cb4div;
	@FXML 
	private CheckBox cb5div;
	@FXML 
	private CheckBox cb6div;
	@FXML 
	private CheckBox cb7div;
	@FXML 
	private CheckBox cb8div;
	@FXML 
	private CheckBox cb9div;
	@FXML 
	private CheckBox cb10div;
	@FXML 
	private CheckBox cb11div;
	@FXML 
	private CheckBox cb12div;
	@FXML 
	private CheckBox cb13div;
	@FXML 
	private CheckBox cb14div;
	@FXML 
	private CheckBox cb15div;


	/**
	 * Used to determine a list of integers to be used in Practise Questions, dependent
	 * on whether or not the input Boolean value 'tables', is true or false. If true, the
	 * function will produce an ArrayList<Integer> for multiplication, and will 
	 * otherwise produce an ArrayList<Integer> for division values, from which to test the user.
	 * 
	 * @param tables
	 * @return
	 */
	public ArrayList<Integer> getTablesMultiples(boolean tables) {

		ArrayList<Integer> ints = new ArrayList<Integer>();

		CheckBox cb;
		if (tables) {
			for (int i = 1; i <= 15; i++) {
				cb = returnCheckBox(i,true);
				if (cb.isSelected()) {
					ints.add(new Integer(i));
				}
			}
		} else {
			for (int i = 1; i <= 15; i++) {
				cb = returnCheckBox(i,false);
				if (cb.isSelected()) {
					ints.add(i);
				}
			}
		}

		return ints;

	}

	
	/**
	 * Takes in a Boolean parameter called 'times', that represents whether the user is
	 * accessing the advanced levels for multiplication, or for division. If it is for
	 * multiplication, then it will fetch the selected 'range' value, from the combo box 
	 * for setting the range. If 'times' is not true, it will fetch the same value, but
	 * will only use it in the context of division questions.
	 * @param times
	 * @return
	 */
	public int getRange(boolean times) {
		if (times) {
			String range = timesRange.getSelectionModel().getSelectedItem();
			switch(range) {
			case "Up to 1":
				return 1;
			case "Up to 2":
				return 2;
			case "Up to 3":
				return 3;
			case "Up to 4":
				return 4;
			case "Up to 5":
				return 5;
			case "Up to 6":
				return 6;
			case "Up to 7":
				return 7;
			case "Up to 8":
				return 8;
			case "Up to 9":
				return 9;
			case "Up to 10":
				return 10;
			case "Up to 11":
				return 11;
			case "Up to 12":
				return 12;
			case "Up to 13":
				return 13;
			case "Up to 14":
				return 14;
			case "Up to 15":
				return 15;
			default :
				return -1;
			}
		} else {
			String range = divRange.getSelectionModel().getSelectedItem();
			switch(range) {
			case "Up to 1":
				return 1;
			case "Up to 2":
				return 2;
			case "Up to 3":
				return 3;
			case "Up to 4":
				return 4;
			case "Up to 5":
				return 5;
			case "Up to 6":
				return 6;
			case "Up to 7":
				return 7;
			case "Up to 8":
				return 8;
			case "Up to 9":
				return 9;
			case "Up to 10":
				return 10;
			case "Up to 11":
				return 11;
			case "Up to 12":
				return 12;
			case "Up to 13":
				return 13;
			case "Up to 14":
				return 14;
			case "Up to 15":
				return 15;
			default :
				return -1;
			}
		}
	}

	/**
	 * Method that simply sets the default settings that are available to the user, upon first
	 * opening the application. Of course all of the check-boxes are available to be checked or not,
	 * up to the discretion of the user: this method simply provides a default platform
	 * of chosen boxes, from which the user can deviate if they so desire.
	 */
	public void setCheckBoxes() {

		cb1x.setSelected(true);

		cb2x.setSelected(true);

		cb3x.setSelected(true);

		cb4x.setSelected(true);

		cb5x.setSelected(true);

		cb6x.setSelected(true);

		cb7x.setSelected(true);

		cb8x.setSelected(true);

		cb9x.setSelected(true);

		cb10x.setSelected(true);

		cb11x.setSelected(false);

		cb12x.setSelected(false);

		cb13x.setSelected(false);

		cb14x.setSelected(false);

		cb15x.setSelected(false);


		cb1div.setSelected(true);

		cb2div.setSelected(true);

		cb3div.setSelected(true);

		cb4div.setSelected(true);

		cb5div.setSelected(true);

		cb6div.setSelected(true);

		cb7div.setSelected(true);

		cb8div.setSelected(true);

		cb9div.setSelected(true);

		cb10div.setSelected(true);

		cb11div.setSelected(false);

		cb12div.setSelected(false);

		cb13div.setSelected(false);

		cb14div.setSelected(false);

		cb15div.setSelected(false);
	}

	/**
	 * This method returns a reference to a check-box, corresponding to the input integer 
	 * and whether it is a multiplication check-box, or a division check-box.
	 * @param num
	 * @param times
	 * @return
	 */
	private CheckBox returnCheckBox(int num, boolean times) {
		if (times) {
			switch (num) {
			case 1:
				return cb1x;
			case 2:
				return cb2x;
			case 3:
				return cb3x;
			case 4:
				return cb4x;
			case 5:
				return cb5x;
			case 6:
				return cb6x;
			case 7:
				return cb7x;
			case 8:
				return cb8x;
			case 9:
				return cb9x;
			case 10:
				return cb10x;
			case 11:
				return cb11x;
			case 12:
				return cb12x;
			case 13:
				return cb13x;
			case 14:
				return cb14x;
			case 15:
				return cb15x;
			default :
				return null;
			}

		} else {
			switch (num) {
			case 1:
				return cb1div;
			case 2:
				return cb2div;
			case 3:
				return cb3div;
			case 4:
				return cb4div;
			case 5:
				return cb5div;
			case 6:
				return cb6div;
			case 7:
				return cb7div;
			case 8:
				return cb8div;
			case 9:
				return cb9div;
			case 10:
				return cb10div;
			case 11:
				return cb11div;
			case 12:
				return cb12div;
			case 13:
				return cb13div;
			case 14:
				return cb14div;
			case 15:
				return cb15div;
			default :
				return null;
			}
		}

	}
}
