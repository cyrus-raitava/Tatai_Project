package application;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;

public class AdvancedController {


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

		cb11x.setSelected(true);

		cb12x.setSelected(true);

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

		cb11div.setSelected(true);

		cb12div.setSelected(true);

		cb13div.setSelected(false);

		cb14div.setSelected(false);

		cb15div.setSelected(false);
	}

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
