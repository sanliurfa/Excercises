package _044sum3and5;

public class Sum3And5Challenge {

	public static void main(String[] args) {
		int sum = 0;
		int count = 0;
		
		for (int i = 1; i <= 10000; i++) {
			if((i % 3 == 0) && (i % 5 == 0)) {
				System.out.println("numbers is " + i);
				count++;
				sum = sum + i;
				if (count == 5) {
					break;
				}
			}
		}
		System.out.println("The total sum is " + sum);

	}

}
