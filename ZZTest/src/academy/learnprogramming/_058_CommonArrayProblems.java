package academy.learnprogramming;

public class _058_CommonArrayProblems {

	public static void main(String[] args) {
		int[] numbers = {1, 2, 3, 4, 5}; 					// Let op de index begint met 0!!!
		
		//index problemen
		
		for (int i = 0; i < numbers.length; i++) {
			System.out.println(i + " =  " + numbers[i]);
		}
		
		for (int i = 0; i <= numbers.length; i++) {			// de laatste lengte is langer dan het aantal index bij <=  hierdoor
															// word er een foutmelding weergegeven!!
															// Dus wanneer je <= en length samen ziet dan moet er een length - 1 van maken
			System.out.println(i + " =  " + numbers[i]);
		}
		
		// size problems 
		
// 		int[20] nums; is fout
		
		int[] nums = new int[20]; // size bepaling alleen door inialisatie
		
		
//		int size = numbers.length(); 						// Dit zal niet compileren want length is GEEN methode.
		int size = numbers.length;
		
		// je kan nooit length niet wijzigen, alleen bij een inilalisatie
		
	}

}
