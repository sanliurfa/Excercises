package _047e15firstandlastsum;

public class FirstAndLastDigitSum {

	public static void main(String[] args) {
		System.out.println(sumFirstAndLastDigit(323456));
		System.out.println(sumFirstAndLastDigit(-222));

	}

	public static int sumFirstAndLastDigit(int number){
		 
	    if(number < 0){
	        return -1;
	    }
	 
	    int lastDigit = number % 10; // hiermee krijg je de laatste int getal
	    int firstDigit = 0 ;
	 
	    for (int i = 0; i < number; i/=10){  // i blijft 0 
	        firstDigit = number % 10;		// dit is de laatste digit
	        number /= 10;					// je deelt number met 10 zolang totdat er een enkel cijfer overblijft nameelijk de laatste
	        								// bij de controle is i=0 en number niet meer deelbaar door 10 dus number = 0
	        								// waardoor i niet meer klener is dan number en de laatste waarde van number dus laatste 
	        								// digit blijft.
	    }
	 
	    return lastDigit +firstDigit;
	 
	}

}
