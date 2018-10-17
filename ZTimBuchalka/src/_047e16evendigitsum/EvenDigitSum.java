package _047e16evendigitsum;

public class EvenDigitSum {

	public static void main(String[] args) {
		System.out.println(getEvenDigitSum(123456789));

	}
	
	public static int getEvenDigitSum(int number) {
		if (number < 0) {
			return -1;
		}
		
		int [] numberArray = new int[10];
		int lastDigit = number % 10;
		int firstDigit = 0 ;
		int sum = 0;
		
		numberArray[0]= lastDigit;
		
		for (int i = 0, j = 0; i < number; i/=10, j++) {
			
			firstDigit = number % 10;
			numberArray[j]= firstDigit;
			number /= 10;
			System.out.println(numberArray[j]);
			
			if (numberArray[j]%2==0) {
				sum+=numberArray[j];
			}
			

		}
		return sum;
		
		
		
		
//		 int lastDigit = number % 10; // hiermee krijg je de laatste int getal
//		    int firstDigit = 0 ;
//		 
//		    for (int i = 0; i < number; i/=10){  // i blijft 0 
//		        firstDigit = number % 10;		// dit is de laatste digit
//		        number /= 10;					// je deelt number met 10 zolang totdat er een enkel cijfer overblijft nameelijk de laatste
//		        								// bij de controle is i=0 en number niet meer deelbaar door 10 dus number = 0
//		        								// waardoor i niet meer klener is dan number en de laatste waarde van number dus laatste 
//		        								// digit blijft.
//		    }
		
		
		
	
	}

}
