package academy.learnprogramming;

import javax.management.RuntimeErrorException;

public class _122_CheckedVsUnchecked {

	public static void main(String[] args) {
//		myMethod();   									// dit geeft een compilatie error omdat een aanroep doet naar een checked exception, of je moet het 
														// handle-en door throws exception toe te voegen aan de methode.
		anotherMethod(); 								// dit geeft geen compilatie error omdat het een aanroep naar een unchecked exception
														// namelijk een runtime exception
		
	}
	
	public static void myMethod() throws Exception{		// dit is een checked exception en moet behandeld worden anders krijgt het een compilatie error
		throw new Exception("Failed to load");
	}
	
	public static void anotherMethod() {				// dit is een unchecked exception (runtime exception)
		throw new RuntimeException("Wrong parameter");
	}

}
