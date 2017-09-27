package application;

public class RandomMaoriNums {

	
	public static String maoriNums(boolean hard) {
		int num;
		
		if (hard) {
			num = (int)(99*(Math.random()) + 1);
		} else {
			num = (int)(9*(Math.random()) + 1);
		}

		return numToMaori(num);
	}

	private static String numToMaori(int num) {
		int tens = num / 10;
		int ones = num % 10;
		
		String middle = middle(tens,ones);
		String tenString = maoriNums(tens);
		String oneString = maoriNums(ones);
		if (tenString.equals("tahi")) {
			tenString = "";
		}
		return tenString + middle + oneString; 
	}
	
	private static String maoriNums(int num) {
		switch (num) {
		case 0 : return "";
		case 1 : return "tahi";
		case 2 : return "rua";
		case 3 : return "toru";
		case 4 : return "wha";
		case 5 : return "rima";
		case 6 : return "ono";
		case 7 : return "whitu";
		case 8 : return "waru";
		case 9 : return "iwa";
		case 10 : return "tekau";
		default : return "ERROR!";
		}
	}
	
	private static String middle(int tens, int ones) {
		if (tens == 0) {
			return "";
		} else if (ones == 0) {
			return " tekau ";
		} else {
			return " tekau ma ";
		}
	}
}
