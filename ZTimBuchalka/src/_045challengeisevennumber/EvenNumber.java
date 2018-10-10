package _045challengeisevennumber;

public class EvenNumber {

	public static void main(String[] args) {
		int number = 4;
		int finishNumber = 20;
		int count = 0;
		int sumEvenNumbers = 0; 
		
		while (number <= finishNumber) {
			number++;
			if(!isEvenNumber(number)) {
				continue;
			}
			sumEvenNumbers += number;
			count++;
			
			System.out.println("Even number "  + number);
			
			
			if (count == 5 ) {
				break;
			}
		}
		System.out.println("Sum number= " + sumEvenNumbers);
		System.out.println("Total of even numbers is " + count);

	}
	
	public static boolean isEvenNumber(int number) {
		if ((number%2) == 0) {
			return true;
		}
		return false;
	}
	

}
