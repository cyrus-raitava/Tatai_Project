package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class EquationGenerator {
	
	
	/**
	 * Method that produces a random equation in the form of a string, given
	 * an input enum of type Level.
	 * 
	 * @param level
	 * @return
	 * @throws IOException
	 */
	public static String[] randomEquation(Level level) throws IOException {
		
		// Initialise a random variable to help generate random questions for
		// each level, as well as an ArrayList<String> to help further specify
		// which numbers to be tested on, in either Easy, Medium, or Hard.
		int rand = (int)(4*Math.random() + 1);
		ArrayList<Integer> timesTable;

		switch (level) {
		case EASY:
			
			timesTable = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
			switch(rand) {
			
			// addSubtract() is a function that takes 3 boolean parameters: the first
			// determining whether or not the digits dealt with by the user have 2 digits
			// or 1, the second determining whether the addition/subtraction question 
			// will contain 2 or 3 variables, and the last parameter specifying whether
			// the question is an addition or subtraction equation.
			case 1:
				return addSubtract(false, true, true);
			case 2:
				return addSubtract(false, true, false);
				
			// In Easy mode, the user may be tested on Multiplication/Division questions
			// that deal with results up to, or less than, 25.
			case 3:
				return multiplyDivide(timesTable, 5, true);
			case 4:
				return multiplyDivide(timesTable, 5, false);
			}
		case MEDIUM:

			timesTable = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
			switch(rand) {
			
			// Sets constraints on Medium level of Addition/Subtraction questions: they must all
			// have 2 digits, and 2 variables (as opposed to the singular digit questions in Easy).
			case 1:
				return addSubtract(true, true, true);
			case 2:
				return addSubtract(true, true, false);
				
			// Similar setup to the parameters specified in the Easy Level, save for that the 
			// range of possible questions regarding multiplication and division have greater
			// ranges.
			case 3:
				return multiplyDivide(timesTable, 10, true);
			case 4:
				return multiplyDivide(timesTable, 10, false);
			}
		case HARD:
			timesTable = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15));
			switch(rand) {
			
			// Sets constraints on Hard Level: all Addition/Subtraction questions have 3 two digit variables, as
			// opposed to the two-digit, two variable questions in Medium.
			
			case 1:
				return addSubtract(true, false, true);
			case 2:
				return addSubtract(true, false, false);
				
			// Similarly the multiplication/division questions cover a greater range of results: all the way up
			// to the answer being 99.
			case 3:
				return multiplyDivide(timesTable, 15, true);
			case 4:
				return multiplyDivide(timesTable, 15, false);
			}
		case CUSTOM: 
			
			// The underlying logic for the Practice Mode: here, the Check-boxes regarding whether the user wants
			// Addition, Subtraction, Multiplication or Division questions is checked here.
			
			// Get the controllers so that we can access the checkboxes for practice mode
			CustomController cc = StorageAndSetUps.getInstance().cc;
			AdvancedController ac = StorageAndSetUps.getInstance().ac;
			ArrayList<Operation> operations = new ArrayList<Operation>();

			// determine what operations are to be used
			if (cc.checkBoxPlus.isSelected()) {
				operations.add(Operation.ADD);
			}
			if (cc.checkBoxMinus.isSelected()) {
				operations.add(Operation.SUBTRACT);
			}
			if (cc.checkBoxTimes.isSelected()) {
				operations.add(Operation.TIMES);
			}
			if (cc.checkBoxDiv.isSelected()) {
				operations.add(Operation.DIVIDE);
			}

			// Determines the default case, if none of the Check Boxes are checked: in the Practice Mode, the
			// application will simply produce numbers which the user can try to say and record: no equations.
			
			int length = operations.size();
			
			if (length == 0) {
				String random = Integer.toString((int)(99*Math.random() + 1));
				return new String[] {random,random};
			}

			int randOp = (int)(length*Math.random());

			Operation op = operations.get(randOp);

			
			boolean twoDigits,twoVariables;
			int range;
			switch(op) {
			case ADD:
				
				// Creates two Boolean Variables to check what the user has specified, in regards to the 
				// advanced selection options for the Addition option.
				
				twoDigits = ac.plusDigits.getSelectionModel().getSelectedItem().equals("2 Digits");
				twoVariables = ac.plusVariables.getSelectionModel().getSelectedItem().equals("2 Variables");
				return addSubtract(twoDigits,twoVariables,true);
			case SUBTRACT:
				
				// Creates two Boolean Variables to check what the user has specified, in regards to the 
				// advanced selection options for the Subtraction option.
				
				twoDigits = ac.minusDigits.getSelectionModel().getSelectedItem().equals("2 Digits");
				twoVariables = ac.minusVariables.getSelectionModel().getSelectedItem().equals("2 Variables");
				return addSubtract(twoDigits,twoVariables,false);
			case TIMES:
				
				// Calls on the multiplyDivide() function, to generate numbers for the multiplication equations.
	
				timesTable = ac.getTablesMultiples(true);
				range = ac.getRange(true);
				if (range == -1 || timesTable.isEmpty()) {
					String random = Integer.toString((int)(99*Math.random() + 1));
					return new String[] {random,random};
				}
				return multiplyDivide(timesTable, range, true);
			case DIVIDE:
				
				// Calls on the multiplyDivide() function, to generate numbers for the division equations.
				
				timesTable = ac.getTablesMultiples(false);
				range = ac.getRange(false);
				if (range == -1 || timesTable.isEmpty()) {
					String random = Integer.toString((int)(99*Math.random() + 1));
					return new String[] {random,random};
				}
				return multiplyDivide(timesTable, range, false);
			}






		default: 
			return new String[] {"DEFAULT BANANAS", "0"};
		}
	}

	
	/**
	 * 
	 * The addSubtract function takes 3 boolean parameters, which- as stated before- help
	 * determine the difficulty of an addition/subtraction equation, based on certain attributes.
	 * These attributes are: 
	 * -whether or not the variables have one digit or two
	 * -whether or not the equation has two variables, or 3
	 * -whether the equation is for addition, or subtraction
	 * 
	 * @param twoDigits
	 * @param twoVariables
	 * @param add
	 * @return
	 */
	private static String[] addSubtract(boolean twoDigits, boolean twoVariables, boolean add) {

		// Declare the integers to be potentially used
		int int1,int2,int3,ans;

		// Define the operator, based on the value of the Boolean add variable.
		String operator;
		if (add) {
			operator = " + ";
		} else {
			operator = " − ";
		}

		// Provide logic behind creating two variable equation
		if (twoVariables) {

			// Provide logic behind creating two digits variable equation
			if (twoDigits) {
				if (add) {
					int1 = (int)(98*Math.random() + 1);
					int2 = (int)((99 - int1)*Math.random() + 1);
					ans = int1 + int2;
				} else {
					int1 = (int)(98*Math.random() + 2);
					int2 = (int)((int1 - 1)*Math.random() + 1);
					ans = int1 - int2;
				}
			// Provide logic behind creating single digits variable equation
			} else {
				if (add) {
					int1 = (int)(9*Math.random() + 1);
					int2 = (int)(9*Math.random() + 1);
					ans = int1 + int2;
				} else {
					int1 = (int)(8*Math.random() + 2);
					int2 = (int)((int1 - 1)*Math.random() + 1);
					ans = int1 - int2;
				}
			}

			return new String[] {int1 + operator + int2, "" + ans};

		} else {
			// Provide logic behind creating two digits variable equation
			if (twoDigits) {
				if (add) {
					int1 = (int)(97*Math.random() + 1);
					int2 = (int)((98 - int1)*Math.random() + 1);
					int3 = (int)((99 - (int1 + int2))*Math.random() + 1);
					ans = int1 + int2 + int3;
				} else {
					int1 = (int)(97*Math.random() + 3);
					int2 = (int)((int1 - 2)*Math.random() + 1);
					int3 = (int)((int1 - int2 - 1)*Math.random() + 1);
					ans = int1 - int2 - int3;
				}
			} else {
				
				// Provide logic behind creating single digits variable equation
				if (add ) {
					int1 = (int)(9*Math.random() + 1);
					int2 = (int)(9*Math.random() + 1);
					int3 = (int)(9*Math.random() + 1);
					ans = int1 + int2 + int3;
				} else {
					int1 = (int)(7*Math.random() + 3);
					int2 = (int)((int1 - 2)*Math.random() + 1);
					int3 = (int)((int1 - int2 -1)*Math.random() + 1);
					ans = int1 - int2 - int3;
				}
			}
			
			// Concatenate strings together, to form string variable to return, that is the equation
			
			return new String[] {int1 + operator + int2 + operator + int3, "" + ans};
			
		}



	}

	/**
	 * The multiplyDivide() function takes in an ArrayList<Integer>, the range, and whether or not
	 * the equation is to be a division or multiplication equation. 
	 * 
	 * @param timesTable
	 * @param range
	 * @param multiply
	 * @return
	 */
	private static String[] multiplyDivide(ArrayList<Integer> timesTable, int range, boolean multiply) {

		// Checks the size of the input ArrayList<Integer>, representing the number of 
		// chosen check boxes for multiplication/division
		int size = timesTable.size();

		int index = (int)(size*Math.random());

		// randomly select a timestable to use.
		int int1 = timesTable.get(index);
		
		// ensure that the range is adjusted so that the product is never above 100
		if (int1 > 6) {
			switch (int1) {
			case 7:
				if (range > 14) {
					range = 14;
				}
			case 8:
				if (range > 12) {
					range = 12;
				}
			case 9:
				if (range > 11) {
					range = 11;
				}
			case 10:
				if (range > 9) {
					range = 9;
				}
			case 11:
				if (range > 9) {
					range = 9;
				}
			case 12:
				if (range > 8) {
					range = 8;
				}
			case 13:
				if (range > 7) {
					range = 7;
				}
			case 14:
				if (range > 7) {
					range = 7;
				}
			case 15:
				if (range > 6) {
					range = 6;
				}
			}
		}

		int int2 = (int)(range*Math.random() + 1);

		if (multiply) {
			return new String [] {int1 + " × " + int2, "" + int1*int2};
		} else {
			return new String[] {int1*int2 + " ÷ " + int1, "" + int2};

		}

	}

}
