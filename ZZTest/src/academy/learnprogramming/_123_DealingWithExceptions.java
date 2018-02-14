package academy.learnprogramming;

public class _123_DealingWithExceptions {

	public static void main(String[] args) {
		int a = 10;
		int b = 0;
													// De curly braces zijn verplicht bij try catch
		try {
			int result = divide(a, b);				// zonder de try catch geeft het een arethmatic exception
			System.out.println("result= "+ result);			
		} catch (ArithmeticException e) {
			//e.printStackTrace();
			System.out.println("Error dividing message "+ e.getMessage());
		}

	}
	
	private static int divide (int a, int b) {
		return a/b;
	}

}
