package application;

import java.util.ArrayList;

public class RandomMaoriNums {

	private static RandomMaoriNums rmn;
	
	protected ArrayList<String> currentNum = new ArrayList<String>();
	protected int currentInt;
	
	private RandomMaoriNums() {
	}
	
	public static RandomMaoriNums getInstance() {
		if (rmn == null) {
			rmn = new RandomMaoriNums();
		}
		return rmn;
	}
	
	public String maoriNums(boolean hard) {
		int num;
		
		if (hard) {
			num = (int)(99*(Math.random()) + 1);
		} else {
			num = (int)(9*(Math.random()) + 1);
		}
		
		currentInt = num;
		numToMaori(num);
		return Integer.toString(currentInt);
	}

	private void numToMaori(int num) {
		currentNum = new ArrayList<String>();
		
		int tens = num / 10;
		int ones = num % 10;
		
		String tenString = maoriNums(tens);
		if (tens > 1) {
			currentNum.add(tenString);
		}
		
		middle(tens,ones);
		
		currentNum.add(maoriNums(ones));
		
	}
	
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
