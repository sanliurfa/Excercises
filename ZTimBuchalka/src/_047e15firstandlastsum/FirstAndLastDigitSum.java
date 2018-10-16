package _047e15firstandlastsum;

public class FirstAndLastDigitSum {

	public static void main(String[] args) {
		System.out.println(sumFirstAndLastDigit(123456));

	}
	
	
	public static int sumFirstAndLastDigit(int number) {
		int first, last;
		
		last = number % 10;
		
		String stringNumber = Integer.toString(number);
		
				
		
		
		for (int i = 0; i < stringNumber.length(); i++) {
			
		}
		
		return last;
		
	}

}
