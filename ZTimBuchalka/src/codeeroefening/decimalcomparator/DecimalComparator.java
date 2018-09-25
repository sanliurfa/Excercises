package codeeroefening.decimalcomparator;

import java.math.*;
import java.text.DecimalFormat;

public class DecimalComparator {

	public static void main(String[] args) {
	System.out.println(areEqualByThreeDecimalPlaces(3.1756  , 3.175));
	}
	
	public static boolean areEqualByThreeDecimalPlaces(double number1, double number2) {
		
//		double floorDouble1 = Math.floor(number1 + 0.5d);
//		double floorDouble2 = Math.floor(number2+ 0.5d);
		
		
		
		DecimalFormat f = new DecimalFormat("##.###");
		double roundDouble1 = round(number1, 3);
		double roundDouble2 = round(number2, 3);
		
		String formatNumber1 = f.format(roundDouble1);
		String formatNumber2 = f.format(roundDouble2);
		if(formatNumber1.equals(formatNumber2) ) {
			return true;
		}

		
		return false;
	
	}
	
	private static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();
	 
	    BigDecimal bd = new BigDecimal(Double.toString(value));
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}

}
