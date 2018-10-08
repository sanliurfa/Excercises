package _042calculateinterest;

public class CalaculateInterest {

	static int count = 0; 
	
	
	public static void main(String[] args) {
//		
//		for (int i = 2; i < 9; i++) {
//			System.out.println("10.000 at " + i + "% interest = " + String.format("%.2f", calculateInterest(10000, i)));
//		}
//		
//		
//		System.out.println("*********************");
//		
//		for (int i = 8; i >1 ; i--) {
//			System.out.println("10.000 at " + i + "% interest = " + String.format("%.2f", calculateInterest(10000, i)));	
//		}	
//		
		
			for (int i = 10; i < 50; i++) {
				if (isPrime(i)) {
					System.out.println( i + " is a prime number");
					count++;
					if (count == 3) {
						System.out.println("exiting for loop");
						break;
					}
				}
				
			}
		
		
		
	}
	
	public static boolean isPrime(int n) {
		if (n == 1) {
			return false;
		}
		for (int i = 2; i <= n/2 ; i++) {
			if (n%i == 0) {
				return false;
			}
			
		}
		return true;
	}
	

	public static double calculateInterest(double amount, double interestRate) {
		return (amount * (interestRate / 100));
	}

}
