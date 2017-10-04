package academy.learnprogramming;

public class TrickyExamQuestionsIfLoops {

	public static void main(String[] args) {
		// Wat is de uitkomst van de onderstaande
		// A. Success
		// B. Failure
		// c. De code compileerd niet vanwege lijn 13
		// D. De code compileerd niet vanwege lijn 14
		
		int x1 = 50 , x2 = 75;
		boolean b = x1 >= x2;
		if (b = true) System.out.println("Success");
		else System.out.println("Failure");
			
		

	}

}

// De juiste antwoord is A. Success want in regel 14 krijgt b de waarde true, het is gen vergelijking!!