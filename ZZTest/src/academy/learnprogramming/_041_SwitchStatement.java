package academy.learnprogramming;

import java.util.Random;

public class _041_SwitchStatement {

	public static void main(String[] args) {
		// switch is net als een if/else statement
		
	// switch statement worden gesupport door primitives en wrappers en enum en String
		// niet gesupport door boolean
		
		int dayOfWeek = 0;
		
		switch (dayOfWeek) {
		case 0:
			System.out.println("Monday");
			break;
		case 1:
			System.out.println("Tuesday");
			break;
		case 2:
			System.out.println("Wednesday");
			break;
		case 3:
			System.out.println("Thursday");
			break;
		case 4:
			System.out.println("Friday");
			break;
		default:
			System.out.println("Weekend");
			break;
		}
		
		Random rand = new  Random();
		int c = rand.nextInt(26) + 'a'; // adding offset to produce lower case letters
		System.out.println((char) c + ", " + c + ": "); // wanneer je de char niet cast dan wordt de char automatisch tot een int omgezet
												// wil je toch een char tonen dan moet je het casten
		
		switch (c) {
		case 'a':
		case 'e':
		case 'i':
		case 'o':
		case 'u':
			System.out.println("vowel");
			break;
		case 'y':
		case 'w':
			System.out.println("sometimes a vowel");

		default:
			System.out.println("consonant");
			break;
		}
		
		//switches welke niet compileren
		int x = 4;
		switch (x) {
		case 4:       		//dit werkt omdat het een int is
		//case x: 			// dit werkt niet omdat een case niet een variabele mag zijn
		case 'K':			// dit compileert omdat char automatisch omgezet word naar een int
		//case "String":    // dit compileert niet omdat een int gevraagd word.
			
			break;

		default:
			break;
		}
		

	}

}
