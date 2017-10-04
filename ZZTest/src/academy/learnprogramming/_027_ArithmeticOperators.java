package academy.learnprogramming;

public class _027_ArithmeticOperators {

	public static void main(String[] args) {
		int f = 12;
		int g = 5;
		int h = 2;
		
		int m = f / 2 - 10 % (4 + 3) - 2 * f % g - h * 3;
			// 12 / 2 - 10 % 7 - 2 * 12 % 3 - 2 * 3
			// 6 - 10 % 7 - 2 * 12 % 3 - 2 * 3 // van links naar rechts * en / gaat voor  + en -
			// 6 - 3 - 24 % 5 - 6
			// 6 - 3 - 4 - 6
			// -7
		
		
		System.out.println("m= " + m);
		
		//Regel modulus,  * en /  gelijke rang hebben en dus van links naar rechts weggewerkt moeten worden en daarna + en -
		
	}

}
