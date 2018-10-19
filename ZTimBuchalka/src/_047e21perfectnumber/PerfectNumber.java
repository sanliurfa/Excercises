package _047e21perfectnumber;

public class PerfectNumber {

	public static void main(String[] args) {
		System.out.println(isPerfectNumber(6));
		System.out.println(isPerfectNumber(28));
		System.out.println(isPerfectNumber(5));
		System.out.println(isPerfectNumber(-1));
	}
	
	public static boolean isPerfectNumber(int number) {
		if(number < 1) {
			return false;
		}
		
		int perfectNumber = 0;
		int sum = 0;
		for (int i = 1; i < number; i++) {
			perfectNumber = number%i;
			if (perfectNumber == 0) {
			sum+=i;
			}
//			System.out.println(perfectNumber);
//			System.out.println(sum);
		}
			
			
			if (number == sum) {
				return true;
			
		}
		return false;
	}

}
