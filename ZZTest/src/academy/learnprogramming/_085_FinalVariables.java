package academy.learnprogramming;

import java.util.*;

public class _085_FinalVariables {
	
	private static final int SIZE = 10;
	
	private static final List<String> VALUES = new ArrayList<>();

	public static void main(String[] args) {
		int [] myArray = new int [SIZE];
//		SIZE = 11;							// omdat SIZE final is kan het dus niet gewijzigd worden
//		SIZE++;								// dit kan dus ook niet
		int doubleSize = 2 * SIZE;			// je kan wel gebruik maken van een final waarde 
		
		for (int i = 0; i < SIZE; i++) {
			System.out.println(myArray[i]);
		}
		
		VALUES.add("changed");
//		VALUES = new ArrayList<>();			// Je kan wel de inhoud wijzigen maar niet meer de referentie naar VALUES die is namelijk final.
		
		final int myNumber = 10;
//		myNumber = 11;						// je kan ook een lokale field niet wijzigen welke final is
		

	}

}
