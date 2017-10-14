package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class EquationGenerator {

	public static String[] randomEquation(Level level) throws IOException {
		int rand = (int)(4*Math.random() + 1);
		ArrayList<Integer> timesTable;

		switch (level) {
		case EASY:
			timesTable = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
			switch(rand) {
			case 1:
				return addSubtract(false, true, true);
			case 2:
				return addSubtract(false, true, false);
			case 3:
				return multiplyDivide(timesTable, 5, true);
			case 4:
				return multiplyDivide(timesTable, 5, false);
			}
		case MEDIUM:
			timesTable = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
			switch(rand) {
			case 1:
				return addSubtract(true, true, true);
			case 2:
				return addSubtract(true, true, false);
			case 3:
				return multiplyDivide(timesTable, 10, true);
			case 4:
				return multiplyDivide(timesTable, 10, false);
			}
		case HARD:
			timesTable = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15));
			switch(rand) {
			case 1:
				return addSubtract(true, false, true);
			case 2:
				return addSubtract(true, false, false);
			case 3:
				return multiplyDivide(timesTable, 15, true);
			case 4:
				return multiplyDivide(timesTable, 15, false);
			}
		case CUSTOM: 
			CustomController cc = StorageAndSetUps.getInstance().cc;
			AdvancedController ac = StorageAndSetUps.getInstance().ac;
			ArrayList<Operation> operations = new ArrayList<Operation>();

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
				twoDigits = ac.plusDigits.getSelectionModel().getSelectedItem().equals("2 Digits");
				twoVariables = ac.plusVariables.getSelectionModel().getSelectedItem().equals("2 Variables");
				return addSubtract(twoDigits,twoVariables,true);
			case SUBTRACT:
				twoDigits = ac.minusDigits.getSelectionModel().getSelectedItem().equals("2 Digits");
				twoVariables = ac.minusVariables.getSelectionModel().getSelectedItem().equals("2 Variables");
				return addSubtract(twoDigits,twoVariables,false);
			case TIMES:
				timesTable = ac.getTablesMultiples(true);
				range = ac.getRange(true);
				if (range == -1 || timesTable.isEmpty()) {
					String random = Integer.toString((int)(99*Math.random() + 1));
					return new String[] {random,random};
				}
				return multiplyDivide(timesTable, range, true);
			case DIVIDE:
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

	private static String[] addSubtract(boolean twoDigits, boolean twoVariables, boolean add) {

		int int1,int2,int3,ans;

		String operator;
		if (add) {
			operator = " + ";
		} else {
			operator = " − ";
		}

		if (twoVariables) {

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

			return new String[] {int1 + operator + int2 + operator + int3, "" + ans};

		}



	}

	private static String[] multiplyDivide(ArrayList<Integer> timesTable, int range, boolean multiply) {

		int size = timesTable.size();

		int index = (int)(size*Math.random());

		int int1 = timesTable.get(index);

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
