package academy.learnprogramming;

public class _089_ReturningDataFromMethods {
	
	// EXAMENVRAAG
	

	public static void main(String[] args) {
		int number = 2;
		String word = "xyz";
		
//		number(number);									// number word niet reassigned en behoud dus zijn eigen waarde
		number = number(number); 						// hier word number reassigned met de resultaat van de methode (number)
		word(word);										// word word niet reassigned en behoud dus zijn eigen waarde
//		word = word(word);								// hier word word reassigned met de resultaat van de methode (word)
		
		System.out.println("Number is " + number);
		System.out.println("Word is " + word);
		System.out.println("Number + Word is " + number + word);

	}

	private static int number(int number) {				// er word een kopie gemaakt van number
		number++;										// kopie word opgehoogt
		return number;									// resultaat word geretourneerd
	}
	
	private static String word (String word) {			// er word een kopie gemaakt van word
		return word += "a";								// resultaat van word + a word geretourneerd
	}

}
