package academy.learnprogramming;

import java.util.Arrays;

public class _062_SortingArrays {

	public static void main(String[] args) {
		int[] numbers = {5, 10, 2};
		
		// de sortering gebeurd door een methode in de Arrays class
		
		Arrays.sort(numbers);
		
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ");    			// numbers[i] schrijft de INHOUD van de betreffende array
		}
		
		System.out.println();
		
		System.out.println(numbers);  						// dit geeft de hash-code
		
		System.out.println(Arrays.toString(numbers)); 		// geeft de INHOUD weer.
		
		//Met string is het netzo maar nu op alfafbetische volgorde
		
		String[] strings = {"50", "9", "500"};
		
		Arrays.sort(strings);
		
		System.out.println(Arrays.toString(strings));  		// Omdat de 9 na de 5 komt wordt de volgorde 50, 500, 9	

	}

}
