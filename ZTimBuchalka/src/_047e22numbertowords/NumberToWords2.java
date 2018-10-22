package _047e22numbertowords;

public class NumberToWords2 {

	public static void main(String[] args) {
		numberToWords(2);

	}
	
	

	    public static void numberToWords(int number){
	        if(number < 0) System.out.println("Invalid Value");
	        int reversedNumber = reverse(number);
	        int numberCount = getDigitCount(number);
	        int reverseCount = getDigitCount(reversedNumber);
	 
	        while (reversedNumber != 0) {
	            int lastDigit = reversedNumber%10;
	            switch (lastDigit) {
	                case 0:
	                    System.out.println("Zero");
	                    break;
	                case 1:
	                    System.out.println("One");
	                    break;
	                case 2:
	                    System.out.println("Two");
	                    break;
	                case 3:
	                    System.out.println("Three");
	                    break;
	                case 4:
	                    System.out.println("Four");
	                    break;
	                case 5:
	                    System.out.println("Five");
	                    break;
	                case 6:
	                    System.out.println("Six");
	                    break;
	                case 7:
	                    System.out.println("Seven");
	                    break;
	                case 8:
	                    System.out.println("Eight");
	                    break;
	                case 9:
	                    System.out.println("Nine");
	                    break;
	                default:
	                    break;
	            }
	            reversedNumber /= 10;
	        }
	        if(numberCount != reverseCount){
	            int difference = numberCount - reverseCount;
	            for(int i = 1; i <= difference; i++){
	                System.out.println("Zero");
	            }
	        }
	    }
	 
	    public static int reverse(int number){
	        int reversedNumber = 0;
	        while (number != 0) {
	            reversedNumber *= 10;
	            reversedNumber += number%10;
	            number /= 10;
	        }
	        return reversedNumber;
	    }
	 
	    public static int getDigitCount(int number){
	        if(number < 0) return -1;
	        if(number == 0) return 1;
	        int count = 0;
	        while (number != 0) {
	            count++;
	            number /= 10;
	        }
	        return count;
	    }
	}


