package application;

import java.util.ArrayList;

public class RandomMaoriNums {

	private static RandomMaoriNums rmn;
	
	protected ArrayList<String> currentNum = new ArrayList<String>();
	protected int currentInt;
	
	private RandomMaoriNums() {
	}
	
	/**
	 * Singleton pattern.
	 */
	public static RandomMaoriNums getInstance() {
		if (rmn == null) {
			rmn = new RandomMaoriNums();
		}
		return rmn;
	}
	
	/**
	 * Sets a random number from 1-9 or 1-99 depending on whether hard is true.
	 * @param hard
	 * @return a string representing the number.
	 */
	public String maoriNums(boolean hard) {
		int num;
		
		if (hard) { // set random number to 1-99 if on hard level
			num = (int)(99*(Math.random()) + 1);
		} else { // set random number to 1-9 if on easy level
			num = (int)(9*(Math.random()) + 1);
		}
		
		// save the current number that is displayed on quiz
		currentInt = num;
		
		numToMaori(num); // set ArrayList to current number
		
		// return string of the current number
		return Integer.toString(currentInt);
	}

	
	/**
	 * Given an integer input, works out the maori string equivalent and
	 * saves to arrayList.
	 * @param num
	 */
	private void numToMaori(int num) {
		currentNum = new ArrayList<String>(); // set new arrayList
		
		int tens = num / 10; // calculate tens digit
		int ones = num % 10; // calculate ones digit
		
		// set tenstring if above 1
		String tenString = maoriNums(tens);
		if (tens > 1) {
			currentNum.add(tenString);
		}
		
		// work out middle string
		middle(tens,ones);
		
		// add ones string
		currentNum.add(maoriNums(ones));
		
	}
	
	/**
	 * Returns the maori string for numbers 1 to 10
	 * @param num integer from 1 to 10
	 * @return maori string
	 */
	private String maoriNums(int num) {
		switch (num) {
		case 0 : return "";
		case 1 : return "tahi";
		case 2 : return "rua";
		case 3 : return "toru";
		case 4 : return "whā";
		case 5 : return "rima";
		case 6 : return "ono";
		case 7 : return "whitu";
		case 8 : return "waru";
		case 9 : return "iwa";
		case 10 : return "tekau";
		default : return "ERROR!";
		}
	}
	
	/**
	 * adds the middle string for a maori number given two digits
	 * @param tens
	 * @param ones
	 */
	private void middle(int tens, int ones) {
		if (tens == 0) {
		} else if (ones == 0) {
			currentNum.add("tekau");
		} else {
			currentNum.add("tekau");
			currentNum.add("mā");
		}
	}
}
