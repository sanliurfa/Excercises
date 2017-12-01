package academy.learnprogramming;

import java.util.ArrayList;
import java.util.List;

public class _087_StaticInitialization {

	private static final int SIZE;

	private static int one;
	private static final int two;
	private static final int three = 3;
	
	private static final List<String> NAMES = new ArrayList<>();
//	private static final int four;					// omdat dit niet nergens geinitialiseerd word kan het niet compileren

	
	static {
		System.out.println("first static init");
		int rows = 5;
		int columns = 4;
		SIZE = rows * columns;						// omdat Size hierboven geinitialiseerd is kan het in een STATIC blok geinitialiseerd worden.
		
	}
	
	static {
		System.out.println("second static block");
		one = 1;
		two = 2;
		one = three;
//		three = 3;									// wanneer een static final field al geinitialiseerd is kan men het niet nogmaals initialiseren
//		two = 2;									// dit geldt ook wanneer het een paar regels hiervoor al geinitiaseerd is. 
		one = 2;
		one = three;								// dit geldt niet voor one omdat one niet finale is.
	}
	
	static {
		System.out.println("thrd static init");
		NAMES.add("Jimmy");
		NAMES.add("Timmy");
	}
	
	
	
	public static void main(String[] args) {		// Wanneer MAIN aangeroepen wordt door de compileren zal het als eerst de static waarde 
		System.out.println(NAMES);					// geinitialiseerd worden.
	}

}
