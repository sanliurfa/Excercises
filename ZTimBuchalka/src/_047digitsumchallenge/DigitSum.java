package _047digitsumchallenge;

import java.util.ArrayList;

public class DigitSum {

	public static void main(String[] args) {
		System.out.println("The sum of the digits in number 125 is " + sumDigits(125));

	}
	
	public static int sumDigits(int number) {
		if (number < 10) {
			return -1;
		}
		
		
		int sum = 0;
	// 125 -> 125 / 10 = 12 --> 12 * 10 -> 125 -120 = 5
		// 125 % 10 = 12,5 int kent geen 0,5 dus dit word dan 12!!
		
		
		
		while ( number > 0) {
		//	extract de laagste eenheid getal 
			int digit = number % 10;
			sum += digit;
			
			// haal de laagste getal weg
			number /= 10; // hetzelfde als number = number /10;
			
			
		}
		
		return sum;
		
		
		
		
	}

}
