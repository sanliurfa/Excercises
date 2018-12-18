package _047e22numbertowords;

public class NumberToWords {

	public static void main(String[] args) {
//		numberToWords(123);
//		numberToWords(234);
//		numberToWords(10);
//		numberToWords(1010);
//		numberToWords(1000);
		numberToWords(2);

		
//		System.out.println(reverse(1010));

		//System.out.println(getDigitCount(-1));
		
	}
	
	public static void numberToWords(int number) {
		

		if (number < 0 ) {
			System.out.println("Invalid Value");
		} else {
		
		int numberCount = getDigitCount(number);
		
		number = reverse(number);
		int reverseCount = getDigitCount(number);

		

		
		
		
		for (int i = number; i > 0; i/=10) {
			
		

		int lastDigit= number%10;
		
		switch (lastDigit) {
		case 0:System.out.println("Zero");
			break;
		case 1:System.out.println("One");
		break;
		case 2:System.out.println("Two");
		break;
		case 3:System.out.println("Three");
		break;
		case 4:System.out.println("Four");
		break;
		case 5:System.out.println("Five");
		break;
		case 6:System.out.println("Six");
		break;
		case 7:System.out.println("Seven");
		break;
		case 8:System.out.println("Eight");
		break;
		case 9:System.out.println("Nine");
		break;
		default:
			break;
		}
		

		
		number /=10;
		}
		
		 if(numberCount != reverseCount){
	            int difference = numberCount - reverseCount;
	            for(int i = 1; i <= difference; i++){
	                System.out.println("Zero");
	            }
		 }
		
//		System.out.println(lastDigit);
//		System.out.println(number);
		}
	}
	
	public static int reverse(int number) {
		StringBuilder sb = new StringBuilder();
		sb.append(number);
		getDigitCount(number);
		sb.reverse();
		return Integer.parseInt(sb.toString());
	}
	
	public static int getDigitCount(int number) {
		if (number < 0) {
			System.out.println("Invalid Value");
			return -1;
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(number);
		int count = sb.length();
		return count;
	}
	

}
