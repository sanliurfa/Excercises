package _047e20allfactors;

public class AllFactors {

	public static void main(String[] args) {
		printFactors(32);

	}
	
	
	public static void printFactors(int number) {
		if (number < 1) {
			System.out.println("Invalid Value");
		}
		
		int factor = 0;
		
		for (int i = 1; i <= number; i++) {
			factor = number % i ;
			if(factor == 0) {
				System.out.print(i + " ");
				//return Integer.toString(i);
			}

			//System.out.println("i is " + i + " factor is "+ factor);
		}

		
	}
	
	

}
